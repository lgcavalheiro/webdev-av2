package av2.webdev.model.dao;

import java.util.List;

import av2.webdev.model.entity.Degree;

public interface DegreeDao {
    public Degree getDegreeByStudentId(String studentId);

    public List<Degree> getDegreeByCourseId(String courseId);
}
