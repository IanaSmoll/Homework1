package Homework1;

public class ThreadForCalculate implements Runnable {
    private CommonResource commonResource;

    public ThreadForCalculate(CommonResource commonResource){
        this.commonResource = commonResource;
    }

    @Override
    public void run() {
        while (commonResource.canDo()) {

            if (commonResource.canDo()) {

                System.out.println(Thread.currentThread().getName() + " - " + commonResource.getValue());
                commonResource.jobDone();
            }
            try {
                Thread.sleep((long) Math.random() * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " was end");
    }
}
