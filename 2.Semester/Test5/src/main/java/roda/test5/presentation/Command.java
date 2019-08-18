package roda.test5.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public static Command from(HttpServletRequest request){
        Command c;
        String path = request.getPathInfo().substring(1);
        //String path = request.getParameter("path");
        switch(path){
            case "hest":
            case "login":
                c = new LoginCommand();
//            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/LoginServlet");
//            dispatcher.forward(request, response);
            break;
            default:
                c = new UnknownCommand();
        }
        return c;
    }
}
