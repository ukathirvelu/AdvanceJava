package com.freetipscentral;

public class MyRunnableTester {

	public static void main(String[] args) {
		//With Anonymous Class
		MyRunnable runnable = new MyRunnable(){
			@Override
			public void run() {
				System.out.println("Hello My Runnable");
			}
		};
		
		//With Lambda Expression 
		MyRunnable runnable1 = 
			() -> { System.out.println("Hello My Runnable");
		};
		
		
		Thread myThread = new Thread(runnable);
		myThread.start();
	}

}
