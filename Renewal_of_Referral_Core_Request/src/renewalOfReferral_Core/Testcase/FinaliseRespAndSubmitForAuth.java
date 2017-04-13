package renewalOfReferral_Core.Testcase;

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
import step3_FinaliseResponse.Page01_RIPCLoginAndOpenRequest;
import step3_FinaliseResponse.Page02_FinaliseAndSubmit;



public class FinaliseRespAndSubmitForAuth 
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
				  
				  Page01_RIPCLoginAndOpenRequest login = new Page01_RIPCLoginAndOpenRequest(driver);
				  login.loginAndOpenReq();
			  }
			  
			// test to finalise and submit response for authorization
			  @Test(priority=1)
			  public void FlnsAndSbmt() 
			  {
				  
				  Page02_FinaliseAndSubmit  FlnsSbmt = new Page02_FinaliseAndSubmit (driver);
				  FlnsSbmt.FinaliseSubmit();
			  }
			  
}
