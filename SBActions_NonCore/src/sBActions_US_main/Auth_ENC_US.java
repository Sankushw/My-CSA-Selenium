package sBActions_US_main;

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
import sBActions_US.Step02_ENC_US;


public class Auth_ENC_US
{
	// TestNG logger
	
		public static Logger log = Logger.getLogger("TnM");
		
		public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		public String sheet="Login"; 
		public String url;
		public String id;
		public String paswd;
		
		
		public WebDriver driver;
		
		
		@BeforeTest
	    public void setup()
		{
		ProfilesIni ini = new ProfilesIni();
    	FirefoxProfile profile = ini.getProfile("default");
    	//WebDriver driver =  new FirefoxDriver(profile);
			
    	driver = new FirefoxDriver(profile);
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 2, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 2, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 2, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
    	
              
        driver.get(url1);    
	  }	
		
		 

		  // Test to add response
		@Test(priority=0)
		  public void ENC_Authorization()
		  {
		       log.debug("Inside open_CSA_Tab() function");
			  
			  Step02_ENC_US encauth = new Step02_ENC_US(driver); 
			  
			  for (int i=1; i<4; i++)
			  {
				  if(i==1)
				  {
				  encauth.login();
				  encauth.ENC_Auth_US();
				  }  
				 
				  
				  else
				  {
					encauth.ENC_Auth_US();  
					
				  }
			  }
		  }
}
		
		  
		

