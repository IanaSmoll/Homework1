package Homework1;

public class CommonResource {
    private dataCell[] data;
    int jobs;
    int countOfRead;

    CommonResource() {
        fillData();
        jobs = 0;
        countOfRead = 0;
    }

    private void fillData() {
        data = new dataCell[50];
        for (int i = 0; i < data.length; i++) {
            char character = data[i].toString().charAt(i);
            int iscii = (int) character;
            iscii = (int) (Math.random() * 127);
            data[i] = new dataCell(i, Character.toString(character));
        }
    }

    CommonResource(dataCell[] data) {
        this.data = data;
        jobs = 0;
        countOfRead = 0;
    }

    synchronized dataCell[] getValue() {
        int random = (int)(Math.random() * 5);
        for (int i = 0; i < data.length; i++) {
            char character = data[i].data.charAt(i);
            int iscii = (int) character;
            if((iscii + random) < 127){
                iscii = iscii + random;
            }
        }
            return data;
    }

    synchronized void jobDone() {
        jobs++;
    }

    synchronized dataCell[] getAllData() {
        dataCell[] tmpData = new dataCell[data.length];
        for (int i = 0; i < data.length; i++) {
            tmpData[i] = new dataCell(data[i].pos, data[i].data);
        }
        return tmpData;
    }

    void printData() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i].data + " ");
            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    boolean canDo() {
        return countOfRead < data.length;
    }

    class dataCell {
        public int pos;
        String data;

        public dataCell(int pos, String data) {
            this.pos = pos;
            this.data = data;
        }
    }
}
