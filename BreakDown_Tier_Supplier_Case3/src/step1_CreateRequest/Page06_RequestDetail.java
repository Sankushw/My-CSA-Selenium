

package step1_CreateRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import lib.Excel;

public class Page06_RequestDetail {
	WebDriver driver;

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";

	@FindBy(id = "FLD_PROJ_NAME") 
	private WebElement Project_Name;
	@FindBy(id = "FLD_IS_GLOBAL_RESOURCE0")
	private WebElement GlobalResource_No;
	@FindBy(id = "FLD_CONTACT_NAME")
	private WebElement CustomerName_Refernce;
	@FindBy(xpath = ".//*[@id='FLD_IS_FED_CONTRACT1']")
	private WebElement Govt_FederalContract_YES;
	@FindBy(id = "FLD_CLIENT")
	private WebElement Client;
	@FindBy(id = "FLD_BRAND")
	private WebElement Brand;
	@FindBy(id = "FLD_SECTOR")
	private WebElement Sector;
	@FindBy(id = "FLD_INDUSTRY")
	private WebElement Industry;
	@FindBy(id = "fldRegulatedAcc1")
	private WebElement FDA;
	@FindBy(id = "fldRegulatedAcc2")
	private WebElement FFIEC;
	@FindBy(id = "fldRegulatedAcc4")
	private WebElement NREG;
	@FindBy(xpath = " .//*[@value='I'] ")
	private WebElement Accounting_Type;
	@FindBy(name = "btnContinue")
	private WebElement Continue;

	// Initialize the web elements
	public Page06_RequestDetail(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Request_detailpage()

	{

		Project_Name.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 4));
		GlobalResource_No.click();
		Govt_FederalContract_YES.click();
		Client.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 5));
		Brand.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 6));
		Sector.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 7));
		Industry.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 8));
		FDA.click();
		FFIEC.click();
		NREG.click();
		Accounting_Type.click();
		Continue.click();

	}

}