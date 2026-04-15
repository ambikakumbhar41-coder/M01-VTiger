package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is aPOM class for Leads web page
 * @author ambik
 * @version 26-03-27
 */

public class LeadsPage {
	
	
	@FindBy(xpath="//img[@title='Create Lead...']") private WebElement addLeads;//createNewLeadIcon
	
    
    public LeadsPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    //public getter


	public WebElement getAddLeads() {
		return addLeads;
	}
/**
 * This is a business library to click on create new lead icon
 */
	//Utilize the WebElement 
	public void clickOnAddLeads() {
		getAddLeads().click();
	}
    
}
