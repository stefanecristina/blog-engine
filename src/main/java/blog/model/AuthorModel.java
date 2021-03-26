package blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AuthorModel {

  @Column(unique = true, nullable = false, length = 50)
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(nullable = false)
  private String profileUrl;

  public String getProfileUrl() {
    return profileUrl;
  }

  public void setProfileUrl(String profileUrl) {
    this.profileUrl = profileUrl;
  }

  @Lob
  private Byte[] profileImage;

  public Byte[] getProfileImage() {
    return profileImage;
  }

  public void setProfileImage(Byte[] profileImage) {
    this.profileImage = profileImage;
  }

  @JsonIgnore
  @OneToMany
  @OrderColumn
  private PostModel[] posts;

  public PostModel[] getPosts() {
    return posts;
  }

  public void setPosts(PostModel[] posts) {
    this.posts = posts;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long idAuthor;

  public Long getIdAuthor() {
    return idAuthor;
  }

  public void setIdAuthor(Long idAuthor) {
    this.idAuthor = idAuthor;
  }

}
