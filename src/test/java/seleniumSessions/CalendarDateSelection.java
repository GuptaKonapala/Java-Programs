package seleniumSessions;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarDateSelection {
	
	static WebDriver driver;

	@Test
	public static void Selectdate() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/datepicker/#Simple%20Date%20Picker");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(2);
		driver.findElement(By.id("datepicker")).click();
		specificdate("29/12/2021");
	}
	
	public static void specificdate(String dat) {
		String date = dat.substring(0, 2);
		String month = dat.substring(3, 5);
		String year = dat.substring(6, 10);
		System.out.println(date+"-"+month+"-"+year);
		Calendar cal = Calendar.getInstance();
		int cumonth = cal.get(Calendar.MONTH)+1;
		int months = 0;
		boolean increment = true;
		if(Integer.parseInt(month)>cumonth) {
			months = Integer.parseInt(month)-cumonth;
		}
		else if(Integer.parseInt(month)<cumonth) {
			months = cumonth-Integer.parseInt(month);
			increment = false;
		}
		for(int i =0; i<months; i++) {
			if(increment) {
				driver.findElement(By.xpath("//a[@data-handler='next']")).click();
			}
			else {driver.findElement(By.xpath("//a[@data-handler='prev']")).click();}
		}
		driver.findElement(By.linkText(date.toString())).click();
	}
}
