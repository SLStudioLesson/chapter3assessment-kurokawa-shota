package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }
    
    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    // displayRecipesメソッド
    private void displayRecipes() {
        try {
            ArrayList<Recipe> recipes = dataHandler.readData();
        
            // レシピが1件も存在しない場合
            if (recipes == null || recipes.isEmpty()) {
                System.out.println("No recipes available.");
            } else {
                System.out.println("Recipes:");
                System.out.println("-----------------------------------");
                for (Recipe recipe : recipes) {
                    System.out.println("Recipe Name: " + recipe.getName());
                    System.out.print("Main Ingredients: ");
                    
                    // 材料を区切り文字で表示（材料の名前が連続して表示されないようにする）
                    for (int i = 0; i < recipe.getIngredients().size(); i++) {
                        Ingredient ingredient = recipe.getIngredients().get(i);
                        System.out.print(ingredient.getName());
                        
                        // 最後の材料でない場合にカンマとスペースを追加
                        if (i < recipe.getIngredients().size() - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println(); // 改行を追加
                    System.out.println("-----------------------------------");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // addNewRecipeメソッド
    private void addNewRecipe() {
        try {
            System.out.println();
            System.out.println("Adding a new name.");
            // ユーザーからレシピ名を入力受付
            System.out.print("Enter recipe name: ");
            String recipeName = reader.readLine();

            // ユーザーから材料を入力受付
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            System.out.println("Enter ingredients (type 'done' when finished):");
            while (true) {
                System.out.print("Ingredient: ");
                String ingredient = reader.readLine();
                if (ingredient.equals("done")) {
                    break;
                }
                ingredients.add(new Ingredient(ingredient));
            }
            // 入力したレシピ用のオブジェクト作成
            Recipe newRecipe = new Recipe(recipeName, ingredients);
            // 入力したレシピ書き込み
            dataHandler.writeData(newRecipe);
            System.out.println("Recipe added successfully.");
        } catch (IOException e) {
            System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }
}
