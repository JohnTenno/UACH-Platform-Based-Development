package t2.controllers.models;

import java.util.List;

public class User {

  private String name;
  private String email;
  private String profilePictureUrl = "https://avatars.githubusercontent.com/u/131226056?v=4";
  private String github;
  private List<String> tools;

  public User() {

  }

  public User(String name, String email, String github, List<String> tools) {
    setName(name);
    setEmail(email);
    setGithub(github);
    setTools(tools);
  }

  public void setGithub(String github) {
    this.github = github;
  }

  public void setTools(List<String> tools) {
    this.tools = tools;
  }

  public List<String> getTools() {
    return tools;
  }

  public String getGithub() {
    return github;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getProfilePictureUrl() {
    return profilePictureUrl;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setProfilePictureUrl(String profilePictureUrl) {
    this.profilePictureUrl = profilePictureUrl;
  }
}
