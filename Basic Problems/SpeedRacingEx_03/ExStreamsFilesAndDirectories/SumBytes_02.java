package ExStreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\ExStreams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String input = path + "\\input.txt";

  //      List<String> allLines = Files.readAllLines(Path.of(input));
        long sum = 0;
//        for (String line : allLines){
//            for (char symbol : line.toCharArray()){
//                sum += symbol;
//            }
//        }
//        System.out.println(sum);
        byte [] allBytes = Files.readAllBytes(Path.of(input));
        for (byte ascii : allBytes){
            if (ascii != 10 && ascii != 13){
                sum += ascii;
            }
        }
        System.out.println(sum);
    }
}
