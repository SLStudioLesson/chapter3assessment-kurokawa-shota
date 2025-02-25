import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();

            DataHandler dataHandler;
            
            switch (choice) {
                case "1":
                    // 「1」を選択した場合、`CSVDataHandler`インスタンスを生成
                    dataHandler = new CSVDataHandler();
                    break;
                case "2":
                    // 「2」を選択した場合、`JSONDataHandler`インスタンスを生成
                    dataHandler = new JSONDataHandler();
                    break;
                default:
                    // 不正な入力（「1」「2」以外）が与えられた場合、`CSVDataHandler`インスタンスを生成
                    dataHandler = new CSVDataHandler();
                    break;
            }

            // 選択されたデータハンドラーをRecipeUIに渡し、displayMenuメソッドを呼び出す
            RecipeUI recipeUI = new RecipeUI(dataHandler);
            recipeUI.displayMenu();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}