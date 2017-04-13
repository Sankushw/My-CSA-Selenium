package sBActions_GB;

import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Step02_ENC_Auth_GB
{
	
private WebDriver driver;

public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	
	//Define Login element
	@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
	
	//Define all web elements under test displayed on home page
	@FindBy (xpath = ".//*[@id='left-nav']//a[contains(text(),'Awaiting executive noncore approver action')]") private WebElement Awaiting_ENC_Action ;
	@FindBy (id="FLD_REQUEST_NUMBER") private WebElement Req_Num_Search ;
	@FindBy (name="btnGo") private WebElement GO_reqnum ;
	
	//@FindBy (xpath =" .//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[3]/a) " ) private WebElement Request_Number ;
	@FindBy (xpath = ".//*[@id='content-main']/form/table[4]/tbody/tr[2]/td[5]/a" ) private WebElement Skill_link ;
	@FindBy (id="FLD_CMTS_TO_REQSTR") private WebElement ENC_Comments;
	@FindBy (name="btnSaveAndAuth") private WebElement SaveAndAuthorize ;
	@FindBy (id="content-main']/form/div[2]/span/span/input") private WebElement ExitReq;
	
		// Initialize the web elements 
	public Step02_ENC_Auth_GB (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Function to login to the application
	// Click on the link again as workaround 
	public void login()
	{
		
		loginToContractor_Link.click();
	}
	
	public void ENC_Auth_US()
	{
		
	WebDriverWait wait01 = new WebDriverWait(driver, 180);
	wait01.until(ExpectedConditions.visibilityOf(Awaiting_ENC_Action));
	
	
		Awaiting_ENC_Action.click();
	
	  		Req_Num_Search.clear();
		Req_Num_Search.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 2, 15));
		GO_reqnum.click();
	
		WebDriverWait wait02 = new WebDriverWait(driver, 160);
		wait02.until(ExpectedConditions.visibilityOf(Skill_link)); 
		
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
	
		Skill_link.click();

		WebDriverWait wait03 = new WebDriverWait(driver, 160);
		wait03.until(ExpectedConditions.visibilityOf(SaveAndAuthorize)); 
	
		ENC_Comments.sendKeys("Approved");
	
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");

		SaveAndAuthorize.click();
	
		//WebDriverWait wait04 = new WebDriverWait(driver, 160);
		//wait04.until(ExpectedConditions.visibilityOf(ExitReq)); 
	
		/* code to capture screenshot */
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\Screenshots\\");
		
	}


}

