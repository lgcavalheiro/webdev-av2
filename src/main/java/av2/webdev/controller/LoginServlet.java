package av2.webdev.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import av2.webdev.model.entity.Student;
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

    if (credentials.get("ID") == null || credentials.get("NAME") == null)
      request.getRequestDispatcher("view/loginError.html").forward(request, response);
    else {
      request.setAttribute("id", credentials.get("ID"));
      request.setAttribute("name", credentials.get("NAME"));

      switch (userType) {
        case "student":
          // get degree + courses + grades
          Student student = new Student();
          student.setId(id);
          student.setName(credentials.get("NAME"));
          student.setDegree(DaoFactory.createDegreeDao().getDegreeByStudentId(id));

          request.getRequestDispatcher("view/StudentHome.jsp").forward(request, response);
          break;
        case "teacher":
          // degree + courses with students and grades
          request.getRequestDispatcher("view/TeacherHome.jsp").forward(request, response);
          break;
        default:
          request.getRequestDispatcher("view/loginError.html").forward(request, response);
          break;
      }
    }
  }
}
