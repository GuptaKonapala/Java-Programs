package com.accenture.ACSF;

public class Javaprograms {

	public static void main(String[] args) {
		array();
		System.out.println(isprimenumber(100593));
		primenumbers(10);
		armstrongnumber(154);
		spacepattern();
		trianglepattern();
		pattern();
		revpattern();
		alphabetorder();
		alphabetorder2();
	}
public static void array() {															//		sum of which 2 numbers = 6  ?
	int num[] = {2,3,4,5,6,1};
	for (int i =0; i<num.length; i++) {
		for(int j=i+1; j<num.length; j++) {
			if(num[i]+num[j]==6) {
				System.out.println(num[i]+" "+num[j]);
				} } } }

public static void primenumbers(int num) {							// 		collection of numbers are prime or not
	for(int i = 0; i<=num; i++) {
		System.out.println(isprimenumber(i));
	} }

public static String isprimenumber(int num) {						// 		a specific number is primenumber or not
	if(num<=1) {
		return num+" is not a primenumber";
	}
	for (int i =2; i<num; i++) {
		if (num % i==0) {
			return num+" is not a primenumber";
		}
	}return num+" is primenumber";
}
public static void armstrongnumber(int num) {					//		armstrong number
	
	int cube =0;
	int i;
	int t = num;
	
	while(num>0) {
		i = num%10;
		num = num/10;
		cube = cube +(i*i*i);
	}
		if(t==cube) {
			System.out.println(t+" is armstrong number");
		}else {System.out.println(t+" is not armstrong number");}
}
public static void spacepattern() {
	for(int i =4; i>=0; i--) {
		for(int j=0; j<i; j++) {
			System.out.print(" ");
		}
		for(int k=4; k>=i; k--) {
			System.out.print("*");
		}System.out.println();
	}
}
public static void trianglepattern() {
	for(int i =4; i>=0; i--) {
		for(int j=0; j<i; j++) {
			System.out.print(" ");
		}
		for(int k=4; k>=i; k--) {
			System.out.print(" *");															//		There is a space before *. thats the difference between traingle pattern and space pattern
		}System.out.println();
	}
}
public static void pattern() {
	for(int i =0; i<=4; i++) {
		for(int j=0; j<=i; j++) {
			System.out.print("*");
		}System.out.println();
	}
}
public static void revpattern() {
	for(int i = 0; i<=4; i++) {
		for(int j= 3; j>=i; j--) {
			System.out.print("*");
		}System.out.println();
	}
}
public static void alphabetorder() {
	int alpha = 65;																					//		65 is ascii value of alphabet
	for(int i=0; i<=4; i++) {
		for(int j=0; j<=i; j++) {
			System.out.print((char)(alpha+j)+" ");
		}System.out.println();
	}
}
public static void alphabetorder2() {
	int alpha = 65;																					//		65 is ascii value of alphabet
	for(int i=0; i<=4; i++) {
		for(int j=0; j<=i; j++) {
			System.out.print((char)(alpha+i)+" ");
		}System.out.println();
	}
}
}
