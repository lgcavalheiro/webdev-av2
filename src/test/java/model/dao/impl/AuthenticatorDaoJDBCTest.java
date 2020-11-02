package model.dao.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import av2.webdev.model.dao.impl.AuthenticatorDaoJDBC;

public class AuthenticatorDaoJDBCTest {
    @Test
    public void testAuthenticatorDaoJDBCTest() throws IOException {
        AuthenticatorDaoJDBC auth = new AuthenticatorDaoJDBC();
        Map<String, String> credentials = auth.authenticateUser("2020010001", "ZCG517", "student");

        assertEquals("Addison Kane", credentials.get("NAME"));
    }
}
