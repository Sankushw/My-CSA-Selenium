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
import sBActions_GB.Step03_SBReject_NonCore;
import sBActions_GB.Step03_SBReturn_NonCore;
import sBActions_GB.Step03_SB_Auth_NonCore;
import sBActions_US.Step03_SBAuth_NonCore;


public class SB_Auth_Ret_Rej_GB
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
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 8, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 8, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 8, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
    	
             
        driver.get(url1);    
	  }	
		
		
        //Test for Skill Request page
		  @Test(priority=0)
		  public void Login()
		  {
			 
			  Step03_SB_Auth_NonCore login = new Step03_SB_Auth_NonCore(driver);
			  login.loginSB();
		  }
		  
		  
		  @Test(priority=1)
		  public void SBAuth1()
		  {
			 
			  Step03_SBReject_NonCore sbrej = new Step03_SBReject_NonCore(driver);
			  sbrej.sblogin();
			  sbrej.SB_Reject();
		  }
		  
		  @Test(priority=2)
		  public void SBAuth2()
		  {
			 
			  Step03_SBReturn_NonCore sbreturn = new Step03_SBReturn_NonCore(driver);
			  sbreturn.SBlogin();
			  sbreturn.SB_Return();
		  }
			
			  
				  
		  
		  
}

