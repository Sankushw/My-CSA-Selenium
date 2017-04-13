package LiteRequest_CA_NA_TestCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.Excel;
import step4_PO_auth.pages.Pageset_PO_auth;
 
public class PO_Authorization {
  
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
		
	    	id = Excel.getCellValue(xlsFilePath, sheet, 5, 0);
	   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 5, 1);
	    	url = Excel.getCellValue(xlsFilePath, sheet, 5, 2);
	    	
	    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
	        
	        driver.get(url1);    
		  }	
						  
			// test to login and authorize request from PO
			  @Test(priority=0)
			  public void authorize_PO() 
			  {
				  
				  Pageset_PO_auth auth_PO = new Pageset_PO_auth(driver);
				  auth_PO.authorize_PO();
			  }
}
