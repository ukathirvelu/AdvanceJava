package com.streams;

import java.util.stream.IntStream;

public class IntStreamTest {

	public static void main(String[] args) 
	{
		//Range
		IntStream stream = IntStream.range(7, 10); 
		System.out.println("range()--");
		stream.forEach(System.out::println );	//5,6,7,8,9
		
		//Closed Range
		IntStream closedRangeStream = IntStream.rangeClosed(7, 10); 
		System.out.println("rangeClosed()--");
		closedRangeStream.forEach( System.out::println );	//5,6,7,8,9,10
	}
}
