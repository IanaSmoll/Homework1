package Homework1;
//Один из них записывает данные в файл каждые 10 изменений данных в общем массиве и работает бесконечно.

import java.io.FileOutputStream;
import java.io.IOException;

public class File {

    String[] array;

    public void file(){
        try {
            FileOutputStream fos = new FileOutputStream("/Users/anasmolickaa/Documents/Java/2. Homework/src/main/java/Homework1/file.txt");
            for (int i = 0; i < array.length; i++) {
                byte[] buffer = array[i].getBytes();
                fos.write(buffer, 0, buffer.length);
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
