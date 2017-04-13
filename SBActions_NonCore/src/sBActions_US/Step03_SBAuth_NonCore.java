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
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step03_SBAuth_NonCore {
 
  
  private WebDriver driver;
  
  public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Awaiting buyer action')]") private WebElement Awaiting_SB_auth_link ;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Skill line items')]") private WebElement SkillLineItems ;
	@FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
	@FindBy (name="btnGo") private WebElement GO_reqnum ;
	@FindBy (id="FLD_SUPP_NUMBER") private WebElement SupplierNum ;
	@FindBy (name="btnSearch") private WebElement SearchBtn  ;
	@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a) " ) private WebElement Request_Number ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement Skill_link ;
	@FindBy (name="butSaveAndContinue") private WebElement SaveAndContinue ;
	@FindBy (id="FLD_SUPP_NUMBER" ) private WebElement SuppNum ;
	@FindBy (id="FLD_FAIR_VALUE_ANALYSIS" ) private WebElement FairValueAnalysis ;
	@FindBy (name="btnSaveAndAuth") private WebElement SaveAndAuth ;
	@FindBy (name="BTN_GO") private WebElement ButtonGO ;
	@FindBy (xpath =" .//*[@id='content-main']/table[3]/tbody/tr[2]/td[1]/a" ) private WebElement SupplierID ;
	@FindBy (id ="FLD_MSTR_AGRMNT_NUMBER") private WebElement MastrNum ;
	@FindBy (id="content-main']/form/div[2]/span/span/input") private WebElement ExitReq;
	 	
	// Initialize the web elements 
	public Step03_SBAuth_NonCore(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	
	public void loginSB()
	{
		
		loginToContractor_Link.click();
		
	}
		
	 public void SBAuth ()
     {
 		
 		WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Awaiting_SB_auth_link));
			
			
		Awaiting_SB_auth_link.click();
 		
 		WebDriverWait wait02 = new WebDriverWait(driver, 300);
		wait02.until(ExpectedConditions.visibilityOf(SkillLineItems));
			
		SkillLineItems.click();
 		Req_Num_Search.clear();
 		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
 		GO_reqnum.click();
 		
 		 WebDriverWait wait03 = new WebDriverWait(driver, 160);
 		wait03.until(ExpectedConditions.visibilityOf(Skill_link)); 
 		
 		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
 		
 		Skill_link.click();
 	
 		WebDriverWait wait04 = new WebDriverWait(driver, 300);
		wait04.until(ExpectedConditions.visibilityOf(SaveAndContinue)); 
 	
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		SaveAndContinue.click();
		WebDriverWait wait05 = new WebDriverWait(driver, 300);
		wait05.until(ExpectedConditions.visibilityOf(SaveAndAuth));
		SuppNum.sendKeys("1000118974");
		MastrNum.sendKeys("MA Test");
		FairValueAnalysis.sendKeys("Approve");
	  
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		SaveAndAuth.click();
		
     }
     
  
}