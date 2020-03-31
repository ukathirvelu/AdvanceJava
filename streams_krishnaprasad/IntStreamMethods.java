package com.streams;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class IntStreamMethods {
	
	 public static void main(String[] args) 
	    { 
	        // Creating an IntStream - sum()
	        /*IntStream stream = IntStream.of(2, 4, 6, -2, -4); 
	        int sumOfElements = stream.sum(); 
	        System.out.println(sumOfElements); */
		 
		 //--mpToObj()
		 /*IntStream stream = IntStream.of(3, 5, 7, 9, 11); 
		 Stream<Long> stream1 = stream.mapToObj(Long::valueOf);
		 stream1.forEach(num -> System.out.println(num)); */
		 
		 //sorted() function 
		/* IntStream stream = IntStream.of(10, 9, 8, 7, 6);
		 stream.sorted().forEach(System.out::println); */
		 
		 // min() max() avg()
		 //IntStream stream = IntStream.of(-9, -18, 54, 8, 7, 14, 3); 
		 /*OptionalInt obj = stream.min();
		 System.out.println("min value:"+obj.getAsInt());*/
		 
		 /*OptionalInt obj1 = stream.max(); 
		 System.out.println("max value:"+obj1.getAsInt());*/
		 
		 /*OptionalDouble  obj = stream.average(); 
		 System.out.println("average value:"+obj.getAsDouble());*/
		 
		 //anyMatch
		 /*IntStream stream = IntStream.of(10, 20, 30, 40, 50, 81);
		 boolean answer = stream.anyMatch(num -> Math.sqrt(num) > 8);
		 System.out.println("findAny:"+answer);*/
		 
		// Check if all elements of stream  are divisible by 3 or not
		 IntStream stream = IntStream.of(3, 5, 9, 12, 14); 
		 boolean answer = stream.allMatch(num -> num % 3 == 0); 
		 System.out.println(answer); 
	    } 

}
