package automation_collections_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day3Selenium {
	
	WebDriver driver;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	@BeforeMethod
	public void openWeb() {
		
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dropdown");
		
		driver.manage().window().maximize();
		
		
		
	}
	
	@AfterMethod
	public void closeApp() {
		driver.quit();
	}
	
	@Test
	public void ts1() throws Exception {
		
		WebElement dropDown = driver.findElement(By.id("dropdown"));
		
		Select s = new Select(dropDown);
		
		Thread.sleep(2000);
		
		s.selectByIndex(1);
		
		Thread.sleep(3000);
		
		s.selectByValue("2");
		
		Thread.sleep(3000);
		
		s.selectByVisibleText("Option 1");
		
		Thread.sleep(3000);
		
	}
	
	
	
	

}
