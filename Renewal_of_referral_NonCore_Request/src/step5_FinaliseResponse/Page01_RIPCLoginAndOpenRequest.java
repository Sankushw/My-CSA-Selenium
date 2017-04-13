package step5_FinaliseResponse;

import org.testng.annotations.Test;

import lib.Excel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page01_RIPCLoginAndOpenRequest {
 
  
  private WebDriver driver;
  
  public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy ( xpath = ".//*[@id='left-nav']//a[contains(text(), 'Search')]" ) private WebElement LHS_Search_tab ;
	@FindBy ( id="FLD_REQ_NUM_SEARCH" ) private WebElement Request_Num_Fld ;
	@FindBy ( name="GO" ) private WebElement Search_GO_btn ;
	@FindBy ( xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[1]/a" ) private WebElement Request_Num_link ;
	
	 
	
	// Initialize the web elements 
	public Page01_RIPCLoginAndOpenRequest(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	
	public void loginAndOpenReq (){
		
		loginToContractor_Link.click();
		
		LHS_Search_tab.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 160);
		wait.until(ExpectedConditions.visibilityOf(Request_Num_Fld)); 
		
		
		Request_Num_Fld.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
		
		Search_GO_btn.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 160);
		wait1.until(ExpectedConditions.visibilityOf(Request_Num_link)); 
		
		
		Request_Num_link.click();
		
		
		
		
  
  }
}

