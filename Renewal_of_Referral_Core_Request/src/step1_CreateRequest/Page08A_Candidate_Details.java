package step1_CreateRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page08A_Candidate_Details {
	  private WebDriver driver;
		
		// Define the element 
		@FindBy (name = "FLD_CAND_FIRST_NM") private WebElement Cand_First_Name;
		@FindBy (name = "FLD_CAND_LAST_NM") private WebElement Cand_last_Name;
		@FindBy (name = "FLD_CAND_PHONE_NUM") private WebElement Cand_Phone_No;
		@FindBy (name = "btnContinue") private WebElement Continue;
		
		
		// Initialize the web elements 
		public Page08A_Candidate_Details(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		
		// Function to fill candidate details
		public void Candidate(){
			
			Cand_First_Name.clear();
			Cand_last_Name.clear();
			Cand_Phone_No.clear();
			
			Cand_First_Name.sendKeys("First Name");
			Cand_last_Name.sendKeys("Last Name");
			Cand_Phone_No.sendKeys("9834528746");
			Continue.click();
		}
		
}
