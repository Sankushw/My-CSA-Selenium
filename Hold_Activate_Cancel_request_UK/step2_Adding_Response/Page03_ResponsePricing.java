package step4_Adding_Response;

import lib.Excel;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Page03_ResponsePricing 
{
  
	private WebDriver driver;

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	@FindBy ( id="FLD_ST_BILL_RT" ) private WebElement ST_rate ;
	@FindBy ( id="FLD_OT_BILL_RATE" ) private WebElement OT_rate ;
	@FindBy ( id="FLD_ST_WAGE" ) private WebElement ST_wage ;
	@FindBy (xpath = ".//*[@id='ibm-content-main']//input[@class='ibm-btn-arrow-pri']" ) private WebElement Continue ;
	
	
	// Initialize the web elements 
			public Page03_ResponsePricing  (WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			
			public void PricingAndSubmit()
			{
				ST_rate.clear();
				ST_rate.sendKeys("30.00");
				ST_wage.clear();
				ST_wage.sendKeys("30.00");
				
				Continue.click();
				
			
			}
}
