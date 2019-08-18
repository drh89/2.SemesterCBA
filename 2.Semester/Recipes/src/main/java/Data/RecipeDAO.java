package Data;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofieamalielandt
 */
public class RecipeDAO
{

    private DBConnector connector = null;

    public RecipeDAO() throws Exception
    {
        this.connector = new DBConnector();
    }

    public List<Ingredient> getIngredients(int recipe_id) throws Exception
    {
        String query
                = "SELECT * "
                + "FROM Recipes.Ingredients "
                + "JOIN Recipes.Recipe_has_ingredients ON (Ingredients.ingredients_id = Recipe_has_ingredients.ingredients_id)"
                + "WHERE recipe_id = '" + recipe_id + "';";

        Statement statement = connector.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(query);

        String name = "";
        double units = 0;
        String scale = "";

        List<Ingredient> ingredients = new ArrayList();

        while (rs.next())
        {

            name = rs.getString("name");
            units = rs.getDouble("units");
            scale = rs.getString("scale");
            if (scale == null) scale = "";

            ingredients.add(new Ingredient(name, units, scale));
        }
        return ingredients;
    }

    public Recipe getRecipe(String name) throws Exception
    {
        String query
                = "SELECT * "
                + "FROM Recipes.Recipe "
                + "WHERE name = '" + name + "';";

        Statement statement = connector.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(query);
        
        Recipe recipe = null;
        String recipe_name = "";
        String description = "";
        int rating = 0;
        String image = "";
        List<Ingredient> ingredients = null;

        while(rs.next())
        {
            recipe_name = rs.getString("name");
            description = rs.getString("description");
            rating = rs.getInt("rating");
            image = rs.getString("image");
            ingredients = getIngredients(rs.getInt("recipe_id"));
            
            recipe = new Recipe(recipe_name, description, ingredients, rating, image);
        }
        
        return recipe;
    }

}
