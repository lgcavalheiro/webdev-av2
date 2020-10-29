package av2.webdev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import av2.webdev.database.AccountDatabase;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = -8259537970640399842L;
  transient AccountDatabase db = new AccountDatabase();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    try (PrintWriter out = response.getWriter()) {
      response.setContentType("text/html;charset=UTF-8");
      String result = db.getUserPassword(123);
      out.println("<head><meta charset=\"UTF-8\"></head>");
      out.println("<body><h1>" + result + "</h1><body>");
    }
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
