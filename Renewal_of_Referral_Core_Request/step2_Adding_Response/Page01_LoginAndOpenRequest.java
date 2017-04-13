package step4_Adding_Response;

import org.testng.annotations.Test;

import lib.Excel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Page01_LoginAndOpenRequest
{
	
private WebDriver driver;

public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	// Define the element 
	@FindBy (xpath = ".//*[@id='ibm-content-main']//a[contains(text(),'Sign in to CSA.')]"   ) private WebElement Sign_in_to_CSA ;
	
	@FindBy (xpath = ".//*[@id='ibm-primary-links']//a[contains(text(), 'CSA search')] " ) private WebElement CSA_search_tab ;
	@FindBy ( id = "FLD_REQ_NUM_SEARCH" ) private WebElement Req_Num_field ;
	@FindBy (xpath =".//*[@id='ibm-content-main']//input[@class='ibm-btn-arrow-pri']") private WebElement Search_btn ; 
	
	@FindBy ( xpath = " .//*[@id='ibm-content-main']/div[2]/div/table/tbody/tr[2]/td[1]/a" ) private WebElement Request_Number_link ;
	
	
	
	// Initialize the web elements 
	public Page01_LoginAndOpenRequest (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	// Click on the link again as workaround 
	public void login(){
		
		Sign_in_to_CSA.click();
		
		CSA_search_tab.click();
  
		Req_Num_field.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 1, 15));
		
		Search_btn.click();
		
		Request_Number_link.click();
		
		
		
		
  }

}
