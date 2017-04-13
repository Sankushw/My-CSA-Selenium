package sBActions_US_main;

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
import sBActions_US.Step01_CreateReq_NonCore;


public class CreateRequest
{
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
		ProfilesIni ini = new ProfilesIni();
    	FirefoxProfile profile = ini.getProfile("default");
    	//WebDriver driver =  new FirefoxDriver(profile);
			
    	driver = new FirefoxDriver(profile);
	
    	id = Excel.getCellValue(xlsFilePath, sheet, 1, 0);
   	  	paswd = Excel.getCellValue(xlsFilePath, sheet, 1, 1);
    	url = Excel.getCellValue(xlsFilePath, sheet, 1, 2);
    	
    	String url1 = "https://" +  id + ":" + paswd + "@" + url;
    	      
        driver.get(url1);    
	  }	
		
		
		  
		//Non Core Request Creation
		  @Test(priority=0)
	     public void NonCore_login()
	     {
	    	  Step01_CreateReq_NonCore noncore = new Step01_CreateReq_NonCore(driver);
	    	  noncore.login();
	     }
		  
		  @Test(priority=1)
		  public void Select_req()
		  {
			  Step01_CreateReq_NonCore selectreq = new Step01_CreateReq_NonCore(driver);
	    			  selectreq.Select_NonCore_Requestor();
		  }
		  
		  @Test(priority=2)
		  public void Select_JRSS()
		  {
			  Step01_CreateReq_NonCore selectjrss = new Step01_CreateReq_NonCore(driver);
			  selectjrss.Select_NonCore_JRSS();
		  }
	    	
		  @Test(priority=3)
		  public void Request_detail()
		  {
			  Step01_CreateReq_NonCore reqdetail = new Step01_CreateReq_NonCore(driver);
			  reqdetail.Request_NonCore_detail();
		  }
	    		
		  @Test(priority=4)
		  public void Request_Location()
		  {
			  Step01_CreateReq_NonCore reqloc = new Step01_CreateReq_NonCore(driver);
			  reqloc.Skill_NonCore_Locationpage();;
		  }
	    			  
		  @Test(priority=5)
		  public void alert()
		  {
			  Step01_CreateReq_NonCore alert = new Step01_CreateReq_NonCore(driver);
			  alert.isAlertPresent();
		  }		  
	    	
		  @Test(priority=6)
		  public void Skillprice()
		  {
			  Step01_CreateReq_NonCore skillprice = new Step01_CreateReq_NonCore(driver);
			 skillprice.Skill_NonCore_skillprice();
		  }
		  
		  @Test(priority=7)
		  public void Supplier_sel()
		  {
			  Step01_CreateReq_NonCore suppsel = new Step01_CreateReq_NonCore(driver);
			 suppsel.Supplier_NonCore("Cand_1", "Contact_1", "873873987900");
		  }
		  
		  @Test(priority=8)
		  public void Req_data()
		  {
			  Step01_CreateReq_NonCore req_data = new Step01_CreateReq_NonCore(driver);
			 req_data.Reqdata();
		  }		  
	    	
		  @Test(priority=9)
		  public void addSkill()
		  {
			  Step01_CreateReq_NonCore addskill = new Step01_CreateReq_NonCore(driver);
			 addskill.AddSkill();
		  }	
		  
		  @Test(priority=10)
		  public void JRSS2()
		  {
			  Step01_CreateReq_NonCore jrss2 = new Step01_CreateReq_NonCore(driver);
			 jrss2.Select_NonCore_JRSS();
		  }	
	    	
		  @Test(priority=11)
		  public void Locpage2()
		  {
			  Step01_CreateReq_NonCore locpage2 = new Step01_CreateReq_NonCore(driver);
			 locpage2.Skill_NonCore_Locationpage();
		  }
	    	
		  @Test(priority=12)
		  public void Alert2()
		  {
			  Step01_CreateReq_NonCore alert2 = new Step01_CreateReq_NonCore(driver);
			  alert2.isAlertPresent();
		  }
		  @Test(priority=13)
		  public void skillPrice2()
		  {
			  Step01_CreateReq_NonCore skillprice2 = new Step01_CreateReq_NonCore(driver);
			  skillprice2.Skill_NonCore_skillprice();
		  }
	    	
		  @Test(priority=14)
		  public void Supplier_sel2()
		  {
			  Step01_CreateReq_NonCore suppsel2 = new Step01_CreateReq_NonCore(driver);
			 suppsel2.Supplier_NonCore("Cand_2", "Contact_2", "873873987911");
		  }
	    			  
		  @Test(priority=15)
		  public void Req_data2()
		  {
			  Step01_CreateReq_NonCore req_data2 = new Step01_CreateReq_NonCore(driver);
			  req_data2.Reqdata();
		  }	
	    	
		 		
	    	//adding 3rd skill
		  
		  @Test(priority=16)
		  
		  public void addSkill1()
		  {
			  Step01_CreateReq_NonCore addskill = new Step01_CreateReq_NonCore(driver);
			 addskill.AddSkill();
		  }
		  
	    	
		  @Test(priority=17)
		  public void JRSS3()
		  {
			  Step01_CreateReq_NonCore jrss2 = new Step01_CreateReq_NonCore(driver);
			 jrss2.Select_NonCore_JRSS();
		  }	
	    	
		  @Test(priority=18)
		  public void Locpage3()
		  {
			  Step01_CreateReq_NonCore locpage2 = new Step01_CreateReq_NonCore(driver);
			 locpage2.Skill_NonCore_Locationpage();
		  }
	    	
		  @Test(priority=19)
		  public void Alert3()
		  {
			  Step01_CreateReq_NonCore alert2 = new Step01_CreateReq_NonCore(driver);
			  alert2.isAlertPresent();
		  }
		  @Test(priority=20)
		  public void skillPrice3()
		  {
			  Step01_CreateReq_NonCore skillprice2 = new Step01_CreateReq_NonCore(driver);
			  skillprice2.Skill_NonCore_skillprice();
		  }
	    	
		  @Test(priority=21)
		  public void Supplier_sel3()
		  {
			  Step01_CreateReq_NonCore suppsel2 = new Step01_CreateReq_NonCore(driver);
			 suppsel2.Supplier_NonCore("Cand_3", "Contact_3", "873873934911");
		  }
	    			  
		  @Test(priority=22)
		  public void Req_data3()
		  {
			  Step01_CreateReq_NonCore req_data2 = new Step01_CreateReq_NonCore(driver);
			  req_data2.Reqdata();
		  }	
	    	
		  @Test(priority=23)
		  public void submit()
		  {
			  Step01_CreateReq_NonCore submit3 = new Step01_CreateReq_NonCore(driver);
			  submit3.Submit();
		  }
	    	
		  
		 
	     }
		

