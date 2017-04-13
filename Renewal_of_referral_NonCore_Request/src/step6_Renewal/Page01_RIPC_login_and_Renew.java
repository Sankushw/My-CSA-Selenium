package step6_Renewal;

import org.testng.annotations.Test;

import lib.Excel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page01_RIPC_login_and_Renew {
 
  
  private WebDriver driver;
  
  public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath = ".//*[@id='content-main']/form[1]/div/span/input") private WebElement Create_New_Request;
	@FindBy (xpath = ".//*[@id='FLD_REQ_TYPE1']") private WebElement Renewal;
	@FindBy (xpath = ".//*[@id='FLD_RENEWAL_TYPE1']") private WebElement Based_on_previous_request;
	@FindBy (name = "FLD_BOND_CART_NUM") private WebElement Bond_cart_No;
	@FindBy (name = "btnContinue") private WebElement Continue;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[2]/a") private WebElement Request_No;
	@FindBy (name = "btnRenewSelected") private WebElement Renew_selected;
	@FindBy (xpath = ".//*[@id='FLD_MULTI_LINE_ITEMS']") private WebElement Select_Checkbox;

	
		
	
	
	// Initialize the web elements 
	public Page01_RIPC_login_and_Renew(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	// Click on the link again as workaround 
	public void login(){
		
		loginToContractor_Link.click();
		
	
		
		
	        	WebDriverWait wait01 = new WebDriverWait(driver, 180);
				wait01.until(ExpectedConditions.visibilityOf(Create_New_Request));
				
				
	        	Create_New_Request.click();
	        	
	        	WebDriverWait wait02 = new WebDriverWait(driver, 180);
				wait02.until(ExpectedConditions.visibilityOf(Renewal));
				
				Renewal.click();
				Based_on_previous_request.click();
				
				Bond_cart_No.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 16));
				
				
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
	    		Continue.click();

	    		WebDriverWait wait03 = new WebDriverWait(driver, 180);
				wait03.until(ExpectedConditions.visibilityOf(Request_No));
				
				Request_No.click();
				
				WebDriverWait wait04 = new WebDriverWait(driver, 180);
				wait04.until(ExpectedConditions.visibilityOf(Renew_selected));
				
				 /* code to capture screenshot */
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;
	  	
	  	File srcFile01 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
	      
			try {
				String filename = "C:\\Users\\IBM_ADMIN\\Desktop\\Snap"+System.currentTimeMillis()+".png";
				FileUtils.copyFile(srcFile01, new File (filename));





			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error...............");
				
			}
			
			
			
			
				Select_Checkbox.click();
				Renew_selected.click();
				
				
				
				
				
				
	          
  }
}
