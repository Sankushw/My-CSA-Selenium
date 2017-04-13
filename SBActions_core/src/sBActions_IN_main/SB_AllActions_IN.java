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
import sBActions_GB.Step05_SBActions_Core_GB;
import sBActions_IN.Step05_SBActions_Core_IN;
import sBActions_US.Step05_SBAuth_Rej_Ret_Core;


public class SB_AllActions_IN
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
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 11, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 11, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 11, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
    	
             
        driver.get(url1);    
	  }	
		
		
        //Test for Skill Request page
		 @Test(priority=1)
		  public void SB_auth() 
		  {
			  
			 Step05_SBActions_Core_IN sb= new Step05_SBActions_Core_IN (driver);
			  sb.loginSB();
			  sb.SB_open_Request();
			  sb.SB_Auth_IN();
			  sb.isAlertPresent();
			  sb.SB_Rej_IN ();
			  sb.isAlertPresent();
			  sb.SB_Return_IN ();
			  sb.isAlertPresent();
			  
		  }
		  
				  
		  
		  
}

