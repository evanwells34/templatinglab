import java.util.ArrayList;

interface Ingredient{
    String getName();
    double getQuantity();
}
class SolidIngredient implements Ingredient{
    private String name;
    private double quantity;
    public SolidIngredient(String name, double quantity){
        this.name = name;
        this.quantity = quantity;
    }
    public String getName(){
        return name;
    }
    public double getQuantity(){
        return quantity;
    }
}
class LiquidIngredient implements Ingredient{
    private String name;
    private double quantity;
    public LiquidIngredient(String name, double quantity){
        this.name = name;
        this.quantity = quantity;
    }
    public String getName(){
        return name;
    }
    public double getQuantity(){
        return quantity;
    }
}
class Recipe<T extends Ingredient>{
    private String name;
    private String instructions;
    private ArrayList<T> ingredients;
    public Recipe(String name, String instructions, ArrayList<T> ingredients, int size){
        this.name = name;
        this.instructions = instructions;
        this.ingredients  = new ArrayList<T>(size);
    }
    public void addIngredient(T ingredient){
        this.ingredients.add(ingredient);
    }
    public void print(){
        if (ingredients == null){
            System.out.println("No ingredients found");
        }
        else{
            System.out.println("Name: " + name + "Instructions: " + instructions + "Ingredients: " + ingredients);
        }
    }

}
public class Main {
    public static void main(String[] args) {
        // Need To Fix This
        Recipe<Ingredient> = new Recipe<Ingredient>
        Recipe r = new Recipe("soup", "Stir", T, 6);
    }
}
