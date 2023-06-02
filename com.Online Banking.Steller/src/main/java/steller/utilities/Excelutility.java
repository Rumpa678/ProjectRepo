package steller.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author RUPA
 *
 */
public class Excelutility {
	/**
	 * this method is used to insert data into excel sheet
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @param Data
	 * @throws Exception
	 */
	public void insertDataIntoExcel(String SheetName,int rowNum,int cellNum,String data) throws Exception{
		FileInputStream fis= new FileInputStream(Ipathconstants.excelPath);
		Workbook book=WorkbookFactory.create(fis);
	Sheet sheet=book.getSheet(SheetName);
	Row row=sheet.createRow(rowNum);
	Cell cell=row.createCell(cellNum);
	cell.setCellValue(data);
	FileOutputStream fos=new FileOutputStream(Ipathconstants.excelPath);
	book.write(fos);
	book.close();	

	}
	/**
	 * this method is used to fetch from excel data
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Exception
	 */
public String getExcelData(String SheetName,int rowNum,int cellNum)throws Exception{
	FileInputStream fis=new FileInputStream(Ipathconstants.excelPath);
	Workbook book=WorkbookFactory.create(fis);
	Sheet sheet=book.getSheet(SheetName);
	Row row=sheet.getRow(rowNum);
	Cell cell=row.getCell(cellNum);
	DataFormatter dataformat=new DataFormatter();
	String data=dataformat.formatCellValue(cell);
	return data;
}
/**
 * this method is used to get count of rows created in excel sheet
 * @param SheetName
 * @return
 * @throws Exception
 */

public int getRowNumber(String SheetName) throws Exception{
	FileInputStream fis=new FileInputStream(Ipathconstants.excelPath);
	Workbook book=WorkbookFactory.create(fis);
	Sheet sheet=book.getSheet(SheetName);
	int row=sheet.getLastRowNum();
	return row;
}

public HashMap<String, String> getMultipledata(String sheetname) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(Ipathconstants.excelPath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sheet=wb.getSheet(sheetname);
	int count=sheet.getLastRowNum();
	HashMap<String, String>map=new HashMap<String, String>();
	for(int i=0;i<=count;i++) {
		String key=sheet.getRow(i).getCell(0).getStringCellValue();
		String value=sheet.getRow(i).getCell(1).getStringCellValue();
		map.put(key, value);
	}
	
	return map;
}
}



