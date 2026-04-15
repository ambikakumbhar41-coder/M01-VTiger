package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class CreatingNewLeadsPage {
	
	@FindBy(name ="firstname") private WebElement firstNameTextField;
	
	@FindBy(name ="lastname") private WebElement lastNameTextField;

	@FindBy(name ="company") private WebElement companyTextField;

	@FindBy(name ="designation") private WebElement titleTextField;

	@FindBy(name ="leadsource") private WebElement leadSourceDropdown;

	@FindBy(name ="noofemployees") private WebElement noOfEmpTextField;

	@FindBy(name ="mobile") private WebElement mobileTextField;

	@FindBy(name ="email") private WebElement emailTextField;

	@FindBy(name ="city") private WebElement cityTextField;

	@FindBy(name ="state") private WebElement stateTextField;

	@FindBy(name ="country") private WebElement countryTextField;

	@FindBy(xpath ="//input[@title='Save [Alt+S]']") private WebElement saveButton;
	
	
	public  CreatingNewLeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}


	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}


	public WebElement getCompanyTextField() {
		return companyTextField;
	}


	public WebElement getTitleTextField() {
		return titleTextField;
	}


	public WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}


	public WebElement getNoOfEmpTextField() {
		return noOfEmpTextField;
	}


	public WebElement getMobileTextField() {
		return mobileTextField;
	}


	public WebElement getEmailTextField() {
		return emailTextField;
	}


	public WebElement getCityTextField() {
		return cityTextField;
	}


	public WebElement getStateTextField() {
		return stateTextField;
	}


	public WebElement getCountryTextField() {
		return countryTextField;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}


/**
 * This is business library to create a new lead
 * @param fname
 * @param lname
 * @param company
 */

	public void CreateNewLead(String fname,String lname,String company) {
		getFirstNameTextField().sendKeys(fname);
		getLastNameTextField().sendKeys(lname);
		getCompanyTextField().sendKeys(company);
		getSaveButton().click();
		
	}
	
	/**
	 * This is business library to create a new lead
	 * @param lname
	 * @param company
	 * @param title
	 * @param leadSource
	 * @param noOfEmp
	 * @return 
	 */
	public void CreateNewLead(String lname, String company,String title,String leadSource,String noOfEmp) {
		getLastNameTextField().sendKeys(lname);
		getCompanyTextField().sendKeys(company);
		getTitleTextField().sendKeys(title);
		new SeleniumUtility().selectOptionByValue(leadSourceDropdown, leadSource);
		getNoOfEmpTextField().sendKeys(noOfEmp);
		getSaveButton().click();
		
	}
	/**
	 * This is a business library to create a new lead
	 * @param lname
	 * @param company
	 * @param mob
	 * @param email
	 * @param city
	 * @param state
	 * @param country
	 */
	public void CreateNewLead(String lname,String company,String mob,String email,String city,String state,String country) {
		getLastNameTextField().sendKeys(lname);
		getCompanyTextField().sendKeys(company);
		getMobileTextField().sendKeys(mob);
		getEmailTextField().sendKeys(email);
		getCityTextField().sendKeys(city);
		getStateTextField().sendKeys(state);
		getCountryTextField().sendKeys(country);
		getSaveButton().click();
		
	}
	
	
	
	
}
