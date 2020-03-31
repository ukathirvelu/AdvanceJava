package com.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreams {

	/**
	 * @param args
	 */
	public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 1; i< 5; i++){
            list.add(i);
        }

        Stream<Integer> stream = list.stream();
        stream.parallel().forEach(p -> System.out.println(p));
    }
}
