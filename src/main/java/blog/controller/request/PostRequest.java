package blog.controller.request;

public class PostRequest {

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

  private Long idAuthor;

  public Long getIdAuthor() {
    return idAuthor;
  }

  public void setIdAuthor(Long idAuthor) {
    this.idAuthor = idAuthor;
  }

  private String content;

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
