package step1_CreateRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

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
					
					/* code to capture screenshot */
					 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
					 
					Continue.click();
					
					
					
					
					
				    }		
}
