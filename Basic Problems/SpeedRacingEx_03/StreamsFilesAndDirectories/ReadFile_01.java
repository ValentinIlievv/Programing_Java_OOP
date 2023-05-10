package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile_01 {
    public static void main(String[] args) {
        String path = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\input.txt";

        try {
            FileInputStream fileStream = new FileInputStream(path);

            int oneByte = fileStream.read();

            while (oneByte >= 0){
                System.out.printf("%s ",Integer.toBinaryString(oneByte));

                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
