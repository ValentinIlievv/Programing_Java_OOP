package ExStreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\ExStreams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String input = path + "\\input.txt";

        List<String> allLines = Files.readAllLines(Path.of(input));

        for (String line : allLines){
            int sum = 0;

            for (char symbol : line.toCharArray()){
                sum += (int)symbol;
            }
            System.out.println(sum);
        }


    }
}
