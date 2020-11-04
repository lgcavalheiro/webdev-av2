package av2.webdev.model.dao;

import java.util.List;

import av2.webdev.model.entity.Student;

public interface StudentDao {
    public List<Student> getStudentByCourseId(String courseId);
}
