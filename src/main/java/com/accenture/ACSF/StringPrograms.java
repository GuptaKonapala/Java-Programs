package com.accenture.ACSF;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class StringPrograms {

	static StringBuffer name = new StringBuffer("bhagadsingh");
	static StringBuilder name2 = new StringBuilder("Gandhi");
	static char[] a = { '1', '2', '3', '4' };

	@Test
	public static void execution() {
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
		 createstringusingchararray(a);
		 endswith("arnold", "old");
		 dateandtime();
		 converttobyteviseversa("haello");
		 converttocharviseversa("hai rey");
		 duplicates("aaabcdbcdeedcba");
		 reverse("hello world");
		 rev();
		 palindrome("abcba");
		 anagram("name", "MAN");
		 occurance("naaaame", 'a');
		 converttoprimitivedatatype("34567");
		 removechar("naaame", "a");
		 countwords("name is kuresh a s d f g h j k k");
		 reversewords("name is jadesh aro sun duck fish gun hut join kite kat");
		 reversewordsusingstringbuilder("name is jadesh aro sun duck fish gun hut joinkite kat");
		 duplicatesusingmap("aaabcd    bcdeedcba");
		 reversepreservingspaces();
	}

	public static void getindexvalue(String name, int index) {
		System.out.println("value of the " + index + " index is " + name.charAt(index));
	}

	public static void getunicode(String name, int index) {
		System.out.println("unicode of index " + index + " is " + name.codePointAt(index));
	}

	public static void getunicodebeforeindex(String name, int index) {
		System.out.println("unicode of before index " + index + " is " + name.codePointAt(index - 1));
		System.out.println("unicode of before index " + index + " is " + name.codePointBefore(index));
	}

	public static void getunicodecount(String name, int index, int endindex) {
		System.out.println("unicode count of the given range is " + name.codePointCount(index, endindex));
	}

	public static void compare2Strings(String name1, String name2) {
		int result = name1.compareTo(name2);
		if (result < 0) {
			System.out.println(name1 + " is " + result + " less than " + name2);
		} else if (result > 0) {
			System.out.println(name1 + " is " + result + " greather than " + name2);
		} else {
			System.out.println(name1 + " and " + name2 + " are same");
		}
	}

	public static void compare2Stringsignorecase(String name1, String name2) {
		int result = name1.compareToIgnoreCase(name2);
		if (result < 0) {
			System.out.println(name1 + " is " + result + " less than " + name2);
		} else if (result > 0) {
			System.out.println(name1 + " is " + result + " greather than " + name2);
		} else {
			System.out.println(name1 + " and " + name2 + " are same");
		}
	}

	public static void concate(String name1, String name2) {
		System.out.println(name1.concat(name2));
	}

	public static void contains(String name, String word) {
		System.out.println(name.contains(word));
	}

	public static void comparecharsequence(String name1, CharSequence name2) {
		System.out.println(name1.contentEquals(name2));
	}

	public static void comparestringbuffer(String name1, StringBuffer name2) {
		System.out.println(name1.contentEquals(name2));
	}

	public static void comparestringbuilder(String name1, StringBuilder name2) {
		System.out.println(name1.equals(name2.toString()));
	}

	public static void createstringusingchararray(char[] array) {
		String st = Arrays.toString(array);
		System.out.println(st);
		String str = String.copyValueOf(array, 1, 1);
		System.out.println(str);
	}

	public static void endswith(String name, String name2) {
		System.out.println(name.endsWith(name2));
	}

	public static void dateandtime() {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
	}

	public static void converttobyteviseversa(String name) {
		byte[] array = name.getBytes();
		System.out.println(Arrays.toString(array));
		String str = new String(array);
		System.out.println(str);
	}

	public static void converttocharviseversa(String name) {
		char[] array = name.toCharArray();
		System.out.println(Arrays.toString(array));
		String str = new String(array);
		System.out.println(str);
		System.out.println(str.hashCode());
	}

	public static void duplicates(String name) {
		char[] array = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		char[] name1 = name.toCharArray();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < name1.length; j++) {
				if (array[i] == name1[j]) {
					count++;
				}
			}
			if (count != 0) {
				System.out.println(array[i] + " is occured " + count + " times");
				count = 0;
			}

		}

	}

	public static void anagram(String name, String name2) {
		char[] array = name.toLowerCase().toCharArray();
		char[] array2 = name2.toLowerCase().toCharArray();
		Arrays.sort(array);
		Arrays.sort(array2);
		System.out.println(name + " is a anagram : " + Arrays.equals(array, array2));
	}

	public static void reverse(String name) {
		char[] array = name.toCharArray();
		String reverse = "";
		for (int i = array.length - 1; i >= 0; i--) {
			reverse = reverse + array[i];
		}
		System.out.println("Reverse String is " + reverse);
	}
	
	public static void rev() {
		String name = "hello sir";
		String name2 ="";
		for(int i =name.length()-1; i>=0; i--) {
			name2 = name2+name.charAt(i);
		}
		System.out.println(name2);
	}

	public static void occurance(String name, char alphabet) {
		char[] array = name.toCharArray();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == alphabet) {
				count++;
			}
		}
		System.out.println(alphabet + " is occurs " + count + " times in " + name);
	}

	public static void converttoprimitivedatatype(String name) {
		System.out.println("Direct String " + (name + 10000));
		int n = Integer.parseInt(name);
		System.out.println("Converted to int " + (n + 10000));
	}

	public static void palindrome(String name) {
		char[] array = name.toCharArray();
		String reverse = "";
		for (int i = array.length - 1; i >= 0; i--) {
			reverse = reverse + array[i];
		}
		if (name.equals(reverse)) {
			System.out.println(name + " is a palindrome");
		} else {
			System.out.println(name + " is not a palindrome");
		}
	}

	public static void removechar(String name, CharSequence alphabet) {
		System.out.println(name.replace("alphabet", ""));
		System.out.println(name);
	}

	public static void countwords(String name) {
		System.out.println(name.split(" ").length);
	}

	public static void reversewords(String name) {
		System.out.println(Arrays.toString(name.split(" ")));
		String[] array = name.split(" ");
		String reverse = "";
		for (int i = 0; i < array.length; i++) {
			for (int j = array[i].length() - 1; j >= 0; j--) {
				reverse = reverse + array[i].charAt(j);
			}
			reverse = reverse + " ";
		}
		System.out.println(reverse);
	}

	public static void reversewordsusingstringbuilder(String name) {
		String[] array = name.split(" ");
		String bufferreverse = "";
		String builderreverse = "";
		for (String e : array) {
			StringBuffer str = new StringBuffer(e);
			str.reverse();
			bufferreverse = bufferreverse + str + " ";
		}
		System.out.println(bufferreverse);
		for (String e : array) {
			StringBuilder str = new StringBuilder(e);
			str.reverse();
			builderreverse = builderreverse + str + " ";
		}
		System.out.println(builderreverse);
	}

	public static void duplicatesusingmap(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				int cnt = map.get(c);
				map.put(c, ++cnt);
			} 
			else {
				map.put(c, 1);
			}
		}
		System.out.println(map);
	}
	
	public static void reversepreservingspaces() {
		String s = "monster under the bed";
		char[] c = s.toCharArray();
		char[] r = new char[c.length];
		for (int i = 0; i < s.length(); i++) {
			if(c[i]==' ') {
				r[i] = ' ';
			}
		}
		int j = r.length-1;
		for (int i = 0; i < s.length(); i++) {
			if(c[i] !=' ') {
				if(r[j] == ' ') {
					j--;
				}
				r[j] = c[i];
				j--;
			}
		}
		System.out.println(String.valueOf(r));
	}
	
}
