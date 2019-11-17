package app;

import java.util.ArrayList;
import java.util.Random;

public class ArrayAnimated  {
    private ArrayList<Integer> myList = new ArrayList<>(0);
    private Integer position;

    public ArrayAnimated() {
        for (int i = 0; i <200 ; i++) {
           myList.add(new Random().nextInt(450));
        }

    }
    public Integer get(int index){
        return this.myList.get(index);
    }
    public void updateToNextGeneration(){
        if (position == null){
            position=0;
        }
        ++position;

    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Integer elem: this.myList
             ) {
            str.append(elem);
        }
        return str.toString();
    }
}
