package main.java.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFExtendedColor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;



public class Putdata extends Projectcommonmethodes{

	public static void writedata(String rowvalue,String columnvalue,String Status) throws IOException
	{
		try {
		String Runmangerpath=prop.getProperty("Runmangername");
		String Workspace = prop.getProperty("Workspace");
		FileInputStream fis = new FileInputStream(new File("./"+Runmangerpath+".xls"));
		HSSFWorkbook workbook = new  HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheet("Desktop_HUSA_Execution_Result");
		HSSFRow row = sheet.getRow(0);

		int col_num = -1;

		for(int i=0; i < row.getLastCellNum(); i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals(columnvalue))
				col_num = i;
		}
		Sheet Sheet1=workbook.getSheet("Desktop_HUSA_Execution_Result");
		String rowValue = rowvalue;
		Integer i = null;
		for( i=1;i<=Sheet1.getLastRowNum();i++)
		{
			if (rowValue.equals(Sheet1.getRow(i).getCell(0).getStringCellValue()))
			{
				System.out.println(i);
				break;
			}
		}

		row = sheet.getRow(i);
		if(row==null||col_num==-1)
		{
			//reportStep("Row or Column not present for the test case", "FAIL");
		}

		if(Status.contains("PASS")) {
			row.getCell(col_num).setCellValue(Status);
			//HSSFCellStyle style = workbook.createCellStyle();

			CellStyle style = workbook.createCellStyle();
			style.cloneStyleFrom(row.getCell(col_num).getCellStyle());
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			row.getCell(col_num).setCellStyle(style);
			
		}
		else if (Status.contains("FAIL")) {
			row.getCell(col_num).setCellValue(Status);


			CellStyle style = workbook.createCellStyle();
			style.cloneStyleFrom(row.getCell(col_num).getCellStyle());
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			row.getCell(col_num).setCellStyle(style);
		}
		 else
	       {
	    	   row.getCell(col_num).setCellValue(Status);
	       }
		//System.out.println("Value of the Excel Cell is - "+ value);
		FileOutputStream fout=new FileOutputStream(new File("./"+Runmangerpath+".xls"));
		workbook.write(fout);
		}
		catch (NullPointerException NPE)
		{
				
		}

	}
}
