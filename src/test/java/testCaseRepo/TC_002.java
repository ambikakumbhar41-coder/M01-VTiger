package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import pomClasses.CreatingNewLeadsPage;
import pomClasses.HomePage;
import pomClasses.LeadsPage;

public class TC_002 extends BaseClass{
	@Test(groups= {"Smoke"})
	public void LE_002() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnAddLeads();
		String lname=eutil.getDataFormatExcel("Leads", 4, 1);
		String company=eutil.getDataFormatExcel("Leads", 4, 2);
		String title=eutil.getDataFormatExcel("Leads", 4, 3);
		String leadSource=eutil.getDataFormatExcel("Leads", 4, 4);
        String noOfEmp=eutil.getDataFormatExcel("Leads", 4, 5);
        CreatingNewLeadsPage cnlp2=new CreatingNewLeadsPage(driver);
        cnlp2.CreateNewLead(lname, company, title, leadSource, noOfEmp);
        System.out.println("LE_002 Executed Successfully");

	}

}
