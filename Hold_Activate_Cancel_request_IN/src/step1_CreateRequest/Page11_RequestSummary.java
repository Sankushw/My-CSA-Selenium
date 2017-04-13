package step1_CreateRequest;

import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.sun.glass.events.KeyEvent;

import java.awt.AWTException;
import java.awt.Robot;
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
import org.openqa.selenium.support.ui.Select;

import lib.Excel;



public class Page11_RequestSummary  
{
	WebDriver driver;
	
	 @FindBy (name = "Submit request") private WebElement SubmitRequest;
	 
	// Initialize the web elements 
			public Page11_RequestSummary (WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}

			 public void RequestSummaryPage()
			    
			    {
				 
				 
				 /* code to capture screenshot */
				 Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\IBM_ADMIN\\Desktop\\AUTOMATION_Hold active cancel\\"); 
							
				 SubmitRequest.click();
				
				
			   }
}