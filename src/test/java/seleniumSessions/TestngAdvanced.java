package seleniumSessions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngAdvanced extends TestngBasics {
	
	public TestngAdvanced obj;

	@BeforeMethod
	public void launch() {
		obj = new TestngAdvanced();
		obj.launchBrowser();
	}
	
	@Test
	public void sample() {
		System.out.println("in the sample");
	}

	

	
	
	@AfterMethod
	public void quit() {
		obj.close();
	}
	@Test
	public void loginpage() {
		driver.get("https://www.google.com");
	}
	@Test(dependsOnMethods = "loginpage")									//		dependsOnMethods is used to a test which is dependent on other test result
	public void myaccount() {																//		it executes only if dependsOnMethod is passed if that is failed it skipped
		System.out.println("my account page");
	}
	@Test(invocationCount=2)															//		it repeats the test multiple times
	public void repeated() {
		System.out.println("invocation count");
	}
	@Test(expectedExceptions=ArithmeticException.class)			//		to catch the exceptions without using try catch block
	public void exception() {
		int i = 9/0;
		System.out.println(i);
	}	
	@Test()						
	public void login() {															
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google", "title not matched");
	}
}
