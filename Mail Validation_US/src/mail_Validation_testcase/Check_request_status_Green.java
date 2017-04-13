package mail_Validation_testcase;

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
import step2_check_Request_green_side.Page01_LoginAndOpenRequest;


public class Check_request_status_Green 
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
			  
			 
			
			  
			  
			
		
			  
			
}
			  
			  
		

