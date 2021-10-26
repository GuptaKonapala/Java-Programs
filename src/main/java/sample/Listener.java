package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class Listener extends Makemy implements WebDriverEventListener{

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Alert Presented");
		
	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("Alert Accepted");
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Alert Dismissed");
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Alert Presented");
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigating to "+url);
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to "+url);
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating to back");
		
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated to back");
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating to forward");
		
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated to forward");
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Refreshing");
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Refreshed");
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Finding the element "+element);
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found the element "+element);
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicking the element "+element);
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Element clicked "+element);
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

}
