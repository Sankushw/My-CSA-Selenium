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
import sBActions_GB.Step06_POAuthNC_GB;
import sBActions_IN.Step06_POAuthNC_IN;

 
public class PO_Auth_IN {
  
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
				  
				  Step06_POAuthNC_IN login = new Step06_POAuthNC_IN(driver);
				  login.login();
			  }
			  
			  
			// test to authorize request from PO
			  @Test(priority=1)
			  public void authorize_PO() 
			  {
				  
				  Step06_POAuthNC_IN auth_PO = new Step06_POAuthNC_IN(driver);
				  auth_PO.authorize_PO();
			  }

			  @Test(priority=2)
			  public void hiring_page() 
			  {
				  
				  Step06_POAuthNC_IN hiringpage = new Step06_POAuthNC_IN(driver);
				  hiringpage.hiring();
			  }

}


