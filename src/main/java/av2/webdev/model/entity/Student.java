package av2.webdev.model.entity;

import java.util.List;

public class Student extends User {
  Degree degree;
  List<Course> courses;
  List<Grade> grades;

  public Student() {

  }

  public Student(String id, String password, String name) {
    super(id, password, name);
  }

  public Degree getDegree() {
    return degree;
  }

  public void setDegree(Degree degree) {
    this.degree = degree;
  }

  public List<Grade> getGrades() {
    return grades;
  }

  public void setGrades(List<Grade> grades) {
    this.grades = grades;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }
}
