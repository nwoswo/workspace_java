package searchFiles;

import java.io.File;
import java.io.FilenameFilter;

public class ListFilesRecursively {
	
    public void listFiles(String startDir) {
        File dir = new File(startDir);
        File[] files = dir.listFiles();

        if (files != null && files.length > 0) {
            for (File file : files) {
                // Check if the file is a directory
                if (file.isDirectory()) {
                    // We will not print the directory name, just use it as a new
                    // starting point to list files from
                    //listDirectory(file.getAbsolutePath());
                	
                	System.out.println(file.getName() + " (size in bytes: " + file.length()+")");
                } else {
                    // We can use .length() to get the file size
                    System.out.println(file.getName() + " (size in bytes: " + file.length()+")");
                }
            }
        }
    }
    public static void main(String[] args) {
        ListFilesRecursively test = new ListFilesRecursively();
        String startDir = ("F:\\Node5Gen");
        test.listFiles(startDir);
    }
}