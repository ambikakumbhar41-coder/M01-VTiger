package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.PropertiesUtility;

public class FetchingdataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
		
		
//		FileInputStream fis=new FileInputStream("C:\\Users\\ambik\\OneDrive\\Desktop\\Selenium Section 3\\TestData.properties");
//		Properties prop=new Properties();
//		prop.load(fis);
//		String URL=prop.getProperty("url");
//		String UN=prop.getProperty("username");
//		String PWD=prop.getProperty("password");
		PropertiesUtility putil= new PropertiesUtility();
		String URL=putil.getDataFromProperties("url");
		String UN=putil.getDataFromProperties("username");
		String PWD=putil.getDataFromProperties("password");
		System.out.println(UN);
		System.out.println(URL);
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(UN,Keys.TAB,PWD,Keys.ENTER);
		
	}

}
