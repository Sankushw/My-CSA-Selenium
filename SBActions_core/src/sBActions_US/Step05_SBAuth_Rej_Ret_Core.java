package sBActions_US;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step05_SBAuth_Rej_Ret_Core {
 
  
  private WebDriver driver;
  
  public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Awaiting buyer action')]") private WebElement Awaiting_Buyer_action ;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Candidates')]") private WebElement Candidates ;
	@FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
	@FindBy (name="btnGo") private WebElement GO_reqnum ;
	
	@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a" ) private WebElement Request_Number ;
	//@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement Skill_link ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[5]/a" ) private WebElement Resp_identification1 ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[3]/td[5]/a" ) private WebElement Resp_identification2 ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[4]/td[5]/a" ) private WebElement Resp_identification3 ;
	@FindBy (name="btnAuthCandidate") private WebElement Auth_Button ;
	@FindBy (name="btnRejectCandidate") private WebElement Reject_Button ;
	@FindBy (name="btnReturnAsFinalistCandidate") private WebElement Return_as_finalist_Button ;
	@FindBy (name="txtSaveAndReturnAsFinalist") private WebElement SaveAndReturn_as_finalist_Button ;
	@FindBy (name="FLD_CMTS_TO_REQSTR") private WebElement CommentsToRequester ;
	
	
	@FindBy (name="FLD_REJ_REASON") private WebElement Reject_Reason ;
	@FindBy (name="btnRejectSel") private WebElement Reject_Selected_Button ;
	
	
	
	
	@FindBy (id="FLD_SUPP_NUMBER") private WebElement SupplierNum ;
	@FindBy (name="btnSearch") private WebElement SearchBtn  ;
	@FindBy (name="butSaveAndContinue") private WebElement SaveAndContinue ;
	@FindBy (id="FLD_SUPP_NUMBER" ) private WebElement SuppNum ;
	@FindBy (id="FLD_FAIR_VALUE_ANALYSIS" ) private WebElement FairValueAnalysis ;
	@FindBy (name="btnAuthSel") private WebElement AuthSelected_Button ;
	
	@FindBy (name="btnSaveAndAuth") private WebElement SaveAndAuth ;
	@FindBy (name="BTN_GO") private WebElement ButtonGO ;
	@FindBy (xpath =" .//*[@id='content-main']/table[3]/tbody/tr[2]/td[1]/a" ) private WebElement SupplierID ;
	@FindBy (id ="FLD_MSTR_AGRMNT_NUMBER") private WebElement MastrNum ;
	@FindBy (id="content-main']/form/div[2]/span/span/input") private WebElement ExitReq;
	 	
	// Initialize the web elements 
	public Step05_SBAuth_Rej_Ret_Core(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	
	public void loginSB()
	{
		
		loginToContractor_Link.click();
		
	}
		
	 public void SB_open_Request ()
     {
 		
 		WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Awaiting_Buyer_action));
			
		Awaiting_Buyer_action.click();
 		
 		Candidates.click();
 		
 		WebDriverWait wait02 = new WebDriverWait(driver, 300);
		wait02.until(ExpectedConditions.visibilityOf(Req_Num_Search));
		
 		Req_Num_Search.clear();
 		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
 		GO_reqnum.click();
 		
 		WebDriverWait wait03 = new WebDriverWait(driver, 160);
 		wait03.until(ExpectedConditions.visibilityOf(Request_Number)); 
 		
 		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
 		
		Request_Number.click();
		
     }
	 
	// Auth 1st response
	 
	 public void SB_Auth_req ()
	 {
 	
 		WebDriverWait wait04 = new WebDriverWait(driver, 300);
		wait04.until(ExpectedConditions.visibilityOf(Resp_identification1)); 
 	
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		Resp_identification1.click();
		WebDriverWait wait05 = new WebDriverWait(driver, 300);
		wait05.until(ExpectedConditions.visibilityOf(Auth_Button));
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		Auth_Button.click();
		
		WebDriverWait wait06 = new WebDriverWait(driver, 300);
		wait06.until(ExpectedConditions.visibilityOf(AuthSelected_Button));
		
		//SuppNum.sendKeys("1000118974");
		//MastrNum.sendKeys("MA Test");
		FairValueAnalysis.sendKeys("Approve");
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		AuthSelected_Button.click();
	 
			
     }
	 
	 //Reject 2nd response
	 
	 public void SB_Rej_req ()
	 {
 	
 		WebDriverWait wait04 = new WebDriverWait(driver, 300);
		wait04.until(ExpectedConditions.visibilityOf(Resp_identification2)); 
 	
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		Resp_identification2.click();
		WebDriverWait wait05 = new WebDriverWait(driver, 300);
		wait05.until(ExpectedConditions.visibilityOf(Reject_Button));
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		Reject_Button.click();
		
		WebDriverWait wait06 = new WebDriverWait(driver, 300);
		wait06.until(ExpectedConditions.visibilityOf(Reject_Selected_Button));
		
		
		Select st = new Select(Reject_Reason);
		st.selectByVisibleText("Does not meet requirement"); 
		
		//SuppNum.sendKeys("1000118974");
		//MastrNum.sendKeys("MA Test");
		FairValueAnalysis.sendKeys("Rejected");
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		Reject_Selected_Button.click();
	  
		
		
     }
	 
	 
	 //return 3rd response
	 
	 public void SB_Return_req ()
	 {
 	
 		WebDriverWait wait04 = new WebDriverWait(driver, 300);
		wait04.until(ExpectedConditions.visibilityOf(Resp_identification3)); 
 	
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		Resp_identification3.click();
		
		WebDriverWait wait05 = new WebDriverWait(driver, 300);
		wait05.until(ExpectedConditions.visibilityOf(Return_as_finalist_Button));
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		
		Return_as_finalist_Button.click();
		
		
		WebDriverWait wait06 = new WebDriverWait(driver, 300);
		wait06.until(ExpectedConditions.visibilityOf(SaveAndReturn_as_finalist_Button));
		
		CommentsToRequester.sendKeys("Returned as finalist");
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		SaveAndReturn_as_finalist_Button.click();
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");

		
     }
	 
     
  
}