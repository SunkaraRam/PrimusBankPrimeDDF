package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataPass {
	
	public static Workbook wb;
	
	public DataPass() throws Throwable {
		
		FileInputStream fi = new FileInputStream("./TestInputs/empreg.xlsx");
		
		wb = WorkbookFactory.create(fi);
		
	}
	
	public static int rowCount(String sheet) throws Throwable {
		
		return wb.getSheet(sheet).getLastRowNum();
	
	}
	
	public static int colCount(String sheet,int rownum) {
		
		return wb.getSheet(sheet).getRow(rownum).getLastCellNum();
	}
	
	public static String getData(String sheet, int rownum,int colnum) {
		
		
		
		String data="";
		
		if (wb.getSheet(sheet).getRow(rownum).getCell(colnum).getCellType()==Cell.CELL_TYPE_NUMERIC) {
			
				long value = (long)wb.getSheet(sheet).getRow(rownum).getCell(colnum).getNumericCellValue();
			
				 data = String.valueOf(value);
			
		} else {

			data = wb.getSheet(sheet).getRow(rownum).getCell(colnum).getStringCellValue();
			
			
		}
		return data;
		
	}
	
	public static void setData(String sheetname,int rownum,int colnum, String status) throws Throwable {
		
		Sheet sh = wb.getSheet(sheetname);
		
		Row row = sh.getRow(rownum);
		
		Cell cell = row.createCell(colnum);
		
		cell.setCellValue(status);
		
		if (status.equalsIgnoreCase("Pass")) {
			
			CellStyle style = wb.createCellStyle();
			
			Font font = wb.createFont();
			
			font.setColor(IndexedColors.WHITE.getIndex());
			
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			style.setFont(font);
			
			row.getCell(colnum).setCellStyle(style);
			
			
		}
		
		if (status.equalsIgnoreCase("Fail")) 
		{
			
			CellStyle style = wb.createCellStyle();
			
			Font font = wb.createFont();
			
			font.setColor(IndexedColors.WHITE.getIndex());
			
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			style.setFont(font);
			
			row.getCell(colnum).setCellStyle(style);	
		}
		
		if (status.equalsIgnoreCase("Not Executed")) 
		{
			
			CellStyle style = wb.createCellStyle();
			
			Font font = wb.createFont();
			
			font.setColor(IndexedColors.WHITE.getIndex());
			
			style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
			
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			style.setFont(font);
			
			row.getCell(colnum).setCellStyle(style);
			
			
		}
		
		FileOutputStream fo = new FileOutputStream("./TestOutput/EmpRes.xlsx");
		wb.write(fo);
		
	}
	
	
	public static void main(String[] args) throws Throwable {
		
		DataPass ds = new DataPass();
		
		int rc = ds.rowCount("MasterTestCases");
		
		System.out.println(rc);
		
		String TCModule = ds.getData("MasterTestCases",1, 1);
		
		System.out.println(TCModule);
		
		int ac = ds.rowCount(TCModule);
		
		System.out.println(ac);
		
		for (int i = 1; i < ac; i++) {
			
			String Description = ds.getData(TCModule,i,0);
			
			String objecttype = ds.getData(TCModule,i,1);
			
			String locatortype = ds.getData(TCModule,i,2);
			
			String locatorvalue = ds.getData(TCModule,i,3);
			
			String testdata = ds.getData(TCModule,i,4);
			
			System.out.println(objecttype);
			
		}
		
	}
	
	
}
