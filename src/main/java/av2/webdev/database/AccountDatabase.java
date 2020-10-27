package av2.webdev.database;

import java.util.ArrayList;

import av2.webdev.model.Student;
import av2.webdev.model.Teacher;
import av2.webdev.model.User;

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
