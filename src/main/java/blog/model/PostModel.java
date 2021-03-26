package blog.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PostModel {

  @Column(unique = true, nullable = false, length = 100)
  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Column(unique = true, nullable = false, length = 250)
  private String intro;

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  @ManyToOne
  private AuthorModel author;

  public AuthorModel getAuthor() {
    return author;
  }

  public void setAuthor(AuthorModel author) {
    this.author = author;
  }

  @Column(insertable = true, updatable = false)
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime dateTime;

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  @Lob
  @Column(nullable = false)
  private String content;

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long idPost;

  public Long getIdPost() {
    return idPost;
  }

  public void setIdPost(Long idPost) {
    this.idPost = idPost;
  }

}
