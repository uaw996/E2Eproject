package MyFirstProject;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;




public class HomePage extends base {
	
	public WebDriver driver;
	Logger log = LogManager.getLogger(ValidateNavigation.class.getName());
	
	
	
	@BeforeTest
	public void initilization() throws IOException {
		
		driver = initializerDriver();
		log.info("driver initialization");
		
	
	}
			
	
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String userId, String pass) throws IOException {

			
		//there are two ways to call class 
		//1. by inheritance
		//2. By creating object that class and invoke the methods of it
		driver.get(prop.getProperty("url"));
		log.info("url launch");
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		log.debug("Click login button");
		LoginPage lg = new LoginPage(driver);
		lg.getUserName().sendKeys(userId);
		lg.getPassword().sendKeys(pass);
		lg.clickLoginBtn().click();
		
		log.debug("Click on submit button");
	//	Assert.assertTrue(driver.getCurrentUrl().endsWith("failed"));
		
	}
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][2];
		data[0][0] = "abd@gmail.com";
		data[0][1] = "123466";
		
		data[1][0] = "sjdjssjs@gmail.com";
		data[1][1] = "12djsfsj3466";
		
		
		
		
		return data;
		
	}

	@AfterTest
	public void tearDown() {
		
		driver.close();
		log.info("window closed successfully");
		
	}
	
}
