package model.dao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import av2.webdev.model.dao.impl.DegreeDaoJDBC;
import av2.webdev.model.entity.Degree;

public class DegreeDaoJDBCTest {
    @Test
    public void testGetDegreeByStudentId() {
        DegreeDaoJDBC dao = new DegreeDaoJDBC();
        Degree result = dao.getDegreeByStudentId("2020010001");

        assertEquals("3", result.getId());
        assertEquals("Redes de Computadores", result.getName());
    }

    @Test
    public void testGetDegreeByStudentIdInvalid() {
        DegreeDaoJDBC dao = new DegreeDaoJDBC();
        Degree result = dao.getDegreeByStudentId("123456789");

        assertEquals(null, result.getId());
        assertEquals(null, result.getName());
    }
}
