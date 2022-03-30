package com.perfecto.sampleproject;

import static org.testng.Assert.assertTrue;

import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.aspectj.weaver.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.exception.ReportiumException;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResult;
import com.perfecto.reportium.test.result.TestResultFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PerfectoSelenium {

	public static RemoteWebDriver driver;
	public static ReportiumClient reportiumClient;
	public static long startTime;
	public static JavascriptExecutor js;
	@Test
	public void invokebrowser() throws Exception {
		String targetEnvironment = "iPhone13ProMax";
		RemoteWebDriver driver;
		String cloudName = "hyundai";
//		String browserName = "mobileOS";
		String browserName = "safari";
		String securityToken = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIzYjJiMTFmMi03ZTExLTQxZGYtYTBjZS03N2UxMzYxMThjNWYifQ.eyJpYXQiOjE2NDE4NDAwMzcsImp0aSI6IjkxOGExOWIyLWIyOGEtNDc4ZC04MGM1LTEwY2E4N2ZkN2IzMiIsImlzcyI6Imh0dHBzOi8vYXV0aDUucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2h5dW5kYWktcGVyZmVjdG9tb2JpbGUtY29tIiwiYXVkIjoiaHR0cHM6Ly9hdXRoNS5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvaHl1bmRhaS1wZXJmZWN0b21vYmlsZS1jb20iLCJzdWIiOiIwODJiMWYzNi0wNDI4LTRkOTMtOGMxNC04MmNiN2JhNzQ3MGEiLCJ0eXAiOiJPZmZsaW5lIiwiYXpwIjoib2ZmbGluZS10b2tlbi1nZW5lcmF0b3IiLCJub25jZSI6IjZlOGM0YmJkLWNjNDgtNDlhNy04ZjdlLTlmODkxMDM1YTVhOCIsInNlc3Npb25fc3RhdGUiOiI0ZTJkMzFmNC1jNTAwLTQ4NTYtODM3Zi1lZDE1ZWE1ZjhhZWEiLCJzY29wZSI6Im9wZW5pZCBlbWFpbCBwcm9maWxlIG9mZmxpbmVfYWNjZXNzIn0.lY4H2-XvVHNH1MsXMKDwQr1KeF9j7CeNlyEwjN6b1m4";
		DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);

		switch (targetEnvironment) {
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
			capabilities.setCapability("noReset", false);
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
			capabilities.setCapability("noReset", false);
			capabilities.setCapability("autoAcceptAlerts", true);
			capabilities.setCapability("autoGrantPermissions", true);
			break;
		}

		capabilities.setCapability("securityToken", PerfectoLabUtils.fetchSecurityToken(securityToken));
		driver = new RemoteWebDriver(new URL("https://" + PerfectoLabUtils.fetchCloudName(cloudName)
				+ ".perfectomobile.com/nexperience/perfectomobile/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		reportiumClient = PerfectoLabUtils.setReportiumClient(driver, reportiumClient);
		reportiumClient.testStart("Perfecto Android mobile web test", new TestContext("tag2", "tag3"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		startTime = System.currentTimeMillis();
		driver.get("https://www.hyundaiusa.com/us/en");
		System.out.println("launched successfully");

		reportiumClient.stepStart("Verify title");
		String aTitle = driver.getTitle();
		System.out.println(aTitle);
		Assert.assertTrue(aTitle.equals("Hyundai Cars, Sedans, SUVs, Compacts, and Luxury | Hyundai"));
		reportiumClient.stepEnd();
		Thread.sleep(2000);
		try {
			
			driver.findElement(By.xpath("//button[contains(text(),'Accept & Close')]")).click();
			WebElement zipFieldVal = driver.findElement(By.xpath("//input[@id='zipModalInput']"));
			zipFieldVal.sendKeys("92614");
			org.openqa.selenium.WebElement zipConfirm = driver.findElement(By.xpath("(//button[@type='submit'])[4]"));
			zipConfirm.click();
		} catch (Exception e) {
			System.out.println("Accept & Close cookie is not available");
		}
		reportiumClient.stepStart("clicking on Menu");
		//driver.findElement(By.xpath("//a[@class='global-header-nav-link']")).click();
		WebElement menu=driver.findElement(By.xpath("//span[@class='global-header-menu-toggle-open']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//span[@class='global-header-menu-toggle-open']")) != null)
		{
			js.executeScript("arguments[0].click();", menu);
			System.out.println("clicked on menu button");
		}
		reportiumClient.stepEnd();
		 driver.quit();
	}

	
//	@AfterMethod
//	public void afterMethod(ITestResult result) {
//		TestResult testResult = null;
//
//		if (result.getStatus() == result.SUCCESS) {
//			testResult = TestResultFactory.createSuccess();
//		} else if (result.getStatus() == result.FAILURE) {
//			testResult = TestResultFactory.createFailure(result.getThrowable());
//		}
//		reportiumClient.testStop(testResult);
//
//		driver.close();
//		driver.quit();
//		String reportURL = reportiumClient.getReportUrl();
//		System.out.println(reportURL);
//	}
}
