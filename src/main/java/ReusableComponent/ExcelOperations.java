package ReusableComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import TestBase.TestBase;

public class ExcelOperations extends TestBase{
	String filePath;
	Sheet sh;
	public ExcelOperations(String excelFile, String sheetName) {	
		FileInputStream fis=null;
	try { 
			filePath = excelFile;
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 	//open file - workbook
			File testDataFile = new File(filePath);
			try {
				 fis=new FileInputStream(testDataFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Workbook wb = null;
			try {
		//factory for creating the appropriate kind of workbook(be HSSFWORKBOOK OR XSSFWORKBOOK), by autodetecting
		// from the supplied input
				wb = WorkbookFactory.create(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			 sh = wb.getSheet(sheetName);
	}
	
	//get test data from  excel sheet in hashmap based on row number
	public HashMap<String, String> getTestDataInMap(int rowNum) throws Exception {
	//read data row by row and put in map
	HashMap<String, String> hm = new HashMap<String, String>();
	for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
	sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
	//System.out.println(sh.getRow(0).getCell(i).toString());
	hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());
	//System.out.println("from excel getting this data");
		//System.out.println(hm);
		}	
		return hm;
	}
	//get row count
	public int getRowCount() {		
		return sh.getLastRowNum();
	}
	//get column count
	public int getColCount() {
	return sh.getRow(0).getLastCellNum();	
	}}
