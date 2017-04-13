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

public class Step03_Finalize {
 
  
  private WebDriver driver;
  public String str2;
  public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy ( xpath = ".//*[@id='left-nav']/div/a[8]" ) private WebElement LHS_Search_tab ;
	@FindBy ( id="FLD_REQ_NUM_SEARCH" ) private WebElement Request_Num_Fld ;
	@FindBy ( name="GO" ) private WebElement Search_GO_btn ;
	@FindBy ( xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[1]/a" ) private WebElement Request_Num_link ;

	 @FindBy ( xpath = ".//*[@id='content-main']/form/table[1]/tbody/tr[1]/td[3]/a" ) private WebElement Requested_Skill ;
	 //@FindBy(name="tblcolCandId") private WebElement  Resp1_Checkbox ;
	 @FindBy (xpath = ".//*[@value='001~S23D2J~001~1000118974~IBMSAPGC0~SUBM~null'] ") private WebElement Resp1_Checkbox;
	 @FindBy (xpath = ".//*[@value='002~S23D2J~001~1000118974~IBMSAPGC0~SUBM~null'] ") private WebElement Resp2_Checkbox;
	 @FindBy (xpath = ".//*[@value='003~S23D2J~001~1000118974~IBMSAPGC0~SUBM~null'] ") private WebElement Resp3_Checkbox;
	 
	 @FindBy(xpath = ".//*[@value= '001~S23D2J~001~1000118974~IBMSAPGC0~FNLS~0']") private WebElement  Resp1_Check ;
	 @FindBy(xpath = ".//*[@value= '002~S23D2J~001~1000118974~IBMSAPGC0~FNLS~0']") private WebElement  Resp2_Check ;
	 @FindBy(xpath = ".//*[@value= '003~S23D2J~001~1000118974~IBMSAPGC0~FNLS~0']") private WebElement  Resp3_Check ;
	 
	 @FindBy(id="NSR1") private WebElement Justification;
	 @FindBy ( name="btnAddSelFin" ) private WebElement Btn_AddSelectedToFinalists ;
	 
	 @FindBy ( name="btnSubmitSel" ) private WebElement Btn_SubmitSelected ;
	 //Hiring Approval 
	 @FindBy ( id="FLD_NON_METRO_HIRING_REQUEST_NUM" ) private WebElement Non_Metro ;
	 @FindBy (id="FLD_REASON_NOT_HAVING_METRO_NUM") private WebElement Reason ;
	 @FindBy (id="ContinueSubmit") private WebElement Continue_Submission;
	 @FindBy (name="Continue") private WebElement Continue;
	 //Submit confirmation page
	 @FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;
	 @FindBy (name="btnConfirmSubmit") private WebElement Confirm_Submission;
	 
	
	// Initialize the web elements 
	public Step03_Finalize(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	
	public void loginAndOpenReq()
	{
		
		loginToContractor_Link.click();
		
		LHS_Search_tab.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 160);
		wait.until(ExpectedConditions.visibilityOf(Request_Num_Fld)); 
		
		
		Request_Num_Fld.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
		
		Search_GO_btn.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 160);
		wait1.until(ExpectedConditions.visibilityOf(Request_Num_link)); 
		
		
		Request_Num_link.click();
	}
		
		
		public void FinaliseSubmit()
		{
			
	    WebDriverWait wait2 = new WebDriverWait(driver, 160);
		wait2.until(ExpectedConditions.visibilityOf(Requested_Skill)); 
		
		Requested_Skill.click();
		System.out.println("Hello1");
		str2 = Requested_Skill.getText();
		System.out.println(str2);
	
		
		 WebDriverWait wait3 = new WebDriverWait(driver, 160);
	     wait3.until(ExpectedConditions.visibilityOf(Btn_AddSelectedToFinalists)); 
	     
	     Resp1_Checkbox.click();
	     Resp2_Checkbox.click();
	     Resp3_Checkbox.click();
	     
		
	     Btn_AddSelectedToFinalists.click();
	     
	 	/* code to capture screenshot */
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		 WebDriverWait wait4 = new WebDriverWait(driver, 160);
	     wait4.until(ExpectedConditions.visibilityOf(Btn_SubmitSelected));
		
	     Resp1_Check.click();
	     Resp2_Check.click();
	     Resp3_Check.click();
	     
	 	/* code to capture screenshot */
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
			
		Btn_SubmitSelected.click();
		
		
		
		//Hiring Approval page
		WebDriverWait wait6 = new WebDriverWait(driver, 160);
		wait6.until(ExpectedConditions.visibilityOf(Continue_Submission));
		
		Non_Metro.click();
		
		Reason.sendKeys("I use Metro, but can't for this situation and have a management-approved bypass");
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		Continue_Submission.click();
		 
		 //submit confirmation page
		
		 WebDriverWait wait7 = new WebDriverWait(driver, 160);
		 wait7.until(ExpectedConditions.visibilityOf(Confirm_Submission));
		 
		 Requesting_Organization.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 1));
		 
			/* code to capture screenshot */
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		 
		 Confirm_Submission.click();
		 
			/* code to capture screenshot */
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		}
 
		
  
  }

