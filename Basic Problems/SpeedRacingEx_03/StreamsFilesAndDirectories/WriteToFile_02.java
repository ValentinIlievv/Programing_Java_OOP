package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteToFile_02 {
    public static void main(String[] args) {

        String path = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources";
        String input = path + "\\input.txt";
        String output = path + "\\02.WriteToFileOutput";


        try {
            FileInputStream inputStream = new FileInputStream(input);
            FileOutputStream outputStream = new FileOutputStream(output);

            int oneByte = inputStream.read();
            List<Character> list = Arrays.asList(',','.','!', '?');
            while (oneByte >= 0){

                if (!list.contains((char)oneByte)){
                    outputStream.write(oneByte);
                }

                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
