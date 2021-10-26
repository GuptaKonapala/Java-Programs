package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsPopupsFrames {
	
	@Test
	public void popup() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		//System.out.println(driver.switchTo().alert().getText()); 		//		direct. without giving reference variable
		Alert alert = driver.switchTo().alert();		//		giving variable to refer. (popup)
		Thread.sleep(1000);
		alert.accept();		//		click on ok
//		alert.dismiss();	//		click on cancel
		driver.findElement(By.id("login1")).sendKeys("hai");

//		WebDriver driver1 = new ChromeDriver();			//			Attachement Button. in inspect the type = file should be written. then only it will work
//		driver1.get("https://html.com/input-type-file/");
//		driver1.findElement(By.xpath("//*[@id=\"fileupload\"]")).sendKeys("C:\\Users\\sunny\\Desktop\\Gupta\\Technology\\Java\\file");		//		Never use click method
		
		WebDriver driver2 = new ChromeDriver();		//		switch to frame
		driver2.get("https://www.easyhtmlcode.com/frames.html");
		driver2.switchTo().frame(0);																	//		switch to frame
		driver2.findElement(By.linkText("CSS Tutorial")).click();
	}
	

}
