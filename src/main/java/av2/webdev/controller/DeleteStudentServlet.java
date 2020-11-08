package av2.webdev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import av2.webdev.model.entity.Grade;
import av2.webdev.model.utils.DaoFactory;

@WebServlet(urlPatterns = { "/deleteStudent" })
public class DeleteStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String courseId = request.getParameter("courseId");

        Float examAv1 = Float.valueOf(request.getParameter("examAv1"));
        Float examAv2 = Float.valueOf(request.getParameter("examAv2"));
        Float examAv3 = Float.valueOf(request.getParameter("examAv3"));

        Float assignmentAv1 = Float.valueOf(request.getParameter("assignmentAv1"));
        Float assignmentAv2 = Float.valueOf(request.getParameter("assignmentAv2"));

        Grade grade = new Grade(examAv1, assignmentAv1, examAv2, assignmentAv2, examAv3);

        // DaoFactory.createGradeDao().updateGrade(studentId, courseId, grade);

        System.out.println("INSIDE DELETE FAAAQ: " + studentId);

        request.getRequestDispatcher("/courseOverview").forward(request, response);
    }
}
