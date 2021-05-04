package com.wiley.divideAndConquer;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MergeSortLinkedList {
	
		static List<Integer> sort(List<Integer> unsorted) {
			int size = unsorted.size();
			if (size == 1) {
				return unsorted;
			} else {
				List<Integer> first = unsorted.subList(0, size/2);
				List<Integer> second = unsorted.subList(size/2, size);
				return merge(sort(first), sort(second));
			}
		}
		
		static List<Integer> merge(List<Integer> first, List<Integer> second) {
			List<Integer> merged = new ArrayList<Integer>();
			int i = 0;
			int j = 0;
			while (merged.size() < first.size() + second.size()) {
				if (i < first.size() && (j >= second.size() || first.get(i) < second.get(j))) {
					merged.add(first.get(i));
					i++;
				} else {
					merged.add(second.get(j));
					j++;
				}
			}
			return merged;
		}
		
	    public static void main(String[] args) throws FileNotFoundException {
	    	Scanner testFile = new Scanner(new File("Test.txt"));
	    	List<Integer> toSort = new ArrayList<Integer>();
	    	while (testFile.hasNextInt()) {
	    		toSort.add(testFile.nextInt());
	    	}
	    	System.out.println(sort(toSort));
	    }
}

