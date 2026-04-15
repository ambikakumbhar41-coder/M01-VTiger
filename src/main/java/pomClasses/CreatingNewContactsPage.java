package pomClasses;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This isaPOM class forCreating New Contact Webpage.
 * @author ambik
 * @version26-03-30
 */

public class CreatingNewContactsPage {
	
	@FindBy(name ="firstname") private WebElement firstNameTextField;
	@FindBy(name ="lastname") private WebElement lastNameTextField;
	@FindBy(name ="title") private WebElement titleTextField;
	@FindBy(name ="department") private WebElement departmentTextField;
	@FindBy(name ="email") private WebElement emailTextField;
	@FindBy(name ="mobile") private WebElement mobileTextField;
	@FindBy(name="mailingcity") private WebElement mailingcityTF;
	@FindBy(name="mailingstate") private WebElement mailingstateTF;
	@FindBy(name="mailingcountry") private WebElement mailingcountryTF;
	@FindBy(xpath ="//input[@title='Save [Alt+S]']") private WebElement saveButton;

	public CreatingNewContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}
	public WebElement getTitleTextField() {
		return titleTextField;
	}
	public WebElement getDepartmentTextField() {
		return departmentTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getMobileTextField() {
		return mobileTextField;
	}
	public WebElement getMailingcityTF() {
		return mailingcityTF;
	}

	public WebElement getMailingstateTF() {
		return mailingstateTF;
	}

	public WebElement getMailingcountryTF() {
		return mailingcountryTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This is a business library to create a new contact
	 * @param fname
	 * @param lname
	 * @param title
	 */
	public void createNewContact(String fname,String lname,String title) {
		getFirstNameTextField().sendKeys(fname);
		getLastNameTextField().sendKeys(lname);
		getTitleTextField().sendKeys(title);
		getSaveButton().click();
	}
	/**
	 * This is a business library to create a new contact
	 * @param lname
	 * @param dept
	 * @param email
	 * @param mob
	 */
	
	public void createNewContact(String lname,String dept,String email,String mob) {
		getLastNameTextField().sendKeys(lname);
		getDepartmentTextField().sendKeys(dept);
		getEmailTextField().sendKeys(email);
		getMobileTextField().sendKeys(mob);
		getSaveButton().click();
	}
	/**
	 * This is a business library to create a new contact
	 * @param lname
	 * @param title
	 * @param email
	 * @param Mcity
	 * @param Mstate
	 * @param Mcountry
	 */
	public void createNewContact(String lname,String title,String email,String mCity,String mState,String mCountry) {
		getLastNameTextField().sendKeys(lname);
		getTitleTextField().sendKeys(title);
		getEmailTextField().sendKeys(email);
		getMailingcityTF().sendKeys(mCity);
		getMailingstateTF().sendKeys(mState);
		getMailingcountryTF().sendKeys(mCountry);
		getSaveButton().click();
		
	}
}
