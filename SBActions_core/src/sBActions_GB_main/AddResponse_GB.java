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
import sBActions_GB.Step02_AddResponse_GB;


public class AddResponse_GB
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
		
		 

		  // Test to add response
	   @Test(priority=0)
		  public void add_response()
		  {
		       log.debug("Inside open_CSA_Tab() function");
			  
			  Step02_AddResponse_GB addresp = new Step02_AddResponse_GB(driver); 
			  
			  for (int i=1; i<4; i++)
			  {
				  if(i==1)
				  {
				 addresp.login();
				  addresp.FillRespdetails("fResp"+i , "GB" , "lResp"+i, "700");
				  }  
				  else if(i==2)
				  {
				  //addresp.login();
				  addresp.FillRespdetails("fResp"+i , "GB" , "lResp"+i, "800");
				  }
			  else
			  {
				  //addresp.login();
				  addresp.FillRespdetails("fResp"+i , "GB" , "lResp"+i, "900");
				  addresp.Submit();
			  }
			  }
		  }
}
		
		  
		

