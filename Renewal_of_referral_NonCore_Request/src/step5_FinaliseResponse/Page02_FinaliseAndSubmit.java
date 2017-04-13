package step5_FinaliseResponse;

import org.testng.annotations.Test;
import lib.Excel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page02_FinaliseAndSubmit 
{
	 private WebDriver driver;
	 
	 public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	 
	 @FindBy ( xpath = ".//*[@id='content-main']/form/table[1]/tbody/tr[1]/td[3]/a" ) private WebElement Skill_link ;
	 @FindBy(name="tblcolCandId") private WebElement  Select_Checkbox ;
	 @FindBy ( name="btnAddSelFin" ) private WebElement Btn_AddSelectedToFinalists ;
	 
	 @FindBy ( name="btnSubmitSel" ) private WebElement Btn_SubmitSelected ;
	 //Hiring Approval 
	 @FindBy ( id="FLD_NON_METRO_HIRING_REQUEST_NUM" ) private WebElement Non_Metro ;
	 @FindBy (id="FLD_REASON_NOT_HAVING_METRO_NUM") private WebElement Reason ;
	 @FindBy (id="ContinueSubmit") private WebElement Continue_Submission;
	 //Submit confirmation page
	 @FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;
	 @FindBy (name="btnConfirmSubmit") private WebElement Confirm_Submission;
	 
	 
	// Initialize the web elements 
		public Page02_FinaliseAndSubmit(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void FinaliseSubmit()
		{
			
	 WebDriverWait wait = new WebDriverWait(driver, 160);
		wait.until(ExpectedConditions.visibilityOf(Skill_link)); 
		
		Skill_link.click();
		
		 WebDriverWait wait1 = new WebDriverWait(driver, 160);
	     wait1.until(ExpectedConditions.visibilityOf(Btn_AddSelectedToFinalists)); 
	     
	     Select_Checkbox.click();
		
	   Btn_AddSelectedToFinalists.click();
		
		 WebDriverWait wait4 = new WebDriverWait(driver, 160);
	     wait4.until(ExpectedConditions.visibilityOf(Btn_SubmitSelected));
		
	     Select_Checkbox.click();
			
		Btn_SubmitSelected.click();
		
		//Hiring Approval page
		WebDriverWait wait2 = new WebDriverWait(driver, 160);
		wait2.until(ExpectedConditions.visibilityOf(Continue_Submission));
		Non_Metro.click();
		 Reason.sendKeys("I use Metro, but can't for this situation and have a management-approved bypass");
		 Continue_Submission.click();
		 
		 //submit confirmation page
		 WebDriverWait wait3 = new WebDriverWait(driver, 160);
		 wait3.until(ExpectedConditions.visibilityOf(Confirm_Submission));
		 Requesting_Organization.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 1));
		 Confirm_Submission.click();
		 
		 
		 
		 
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
		
		
		}
 
}
