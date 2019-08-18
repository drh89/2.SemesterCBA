
package Logic;

import Data.Recipe;
import Data.RecipeDAO;


public class RecipeConnector
{
    public Recipe getRecipe(String name) throws Exception
    {
        
        RecipeDAO DAO = new RecipeDAO();
        System.out.println("recipe");
        Recipe recipe = DAO.getRecipe(name);
        
        return recipe;
    }
    
}
