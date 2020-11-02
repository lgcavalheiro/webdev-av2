package model.utils;

import org.junit.Test;

import av2.webdev.model.dao.AuthenticatorDao;
import av2.webdev.model.dao.CourseDao;
import av2.webdev.model.dao.DegreeDao;
import av2.webdev.model.dao.GradeDao;
import av2.webdev.model.utils.DaoFactory;

public class DaoFactoryTest {
    @Test
    public void testCreateAuthenticatorDao() {
        AuthenticatorDao auth = DaoFactory.createAuthenticatorDao();

        assert (auth.getClass().getName().contains("AuthenticatorDaoJDBC"));
    }

    @Test
    public void testCreateDegreeDao() {
        DegreeDao dao = DaoFactory.createDegreeDao();

        assert (dao.getClass().getName().contains("DegreeDaoJDBC"));
    }

    @Test
    public void testCreateCourseDao() {
        CourseDao dao = DaoFactory.createCourseDao();

        assert (dao.getClass().getName().contains("CourseDaoJDBC"));
    }

    @Test
    public void testCreateGradeDao() {
        GradeDao dao = DaoFactory.createGradeDao();

        assert (dao.getClass().getName().contains("GradeDaoJDBC"));
    }
}
