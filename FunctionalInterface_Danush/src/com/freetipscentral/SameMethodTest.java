package com.freetipscentral;

interface Test {
	void display();
	default void show() {
		System.out.println("show from Test");
	}
}
//Another interface with same show method

interface AnotherTest {
	void display();
	default void show() {
		System.out.println("show from Test");
	}

}
//Main class to implement above two interfaces

//class SameMethodTest implements Test, AnotherTest{
//here is an ambiguity which show method has to inherit here
//}

//This class wont compile because there is an ambiguity between Test, AnotherTest interfaces show() method, to resolve this we need to override show() method to Main Class.

class SameMethodTest implements Test, AnotherTest {
public static void main(String[] args) {
	SameMethodTest smt = new SameMethodTest();
	smt.show();
	smt.display();
}
	public void show() {
		System.out.println("Main show method");
	}
	public void display() {
		 System.out.println("display method");
		
	}

}