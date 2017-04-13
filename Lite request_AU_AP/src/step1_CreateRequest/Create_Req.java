package step1_CreateRequest;

import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import lib.Excel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Create_Req {
 
  
  private WebDriver driver;
	
  public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
  
	// Define the element ---------------------------------------
    //page 1
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	
	//page 2
	@FindBy (xpath = ".//*[@id='content-main']/form[1]/div/span/input") private WebElement Create_New_Request;
	
	//page 3
	  @FindBy (id ="FLD_REQ_TYPE") private WebElement New_Request ;
	 // @FindBy ( id="FLD_NORMAL_TYPE1") private WebElement Time_Materials ;
	  @FindBy (name = "btnContinue") private WebElement Continue ;
	  
	  //page 4
	    @FindBy  (id = "FLD_REQST_CO") private WebElement  Requesting_Company ;
		@FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;
		
	  //page 5
		 @FindBy ( xpath= ".//*[@id='JRSS_SELECTION1']") private WebElement Priced_JRSS;
		 @FindBy ( id = "FLD_JOB_ROLE" ) private WebElement Select_JobRole ;
		 @FindBy ( id = "FLD_SKILL_SET") private WebElement Select_SkillSet ;
		 @FindBy ( xpath= ".//*[@id='JRSS_SELECTION2']") private WebElement Non_Priced_Radio;	
	  
	  //Page 6
		 @FindBy ( id="FLD_PROJ_NAME") private WebElement Project_Name;
		   // @FindBy (id="FLD_IS_GLOBAL_RESOURCE0") private WebElement GlobalResource_No ;
		   // @FindBy ( id="FLD_CONTACT_NAME") private WebElement CustomerName_Refernce ;
		    @FindBy ( xpath = ".//*[@id='FLD_IS_FED_CONTRACT']")  private WebElement Govt_FederalContract ;
		    @FindBy ( id="FLD_CLIENT") private WebElement Client ;
		    @FindBy ( id="FLD_BRAND") private WebElement Brand ;
		    @FindBy ( id="FLD_SECTOR") private WebElement Sector ;
		    @FindBy ( id="FLD_INDUSTRY") private WebElement Industry ;
		   // @FindBy ( id="fldRegulatedAcc1") private WebElement FDA ;
		   // @FindBy ( id="fldRegulatedAcc2") private WebElement FFIEC ;
		   // @FindBy ( id="fldRegulatedAcc4") private WebElement NREG ;
		    @FindBy ( xpath = " .//*[@value='I'] " ) private WebElement Accounting_Type ;
		    @FindBy ( id="FLD_SRVREQ_PRPSTYPE_CD2") private WebElement Req_Type_RFQ ;	 
	
		    //Page 7
		    @FindBy ( id="FLD_WRK_LOC_STATE" ) private WebElement State_Region_Province;
		    @FindBy ( id="FLD_WRK_LOC_CITY" ) private WebElement City ;
		    @FindBy ( id="FLD_WRK_LOC" ) private WebElement Work_Location ;
		    @FindBy (id="FLD_ALT_WORK_LOC" ) private WebElement Alternate_Workloc ; 
		    @FindBy ( name="Continue" ) private WebElement Continue_Button ;
		    
	       //Page 8
		        @FindBy ( id="FLD_RQSTD_SKILL_LVL" ) private WebElement Skill_Level;
			    //@FindBy (id="FLD_RQSTD_PRICE_LVL" )  private WebElement Price_Level;
			    @FindBy (id="FLD_QTY_SKILL_NEEDED" ) private WebElement Quantity ;
			    
			// Page 9
			    @FindBy (id="UTILIZE_RADIAL_BUTTON") private WebElement NonCore_Supplier;
			    @FindBy ( id="FLD_SUPPLIER_CONTRACTS") private WebElement Contract ;
			    @FindBy (id="FLD_SUPP_NM") private WebElement Supplier_name;
				@FindBy (id="FLD_CONTACT_NM") private WebElement Contact_name;
				@FindBy (id="FLD_CONTACT_PHONE_NUM") private WebElement Contact_phone_number;
				@FindBy (id="FLD_CAND_FIRST_NM") private WebElement First_Name;
				@FindBy (id="FLD_CAND_LAST_NM_SURNM") private WebElement Last_Name; 
				@FindBy (id="FLD_WARNING_JUST") private WebElement SupplierWarning;
				
			//Page10	
				@FindBy (xpath = ".//*[@value='Continue to request summary'] ") private WebElement ContinueToRequestSummary;
				
			//Page11 
				@FindBy (name = "Submit request") private WebElement SubmitRequest;
				
			//Page12 and 13
				@FindBy (name="btnConfirmSubmit") private WebElement confirm_Submission;
				@FindBy ( xpath= ".//*[@id='content-main']/table[1]/tbody/tr/td[1]/h1 ") private WebElement RequestCreated;
				
				
	
	// Initialize the web elements 
	public Create_Req(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// page 1-Function to login to the application
	
	public void login(){
		
		loginToContractor_Link.click();
  
        }
	
	//page 2- welcome page
	
	 public void Create_New_Request()
     {
     	    WebDriverWait wait01 = new WebDriverWait(driver, 180);
			wait01.until(ExpectedConditions.visibilityOf(Create_New_Request));
			
			/* code to capture screenshot */
			 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
							
     	Create_New_Request.click();
     	
     }
	 
	 //page 3- req type
	 public void Skill_Request()
	    
	    {
	    	
	    	New_Request.click();
	    	//Time_Materials.click();
	    	
	    	/* code to capture screenshot */
	    	 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
	    				
	    	Continue.click();
	    }
	 
	 
	 //page 4- select requester
	 public void Select_Requester()
	    
	    {
		//Requesting_Company.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 0)); 
		//Requesting_Organization.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 1));
		
		 /* code to capture screenshot */
		 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
					
		Continue.click();
		 }
	 
	 //page 5- JRSS
	 
	 public void Select_JRSS()
	    
	    {
		 String JR = Excel.getCellValue(xlsFilePath, "Request_creation", 1, 2);
		 String SS = Excel.getCellValue(xlsFilePath, "Request_creation", 1, 3);  
	   
		 Non_Priced_Radio.click();	
		
	    Select JRlistbox = new Select(Select_JobRole);
		JRlistbox.selectByVisibleText(JR);
		
		Select SSlistbox = new Select(Select_SkillSet);
		SSlistbox.selectByVisibleText(SS);
		
		/* code to capture screenshot */
		 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
					
		
		 Continue.click();
	    }
	 
	 //page 6- request Detail 
	 
	 public void Request_detailpage()
	    
	    {
		 Project_Name.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 4));
		//GlobalResource_No.click();
		Govt_FederalContract.click();
		Client.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 5));
		Brand.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 6));
		Sector.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 7));
		Industry.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 8));
		//FDA.click();
		//FFIEC.click();
		//NREG.click();
		Accounting_Type.click();
		Req_Type_RFQ.click();
		
		/* code to capture screenshot */
		 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
					
		Continue.click();
		
	   }
	 
	 //Page 7- Skill detail skill location
		 public void Skill_detailLocationpage()
		    
		    {
			 
		  // State_Region_Province.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 9));
			 
			 Select st = new Select(State_Region_Province);
				st.selectByVisibleText("South Australia");
				
		   try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		   
		   
		   Select ct = new Select(City);
			ct.selectByVisibleText("KIDMAN PARK");
			
			
		   try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
		   /* code to capture screenshot */
		   Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
		  			
		   Continue_Button.click();
			
		   }
	 //Page 8- skill detail skill Price
	 
		 public void Skill_detail_skillpricepage()
		    
		    {
			 
		    Skill_Level.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 12));
		   // Price_Level.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 13));
		    
		    
		   
		    try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		    
		    /* code to capture screenshot */
		    Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
		   			
			Continue_Button.click();
			
		   }
	 
	 //Page 9- Supplier Selection
	 
		 public void SupplierSelectionPage()
		    
		    {
			NonCore_Supplier.click();
			Supplier_name.sendKeys("Test supplier");
			Contact_name.sendKeys("test contact");
			Contact_phone_number.sendKeys("7864532745");
			First_Name.sendKeys("Test F name");
			Last_Name.sendKeys("test L name");
						
			 /* code to capture screenshot */
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\");  
		
			
			Continue.click();
						
			 WebDriverWait wait = new WebDriverWait(driver, 160);
			wait.until(ExpectedConditions.visibilityOf(Continue)); 
							
		SupplierWarning.sendKeys("Diversity Supplier");
				
		 /* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
		
		Continue.click();
		    }
		 
		 
		 //Page 10 - Skill Summary
		 
		 public void SkillSummaryPage()
		    
		    {
			 /* code to capture screenshot */
				Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
			
				ContinueToRequestSummary.click();
			
			
		   }
		 
		 //Page 11- Req Summary
		 
		 public void RequestSummaryPage()
		    
		    {
			 /* code to capture screenshot */
				Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
				
			 SubmitRequest.click();
			
			  }
		 
		 //Page 12 and 13- Submit confirmation
		 
		 public String  Reqdata()
		    
		    {
			 WebDriverWait wait = new WebDriverWait(driver, 160);
				wait.until(ExpectedConditions.visibilityOf(confirm_Submission));
				
				 /* code to capture screenshot */
				Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
			 
				confirm_Submission.click();
				 driver.switchTo().alert().accept();
				
			 // set req no. to excel sheet
				 WebDriverWait wait1 = new WebDriverWait(driver, 160);
					wait1.until(ExpectedConditions.visibilityOf(RequestCreated));
		
				String Number = RequestCreated.getText().substring(26, 32);
				System.out.println(Number);
				
				Excel.setCellValue(xlsFilePath, "Request_creation", 1, 15, Number );
				
				
				 /* code to capture screenshot */
				Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
			
			
			return RequestCreated.getText();
			
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

	       }
		   }
			 
}
