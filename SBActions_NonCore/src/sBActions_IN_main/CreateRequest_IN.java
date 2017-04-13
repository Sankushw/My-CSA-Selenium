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
import sBActions_GB.Step01_CreateReqGB_NonCore;
import sBActions_IN.Step01_CreateReqIN_NonCore;


public class CreateRequest_IN
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
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 12, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 12, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 12, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
    	      
        driver.get(url1);    
	  }	
		
		 // test to Login to the application as RIPC
		 @Test(priority=0)
	     public void NonCore_login()
	     {
	    	  Step01_CreateReqIN_NonCore noncore = new Step01_CreateReqIN_NonCore(driver);
	    	  noncore.login();
	     }
		  
		  @Test(priority=1)
		  public void Select_req()
		  {
			  Step01_CreateReqIN_NonCore selectreq = new Step01_CreateReqIN_NonCore(driver);
	    			  selectreq.GB_NonCore_Requestor();
		  }
		  
		  @Test(priority=2)
		  public void Select_JRSS()
		  {
			  Step01_CreateReqIN_NonCore selectjrss = new Step01_CreateReqIN_NonCore(driver);
			  selectjrss.Select_NonCore_JRSS();
		  }
	    	
		  @Test(priority=3)
		  public void Request_detail()
		  {
			  Step01_CreateReqIN_NonCore reqdetail = new Step01_CreateReqIN_NonCore(driver);
			  reqdetail.Request_NonCore_detail();
		  }
	    		
		  @Test(priority=4)
		  public void Request_Location()
		  {
			  Step01_CreateReqIN_NonCore reqloc = new Step01_CreateReqIN_NonCore(driver);
			  reqloc.Skill_NonCore_Locationpage();;
		  }
	    			  
		  @Test(priority=5)
		  public void alert()
		  {
			  Step01_CreateReqIN_NonCore alert = new Step01_CreateReqIN_NonCore(driver);
			  alert.isAlertPresent();
		  }		  
	    	
		  @Test(priority=6)
		  public void Skillprice()
		  {
			  Step01_CreateReqIN_NonCore skillprice = new Step01_CreateReqIN_NonCore(driver);
			 skillprice.Skill_NonCore_skillprice();
		  }
		  
		  @Test(priority=7)
		  public void Supplier_sel()
		  {
			  Step01_CreateReqIN_NonCore suppsel = new Step01_CreateReqIN_NonCore(driver);
			 suppsel.Supplier_NonCore("Supp_1", "Contact_1", "873873987900");
		  }
		  
		  @Test(priority=8)
		  public void Req_data()
		  {
			  Step01_CreateReqIN_NonCore req_data = new Step01_CreateReqIN_NonCore(driver);
			 req_data.Reqdata();
		  }		  
	    	
		  @Test(priority=9)
		  public void addSkill()
		  {
			  Step01_CreateReqIN_NonCore addskill = new Step01_CreateReqIN_NonCore(driver);
			 addskill.AddSkill();
		  }	
		  
		  @Test(priority=10)
		  public void JRSS2()
		  {
			  Step01_CreateReqIN_NonCore jrss2 = new Step01_CreateReqIN_NonCore(driver);
			 jrss2.Select_NonCore_JRSS();
		  }	
	    	
		  @Test(priority=11)
		  public void Locpage2()
		  {
			  Step01_CreateReqIN_NonCore locpage2 = new Step01_CreateReqIN_NonCore(driver);
			 locpage2.Skill_NonCore_Locationpage();
		  }
	    	
		  @Test(priority=12)
		  public void Alert2()
		  {
			  Step01_CreateReqIN_NonCore alert2 = new Step01_CreateReqIN_NonCore(driver);
			  alert2.isAlertPresent();
		  }
		  @Test(priority=13)
		  public void skillPrice2()
		  {
			  Step01_CreateReqIN_NonCore skillprice2 = new Step01_CreateReqIN_NonCore(driver);
			  skillprice2.Skill_NonCore_skillprice();
		  }
	    	
		  @Test(priority=14)
		  public void Supplier_sel2()
		  {
			  Step01_CreateReqIN_NonCore suppsel2 = new Step01_CreateReqIN_NonCore(driver);
			 suppsel2.Supplier_NonCore("supp_2", "Contact_2", "873873987911");
		  }
	    			  
		  @Test(priority=15)
		  public void Req_data2()
		  {
			  Step01_CreateReqIN_NonCore req_data2 = new Step01_CreateReqIN_NonCore(driver);
			  req_data2.Reqdata();
		  }	
		  
		  //3rd skill
		  
		  @Test(priority=16)
		  public void addSkill3()
		  {
			  Step01_CreateReqIN_NonCore addskill3 = new Step01_CreateReqIN_NonCore(driver);
			 addskill3.AddSkill();
		  }	
		  
		  @Test(priority=17)
		  public void JRSS3()
		  {
			  Step01_CreateReqIN_NonCore jrss3 = new Step01_CreateReqIN_NonCore(driver);
			 jrss3.Select_NonCore_JRSS();
		  }	
	    	
		  @Test(priority=18)
		  public void Locpage3()
		  {
			  Step01_CreateReqIN_NonCore locpage3 = new Step01_CreateReqIN_NonCore(driver);
			 locpage3.Skill_NonCore_Locationpage();
		  }
	    	
		  @Test(priority=19)
		  public void Alert3()
		  {
			  Step01_CreateReqIN_NonCore alert3 = new Step01_CreateReqIN_NonCore(driver);
			  alert3.isAlertPresent();
		  }
		  @Test(priority=20)
		  public void skillPrice3()
		  {
			  Step01_CreateReqIN_NonCore skillprice3 = new Step01_CreateReqIN_NonCore(driver);
			  skillprice3.Skill_NonCore_skillprice();
		  }
	    	
		  @Test(priority=21)
		  public void Supplier_sel3()
		  {
			  Step01_CreateReqIN_NonCore suppsel3 = new Step01_CreateReqIN_NonCore(driver);
			 suppsel3.Supplier_NonCore("supp_3", "Contact_3", "873873987911");
		  }
	    			  
		  @Test(priority=22)
		  public void Req_data3()
		  {
			  Step01_CreateReqIN_NonCore req_data3 = new Step01_CreateReqIN_NonCore(driver);
			  req_data3.Reqdata();
		  }	
	    	
		  @Test(priority=23)
		  public void submit()
		  {
			  Step01_CreateReqIN_NonCore submit3 = new Step01_CreateReqIN_NonCore(driver);
			  submit3.Submit();
		  }
	    			
	    		  
	    	  
	     }