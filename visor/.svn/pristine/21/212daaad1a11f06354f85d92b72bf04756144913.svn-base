package searchFiles;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

public class Test {
    public static void main(String[] args) {
        File root = new File("F:\\\\Node5Gen");
        String fileName = "tsconfig.json";
        try {
            boolean recursive = true;

            Collection files = FileUtils.listFiles(root, null, recursive);

            for (Iterator iterator = files.iterator(); iterator.hasNext();) {
                File file = (File) iterator.next();
                if (file.getName().equals(fileName))
                    System.out.println(file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}