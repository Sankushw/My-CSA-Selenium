package step3_RIPC_Verify_Received_Response;

import org.testng.annotations.Test;

import lib.Excel;

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

public class Page01_RIPCLoginAndOpenRequest {

	private WebDriver driver;

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";

	// Define the element
	@FindBy(xpath = ".//*[@id='content-main']/p[2]/a")
	private WebElement loginToContractor_Link;
	@FindBy(xpath = ".//*[@id='left-nav']//a[contains(text(), 'Search')]")
	private WebElement LHS_Search_tab;
	@FindBy(id = "FLD_REQ_NUM_SEARCH")
	private WebElement Request_Num_Fld;
	@FindBy(name = "GO")
	private WebElement Search_GO_btn;
	@FindBy(xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[1]/a")
	private WebElement Request_Num_link;
	@FindBy(xpath = ".//*[@id='content-main']/form/table[1]/tbody/tr[1]/td[3]/a")
	private WebElement Skill_link;
	@FindBy(xpath = ".//*[@id='nonFinalCandForm']/table[1]/tbody/tr[2]/td[2]/a")
	private WebElement Response_Identification;

	// Initialize the web elements
	public Page01_RIPCLoginAndOpenRequest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Function to login to the application

	public void loginAndOpenReq() {

		loginToContractor_Link.click();

		LHS_Search_tab.click();

		WebDriverWait wait = new WebDriverWait(driver, 160);
		wait.until(ExpectedConditions.visibilityOf(Request_Num_Fld));

		Request_Num_Fld.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));

		Search_GO_btn.click();

		WebDriverWait wait1 = new WebDriverWait(driver, 160);
		wait1.until(ExpectedConditions.visibilityOf(Request_Num_link));

		Request_Num_link.click();

		WebDriverWait wait3 = new WebDriverWait(driver, 160);
		wait3.until(ExpectedConditions.visibilityOf(Skill_link));

		Skill_link.click();

		WebDriverWait wait4 = new WebDriverWait(driver, 160);
		wait4.until(ExpectedConditions.visibilityOf(Response_Identification));

		Response_Identification.click();

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

	}
}
