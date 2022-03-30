package main.java.utility;



import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

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
	public void beforeMethod() throws IOException
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
	
	
	public void invokebrowser()
	{
		try {
			DesiredCapabilities caps=new DesiredCapabilities();
			caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
		    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10"); 
		    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus6");
//		    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 8");
	        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//		    caps.setCapability(MobileCapabilityType.UDID, "97d0de4c0806");
		    caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);
		    //caps.setCapability(MobileCapabilityType.APP, "");
		    caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	 //       driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	   	    URL url=new URL("http://127.0.0.1:4723/wd/hub");
	        driver=new AppiumDriver<MobileElement>(url,caps);
//		    driver=new AndroidDriver<MobileElement>(url,caps);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			startTime=System.currentTimeMillis();
			driver.get(prop.getProperty("url"));
			System.out.println("launched successfully");
			closeNotificationPopup();
			handleMobileBrowserPopup();
			sleepTime(5);
		//	zipValueEnter();
		//	husaLivePopupClose();
			
		}catch(Exception exp) {
			System.out.println("Cause is :"+exp.getCause());
			System.out.println("Message is:" +exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	public static void testcasenumber(String testcasenumber)
	{
		Testcasenumber= testcasenumber;
	}

}
