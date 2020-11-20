package av2.webdev.model.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import av2.webdev.model.dao.AuthenticatorDao;
import av2.webdev.model.dao.impl.utils.QueryLogger;
import av2.webdev.model.utils.DatabaseConnector;

public class AuthenticatorDaoJDBC implements AuthenticatorDao {
    static private Connection connection;
    static private PreparedStatement query;
    static private ResultSet resultSet;

    @Override
    public Map<String, String> authenticateUser(String id, String password, String userType) throws IOException {
        try {
            connection = DatabaseConnector.getConnection();
            query = connection.prepareStatement(
                    "SELECT ID, NAME FROM " + userType.toUpperCase(Locale.US) + " WHERE ID = ? AND PASSWORD = ?");
            query.setInt(1, Integer.parseInt(id));
            query.setString(2, password);
            resultSet = query.executeQuery();

            Map<String, String> result = new HashMap<String, String>();
            while (resultSet.next()) {
                result.put("ID", Integer.toString(resultSet.getInt("ID")));
                result.put("NAME", resultSet.getString("NAME"));
            }

            return result;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                QueryLogger.logQuery(this.getClass().getSimpleName(), "authenticateUser");
                if (query != null)
                    query.close();
                if (resultSet != null)
                    resultSet.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
