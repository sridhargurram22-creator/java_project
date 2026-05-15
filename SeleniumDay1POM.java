package automation_collections_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SeleniumDay1POM {
	
	WebDriver driver;
	
	@FindBy (name = "email") WebElement username;
	@FindBy (name = "pass") WebElement password;
	@FindBy (xpath = "//*[@aria-label=\"Log in\"]") WebElement login;

	
	
	public SeleniumDay1POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginFb(String name, String pass) {
		
		username.sendKeys(name);
		password.sendKeys(pass);
		login.click();
	}
	
	
}
