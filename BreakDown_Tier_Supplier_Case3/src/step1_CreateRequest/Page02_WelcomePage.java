package step1_CreateRequest;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page02_WelcomePage {

	WebDriver driver;

	// Define all web elements under test displayed on home page
	@FindBy(xpath = ".//*[@id='content-main']/form[1]/div/span/input")
	private WebElement Create_New_Request;

	// Initialize the web elements
	public Page02_WelcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Function to click Create New Request button
	public void Create_New_Request() {
		WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Create_New_Request));

		Create_New_Request.click();

	}

}
