package ExStreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

public class ALL_CAPITALS_03 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\ExStreams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String output = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\ExStreams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));

        List<String> allLines = Files.readAllLines(Path.of(path));
        for (String line : allLines){
            writer.write(line.toUpperCase(Locale.ROOT));
            writer.newLine();
        }
        writer.close();

    }
}
