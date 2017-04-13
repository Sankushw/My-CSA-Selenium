package step1_CreateRequest;

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

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import lib.Excel;

public class Page12_SubmitConfimationLast
{
WebDriver driver;
	
public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";	
	
   @FindBy ( xpath= ".//*[@id='content-main']/table[1]/tbody/tr/td[1]/h1 ") private WebElement RequestCreated;
  
    
   
    
 // Initialize the web elements 
	public Page12_SubmitConfimationLast (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	 public String Reqdata()
	    
	    {
		
		// set req no. to excel sheet
		 WebDriverWait wait1 = new WebDriverWait(driver, 160);
			wait1.until(ExpectedConditions.visibilityOf(RequestCreated));
	
			String Number = RequestCreated.getText().substring(33, 39);
			System.out.println(Number);
			
			Excel.setCellValue(xlsFilePath, "Request_creation", 1, 15, Number );
			
		 
		 /* code to capture screenshot */
		 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
					
		return RequestCreated.getText();
		
	   }
	 
	 
}
