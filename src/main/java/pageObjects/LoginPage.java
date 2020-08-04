package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By userName = By.id("user_email");
	
	By password = By.id("user_password");
	
	By loginBtn = By.name("commit");
	
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}

	public WebElement getUserName() {
		
		return driver.findElement(userName);
		
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
		
	}
	
	public WebElement clickLoginBtn() {
		
		return driver.findElement(loginBtn);
		
	}
	
	
	

}
