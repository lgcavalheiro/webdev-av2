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

    @Test
    public void testGetGradeByCourseId() {
        GradeDaoJDBC dao = new GradeDaoJDBC();
        List<Grade> result = dao.getGradeByCourseId("2");

        assertEquals(7, result.size());
    }

    @Test
    public void testUpdateGrade() {
        GradeDaoJDBC dao = new GradeDaoJDBC();
        int rowsAffected = dao.updateGrade("2020010001", "3",
                new Grade((float) 5.0, (float) 1.2, (float) 7.2, (float) 2.0, (float) 6.9));

        assertEquals(1, rowsAffected);
    }

    @Test
    public void testUpdateGradeInvalid() {
        GradeDaoJDBC dao = new GradeDaoJDBC();
        int rowsAffected = dao.updateGrade("1234", "999",
                new Grade((float) 5.0, (float) 1.2, (float) 7.2, (float) 2.0, (float) 6.9));

        assertEquals(0, rowsAffected);
    }
}
