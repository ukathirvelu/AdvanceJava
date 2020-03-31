package com.streams;

import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;

public class DoubleStreamDemo {
	
	public static void main(String[] args) {
		System.out.println("--Using DoubleStream.of--");
		DoubleStream.of(5.33,2.34,5.32,2.31,3.51).map(d->d*1.5).forEach(s->System.out.print(s +" "));
		
		
		System.out.println("\n--Using DoubleStream.average--");
		double val = DoubleStream.of(12.1,11.2,13.3).average().getAsDouble();
		System.out.println(val);
		
		
		System.out.println("--Using DoubleStream.max--");
		val = DoubleStream.of(12.1,11.2,13.3).max().getAsDouble();
		System.out.println(val);
		
		
		System.out.println("--Using DoubleStream.filter--");
		DoublePredicate range = d -> d > 12.11 && d < 12.99;		
		DoubleStream.of(12.1,11.2,12.3).filter(range).forEach(d->System.out.print(d));
	}

}
