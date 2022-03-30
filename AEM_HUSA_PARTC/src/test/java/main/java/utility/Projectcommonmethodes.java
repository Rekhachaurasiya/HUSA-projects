package main.java.utility;


import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import main.java.commonComponents.Commoncomponents;
import okhttp3.internal.cache.DiskLruCache.Snapshot;


public class Projectcommonmethodes extends Commoncomponents {

	public static String Testcasenumber;
	long startTime;
	public String browser;
	public String dataSheetName;
	long totalstarttime;

	@BeforeSuite
	public void beforeSuite() throws IOException{
		load();
		date();
		startResult();
		UpdateFinalResult.filecopy();
	}

	@BeforeTest 
	public void beforeTest(){
		emaiid();
	
		commonproperties();
		totalstarttime = System.currentTimeMillis(); 
	

	}
	int j=0;

	@BeforeMethod
	public void beforeMethod() throws IOException{
		Object[][] data = getData();
		int i=j;
		String testcaserequired=(String) data[i][2];
		if(testcaserequired.contains("YES")){
			String testCaseName=(String) data[i][0];
			String testDescription=(String) data[i][1];
			String category = "Regression";
			 String Testtypebrowser= Commoncomponents.getdata("BrowserType", "Browser");
			String authors= Testtypebrowser;
			test = startTestCase(testCaseName, testDescription);
			test.assignCategory(category);
			test.assignAuthor(authors);
            invokebrower();
				
				}
		j=i+1;

	}


	@AfterSuite
	public void afterSuite() throws Exception {
		
		endResult();
	//	UpdateFinalResult.updateresult();
		UpdateFinalResult.result();
		Html_Creation.main(null);
		//Html.main(null);
		
		main.java.utility.Snapshot.resultsnap();
		//Convert_Image.main(null);
			Sendemail.send();
	}
	@AfterTest
	public void afterTest() throws IOException{
		unloadObjects();
		long duration = System.currentTimeMillis() - totalstarttime;
		long minutes = (duration / 1000)  / 60;
		int seconds = (int)((duration / 1000) % 60);		
		String executiontime= minutes+" minute(s), "+seconds+" second(s)";		
		UpdateFinalResult.writedata("TestConfigurations","BrowserType", "Total Execution Time", executiontime); 
		
	}

	@AfterMethod
	public void afterMethod() throws IOException{
		endResult();
		endTestcase();
		closeAllBrowsers();	
		long duration = System.currentTimeMillis() - startTime;
		long minutes = (duration / 1000)  / 60;
		int seconds = (int)((duration / 1000) % 60);		
		String executiontime= minutes+" minute(s), "+seconds+" second(s)";		
		Putdata.writedata(Testcasenumber, "Execution Time", executiontime);
	
	}

	@DataProvider(name="fetchData")
	public Object[][] getData(){
		return DataInputProvider.getAllSheetData("Desktop_HUSA_Execution_Result");	
	}	

	
	
	private void invokebrower() {
		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);
			if(browser.equalsIgnoreCase("chrome")){
				System.out.println(browser);
				System. setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
				driver=new ChromeDriver();
				
			}else if(browser.equalsIgnoreCase("Ie")){
				
			 System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
			 driver = new InternetExplorerDriver(); 
			}
			else{
				System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
				driver = new FirefoxDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 startTime = System.currentTimeMillis();
			driver.get(prop.getProperty("url"));		
			reportStep("The browser :" +browser+ " launched successfully" , "PASS");
			System.out.println("launched successfully");
			zipValueEnter();
//			husaLivePopupClose();
//			sleepTime(10);
//			liveChatPopUp();
			sleepTime(10);
			closeNotificationPopup();
		} catch (Exception e) {			
			//reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
		
	}
	
	 public static void  testcasenumber(String testcasenumber){
         
         Testcasenumber=testcasenumber;
         
  }
}






