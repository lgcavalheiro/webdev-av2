package av2.webdev.database;

import java.util.HashMap;
import java.util.Map;

import av2.webdev.model.Student;
import av2.webdev.model.Teacher;
import av2.webdev.model.User;

public class AccountDatabase {
  private transient Map<Integer, User> db = new HashMap<Integer, User>();

  public AccountDatabase() {
    this.db.put(123, new Student(123, "asd123"));
    this.db.put(678, new Teacher(456, "456456123"));
  }

  public String getUserPassword(int id) {
    return db.get(id).getPassword();
  }

  public static int sum(int a, int b) {
    return a + b;
  }
}
