package step2_ENCauthorization;


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


public class Page2_ENCauth 
{
	
	WebDriver driver;
	
	// Define all web elements under test displayed on home page
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Awaiting executive noncore approver action')]") private WebElement Awaiting_ENC_auth_link ;
    @FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
	@FindBy (name="btnGo") private WebElement GO_reqnum ;
	@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a) " ) private WebElement Request_Number ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement Skill_link ;
	@FindBy (id="FLD_CMTS_TO_REQSTR") private WebElement ENC_Comments;
	//@FindBy (name="butnSaveAndContinue") private WebElement SaveAndAuthorize ;
	@FindBy (id="content-main']/form/div[2]/span/span/input") private WebElement ExitReq;
	@FindBy (id="btnSearch") private WebElement SearchBtn ;
	@FindBy (id="FLD_SUPP_NUMBER" ) private WebElement SuppNum ;
	@FindBy (id="FLD_FAIR_VALUE_ANALYSIS" ) private WebElement FVAText ;
 	@FindBy (name="btnSaveAndAuth") private WebElement SaveAndAuth ;
	
	
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		
	
		// Initialize the web elements 
		public Page2_ENCauth(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
	
		
		//Function to click Create New Request button
        public void ENCAuth ()
        {
    		
    		WebDriverWait wait02 = new WebDriverWait(driver, 180);
			wait02.until(ExpectedConditions.visibilityOf(Awaiting_ENC_auth_link));
			
			
			Awaiting_ENC_auth_link.click();
    		
			Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
    		GO_reqnum.click();
    		 WebDriverWait wait03 = new WebDriverWait(driver, 160);
    			wait03.until(ExpectedConditions.visibilityOf(Skill_link)); 
    		
    	Skill_link.click();
    	
    	WebDriverWait wait07 = new WebDriverWait(driver, 160);
 		wait07.until(ExpectedConditions.visibilityOf(SaveAndAuth)); 
 		ENC_Comments.sendKeys("Approved");
 		
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
    	
	SaveAndAuth.click();
 		
 		
 		
    	
    	 WebDriverWait wait04 = new WebDriverWait(driver, 160);
 		wait04.until(ExpectedConditions.visibilityOf(ExitReq)); 
 		
 		
 		
 		
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
    	
    	
    		
        	
        }
        
     
}


