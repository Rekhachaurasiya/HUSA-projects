package main.java.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporter {
       public static ExtentTest test;
       public static ExtentReports extent;
       public String testCaseName, testDescription, category, authors;
       public static RemoteWebDriver driver;
       public static long num1;
       public static long resultpath;
       
       
       static String Testcasenumber="";
       
       public long date(){
              SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");  
              Date date = new Date();  
              String date1=   formatter.format(date);  
              String sanptrim=date1.replace("/", "");
              String santrim1= sanptrim.replace(":", "");
              String santrim2= santrim1.replaceAll("\\s", "");
              num1 = Long.parseLong(santrim2);
              return num1;
       }
       
       public static void  testcasenumber(String testcasenumber){
              
              Testcasenumber=testcasenumber;
              
       }

       public static void reportStep(String desc, String status, boolean bSnap)  {

              if(bSnap && !status.equalsIgnoreCase("INFO")){
            	  if(status.equalsIgnoreCase("FAIL")){
                     long num = 100000l;        
                     try {
                           num= takeSnap2(); 
                     } catch (Exception e) {
                           e.printStackTrace();
                     }
                     //desc = desc+test.addScreenCapture("./reports/images/"+num+".jpg");
                     desc = desc+test.addScreenCapture("./images/"+num+".jpg");
                     
            	  }

              }

              // Write if it is successful or failure or information
              if(status.equalsIgnoreCase("PASS")){
                     test.log(LogStatus.PASS, desc);
                     try {
                           Putdata.writedata(Testcasenumber, "Status", "PASS");
                     } catch (IOException e) {
                           
                           e.printStackTrace();
                     }
              }else if(status.equalsIgnoreCase("FAIL")){
                     test.log(LogStatus.FAIL, desc);
                     try {
                           Putdata.writedata(Testcasenumber, "Status", "FAIL");
                     } catch (IOException e) {
                           
                           e.printStackTrace();
                     }
               throw new RuntimeException("FAILED");
              }else if(status.equalsIgnoreCase("WARN")){
                     test.log(LogStatus.WARNING, desc);
              }else if(status.equalsIgnoreCase("INFO")){
                     test.log(LogStatus.INFO, desc);
              }

       }

       public static void reportStep(String desc, String status) {

              reportStep(desc, status, true); 



       }

       public abstract long takeSnap();

       public ExtentReports startResult(){

              extent = new ExtentReports("./Result/Regression/"+num1+"/report.html", false);
              //extent = new ExtentReports("./reports/report.html", false);
              extent.loadConfig(new File("./repository/extent-config.xml"));
              return extent;
       }

       public ExtentTest startTestCase(String testCaseName, String testDescription){
              test = extent.startTest(testCaseName, testDescription);
              return test;
       }

       public void endResult(){         
              extent.flush();
       }

       public void endTestcase(){
              if(test!=null){                   
                           
                     
                     extent.endTest(test);
                     //System.out.println("dajid");
              }
       }

       public static long takeSnap2(){
              long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
              try {

                     FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./Result/Regression/"+num1+"/images/"+number+".jpg"));
              } catch (WebDriverException e) {
                     reportStep("The browser has been closed.", "FAIL");
              } catch (IOException e) {
                     reportStep("The snapshot could not be taken", "WARN");
              }
              return number;
       }

       public static String resultpath(){
              String resultpath="./Result/Regression/"+num1+"/report.html";
              return resultpath;

       }



}
