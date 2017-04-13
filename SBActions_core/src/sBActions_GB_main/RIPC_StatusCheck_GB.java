package sBActions_GB_main;

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
import sBActions_GB.Step06_RIPC_ResponseStatus_GB;
import sBActions_US.Step01_CreateRequest;
import sBActions_US.Step02_AddResponse;
import sBActions_US.Step03_Finalize;
import sBActions_US.Step06_RIPC_ResponseStatus;


public class RIPC_StatusCheck_GB
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
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 6, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 6, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 6, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
    	
            driver.get(url1);    
	  }	
		
		 // test to Login to the application as RIPC
		  @Test(priority=0)
		  public void RIPC_Login() 
		  {
			  
			  Step06_RIPC_ResponseStatus_GB statuschk = new  Step06_RIPC_ResponseStatus_GB(driver);
			  statuschk.login();
			  statuschk.status_verf();
			  
}
}