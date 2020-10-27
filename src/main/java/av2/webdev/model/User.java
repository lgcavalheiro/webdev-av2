package av2.webdev.model;

public class User {
  private int id;
  private String password;

  public User(int id, String password) {
    this.id = id;
    this.password = password;
  }

  public int getId() {
    return this.id;
  }

  public String getPassword() {
    return this.password;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
