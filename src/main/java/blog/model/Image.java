package blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Image {

  private String url;

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }

  private String alt;

  public String getAlt() {
    return alt;
  }

  public void setAlt(String alt) {
    this.alt = alt;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long idImage;

  public Long getIdImage() {
    return idImage;
  }

  public void setIdImage(Long idImage) {
    this.idImage = idImage;
  }

}
