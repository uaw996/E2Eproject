package MyFirstProject;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateNavigation extends base {
	public WebDriver driver;
	Logger log = LogManager.getLogger(ValidateNavigation.class.getName());
	
	
	@BeforeTest
	public void initilization() throws IOException {
		
		driver = initializerDriver();
		log.info("driver initialization");
		driver.get(prop.getProperty("url"));
		log.info("url launch");
	}

	
	@Test()
	public void cantactbtnTest() throws IOException {

			
		//there are two ways to call class 
		//1. by inheritance
		//2. By creating object that class and invoke the methods of it
		
		LandingPage l = new LandingPage(driver);
		
	   Assert.assertTrue(l.getNavigate().isDisplayed());
		log.debug("successfully navigation button Displayed");
	   
	}
	

	@AfterTest
	public void tearDown() {
		
		driver.close();
		log.info("window closed successfully");
	}

	}
