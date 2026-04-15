package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import pomClasses.ContactsPage;
import pomClasses.CreatingNewContactsPage;
import pomClasses.HomePage;

public class TC_004 extends BaseClass{
	@Test(groups= {"System","Smoke"})
	public void CON_001() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsMenu();
		ContactsPage cp=new ContactsPage(driver);
		cp.newContactsPage();
		String fname=eutil.getDataFormatExcel("Contacts", 1, 1);
		String lname=eutil.getDataFormatExcel("Contacts", 1, 2);
		String title=eutil.getDataFormatExcel("Contacts", 1, 3);
		CreatingNewContactsPage cncp=new CreatingNewContactsPage(driver);
		cncp.createNewContact(fname, lname, title);
		System.out.println("CON_001 Executed Successfully");
	}
}
