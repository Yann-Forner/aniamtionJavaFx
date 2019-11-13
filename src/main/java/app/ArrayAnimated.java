package app;

import java.util.ArrayList;

public class ArrayAnimated  {
    private ArrayList<Integer> myList = new ArrayList<>(0);
    private int position=0;

    public ArrayAnimated() {
        for (int i = 0; i <500 ; i++) {
            myList.add(i);
        }
    }
    public void updateToNextGeneration(){

    }
}
