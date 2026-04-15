package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pomClasses.HomePage;
import pomClasses.LoginPage;

public class BaseClass {
	public static WebDriver sDriver;
	public WebDriver driver;
	public PropertiesUtility putil=new PropertiesUtility();
	public SeleniumUtility sutil=new SeleniumUtility();
	public ExcelUtility eutil=new ExcelUtility();
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("Creating database connection");
	}
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void bdConfig(@Optional("chrome") String BROWSER) throws IOException {
		if(BROWSER.equals("chrome")) 
			driver=new ChromeDriver();
		else if(BROWSER.equals("edge")) 
			driver=new EdgeDriver();
		else if(BROWSER.equals("firefox")) 
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		sDriver=driver;
		String URL=putil.getDataFromProperties("url");
		sutil.accessApplication(driver, URL);
		sutil.maximizeWindow(driver);
		sutil.implicitWait(driver, 15);
		System.out.println("Application Launched Successfully");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		String URL=putil.getDataFromProperties("username");
		String PWD=putil.getDataFromProperties("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(URL, PWD);
	System.out.println("Login done Successfully");
	}
	@AfterMethod(alwaysRun = true)
	public void amConfig() {
		HomePage hp=new HomePage(driver);
		hp.signoutOptions(driver);
	     System.out.println("Logout Opration Successfully");
		
	}
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();
		System.out.println("Browser closed successfully");
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("Closing DB connection");
		
	}

}

