package com.in28minutes.demo;

import org.springframework.stereotype.Component;

@Component
public interface SortAlgorithm {
	
	public int[] sort(int[] numbers);
	
}
