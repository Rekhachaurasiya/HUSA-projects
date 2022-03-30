package main.java.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFExtendedColor;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.WebElement;

public class UpdateFinalResult extends Projectcommonmethodes {
       
	public static void writedata(String Sheetname,String rowvalue,String columnvalue,String Status) throws IOException
    {

              String Runmangerpath=prop.getProperty("Runmangername");
              String Workspace = prop.getProperty("Workspace");
              FileInputStream fis = new FileInputStream(new File("./"+Runmangerpath+".xls"));
       HSSFWorkbook workbook = new  HSSFWorkbook(fis);
       HSSFSheet sheet = workbook.getSheet(Sheetname);
       HSSFRow row = sheet.getRow(0);

       int col_num = -1;

       for(int i=0; i < row.getLastCellNum(); i++)
       {
              if(row.getCell(i).getStringCellValue().trim().equals(columnvalue))
                     col_num = i;
       }
       Sheet Sheet1=workbook.getSheet(Sheetname);
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
       
       if(Status.equalsIgnoreCase("PASS")) {
    	   String posStatus=Status.toUpperCase();
row.getCell(col_num).setCellValue(posStatus);
//HSSFCellStyle style = workbook.createCellStyle();

CellStyle style = workbook.createCellStyle();
style.cloneStyleFrom(row.getCell(col_num).getCellStyle());
style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
row.getCell(col_num).setCellStyle(style);
       }
       else if (Status.equalsIgnoreCase("FAIL")||Status.equalsIgnoreCase("UNKNOWN")) {
    	   String negStatus=Status.toUpperCase();
    	   row.getCell(col_num).setCellValue(negStatus);
    	   
if(Status.equalsIgnoreCase("UNKNOWN")){
    		   
    		   Status="FAIL";
          row.getCell(col_num).setCellValue(Status);
    	   }
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
       
       

       public static void result() throws IOException
       {

          String Runmangerpath=prop.getProperty("Runmangername");
           String Workspace = prop.getProperty("Workspace");
           FileInputStream fis = new FileInputStream(new File("./"+Runmangerpath+".xls"));
       HSSFWorkbook workbook = new  HSSFWorkbook(fis);
       HSSFSheet sheet = workbook.getSheet("Desktop_HUSA_Execution_Result");
       HSSFRow row = sheet.getRow(0);
       String columnvalue="Status";
              String rowvalue="YES";
              int col_num = -1;

              for(int i=0; i < row.getLastCellNum(); i++)
              {
                     if(row.getCell(i).getStringCellValue().trim().equals(columnvalue))
                           col_num = i;
              }
              
              String rowValue = rowvalue;
              Integer Z = 0;
              for( int k=1;k<=sheet.getLastRowNum();k++)
              {
                     try{
                     System.out.println(sheet.getRow(k).getCell(2).getStringCellValue());
                     if (sheet.getRow(k).getCell(2).getStringCellValue()!=null)
                     {
                     
                           Z=Z+1;
                           
                     }}
                     catch(NullPointerException NPE)
                         {
                             
                         }
              }
       //     System.out.println(Z);
              
              ArrayList<String> str = new ArrayList<String>(); 
              
              for(int i=1;i<=Z;i++) {
              HSSFCell cell = sheet.getRow(i).getCell(col_num);
              str.add(cell.getStringCellValue());
                             
              }
              //System.out.println(str);
              Integer Totalcount=str.size();
              Integer passcount= 0;
              Integer failcount= 0;
              
              for( int i=0;i<=Totalcount-1;i++)
              {
                     if(str.get(i).equalsIgnoreCase("PASS"))
                     passcount=passcount+1;
                     
              }
              for( int i=0;i<=Totalcount-1;i++)
              {
                     if(str.get(i).equalsIgnoreCase("FAIL"))
                     failcount=failcount+1;
                     
              }
              String TotalExecutioncount=Totalcount.toString();
              String TotalPasscount=passcount.toString();
              String Totalfailcount=failcount.toString();
              	writedata("Total Execution Summary","Executed", "Total Number of Test Case", TotalExecutioncount);
    			writedata("Total Execution Summary","Pass", "Total Number of Test Case", TotalPasscount);
    			writedata("Total Execution Summary","Fail", "Total Number of Test Case", Totalfailcount); 
              
       }
       
       public static void filecopy() throws IOException
       {
    	String Runmangerpath=prop.getProperty("Runmangername");
       File source = new File("./runmanger.xls");
       File dest = new File("./"+Runmangerpath+".xls");

       try {
          FileUtils.copyFile(source, dest);
       } catch (IOException e) {
          e.printStackTrace();
       }

       }

       public static void updateresult() throws IOException
       {
       String Workspace = prop.getProperty("Workspace");
       //System. setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
       /*ChromeOptions chromeOptions = new ChromeOptions();
              chromeOptions.addArguments("--headless");
              ChromeDriver driver = new ChromeDriver(chromeOptions);*/
//       DesiredCapabilities dc = new DesiredCapabilities();
//       dc.setBrowserName("Chrome");
//       WebDriver driver=new ChromeDriver();
       String url= Workspace+Reporter.resultpath();
       driver.get(url);
       driver.manage().window().maximize();
       sleepTime(10);

       List<WebElement> passEle = driver.findElements(By.xpath("//span[@class='test-name']"));

       System.out.println(passEle.size());

       for(int j=1;j<=passEle.size();j++) {         
       WebElement passEach = driver.findElement(By.xpath("(//span[@class='test-name'])["+j+"]//following::span"));     
       WebElement testCaseEach = driver.findElement(By.xpath("(//span[@class='test-name'])["+j+"]"));
       String testcasestatus = passEach.getText();
       String Testcasenumber = testCaseEach.getText();
       writedata("Desktop_HUSA_Execution_Result",Testcasenumber,"Status",testcasestatus);
       }

       driver.close();  

       }


}
