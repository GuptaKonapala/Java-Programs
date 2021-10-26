
package seleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsdisplayedIsenabledIsselected {

	@Test
	public void isdisplayed() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://register.freecrm.com/register/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		boolean b1 = driver.findElement(By.name("action")).isDisplayed();			//		is displayed - is it able to see
		System.out.println(b1);
		boolean b2 = driver.findElement(By.name("action")).isEnabled();				//		is enabled - is it able to do some action like click or giving some input
		System.out.println(b2);
		boolean b3 = driver.findElement(By.id("terms")).isSelected();						//		is selected - is it clicked
		System.out.println("before accepting terms "+b3);
		driver.findElement(By.id("terms")).click();
		System.out.println("after accepting terms "+driver.findElement(By.id("terms")).isSelected());
	}
}
