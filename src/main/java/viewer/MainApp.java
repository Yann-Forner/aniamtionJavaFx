package viewer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class MainApp implements Initializable {
    @FXML
    private Canvas canvas;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        render();
    }


    private void render(){
        canvas.setWidth(600);
        canvas.setHeight(400);



        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        PixelWriter pixelWriter = graphicsContext.getPixelWriter();


        for (int i = 0; i < canvas.getWidth() ; i++) {
            for (int j = 0; j <  canvas.getHeight(); j++) {
                pixelWriter.setColor(i,j, Color.ORANGE);
            }
        }

    }
}
