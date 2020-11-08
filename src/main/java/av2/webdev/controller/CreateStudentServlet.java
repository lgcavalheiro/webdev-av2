package av2.webdev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import av2.webdev.model.entity.Degree;
import av2.webdev.model.entity.Grade;
import av2.webdev.model.entity.Student;
import av2.webdev.model.utils.DaoFactory;

@WebServlet(urlPatterns = { "/createStudent" })
public class CreateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/createStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get degree by course id
        String courseId = request.getParameter("courseId");
        Degree degree = DaoFactory.createDegreeDao().getDegreeByCourseId(courseId).get(0);
        // insert new student
        Student student = new Student();
        String studentName = request.getParameter("studentName");
        student.setId(request.getParameter("studentId"));
        student.setName(studentName);
        student.setPassword(studentName.substring(0, 2).toUpperCase() + "123");
        student.setDegree(degree);
        int rowsAffectedStudent = DaoFactory.createStudentDao().insertStudent(student);
        String gradeId = "";
        // insert new grade
        if (rowsAffectedStudent > 0) {
            Grade grade = new Grade((float) 0, (float) 0, (float) 0, (float) 0, (float) 0);
            gradeId = DaoFactory.createGradeDao().insertGrade(grade);
        }
        // insert on junction table
        if (gradeId.length() > 0) {
            DaoFactory.createJunctionDao().insertStudentCourseGradeJunction(student.getId(), courseId, gradeId);
        }
    }
}
