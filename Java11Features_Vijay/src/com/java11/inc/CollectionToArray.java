/**
 * 
 */
package com.java11.inc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kvijayakumar
 *
 */
public class CollectionToArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
List<Integer> list = List.of(1, 2, 3, 4, 5);
        
        Integer[] array1 = list.toArray(Integer[]::new);
        System.out.println(Arrays.toString(array1));
        
        Set<Integer> hset1 = new LinkedHashSet<>(list);
        hset1.remove(1);
        Integer[] array2 = hset1.toArray(Integer[]::new);
        System.out.println(Arrays.toString(array2));
        
        Set<Country> hset2 = new HashSet<>();
        hset2.add(new Country("ID", "Indonesia"));
        hset2.add(new Country("SG", "Singapore"));
        hset2.add(new Country("MY", "Malaysia"));
        Country[] array3 = hset2.toArray(Country[]::new);
        System.out.println(Arrays.toString(array3));
    }
    
     static class Country {
        String code;
        String name;

		  @Override 
		  public String toString() { return "Country [code=" + code +
		  ", name=" + name + "]"; }
		 

		Country(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }
	}


