package av2.webdev.model;

import av2.webdev.model.dao.AuthenticatorDao;
import av2.webdev.model.dao.impl.AuthenticatorDaoJDBC;

public class DaoFactory {
    public static AuthenticatorDao createAuthenticatorDao() {
        return new AuthenticatorDaoJDBC();
    }
}
