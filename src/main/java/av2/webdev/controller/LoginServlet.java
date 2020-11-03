package av2.webdev.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import av2.webdev.model.entity.Student;
import av2.webdev.model.entity.Teacher;
import av2.webdev.model.utils.DaoFactory;

@WebServlet(urlPatterns = { "/home" })
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String id = request.getParameter("id");
    String userType = request.getParameter("userType");

    Map<String, String> credentials = DaoFactory.createAuthenticatorDao().authenticateUser(id,
        request.getParameter("password"), userType);

    if (credentials == null || credentials.get("ID") == null || credentials.get("NAME") == null)
      request.getRequestDispatcher("view/loginError.html").forward(request, response);
    else {
      HttpSession session;

      switch (userType) {
        case "student":
          Student student = new Student();
          student.setId(id);
          student.setName(credentials.get("NAME"));
          student.setDegree(DaoFactory.createDegreeDao().getDegreeByStudentId(id));
          student.setCourses(DaoFactory.createCourseDao().getCourseByStudentId(id));
          student.setGrades(DaoFactory.createGradeDao().getGradeByStudentId(id));
          student.getGrades().forEach(grade -> grade.calculateIfApproved());

          session = request.getSession();
          session.setAttribute("student", student);

          request.getRequestDispatcher("view/studentHome.jsp").forward(request, response);
          break;
        case "teacher":
          // degree + courses with students and grades
          Teacher teacher = new Teacher();
          teacher.setId(id);
          teacher.setName(credentials.get("NAME"));
          teacher.setCourses(DaoFactory.createCourseDao().getCourseByTeacherId(id));

          session = request.getSession();
          session.setAttribute("teacher", teacher);

          request.getRequestDispatcher("view/teacherHome.jsp").forward(request, response);
          break;
        default:
          request.getRequestDispatcher("view/loginError.html").forward(request, response);
          break;
      }
    }
  }
}
