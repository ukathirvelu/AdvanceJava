package com.in28minutes.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArraySortImpl {
	
	@Autowired
	SortAlgorithm sortAlgorithm;

	// auto wiring by constructor function
//	public ArraySortImpl(SortAlgorithm sortAlgorithm) {
//		super();
//		this.sortAlgorithm = sortAlgorithm;
//	}
	
	
	


	public int[] arraySearch(int[] numbers, int numberToSearch) {
		//int[] numArray = {1,2,3,4};
		//return 1;
		
			//		BubbleSortAlg bubbleSortAlg = new BubbleSortAlg();
			//		int[] sortedNumbers = bubbleSortAlg.sort(numbers);
			//		
			//		for (int i : sortedNumbers) {
			//			  //System.out.println(i);
			//			  }
		
		
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		
		
		return sortedNumbers;
	}
	
	
	//By Setter Injection
	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}

}
