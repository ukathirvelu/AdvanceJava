package com.java11.inc;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

/* Changes in java.nio.file.Path
 * Path of(String, String[]): Returns a Path by converting a path string, 
 * or a sequence of strings that when joined form a path string. 
 * The Path is obtained by invoking the getPath method of the default FileSystem.
 * 
 * Path of(net.URI): Returns a Path by converting a URI.
 * */
public class PathOf {

	public static void main(String[] args) {
		
		String tempFolder = System.getProperty("java.io.tmpdir");
		System.out.println("tempFolder+++:" + tempFolder);
		// Create Path from a sequence of Strings
        Path path1 = Path.of(tempFolder, "test.txt");
        System.out.println(path1);        
        System.out.println(Files.exists(path1));
        
        File file = new File(path1.toString());
        //Create the file
        try {
			if (file.createNewFile()) {
			    System.out.println("File is created!");
			} else {
			    System.out.println("File already exists.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String uriFullPath = "file:///" + tempFolder.replace("\\", "/") + "test.txt";
        URI uri = URI.create(uriFullPath);
        System.out.println("URI Path::"+uri);
      
        // Create Path from a URI
        Path path2 = Path.of(uri);
        System.out.println(path2);
        System.out.println(Files.exists(path2));

	}

}
