/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.FacadesData;

import data.RecipeMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.Recipe;

/**
 *
 * @author Dennis
 */
public class RecipeDataFacade {
    
    
    private RecipeMapper rm;

    public RecipeDataFacade() throws Exception {
        rm = new RecipeMapper();
    }
    
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
        RecipeDataFacade rdf = new RecipeDataFacade();
//        System.out.println( rdf.getRecipe(1));
        System.out.println( rdf.getAllRecipes());
    }
    
     
    public List<Recipe> getAllRecipes() throws Exception{
        List<Recipe> recipes = new ArrayList();
        
        recipes = rm.getAllRecipes();
        
        return recipes;
        
    }
    
    public Recipe getRecipe(int recipe_Id) throws ClassNotFoundException, SQLException, Exception{
        System.out.println("hej fra data");
        Recipe rec = rm.getRecipe(recipe_Id);
        return rec;
    }
    
}
