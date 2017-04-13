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

public class Step05_CRBAuthNC_IN {
 
  
  private WebDriver driver;
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Awaiting client review board action')]") private WebElement Awaiting_CRB_auth_link ;
	@FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
	@FindBy (name="btnGo") private WebElement GO_reqnum ;
	@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a) " ) private WebElement Request_Number ;
	@FindBy (name="FLD_MULTI_LINE_ITEMS") private WebElement  Select_Checkbox ;
	@FindBy (name = "btnAuthFin") private WebElement Auth_Btn;
	@FindBy (name = "btnAuthSel") private WebElement Auth_Sel;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Skill line items')]") private WebElement SkillLineItems ;
	@FindBy (xpath =".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[4]") private WebElement Project_Name;
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Initialize the web elements 
	public Step05_CRBAuthNC_IN(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Function to login to the application
	
	public void crblogin()
	{
		
		loginToContractor_Link.click();
  
    }

	//Function to click Create New Request button
    public void CRB_Auth ()
    {
   		WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Awaiting_CRB_auth_link));
		
		
		Awaiting_CRB_auth_link.click();
		
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(SkillLineItems));
		
		SkillLineItems.click();
		Req_Num_Search.clear();
		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 15));
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		GO_reqnum.click();

		String Req_Num = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 15) ;
		
		WebDriverWait wait03 = new WebDriverWait(driver, 160);
		wait03.until(ExpectedConditions.visibilityOf(Project_Name)); 
		
		Project_Name.click();
	
		WebDriverWait wait04 = new WebDriverWait(driver, 160);
		wait04.until(ExpectedConditions.visibilityOf(Auth_Btn));
	
	    Select_Checkbox.click();
	    /* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		Auth_Btn.click();
		
		
    
	WebDriverWait wait05 = new WebDriverWait(driver, 160);
	wait05.until(ExpectedConditions.visibilityOf(Auth_Sel));

	/* code to capture screenshot */
	Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
	
	Auth_Sel.click();
	
	//CRB Comments Page
	
	/* code to capture screenshot */
	Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
    }
}