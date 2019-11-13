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

    private Instancetimer instancetimer;

    private Parent view;

    public MainAppLauncher() { this(new Instancetimer(new ArrayAnimated())); }

    private MainAppLauncher(Instancetimer instancetimer) {
        this.instancetimer = instancetimer;
    }
    public static void main(String[] args) {
        Application.launch(MainAppLauncher.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
//            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            //            stage.setWidth(primaryScreenBounds.getWidth());
//            stage.setHeight(primaryScreenBounds.getHeight());


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource("MainApp.fxml")));
            FXMLLoader loader = new FXMLLoader();
            URL location = getClass().getClassLoader()
                    .getResource("MainApp.fxml");
            loader.setLocation(location);
            view = loader.load();
            MainApp mainApp = loader.getController();
            mainApp.setInstanceTimer(instancetimer);
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Tri");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}