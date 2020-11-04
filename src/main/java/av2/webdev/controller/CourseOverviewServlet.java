package av2.webdev.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import av2.webdev.model.entity.Grade;
import av2.webdev.model.entity.Student;
import av2.webdev.model.utils.DaoFactory;

@WebServlet(urlPatterns = { "/courseOverview" })
public class CourseOverviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String courseId = request.getParameter("courseId");
        List<Student> studentList = DaoFactory.createStudentDao().getStudentByCourseId(courseId);
        List<Grade> gradeList = DaoFactory.createGradeDao().getGradeByCourseId(courseId);
        for (Student student : studentList) {
            for (Grade grade : gradeList) {
                if (student.getId().equalsIgnoreCase(grade.getStudentId())) {
                    List<Grade> temp = new ArrayList<Grade>();
                    grade.calculateIfApproved();
                    temp.add(grade);
                    student.setGrades(temp);
                }
            }
        }
        request.getSession().setAttribute("studentList", studentList);
        request.getSession().setAttribute("classNumber", request.getParameter("classNumber"));
        request.getSession().setAttribute("courseName", request.getParameter("name"));

        request.getRequestDispatcher("view/courseOverview.jsp").forward(request, response);
    }
}
