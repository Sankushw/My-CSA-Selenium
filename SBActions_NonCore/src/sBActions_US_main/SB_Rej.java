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
import sBActions_US.Step03_SBAuth_NonCore;
import sBActions_US.Step03_SBReject_NonCore;
import sBActions_US.Step03_SBReturn_NonCore;


public class SB_Rej
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
		ProfilesIni ini = new ProfilesIni();
    	FirefoxProfile profile = ini.getProfile("default");
    	//WebDriver driver =  new FirefoxDriver(profile);
			
    	driver = new FirefoxDriver(profile);
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 5, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 5, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 5, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
    	
             
        driver.get(url1);    
	  }	
		
	
		  
		 @Test(priority=1)
		  public void sb_rej()
		  {
			 Step03_SBReject_NonCore sbreject = new Step03_SBReject_NonCore(driver);
			 sbreject.sblogin();
			 sbreject.SB_Reject();
			  
		  }
	 
		  
		  
}

