package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

/**
 * This is POM class for login WebPage
 * @author ambik
 * @version 26-03-27
 */


public class HomePage {
	@FindBy(xpath="//td[@class='tabUnSelected']/a[text()='Leads']")
	private WebElement leadsMenu;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactsMenu;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement accountsIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutOption;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
 
	//public getter
	
	public WebElement getLeadsMenu() {
		return leadsMenu;
	}
	public WebElement getContactsMenu() {
		return contactsMenu;
	}
	public WebElement getAccountsIcon() {
		return accountsIcon;
	}
	public WebElement getSignoutOption() {
		return signoutOption;
	}
	
	
	//Utilize the WebElement 
	/**
	 * This is business library to home to the Application
	 */
	
	public void clickOnLeadsMenu() {
		getLeadsMenu().click();
		
	}
	public void clickOnContactsMenu() {
		getContactsMenu().click();
	}
	
	
	public void signoutOptions(WebDriver driver) {
		SeleniumUtility sutil=new SeleniumUtility();
		sutil.mouseHovering(driver, accountsIcon);
		getSignoutOption().click();
		
	}

}
