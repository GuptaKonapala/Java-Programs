package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Makemy {
	
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static Listener eventlistener;
	
	public static void select(List<WebElement> list, String name) {
	    for(WebElement e : list) {
	    	if(e.getText().contains(name)) {
	    		e.click();
	    		break;
	    	}
	    }
	}
	
	public static void stringlist(List<WebElement> list, List<String> newlist, String format) {
		for(WebElement e : list) {
			newlist.add(e.getText().replaceAll("[^"+format+"]", ""));
		}
	}
	
	public static List<Integer> stringsort(List<String> list) {
		List<Integer> num = new ArrayList<Integer>();
		for(String e: list) {
			num.add(Integer.parseInt(e));
		}
		Collections.sort(num);
		return num;
	}
	
	public static void destination(String name) {
		driver.findElement(By.xpath("//li[@role='option']//div//div//p[contains(., '"+name+"')]")).click();
	}
	
	public static void date(String monthyear, int date) {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.NANOSECONDS);
		boolean flag = false;
		while(flag==false) {
		try {
			driver.findElement(By.xpath("//div[text()='"+monthyear+"']/parent::div/following-sibling::div[2]//div//div//div//p[text() = '"+date+"']/parent::div/parent::div")).click();
			break;
		} 
		catch (NoSuchElementException e1) {
		} 
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
	}
	
	public static void passengers(int adults, int child, int infant) {
		driver.findElement(By.xpath("//label[@for='travellers']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-"+adults+"']")).click();
		driver.findElement(By.xpath("//li[@data-cy='children-"+child+"']")).click();
		driver.findElement(By.xpath("//li[@data-cy='infants-"+infant+"']")).click();
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
	}
	
	public static void travelclass(String clas) {
		driver.findElement(By.xpath("//label[@for='travellers']")).click();
		driver.findElement(By.xpath("//li[text()='"+clas+"']")).click();
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
	}
	
	public static void filter(String filtername) {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.NANOSECONDS);
		boolean flag = false;
		while(flag==false) {
		try {
			driver.findElement(By.xpath("//div[@class=\"filtersOuter\"]//div//label//div//span//span//span[contains(text(), '"+filtername+"')]/parent::span/parent::span/preceding-sibling::span//span[@class='box']")).click();
			break;
		}
		catch(ElementNotInteractableException e) {
			driver.findElement(By.xpath("//span[contains(text(),'more')]")).click();
			}
		}
	}
	
	//@Test
	public static void makemytrip() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		e_driver = new EventFiringWebDriver(driver);
		eventlistener = new Listener();
		e_driver.register(eventlistener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				}
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//input[@data-cy='toCity']"))).perform();
	    driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Mumbai");
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			}
	    List<WebElement> destinations = driver.findElements(By.xpath("//ul//li[@role='option']"));
	    select(destinations, "Shiva");
		//destination("Shiva");
		date("October 2021", 23);
		passengers(4, 3, 2);
		travelclass("Premium Economy");
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> price = driver.findElements(By.xpath("//p[@class='blackText fontSize18 blackFont white-space-no-wrap']"));
		List<String> prices = new ArrayList<String>();
		stringlist(price, prices, "0-9");
		System.out.println(prices);
		System.out.println(stringsort(prices));
		List<WebElement> filters = driver.findElements(By.xpath("//div[@class='filtersOuter']//div//label"));
		select(filters, "1 Stop");
		//filter("Spice");
		driver.findElement(By.xpath("//button[starts-with(@id,'bookbutton')]")).click();
		driver.findElement(By.xpath("//button[text()='Book Now']")).click();
		List<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
//		Set<String>windows = driver.getWindowHandles();
//		Iterator<String> it = windows.iterator();
//		String window1= it.next();
//		String window2= it.next();
//		driver.switchTo().window(window2);
		driver.findElement(By.xpath("//div//span[2][contains(text(),'Base Fare')]")).click();
		driver.switchTo().window(tabs.get(0));
		WebElement tar = driver.findElement(By.xpath("//div[@tabindex='0']"));
	}
	
	@Test
	public static void flipkart() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		e_driver = new EventFiringWebDriver(driver);
		eventlistener = new Listener();
		e_driver.register(eventlistener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/mens-formal-shirts/pr?sid=clo,ash,axc,mmk,bk1&fm=neo%2Fmerchandising&iid=M_76219d12-e91e-4756-a81a-82bcd3f23a27_1_372UD5BXDFYS_MC.V795R35ST9K6&otracker=hp_rich_navigation_4_1.navigationCard.RICH_NAVIGATION_Fashion~Men%2527s%2BTop%2BWear~Men%2527s%2BFormal%2BShirts_V795R35ST9K6&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_4_L2_view-all&cid=V795R35ST9K6");
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3']"));
		int count =1;
		for(WebElement e : price) {
			System.out.println(count+++". "+e.getText());
		}
	}
}
