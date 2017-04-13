package renewalOfReferral_Core.Testcase;

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
import step3_SBAuthorization.Page1_SBLogin;
import step3_SBAuthorization.Page2_SBReject;
import step3_SBAuthorization.Page2_SBReturn;
import step3_SBAuthorization.Page2_SBauth;




public class SB_Authorization
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
		ProfilesIni ini = new ProfilesIni();
    	FirefoxProfile profile = ini.getProfile("default");
    	//WebDriver driver =  new FirefoxDriver(profile);
			
    	driver = new FirefoxDriver(profile);
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 2, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 2, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 2, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
        
        driver.get(url1);    
	  }	
		
		 // test to Login to the application as RIPC
		  @Test(priority=0)
		  public void SB_Login() 
		  {
			  
			  Page1_SBLogin login = new Page1_SBLogin(driver);
			  login.login();
		  }
		  
		  @Test(priority=1)
		  public void SB_auth() 
		  {
			  
			  Page2_SBauth wlcmpage = new Page2_SBauth(driver);
			  wlcmpage.SBAuth();
		  }
		  
		  
		 /*  @Test(priority=2)
		  public void SB_return() 
		  {
			  
			  Page2_SBReturn wlcmpage = new Page2_SBReturn(driver);
			  wlcmpage.SBReturn();
		  }
		  
		  @Test(priority=2)
		  public void SB_reject() 
		  {
			  
			  Page2_SBReject wlcmpage = new Page2_SBReject(driver);
			  wlcmpage.SBReject();
		  }
		  */
		  
		  
}
		  
	
