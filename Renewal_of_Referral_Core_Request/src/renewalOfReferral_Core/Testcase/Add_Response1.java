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
import step2_Adding_Response.Page01_LoginAndOpenRequest;
import step2_Adding_Response.Page02_Response_detail;
import step2_Adding_Response.Page03_ResponsePricing;
import step2_Adding_Response.Page04_ResponseSummaryAndSubmit;


public class Add_Response1 
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
		    public void setup1()
			{
			ProfilesIni ini = new ProfilesIni();
	    	FirefoxProfile profile = ini.getProfile("default");
	    	//WebDriver driver =  new FirefoxDriver(profile);
				
	    	driver = new FirefoxDriver(profile);
		
	    	id = Excel.getCellValue(xlsFilePath, sheet, 3, 0);
	   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 3, 1);
	    	url = Excel.getCellValue(xlsFilePath, sheet, 3, 2);
	    	
	    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
	        
	        driver.get(url1);    
		  }	
			
			 // test to Login to the application as RIPC
			  @Test(priority=0)
			  public void Supp_Login1() 
			  {
				  
				  Page01_LoginAndOpenRequest login = new Page01_LoginAndOpenRequest(driver);
				  login.login();
			  }
			  
			 
			  @Test(priority=1)
			  public void AddResp1( ) 
			  {
				  
				  Page02_Response_detail  sbmt = new Page02_Response_detail  (driver);
				  sbmt.FillRespdetails();
				  
			  }
			  
			
			  @Test(priority=2)
			  public void RespPric1() 
			  {
				  
				  Page03_ResponsePricing  pric = new Page03_ResponsePricing  (driver);
				  pric.PricingAndSubmit();
			  }
			  
			  
		
			  @Test(priority=3)
			  public void RespSum1() 
			  {
				  
				  Page04_ResponseSummaryAndSubmit   Sum = new Page04_ResponseSummaryAndSubmit   (driver);
				  Sum.RespSummaryandsubmit();
			  }
			  
			  
			  
			
		
			  
			
}
			  
			  
		

