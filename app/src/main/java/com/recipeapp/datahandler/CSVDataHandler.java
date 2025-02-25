package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    // フィールド
    private String filePath; // レシピデータを格納するCSVファイルのパス。

    // コンストラクタ(引数なし)
    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }
    // コンストラクタ（引数あり）
    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override // getModeメソッド
    public String getMode() {
        return "CSV";
    }

    @Override // readDataメソッド
    public ArrayList<Recipe> readData() throws IOException {
        // レシピを格納するリスト
        ArrayList<Recipe> recipes = new ArrayList<>();
        // CSVファイルを開く
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                // 1行ずつ読み込んで、レシピ名と材料を分ける
                String[] data = line.split(",", 2);  // カンマで分割して、名前と材料に分ける
                
                // レシピ名と材料のリストを取得
                String recipeName = data[0];
                String ingredientsData = data[1];
                
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                
                // 材料をカンマ区切りで分割
                String[] ingredientList = ingredientsData.split(",");
                for (String ingredientName : ingredientList) {
                    // Ingredientオブジェクトを作成して、リストに追加
                    Ingredient ingredient = new Ingredient(ingredientName.trim());
                    ingredients.add(ingredient);
                }
                
                // Recipeオブジェクトを作成し、リストに追加
                Recipe recipe = new Recipe(recipeName, ingredients);
                recipes.add(recipe);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    
        return recipes;
    }

    @Override // writeDataメソッド
    public void writeData(Recipe recipe) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            // レシピ名と材料をCSV形式で書き込む
            writer.append(recipe.getName());
            for (Ingredient ingredient : recipe.getIngredients()) {
                writer.append(", ").append(ingredient.getName());
            }
            writer.append("\n"); // 新しい行を追加
        } catch (IOException e) {
            throw new IOException("Error writing data to file: " + e.getMessage());
        }
    }

    @Override // searchDataメソッド
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }
}
