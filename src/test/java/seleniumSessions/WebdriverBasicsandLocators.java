package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverBasicsandLocators {
	
@Test
	public void method() {
		WebDriverManager.chromedriver().setup();		//	to setup browser
		WebDriver driver = new ChromeDriver();			//	to launch specific browser
		driver.manage().deleteAllCookies();						//	to clear cookies
		driver.manage().window().maximize();				//	to maximize window
		driver.get("https://www.ebay.com/");					//	to launch specific site
		driver.findElement(By.linkText("Advanced")).click();				//	to select specific element by using "link test" then click
		driver.findElement(By.name("_nkw")).sendKeys("Monitor");	//	to select specific element by using "element name" then giving some input
		driver.findElement(By.className("block")).sendKeys("Tv");		//	to select specific element by using "class name" then giving some input
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"_in_kw\"]")));		//	to select drop down list we have to create a object which is having the path to drop down list. 
																																					//	here we are select the element by using "XPath"
																																					// Absolute XPath should not be used it comes from hierarchy	-	https//body/fieldset[1]/div[3]/button 
																																					//	Only Relative XPath should be used	-	//*[@id="gh-as-a"]
		select.selectByVisibleText("Exact words, exact order");				//	by using select class methods(selectByVisibleText) we are selecting specific element in drop down list
		Select select1 = new Select(driver.findElement(By.id("e1-1")));		
		select1.selectByVisibleText("Computers/Tablets & Networking");
		driver.findElement(By.cssSelector("#LH_TitleDesc")).click();	//	to select specific element by using "CSS Selector" then click
		driver.findElement(By.id("_mPrRngCbx")).click();					//	to select specific element by using "element id" then click
		driver.findElement(By.partialLinkText("using advanced")).click();		//	to select specific element by using "partial link test" then click
		driver.findElement(By.partialLinkText("search tips")).click();
		driver.close();
		
	}
}
