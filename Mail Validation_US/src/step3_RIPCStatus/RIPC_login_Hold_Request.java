package step3_RIPCStatus;

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

public class RIPC_login_Hold_Request {
 
  
  private WebDriver driver;
  
  public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Search')]") private WebElement Search ;
	@FindBy ( id="FLD_REQ_NUM_SEARCH") private WebElement Request_Num ;
	@FindBy ( name="GO") private WebElement Go_btn ;
	@FindBy  ( xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[1]/a") private WebElement ReqNumlink ;
	@FindBy ( xpath = ".//*[@id='content-main']/form/div[2]/span/span[1]/input") private WebElement Hold_skill ;
	@FindBy ( name="btnSaveAndContinue") private WebElement save_and_continue ;
	@FindBy ( name="TBLCOL_REASON") private WebElement Reason ;
	@FindBy ( name="TBLCOL_COMMENTS") private WebElement Comments ;
	
	
	
	
	// Initialize the web elements 
	public RIPC_login_Hold_Request(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	// Click on the link again as workaround 
	public void login(){
		
		loginToContractor_Link.click();
		Search.click();
		
		Request_Num.sendKeys(Excel.getCellValue(xlsFilePath,"Request_creation", 1, 15));
		Go_btn.click();
		
		
		ReqNumlink.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 160);
		wait1.until(ExpectedConditions.visibilityOf(Hold_skill));
		
		 /* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

	try {
		String filename = "C:\\Users\\IBM_ADMIN\\Desktop\\Snap"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(srcFile1, new File (filename));





	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Error...............");
		
	}
		
		
		
		Hold_skill.click();
		
		
		
		
	WebDriverWait wait2 = new WebDriverWait(driver, 160);
	wait2.until(ExpectedConditions.visibilityOf(save_and_continue));
	
	Reason.sendKeys("Other");
	
	Comments.sendKeys("test");
	
	 /* code to capture screenshot */
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

File srcFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

try {
	String filename = "C:\\Users\\IBM_ADMIN\\Desktop\\Snap"+System.currentTimeMillis()+".png";
	FileUtils.copyFile(srcFile2, new File (filename));





} catch (IOException e) {
	// TODO Auto-generated catch block
	System.out.println("Error...............");
	
}
	
	
	
	save_and_continue.click();
	
	
	 /* code to capture screenshot */
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

File srcFile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

try {
	String filename = "C:\\Users\\IBM_ADMIN\\Desktop\\Snap"+System.currentTimeMillis()+".png";
	FileUtils.copyFile(srcFile3, new File (filename));





} catch (IOException e) {
	// TODO Auto-generated catch block
	System.out.println("Error...............");
	
}
  
  }
}
