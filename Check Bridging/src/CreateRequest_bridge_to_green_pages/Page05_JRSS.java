package CreateRequest_bridge_to_green_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import lib.Excel;

public class Page05_JRSS {
WebDriver driver;
	
	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
    @FindBy ( xpath= ".//*[@id='JRSS_SELECTION1']") private WebElement Priced_JRSS;
    @FindBy ( id = "FLD_JOB_ROLE" ) private WebElement Select_JobRole ;
    @FindBy ( id = "FLD_SKILL_SET") private WebElement Select_SkillSet ;
    @FindBy ( name= "btnContinue" ) private WebElement Continue ;
  
    
   
    
 // Initialize the web elements 
	public Page05_JRSS(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	 public void Select_JRSS()
	    
	    {
		 
		 String JR = Excel.getCellValue(xlsFilePath, "Request_creation", 1, 2);
		 String SS = Excel.getCellValue(xlsFilePath, "Request_creation", 1, 3);  
	   
		 Priced_JRSS.click();	
		
	    Select JRlistbox = new Select(Select_JobRole);
		JRlistbox.selectByVisibleText(JR);
		
		Select SSlistbox = new Select(Select_SkillSet);
		SSlistbox.selectByVisibleText(SS);
		
		
		
	   }
	 
	 public void JRSS_Ctn()
	 {
		 Continue.click();
	 }
}
