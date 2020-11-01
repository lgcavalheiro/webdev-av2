package av2.webdev.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import av2.webdev.database.AccountTable;
import av2.webdev.model.Authenticator;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  transient AccountTable db = new AccountTable();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    String userType = request.getParameter("userType");

    Map<String, String> credentials = Authenticator.authenticateUser(id, password, userType);

    request.setAttribute("id", credentials.get("ID"));
    request.setAttribute("name", credentials.get("NAME"));

    if (request.getAttribute("id") == null || request.getAttribute("name") == null)
      request.getRequestDispatcher("view/loginError.html").forward(request, response);
    else {
      if (userType.equalsIgnoreCase("student"))
        request.getRequestDispatcher("view/StudentHome.jsp").forward(request, response);
      else
        request.getRequestDispatcher("view/TeacherHome.jsp").forward(request, response);
    }
  }
}
