package av2.webdev.model.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
  private String id;
  private String password;
  private String name;

  public User() {

  }

  public User(String id, String password, String name) {
    this.id = id;
    this.password = password;
    this.name = name;
  }

  public String getId() {
    return this.id;
  }

  public String getPassword() {
    return this.password;
  }

  public String getName() {
    return this.name;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getSchema() {
    List<String> result = new ArrayList<String>();
    result.add("id");
    result.add("password");
    result.add("name");
    return result;
  }
}
