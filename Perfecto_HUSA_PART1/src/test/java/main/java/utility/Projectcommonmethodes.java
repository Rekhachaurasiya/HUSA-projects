package main.java.utility;



import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResult;
import com.perfecto.reportium.test.result.TestResultFactory;
import com.perfecto.sampleproject.PerfectoLabUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.commonComponents.Commoncomponents;

public class Projectcommonmethodes extends Commoncomponents{
	public static String Testcasenumber;
	long startTime;
	public String browser;
	public String dataSheetName;
	long totalstarttime;
	
	public static ReportiumClient reportiumClient;
	
	@BeforeSuite
	public void beforeSuite() throws IOException{
		
		load();
		date();                                                                                               
		startResult();
		UpdateFinalResult.filecopy();
		
	}
	
	@BeforeTest
	public void beforeTest()
	{
		emaiid();
		commonproperties();
		totalstarttime= System.currentTimeMillis();
		
		}
	int j=0;
	
	@BeforeMethod
	public void beforeMethod() throws Exception
	{
		Object[][] data=getData();
		int i=j;
		String testcaserequired=(String) data[i][2];
		if(testcaserequired.contains("YES"))
		{
			String testCaseName= (String) data[i][0];
			String testDescription= (String) data[i][1];
			String category="Regression";
			String Testtypebrowser=Commoncomponents.getdata("BrowserType","Browser");
			String authors= Testtypebrowser;
			test=startTestCase(testCaseName,testDescription);
			test.assignCategory(category);
			test.assignAuthor(authors);
			invokebrowser();
			
		}
		j=i+1;
		
	}
	
	@AfterSuite
	public void afterSuite() throws Exception
	{
		endResult();
		UpdateFinalResult.updateresult();
		UpdateFinalResult.result();
		Html_Creation.main(null);
		main.java.utility.Snapshot.resultsnap();
		Sendemail.send();
		//Html.main(null);
		
		//main.java.utility.Snapshot.resultsnap();
		//Convert_Image.main(null);
		
		}
	
	@AfterTest
	public void afterTest() throws IOException
	{
		unloadObjects();
		long duration=System.currentTimeMillis() - totalstarttime;
		long minutes=(duration/1000)/60;
		int seconds= (int) ((duration/1000)%60);
		String executiontime=minutes + "minute(s), "+seconds+" second(s)";
		UpdateFinalResult.writedata("TestConfigurations", "BrowserType" ,"Total Execution Time", executiontime);
		
	}
	
