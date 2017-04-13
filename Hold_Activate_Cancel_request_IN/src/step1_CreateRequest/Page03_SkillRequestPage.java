package step1_CreateRequest;

import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Page03_SkillRequestPage
{
	WebDriver driver;
	
	// Define all web elements  
  @FindBy (id ="FLD_REQ_TYPE") private WebElement New_Request ;
  @FindBy ( id="FLD_NORMAL_TYPE1") private WebElement Time_Materials ;
  @FindBy (name = "btnContinue") private WebElement Continue ;
	
	// Initialize the web elements 
			public Page03_SkillRequestPage(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
	
	
    public void Skill_Request()
    
    {
    	
    	New_Request.click();
    	Time_Materials.click();
    	/* code to capture screenshot */
    	 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
    				
    	Continue.click();
    }
    

    
}
