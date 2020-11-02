package model.utils;

import org.junit.Test;

import av2.webdev.model.dao.AuthenticatorDao;
import av2.webdev.model.dao.DegreeDao;
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
}
