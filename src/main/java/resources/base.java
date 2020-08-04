package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;



public class base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializerDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Umesh\\eclipse-workspace\\EndToEndTesting\\src\\main\\java\\resources\\Data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome") ) {
		//String ch=	System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	        driver = new ChromeDriver();
			
		}
		else if(browserName.equals("firefox") ) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
	        driver = new FirefoxDriver();
			
		}
if(browserName.equals("IE")) {
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
		
		public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
//			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// you can also write above statement 
		
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source =  ts.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir")+"\\screenShots\\"+testCaseName+".png";
			 
			 FileHandler.copy(source,new File(destinationFile));
//		  return destinationFile;
			
		
	} 
	
	
	

}
