package com.in28minutes.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
		SpringApplication.run(Application.class, args);
		
		//QuickSortAlg  quickSort = applicationContext.getBean(QuickSortAlg.class);
		
		ArraySortImpl  arraySr = applicationContext.getBean(ArraySortImpl.class);
		
		//ArraySortImpl  arraySr = new ArraySortImpl(new QuickSortAlg());
		//int[] result = arraySr.arraySearch(new int[] {11,22,33,44}, 3);
		
		int[] result = arraySr.arraySearch(new int[] {11,22,33,44}, 3);
		for (int i : result) {
			  System.out.println(i);
			  }
		
//		for ( String name : applicationContext.getBeanDefinitionNames())
//		{
//			 System.out.println(name);
//		}
	}

}

