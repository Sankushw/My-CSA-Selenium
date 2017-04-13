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
import sBActions_GB.Step01_CreateRequest_GB;


public class CreateRequest_GB
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
					  
					  Step01_CreateRequest_GB login = new Step01_CreateRequest_GB(driver);
					  login.login();
				  }
					@Test(priority=1)
					  public void Create_Req() 
					  {
						  
						  Step01_CreateRequest_GB createreq = new Step01_CreateRequest_GB(driver);
						  createreq.Create_New_Request();
					  }
					@Test(priority=2)
					  public void skill_Req() 
					  {
						  
						  Step01_CreateRequest_GB skillreq = new Step01_CreateRequest_GB(driver);
						  skillreq.Skill_Request();
					  }
					@Test(priority=3)
					  public void select_Req() 
					  {
						  
						  Step01_CreateRequest_GB selectreq = new Step01_CreateRequest_GB(driver);
						  selectreq.Select_Requestor();
					  }

					@Test(priority=4)
					  public void select_jrss() 
					  {
						  
						  Step01_CreateRequest_GB selectreq = new Step01_CreateRequest_GB(driver);
						  selectreq.Select_JRSS();
					  }

					@Test(priority=5)
					  public void req_detail() 
					  {
						  
						  Step01_CreateRequest_GB reqdetail = new Step01_CreateRequest_GB(driver);
						  reqdetail.Request_detailpage();
					  }
					@Test(priority=6)
					  public void skill_loc() 
					  {
						  
						  Step01_CreateRequest_GB skillloc = new Step01_CreateRequest_GB(driver);
						  skillloc.Skill_detailLocationpage();
					  }
					@Test(priority=7)
					  public void alert_check() 
					  {
						  
						  Step01_CreateRequest_GB alertchk = new Step01_CreateRequest_GB(driver);
						  alertchk.isAlertPresent();
					  }
					@Test(priority=8)
					  public void skill_price() 
					  {
						  
						  Step01_CreateRequest_GB skillprice = new Step01_CreateRequest_GB(driver);
						  skillprice.Skill_detail_skillpricepage();
					  }
					@Test(priority=9)
					  public void supp() 
					  {
						  
						  Step01_CreateRequest_GB supplier = new Step01_CreateRequest_GB(driver);
						  supplier.SupplierSelectionPage();
					  }
					@Test(priority=10)
					  public void req_data() 
					  {
						  
						  Step01_CreateRequest_GB reqdata = new Step01_CreateRequest_GB(driver);
						  reqdata.Reqdata();
					  }
		  }

		