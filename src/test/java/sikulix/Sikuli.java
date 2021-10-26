package sikulix;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sikuli {

	@Test
	public void Youtube() throws InterruptedException, FindFailed{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/watch?v=OtQAMoXYqes&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT&index=22");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Screen s = new Screen();
		Pattern mute = new Pattern("E:\\Java_Selenium\\ACSF\\mute.PNG");
		s.wait(mute, 15000);
		s.click();
		
		
		
	}

}