	@AfterMethod
	public void afterMethod() throws IOException
	{
		endResult();
		endTestcase();
		closeAllBrowsers();
		long duration=System.currentTimeMillis() - startTime;
		long minutes=(duration/1000)/60;
		int seconds= (int) ((duration/1000)%60);
		String executiontime=minutes + "minute(s), "+seconds+" second(s)";
		Putdata.writedata(Testcasenumber,"Execution Time", executiontime);

	}
	@DataProvider(name="fetchData")
	public Object[][] getData()
	{
		return DataInputProvider.getAllSheetData("Desktop_HUSA_Execution_Result");
	}
	
	
	public void invokebrowser() throws Exception 
	{	
		try {
        String targetEnvironment="iPhone13ProMax";
		RemoteWebDriver driver;
		String cloudName = "hyundai";
//		String browserName = "mobileOS";
		String browserName = "safari";
		String securityToken = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIzYjJiMTFmMi03ZTExLTQxZGYtYTBjZS03N2UxMzYxMThjNWYifQ.eyJpYXQiOjE2NDE4NDAwMzcsImp0aSI6IjkxOGExOWIyLWIyOGEtNDc4ZC04MGM1LTEwY2E4N2ZkN2IzMiIsImlzcyI6Imh0dHBzOi8vYXV0aDUucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2h5dW5kYWktcGVyZmVjdG9tb2JpbGUtY29tIiwiYXVkIjoiaHR0cHM6Ly9hdXRoNS5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvaHl1bmRhaS1wZXJmZWN0b21vYmlsZS1jb20iLCJzdWIiOiIwODJiMWYzNi0wNDI4LTRkOTMtOGMxNC04MmNiN2JhNzQ3MGEiLCJ0eXAiOiJPZmZsaW5lIiwiYXpwIjoib2ZmbGluZS10b2tlbi1nZW5lcmF0b3IiLCJub25jZSI6IjZlOGM0YmJkLWNjNDgtNDlhNy04ZjdlLTlmODkxMDM1YTVhOCIsInNlc3Npb25fc3RhdGUiOiI0ZTJkMzFmNC1jNTAwLTQ4NTYtODM3Zi1lZDE1ZWE1ZjhhZWEiLCJzY29wZSI6Im9wZW5pZCBlbWFpbCBwcm9maWxlIG9mZmxpbmVfYWNjZXNzIn0.lY4H2-XvVHNH1MsXMKDwQr1KeF9j7CeNlyEwjN6b1m4";	
		DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
		
		switch(targetEnvironment) {
		    case "SamsungGalaxyS10":
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("useAppiumForWeb", true);
			capabilities.setCapability("openDeviceTimeout", 2);
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "10");
			capabilities.setCapability("location", "NA-US-PHX");
			capabilities.setCapability("resolution", "1440x3040");
			capabilities.setCapability("manufacturer", "Samsung");
			capabilities.setCapability("model", "Galaxy S10");
			capabilities.setCapability("deviceId", "RF8M3147NRE");
			capabilities.setCapability("autoAcceptAlerts", true);
			capabilities.setCapability("autoGrantPermissions", true);
			break;
		    case "iPhone13ProMax":
				capabilities.setCapability("platformName", "iOS");
				capabilities.setCapability("model", "iPhone.*");
				capabilities.setCapability("useAppiumForWeb", true);
				capabilities.setCapability("openDeviceTimeout", 2);
				capabilities.setCapability("platformName", "iOS");	
				capabilities.setCapability("platformVersion", "15.1");
				capabilities.setCapability("location", "NA-US-PHX");
				capabilities.setCapability("resolution", "1284x2778");
				capabilities.setCapability("manufacturer", "Apple");
				capabilities.setCapability("model", "iPhone-13 Pro Max");
				capabilities.setCapability("deviceName", "00008110-001465C80A11801E");
				capabilities.setCapability("autoAcceptAlerts", true);
				capabilities.setCapability("autoGrantPermissions", true);
				break;
		    	
		    case "iPad9thGeneration":
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("model", "iPhone.*");
			capabilities.setCapability("useAppiumForWeb", true);
			capabilities.setCapability("openDeviceTimeout", 2);
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("platformVersion", "15.1");
			capabilities.setCapability("location", "NA-US-PHX");
			capabilities.setCapability("resolution", "2160x1620");
			capabilities.setCapability("manufacturer", "Apple");
			capabilities.setCapability("model", "iPad \\(9th generation\\)");
			capabilities.setCapability("deviceName", "00008030-001278242140C02E");
			capabilities.setCapability("autoAcceptAlerts", true);
			capabilities.setCapability("autoGrantPermissions", true);
			break;
		}
			
			capabilities.setCapability("securityToken", PerfectoLabUtils.fetchSecurityToken(securityToken));		
			driver = new RemoteWebDriver(new URL("https://" + PerfectoLabUtils.fetchCloudName(cloudName) + ".perfectomobile.com/nexperience/perfectomobile/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			reportiumClient = PerfectoLabUtils.setReportiumClient(driver, reportiumClient); //Creates reportiumClient
			reportiumClient.testStart("Perfecto Android mobile web test", new TestContext("tag2", "tag3")); //Starts the reportium test
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			startTime=System.currentTimeMillis();
			driver.get(prop.getProperty("url"));
			reportiumClient.stepStart("Verify title");
			String aTitle = driver.getTitle();
			System.out.println(aTitle);
			Assert.assertTrue(aTitle.equals("Hyundai Cars, Sedans, SUVs, Compacts, and Luxury | Hyundai"));
			reportiumClient.stepEnd();
			Thread.sleep(2000);
			System.out.println("launched successfully");
//			husaLivePopupClose();
			closeNotificationPopup();
//			handleMobileBrowserPopup();	
//			allowAppPermission();
			zipValueEnter();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
			
			
	
		
	
	public static void testcasenumber(String testcasenumber)
	{
		Testcasenumber= testcasenumber;
	}

}
