package step1_CreateRequest;

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

public class Page08A_Service_Identification {
	  private WebDriver driver;
		
		// Define the element 
	  
	    @FindBy ( xpath = ".//*[@id='FLD_DISCUSS_PROC']" ) private WebElement Procurement_Yes ;
	    @FindBy ( xpath = ".//*[@id='FLD_PRE_APPROVAL']" ) private WebElement Preapproval_yes ;
	    @FindBy (name = "FLD_RCMMD_SCND_TIER_SUPP") private WebElement Tier_Supplier_solution_Provider_Name;
		@FindBy (name = "btnContinue") private WebElement Continue;
		
		
		// Initialize the web elements 
		public Page08A_Service_Identification(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		
		// Function to fill candidate details
		public void Candidate(){
	
			Procurement_Yes.click();
			Preapproval_yes.click();
			Tier_Supplier_solution_Provider_Name.sendKeys("Test SSP Name");
			
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
		}
		
}
