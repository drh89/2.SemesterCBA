
package Data;


public class Ingredient
{
    private String name;
    private double units;
    private String scale;

    public Ingredient(String name, double units, String scale)
    {
        this.name = name;
        this.units = units;
        this.scale = scale;
    }

    public String getName()
    {
        return name;
    }

    public double getUnits()
    {
        return units;
    }

    public String getScale()
    {
        return scale;
    }

    @Override
    public String toString()
    {
        return name + ": " + units +" " + scale;
    }
 
}
