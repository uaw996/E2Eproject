package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;





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
		
		public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
//			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// you can also write above statement 
			String dateName = new SimpleDateFormat("hh mm ss").format(new Date());
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source =  ts.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir")+"\\screenShots\\"+testCaseName+""+dateName+".png";
			 
			 FileHandler.copy(source,new File(destinationFile));

			return destinationFile;
		
	} 
		
		@AfterClass
		public void tearDown() {
			
			driver.close();
//			log.info("driver close successfuly");
			
		}
	
	
	

}
