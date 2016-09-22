package Generic_library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {
	FileInputStream fis;
	XSSFWorkbook wb;
	public void WorkbookInitialize(String xpath) throws IOException{		
		
//		FILEINputStream
		fis = new FileInputStream(xpath);
//		Workbook
		wb = new XSSFWorkbook(fis);
				
	}
	
	public XSSFSheet setSheet(String sName){
		
		XSSFSheet sheet = wb.getSheet(sName);
		return sheet;
		
	}
	
	public int rowCount(XSSFSheet tsheet){
		int lastRowNum = tsheet.getLastRowNum();
		return lastRowNum;
	}
	
	public int columnCount(XSSFSheet tsheet){
		int lastCellNum = tsheet.getRow(0).getLastCellNum();
		return lastCellNum;
		
	}
	
	public String readCell(XSSFSheet tsheet,int row , int column){
		XSSFCell cell = tsheet.getRow(row).getCell(column);
		String celltext = "";
		
		if(cell.getCellType()==Cell.CELL_TYPE_STRING){
//			System.out.println("string");
			celltext = cell.getStringCellValue();
			
		}else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
//			System.out.println("number");
			celltext = String.valueOf(cell.getNumericCellValue());
		}else if(cell.getCellType()==Cell.CELL_TYPE_BLANK){
			celltext = "";
		}
			
		return celltext;
				
	}
	
	public String readCell(XSSFSheet tsheet,int row , String columnName){
		int colindex = 0;
		//		iterate through columns
		for(int cindex = 0 ;cindex <=columnCount(tsheet) ; cindex++ ){
			
			if(tsheet.getRow(0).getCell(cindex).getStringCellValue().equalsIgnoreCase(columnName)){
				
				colindex=cindex;
				break;
			}	
			
		}
		
		return readCell(tsheet,row , colindex);
			
	}	
	
	
	public void writeCell(XSSFSheet tsheet,int row , int column,String writeVal){
		XSSFCell cellwrite = tsheet.getRow(row).getCell(column);
		cellwrite.setCellValue(writeVal);
	}
	
	public void saveFile(String xPath) throws IOException{
		fis.close();
		
//		Save the file
		FileOutputStream fos = new FileOutputStream(xPath);
		wb.write(fos);
		fos.close();
	}	

}
