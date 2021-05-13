package searchFiles;

import java.io.File;
import java.io.FilenameFilter;

public class Pathnames {
	
	String[] pathnames;
	 File f = new File("F:\\Node5Gen");
    public void method1() {
        // Creates an array in which we will store the names of files and directories
        

        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
       
        pathnames = f.list();
        
    }
    
    void print() {
    	// Populates the array with names of files and directories
        

        // For each pathname in the pathnames array
        for (String pathname : pathnames) {
            // Print the names of files and directories
            System.out.println(pathname);
        }
    }
    
    void method2() {
    	

    	// This filter will only include files ending with .py
    	FilenameFilter filter = new FilenameFilter() {
    	        public boolean accept(File f, String name) {
    	            return name.startsWith("4-server-monolitica");
    	        }
    	    };

    	// This is how to apply the filter
    	pathnames = f.list(filter);
    }
    
    public static void main(String args[]) {
    	Pathnames path = new Pathnames();
    	path.method2();
    	path.print();
    }
}