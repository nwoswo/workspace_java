package searchFiles;

import java.io.File;
import java.io.FilenameFilter;

public class Pathnames2 {
    public static void main(String args[]) {

        // try-catch block to handle exceptions
        try {
            File f = new File("F:\\Node5Gen");

            FilenameFilter filter = new FilenameFilter() {

                public boolean accept(File f, String name) {
                    // We want to find only .c files
                    return name.startsWith("4-server-monolitica");
                }
            };

            // Note that this time we are using a File class as an array,
            // instead of String
            File[] files = f.listFiles(filter);

            // Get the names of the files by using the .getName() method
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}