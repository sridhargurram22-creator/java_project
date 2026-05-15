package automation_collections_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day2Selenium {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void openWeb() {
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#start button")));
		
		
	}
	
	@AfterMethod
	public void closeWeb() {
		driver.quit();
	}
	
	@Test
	public void ts1() {
		
		
		driver.findElement(By.cssSelector("#start button")).click();
		
		SoftAssert s = new SoftAssert();
		
		try {
		WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']")));
		System.out.println(result.getText());
		s.assertEquals(result.getText(), "Hello World!");
		}
		catch (TimeoutException e) {
			Assert.fail("Dynamic element did not appear within timeout: " + e.getMessage());
		}
		
	
		
		s.assertAll();
	}

}
