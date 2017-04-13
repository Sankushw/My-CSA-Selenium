package step2_Adding_Response;

import org.testng.annotations.Test;

import lib.Excel;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page04_ResponseSummaryAndSubmit {

	private WebDriver driver;

	@FindBy(xpath = ".//*[@id='ibm-content-main']//input[@class='ibm-btn-arrow-pri' and @title='Continue']")
	private WebElement Continue;
	@FindBy(xpath = ".//*[@id='ibm-content-main']//input[@class='ibm-btn-arrow-sec' and @title='Edit Response details']")
	private WebElement Edit_Response_details;
	@FindBy(xpath = ".//*[@id='ibm-content-main']//input[@class='ibm-btn-arrow-pri' and @title='Submit responses' ]")
	private WebElement Submit_responses;

	// Initialize the web elements
	public Page04_ResponseSummaryAndSubmit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void RespSummaryandsubmit() {

		WebDriverWait wait2 = new WebDriverWait(driver, 160);
		wait2.until(ExpectedConditions.visibilityOf(Edit_Response_details));

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

		WebDriverWait wait3 = new WebDriverWait(driver, 160);
		wait3.until(ExpectedConditions.visibilityOf(Submit_responses));

		Submit_responses.click();

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		File srcFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String filename = "C:\\Users\\IBM_ADMIN\\Desktop\\Snap" + System.currentTimeMillis() + ".png";
			FileUtils.copyFile(srcFile1, new File(filename));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error...............");

		}

	}
}
