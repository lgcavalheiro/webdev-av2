package av2.webdev.model.dao;

import java.io.IOException;
import java.util.Map;

public interface AuthenticatorDao {
    public Map<String, String> authenticateUser(String id, String password, String userType) throws IOException;

    void logQuery(String queryName);
}
