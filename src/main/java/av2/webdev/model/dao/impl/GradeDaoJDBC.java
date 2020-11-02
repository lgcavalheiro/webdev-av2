package av2.webdev.model.dao.impl;

import av2.webdev.model.dao.GradeDao;

public class GradeDaoJDBC implements GradeDao {
    private static String cuéri = "SELECT COURSE.ID, COURSE.CLASS_NUMBER, COURSE.NAME, GRADE.EXAM_AV1, GRADE.ASSIGNMENT_AV1, GRADE.EXAM_AV2, GRADE.ASSIGNMENT_AV2, GRADE.EXAM_AV3, GRADE.FINAL_GRADE, GRADE.UPDATE_TIMESTAMP FROM STUDENT_COURSE_GRADE_JT INNER JOIN COURSE ON COURSE_FK = COURSE.ID INNER JOIN GRADE ON GRADE_FK = GRADE.ID WHERE STUDENT_FK = 2020010001";

    @Override
    public void getGradeByStudentId(String studentId) {
        // TODO Auto-generated method stub

    }

}
