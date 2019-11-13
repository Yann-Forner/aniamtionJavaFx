package viewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.Objects;

public class MainAppLauncher extends Application {

    public static void main(String[] args) {
        Application.launch(MainAppLauncher.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
//            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource("MainApp.fxml")));
            primaryStage.setScene(new Scene(root));
//            stage.setWidth(primaryScreenBounds.getWidth());
//            stage.setHeight(primaryScreenBounds.getHeight());
            primaryStage.setTitle("Test");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}