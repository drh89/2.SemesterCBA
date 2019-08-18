/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.FacadesLogic;

import data.FacadesData.RecipeDataFacade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.Recipe;
import logic.RecipeController;

/**
 *
 * @author Dennis
 */
public class RecipeLogicFacade {

    private RecipeController rc;

    public RecipeLogicFacade() throws Exception {
        rc = new RecipeController();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
        RecipeLogicFacade rlf = new RecipeLogicFacade();

        System.out.println(rlf.getAllRecipes());
    }
    
    
    public List<Recipe> getAllRecipes() throws Exception{
        List<Recipe> recipes = new ArrayList();
        
        recipes = rc.getAllRecipes();
        
        return recipes;
        
    }

    public Recipe getRecipe(int recipeId) throws ClassNotFoundException, SQLException, Exception {

        Recipe rec = rc.getRecipe(recipeId);
        System.out.println("hej fra logic!");
        return rec;

    }
}
