package av2.webdev.model.utils;

import av2.webdev.model.dao.AuthenticatorDao;
import av2.webdev.model.dao.CourseDao;
import av2.webdev.model.dao.DegreeDao;
import av2.webdev.model.dao.GradeDao;
import av2.webdev.model.dao.impl.AuthenticatorDaoJDBC;
import av2.webdev.model.dao.impl.CourseDaoJDBC;
import av2.webdev.model.dao.impl.DegreeDaoJDBC;
import av2.webdev.model.dao.impl.GradeDaoJDBC;

public class DaoFactory {
    public static AuthenticatorDao createAuthenticatorDao() {
        return new AuthenticatorDaoJDBC();
    }

    public static DegreeDao createDegreeDao() {
        return new DegreeDaoJDBC();
    }

    public static CourseDao createCourseDao() {
        return new CourseDaoJDBC();
    }

    public static GradeDao createGradeDao() {
        return new GradeDaoJDBC();
    }
}
