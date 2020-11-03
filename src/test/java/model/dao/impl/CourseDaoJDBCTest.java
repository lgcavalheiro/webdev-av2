package model.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import av2.webdev.model.dao.impl.CourseDaoJDBC;
import av2.webdev.model.entity.Course;

public class CourseDaoJDBCTest {
    @Test
    public void testGetCourseByStudentId() {
        CourseDaoJDBC dao = new CourseDaoJDBC();
        List<Course> result = dao.getCourseByStudentId("2020010001");

        assertEquals("Fundamentos de Redes", result.get(0).getName());
        assertEquals("Roteamento", result.get(1).getName());
        assertEquals("Empreendedorismo", result.get(2).getName());
        assertEquals("Metodologia Científica", result.get(3).getName());
    }

    @Test
    public void testGetCourseByStudentIdInvalid() {
        CourseDaoJDBC dao = new CourseDaoJDBC();
        List<Course> result = dao.getCourseByStudentId("12345");

        assertEquals("[]", result.toString());
    }

    @Test
    public void testGetCourseByTeacherID() {
        CourseDaoJDBC dao = new CourseDaoJDBC();
        List<Course> result = dao.getCourseByTeacherId("99990001");

        assertEquals("Fundamentos do Design", result.get(0).getName());
    }

    @Test
    public void testGetCourseByTeacherIdInvalid() {
        CourseDaoJDBC dao = new CourseDaoJDBC();
        List<Course> result = dao.getCourseByTeacherId("12345");

        assertEquals("[]", result.toString());
    }
}
