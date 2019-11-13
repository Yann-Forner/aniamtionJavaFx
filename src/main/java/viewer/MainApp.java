package viewer;

import app.ArrayAnimated;
import app.Instancetimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainApp implements Initializable {
    @FXML
    private Canvas canvas;

    private Instancetimer instance;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        render();
    }



    public void setInstanceTimer(Instancetimer timer){
        this.instance = timer;
    }


    private void render(){
        canvas.setWidth(600);
        canvas.setHeight(400);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        PixelWriter pixelWriter = graphicsContext.getPixelWriter();




    }
}
