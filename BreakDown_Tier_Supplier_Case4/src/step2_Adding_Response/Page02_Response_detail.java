package step2_Adding_Response;

import org.testng.annotations.Test;
import lib.Excel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Page02_Response_detail 
{
 
	private WebDriver driver;

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	@FindBy (xpath =".//*[@id='ibm-content-main']/form[1]/div/div/div[1]/div/table/tbody/tr[2]/td[2]/a") private WebElement Response_Identification; 
	//@FindBy ( id="FLD_CAND_FIRST_NM") private WebElement First_Name ;
	//@FindBy ( id="FLD_CAND_MDL_NM") private WebElement Middle_Name;
	//@FindBy ( id="FLD_CAND_LAST_NM_SURNM") private WebElement LastName_Surname ;
	@FindBy ( id="FLD_CITIZENSHIP") private WebElement Citizenship ;
	@FindBy ( id="FLD_CAND_RES") private WebElement Resp_Attachment ;
	
	@FindBy (xpath= ".//*[@id='ibm-content-main']//div[4]//tr[2]//td[3]") private WebElement lbl_StartDate;
	@FindBy (xpath= ".//*[@id='ibm-content-main']//div[4]//tr[3]//td[3]") private WebElement lbl_EndDate;
	@FindBy (xpath= ".//*[@id='ibm-content-main']//div[4]//tr[4]//td[3]") private WebElement lbl_Skill_Level;
	@FindBy ( id="FLD_START_DT") private WebElement txt_StartDate ;
	@FindBy ( id="FLD_END_DT" ) private WebElement txt_EndDate ;
	@FindBy (name="FLD_SKILL_LVL") private WebElement  DD_SkillLevel ;
	@FindBy (xpath = ".//*[@id='ibm-content-main']//input[@class='ibm-btn-arrow-pri' and @title='Continue']" ) private WebElement Continue ;
	
	
	
	
	
	// Initialize the web elements 
		public Page02_Response_detail (WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void FillRespdetails() 
		{
			
			WebDriverWait wait = new WebDriverWait(driver, 160);
			wait.until(ExpectedConditions.visibilityOf(Response_Identification));
			
			Response_Identification.click();
			
			WebDriverWait wait1 = new WebDriverWait(driver, 160);
			wait1.until(ExpectedConditions.visibilityOf(Continue));
			
					
			Select ct = new Select(Citizenship);
			ct.selectByVisibleText("United States");
				
			
			String startDate = lbl_StartDate.getText().trim();
			txt_StartDate.sendKeys(startDate); 
			
			String endDate = lbl_EndDate.getText().trim();
			txt_EndDate.sendKeys(endDate); 
			
			String Skill = lbl_Skill_Level.getText().trim();
			Select sel = new Select(DD_SkillLevel);
			sel.selectByVisibleText(Skill); 
			
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
            Resp_Attachment.click();
			
			String path  = Excel.getCellValue(xlsFilePath, "Add_response", 1, 3);



			//put path to your file in a clipboard
		    StringSelection ss = new StringSelection(path);
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);


			try {
				Robot robot = new Robot();

				robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);

			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			

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
			
			Continue.click();
			

			
			
			
		}
}
