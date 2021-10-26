package seleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Graphandsvg {
	
	@Test
	public static void svg() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.covid19india.org/");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[4]/div[2]/div/div[9]/div[1]")).click();
		List<WebElement> svg = driver.findElements(By.xpath("(//*[name()='svg' and @preserveAspectRatio])[8]//*[local-name()='circle']"));
		Actions action = new Actions(driver);
		int i =0;
		for(WebElement ele : svg) {
			action.moveToElement(ele).perform();
			System.out.println(i+1+". "+driver.findElement(By.xpath("//div[@class='svg-parent fadeInUp is-confirmed']//div[@class='stats-bottom']/h2")).getText());
			i++;
		}
	}

}
