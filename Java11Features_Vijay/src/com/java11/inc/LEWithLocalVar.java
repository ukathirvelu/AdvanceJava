package com.java11.inc;

import java.util.Arrays;
import javax.annotation.Nonnull;

public class LEWithLocalVar {

	public static void main(String[] args) {

		// with parenthesis
		GreetingService greetService1 = (var s1, var s2) -> System.out.println("Hello " + (s1 + s2));

		// with parenthesis
		GreetingService greetService2 = (s1, s2) -> System.out.println("Hello " + (s1 + s2));

		// without parenthesis
		GreetingService greetService3 = (String s1, String s2) -> System.out.println("Hello " + (s1 + s2));

		// Limitations:
		// we cannot mix var with explicit types
		/*
		 * GreetingService greetService4 = (var
		 * s1, String s2) ->
		 * System.out.println("Hello " + (s1 +
		 * s2));
		 */

		// we cannot use var for some parameters and skip for others:
		/*
		 * GreetingService greetService5 = ( s1, var s2) -> System.out.println("Hello "
		 * + (s1 + s2));
		 */

		// Even though we can skip the parentheses in single parameter lambda
		Greeting greeting = s1 -> System.out.println(s1.toUpperCase());

		// we cannot skip them while using var:
		// Greeting greeting1 = var s1 -> System.out.println(s1.toUpperCase());
		// Greeting greeting1 = (var s1) -> System.out.println(s1.toUpperCase());

		greetService1.sayMessage("Lamdba", "-1");
		greetService2.sayMessage("Lamdba", "-2");
		greetService3.sayMessage("Lamdba", "-3");
		greeting.say("Hello");

		/*
		 * Benefit Why would we want to use var for lambda parameters when we could
		 * simply skip the types?
		 * 
		 * One benefit of uniformity is that modifiers can be applied to local variables
		 * and lambda formals without losing brevity. For example, a common modifier is
		 * a type annotation: (@Nonnull var s1, @Nullable var s2) -> s1 + s2
		 * 
		 * @Nonnull var x = new Foo(); (@Nonnull var x, @Nullable var y) -> x.process(y)
		 * We cannot use such annotations without specifying the types.
		 * 
		 * @Nonnull – The compiler can determine cases where a code path might receive a
		 * null value, without ever having a NullPointerException.
		 * 
		 * code analysers - sonar cube , find bugs
		 */

		var arrInteger = new Integer[] { 5, 9, 3, 6, 2, 4, 8, 7, 1 };
		long cnt = Arrays.stream(arrInteger).filter((@Nonnull var a) -> (a != null && a > 5)).count();
		System.out.println(cnt);
	}

	interface GreetingService {
		void sayMessage(String s1, String s2);
	}

	interface Greeting {
		void say(String s1);
	}

//https://www.dariawan.com/tutorials/java/java-11-local-variable-syntax-lambda-parameters-jep-323/

}