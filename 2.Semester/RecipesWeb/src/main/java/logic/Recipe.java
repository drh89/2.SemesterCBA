/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Dennis
 */
public class Recipe {
    
     private int id;
    private String name;
    private String ingredients;
    private String instructions;
    private String imageUrl;
    
    public Recipe(int id, String name, String ingredients, String instructions, String imageUrl){
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.imageUrl = imageUrl;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the ingredients
     */
    public String getIngredients() {
        return ingredients;
    }

    /**
     * @param ingredients the ingredients to set
     */
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * @return the instructions
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * @param instructions the instructions to set
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    /**
     * @return the imageId
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageId the imageId to set
     */
    public void setImageId(String imageUrl) {
        this.imageUrl = imageUrl;
    }
     @Override
    public String toString(){
        return name + "\n" + ingredients + "\n" + instructions + "\n";
    }
    
     
}
