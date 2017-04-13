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
import sBActions_GB.Step05_CRBAuthNC_GB;
import sBActions_IN.Step05_CRBAuthNC_IN;


public class CRB_Actions_IN
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
	
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 15, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 15, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 15, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
        
        driver.get(url1);    
	  }	
		
		 // test to Login to the application as RIPC
		  
		  @Test(priority=0)
		  public void CRB_login() 
		  {
			  
			  Step05_CRBAuthNC_IN crb = new Step05_CRBAuthNC_IN(driver);
			  crb.crblogin();
			  crb.CRB_Auth();
			  
		  }
		  
}
		  
	
