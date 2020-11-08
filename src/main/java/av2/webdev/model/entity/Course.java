package av2.webdev.model.entity;

import java.sql.Timestamp;

public class Course {
    String id;
    String classNumber;
    String name;
    String degreeId;
    Timestamp updateTimestamp;

    public Course() {

    }

    public Course(String id, String classNumber, String name, Timestamp updateTimestamp) {
        this.id = id;
        this.classNumber = classNumber;
        this.name = name;
        this.updateTimestamp = updateTimestamp;
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

    public Timestamp getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Timestamp updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public String getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(String degreeId) {
        this.degreeId = degreeId;
    }
}
