package com.recipeapp.model;

public class Ingredient {
    // フィールド
    private String name; // 材料の名前

    // コンストラクタ
    public Ingredient(String name) {
        this.name = name;
    }

    // getNameメソッド
    public String getName() {
        return this.name;
    }
}
