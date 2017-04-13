package step1_CreateRequest;

import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import lib.Excel;

public class Page08_SkilldetailSkillPrice 
{
 
	WebDriver driver;
	
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
		
	    @FindBy ( id="FLD_RQSTD_SKILL_LVL" ) private WebElement Skill_Level;
	    @FindBy (id="FLD_RQSTD_PRICE_LVL" )  private WebElement Price_Level;
	    @FindBy (id="FLD_QTY_SKILL_NEEDED" ) private WebElement Quantity ;
	    @FindBy (name="Continue") private WebElement Continue ;
	    
	   
	    
	 // Initialize the web elements 
		public Page08_SkilldetailSkillPrice(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		 public void Skill_detail_skillpricepage()
		    
		    {
			 
		    Skill_Level.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 12));
		    Price_Level.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 13));
		    
		    
		   
		    try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		    /* code to capture screenshot */
		    Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
		   			
			Continue.click();
			
		   }
		 public boolean isAlertPresent() 
		   { 
		       try 
		       { 
		           driver.switchTo().alert().accept(); 
		           return true; 
		       }   // try 
		       catch (NoAlertPresentException Ex) 
		       { 
		           return false; 

	       }  
		   }
}
