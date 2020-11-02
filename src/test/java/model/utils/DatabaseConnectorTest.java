package model.utils;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import av2.webdev.model.utils.DatabaseConnector;

public class DatabaseConnectorTest {
    private static Connection connection;

    @Test
    public void testGetConnection() throws SQLException {
        try {
            connection = DatabaseConnector.getConnection();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        assertEquals(true, connection.isValid(8));
        connection.close();
    }
}
