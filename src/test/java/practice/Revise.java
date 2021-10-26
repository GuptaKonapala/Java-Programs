package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

public class Revise {
	
	int[] a = { 1, 2, 3, 4, 5, 9, 8, 7, 6 };
	int[] b = { 1, 2, 3, 3, 1 };
	int[] c = { 1, 2, 3, 4, 5, 9, 5, 5, 6 };
	int[] d = { 1, 5, 3, 4, 5, 5, 8, 7, 6 };
	int[] e = {0,0,1,7,5,0,4,5,0};
	
	
	
	@Test
	public void arrayexecution() {
		 sortnumericarray(a);
		 sum(b);
		 average(b);
		 containsvalue(a, 6);
		 indexnumber(b, 1);
		 removeelement(c, 5);
		 removevalue(d, 5);
		 copyarraybyiterating(b);
		 replaceanindexvalue(d,0,9);
		 maxandmin(a);
		 reverseanarray(a);
		 reveseanarrayusinglist(b);
		 smallestnumberdoesnotinarray(e);
		 movenumbertolast(e, 0);
	}


	private void sortnumericarray(int[] a2) {
		for(int i =0; i<a2.length; i++) {
			for(int j =i+1; j<a2.length; j++) {
				if(a2[i]>a2[j]) {
					int temp = a2[i];
					a2[i] = a2[j];
					a2[j] = temp;
				}
			}
		}
		System.out.println("Sorted using bubble sort "+Arrays.toString(a2));
		
		Arrays.sort(a2);
		System.out.println("Sorted using Arrays class "+Arrays.toString(a2));
		System.out.println("                   *****************                   ");	}


	private void sum(int[] b2) {
		int sum = 0;
		for(Integer e : b2) {
			sum = sum+e;
		}
		System.out.println("Sum using for each loop is "+sum);
		System.out.println("                   *****************                   ");	}


	private void average(int[] b2) {
		int avg = 0;
		for(Integer e : b2) {
			avg = avg+e;
		}
		System.out.println("Average of an array is "+avg/b2.length);
		System.out.println("                   *****************                   ");	}


	private void containsvalue(int[] a2, int i) {
		boolean flag = true;
		for(Integer e : a2) {
			if(e==i) {
				System.out.println(Arrays.toString(a2)+" contains "+i);
				flag = false;
			}
		}
		if(flag == true) {
			 System.out.println(Arrays.toString(a2)+" doesn't contains "+i);
		}
		System.out.println("                   *****************                   ");
	}


	private void indexnumber(int[] b2, int i) {
		for(int j =0; j<b2.length; j++) {
			if(b2[j]==i) {
				System.out.println("Index of the "+i+" is "+j);
			}
		}
		System.out.println("                   *****************                   ");	}


	private void removeelement(int[] c2, int i) {
		for(int j =0; j<c2.length; j++) {
			if(c2[j]==i) {
				c2 =ArrayUtils.remove(c2, j);
				j--;
			}
		}
		System.out.println("Element removed using ArrayUtils.remove method "+Arrays.toString(c2));
		System.out.println("                   *****************                   ");	}


	private void removevalue(int[] d2, int i) {
		int[] arr = new int[d2.length];
		int position =0;
		for(int j =0; j<d2.length; j++) {
			if(!(d2[j]==i)) {
				arr[position] = d2[j];
				position++;
			}
		}
		d2 = arr;
		System.out.println("new array created by leaving specific number "+Arrays.toString(d2));
		System.out.println("                   *****************                   ");	}


	private void copyarraybyiterating(int[] b2) {
		int[] b = new int[b2.length]; 
		int index = 0;
		for(Integer e : b2) {
			b[index] = e;
			index++;
		}
		System.out.println("Copied using for each loop "+Arrays.toString(b));
		System.out.println("                   *****************                   ");	}


