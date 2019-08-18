
package Presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sofieamalielandt
 */
public abstract class Command
{
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public static Command from(HttpServletRequest request)
    {
        Command c;
        String path = request.getPathInfo().substring(1);
        // String path = request.getParameter("path");

        switch (path)
        {
            case "recipe":
                c = new RecipeCommand();
                break;

            default:
                c = new UnknownCommand();

        }

        return c;
    }
    
}
