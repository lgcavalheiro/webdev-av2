package model.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import av2.webdev.model.dao.impl.StudentDaoJDBC;
import av2.webdev.model.entity.Student;

public class StudentDaoJDBCTest {
    @Test
    public void testGetStudentByCourseId() {
        StudentDaoJDBC dao = new StudentDaoJDBC();
        List<Student> result = dao.getStudentByCourseId("2");

        assertEquals(6, result.size());
    }
}
