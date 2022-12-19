package Homework1;
//Один из них записывает данные в файл каждые 10 изменений данных в общем массиве и работает бесконечно.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadForWorkFile implements Runnable {

    private CommonResource commonResource;
    private int countOfBackup;

    public ThreadForWorkFile(CommonResource commonResource) {
        this.commonResource = commonResource;
        countOfBackup = 0;
    }

    @Override
    public void run() {
        String wayToFile = "src/tmp";

        File directory = new File(wayToFile);
        if (!directory.exists()) {
            System.out.println("The folder rc/tmp is not exist.Creating...");
            directory.mkdir();
        }
        wayToFile += "/file";

        int counterToClose = 0;
        while (true) {
            System.out.println(commonResource.jobs);
            if (counterToClose >= 10) {
                System.out.println("Closing work-with-file thread...");
                break;
            }
            if (commonResource.jobs >= 10) {
                wayToFile += countOfBackup++;
                writeToFile(wayToFile);
                commonResource.jobs -= 10;
                wayToFile = "src/tmp/file";
                counterToClose = 0;
            } else {
                counterToClose++;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void writeToFile(String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            System.out.println("Start write to file " + fileName);
            String res = "";
            CommonResource.dataCell[] data = commonResource.getAllData();
            for (int i = 0; i < data.length; i++) {
                res += data[i].data;
                res += "_";
                if (i % 10 == 0 && i != 0) {
                    res += "\r";
                }
            }
            fileWriter.write(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("End write to file " + fileName);
    }
}


            /*FileOutputStream fos = new FileOutputStream("/Users/anasmolickaa/Documents/Java/2. Homework/src/main/java/Homework1/file.txt");
            for (int i = 0; i < data.length; i++) {
                byte[] buffer = data[i].getBytes();
                fos.write(buffer, 0, buffer.length);
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}*/
