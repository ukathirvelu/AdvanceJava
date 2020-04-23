package com.in28minutes.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlg  implements SortAlgorithm{
	
	public int[] sort(int[] numbers) {
		
		int[] sortedNumber = {5,6,7,8};
		numbers  = sortedNumber;
		return numbers;
	}


}
