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

public class Page07_SkilldetailLocation
{
	WebDriver driver;
	
public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
   
    @FindBy ( id="FLD_WRK_LOC_STATE" ) private WebElement State_Region_Province;
    @FindBy ( id="FLD_WRK_LOC_CITY" ) private WebElement City ;
    @FindBy ( id="FLD_WRK_LOC" ) private WebElement Work_Location ;
    @FindBy ( name="Continue" ) private WebElement Continue ;
    @FindBy (id="FLD_ALT_WORK_LOC" ) private WebElement Alternate_Workloc ;
    
   
    
 // Initialize the web elements 
	public Page07_SkilldetailLocation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	 public void Skill_detailLocationpage()
	    
	    {
		 
	  // State_Region_Province.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 9));
		 
		 Select st = new Select(State_Region_Province);
			st.selectByVisibleText("London, City of");
			
	   try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	   
	   
		
	   Select ct = new Select(City);
		ct.selectByVisibleText("LONDON");
		
		
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
  

