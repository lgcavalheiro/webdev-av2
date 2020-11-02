package av2.webdev.model.entity;

public class Course {
    String id;
    String classNumber;
    String name;

    public Course() {

    }

    public Course(String id, String classNumber, String name) {
        this.id = id;
        this.classNumber = classNumber;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
