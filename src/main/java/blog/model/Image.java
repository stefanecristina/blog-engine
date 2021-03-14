package blog.model;

public class Image {

  public Image() { }

  public Image(String url, String alt) {
    this.url = url;
    this.alt = alt;
  }

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

}
