package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This is POM class for login WebPage
 * @author ambik
 * @version 26-03-27
 */

public class LoginPage {
	
	
	//Declaring WebElement
	
	@FindBy(name="user_name") 
	private WebElement usernameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
     
	//public getter

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}


	public WebElement getPasswordTextField() {
		return passwordTextField;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//Utilize the WebElement 
	/**
	 * This is business library to logon to the Application
	 * @param UN
	 * @param PWD
	 */
	public void loginToApplication(String UN,String PWD) {
		getUsernameTextField().sendKeys(UN);
		getPasswordTextField().sendKeys(PWD);
		getLoginButton().click();
	}

}
