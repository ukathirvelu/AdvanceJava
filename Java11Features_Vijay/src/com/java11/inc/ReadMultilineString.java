package com.java11.inc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadMultilineString {

	public static void main(String[] args) {
		
		var classLoader = ClassLoader.getSystemClassLoader();
		var url = classLoader.getResource("testfile.txt");
        //var url = classLoader.getResource("sample.xlsx");
        
		try {
			Path path = Path.of(url.toURI());
			System.out.println("URL Path : "+ path);
	        System.out.println("File Exits: "+ Files.exists(path));
	        System.out.println("Read data as String : "+ Files.readString(path));
	        
	        System.out.println("Read data as List<String> : "+ Files.readAllLines(path));
	        
	        System.out.println("Read file size : "+ Files.size(path)+" bytes");

		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
