/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.FacadesData.RecipeDataFacade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dennis
 */
public class RecipeController {
    
    private RecipeDataFacade rdf;
    
    
    public RecipeController() throws Exception{
        rdf = new RecipeDataFacade();
}
    
    public List<Recipe> getAllRecipes() throws Exception{
        List<Recipe> recipes = new ArrayList();
        
        recipes = rdf.getAllRecipes();
        
        return recipes;
        
        
    }
    
    public Recipe getRecipe(int recipe_Id) throws Exception{
        Recipe rec = rdf.getRecipe(recipe_Id);
        return rec;
    }
}
