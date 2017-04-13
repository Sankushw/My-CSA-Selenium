package step2_Adding_Response;

import org.testng.annotations.Test;

import lib.Excel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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



public class Page01_LoginAndOpenRequest
{
	
private WebDriver driver;

public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Define the element 
    //Summary page elements
	@FindBy (xpath = ".//*[@id='ibm-content-main']//a[contains(text(),'Sign in to CSA.')]"   ) private WebElement Sign_in_to_CSA ;
	@FindBy (xpath = ".//*[@id='ibm-primary-links']//a[contains(text(), 'CSA search')] " ) private WebElement CSA_search_tab ;
	@FindBy ( id = "FLD_REQ_NUM_SEARCH" ) private WebElement Req_Num_field ;
	@FindBy (xpath =".//*[@id='ibm-content-main']//input[@class='ibm-btn-arrow-pri'and @title='Search'] ") private WebElement Search_btn ; 
	@FindBy ( xpath = " .//*[@id='ibm-content-main']/div[2]/div/table/tbody/tr[2]/td[1]/a" ) private WebElement Request_Number_link ;
	
	//Response page element
	@FindBy (xpath =".//*[@id='ibm-content-main']//input[@class='ibm-btn-arrow-pri' and @title='Add response']") private WebElement btn_Add_response; 
	@FindBy ( id="FLD_CAND_FIRST_NM") private WebElement First_Name ;
	@FindBy ( id="FLD_CAND_MDL_NM") private WebElement Middle_Name;
	@FindBy ( id="FLD_CAND_LAST_NM_SURNM") private WebElement LastName_Surname ;
	@FindBy ( id="FLD_CITIZENSHIP") private WebElement Citizenship ;
	@FindBy ( id="FLD_CAND_RES") private WebElement Resp_Attachment ;
	@FindBy (xpath= ".//*[@id='ibm-content-main']//div[4]//tr[2]//td[3]") private WebElement lbl_StartDate;
	@FindBy (xpath= ".//*[@id='ibm-content-main']//div[4]//tr[3]//td[3]") private WebElement lbl_EndDate;
	@FindBy (xpath= ".//*[@id='ibm-content-main']//div[4]//tr[4]//td[3]") private WebElement lbl_Skill_Level;
	@FindBy ( id="FLD_START_DT") private WebElement txt_StartDate ;
	@FindBy ( id="FLD_END_DT" ) private WebElement txt_EndDate ;
	@FindBy (name="FLD_SKILL_LVL") private WebElement  DD_SkillLevel ;
	@FindBy (xpath = ".//*[@id='ibm-content-main']//input[@class='ibm-btn-arrow-pri' and @title='Continue']" ) private WebElement Continue ;
	
	
	//Pricing page element
	@FindBy ( id="FLD_ST_BILL_RT" ) private WebElement ST_rate ;
	@FindBy ( id="FLD_OT_BILL_RATE" ) private WebElement OT_rate ;
	@FindBy ( id="FLD_ST_WAGE" ) private WebElement ST_wage ;
	

	
   // Summary page element
	@FindBy (xpath = ".//*[@id='ibm-content-main']//input[@class='ibm-btn-arrow-sec' and @title='Edit Response details']") private WebElement Edit_Response_details ;
	@FindBy (xpath = ".//*[@id='ibm-content-main']//input[@class='ibm-btn-arrow-pri' and @title='Submit responses' ]" ) private WebElement Submit_responses ;
	
	
	
	
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
		
		Request_Number_link.click();
		
	}
	
	
		
		//Page2////////////////////////////////////////////////////////
		
	public void Add_response(String First_Name_temp , String Middle_Name_temp , String LastName_Surname_temp, String st_rate, String wage_rate  )
	{
		
		WebDriverWait wait1 = new WebDriverWait(driver, 160);
		wait1.until(ExpectedConditions.visibilityOf(btn_Add_response));
		
		btn_Add_response.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, 160);
		wait2.until(ExpectedConditions.visibilityOf(Continue));
		
				
		Select ct = new Select(Citizenship);
		ct.selectByVisibleText("United States");
			
		First_Name.sendKeys(First_Name_temp);
		Middle_Name.sendKeys(Middle_Name_temp);
		LastName_Surname.sendKeys(LastName_Surname_temp);
		
		
		String startDate = lbl_StartDate.getText().trim();
		txt_StartDate.sendKeys(startDate); 
		
		String endDate = lbl_EndDate.getText().trim();
		txt_EndDate.sendKeys(endDate); 
		
		String Skill = lbl_Skill_Level.getText().trim();
		Select sel = new Select(DD_SkillLevel);
		sel.selectByVisibleText(Skill); 
		
		// take screenshot
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
        Resp_Attachment.click();
		
		String path  = Excel.getCellValue(xlsFilePath, "Add_response", 1, 3);



		//put path to your file in a clipboard
	    StringSelection ss = new StringSelection(path);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);


		try {
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
     
		
		//page3 ////////////////////////////////////////////////
		
		
		Continue.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		WebDriverWait wait4 = new WebDriverWait(driver, 160);
		wait4.until(ExpectedConditions.visibilityOf(ST_rate));
		
		
	    ST_rate.clear();
		ST_rate.sendKeys(st_rate);
		ST_wage.clear();
	    ST_wage.sendKeys(wage_rate);
		
		
		Continue.click();
	
		
		
		///Page4///////////////////////////////
		
		WebDriverWait wait5 = new WebDriverWait(driver, 160);
		wait5.until(ExpectedConditions.visibilityOf(Edit_Response_details));
		
		
	
		Continue.click();
		
		WebDriverWait wait6 = new WebDriverWait(driver, 160);
		wait6.until(ExpectedConditions.visibilityOf(Submit_responses));
	
		
		
	}
		
        //method to click submit button after adding all responses
	
		public void Click_Submit()
		{
		
		
		Submit_responses.click();
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
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


