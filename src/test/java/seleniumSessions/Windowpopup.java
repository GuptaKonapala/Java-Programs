package seleniumSessions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowpopup {						//					window pop ups are differ from java pop ups
																			//					window pop ups  have url and we can maximize the window pop ups
	@Test
	public void method() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("url");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("popuppath")).click();
		Thread.sleep(2000);
		
		//	we can't get the id's simply using inspect. to get the id's of windows we have to use "getwindowhandles "method
		Set<String> handler = driver.getWindowHandles();		//		to handle windows, it gives set values so we are using iterator method to get values
		Iterator<String> it = handler.iterator();		//		to get the set values we have to use iterator method
		String parentwindowid = it.next();			//		iterator pointed to parentwindow id
		System.out.println(parentwindowid);			//		got the parentwindow id
		String childwindowid = it.next();				//		iterator pointed to childwindow id
		System.out.println(childwindowid);			//		got the childwindow id
		driver.switchTo().window(childwindowid);			//		driver switch to other window. but we need ids to switch from one window to another so we are using "getwindowhandles" method
		System.out.println(driver.getTitle());			//		to print title of page
		driver.close();			//		to close the current window
		driver.switchTo().window(parentwindowid);		//		switch to parentwindow. Otherwise no such window exception will occur
		System.out.println(driver.getTitle());		
	}
}
