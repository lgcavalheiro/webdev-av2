package av2.webdev.servlet;

import av2.webdev.model.AccountDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
  AccountDatabase db = new AccountDatabase();

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws IOException {
    try (PrintWriter out = response.getWriter()) {
      response.setContentType("text/html;charset=UTF-8");
      String result = db.getUserPassword(0);
      System.out.println(result);
      out.println(result);
    }
  }

  @Override
  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) {}
}
