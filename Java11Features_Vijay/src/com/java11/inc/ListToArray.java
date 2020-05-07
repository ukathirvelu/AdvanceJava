package com.java11.inc;

import java.util.Arrays;
import java.util.List;

public class ListToArray {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Doc", "Grumpy", "Happy", 
                "Sleepy", "Dopey", "Bashful", "Sneezy");
        
        System.out.println("List to Array example in Java 8:");
        
        Object[] objects = list.toArray();
        System.out.println("Object type: ::" + Arrays.toString(objects));
        
        String[] array = list.toArray(new String[list.size()]);
        System.out.println("List Type setting the size ::"+ Arrays.toString(array));
        
     // new method
        String[] array2 = list.toArray(String[]::new);
        //:: method reference operattor a static method, an instance method, or a constructor.
        System.out.println("Using Java11 toArray Default method:" + Arrays.toString(array2));

	}

	//https://www.dariawan.com/tutorials/java/java-11-convert-collection-array/
}
