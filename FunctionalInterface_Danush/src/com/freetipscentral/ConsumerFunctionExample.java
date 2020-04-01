package com.freetipscentral;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
public class ConsumerFunctionExample{
  public static void main(String args[]){
    Consumer<Integer> consumer= i-> System.out.print(" "+i);
    List<Integer> integerList=Arrays.asList(1,10,200,101,9);
    printList(integerList, consumer);
 }
 public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer){
  for(Integer integer:listOfIntegers){
	  //The accept() method which works as per the lambda definition assigned to
	  //the consumer interface, i.e. i-> System.out.print(" "+i) , 
	  //prints out the value of each integer
    consumer.accept(integer);
  }
 }
}
