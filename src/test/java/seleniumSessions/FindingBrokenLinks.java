package seleniumSessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindingBrokenLinks {
	
	@Test
	public void gettinglinks() throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));						//			Creating a list object which includes all the links
		linkslist.addAll(driver.findElements(By.tagName("img")));										//			Adding the img to the linkslist
		System.out.println(linkslist.size());
		
		List<WebElement> activelinks = new ArrayList<WebElement>();							//			Creating an Arraylist object to store all the activelinks
		
		for (int i = 0; i<linkslist.size(); i++) {																					//			Using for loop to iterate the linkslist value
			if(linkslist.get(i).getAttribute("href")!=null && ! linkslist.get(i).getAttribute("href").contains("javascript")) {
				activelinks.add(linkslist.get(i));
			}
		}
		System.out.println(activelinks.size());
		
		for(int j = 0; j<activelinks.size(); j++) {
			HttpURLConnection connection= (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href")+" --------->"+response);
		}
	}

}
