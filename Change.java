package Homework1;


import java.util.Random;

public class Change{

    String[] array;

    public String[] increase(String[] array){

        int random = (int)(Math.random() * 5);
        for (int i = 0; i < array.length; i++) {
            char character = array[i].charAt(i);
            int iscii = (int) character;
                if ((iscii + random) < 91) {
                    iscii = iscii + random;
                }
            }
        return array;
    }
}
