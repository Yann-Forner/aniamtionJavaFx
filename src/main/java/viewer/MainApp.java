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
        this.instance = new Instancetimer(new ArrayAnimated());
        this.instance.setMainApp(this);
        render();

    }

    public void refresh(){
        render();
    }

    public void setInstanceTimer(Instancetimer timer){
        this.instance = timer;
        render();
    }


    public void render(){
        canvas.setWidth(1000);
        canvas.setHeight(500);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();


        PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        try {
            for (int i = 0; i < canvas.getWidth() ; i++) {
                for (int j = 0; j <  canvas.getHeight(); j++) {
                    pixelWriter.setColor(i,j,Color.WHITE);
                }
            }
            for (int i = 0; i < canvas.getWidth() ; i+=5) {
                rectTracer(pixelWriter,i);
            }
        }catch (NullPointerException e){
            System.out.println("RATé");
        }




    }

    private void rectTracer(PixelWriter pixelWriter,int x){
        for (int y =(int) this.canvas.getHeight(); y >=(int) this.canvas.getHeight() - this.instance.getMyArray().get(x/5) ; y--) {
            pixelWriter.setColor(x,y,Color.BLACK);
            pixelWriter.setColor(x+4,y,Color.BLACK);
            if( this.instance.getMyArray().getPosition()!=null && x/5 == this.instance.getMyArray().getPosition()){
                pixelWriter.setColor(x+1,y,Color.GREEN);
                pixelWriter.setColor(x+2,y,Color.GREEN);
                pixelWriter.setColor(x+3,y,Color.GREEN);
            }
            if(y==(int) this.canvas.getHeight() - this.instance.getMyArray().get(x/5)){
                pixelWriter.setColor(x+1,y,Color.BLACK);
                pixelWriter.setColor(x+2,y,Color.BLACK);
                pixelWriter.setColor(x+3,y,Color.BLACK);
            }
        }
    }
}
