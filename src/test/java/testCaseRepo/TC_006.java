package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import pomClasses.ContactsPage;
import pomClasses.CreatingNewContactsPage;
import pomClasses.HomePage;

public class TC_006 extends BaseClass{
	@Test(groups= {"System"})
	public void CON_003() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsMenu();
		ContactsPage cp=new ContactsPage(driver);
		cp.newContactsPage();
		String lname=eutil.getDataFormatExcel("Contacts", 7, 1);
		String title=eutil.getDataFormatExcel("Contacts", 7, 2);
		String email=eutil.getDataFormatExcel("Contacts", 7, 3);
		String mCity=eutil.getDataFormatExcel("Contacts", 7, 4);
		String mState=eutil.getDataFormatExcel("Contacts", 7, 5);
		String mCountry=eutil.getDataFormatExcel("Contacts", 7, 6);
		CreatingNewContactsPage cncp=new CreatingNewContactsPage(driver);
		cncp.createNewContact(lname, title, email, mCity, mState, mCountry);
		System.out.println("CON_003 Executed Successfully");
	}
}
