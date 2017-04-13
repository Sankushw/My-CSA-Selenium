package sBActions_GB_main;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.Excel;
import sBActions_GB.Step06_POAuthNC_GB;

 
public class PO_Auth_GB {
  
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
		
	    	id = Excel.getCellValue(xlsFilePath, sheet, 10, 0);
	   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 10, 1);
	    	url = Excel.getCellValue(xlsFilePath, sheet, 10, 2);
	    	
	    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
	        
	        driver.get(url1);    
		  }	
			
			// test to Login to the application as RIPC
			  @Test(priority=0)
			  public void PO_Login() 
			  {
				  
				  Step06_POAuthNC_GB login = new Step06_POAuthNC_GB(driver);
				  login.login();
			  }
			  
			  
			// test to authorize request from PO
			  @Test(priority=1)
			  public void authorize_PO() 
			  {
				  
				  Step06_POAuthNC_GB auth_PO = new Step06_POAuthNC_GB(driver);
				  auth_PO.authorize_PO();
			  }

			  @Test(priority=2)
			  public void hiring_page() 
			  {
				  
				  Step06_POAuthNC_GB hiringpage = new Step06_POAuthNC_GB(driver);
				  hiringpage.hiring();
			  }

}


