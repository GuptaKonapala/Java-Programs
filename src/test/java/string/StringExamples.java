package string;

import org.testng.annotations.Test;

public class StringExamples {
	
	@Test	
	public void example1() {
		
		String str="Selenium";  //Immutable 
		
	
		System.out.println(str);
			
	}
	@Test
	public void example2() {
				
			StringBuffer sb = new StringBuffer("Selenium");
					System.out.println(sb.reverse());
					
					
		
			
	}
		
	//StringBuidler

}
