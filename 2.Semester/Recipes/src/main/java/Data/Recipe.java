package Data;

import java.util.List;

public class Recipe
{

    private String name;
    private String description;
    private List<Ingredient> ingredients;
    private int rating;
    private String image;

    public Recipe(String name, String description, List<Ingredient> ingredients, int rating, String image)
    {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.rating = rating;
        this.image = image;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getIngredients()
    {
        String ings = "";

        for (Ingredient i : ingredients)
        {
            ings = ings + i + "<br>";

        }

        return ings;
    }

    public int getRating()
    {
        return rating;
    }

    public String getImage()
    {
        return image;
    }

}
