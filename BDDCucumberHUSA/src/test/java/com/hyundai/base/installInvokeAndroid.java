package com.hyundai.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class installInvokeAndroid {
	public static  AndroidDriver<AndroidElement> driver;
	 public AndroidDriver<AndroidElement> setUp() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
	    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10"); 
	    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus6");
//	    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 8");
     caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//	    caps.setCapability(MobileCapabilityType.UDID, "97d0de4c0806");
	    caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);
	    //caps.setCapability(MobileCapabilityType.APP, "");
	    caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//	  driver =new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.manage().deleteAllCookies();
	  return driver;
	 }
	 
	  public static void haldleAllowAndBlockPopup() throws InterruptedException {
		 driver.get("https://www.hyundaiusa.com/us/en");
		 Thread.sleep(2000);
		 System.out.println(driver.getContext());
		 Thread.sleep(2000);
		 String webContext = driver.getContext();
		    Set<String> contexts = driver.getContextHandles();
		    for (String handle: contexts){
		    	System.out.println(handle);
		        if (handle.contains("NATIVE_APP")){
		        	driver.context(handle);
		        	driver.findElement(By.id("android:id/button1")).click();
		            break;
		        }
		    }
	  
		    driver.context(webContext); 
		    driver.manage().deleteCookieNamed("Cookies accept and close");
			driver.findElement(By.xpath("/html/body/div[1]/div/button")).click(); 
	 }
		

	public static void StartAppium() throws IOException {
		Runtime.getRuntime().exec("appium --chromedriver-executable C:\\Users\\0014HO744\\Desktop\\AppiumSoftware\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
	}
	
	public static void StartEmulator() throws IOException {
		Runtime.getRuntime().exec("appium --chromedriver-executable C:\\Users\\0014HO744\\Desktop\\AppiumSoftware\\EmulatorDriver\\chromedriver_win32\\chromedriver.exe");
	}
//	
//	public static void StopEmulator() throws IOException {
//		Runtime.getRuntime().exec("C:\\Users\\lenovo\\Desktop\\WorkSpace_IBM_Appium_20042021\\Framework\\stopEmulator.bat");
//	}
//	
//	public static void StartAppiumChromeDriverSpeific() throws IOException {
//		Runtime.getRuntime().exec("C:\\Users\\lenovo\\Desktop\\WorkSpace_IBM_Appium_20042021\\Framework\\startAppiumChromedriver90.bat");
	}

	


