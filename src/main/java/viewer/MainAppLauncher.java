package viewer;

import app.ArrayAnimated;
import app.Instancetimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class MainAppLauncher extends Application {

    private static final String VIEW_RESOURCE_PATH = "MainApp.fxml";

    private Parent view;


    public static void main(String[] args) {
        Application.launch(MainAppLauncher.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource("MainApp.fxml")));

            FXMLLoader loader = new FXMLLoader();

            URL location = getClass().getClassLoader()
                    .getResource("MainApp.fxml");
            loader.setLocation(location);
            view = loader.load();

            MainApp mainApp = loader.getController();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Tri");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}