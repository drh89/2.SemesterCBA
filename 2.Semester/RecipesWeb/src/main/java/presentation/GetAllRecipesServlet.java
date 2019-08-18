/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.FacadesLogic.RecipeLogicFacade;
import logic.Recipe;

/**
 *
 * @author Dennis
 */

@WebServlet(name = "GetAllRecipesServlet", urlPatterns ="/GetAllRecipesServlet")
public class GetAllRecipesServlet extends HttpServlet {
    
    private RecipeLogicFacade rlf;
    private static int count = 1;
    public GetAllRecipesServlet() throws Exception{
        rlf = new RecipeLogicFacade();
    }
    
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            getAllRecipes(request, response);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    
    public void getAllRecipes(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        
        response.setContentType("text/html;charset=UTF-8");
        List<Recipe> recipes = new ArrayList();
        recipes = rlf.getAllRecipes();
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetAllRecipesServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Opskrifter:</h1>");
            
            for (Recipe recipe : recipes) {
                
                
                
                out.println("<p><a href=\"/RecipesWeb/SingleRecipeServlet?id=" + count + "\">"  + recipe.getName() + "</a></p>");
                count++;
            }
            
            
            out.println("</body>");
            out.println("</html>");
        }

    }
    
    
}
