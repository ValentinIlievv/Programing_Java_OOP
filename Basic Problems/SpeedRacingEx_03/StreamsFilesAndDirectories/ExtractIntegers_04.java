package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources";
        String input = path + "\\input.txt";
        String output = path + "\\04.ExtractIntegersOutput";


        Scanner reader = new Scanner(new FileInputStream(input));
        PrintStream writer = new PrintStream(new FileOutputStream(output));

        while (reader.hasNext()){
            if (reader.hasNextInt()){
                writer.println(reader.nextInt());
            }
            reader.next();
        }
    }
}
