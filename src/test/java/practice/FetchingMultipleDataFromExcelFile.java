package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class FetchingMultipleDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\ambik\\OneDrive\\Desktop\\Excel File\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Birds");
		DataFormatter df=new DataFormatter();
//		Row r=sh.getRow(1);
//		for(int i=0;i<r.getLastCellNum();i++) {
//			Cell c=r.getCell(i);
//			String value =df.formatCellValue(c);
//			System.out.print(value+" ");
//		}

		for(int i=1;i<=sh.getLastRowNum();i++) {
			Row r=sh.getRow(i);
			for(int j=0;j<r.getLastCellNum();j++) {
				Cell c=r.getCell(j);
				String value=df.formatCellValue(c);
				System.out.print(value+" ");
			}
			System.out.println();
		}
		

	}

}
