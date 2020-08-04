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
public class ValidateTitle extends base {
	
	public WebDriver driver;
	
	static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void initilization() throws IOException {
		
		driver = initializerDriver();
		log.info("initialization driver");
		driver.get(prop.getProperty("url"));
		log.info("url launch");
	
	}

	
	@Test()
	public void courseNameTest() throws IOException {

			
		//there are two ways to call class 
		//1. by inheritance
		//2. By creating object that class and invoke the methods of it
		
		LandingPage l = new LandingPage(driver);
	   
		
	    Assert.assertEquals( l.getTitle().getText(), "FEATURED 12COURSES");
	    log.debug("succecfully validate");
	}
	

	@AfterTest
	public void tearDown() {
		
		driver.close();
		log.info("driver close successfuly");
		
	}

	
	}
