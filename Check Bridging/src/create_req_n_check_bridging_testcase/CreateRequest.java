package create_req_n_check_bridging_testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CreateRequest_bridge_to_green_pages.Page01_RIPC_login;
import CreateRequest_bridge_to_green_pages.Page02_WelcomePage;
import CreateRequest_bridge_to_green_pages.Page03_SkillRequestPage;
import CreateRequest_bridge_to_green_pages.Page04_SelectRequester;
import CreateRequest_bridge_to_green_pages.Page05_JRSS;
import CreateRequest_bridge_to_green_pages.Page06_RequestDetail;
import CreateRequest_bridge_to_green_pages.Page07_SkilldetailLocation;
import CreateRequest_bridge_to_green_pages.Page08_SkilldetailSkillPrice;
import CreateRequest_bridge_to_green_pages.Page09_Supplier_Selection;
import CreateRequest_bridge_to_green_pages.Page10_SkillSummary;
import CreateRequest_bridge_to_green_pages.Page11_RequestSummary;
import CreateRequest_bridge_to_green_pages.Page12_SubmitConfimationLast;
import CreateRequest_bridge_to_green_pages.Page13_GreenLogin;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import lib.Excel;


public class CreateRequest
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
		  public void RIPC_Login() 
		  {
			  
			  Page01_RIPC_login login = new Page01_RIPC_login(driver);
			  login.login();
		  }
		  
	
		  // Test to open CSA home page tab
		  @Test(priority=1)
		  public void open_CSA_Tab()
		  {
		
			  
			  log.debug("Inside open_CSA_Tab() function");
			  
			  Page02_WelcomePage wlcm = new Page02_WelcomePage(driver);  		
			  wlcm.Create_New_Request();  
			  
			  
		  }
		  
		 //Test for Skill Request page
		  @Test(priority=2)
		  public void Skill_Request1()
		  {
			 
			  Page03_SkillRequestPage sklreq = new Page03_SkillRequestPage(driver);
			  sklreq.Skill_Request();
			  
			  
			  
		  }
		  
		//Test for Select Requester page
		  @Test(priority=3)
		  public void Select_Requester1()
		  {
			 
			  Page04_SelectRequester selreq = new Page04_SelectRequester(driver);
			  selreq.Select_Requester();
			 
		  }
		  
		  //Test for JRSS page
		  @Test(priority=4)
		  public void JRSS_Select(){
			  
			  Page05_JRSS JRSS = new Page05_JRSS(driver);
			  JRSS.Select_JRSS();
			  JRSS.JRSS_Ctn();
			  
		  }
		  
		//Test for Request detail page
		  @Test(priority=5)
		  public void Req_detail(){
			  
			  Page06_RequestDetail Reqdtl = new Page06_RequestDetail(driver);
			  Reqdtl.Request_detailpage();
			  
		  }
		  
		//Test for Skill detail page with location
		  @Test(priority=6)
		  public void Skill_detailLoc(){
			  
			  Page07_SkilldetailLocation Sklloc = new Page07_SkilldetailLocation(driver);
			  Sklloc.Skill_detailLocationpage();
			  
		  } 
		  
		//Test for Skill detail page with skill and price level
		  @Test(priority=7)
		  public void Skill_detailsklprc(){
			  
			  Page08_SkilldetailSkillPrice Sklprclvl = new Page08_SkilldetailSkillPrice(driver);
			  Sklprclvl.Skill_detail_skillpricepage();
			  
		  } 
		  
		 
		  
		//Test for supplier selection page
		  @Test(priority=8)
		  public void Supp_select(){
			  
			  Page09_Supplier_Selection Suppslct = new Page09_Supplier_Selection(driver);
			  Suppslct.SupplierSelectionPage();
			  
		  } 
		  
		
		  
		//Test for Skill summary page
		  @Test(priority=9)
		  public void SkillSummary(){
			  
			  Page10_SkillSummary Sklsum = new Page10_SkillSummary (driver);
			  Sklsum.SkillSummaryPage();
			  
		  } 
		  
		//Test for Request summary page
		  @Test(priority=10)
		  public void ReqSummary(){
			  
			  Page11_RequestSummary  Reqsum = new   Page11_RequestSummary  (driver);
			  Reqsum.RequestSummaryPage();
			  
		  } 
		  
		
		
		 
		  //Test for Submit Confirmation Last page
		  @Test(priority=11)
		  public void submitconfirmed(){
			  
			  Page12_SubmitConfimationLast sctext = new Page12_SubmitConfimationLast(driver);
			  String heading = sctext.Reqdata() ;
			  Reporter.log(heading);
	
		  }
		  
		



	// TestNG logger
	
	
			
		
    
			 // test to Login to the application as RIPC
			  @Test(priority=12)
			  
			  public void Supp_Login1() 
			  {
			  
				  
				  id = Excel.getCellValue(xlsFilePath, sheet, 3, 0);
			   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 3, 1);
			    	url = Excel.getCellValue(xlsFilePath, sheet, 3, 2);
			    	
			    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
			        
			        driver.get(url1);
				  
				  
				 
				  Page13_GreenLogin login = new Page13_GreenLogin(driver);
				login.login();  
			  }
			  
			 
			
			  
			  
			
		
			  
			
}





