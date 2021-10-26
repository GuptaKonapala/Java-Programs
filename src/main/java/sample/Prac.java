package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Prac {

	@Test
	public static void execute() {
		//windowsize();
		duplicate();
		met();
		remov();
	}

	public static void windowsize() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		for (int i = 400; i <= 1000; i = i + 10) {
			driver.manage().window().setSize(new Dimension(i, i));
		}
	}

	public static void duplicate() {
		char[] arr = { 'd', 'z', 'a', 'a', 'a', 'a', 'b', 'b', 'c', 'b', 'c', 'c', 'd', 'z' };
		Arrays.sort(arr);
		int count = 1;
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				list.add(arr[i]);
				count++;
			} else {
				list.add(arr[i]);
				list.add(count);
				count = 1;
			}
		}
		if (arr[arr.length - 2] == arr[arr.length - 1]) {
			list.add(arr[arr.length - 1]);
			list.add(count++);
		} else {
			list.add(arr[arr.length - 1]);
			list.add(count);
		}
		System.out.println(list);
	}

	public static void met() {
		int[] ar = { 4, 3, 3, 3, 2, 1, 2, 3, 4 };
		for (int i = 0; i < ar.length; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				if (ar[i] == 3) {
					int temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(ar));
	}
	
	public static void remov() {
		int[] ar = { 4, 3, 3, 3, 2, 1, 2, 3, 4 };
		for(int i =0; i<ar.length; i++) {
			if(ar[i]==3) {
				ar=ArrayUtils.remove(ar, i);
				i--;
			}
		}
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar)); 
	}

}
