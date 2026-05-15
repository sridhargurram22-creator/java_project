package automation_collections_practice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumDay1{
	
	WebDriver driver;
	
	@BeforeMethod
	public void openApp() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test
	public void ts1() throws Exception {
		SeleniumDay1POM base = new SeleniumDay1POM(driver);
		base.loginFb("Sridhar", "1234567890");
		Thread.sleep(2000);
		
	}
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}

}
