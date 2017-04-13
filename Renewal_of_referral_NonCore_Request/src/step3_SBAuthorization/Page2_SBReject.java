package step3_SBAuthorization;


import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Click;

import lib.Excel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Page2_SBReject 
{
	
	WebDriver driver;
	
	// Define all web elements under test displayed on home page
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Awaiting buyer action')]") private WebElement Awaiting_SB_auth_link ;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Skill line items')]") private WebElement SkillLineItems ;
	@FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
	@FindBy (name="btnGo") private WebElement GO_reqnum ;
	@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a) " ) private WebElement Request_Number ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement Skill_link ;
	@FindBy (name="butSaveAndContinue") private WebElement SaveAndContinue ;
	@FindBy (id="btnSearch") private WebElement SearchBtn ;
	@FindBy (id="FLD_SUPP_NUMBER" ) private WebElement SuppNum ;
	@FindBy (id="FLD_FAIR_VALUE_ANALYSIS" ) private WebElement FVAText ;
 	@FindBy (name="btnSaveAndReject") private WebElement SaveAndReject ;
	
	private String getReqNum(String Req_Num) 
	{
		
		return ".//*[@id='content-main']//a[contains(text(),'"+ Req_Num +"')]";
	}
	
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		
	
		// Initialize the web elements 
		public Page2_SBReject(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
	
		
		//Function to click Create New Request button
        public void SBReject ()
        {
    		
    		WebDriverWait wait02 = new WebDriverWait(driver, 180);
			wait02.until(ExpectedConditions.visibilityOf(Awaiting_SB_auth_link));
			
			
			Awaiting_SB_auth_link.click();
    		
    		WebDriverWait wait06 = new WebDriverWait(driver, 180);
			wait06.until(ExpectedConditions.visibilityOf(SkillLineItems));
			
			SkillLineItems.click();
    		
    		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
    		GO_reqnum.click();
    		
    		 WebDriverWait wait03 = new WebDriverWait(driver, 160);
    			wait03.until(ExpectedConditions.visibilityOf(Skill_link)); 
    		
    	Skill_link.click();
    	
    	WebDriverWait wait07 = new WebDriverWait(driver, 160);
 		wait07.until(ExpectedConditions.visibilityOf(SaveAndContinue)); 
    	
 		/* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

	try {
		String filename = "C:\\Users\\IBM_ADMIN\\Desktop\\Snap"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(srcFile, new File (filename));





	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Error...............");
		
	}
    	
 		SaveAndContinue.click();
 		
 		
 		
    	
    	 WebDriverWait wait04 = new WebDriverWait(driver, 160);
 		wait04.until(ExpectedConditions.visibilityOf(SaveAndReject)); 
 		
 		
 		
 		
 		 /* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

	try {
		String filename = "C:\\Users\\IBM_ADMIN\\Desktop\\Snap"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(srcFile, new File (filename));





	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Error...............");
		
	}
 		
	SaveAndReject.click();
    	
    	
  
    	
    	
    	
    	
    		
        	
        }
        
     
}


