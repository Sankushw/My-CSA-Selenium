package sBActions_IN_main;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.Excel;
import sBActions_IN.Step08_PO_Auth_IN;
import sBActions_US.Step08_PO_Auth;

 
public class PO_Authorization_IN {
  
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
				System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		    	driver = new ChromeDriver();
		    	
		
	    	id = Excel.getCellValue(xlsFilePath, sheet, 16, 0);
	   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 16, 1);
	    	url = Excel.getCellValue(xlsFilePath, sheet, 16, 2);
	    	
	    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
	        
	        driver.get(url1);    
		  }	
			
			// test to Login to the application as RIPC
			  @Test(priority=0)
			  public void PO_Login() 
			  {
				  
				  Step08_PO_Auth_IN login = new Step08_PO_Auth_IN(driver);
				  login.login();
			  }
			  
			  
			// test to authorize request from PO
			  @Test(priority=1)
			  public void authorize_PO() 
			  {
				  
				  Step08_PO_Auth_IN auth_PO = new Step08_PO_Auth_IN(driver);
				  auth_PO.authorize_PO();
			  }


}


