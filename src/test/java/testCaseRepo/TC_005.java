package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import pomClasses.ContactsPage;
import pomClasses.CreatingNewContactsPage;
import pomClasses.HomePage;

public class TC_005 extends BaseClass{
	@Test(groups= {"Smoke"})
	public void CON_002() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsMenu();
		ContactsPage cp=new ContactsPage(driver);
		cp.newContactsPage();
		String lname = eutil.getDataFormatExcel("Contacts", 4, 1);
		String dept = eutil.getDataFormatExcel("Contacts", 4, 2);
		String email = eutil.getDataFormatExcel("Contacts", 4, 3);
		String mob = eutil.getDataFormatExcel("Contacts", 4, 4);
		CreatingNewContactsPage cncp=new CreatingNewContactsPage(driver);
		cncp.createNewContact(lname, dept, email, mob);
		System.out.println("CON_002 Executed Successfully");
	}

}
