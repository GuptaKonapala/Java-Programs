package com.accenture.ACSF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class ArrayConcept {

	int[] a = { 1, 2, 3, 4, 5, 9, 8, 7, 6 };
	int[] b = { 1, 2, 3, 3, 1 };
	int[] c = { 1, 2, 3, 4, 5, 9, 8, 7, 6 };
	int[] d = { 1, 5, 3, 4, 5, 5, 8, 7, 6 };
	int[] e = {0,1,7,5,0,4,5,0};

	@Test
	public void execution() {
//		 sortnumericarray(a);
//		 sum(b);
//		 average(b);
//		 System.out.println(containsvalue(a, 6));
//		 indexnumber(b, 2);
//		 removeelement(c, 5);
//    	 removevalue(d, 5);
//		 copyarraybyiterating(b);
//		 replaceanelement(d,0,9);
//		 maxandmin(a);
//		 reverseanarray(a);
//		 reveseanarrayusinglist(b);
//		 smallestnumberdoesnotinarray();
//		 movezerostolast(e);
	}

	public static void sortnumericarray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println("Sorted using bubble sort " + Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("Sorted using Arrays sort method " + Arrays.toString(array));
	}

	public static void sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		System.out.println("Sum of all the values in array is " + sum);
	}

	public static void average(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		System.out.println("Average of the array values is " + sum / array.length);
	}

	public static String containsvalue(int[] array, int number) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				return Arrays.toString(array) + " contains " + number;
			}
		}
		return Arrays.toString(array) + " doesn't contains " + number;
	}

	public static void indexnumber(int[] array, int number) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				System.out.println(number + " index is " + i);
			}
		}
	}

	public static void removeelement(int[] array, int number) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				int remove = i;
				for (int j = remove; j < array.length - 1; j++) {
					array[j] = array[j + 1];
				}
			}
		}
		System.out.println("after carryforward "+Arrays.toString(array));
	}
	
	public static void removevalue(int[] array, int number) {
		int[] newarray = new int[array.length];
		int position = 0;
		for(int i =0; i<array.length; i++) {
			if(!(array[i]==number)) {
				newarray[position] = array[i];
				position++;
			}
		}
		array = newarray;
		System.out.println("after remove "+Arrays.toString(array));
	}

	public static void copyarraybyiterating(int[] array) {
		int[] newarray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			newarray[i] = array[i];
		}
		System.out.println("copy "+Arrays.toString(newarray));
	}

	public static void replaceanelement(int[] array, int index, int value) {
		for (int i=0; i<array.length; i++) {
			if (i == index) {
				array[i] = value;
			}
		}
		System.out.println("replace "+Arrays.toString(array));
	}

	public static void maxandmin(int[] array) {
		int max = array[0];
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			} else if (min > array[i]) {
				min = array[i];
			}
		}
		System.out.println("max : "+max + ", min : " + min);
	}

	public static void reverseanarray(int[] array) {
		System.out.println("before reverse "+Arrays.toString(array));
		int num[] = new int[array.length];
		int position = 0;
		for (int i = array.length - 1; i >= 0; i--) {		
				num[position] =array[i];
				position++;
		}
		System.out.println("after reverse "+Arrays.toString(num));
	}
	
	public static void reveseanarrayusinglist(int[] array) {
		 System.out.println(Arrays.toString(array));
		 List<Integer> list = new ArrayList<Integer>();
		 for(int i = array.length-1; i>=0; i--) {
		 list.add(array[i]);
		 }
		 System.out.println("reverselist "+list);
	}

	public static void smallestnumberdoesnotinarray() {
		int a[] = { 0, -1, -2, 3, 2, 2, 3, 4 };
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				if (!set.contains(a[i])) {
					set.add(a[i]);
				}
			}
		}
		for (int j = 1; j < 100000; j++) {
			if (!set.contains(j)) {
				System.out.println("smallest number "+j);
				break;
			}
		}
	}
	
	public static void movezerostolast(int[] a) {
		for(int i =0; i<a.length; i++) {
			for(int j = i+1; j<a.length; j++)
				if(a[i]==0) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
