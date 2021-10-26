package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTableCustomiseXPath {

	@Test
	public void ParentXpath() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'textvalue')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'textvalue')]/parent::html tag//preceding-sibling::html tag//input[@name='login']")).click();		//	 XPath using parenting and sibling 
	}
}
