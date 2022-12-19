package Homework1;

public class Main {
    public static void main(String[] args) {

        CommonResource commonResource = new CommonResource();

        commonResource.printData();
        Thread first = new Thread(new ThreadForCalculate(commonResource));
        Thread second = new Thread(new ThreadForCalculate(commonResource));
        Thread third = new Thread(new ThreadForCalculate(commonResource));
        Thread four = new Thread(new ThreadForCalculate(commonResource));
        first.start();
        second.start();
        third.start();
        four.start();
        try{
            first.join();
            second.join();
            third.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        commonResource.printData();

    }
}
