package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.RetryAnalyzerImplementation;
import pomClasses.CreatingNewLeadsPage;
import pomClasses.HomePage;
import pomClasses.LeadsPage;
@Listeners(genericUtility.ListenersImplementation.class)
public class TC_001  extends BaseClass{
	int i=1;
	@Test(groups= {"Regression","System"}, retryAnalyzer=genericUtility.RetryAnalyzerImplementation.class)
	public void LE_001() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnAddLeads();
//		if(i<=3) {
//			i++;
//			Assert.fail();
//		}
		String fname=eutil.getDataFormatExcel("Leads", 1, 1);
		String lname=eutil.getDataFormatExcel("Leads", 1, 2);
		String company=eutil.getDataFormatExcel("Leads", 1, 3);
		CreatingNewLeadsPage cnlp=new CreatingNewLeadsPage(driver);
		cnlp.CreateNewLead(fname, lname, company);
		System.out.println("LE_001 Executed Successfully");
		
	}

}
