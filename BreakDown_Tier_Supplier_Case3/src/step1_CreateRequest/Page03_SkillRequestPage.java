package step1_CreateRequest;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page03_SkillRequestPage {
	WebDriver driver;

	// Define all web elements
	@FindBy(id = "FLD_REQ_TYPE1")
	private WebElement Renewal_Request;
	@FindBy(id = "FLD_RENEWAL_TYPE2")
	private WebElement Manual;
	@FindBy(id = "FLD_NORMAL_TYPE10")
	private WebElement Time_material;
	@FindBy(name = "btnContinue")
	private WebElement Continue;

	// Initialize the web elements
	public Page03_SkillRequestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Skill_Request()

	{

		Renewal_Request.click();
		Manual.click();
		Time_material.click();

		/* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String filename = "C:\\Users\\IBM_ADMIN\\Desktop\\Snap" + System.currentTimeMillis() + ".png";
			FileUtils.copyFile(srcFile, new File(filename));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error...............");

		}

		Continue.click();
	}

}
