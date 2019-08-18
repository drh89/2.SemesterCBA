/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.Recipe;

/**
 *
 * @author Dennis
 */
public class RecipeMapper {
    
    private DBConnector con = null;
    
    public RecipeMapper() throws Exception{
        con = new DBConnector();
        
    }
    public static void main(String[] args) throws Exception {
        RecipeMapper rm = new RecipeMapper();
        System.out.println(rm.getAllRecipes());
    }
    
    public List<Recipe> getAllRecipes() throws Exception{
        List<Recipe> recipes = new ArrayList();
        Recipe rec = null;
        String query = "SELECT * FROM Recipe;";
        
        PreparedStatement stmt = con.getConnection().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            int id = rs.getInt("recipe_Id");
            String name = rs.getString("recipe_Name");
            String ingredients = rs.getString("ingredients");
            String instructions = rs.getString("instructions");
            String imageUrl = rs.getString("image_Url");
            
            rec = new Recipe(id, name, ingredients, instructions, imageUrl);
            recipes.add(rec);
            
            
        }
        return recipes;
    }
    
    public Recipe getRecipe (int recipeId) throws Exception{
        Recipe rec = null;
        String query =  "SELECT * FROM Recipe WHERE recipe_Id = " + recipeId + ";";
       
        PreparedStatement stmt = con.getConnection().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            
            int id = rs.getInt("recipe_Id");
            String name = rs.getString("recipe_Name");
            String ingredients = rs.getString("ingredients");
            String instructions = rs.getString("instructions");
            String imageUrl = rs.getString("image_Url");
            
            rec = new Recipe(id, name, ingredients, instructions, imageUrl);
            
        }
        return rec;
    }
}
