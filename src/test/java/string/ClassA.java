package string;

import org.testng.annotations.Test;

public class ClassA {
	
	@Test
	public void example1() {
		System.out.println("in class A");
	}
	@Test
	public void cdexample2() {
		System.out.println("in class A of example2");
	}
	@Test(priority = 0)
	public void cexample3() {
		System.out.println("in class A of example3");
	}
}
