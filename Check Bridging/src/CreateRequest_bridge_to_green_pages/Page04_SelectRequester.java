package CreateRequest_bridge_to_green_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import lib.Excel;

public class Page04_SelectRequester {
	WebDriver driver;
	
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	
	@FindBy  (id = "FLD_REQST_CO") private WebElement  Requesting_Company ;
	@FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;
	@FindBy (name= "btnContinue" ) private WebElement Continue ;
	

	
	
	
	// Initialize the web elements 
				public Page04_SelectRequester(WebDriver driver)
				{
					this.driver=driver;
					PageFactory.initElements(driver, this);
				}
		
				 public void Select_Requester()
				    
				    {
				    
					 
					
					Requesting_Company.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 0)); 
					Requesting_Organization.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 1));
					Continue.click();
					
					
					
					
					
				    }		
}
