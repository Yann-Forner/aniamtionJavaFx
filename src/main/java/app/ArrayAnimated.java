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
        }else{
            int temp = position;
            for (int i = position; i >=0; i--) {
                if(this.myList.get(i)>=this.myList.get(position)) {
//                    System.out.println(this.myList.get(temp)+"<="+this.myList.get(i)+"<="+this.myList.get(position));
                    temp=i;
                }
            }
            this.shift(position,temp);
        }
        ++position;
    }

    public void shift(int cible, int position){
        if(cible!=position){
            Integer temp = this.myList.get(cible);
            this.myList.remove(cible);
            this.myList.add(position, temp);
        }

    }

    public Integer getPosition() {
        return position;
    }

    public void switchItems(int index1, int index2){
        Integer temp= this.myList.get(index1);
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
