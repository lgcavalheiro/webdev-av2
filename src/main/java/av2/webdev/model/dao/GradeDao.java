package av2.webdev.model.dao;

import java.util.List;

import av2.webdev.model.entity.Grade;

public interface GradeDao {
    public List<Grade> getGradeByStudentId(String studentId);

    public List<Grade> getGradeByCourseId(String courseId);
}
