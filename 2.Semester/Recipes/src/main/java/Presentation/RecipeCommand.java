/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Recipe;
import Logic.RecipeConnector;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sofieamalielandt
 */
public class RecipeCommand extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String recipe = request.getParameter("recipe");
            
            RecipeConnector r = new RecipeConnector();
            Recipe result;

            result = r.getRecipe(recipe);
            
            HttpSession session = request.getSession();
            session.setAttribute("Recipe", result);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter())
            {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title> Opsrift på:" + result.getName() + "</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>" + result.getName() + "</h1>");
                out.println("<p>" + result.getIngredients() + "</p>");
                out.println("<p>" + result.getDescription() + "</p>");
                out.println("<p>Rating: " + result.getRating() + "</p>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

}
