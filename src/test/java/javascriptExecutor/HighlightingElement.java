package javascriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HighlightingElement {
	
	@Test
	public void intialization() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("https://www.youtube.com/watch?v=Dpx1Q62QpFU&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT&index=14");
			WebElement logo = driver.findElement(By.id("logo-icon"));
			flash(logo,driver,"blue");
	}
	public void flash(WebElement element, WebDriver driver, String color) {
			String bgcolor = element.getCssValue("backgroundColor");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			for(int i = 0; i<10; i++) {
				js.executeScript("arguments[0].style.backgroundColor = ' "+color+" ' " , element);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				js.executeScript("arguments[0].style.backgroundColor = ' "+bgcolor+" ' " , element);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}


}
