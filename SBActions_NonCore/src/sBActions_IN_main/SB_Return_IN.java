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
import sBActions_IN.Step03_SBReturn_NC_IN;
import sBActions_US.Step03_SBAuth_NonCore;
import sBActions_US.Step03_SBReject_NonCore;
import sBActions_US.Step03_SBReturn_NonCore;


public class SB_Return_IN
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
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 13, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 13, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 13, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
    	
             
        driver.get(url1);    
	  }	
		
		@Test(priority=1)
		  public void SBRet()
		  {
			 
			  Step03_SBReturn_NC_IN sbret = new Step03_SBReturn_NC_IN(driver);
			  sbret.SBlogin();
			  sbret.SB_Return();
		  }
}

