package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
        ArrayList<Recipe> recipes = new ArrayList<>();
        ArrayList<String> recipes1 = new ArrayList<>();

        // recipeをString型に変換してrecipes1に格納
        for (Recipe recipe : recipes) {
            recipes1.add(recipe.toString());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // CSVファイルから行を1行ずつ読み込む
            while ((line = reader.readLine()) != null) {
                recipes1.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: 例外のメッセージ");
        }
        return recipes;
    }

    @Override // writeDataメソッド
    public void writeData(Recipe recipe) throws IOException {

    }

    @Override // searchDataメソッド
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }
}
