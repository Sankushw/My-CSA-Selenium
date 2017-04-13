package LiteRequest_AU_AP_TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import step1_CreateRequest.Create_Req;


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
			System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    	
	    	
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
			  
			  Create_Req login = new Create_Req(driver);
			  login.login();
		  }
		  
	
		  // Test to open CSA home page tab
		  @Test(priority=1)
		  public void open_CSA_Tab()
		  {
		
			  
			  log.debug("Inside open_CSA_Tab() function");
			  
			  Create_Req wlcm = new Create_Req(driver);  		
			  wlcm.Create_New_Request();  
			  
			  
		  }
		  
		 //Test for Skill Request page
		  @Test(priority=2)
		  public void Skill_Request1()
		  {
			 
			  Create_Req sklreq = new Create_Req(driver);
			  sklreq.Skill_Request();
			  
			  
			  
		  }
		  
		//Test for Select Requester page
		  @Test(priority=3)
		  public void Select_Requester1()
		  {
			 
			  Create_Req selreq = new Create_Req(driver);
			  selreq.Select_Requester();
			 
		  }
		  
		  //Test for JRSS page
		  @Test(priority=4)
		  public void JRSS_Select(){
			  
			  Create_Req JRSS = new Create_Req(driver);
			  JRSS.Select_JRSS();
			  
			  
		  }
		  
		//Test for Request detail page
		  @Test(priority=5)
		  public void Req_detail(){
			  
			  Create_Req Reqdtl = new Create_Req(driver);
			  Reqdtl.Request_detailpage();
			  
		  }
		  
		//Test for Skill detail page with location
		  @Test(priority=6)
		  public void Skill_detailLoc(){
			  
			  Create_Req Sklloc = new Create_Req(driver);
			  Sklloc.Skill_detailLocationpage();
			  Sklloc.isAlertPresent();
		  } 
		  
		//Test for Skill detail page with skill and price level
		  @Test(priority=7)
		  public void Skill_detailsklprc(){
			  
			  Create_Req Sklprclvl = new Create_Req(driver);
			  Sklprclvl.Skill_detail_skillpricepage();
			  Sklprclvl.isAlertPresent();
		  } 
		  
		 
		  
		//Test for supplier selection page
		  @Test(priority=8)
		  public void Supp_select(){
			  
			  Create_Req Suppslct = new Create_Req(driver);
			  Suppslct.SupplierSelectionPage();
			  
		  } 
		  
		
		  
		//Test for Skill summary page
		  @Test(priority=9)
		  public void SkillSummary(){
			  
			  Create_Req Sklsum = new Create_Req (driver);
			  Sklsum.SkillSummaryPage();
			  
		  } 
		  
		//Test for Request summary page
		  @Test(priority=10)
		  public void ReqSummary(){
			  
			  Create_Req  Reqsum = new   Create_Req  (driver);
			  Reqsum.RequestSummaryPage();
			  
		  } 
		  
		
		
		 
		  //Test for Submit Confirmation Last page
		  @Test(priority=11)
		  public void submitconfirmed(){
			  
			  Create_Req sctext = new Create_Req(driver);
			  String heading = sctext.Reqdata() ;
			  Reporter.log(heading);
	
		  }
		  
		
}
