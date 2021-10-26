package seleniumSessions;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shadowroot {
	
	@Test
	public static void shadow() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("chrome://downloads/");
		WebElement root = driver.findElement(By.cssSelector("downloads-manager"));
		WebElement shadowroot1 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", root);
		WebElement root2 = shadowroot1.findElement(By.cssSelector("downloads-toolbar"));
		WebElement shadowroot2 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", root2);
		WebElement root3 = shadowroot2.findElement(By.cssSelector("cr-toolbar"));
		WebElement shadowroot3 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", root3);
		WebElement root4 = shadowroot3.findElement(By.cssSelector("cr-toolbar-search-field"));
		WebElement shadowroot4 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", root4);
		shadowroot4.findElement(By.id("searchInput")).sendKeys("Gupta");
	}

}
