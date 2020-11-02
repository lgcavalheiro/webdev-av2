package av2.webdev.model.dao;

import av2.webdev.model.entity.Degree;

public interface DegreeDao {
    public Degree getDegreeByStudentId(String studentId);
}
