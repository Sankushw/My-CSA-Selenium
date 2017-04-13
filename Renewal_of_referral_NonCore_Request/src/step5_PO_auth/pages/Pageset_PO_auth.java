package step5_PO_auth.pages;

import org.testng.annotations.Test;

import lib.Excel;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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

public class Pageset_PO_auth {
 
  
  private WebDriver driver;
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Awaiting project office action')]") private WebElement Awaiting_PO_Auth_link ;
	@FindBy (xpath = ".//*[@id='left-nav']/div/div/a[1]") private WebElement Skill_Line_Item ;
	@FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
	@FindBy (name="btnGo") private WebElement GO_reqnum ;
	@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a " ) private WebElement Request_Number ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[4]/a" ) private WebElement Project_Name ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement Skill_link ;
	@FindBy (name="FLD_MULTI_LINE_ITEMS") private WebElement  Select_Checkbox ;
	@FindBy (name="btnSubmitSelCand") private WebElement Submit_Selected_Responses ;
	@FindBy (xpath = ".//*[@id='ContinueSubmit']" ) private WebElement Continue_Submission ;
	@FindBy (name="btnContinueSubmission") private WebElement  Continue_Submission_Again ;
	@FindBy (name="BTN_CHG_MGR0") private WebElement  Add_Manager ;
	
	//elements in child window
	@FindBy (name="FLD_EMP_WEB_ID") private WebElement Email_Id;
	@FindBy (name="BTN_GO") private WebElement GO_Button;
	@FindBy (xpath = ".//*[@id='content-main']/table[3]/tbody/tr[2]/td[1]/a" ) private WebElement Name ;
	@FindBy (name="TEMP REPT MGR BUTTON") private WebElement Use_As_Manager;
	
	//elements in main window
	@FindBy (name="FLD_SENSITIVE_TECH0") private WebElement  Sensitive_Technologies_No ;
	@FindBy (name="FLD_DETAIL_JOB_SCOPE") private WebElement  Job_Scope ;
	@FindBy (name="FLD_DESC_SOFTWARE_TECH") private WebElement  Software_Technologies ;
	@FindBy (xpath =".//*[@id='FLD_NON_METRO_HIRING_REQUEST_NUM']") private WebElement Hirinig_Approval ;
	@FindBy (name="FLD_REASON_NOT_HAVING_METRO_NUM") private WebElement Reason ;
    @FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;
	@FindBy (name="btnConfirmSubmit") private WebElement Confirm_submission ;
	
	
	
	
	
	// Initialize the web elements 
	public Pageset_PO_auth(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	// Click on the link again as workaround 
	public void login(){
		
		loginToContractor_Link.click();
  
		
  }
	
	
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	
		
		//Function to click Submit selected response button
        public void authorize_PO ()
        {
        	
        	WebDriverWait wait01 = new WebDriverWait(driver, 180);
			wait01.until(ExpectedConditions.visibilityOf(Awaiting_PO_Auth_link));
			
		    Awaiting_PO_Auth_link.click();
		    
		    WebDriverWait wait02 = new WebDriverWait(driver, 180);
			wait02.until(ExpectedConditions.visibilityOf(Skill_Line_Item));
			Skill_Line_Item.click();
    		
    		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
    		GO_reqnum.click();

    		WebDriverWait wait03 = new WebDriverWait(driver, 180);
			wait03.until(ExpectedConditions.visibilityOf(Project_Name));
    		
    		
    	Project_Name.click();
    	
    	WebDriverWait wait04 = new WebDriverWait(driver, 180);
		wait04.until(ExpectedConditions.visibilityOf(Submit_Selected_Responses));
		
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
		
    	
		Select_Checkbox.click();
		
    	Submit_Selected_Responses.click();
    	
    	
    	WebDriverWait wait05 = new WebDriverWait(driver, 180);
		wait05.until(ExpectedConditions.visibilityOf(Continue_Submission));
		Hirinig_Approval.click();
		Reason.sendKeys("I use Metro, but can't for this situation and have a management-approved bypass");
		Continue_Submission.click();
    	
    	WebDriverWait wait06 = new WebDriverWait(driver, 180);
		wait06.until(ExpectedConditions.visibilityOf(Continue_Submission_Again));
		Add_Manager.click();
		
		
		 // To handle all new opened window.
		String MainWindow=driver.getWindowHandle();
					
        Set<String> s1=driver.getWindowHandles();		
    Iterator<String> i1=s1.iterator();		
    		
    while(i1.hasNext())			
    {		
        String ChildWindow=i1.next();		
        		
        if(!MainWindow.equalsIgnoreCase(ChildWindow))			
        {    		
             
                // Switching to Child window
                driver.switchTo().window(ChildWindow);		
                                                                                     
                Email_Id.sendKeys(Excel.getCellValue(xlsFilePath, "Login", 1, 0));                                                                     
                GO_Button.click();
                WebDriverWait wait07 = new WebDriverWait(driver, 180);
        		wait07.until(ExpectedConditions.visibilityOf(Name));
                Name.click();
                Use_As_Manager.click();
                
                
                
                
          }		
    }		
    // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);	
        
        Sensitive_Technologies_No.click();
        Job_Scope.sendKeys("Test");
        Software_Technologies.sendKeys("Test");
        Continue_Submission_Again.click();
        
        
        
   
		
		
		
		
    	WebDriverWait wait08 = new WebDriverWait(driver, 180);
		wait08.until(ExpectedConditions.visibilityOf(Confirm_submission));
		
		 Requesting_Organization.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 1));
    	Confirm_submission.click();
    	
    	
    	
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
