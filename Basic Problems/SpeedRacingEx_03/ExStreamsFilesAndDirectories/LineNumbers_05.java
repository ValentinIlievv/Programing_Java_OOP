package ExStreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\ExStreams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String output = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\ExStreams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputLineNumbers.txt";
        File newFile = new File(output);


       List<String> allLines = Files.readAllLines(Path.of(path));

        PrintWriter writer = new PrintWriter(newFile);
        int lineNumber = 1;
        for (String line : allLines){
            writer.println(lineNumber + ". " + line);
            lineNumber++;
        }
        writer.close();


    }
}
