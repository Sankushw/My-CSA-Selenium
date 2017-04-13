package CreateRequest_bridge_to_green_pages;

import org.testng.annotations.Test;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import lib.Excel;

public class Page09_Supplier_Selection
{
WebDriver driver;
	
	
		
	    @FindBy (id="PRIMARY_RADIAL_BUTTON") private WebElement Primary_Supplier;
	    @FindBy (name="btnContinue") private WebElement Continue ;
	    @FindBy ( id="FLD_SUPPLIER_CONTRACTS") private WebElement Contract ;
	    
	   
	    
	 // Initialize the web elements 
		public Page09_Supplier_Selection(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		 public void SupplierSelectionPage()
		    
		    {
			Primary_Supplier.click();
			
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
			
			
			 WebDriverWait wait = new WebDriverWait(driver, 160);
				wait.until(ExpectedConditions.visibilityOf(Contract)); 
				
				
				
				
				Continue.click();
				
				
				
		   }
}
