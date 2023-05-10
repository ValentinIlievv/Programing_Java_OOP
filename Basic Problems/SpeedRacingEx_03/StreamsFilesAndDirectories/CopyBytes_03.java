package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes_03 {
    public static void main(String[] args) {
        String path = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources";
        String input = path + "\\input.txt";
        String output = path + "\\03.CopyBytesOutput";

        try {
            FileInputStream inputStream = new FileInputStream(input);
            FileOutputStream outputStream = new FileOutputStream(output);

            int oneByte = inputStream.read();

            while (oneByte >= 0){

                if (oneByte == 10 || oneByte == 32){
                    outputStream.write(oneByte);
                }else {
                    String digit = String.valueOf(oneByte);
                    for (int i = 0; i < digit.length(); i++) {
                        outputStream.write(digit.charAt(i));

                    }
                }

                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
