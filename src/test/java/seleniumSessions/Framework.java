package seleniumSessions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Framework {
	WebDriver driver;
	@Test
	public void facebook() throws IOException {
	Properties prop = new Properties();			//		creating a object of config.properties file
	FileInputStream ip = new FileInputStream("//E:/Java_Selenium/ACSF/src/test/java/seleniumSessions/config.properties");		//		input the address of config.properties file in FileInputStream class
	prop.load(ip);		//		load the object with FileInputStream class to access the data
	System.out.println(prop.getProperty("first_name"));
	
	String browser = prop.getProperty("browser");
	String url = prop.getProperty("url");
	String firstname = prop.getProperty("first_name");
	String lastname = prop.getProperty("last_name");
	String mobile = prop.getProperty("mobile_no");
	
	if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browser.equals("ff")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		else if(browser.equals("ie")) {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		}
	
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
	driver.findElement(By.linkText("Create New Account")).click();
	driver.findElement(By.name("firstname")).sendKeys(firstname);
	driver.findElement(By.name("lastname")).sendKeys(lastname);
	driver.findElement(By.name("reg_email__")).sendKeys(mobile);
	driver.findElement(By.id(prop.getProperty("password_id"))).sendKeys(prop.getProperty("password"));
	
	
	
	
	
	}
}
