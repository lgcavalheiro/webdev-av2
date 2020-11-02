package av2.webdev.model.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseConnector {
    public static Connection getConnection() throws IOException, ClassNotFoundException {
        try {
            Map<String, String> credentials = DatabaseCredentialsGetter.getDatabaseCredentials();
            String url = credentials.get("url");
            String driver = credentials.get("driver");
            String username = credentials.get("username");
            String password = credentials.get("password");
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    // private static Properties loadProperties() throws IOException {
    // try (FileInputStream fs = new
    // FileInputStream("build/resources/main/db.properties")) {
    // Properties properties = new Properties();
    // properties.load(fs);
    // fs.close();
    // return properties;
    // } catch (IOException e) {
    // throw new DatabaseException(e.getMessage());
    // }
    // }
}
