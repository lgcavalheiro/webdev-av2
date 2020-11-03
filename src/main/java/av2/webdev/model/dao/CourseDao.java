package av2.webdev.model.dao;

import java.util.List;

import av2.webdev.model.entity.Course;

public interface CourseDao {
    public List<Course> getCourseByStudentId(String studentId);

    public List<Course> getCourseByTeacherId(String teacherId);
}
