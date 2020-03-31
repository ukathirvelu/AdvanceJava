package com.streams;

import java.util.ArrayList;
import java.util.List;

public class VerifyStreamRunningMode {
	
	public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 1; i< 5; i++){
            list.add(i);
        }

        System.out.println(list.stream().isParallel());
        
        System.out.println(list.stream().parallel().isParallel());
    }

}
