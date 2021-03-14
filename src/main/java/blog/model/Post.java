package blog.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long idPost;

  public Long getIdPost() {
    return idPost;
  }

  public void setIdPost(Long idPost) {
    this.idPost = idPost;
  }

  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  private String intro;

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  @OneToOne
  private Image img;

  public Image getImg() {
    return img;
  }

  public void setImg(Image img) {
    this.img = img;
  }

  @ManyToOne
  private Author author;

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime dateTime;

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

}
