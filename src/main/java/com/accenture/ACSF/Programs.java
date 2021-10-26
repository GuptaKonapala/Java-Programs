package com.accenture.ACSF;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Programs {
	
	static long[] a = {12,14,16,-10,-30,17,19,20};
	static int[] b = {5,3,6,2,1,616,70,5,7};
	
	@Test
	public static void execution() {
		findOddorEven(-99);
		swapTwoNumbers(100, 10);
		swapTwoNumbersWithoutUsing3rdvariable(20,30);
		primeNumber(7);
		factorial(7);
		reverseNumber(453);
		fibonacci(10);
		armstrongNumber(-1);
		palindromeNumber(7007);
		noofdigits(-9876009);
		sumofdigits(123);
		largestandsmallest(a);
		multiplication(10);
		seconndlargestnumber(b);
	}
	
	public static void findOddorEven(long number) {
		
		if(number%2 ==0) {
			System.out.println(number+" is a Even number");
		}
		else {System.out.println(number+" is an Odd number");
	}}
	
	public static void swapTwoNumbers(long number1, long number2) {
		long temp = number1;
		number1 = number2;
		number2 = temp;
		System.out.println(number1+" is number1 value");
		System.out.println(number2+" is number2 value");
	}
	
	public static void swapTwoNumbersWithoutUsing3rdvariable(long num1, long num2) {
		num1 = num1*num2;
		num2 = num1/num2;
		num1 = num1/num2;
		System.out.println(num1+" is num1 value");
		System.out.println(num2+" is num2 value");
	}
	
	public static void primeNumber(long number) {
		if(number>2) {
			for (int i = 2; i<number; i++) {
				if(number%i==0) {
					System.out.println(number+" is not a prime number");
					break;
			}
			else {System.out.println(number+" is a prime number");
			}}}
		else if(number==2) {
			System.out.println(number+" is a prime number");
		}
		else {System.out.println(number+" is not a prime number");
	}}
	
	public static void factorial(long number) {
		long factorial = 1;
		if(number>=1) {
			for(long i = number; i>=1; i--) {
				factorial = factorial*(i);
			}
			System.out.println(factorial);
		}
		else {
			for(long i = number; i<0; i++) {
				factorial = factorial*(i);
			}
			if(factorial>0) {
				System.out.println(-+(factorial));
			}
			else{System.out.println(factorial);}
		}	
	}
	public static void reverseNumber(long number) {
		long rev = 0;
		while(number>0) {
			long i = number%10;
			rev = rev*10+i;
			number = number/10;
		}
		System.out.println(rev);
	}
	
	public static void fibonacci(long number) {
		long num1 = 0;
		long num2 = 1;
		System.out.println(num1);
		for(int i = 1; i<number; i++) {
			long num = num1+num2;
			num1 = num2;
			num2 = num;
			System.out.println(num1);
	}
	}
	public static void armstrongNumber(long number) {
		long cube = 0;
		long temp = number;
		while(number>0) {
			long j = number%10;
			number = number/10;
			cube = cube+(j*j*j);
		}
		if(temp==cube) {
			System.out.println(temp+" is armstrong number");
		}
		else {System.out.println(temp+" is not a armstrong number");
		}
	}
	public static void palindromeNumber(long number) {
		long temp = number;
		long rev = 0;
		while(number>0) {
			long i = number%10;
			rev = rev*10+(i);
			number = number/10;
		}
		if(rev==temp) {
			System.out.println(temp+" is a palindrome number");
		}
		else {System.out.println(temp+" is not a palindrome number");
		}
	}
	public static void noofdigits(long number){
		long digit = 0;
		while(number>0||number<0) {
			number = number/10;
			digit++;
		}
		System.out.println("No.of digits are "+digit);
	}
	
	public static void sumofdigits(long number) {
		long sum = 0;
		while(number!=0) {
			long i = number%10;
			sum = sum+i;
			number = number/10;
		}
		System.out.println("sum of digits "+sum);
	}
	
	public static void largestandsmallest(long[] array) {
		long max = array[0];
		long min = array[0];
		for(int i = 0; i<array.length; i++) {
			if(max<array[i]) {
				max = array[i];
			}
			if(min>array[i]) {
				min = array[i];
			}
		}System.out.println("Largest is "+max);
		System.out.println("smallest is "+min);
	}
	
	public static void multiplication(int number) {
		for(int i =1; i<11; i++) {
			System.out.println(number+"x"+i+"="+number*i);
		}
	}
	public static void seconndlargestnumber(int[] array) {
		int temp;
		for(int i = 0; i<array.length; i++) {
			for(int j= i+1; j<array.length; j++) {
				if(array[i]>array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println(array[array.length-2]);
	}
	//@Test
	public void flipkart() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//img[@alt='Mobiles']")).click();
		driver.findElement(By.name("q")).sendKeys("mobiles");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		List<WebElement> price = driver.findElements(By.cssSelector("div[class='_30jeq3 _1_WHN1']"));
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(WebElement e : price) {
			list.add(Integer.parseInt(e.getText().replaceAll("[^0-9]", "")));
		}
		Collections.sort(list);
			System.out.println("------------------------------");
		for(Integer e : list) {
			System.out.println(e);
		}
		driver.close();
	}
}
