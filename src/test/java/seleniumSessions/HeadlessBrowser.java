package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowser {
	
	@Test
	public void headlessChrome() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();		//		Object for chrome options
		options.addArguments("window-size=1920,1080");		//		to convert mobile view to desktop view
		options.addArguments("headless");									//		to perform without opening browser
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
	}

}
