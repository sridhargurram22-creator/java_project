package automation_collections_practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClaudeCode1 {

	public static void main(String[] args) throws Exception {
		
		/*
		 * Q1. Store all links from a webpage in a List and print count
    		(getAllLinks → store in ArrayList)
		 * 
		 */
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		
		System.out.println(alllinks.size());
		
		
		for (WebElement ref :alllinks) {
			System.out.println(ref.getText());
		}
		
		driver.close();

	}

}
