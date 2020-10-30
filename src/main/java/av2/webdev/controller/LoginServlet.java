package av2.webdev.controller;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import av2.webdev.database.AccountTable;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = -8259537970640399842L;
  transient AccountTable db = new AccountTable();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    request.setAttribute("id", id);
    request.setAttribute("password", password);
    request.getRequestDispatcher("view/home.jsp").forward(request, response);
  }
}
