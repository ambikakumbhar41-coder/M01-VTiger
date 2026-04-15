package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This is an utility class which deals with Excel file.
 * @author ambik
 * @version 26-03-23
 */

public class ExcelUtility {
	/**
	 * This is a generic method to fetch single cell data from Excel file
	 * @param sheetname
	 * @param rowIndex
	 * @param cellIndex
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFormatExcel(String sheetname,int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Cell c=wb.getSheet(sheetname).getRow(rowIndex).getCell(cellIndex); 
		DataFormatter df= new DataFormatter();
		String value=df.formatCellValue(c);
		return value;
	}
	
	
	public List<String> getMultipleDatafromExcel(String sheetName,int startRowIndex,int startCellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		DataFormatter df=new DataFormatter();
		List<String> a1=new ArrayList<String>();
		for(int i=startRowIndex;i<=sh.getLastRowNum();i++) {
			Row r=sh.getRow(i);
			for(int j=startCellIndex;j<r.getLastCellNum();j++) {
				Cell c=r.getCell(j);
				String value=df.formatCellValue(c);
				a1.add(value);
			}
		}
		return a1;
	}
	/**
	 * This is generic method to write data to excel file.
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void writeDataToExcel(String sheetName,int rowIndex,int cellIndex,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row r=sh.createRow(rowIndex);
		Cell c = r.createCell(cellIndex);
		c.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IPathUtility.excelPath);
		wb.write(fos);

	}

}

