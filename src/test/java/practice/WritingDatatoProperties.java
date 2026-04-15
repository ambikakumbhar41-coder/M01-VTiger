package practice;

import java.io.IOException;

import genericUtility.PropertiesUtility;

public class WritingDatatoProperties {
	public static void main(String[] args) throws IOException {
//		FileInputStream fis=new FileInputStream("C:\\Users\\ambik\\OneDrive\\Desktop\\Selenium Section 3\\TestData.properties");
//		Properties prop=new Properties();
//		prop.load(fis);
//		prop.setProperty("mobile", "8197680941");
//		FileOutputStream fos=new FileOutputStream("C:\\Users\\ambik\\OneDrive\\Desktop\\Selenium Section 3\\TestData.properties");
//		prop.store(fos, "mobile number updated");
	    PropertiesUtility putil=new PropertiesUtility();
	    putil.writeDataToProperties("name", "robin", "name is updated");
		
		
	}

}
