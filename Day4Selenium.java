package automation_collections_practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day4Selenium {
	
	WebDriver driver;

	@BeforeMethod
	public void openWeb() {
		
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	@AfterMethod
	public void closeApp() {
		driver.quit();
	}
	
	@Test
	public void windowHandles() throws Exception {
		
		String parentHandle = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//*[text()='Click Here']")).click();
		
		Thread.sleep(2000);
		
		Set<String> allHandles = driver.getWindowHandles();
		
		System.out.println("No of winodws: "+allHandles.size());
		
		for (String ref : allHandles) {
			if (!ref.equals(parentHandle)) {
			driver.switchTo().window(ref);
			}
		}
		Assert.assertEquals(driver.getTitle(), "New Window");
		
		System.out.println(driver.getTitle());
		
		
		driver.close();
		
		driver.switchTo().window(parentHandle);
		
	
	}

}
