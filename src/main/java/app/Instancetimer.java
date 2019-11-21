package app;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import viewer.MainApp;

public class Instancetimer {

    private static final int PERIOD_IN_MILLISECONDS = 250;
    private Timeline timeline;
    private ArrayAnimated myArray;
    private MainApp mainApp;


    public Instancetimer(ArrayAnimated myArray) {
        this.myArray = myArray;
        updateTimeline();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        this.play();
    }

    private void updateTimeline() {
        Duration duration = new Duration(PERIOD_IN_MILLISECONDS);
        EventHandler<ActionEvent> eventHandler = event -> next();
        KeyFrame keyFrame = new KeyFrame(duration, eventHandler);
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);

    }

    private void next() {
        System.out.println("Appel de next()");

        this.myArray.updateToNextGeneration();
        this.mainApp.refresh();

    }

    public MainApp getMainApp() {
        return mainApp;
    }

    public ArrayAnimated getMyArray() {
        return myArray;
    }

    public void play() {
        timeline.play();
    }

}
