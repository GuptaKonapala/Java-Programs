package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngBasics {

	public WebDriver driver;																//				Global variable to available for all the methods


	@BeforeSuite																		//				1st BeforeSuite annotated method will be executed
	public void openeclipse() {
		System.out.println("Before Suite");
	}

	@BeforeTest																			//				2nd BeforeTest annotated method will be executed
	public void testsomething() {
		System.out.println("Before Test");
	}

	@BeforeClass																		//				3rd BeforeClass annotated method will be executed
	public void browserSetup() {
		WebDriverManager.chromedriver().setup();
		System.out.println("Before Class");
	}
																//				4th BeforeMethod annotated method will be executed and 7th will be executed
	@BeforeMethod
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println("Before Method");
	}

	@Test(priority=2,groups="home page")						//				8th Test annotated method will be executed because we give priority 2, 
	public void login() {															//				groups keyword is used to groups the test cases
		driver.get("https://www.google.com");
		System.out.println("login = " + driver.getTitle());
	}

	@Test(priority=1,groups="home page")						//				5th Test annotated method will be executed because we give priority 1
	public void signin() {
		driver.get("https://www.facebook.com");
		System.out.println("signin = " + driver.getTitle());
	}
	
	@AfterMethod																		//				6th AfterMethod annotated method will be executed and 9th will be executed
	public void close() {
		System.out.println("After Method");
		String title = driver.getTitle();
		System.out.println(title);		//		Got the different Values
		driver.close();
	}
	
	@AfterClass																			//				10th AfterClass annotated method will be executed
	public void getreports() {
		System.out.println("After Class");
	}
	
	@AfterTest																			//				11th AfterTest annotated method will be executed
	public void verify() {
		System.out.println("After Test");
	}
	
	@AfterSuite																			//				Last AfterSuite annotated method will be executed
	public void done() {
		System.out.println("After Suite");	
	}
}
