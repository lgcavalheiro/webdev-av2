package av2.webdev.model.entity;

import java.util.List;

public class Teacher extends User {
  List<Course> courses;

  public Teacher() {

  }

  public Teacher(String id, String password, String name) {
    super(id, password, name);
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }
}
