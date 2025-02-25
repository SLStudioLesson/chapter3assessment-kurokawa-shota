package com.recipeapp.datahandler;

import java.util.ArrayList;
import java.io.IOException;
import com.recipeapp.model.Recipe;

public interface DataHandler {
    // getModeメソッド
    public String getMode();

    // readDataメソッド
    public ArrayList<Recipe> readData() throws IOException;

    // writeDataメソッド
    public void writeData(Recipe recipe) throws IOException;

    // searchDataメソッド
    public ArrayList<Recipe> searchData(String keyword) throws IOException;
}
