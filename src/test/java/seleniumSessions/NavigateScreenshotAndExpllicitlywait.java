package seleniumSessions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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

public class NavigateScreenshotAndExpllicitlywait {

	@Test
	public void moveto() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://www.amazon.com/");		//		Navigate to other page
		driver.navigate().back();														//		Navigate back
		Thread.sleep(20);
		driver.navigate().forward();												//		Navigate front
		Thread.sleep(10);
		driver.navigate().refresh();													//		refresh
		clickon(driver, driver.findElement(By.linkText("Gift Cards")), 10);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			//		To take Screenshot
		try {
			FileUtils.copyFile(src, new File("E:\\Java_Selenium\\ACSF\\src\\test\\java\\seleniumSessions\\gift cards.png"));			 //		storing the screenshot
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void clickon(WebDriver driver, WebElement locator, int timeout) {		//		Explicit wait
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
}
