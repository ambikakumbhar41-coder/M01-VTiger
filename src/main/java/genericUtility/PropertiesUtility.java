package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This is an utility class which deals with Properties file
 * @author ambik
 * @version 2026-03-20
 */

public class PropertiesUtility {
	/**
	 * This is a generic method to fetch data from Properties file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IPathUtility.propertiespath);
		Properties prop=new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
	}
	/**
	 * This is a generic method to write the data to Properties file
	 * @param key
	 * @param value
	 * @param comment
	 * @throws IOException
	 */
	public void writeDataToProperties(String key,String value,String comment) throws IOException {
		
		FileInputStream fis=new FileInputStream(IPathUtility.propertiespath);
		Properties prop=new Properties();
		prop.load(fis);
		prop.setProperty(key,value);
		FileOutputStream fos=new FileOutputStream(IPathUtility.propertiespath);
		prop.store(fos, comment);
	}

}
