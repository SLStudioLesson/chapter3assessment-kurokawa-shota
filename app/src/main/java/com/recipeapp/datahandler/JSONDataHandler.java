package com.recipeapp.datahandler;

import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Recipe;

public class JSONDataHandler implements DataHandler {
    @Override // getModeメソッド
    public String getMode() {
        return "JSON";
    }

    @Override // readDataメソッド
    public ArrayList<Recipe> readData() throws IOException {
        return null;
    }

    @Override // writeDataメソッド
    public void writeData(Recipe recipe) throws IOException {

    }

    @Override // searchDataメソッド
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }
}
