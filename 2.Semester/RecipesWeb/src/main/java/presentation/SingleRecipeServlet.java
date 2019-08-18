/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.FacadesLogic.RecipeLogicFacade;
import logic.Recipe;
import logic.RecipeController;

/**
 *
 * @author Dennis
 */
@WebServlet(name = "SingleRecipeServlet", urlPatterns = {"/SingleRecipeServlet"})
public class SingleRecipeServlet extends HttpServlet {
    private RecipeLogicFacade rlf;

    public SingleRecipeServlet() throws Exception {
        rlf = new RecipeLogicFacade();
    }
    
    

   public void getRecipe(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        
        String parameter = request.getParameter("id");
        Recipe result = rlf.getRecipe(Integer.valueOf(parameter));


       
        
//        HttpSession session = request.getSession();
//        session.setAttribute("Recipe", result);
//        String name = (String) request.getSession().getAttribute("name");
//        String ingredients = (String) request.getSession().getAttribute("ingredients");
//        String instructions = (String)
       

        response.setContentType("text/html;charset=UTF-8");
        String path = result.getImageUrl();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SingleRecipeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Opskrift på: " + result.getName() + "</h1>");
            out.println("<p><b>Ingredienser: </b></p>");
            out.println("<p>" + result.getIngredients() + "</p>");
            out.println("<p><b>Sådan gør du: </b></p>");
            out.println("<p>" + result.getInstructions()+ "</p>");
            out.println("<img src=" + "\"" + path + "\"" + ">");
            out.println("</body>");
            out.println("</html>");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            getRecipe(request, response);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            getRecipe(request, response);
        }  catch (Exception ex) {
          ex.getMessage();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
   
    

}
