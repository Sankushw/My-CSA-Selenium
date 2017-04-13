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
import org.openqa.selenium.support.ui.Select;

import lib.Excel;

public class Page11_RequestSummary {
	WebDriver driver;

	@FindBy(name = "Submit request")
	private WebElement SubmitRequest;

	// Initialize the web elements
	public Page11_RequestSummary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void RequestSummaryPage()

	{

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
		SubmitRequest.click();

	}
}