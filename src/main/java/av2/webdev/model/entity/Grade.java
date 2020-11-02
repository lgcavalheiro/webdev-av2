package av2.webdev.model.entity;

import java.sql.Timestamp;

public class Grade {
    String id;
    Float examAv1;
    Float assignmentAv1;
    Float examAv2;
    Float assignmentAv2;
    Float examAv3;
    Float finalGrade;
    String courseId;
    Timestamp updateTimestamp;

    public Grade() {

    }

    public Grade(String id, Float examAv1, Float assignmentAv1, Float examAv2, Float assignmentAv2, Float examAv3,
            Float finalGrade, String courseId, Timestamp updateTimestamp) {
        this.id = id;
        this.examAv1 = examAv1;
        this.assignmentAv1 = assignmentAv1;
        this.examAv2 = examAv2;
        this.assignmentAv2 = assignmentAv2;
        this.examAv3 = examAv3;
        this.finalGrade = finalGrade;
        this.courseId = courseId;
        this.updateTimestamp = updateTimestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getExamAv1() {
        return examAv1;
    }

    public void setExamAv1(Float examAv1) {
        this.examAv1 = examAv1;
    }

    public Float getAssignmentAv1() {
        return assignmentAv1;
    }

    public void setAssignmentAv1(Float assignmentAv1) {
        this.assignmentAv1 = assignmentAv1;
    }

    public Float getExamAv2() {
        return examAv2;
    }

    public void setExamAv2(Float examAv2) {
        this.examAv2 = examAv2;
    }

    public Float getAssignmentAv2() {
        return assignmentAv2;
    }

    public void setAssignmentAv2(Float assignmentAv2) {
        this.assignmentAv2 = assignmentAv2;
    }

    public Float getExamAv3() {
        return examAv3;
    }

    public void setExamAv3(Float examAv3) {
        this.examAv3 = examAv3;
    }

    public Timestamp getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Timestamp updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Float getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(Float finalGrade) {
        this.finalGrade = finalGrade;
    }
}
