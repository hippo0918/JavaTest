package com.java.se;
import java.util.*;

public class Sort {
	
	public static void main(String[] args) {
		//create a array of the length is 10 
		Integer arrayLength = 100;
		Integer[] array = new Integer[arrayLength];
		for(int i=arrayLength; i>0;) {
			//value is in [10,100]
			array[--i] = new Random().nextInt(91) + 10;
		}
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	//BubbleSort
	public static <T extends Comparable<T>> void bubbleSort(T[] array) {
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array.length-i-1; j++) {
				if(array[j].compareTo(array[j+1]) > 0) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
	
	//insertedSort
	public static <T extends Comparable<T>> void insertedSort(T[] array) {
		Integer[] a = new Integer[array.length];
		array = (T[]) a;
	}
}