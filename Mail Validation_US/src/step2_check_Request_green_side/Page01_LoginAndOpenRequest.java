package step2_check_Request_green_side;

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



public class Page01_LoginAndOpenRequest
{
	
private WebDriver driver;

public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='ibm-content-main']//a[contains(text(),'Sign in to CSA.')]"   ) private WebElement Sign_in_to_CSA ;
	
	@FindBy (xpath = ".//*[@id='ibm-primary-links']//a[contains(text(), 'CSA search')] " ) private WebElement CSA_search_tab ;
	@FindBy ( id = "FLD_REQ_NUM_SEARCH" ) private WebElement Req_Num_field ;
	@FindBy (xpath =".//*[@id='ibm-content-main']//input[@class='ibm-btn-arrow-pri'and @title='Search'] ") private WebElement Search_btn ; 
	
		
	
	
	// Initialize the web elements 
	public Page01_LoginAndOpenRequest (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	// Click on the link again as workaround 
	public void login(){
		
		Sign_in_to_CSA.click();
		
		CSA_search_tab.click();
	
		
		WebDriverWait wait = new WebDriverWait(driver, 160);
		wait.until(ExpectedConditions.visibilityOf(Req_Num_field));
        
		Req_Num_field.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
		
		Search_btn.click();
		
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
		
		
		
		
  }

}
