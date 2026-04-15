package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import pomClasses.HomePage;
import pomClasses.LeadsPage;

public class TC_003 extends BaseClass {
	@Test(groups= {"Regression"})
	public void LE_003() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnAddLeads();
		String lname=eutil.getDataFormatExcel("Leads", 7, 1);
		String company=eutil.getDataFormatExcel("Leads", 7, 2);
		String mob=eutil.getDataFormatExcel("Leads", 7, 3);
		String email=eutil.getDataFormatExcel("Leads", 7, 4);
		String city=eutil.getDataFormatExcel("Leads", 7, 5);
		String status=eutil.getDataFormatExcel("Leads", 7, 6);
		String country=eutil.getDataFormatExcel("Leads", 7, 7);
        System.out.println("LE_003 Executed Successfully");

	}
}
