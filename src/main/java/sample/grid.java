package sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class grid {

	@Test
	public void gridsample() throws MalformedURLException {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setPlatform(Platform.ANY);
		cap.setBrowserName("chrome");
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"),cap);
		driver.get("http://gmail.com");
		driver.findElement(By.id("Email")).sendKeys("harshad");
		driver.findElement(By.id("Passwd")).sendKeys("hoejlkd");
	}
}
