package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import genericUtility.ExcelUtility;

public class WritingDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

//		FileInputStream fis = new FileInputStream("C:\\Users\\ambik\\OneDrive\\Desktop\\Excel File\\TestData.xlsx");
//		Workbook wb=WorkbookFactory.create(fis);
//		Sheet sh=wb.createSheet("Cars");
//		Row r=sh.createRow(1);
//		Cell c = r.createCell(3);
//		c.setCellValue("hyundai");
//		FileOutputStream fos=new FileOutputStream("C:\\Users\\ambik\\OneDrive\\Desktop\\Excel File\\TestData.xlsx");
//		wb.write(fos);
		ExcelUtility eutil=new ExcelUtility();
		eutil.writeDataToExcel("cars", 3, 1, "Thar");

	}

}
