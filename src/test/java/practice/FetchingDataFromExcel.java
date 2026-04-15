package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtility.ExcelUtility;



public class FetchingDataFromExcel {
	public static void main(String[] args) throws  IOException {
		

//	FileInputStream fis = new FileInputStream("C:\\Users\\ambik\\OneDrive\\Desktop\\Excel File\\TestData.xlsx");
//	Workbook wb=WorkbookFactory.create(fis);
//	Sheet sh=wb.getSheet("Actors");
//	Row r=sh.getRow(1);
//	Cell c = r.getCell(3);
//	String value=c.getStringCellValue();
//	System.out.println(value);
//	Cell  c2=wb.getSheet("Cartoon").getRow(4).getCell(3);
//	String value2=c2.getStringCellValue();
//	System.out.println(value2);
	
//	Cell c=wb.getSheet("Actors").getRow(6).getCell(2); 
//	DataFormatter df= new DataFormatter();
//	String value=df.formatCellValue(c);
//	System.out.println(value);
	ExcelUtility eutil= new ExcelUtility();
 	String value1=eutil.getDataFormatExcel("Actors", 4, 4);
	String value2=eutil.getDataFormatExcel("Cartoon", 1, 3);
	System.out.println(value1);
 	System.out.println(value2);
	
	}
	
}
