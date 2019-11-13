package app;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;


public class Instancetimer {

    private static final int PERIOD_IN_MILLISECONDS = 100;
    private Timeline timeline;

    private ArrayAnimated myArray;

    public Instancetimer(ArrayAnimated myArray) {
        this.myArray = myArray;
        updateTimeline();

    }

    private void updateTimeline() {
        Duration duration = new Duration(PERIOD_IN_MILLISECONDS);
        EventHandler<ActionEvent> eventHandler = event -> next();
        KeyFrame keyFrame = new KeyFrame(duration, eventHandler);
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    private void next() {
        this.myArray.updateToNextGeneration();
    }

    public ArrayAnimated getMyArray() {
        return myArray;
    }

    public void play() {
        timeline.play();
    }

}
