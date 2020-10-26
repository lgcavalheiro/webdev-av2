package av2.webdev.model;

import av2.webdev.classes.Student;
import av2.webdev.classes.Teacher;
import av2.webdev.classes.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccountDatabase {
  ArrayList<User> db = new ArrayList<User>();

  public AccountDatabase() {
    this.db.add(new Student(123, "a123"));
    this.db.add(new Teacher(987, "a987"));
  }

  public String getUserPassword(int index) {
    return db.get(index).getPassword();
  }
}
