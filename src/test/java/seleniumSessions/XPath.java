package seleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPath {

	@Test
	public void creatingXPath() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[7]/a")).click();		//		Absolute XPath
    	List <WebElement> linklist = driver.findElements(By.tagName("a"));
		System.out.println(linklist.size());
		for (int a=0; a<linklist.size(); a++) {
		System.out.println(linklist.get(a).getText());	
		}
	}
}
