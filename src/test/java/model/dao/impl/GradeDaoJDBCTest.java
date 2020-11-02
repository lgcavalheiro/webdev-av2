package model.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import av2.webdev.model.dao.impl.GradeDaoJDBC;
import av2.webdev.model.entity.Grade;

public class GradeDaoJDBCTest {
    @Test
    public void testGetGradeByStudentId() {
        GradeDaoJDBC dao = new GradeDaoJDBC();
        List<Grade> result = dao.getGradeByStudentId("2020010001");

        assertEquals("2", result.get(0).getId());
        assertEquals("18", result.get(1).getId());
        assertEquals("28", result.get(2).getId());
        assertEquals("34", result.get(3).getId());
    }
}
