package com.java11.inc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

/* Changes in java.nio.file.Files
 * To read from a large file, I normally using BufferedReader combined with FileReader. 
 * And to write to "large" file, I will use BufferedWriter combined with FileWriter. 
 * But, let's think about a simple case where actually the file is simply can be handle as a simple String
 * 
 * String readString(Path): Reads all content from a file into a string, decoding from bytes to 
   characters using the UTF-8 charset.
 * String readString(Path, Charset): As above, except decoding from bytes to characters using the 
   specified Charset.
 * Path writeString(Path, CharSequence, java.nio.file. OpenOption[]):Write a CharSequence to a file. 
   Characters are encoded into bytes using the UTF-8 charset.
 * Path writeString(Path, CharSequence, java.nio.file. Charset, OpenOption[]): 
   As above, except Characters are encoded into bytes using the specified Charset.
 * OutofMemoryError if size>2GB
 * */

public class ReadAndWriteString {
	
	static Path createTempPath() throws IOException {
        Path tempPath = Files.createTempFile("readwrite", ".txt");
        File tempFile = tempPath.toFile();
        tempFile.deleteOnExit();
        
        return tempPath;
    }
	public static void main(String[] args) {
		
		String testString = "Add Line using write String";
        try {
			Path path1 = Files.writeString(createTempPath(), testString);
			System.out.println("String written to file: " + path1);
	        System.out.println("Read the Added line : " + Files.readString(path1)); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Charset charset = Charset.forName("ISO-8859-3");
		try {
			Path path2 = Files.writeString(createTempPath(), testString, charset);
			System.out.println("Charset :: String written to file: " + path2);
	        String s = Files.readString(path2, charset);
	        System.out.println("Charset :: Read the Added line : " + s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
