package practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascript {
	
	WebDriver driver;
	WebElement kids;
	JavascriptExecutor js;
	WebElement feedback;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.hotstar.com/in");
		kids = driver.findElement(By.xpath("//div[@class = 'iconClass kids']"));
		js = (JavascriptExecutor)driver;
		feedback = driver.findElement(By.linkText("Feedback"));
	}
	
	@Test
	public void flash() {																														//			highlight element
		String bgcolor = kids.getCssValue("backgroundColor");
		for(int i = 0; i<10; i++) {
		js.executeScript("arguments[0].style.backgroundColor =  ' red ' " , kids);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("arguments[0].style.backgroundColor = ' "+bgcolor+" ' ", kids);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	@Test
	public void border() {																													//			border element
		js.executeScript("arguments[0].style.border = '3px solid red' ", kids);
	}
	@Test			
	public void explicitwait() {																											//			explicit wait
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(kids));
		kids.click();
	}
	@Test
	public void screenshot() {																											//			screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("E:\\Java_Selenium\\ACSF\\src\\test\\java\\screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void click() {																														//				click
		js.executeScript("arguments[0].click()", kids);
	}
	@Test
	public void refresh() {																													//				refresh
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("history.go(0)");
	}
	@Test
	public void alert() {																														//				alert
		js.executeScript("alert('Alert')");
	}
	@Test
	public void title() {																															//				title
		String name = js.executeScript("return document.title").toString();
		System.out.println(name);
	}
	@Test
	public void pageText() {																												//				page text
	String test = js.executeScript("return document.documentElement.innerText;").toString();
	System.out.println(test);
	}
	@Test
	public void scrolltoend() {																											//				scroll to end
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	@Test
	public void scrolltoelement() {																									//				scroll to element
		js.executeScript("arguments[0].scrollIntoView(true)",feedback);
		feedback.click();
	}

}
