package roda.test5.presentation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import roda.test5.data.User;
import roda.test5.logic.LoginController;

public class LoginCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        LoginController c = new LoginController();
        boolean valid = c.isValid(username, password);
        User user = c.getUser(username);
        
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        // User u = (User) session.getAttribute("user");
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Valid: " + valid + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
