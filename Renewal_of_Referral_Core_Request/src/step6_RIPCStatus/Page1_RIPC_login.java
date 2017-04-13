package step6_RIPCStatus;

import org.testng.annotations.Test;

import lib.Excel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page1_RIPC_login {
 
  
  private WebDriver driver;
  
  public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Search')]") private WebElement Search ;
	@FindBy ( id="FLD_REQ_NUM_SEARCH") private WebElement Request_Num ;
	@FindBy ( name="GO") private WebElement Go_btn ;
	@FindBy  ( xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[1]/a") private WebElement ReqNumlink ;
	@FindBy ( xpath = ".//*[@id='content-main']/form/table[1]/tbody/tr[11]/td[3]/a") private WebElement Supplink ;
	
	
	
	
	// Initialize the web elements 
	public Page1_RIPC_login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	// Click on the link again as workaround 
	public void login(){
		
		loginToContractor_Link.click();
		Search.click();
		
		Request_Num.sendKeys(Excel.getCellValue(xlsFilePath,"Request_creation", 1, 15));
		Go_btn.click();
		
		
		ReqNumlink.click();
		Supplink.click();
		
  
  }
}
