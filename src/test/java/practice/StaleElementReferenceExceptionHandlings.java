package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementReferenceExceptionHandlings {
	
	//@Test
	public static void SingleElement() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/mobiles/mi~brand/pr?sid=tyy,4io&otracker=nmenu_sub_Electronics_0_Mi");
		driver.findElement(By.xpath("(//div[@class='_10UF8M'])[3]")).click();
		driver.findElement(By.xpath("(//div[@class='_1AtVbE col-12-12'])[3]")).click();
		driver.findElement(By.xpath("//div[@class='_10UF8M']")).click();
//		driver.navigate().refresh();																								//	To Handle StaleElementReferenceException for single Element
//		WebDriverWait wait = new WebDriverWait(driver, 10);											//	We can use Refresh, Explicit Wait of stalenessOf condition 				
//		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//div[@class='_2kHMtA']"))));
//		for(int i=0; i<10; i++) {																										//	And Try Catch Block within the for loop
//			try {
				driver.findElement(By.xpath("//div[@class='_2kHMtA']")).click();
//				break;
//			}
//			catch(StaleElementReferenceException e){
//			}
//		}
	}
	

	@Test
	public static void ListOfElements() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/mobiles/mi~brand/pr?sid=tyy,4io&otracker=nmenu_sub_Electronics_0_Mi");
		driver.findElement(By.xpath("(//div[@class='_10UF8M'])[3]")).click();
		driver.navigate().refresh();												//	To Handle StaleElementReferenceException while finding List of Elements Only refresh will work
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		int cnt =1;
		for(WebElement e : products) {
				System.out.println(cnt+". "+e.getText());
		}
	}
}
