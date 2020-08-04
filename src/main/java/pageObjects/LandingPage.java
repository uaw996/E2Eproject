package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

	By signin = By.xpath("//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a/span");
	By title = By.cssSelector("div[class='text-center']>h2");
	By navigate = By.cssSelector(
			"#homepage > header > div.navbar.navbar-default.navbar-static-top > div > nav > ul > li:nth-child(8) > a");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {

		return driver.findElement(signin);
	}

	public WebElement getTitle() {

		return driver.findElement(title);
	}

	public WebElement getNavigate() {

		return driver.findElement(navigate);
	}

}
