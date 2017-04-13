package sBActions_IN;


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

public class Step03_SBReject_NC_IN {
 
  
  private WebDriver driver;
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	
	@FindBy (xpath = ".//*[@id='left-nav']/div/a[4]") private WebElement awaiting_buyer_action ; 
	//@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Candidates')]") private WebElement Candidates ;
	@FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
	@FindBy (xpath = ".//*[@id='left-nav']/div/div/a[1]") private WebElement SkillLineItems ;
	@FindBy (name="btnGo") private WebElement GO_reqnum ;
	@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a) " ) private WebElement Request_Number ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement Skill_link ;
	@FindBy (name="butSaveAndContinue") private WebElement SaveAndContinue ;
	@FindBy (name="FLD_MULTI_LINE_ITEMS") private WebElement  Select_Checkbox ;
	@FindBy (name = "btnSaveAndReject") private WebElement Save_and_Reject;
	@FindBy (id="FLD_SUPP_NUMBER" ) private WebElement SuppNum ;
	@FindBy (id="FLD_FAIR_VALUE_ANALYSIS" ) private WebElement FairValueAnalysis ;
	@FindBy (name = "FLD_CMTS_TO_REQSTR") private WebElement CommentsToReq;
	
	@FindBy (name ="btnRejectSel") private WebElement Reject;
	@FindBy (name = "FLD_REJ_REASON") private WebElement Reason;
	@FindBy (xpath=".//*[@id='FLD_CMTS_TO_REQSTR']") private WebElement Comments;
	@FindBy (name = "btnAuthSel") private WebElement Auth_Sel;
	
	@FindBy (xpath =".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[4]") private WebElement Project_Name;
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Initialize the web elements 
	public Step03_SBReject_NC_IN(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Function to login to the application
	
	public void sblogin()
	{
		
		loginToContractor_Link.click();
  
    }

	//Function to click Create New Request button
    public void SB_Reject ()
    {
   		WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(awaiting_buyer_action));
		
		
		awaiting_buyer_action.click();
		
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(SkillLineItems));
		
		SkillLineItems.click();
		
		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 15));
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
		wait05.until(ExpectedConditions.visibilityOf(Save_and_Reject));
		SuppNum.sendKeys("A0359");
		CommentsToReq.sendKeys("Rejected");
		//MastrNum.sendKeys("MA Test");
		FairValueAnalysis.sendKeys("rejected");
		
	  
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		Save_and_Reject.click();
		driver.switchTo().alert().accept();
		
    }
}