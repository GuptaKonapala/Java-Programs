package practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotHighlightExplicitwait {
	
	@Test
	public void setup() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//button[@class = '_2KpZ6l _2doB4z']")).click();
		WebElement loginbtn = driver.findElement(By.linkText("Login"));
		highlightElement(loginbtn, driver, "orange");
		explicitwait(driver, 20, loginbtn);
		screenshot(driver);
	}
	public void explicitwait(WebDriver driver, int timeout, WebElement element) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	public void highlightElement(WebElement element, WebDriver driver, String color) {
		String bgcolor = element.getCssValue("backgroundColor");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = ' "+color+" ' ", element);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("arguments[0].style.backgroundColor = ' "+bgcolor+" ' ", element);
	}
	public void screenshot(WebDriver driver) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("E:\\Java_Selenium\\ACSF\\src\\test\\java\\seleniumSessions\\flipkart.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
