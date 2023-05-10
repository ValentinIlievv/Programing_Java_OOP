package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine_05 {
    public static <e> void main(String[] args)  {
        String path = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources";
        String input = path + "\\input.txt";
        String output = path + "\\05.WriteEveryThirdLineOutput.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(input));
           PrintStream writer = new PrintStream(new FileOutputStream(output))) {


               int count = 1;
               String line = reader.readLine();
               while(line != null) {


                   if (count % 3 == 0) {
                       writer.println(line);
                   }

                   line = reader.readLine();
                   count++;
               }
           }
           catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
