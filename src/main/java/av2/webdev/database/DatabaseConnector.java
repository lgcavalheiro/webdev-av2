package av2.webdev.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnector {
    private static Connection connection = null;

    public static Connection getConnection() throws IOException, ClassNotFoundException {
        if (connection == null) {
            try {
                Properties properties = loadProperties();
                String url = properties.getProperty("url");
                String driver = properties.getProperty("driver");
                String username = properties.getProperty("username");
                String password = properties.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                throw new DatabaseException(e.getMessage());
            }

        }
        return connection;
    }

    private static Properties loadProperties() throws IOException {
        try (FileInputStream fs = new FileInputStream("build/resources/main/db.properties")) {
            Properties properties = new Properties();
            properties.load(fs);
            return properties;
        } catch (IOException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DatabaseException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new DatabaseException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new DatabaseException(e.getMessage());
            }
        }
    }
}
