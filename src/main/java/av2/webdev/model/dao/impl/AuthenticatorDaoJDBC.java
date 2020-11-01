package av2.webdev.model.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import av2.webdev.model.dao.AuthenticatorDao;
import av2.webdev.model.utils.DatabaseConnector;

public class AuthenticatorDaoJDBC implements AuthenticatorDao {
    @Override
    public Map<String, String> authenticateUser(String id, String password, String userType) throws IOException {
        Connection connection = null;
        PreparedStatement query = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnector.getConnection();
            query = connection.prepareStatement(
                    "SELECT ID, NAME FROM " + userType.toUpperCase() + " WHERE ID = ? AND PASSWORD = ?");
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
            DatabaseConnector.closeStatement(query);
            DatabaseConnector.closeResultSet(resultSet);
            System.out.println("Transaction completed");
        }

        return null;
    }
}
