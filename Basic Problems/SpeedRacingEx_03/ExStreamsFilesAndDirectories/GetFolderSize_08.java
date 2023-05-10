package ExStreamsFilesAndDirectories;

import java.io.File;

public class GetFolderSize_08 {
    public static void main(String[] args) {
        String pathFolder = "C:\\Users\\Valentin\\Documents\\1.SoftUni\\JavaAdvance\\Streams, Files and Directories\\ExStreams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(pathFolder);

        File[] allFilesInFolder = folder.listFiles();

        int folderSize = 0;
        if (allFilesInFolder != null) {
            for (File file : allFilesInFolder) {
                folderSize += file.length();
            }
        }
        System.out.println("Folder size: " + folderSize);
    }
}
