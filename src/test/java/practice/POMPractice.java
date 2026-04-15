package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.ExcelUtility;
import genericUtility.PropertiesUtility;
import genericUtility.SeleniumUtility;
import pomClasses.ContactsPage;
import pomClasses.CreatingNewContactsPage;
import pomClasses.CreatingNewLeadsPage;
import pomClasses.HomePage;
import pomClasses.LeadsPage;
import pomClasses.LoginPage;

public class POMPractice {
	@FindBy(name="user_name")
	WebElement usernameTF;
	
	public POMPractice(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static void main(String[] args) throws IOException {
		
		SeleniumUtility sutil=new SeleniumUtility();
		PropertiesUtility putil=new PropertiesUtility();
		ExcelUtility eutil=new ExcelUtility();
		
		String URL=putil.getDataFromProperties("url");
		String UN=putil.getDataFromProperties("username");
		String PWD=putil.getDataFromProperties("password");
		WebDriver driver=new ChromeDriver();
		sutil.accessApplication(driver, URL);
		sutil.maximizeWindow(driver);
		sutil.implicitWait(driver, 15);
	//	WebElement usernameTF=driver.findElement(By.name("user_name")).sendKeys(UN);
//	    POMPractice p=new POMPractice(driver);
//	    p.usernameTF.sendKeys(UN);
//	    driver.navigate().refresh();
//	    p.usernameTF.sendKeys(UN);
        LoginPage lp=new LoginPage(driver);
        lp.loginToApplication(UN, PWD);
        HomePage hp=new HomePage(driver);
        hp.clickOnContactsMenu();
        ContactsPage cp=new ContactsPage(driver);
        cp.newContactsPage();
        String fname=eutil.getDataFormatExcel("Contacts", 1, 1);
        String lname=eutil.getDataFormatExcel("Contacts", 1, 2);
        String title=eutil.getDataFormatExcel("Contacts", 1, 3);
        CreatingNewContactsPage cncp=new CreatingNewContactsPage(driver);
        cncp.createNewContact(fname, lname, title);
        hp.getSignoutOption();
        String lname1 =eutil.getDataFormatExcel("Contacts", 4, 1);
        String dept=eutil.getDataFormatExcel("Contacts", 4, 2);
        String email=eutil.getDataFormatExcel("Contacts", 4, 3);
        String mob=eutil.getDataFormatExcel("Contacts", 4, 4);
        CreatingNewContactsPage cncp2=new CreatingNewContactsPage(driver);
        cncp2.createNewContact(lname1, dept, email, mob);	
        hp.getSignoutOption();
//        
//        hp.clickOnLeadsMenu();
//        LeadsPage lp1=new LeadsPage(driver);
//        lp1.clickOnAddLeads();
//        String fname=eutil.getDataFormatExcel("Leads", 1, 1);
//        String lname=eutil.getDataFormatExcel("Leads", 1, 2);
//        String company=eutil.getDataFormatExcel("Leads", 1, 3);
//        CreatingNewLeadsPage cnlp=new CreatingNewLeadsPage(driver);
//        cnlp.CreateNewLead(fname, lname, company);
//        hp.signoutOptions(driver);
        
//        String lname=eutil.getDataFormatExcel("Leads", 4, 1);
//        String company=eutil.getDataFormatExcel("Leads", 4, 2);
//        String title=eutil.getDataFormatExcel("Leads", 4, 3);
//        String leadSource=eutil.getDataFormatExcel("Leads", 4, 4);
//        String noOfEmp=eutil.getDataFormatExcel("Leads", 4, 5);
//        CreatingNewLeadsPage cnlp1=new CreatingNewLeadsPage(driver);
//        cnlp1.CreateNewLead(lname, company, title, leadSource, noOfEmp);
//        hp.getSignoutOption();
//        
//           driver.quit();
        
//        hp.clickOnContactsMenu();
//        ContactsPage cp=new ContactsPage(driver);
//        cp.NewContactsPage();
        
        
        
 //       hp.signoutOptions(driver);
	}

}
