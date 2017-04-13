package step2_ENCauthorization;


import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import lib.Excel;

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
import org.openqa.selenium.support.ui.WebDriverWait;

public class ENC_Authoriz {
 
  
  private WebDriver driver;
  public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
  
	// Define the element 
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Awaiting executive noncore approver action')]") private WebElement Awaiting_ENC_auth_link ;
    @FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
	@FindBy (name="btnGo") private WebElement GO_reqnum ;
	@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a) " ) private WebElement Request_Number ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement Skill_link ;
	@FindBy (id="FLD_CMTS_TO_REQSTR") private WebElement ENC_Comments;
	//@FindBy (name="butnSaveAndContinue") private WebElement SaveAndAuthorize ;
	@FindBy (id="content-main']/form/div[2]/span/span/input") private WebElement ExitReq;
	@FindBy (id="btnSearch") private WebElement SearchBtn ;
	@FindBy (id="FLD_SUPP_NUMBER" ) private WebElement SuppNum ;
	@FindBy (id="FLD_FAIR_VALUE_ANALYSIS" ) private WebElement FVAText ;
 	@FindBy (name="btnSaveAndAuth") private WebElement SaveAndAuth ;
	
	
	
	// Initialize the web elements 
	public ENC_Authoriz(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// login and authorization 
	public void ENCAuth ()
    {
		loginToContractor_Link.click();
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(Awaiting_ENC_auth_link));
		
		
		Awaiting_ENC_auth_link.click();
		
		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
		GO_reqnum.click();
		 WebDriverWait wait03 = new WebDriverWait(driver, 160);
			wait03.until(ExpectedConditions.visibilityOf(Skill_link)); 
		
			/* code to capture screenshot */
			 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
						
			
	Skill_link.click();
	
	WebDriverWait wait07 = new WebDriverWait(driver, 160);
		wait07.until(ExpectedConditions.visibilityOf(SaveAndAuth)); 
		ENC_Comments.sendKeys("Approved");
		
		/* code to capture screenshot */
		 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
					
	
    SaveAndAuth.click();
	
	WebDriverWait wait04 = new WebDriverWait(driver, 160);
	wait04.until(ExpectedConditions.visibilityOf(ExitReq)); 
		
		
		
	/* code to capture screenshot */
	 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
				
		
    	
    }
	
	
	
}
