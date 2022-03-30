package main.java.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;



public class ReadExcelData extends Projectcommonmethodes {


	public static String getdata(String rowvalue,String columnvalue) throws IOException
	{
		String Datasheetname=	prop.getProperty("Datasheetname");
		FileInputStream fis = new FileInputStream("./testData/"+Datasheetname+".xls");
		HSSFWorkbook workbook = new  HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheet("General_Data");
		HSSFRow row = sheet.getRow(0);

		int col_num = -1;

		for(int i=0; i < row.getLastCellNum(); i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals(columnvalue))
				col_num = i;
		}
		Sheet Sheet1=workbook.getSheet("General_Data");
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
			reportStep("Row or Column not present for the test case", "FAIL");
		}
		HSSFCell cell = row.getCell(col_num);

		String value = cell.getStringCellValue();
		//System.out.println("Value of the Excel Cell is - "+ value);
		if(value=="")
		{
			reportStep("Value is not present in the "+Datasheetname, "INFO");
		}
		return value;
	}

}


