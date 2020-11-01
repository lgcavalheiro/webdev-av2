package av2.webdev.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import av2.webdev.model.DaoFactory;

@WebServlet(urlPatterns = { "/home" })
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String userType = request.getParameter("userType");

    Map<String, String> credentials = DaoFactory.createAuthenticatorDao().authenticateUser(request.getParameter("id"),
        request.getParameter("password"), userType);

    if (credentials.get("ID") == null || credentials.get("NAME") == null)
      request.getRequestDispatcher("view/loginError.html").forward(request, response);
    else {
      request.setAttribute("id", credentials.get("ID"));
      request.setAttribute("name", credentials.get("NAME"));

      if (userType.equalsIgnoreCase("student"))
        request.getRequestDispatcher("view/StudentHome.jsp").forward(request, response);
      else
        request.getRequestDispatcher("view/TeacherHome.jsp").forward(request, response);
    }
  }
}
