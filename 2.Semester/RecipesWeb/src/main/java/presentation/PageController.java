/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dennis
 */
@WebServlet(name = "PageController", urlPatterns = "/PageController")
public class PageController extends HttpServlet {
    private GetAllRecipesServlet servlet;
    private SingleRecipeServlet servletSingle;
    
    
    protected void redirectToPage(HttpServletRequest request, HttpServletResponse response)throws Exception{
        
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        
        String page = request.getParameter("page");
                String id = request.getParameter("id");

        
        switch(page){
            
            case"GetAllRecipes":
                servlet = new GetAllRecipesServlet();
                servlet.getAllRecipes(request, response);
                break;
            
            case"GetSingleRecipe":
                servletSingle = new SingleRecipeServlet();
                servletSingle.getRecipe(request, response);
                
                
            
            
            
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
            redirectToPage(request, response);
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
            redirectToPage(request, response);
        } catch (Exception ex) {
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