	private void replaceanindexvalue(int[] d2, int i, int j) {
		for(int k=0; k<d2.length; k++) {
			if(k==i) {
				d2[k]=j;
			}
		}
		System.out.println("Replaced "+i+" index value with "+j+" "+Arrays.toString(d2));
		System.out.println("                   *****************                   ");	}


	private void maxandmin(int[] a2) {
		int min = a2[0];
		int max = a2[0];
		for(Integer e : a2) {
			if(min>e) {
				min = e;
			}
			else if(max<e) {
				max =e;
			}
		}
		System.out.println("minimun value of an array is "+min);
		System.out.println("maximum value of an array is "+max);
		System.out.println("                   *****************                   ");	}


	private void reverseanarray(int[] a2) {
		int arr[] = new int[a2.length];
		int pos =0;
		for(int i=a2.length-1; i>=0; i--) {
			System.out.print(a2[i]+" ");
			arr[pos] = a2[i];
			pos++;
		}
		System.out.println("New reversed array "+Arrays.toString(arr));
		System.out.println("                   *****************                   ");	}


	private void reveseanarrayusinglist(int[] b2) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = b2.length-1; i>=0; i--) {
			list.add(b2[i]);
		}
		System.out.println("Reverse an array using ArrayList "+list);
		System.out.println("                   *****************                   ");	}


	private void smallestnumberdoesnotinarray(int[] e2) {
		Set <Integer>set = new HashSet<Integer>();
		for(Integer e : e2) {
			set.add(e);
		}
		for(int i =0; i<100000; i++) {
			if(!set.contains(i)) {
				System.out.println("Smallest number doesn't in array is "+i);
				break;
			}
		}
		System.out.println("                   *****************                   ");	}


	private void movenumbertolast(int[] e2, int num) {
		int temp;
		for(int j=0; j<e2.length; j++) {
			for(int i =j+1; i<e2.length; i++) {
				if(e2[j]==num) {
					temp = e2[j];
					e2[j] = e2[i];
					e2[i] = temp;
				}			
			}
		}
		System.out.println(Arrays.toString(e2));
	}
	

	static StringBuffer name = new StringBuffer("bhagadsingh");
	static StringBuilder name2 = new StringBuilder("Gandhi");
	static char[] as = { '1', '2', '3', '4' };
	
	
	@Test
	public static void stringexecution() {
		System.out.println("                   *****************                   ");
		System.out.println("                   *****************                   ");
		System.out.println("                   *****************                   ");
		 getindexvalue("Gupta K", 6);
		 getunicode("unicode", 0);
		 getunicodebeforeindex("name", 3);
		 getunicodecount("string name", 3,9);
		 compare2Strings("name3", "name2");
		 compare2Stringsignorecase("Name is Gupta2", "nAME IS gUPTA0");
		 concate("name1", "name2");
		 contains("harshad", "ha");
		 comparecharsequence("manmohan", "harigovind");
		 comparestringbuffer("lalalajapathi", name);
		 comparestringbuilder("Gandhi", name2);
		 createstringusingchararray(as);
		 endswith("arnold", "old");
		 dateandtime();
		 converttobyteviseversa("haello");
		 converttocharviseversa("hai rey");
		 duplicates("aaabcdbcdeedcba");
		 noofduplicates("automation");
		 reverse("hello world");
		 rev("Hey bob marley");
		 palindrome("abcbaa");
		 anagram("name", "NAME");
		 occurance("naaaame", 'a');
		 converttoprimitivedatatype("34567");
		 removechar("naaame", "a");
		 removeduplicates("lesksvsssssavvvmvvvvvvvbcde");
		 countwords("name is kuresh a s d f g h j k k");
		 reversewords("name is jadesh aro sun duck fish gun hut join kite kat");
		 reversewordsusingstringbuilder("name is jadesh aro sun duck fish gun hut join kite kat");
		 reversepreservingspaces("name is kha");
	}


	private static void getindexvalue(String string, int i) {
			System.out.println("index value of "+i+" is "+string.charAt(i));
			System.out.println("                   *****************                   ");
	}


	private static void getunicode(String string, int i) {
		System.out.println(string.codePointAt(i));
		System.out.println("                   *****************                   ");
	}


	private static void getunicodebeforeindex(String string, int i) {
		System.out.println(string.codePointBefore(i));
		System.out.println("                   *****************                   ");
	}


	private static void getunicodecount(String string, int i, int j) {
		System.out.println(string.codePointCount(i, j));
		System.out.println("                   *****************                   ");
	}


	private static void compare2Strings(String string, String string2) {
		System.out.println(string.compareTo(string2));
		System.out.println("                   *****************                   ");
	}


	private static void compare2Stringsignorecase(String string, String string2) {
		System.out.println(string.compareToIgnoreCase(string2));
		System.out.println("                   *****************                   ");
	}


	private static void concate(String string, String string2) {
		System.out.println(string.concat(string2));
		System.out.println("                   *****************                   ");
	}


	private static void contains(String string, String string2) {
		System.out.println(string.contains(string2));
		System.out.println("                   *****************                   ");		
	}


	private static void comparecharsequence(String string, String string2) {
		System.out.println(string.equals(string2));
		System.out.println("                   *****************                   ");		
	}


	private static void comparestringbuffer(String string, StringBuffer name3) {
		System.out.println(string.contentEquals(name3));
		System.out.println("                   *****************                   ");		
	}


	private static void comparestringbuilder(String string, StringBuilder name22) {
		System.out.println(string.equals(name22.toString()));
		System.out.println("                   *****************                   ");		
	}


	private static void createstringusingchararray(char[] as2) {
		System.out.println(Arrays.toString(as2));
		System.out.println(String.copyValueOf(as2));
		System.out.println("                   *****************                   ");		
	}


	private static void endswith(String string, String string2) {
		System.out.println(string.endsWith(string2));
		System.out.println("                   *****************                   ");		
	}


	private static void dateandtime() {
		System.out.println(Calendar.getInstance().getTime());
		System.out.println("                   *****************                   ");		
	}


	private static void converttobyteviseversa(String string) {
		System.out.println(Arrays.toString(string.getBytes()));
		String str = new String(string.getBytes());
		System.out.println(str);
		System.out.println("                   *****************                   ");		
	}


	private static void converttocharviseversa(String string) {
		System.out.println(Arrays.toString(string.toCharArray()));
		String str = new String(string.toCharArray());
		System.out.println(str);
		System.out.println("                   *****************                   ");		
	}


	private static void duplicates(String string) {
		Map <Character, Integer>map = new HashMap<Character, Integer>();
		for(int i =0; i<string.length(); i++) {
			char c = string.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, 1);
			}
			else {
				int cnt = map.get(c);
				map.put(c, ++cnt);
			}
		}
		System.out.println(map);
		System.out.println("                   *****************                   ");		
	}
	
	
	public static void noofduplicates(String s){
		int cnt =0;
		char[] s1 =s.toCharArray();
		for(int i =0; i<s1.length-1; i++) {
			for(int j=i+1; j<s1.length; j++) {
				if(s1[i]==s1[j]) {
					cnt++;
					s1=ArrayUtils.remove(s1, j);
					j--;
				}
			}
		}
		System.out.println(cnt);
	}


	private static void reverse(String string) {
		StringBuffer str= new StringBuffer(string);
		System.out.println(str.reverse());
		StringBuilder stb = new StringBuilder(string);
		System.out.println(stb.reverse());
		System.out.println("                   *****************                   ");		
	}


	private static void rev(String string) {
		String revs ="";
		for(int i =string.length()-1; i>=0; i--) {
			revs = revs+string.charAt(i);
		}
		System.out.println(revs);
		System.out.println("                   *****************                   ");		
	}


	private static void palindrome(String string) {
		String revs ="";
		for(int i =string.length()-1; i>=0; i--) {
			revs = revs+string.charAt(i);
		}
		if(string.equals(revs)) {
			System.out.println(string+" is palindrome");
		}
		else {System.out.println(string+" is not a palindrome");}
		System.out.println("                   *****************                   ");		
	}


	private static void anagram(String string, String string2) {
		char[] s1 = string.toLowerCase().toCharArray();
		char[] s2 = string2.toLowerCase().toCharArray();
		Arrays.sort(s1);
		Arrays.sort(s2);
		if(Arrays.equals(s1, s2)) {
			System.out.println(string+" is anagram");
		}
		else {System.out.println(string+" is not an anagram");}
		System.out.println("                   *****************                   ");		
	}


	private static void occurance(String string, char f) {
		int cnt =0;
		for(int i =0; i<string.length(); i++) {
			if(string.charAt(i)==f) {
				cnt++;
			}
		}
		System.out.println(f+" occurs "+cnt+" times in "+string);
		System.out.println("                   *****************                   ");		
	}


	private static void converttoprimitivedatatype(String string) {
		System.out.println(Integer.parseInt(string));
		System.out.println("                   *****************                   ");		
	}


	private static void removechar(String string, String string2) {
		System.out.println(string.replaceAll(string2, ""));
		System.out.println("                   *****************                   ");		
	}
	
	
	public static void removeduplicates(String s) {
		boolean duplicate = false;
		String s2= "";
		for(int i=0; i<s.length(); i++) {
			for(int j=0; j<s.length(); j++) {
				if(i!=j) {
					if(s.charAt(i)==s.charAt(j)) {
						duplicate = true;
						break;
					}
				}
			}
			if(duplicate == false) {
				s2 = s2+s.charAt(i);
			}
			duplicate = false;
		}
		System.out.println("After removing duplicates "+s2);
	}


	private static void countwords(String string) {
		String[] a = string.split(" ");
		System.out.println(a.length);
		System.out.println("                   *****************                   ");		
	}


	private static void reversewords(String string) {
		String[] s = string.split(" ");
		String rev ="";
		for(String e : s) {
			for(int i=e.length()-1; i>=0; i--) {
				rev = rev+e.charAt(i);
			}
			rev = rev+" ";
		}
		System.out.println("reverse words using double forloop : "+rev);
		System.out.println("                   *****************                   ");		
	}


	private static void reversewordsusingstringbuilder(String string) {
		String[] s = string.split(" ");
		String rev = "";
		String rev2 = "";
		for(String e : s) {
			StringBuilder sb = new StringBuilder(e);
			rev = rev+sb.reverse()+" ";
		}
		for(String e : s) {
			StringBuffer sbu = new StringBuffer(e);
			rev2 = rev2+sbu.reverse()+" ";
		}
		System.out.println("reverse words using Stringbuilder : "+rev);
		System.out.println("reverse words using Stringbuffer : "+rev2);
		System.out.println("                   *****************                   ");		
	}



	private static void reversepreservingspaces(String string) {
		char[]a = string.toCharArray();
		char[]b = new char[a.length];
		for(int i =0; i<a.length; i++) {
			if(a[i]==' ') {
				b[i]=' ';
			}
		}
		int n = b.length-1;
		for(int i =0; i<a.length; i++) {
			if(a[i] !=' ') {
				if(b[n]==' ') {
					n--;
				}
					b[n] = a[i];
					n--;
			}
		}
		System.out.println(String.valueOf(b));
		System.out.println("                   *****************                   ");	
	}

	
	
	
	static long[] ab = {12,14,16,-10,-30,17,19,20};
	static int[] bc = {5,3,6,2,1,616,70,5,7};
	
	
	@Test
	public static void xexecution() {
		System.out.println("                   *****************                   ");
		System.out.println("                   *****************                   ");
		System.out.println("                   *****************                   ");
		findOddorEven(-100);
		swapTwoNumbers(100, 10);
		swapTwoNumbersWithoutUsing3rdvariable(20,30);
		primeNumber(6);
		factorial(7);
		reverseNumber(553);
		fibonacci(10);
		armstrongNumber(153);
		palindromeNumber(1);
		noofdigits(-10);
		sumofdigits(-101101);
	}


	private static void findOddorEven(int i) {
			if(i%2==0) {
				System.out.println(i+" is an even number");
			}
			else {System.out.println(i+" is an odd number");}
		System.out.println("                   *****************                   ");
	}


	private static void swapTwoNumbers(int i, int j) {
		int i2 = i;
		int j2 = j;
		int temp = i;
		i = j;
		j = temp;
		System.out.println("Before swap value of i is "+i2+" After swap value of i is "+i);
		System.out.println("Before swap value of i is "+j2+" After swap value of i is "+j);
		System.out.println("                   *****************                   ");		
	}


	private static void swapTwoNumbersWithoutUsing3rdvariable(int i, int j) {
		int i2 = i;
		int j2 = j;
		i = i+j;
		j = i-j;
		i = i-j;
		System.out.println("Before swap value of i is "+i2+" After swap value of i is "+i);
		System.out.println("Before swap value of i is "+j2+" After swap value of i is "+j);
		System.out.println("                   *****************                   ");		
	}


	private static void primeNumber(int i) {
		boolean flag = false;
		if(i<2) {
			System.out.println(i+" is not a prime number");
		}
		else if(i==2) {
			System.out.println(i+" is a prime number");
		}
		else {
			for(int j=2; j<i; j++) {
				if(i%j==0) {
					System.out.println(i+" is not a prime number");
					flag = true;
					break;
				}
			}
			if(flag == false) {
				System.out.println (i+" is a prime number");
			}
		}
		System.out.println("                   *****************                   ");
	}


	private static void factorial(int i) {
		int fact=i;
		for(int j=i-1; j>=1; j--) {
			fact=fact*j;
		}
		System.out.println("factorial of "+i+" is "+fact);
		System.out.println("                   *****************                   ");		
	}


	private static void reverseNumber(int i) {
		int rev=0;
		while(i>0) {
			rev=(rev*10)+i%10;
			i = i/10;
		}
		System.out.println(rev);
		System.out.println("                   *****************                   ");		
	}


	private static void fibonacci(int i) {
		int f = 0;
		int s = 1;
		System.out.println("fibonacci series");
		for(int j = 0; j<i; j++) {
			int fib = f+s;
			System.out.println(f);
			f = s;
			s = fib;
		}
		System.out.println("                   *****************                   ");		
	}


	private static void armstrongNumber(int i) {
		int cube=0;
		while(i>=1) {
			int j =i%10;
			cube = cube+(j*j*j);
			i = i/10;
		}
		System.out.println(cube);
		System.out.println("                   *****************                   ");		
	}


	private static void palindromeNumber(int i) {
		int num = i;
		int pali = 0;
		while(i>=1) {
			pali=(pali*10)+(i%10);
			i=i/10;
		}
		if(num==pali) {
			System.out.println(num+" is a palindrome number");
		}
		else {System.out.println(num+" is not a palindrome number");}
		System.out.println("                   *****************                   ");		
	}


	private static void noofdigits(int i) {
		int cnt = 0;
		if(i>0) {
			while(i>0) {
				cnt++;
				i=i/10;
			}
		}
		else {
			while(i<0) {
				cnt++;
				i=i/10;
			}
		}
		System.out.println(cnt);
		System.out.println("                   *****************                   ");		
	}


	private static void sumofdigits(int i) {
		int sum =0;
		if(i>0) {
			while(i>0) {
				sum = sum+i%10;
				i=i/10;
			}
		}
		else {
			while(i<0) {
				sum = sum+i%10;
				i=i/10;
			}
		}
		System.out.println(sum);
	}





}
