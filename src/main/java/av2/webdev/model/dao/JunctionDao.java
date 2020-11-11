package av2.webdev.model.dao;

public interface JunctionDao {
    public int insertStudentCourseGradeJunction(String studentId, String courseId, String gradeId);

    public String getGradeIdByStudentAndCourse(String studentId, String courseId);

    public void deleteStudentCourseGradeJunction(String studentId, String courseId, String gradeId);
}
