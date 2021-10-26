package javascriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MethodsinJavascriptExecutor {
	
	WebDriver driver;
	JavascriptExecutor js;
	WebElement loginbtn;
	WebElement career;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//button[@class = '_2KpZ6l _2doB4z']")).click();
		js = (JavascriptExecutor)driver;
		loginbtn = driver.findElement(By.linkText("Login"));
		career = driver.findElement(By.linkText("Careers"));
	}
	@Test
	public void border() {
		js.executeScript("arguments[0].style.border = '3px solid red' ", loginbtn);
	}
	@Test
	public void alert() {
		String message = "Alert-------> this is an alert";
		js.executeScript("alert(' "+message+" ')");
	}
	@Test
	public void click() {
		js.executeScript("arguments[0].click();", loginbtn);
	}
	@Test
	public void refresh() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("history.go(0)");
	}
	@Test
	public void title() {
		String titil = js.executeScript("return document.title;").toString();
		System.out.println(titil);
	}
	@Test
	public void innerText() {
		String text = js.executeScript("return document.documentElement.innerText;").toString();
		System.out.println(text);
	}
	@Test
	public void scrollPageDown() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("window.scrollTo(0,documet.body.scrollHeight)");
	}
	@Test
	public void scrolltoelement() {
		js.executeScript("arguments[0].scrollIntoView(true);", career);
		career.click();
	}
}
