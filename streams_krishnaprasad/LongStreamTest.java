package com.streams;

import java.util.stream.LongStream;

public class LongStreamTest {
	
    public static void main(String[] args) 
    { 
    	LongStream stream = LongStream.range(6L, 10L); 
        stream.forEach(System.out::println);
        System.out.println("==============");
        
        LongStream stream1 = LongStream.rangeClosed(6L, 10L);
        stream1.forEach(System.out::println);
    } 
} 
