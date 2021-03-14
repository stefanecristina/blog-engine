package blog.model;

public class Author {

  public Author() {

  }

  public Author(String name, String profileUrl) {
    this.name = name;
    this.profileUrl = profileUrl;
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private String profileUrl;

  public String getProfileUrl() {
    return profileUrl;
  }

  public void setProfileUrl(String profileUrl) {
    this.profileUrl = profileUrl;
  }

}
