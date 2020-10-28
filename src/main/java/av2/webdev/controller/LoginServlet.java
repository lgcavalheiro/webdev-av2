package av2.webdev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import av2.webdev.database.AccountDatabase;

@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = -8259537970640399842L;
  transient AccountDatabase db = new AccountDatabase();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    try (PrintWriter out = response.getWriter()) {
      response.setContentType("text/html;charset=UTF-8");
      String result = db.getUserPassword(123);
      System.out.println(result);
      out.println(result);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) {
  }
}
