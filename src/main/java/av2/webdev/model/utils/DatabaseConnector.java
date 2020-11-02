package av2.webdev.model.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
    public static Connection getConnection() throws IOException, ClassNotFoundException {
        try {
            Properties properties = loadProperties();
            String url = properties.getProperty("url");
            String driver = properties.getProperty("driver");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private static Properties loadProperties() throws IOException {
        try (FileInputStream fs = new FileInputStream("build/resources/main/db.properties")) {
            Properties properties = new Properties();
            properties.load(fs);
            fs.close();
            return properties;
        } catch (IOException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
