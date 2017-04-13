package sBActions_IN_main;

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
import sBActions_GB.Step01_CreateRequest_GB;
import sBActions_IN.Step01_CreateRequest_IN;
import sBActions_US.Step01_CreateRequest;
import sBActions_US.Step02_AddResponse;
import sBActions_US.Step03_Finalize;


public class CreateRequest_IN
{
	// TestNG logger
	
		public static Logger log = Logger.getLogger("TnM");
		
		public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		public String sheet="Login"; 
		public String url;
		public String id;
		public String paswd;
		public String id_green;
		public String paswd_green;
		public String url_green;
		public String url2;
		
		public WebDriver driver;
		
		
		@BeforeTest
	    public void setup()
		{
			System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
	    	driver = new ChromeDriver();
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 12, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 12, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 12, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
    	      
        driver.get(url1);    
	  }	
		
		 // test to Login to the application as RIPC
		  @Test(priority=0)
		  public void RIPC_Login() 
		  {
			  
			  Step01_CreateRequest_IN login = new Step01_CreateRequest_IN(driver);
			  login.login();
			  login.Create_New_Request();
			  login.Skill_Request();
			  login.Select_Requestor();
			  login.Select_JRSS();
			  login.Request_detailpage();
			  login.Skill_detailLocationpage();
			  login.isAlertPresent();
			  login.Skill_detail_skillpricepage();
			  login.SupplierSelectionPage();
			  login.Reqdata();
			  //driver.quit();
			/*  try {
					Thread.sleep(1500000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} */
		  
}
		  // Test to add response
	/*	 @Test(priority=1)
		  public void add_response()
		  {
		     driver.get(url2);
			  
			  log.debug("Inside open_CSA_Tab() function");
			  
			  Step02_AddResponse addresp = new Step02_AddResponse(driver); 
			  
			  for (int i=1; i<4; i++)
			  {
				  if(i==1)
				  {
				 addresp.login();
				  addresp.FillRespdetails("fResp"+i , "US" , "lResp"+i, "40");
				  }  
				  else if(i==2)
				  {
				  //addresp.login();
				  addresp.FillRespdetails("fResp"+i , "US" , "lResp"+i, "35");}
			  else
			  {
				  //addresp.login();
				  addresp.FillRespdetails("fResp"+i , "US" , "lResp"+i, "38");
				  addresp.Submit();
			  }
			  }
			
		  }
		*/  
		 //Test for Skill Request page
	/*	  @Test(priority=0)
		  public void Finalize()
		  {
			 
			  Step03_Finalize respfinal = new Step03_Finalize(driver);
			  respfinal.loginAndOpenReq();
			  respfinal.FinaliseSubmit();
			  
				  
		  }*/
		  
		
}
