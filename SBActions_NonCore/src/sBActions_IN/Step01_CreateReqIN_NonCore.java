package sBActions_IN;

import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import lib.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step01_CreateReqIN_NonCore {
 
  
  private WebDriver driver;
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath = ".//*[@id='content-main']/form[1]/div/span/input") private WebElement Create_New_Request;
	
	//Skill Request Page	
	@FindBy (id ="FLD_REQ_TYPE") private WebElement New_Request ;
	@FindBy ( id="FLD_NORMAL_TYPE1") private WebElement Time_Materials ;
	@FindBy (name = "btnContinue") private WebElement Continue ;
	
	//Select Requestor
	@FindBy  (id = "FLD_REQST_CO") private WebElement  Requesting_Company ;
	@FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;
	
	// Job Role/Skill
	  @FindBy ( xpath= ".//*[@id='JRSS_SELECTION1']") private WebElement Priced_JRSS;
	    @FindBy ( id = "FLD_JOB_ROLE" ) private WebElement Select_JobRole ;
	    @FindBy ( id = "FLD_SKILL_SET") private WebElement Select_SkillSet;
	
	//Project Creation
	    @FindBy ( id="FLD_PROJ_NAME") private WebElement Project_Name;
	    @FindBy (id="FLD_IS_GLOBAL_RESOURCE0") private WebElement GlobalResource_No ;
	    @FindBy ( id="FLD_CONTACT_NAME") private WebElement CustomerName_Refernce ;
	    @FindBy ( xpath = ".//*[@id='FLD_IS_FED_CONTRACT']")  private WebElement Govt_FederalContract ;
	    @FindBy ( id="FLD_CLIENT") private WebElement Client ;
	    @FindBy ( id="FLD_BRAND") private WebElement Brand ;
	    @FindBy ( id="FLD_SECTOR") private WebElement Sector ;
	    @FindBy ( id="FLD_INDUSTRY") private WebElement Industry ;
	    @FindBy ( xpath = " .//*[@value='I'] " ) private WebElement Accounting_Type ;
	    
	    //Skill detail Location
	    @FindBy ( id="FLD_WRK_LOC_STATE" ) private WebElement State_Region_Province;
	    @FindBy ( id="FLD_WRK_LOC_CITY" ) private WebElement City ;
	    @FindBy ( id="FLD_WRK_LOC" ) private WebElement Work_Location ;
	    @FindBy ( name="Continue" ) private WebElement Continue_2 ;
	    @FindBy (id="FLD_ALT_WORK_LOC" ) private WebElement Alternate_Workloc ;
	    
	  //Skill detail skill price
	    @FindBy ( id="FLD_RQSTD_SKILL_LVL" ) private WebElement Skill_Level;
	    @FindBy (id="FLD_RQSTD_PRICE_LVL" )  private WebElement Price_Level;
	    @FindBy (id="FLD_QTY_SKILL_NEEDED" ) private WebElement Quantity ;
	    @FindBy (xpath =".//*[@id='FLD_ST']") private WebElement ST_time;
	    
	    //Supplier Page
	    @FindBy (id="UTILIZE_RADIAL_BUTTON") private WebElement NonCore_Supplier;
	    @FindBy ( id="FLD_SUPPLIER_CONTRACTS") private WebElement Contract ;
	    @FindBy ( id="FLD_SUPP_NM") private WebElement SupplierName ;
	    @FindBy (id ="FLD_CONTACT_NM") private WebElement ContactName ;
	    @FindBy (id = "FLD_CONTACT_PHONE_NUM") private WebElement ContactNumber ;
	    @FindBy (id="FLD_WARNING_JUST") private WebElement Business_Justification;
	    
	    
	    @FindAll({@FindBy(name="FLD_MULTI_LINE_ITEMS")}) private List<WebElement>  Select_Checkbox ;
	    
	    //Skill Summary Page
	    @FindBy (xpath = ".//*[@value='Continue to request summary'] ") private WebElement ContinueToRequestSummary;
	
	 //Review Skill request
	    @FindBy (name = "Submit request") private WebElement SubmitRequest;
	    
	    //Request Created
	    @FindBy ( xpath= ".//*[@id='content-main']/table[1]/tbody/tr/td[1]/h1 ") private WebElement RequestCreated;
	
	    //Add Skill
	    @FindBy (xpath = ".//*[@value='Add skill'] ") private WebElement AddSkill;
	    
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	 
	// Initialize the web elements 
	public Step01_CreateReqIN_NonCore(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	// Click on the link again as workaround 
	public void login()
	{
		
		loginToContractor_Link.click();
  
	
	//Create Request
	
    	WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Create_New_Request));
		
		
    	Create_New_Request.click();
    	
    
	//Skill Request Page
	
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(New_Request));
		
		New_Request.click();
		Time_Materials.click();
		Continue.click();
		
	}
	
	//Select Requestor Page
	public void GB_NonCore_Requestor()
	{
		//Requesting_Company.sendKeys(Excel.getCellValue(xlsFilePath,"Request_Creation",3,0));
		
		// Requesting_Organization.sendKeys("GBS");
		 
		
		Continue.click();		
	}
	
	//JRSS
	public void Select_NonCore_JRSS()
    {
	 
	String JR = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 2);
	String SS = Excel.getCellValue(xlsFilePath, "Request_creation", 3, 3);  
   
	Priced_JRSS.click();	
	
    Select JRlistbox = new Select(Select_JobRole);
	JRlistbox.selectByVisibleText(JR);
	
	Select SSlistbox = new Select(Select_SkillSet);
	SSlistbox.selectByVisibleText(SS);
	

	   try 
	   	{
			Thread.sleep(2000);
		} 
	   catch (InterruptedException e) 
	   {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	 
	 Continue.click();
	 
    }
	
	//request details
	public void Request_NonCore_detail()
    
    {
	 
	Project_Name.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 4));
	GlobalResource_No.click();
	Govt_FederalContract.click();
	Client.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 5));
	Brand.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 6));
	Sector.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 7));
	Industry.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 8));
	Accounting_Type.click();
	Continue.click();
	}
	
	//skill detail Page
	public void Skill_NonCore_Locationpage()
    
    {
	 
	 Select st = new Select(State_Region_Province);
		st.selectByVisibleText("Karnataka");
		
   try 
   {
		Thread.sleep(2000);
	} 
   catch (InterruptedException e) 
   {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
   
   Select ct = new Select(City);
	ct.selectByVisibleText("BANGALORE");
	
   try 
   	{
		Thread.sleep(2000);
	} 
   catch (InterruptedException e) 
   {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
   Continue_2.click();
    }
   public boolean isAlertPresent() 
   { 
       try 
       { 
    	   driver.switchTo().alert().accept();
           return true;
       
           
       }   // try 
       catch (NoAlertPresentException Ex) 
       { 
           return false; 
       }   // catch 
   //driver.switchTo().alert().accept();
   }
    
	//Skill detail skill price
	public void Skill_NonCore_skillprice()
    
    {

	WebDriverWait wait3 = new WebDriverWait(driver, 160);
	wait3.until(ExpectedConditions.visibilityOf(Skill_Level));
		
    Skill_Level.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 12));
    ST_time.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),"12");
    
      
    try 
    {
		Thread.sleep(2000);
	}
    catch (InterruptedException e) 
    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
    
    Continue_2.click();
	
    }
	//Supplier Selection Page
		public void Supplier_NonCore(String Supp_name, String Contact_name, String number)
		{
		NonCore_Supplier.click();
		SupplierName.sendKeys(Supp_name);
		ContactName.sendKeys(Contact_name);
		ContactNumber.sendKeys(number);
		
		
		 /* code to capture screenshot */
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
		Continue.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOf(Continue)); 
		Business_Justification.sendKeys("Diversity Supplier");
			
		Continue.click();
			
		//Summary Page
		WebDriverWait wait6 = new WebDriverWait(driver, 160);
		wait6.until(ExpectedConditions.visibilityOf(ContinueToRequestSummary));
		
		ContinueToRequestSummary.click();
		
		WebDriverWait wait7 = new WebDriverWait(driver, 160);
		wait7.until(ExpectedConditions.visibilityOf(SubmitRequest));
		
		//SubmitRequest.click();
		
		//String Number = RequestCreated.getText().substring(33, 39);
		//Excel.setCellValue(xlsFilePath, "Request_creation", 1, 15, Number );
		}

	    public void Reqdata()
	    {
	    	
	    	/* code to capture screenshot */
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
	    
	}
	    public void AddSkill()
	    {
	    AddSkill.click();
	    	    
	    }
	    public void Submit()
	    {
		  	WebDriverWait wait7 = new WebDriverWait(driver, 160);
			wait7.until(ExpectedConditions.visibilityOf(SubmitRequest));
			for (WebElement elt: Select_Checkbox){

				elt.click();

			} 
			
					SubmitRequest.click();
					
					/* code to capture screenshot */
					Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
			
			String Number = RequestCreated.getText().substring(33, 39);
			Excel.setCellValue(xlsFilePath, "Request_creation", 3, 15, Number );
	    }
		
}



	
