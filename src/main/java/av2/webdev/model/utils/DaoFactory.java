package av2.webdev.model.utils;

import av2.webdev.model.dao.AuthenticatorDao;
import av2.webdev.model.dao.DegreeDao;
import av2.webdev.model.dao.impl.AuthenticatorDaoJDBC;
import av2.webdev.model.dao.impl.DegreeDaoJDBC;

public class DaoFactory {
    public static AuthenticatorDao createAuthenticatorDao() {
        return new AuthenticatorDaoJDBC();
    }

    public static DegreeDao createDegreeDao() {
        return new DegreeDaoJDBC();
    }
}
