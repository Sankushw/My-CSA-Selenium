package nonCoreRequest.Testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import lib.Excel;
import step1_CreateRequest.Page01_RIPC_login;
import step1_CreateRequest.Page02_WelcomePage;
import step1_CreateRequest.Page03_SkillRequestPage;
import step1_CreateRequest.Page04_SelectRequester;
import step1_CreateRequest.Page05_JRSS;
import step1_CreateRequest.Page06_RequestDetail;
import step1_CreateRequest.Page07_SkilldetailLocation;
import step1_CreateRequest.Page08A_Candidate_Details;
import step1_CreateRequest.Page08_SkilldetailSkillPrice;

import step1_CreateRequest.Page09_Supplier_Selection;
import step1_CreateRequest.Page10_SkillSummary;
import step1_CreateRequest.Page11_RequestSummary;
import step1_CreateRequest.Page12_SubmitConfimationLast;
import step6_Renewal.Page01_RIPC_login_and_Renew;
import step6_Renewal.Page03_Request_Detail;
import step6_Renewal.Page2_Requesting_Org;


public class RenewalOfrequest
{
	// TestNG logger
	
		public static Logger log = Logger.getLogger("TnM");
		
		public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		public String sheet="Login"; 
		public String url;
		public String id;
		public String paswd;
		
		WebDriver driver;
		
		
		@BeforeTest
	    public void setup()
		{
		ProfilesIni ini = new ProfilesIni();
    	FirefoxProfile profile = ini.getProfile("default");
    	//WebDriver driver =  new FirefoxDriver(profile);
			
    	driver = new FirefoxDriver(profile);
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 1, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 1, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 1, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
        
        driver.get(url1);    
	  }	
		
		 // test to Login to the application as RIPC
		  @Test(priority=0)
		  public void RIPC_Login_Renewal() 
		  {
			  
			  Page01_RIPC_login_and_Renew login = new Page01_RIPC_login_and_Renew(driver);
			  login.login();
		  }
		  
	
		  // Test to create new renewed request
		  @Test(priority=1)
		  public void Organization()
		  {
		
			    
			 Page2_Requesting_Org org= new Page2_Requesting_Org(driver);  		
			 org.Select_Requester();
			  
			  
		  }
		  
		 //Test for creating renewed req
		  @Test(priority=2)
		  public void Request_detail()
		  {
			 
			  Page03_Request_Detail detail = new Page03_Request_Detail(driver);
			  detail.Request_detailpage();
			  
			  
			  
		  }
		  
		
	
		  
		  
		
}
