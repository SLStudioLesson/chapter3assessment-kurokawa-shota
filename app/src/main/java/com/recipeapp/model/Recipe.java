package com.recipeapp.model;

import java.util.ArrayList;

public class Recipe {
    // フィールド
    private String name; // レシピの名前
    private  ArrayList<Ingredient> ingredients; // レシピの材料リスト

    // コンストラクタ
    public Recipe(String name, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    // getNameメソッド
    public String getName() {
        return this.name;
    }

    // getIngredientsメソッド
    public ArrayList<Ingredient> getIngredients() {
        return this.ingredients;
    }
}
