package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseMovements {

	@Test
	public void pointer() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		Actions action =  new Actions(driver);
		action.moveToElement(driver.findElement(By.id("ctl00_HyperLinkLogin"))).build().perform();
		action.moveToElement(driver.findElement(By.linkText("SpiceClub Members"))).build().perform();
		driver.findElement(By.linkText("Sign up")).click();
		Select select = new Select(	driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_DropDownListTitle")));
		select.selectByVisibleText("MR");
		driver.findElement(By.xpath("//*[@id=\"CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxFirstName\"]")).sendKeys("Hey ram");
		driver.findElement(By.cssSelector("#CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxLastName")).sendKeys("how are you");
		driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXINTLMOBILENUMBER")).sendKeys("9839848548");
		driver.findElement(By.id("chkSpiceClubTnC")).click();
		driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldAgentPassword")).sendKeys("passcode");
		driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldPasswordConfirm")).sendKeys("passcode");
		driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_ButtonSubmit")).click();
	}
}
