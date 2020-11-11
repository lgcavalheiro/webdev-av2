package av2.webdev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import av2.webdev.model.utils.DaoFactory;

@WebServlet(urlPatterns = { "/deleteStudent" })
public class DeleteStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String courseId = request.getParameter("courseId");

        // get grade id for this student + course
        String gradeId = DaoFactory.createJunctionDao().getGradeIdByStudentAndCourse(studentId, courseId);

        // delete grade and entry in junction table
        DaoFactory.createJunctionDao().deleteStudentCourseGradeJunction(studentId, courseId, gradeId);
        DaoFactory.createGradeDao().deleteGrade(gradeId);

        request.getRequestDispatcher("/courseOverview").forward(request, response);
    }
}
