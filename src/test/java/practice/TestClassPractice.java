package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import pomClasses.CreatingNewLeadsPage;
import pomClasses.HomePage;
import pomClasses.LeadsPage;

public class TestClassPractice extends BaseClass {
	
	@Test
	public void TC_001() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnAddLeads();
		CreatingNewLeadsPage cnlp=new CreatingNewLeadsPage(driver);
		String fname=eutil.getDataFormatExcel("Leads", 1, 1);
		String lname=eutil.getDataFormatExcel("Leads", 1, 2);
		String company=eutil.getDataFormatExcel("Leads", 1, 3);
		cnlp.CreateNewLead(fname, lname, company);
		System.out.println("TC_001 Executated Successfully");
	}

}
