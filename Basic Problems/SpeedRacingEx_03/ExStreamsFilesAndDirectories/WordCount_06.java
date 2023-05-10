package ExStreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {
        String pathWords = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\ExStreams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";

        List<String> wordsList = Files.readAllLines(Path.of(pathWords));

        Map<String, Integer> countWords = new HashMap<>();

        for (String line : wordsList ){

            String[] wordsOnCurrentRow = line.split("\\s+");
            Arrays.stream(wordsOnCurrentRow).forEach(word -> countWords.put(word, 0));
        }

        String textPath = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\ExStreams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        List<String> textLines = Files.readAllLines(Path.of(textPath));

        for (String line : textLines){

            line = line.replaceAll("[\\,\\.\\!\\?\\:]", "");

            String[] wordsArr = line.split("\\s+");
            for (String word : wordsArr){
                if (countWords.containsKey(word)){
                    countWords.put(word, countWords.get(word) + 1);
                }
            }
        }
        String output = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\ExStreams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt.txt";
        PrintWriter writer = new PrintWriter(output);

        countWords.entrySet().stream().sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue())).
                forEach(word -> writer.println(word.getKey() + " - " + word.getValue()));

        writer.close();

    }
}
