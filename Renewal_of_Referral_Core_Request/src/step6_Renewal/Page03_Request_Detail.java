package step6_Renewal;

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
import org.testng.annotations.Test;

import lib.Excel;

public class Page03_Request_Detail 
{
	WebDriver driver;
	
public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
    @FindBy ( id="FLD_PROJ_NAME") private WebElement Project_Name;
    @FindBy (id="FLD_IS_GLOBAL_RESOURCE0") private WebElement GlobalResource_No ;
    @FindBy ( id="FLD_CONTACT_NAME") private WebElement CustomerName_Refernce ;
    @FindBy ( xpath = ".//*[@id='FLD_IS_FED_CONTRACT']")  private WebElement Govt_FederalContract ;
    @FindBy ( id="FLD_CLIENT") private WebElement Client ;
    @FindBy ( id="FLD_BRAND") private WebElement Brand ;
    @FindBy ( id="FLD_SECTOR") private WebElement Sector ;
    @FindBy ( id="FLD_INDUSTRY") private WebElement Industry ;
    @FindBy ( id="fldRegulatedAcc1") private WebElement FDA ;
    @FindBy ( id="fldRegulatedAcc2") private WebElement FFIEC ;
    @FindBy ( id="fldRegulatedAcc4") private WebElement NREG ;
    @FindBy ( xpath = " .//*[@value='I'] " ) private WebElement Accounting_Type ;
   // @FindBy ( name="btnSaveAsDraft" ) private WebElement Save_As_Draft;
    @FindBy ( name="btnContinue" ) private WebElement Continue;
    @FindBy ( xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[4]/a" ) private WebElement Description ;
    @FindBy ( id="Edit details") private WebElement Edit_details ;
    @FindBy ( name="FLD_END_DT_DAY" ) private WebElement End_Day;
    @FindBy ( name="FLD_END_DT_MONTH" ) private WebElement End_Month;
    @FindBy ( name="FLD_END_DT_YEAR" ) private WebElement End_Year;
    @FindBy ( name="Continue" ) private WebElement Continue_Button;

    @FindBy ( xpath = ".//*[@id='FLD_DISCUSS_PROC']" ) private WebElement Procurement_Yes ;
    @FindBy ( xpath = ".//*[@id='FLD_PRE_APPROVAL']" ) private WebElement Preapproval_yes ;
    @FindBy (id="FLD_WARNING_JUST") private WebElement SupplierWarning;
    @FindBy (xpath = ".//*[@value='Continue to request summary'] ") private WebElement ContinueToRequestSummary;
    @FindBy (name = "Submit request") private WebElement SubmitRequest;
    @FindBy ( xpath= ".//*[@id='content-main']/table[1]/tbody/tr/td[1]/h1 ") private WebElement RequestCreated;
    
   
    
 // Initialize the web elements 
	public Page03_Request_Detail(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	 public void Request_detailpage()
	    
	    {
		 
		Project_Name.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 4));
		GlobalResource_No.click();
		Govt_FederalContract.click();
		Client.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 5));
		Brand.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 6));
		Sector.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 7));
		Industry.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 8));
		FDA.click();
		FFIEC.click();
		NREG.click();
		Accounting_Type.click();
		Continue.click();
		
		WebDriverWait wait01 = new WebDriverWait(driver, 180);
		wait01.until(ExpectedConditions.visibilityOf(Description));
		
		Description.click();
		
		WebDriverWait wait02 = new WebDriverWait(driver, 180);
		wait02.until(ExpectedConditions.visibilityOf(Edit_details));
	
		Edit_details.click();
		
		WebDriverWait wait03 = new WebDriverWait(driver, 180);
		wait03.until(ExpectedConditions.visibilityOf(Continue_Button));
		
		End_Day.sendKeys("26");
		End_Month.sendKeys("Nov");
		End_Year.sendKeys("2018");
	
		Continue_Button.click();
		
		
	    driver.switchTo().alert().accept();
		
		WebDriverWait wait04 = new WebDriverWait(driver, 180);
		wait04.until(ExpectedConditions.visibilityOf(Continue_Button));
		
		Continue_Button.click();
		
		
		Procurement_Yes.click();
		Preapproval_yes.click();
		Continue.click();
		
		WebDriverWait wait05 = new WebDriverWait(driver, 180);
		wait05.until(ExpectedConditions.visibilityOf(Continue));
		
		Continue.click();
		
		
		
	SupplierWarning.sendKeys("Solution is urgent.");
				
	Continue.click();
			
	WebDriverWait wait06 = new WebDriverWait(driver, 180);
	wait06.until(ExpectedConditions.visibilityOf(ContinueToRequestSummary));	
	
	
	 
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
	
	 ContinueToRequestSummary.click();
	 
	 
	 WebDriverWait wait07 = new WebDriverWait(driver, 180);
		wait07.until(ExpectedConditions.visibilityOf(SubmitRequest));
		
		
		 /* code to capture screenshot */
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;
	
	File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
 
	try {
		String filename = "C:\\Users\\IBM_ADMIN\\Desktop\\Snap"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(srcFile1, new File (filename));





	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Error...............");
		
	}
	
	SubmitRequest.click();
	
	WebDriverWait wait08 = new WebDriverWait(driver, 180);
	wait08.until(ExpectedConditions.visibilityOf(RequestCreated));
	
	
	 /* code to capture screenshot */
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)  ;

File srcFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;

try {
	String filename = "C:\\Users\\IBM_ADMIN\\Desktop\\Snap"+System.currentTimeMillis()+".png";
	FileUtils.copyFile(srcFile2, new File (filename));





} catch (IOException e) {
	// TODO Auto-generated catch block
	System.out.println("Error...............");
	
}
		
		
		
		
		
	   }
	 
	
}
  

