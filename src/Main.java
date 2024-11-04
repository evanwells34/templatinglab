import java.util.ArrayList;
import java.util.Scanner;

interface Ingredient {
    String getName();

    double getQuantity();
}

class SolidIngredient implements Ingredient {
    private String name;
    private double qtyGrams;

    public SolidIngredient(String n, double q) {
        name = n;
        qtyGrams = q;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return qtyGrams;
    }
}

class LiquidIngredient implements Ingredient {
    private String name;
    private double qtyMl;

    public LiquidIngredient(String n, double q) {
        name = n;
        qtyMl = q;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return qtyMl;
    }
}

class Recipe<T extends Ingredient> {
    private String name;
    private String instructions;
    private ArrayList<T> ingredients;

    public Recipe(String n, String inst) {
        name = n;
        instructions = inst;
        ingredients = new ArrayList<T>();
    }

    public void addIngredient(T t) {
        ingredients.add(t);
    }

    public void print() {
        if (ingredients.isEmpty()) {
            System.out.println("No ingredients found");
        } else {
            int i = 0;
            for(T ingredient : ingredients) {
                System.out.println("Name: " + ingredients.get(i).getName() + " Quantity: " + ingredients.get(i).getQuantity());
                i++;
            }
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Recipe<Ingredient> recipe;
        Scanner sc = new Scanner(System.in);
        String name = "";
        String instruction = "";
        recipe = new Recipe<Ingredient>(name, instruction);

        System.out.println("Welcome To the Recipe Site!");
        System.out.println("1. Type 1 to add ingredient");
        System.out.println("2. Type 2 to list ingredients");
        System.out.println("3. Type 3 to exit");
        try {
        int userInput = sc.nextInt();
            sc.nextLine();
            while (userInput != 3) {
                if (userInput == 1) {
                    addIngredient(recipe, sc);
                    System.out.println("1. Type 1 to add ingredient");
                    System.out.println("2. Type 2 to list ingredients");
                    userInput = sc.nextInt();
                }
                else if (userInput == 2) {
                    recipe.print();
                    System.out.println("1. Type 1 to add ingredient");
                    System.out.println("2. Type 3 to exit");
                    userInput = sc.nextInt();
                }
                else {
                    System.out.println("Invalid Choice");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input: " + e.getMessage());
            System.exit(-1);
        }
    }
    public static void addIngredient(Recipe<Ingredient> recipe, Scanner sc) {
        System.out.println("Type s for solid ingredient, type l for liquid ingredient");
        char type = sc.next().toLowerCase().charAt(0);
        System.out.println("Enter ingredient");
        String name = sc.next();
        System.out.println("Enter quantity");
        double quantity = Double.parseDouble(sc.next());
        Ingredient ingredient;
        if (type == 's')
            ingredient = new SolidIngredient(name, quantity);
        else
            ingredient = new LiquidIngredient(name, quantity);
        recipe.addIngredient(ingredient);
    }

}
