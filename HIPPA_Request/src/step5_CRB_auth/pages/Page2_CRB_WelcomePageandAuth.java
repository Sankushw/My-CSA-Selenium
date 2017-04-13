package step5_CRB_auth.pages;


import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Click;

import lib.Excel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Page2_CRB_WelcomePageandAuth 
{
	
	WebDriver driver;
	
	// Define all web elements under test displayed on home page
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Switch instance')]") private WebElement Switch_Instance;
	@FindBy (id="FLD_SELECT_INSTANCE") private WebElement Instance ;
	@FindBy (name="btnGo") private WebElement GO ;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Awaiting client review board action')]") private WebElement Awaiting_CRB_auth_link ;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Candidates')]") private WebElement Candidates ;
	@FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
	@FindBy (name="btnGo") private WebElement GO_reqnum ;
	@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a) " ) private WebElement Request_Number ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement Skill_link ;
	@FindBy(name="tblcolCandId") private WebElement  Select_Checkbox ;
	@FindBy (name="btnAuthSel") private WebElement Authorize_selected ;
	
	private String getReqNum(String Req_Num) 
	{
		
		return ".//*[@id='content-main']//a[contains(text(),'"+ Req_Num +"')]";
	}
	
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		
	
		// Initialize the web elements 
		public Page2_CRB_WelcomePageandAuth(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
	
		
		//Function to click Create New Request button
        public void Switch_ins ()
        {
        	WebDriverWait wait01 = new WebDriverWait(driver, 180);
			wait01.until(ExpectedConditions.visibilityOf(Switch_Instance));
			
			
        	Switch_Instance.click();
        	
        	try {
    			Thread.sleep(6000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} 
        	
        	Select ins = new Select(Instance);
    		ins.selectByVisibleText("Americas");
    		
    		GO.click();
    		
    		try {
    			Thread.sleep(6000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} 
    		
    		
    		WebDriverWait wait02 = new WebDriverWait(driver, 180);
			wait02.until(ExpectedConditions.visibilityOf(Awaiting_CRB_auth_link));
			
			
    		Awaiting_CRB_auth_link.click();
    		
    		WebDriverWait wait06 = new WebDriverWait(driver, 180);
			wait06.until(ExpectedConditions.visibilityOf(Candidates));
			
    		Candidates.click();
    		
    		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
    		GO_reqnum.click();

    		String Req_Num = Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15) ;
    		
    		 WebDriverWait wait03 = new WebDriverWait(driver, 160);
    			wait03.until(ExpectedConditions.visibilityOf(Skill_link)); 
    		
    	Skill_link.click();
    	
    	WebDriverWait wait07 = new WebDriverWait(driver, 160);
 		wait07.until(ExpectedConditions.visibilityOf(Authorize_selected)); 
    	
    	
 		Select_Checkbox.click();
 		
    	Authorize_selected.click();
    	
    	 WebDriverWait wait04 = new WebDriverWait(driver, 160);
 		wait04.until(ExpectedConditions.visibilityOf(Authorize_selected)); 
 		
 		 /* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

	try {
		String filename = "C:\\Users\\IBM_ADMIN\\Desktop\\Snap"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(srcFile, new File (filename));





	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Error...............");
		
	}
 		
 		Authorize_selected.click();
    	
    	
  
    	
    	
    	
    	
    		
        	
        }
        
     
}


