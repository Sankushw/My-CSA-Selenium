package step4_Adding_Response;

import org.testng.annotations.Test;

import lib.Excel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page04_ResponseSummaryAndSubmit 
{
  
	private WebDriver driver;
	
	@FindBy (xpath = ".//*[@id='ibm-content-main']//input[@class='ibm-btn-arrow-pri']" ) private WebElement Continue ;
	@FindBy (xpath = ".//*[@id='ibm-content-main']//input[@class='ibm-btn-arrow-sec']" ) private WebElement Submit_Selected ;
	
	
	// Initialize the web elements 
		public Page04_ResponseSummaryAndSubmit (WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void RespSummaryandsubmit()
		{
			Continue.click();
			
			WebDriverWait wait = new WebDriverWait(driver, 160);
			wait.until(ExpectedConditions.visibilityOf(Submit_Selected));
			
			Submit_Selected.click();
			
			
			
			
			
			
		}
}
