package step3_SBAuthorization;


import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

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

public class Page1_SBauthoriz {
 
  
  private WebDriver driver;
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	
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
 	@FindBy (name="btnSaveAndAuth") private WebElement SaveAndAuth ;
 	@FindBy (xpath = ".//*[@id='content-main']/form/div[2]/span/span/input") private WebElement ExitReq;
	
 	
 	private String getReqNum(String Req_Num) 
	{
		
		return ".//*[@id='content-main']//a[contains(text(),'"+ Req_Num +"')]";
	}
	
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		
	
	// Initialize the web elements 
	public Page1_SBauthoriz(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login and auth to the application
 
	
	 public void SBAuth ()
     {
		 
		 loginToContractor_Link.click();
 		
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
 		
 			
 			/* code to capture screenshot */
 			 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
 						
 		
 	Skill_link.click();
		

 	WebDriverWait wait07 = new WebDriverWait(driver, 160);
		wait07.until(ExpectedConditions.visibilityOf(SaveAndContinue)); 
 	
		/* code to capture screenshot */
		 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
					
 	
		SaveAndContinue.click();
		
 	
 	 WebDriverWait wait04 = new WebDriverWait(driver, 160);
		wait04.until(ExpectedConditions.visibilityOf(SaveAndAuth)); 
		
		SuppNum.sendKeys("1000118974");
		
		FVAText.sendKeys("Authoriszed");                       
		
		
		/* code to capture screenshot */
		 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
					
		
		SaveAndAuth.click();
 	
		driver.switchTo().alert().accept();
		
		

	    WebDriverWait wait08 = new WebDriverWait(driver, 160);
		wait04.until(ExpectedConditions.visibilityOf(ExitReq)); 
		
		
		
		/* code to capture screenshot */
		 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
					
 		
     }
	
}
