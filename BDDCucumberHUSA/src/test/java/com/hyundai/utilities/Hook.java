package com.hyundai.utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
	private static  AndroidDriver<MobileElement> driver;
	@Before("@Appium")
	public AndroidDriver<MobileElement> appiumSetUp() throws MalformedURLException {
			  DesiredCapabilities caps = new DesiredCapabilities();
			  caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
			    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10"); 
			    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus6");
//			    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 8");
		     caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//			    caps.setCapability(MobileCapabilityType.UDID, "97d0de4c0806");
			    caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);
			    //caps.setCapability(MobileCapabilityType.APP, "");
			    caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			    driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//			  driver =new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			  driver.manage().deleteAllCookies();
			  return driver;
	}
	 public static void StartAppium() throws IOException {
			Runtime.getRuntime().exec("appium --chromedriver-executable C:\\Users\\0014HO744\\Desktop\\AppiumSoftware\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		}
		
		public static AndroidDriver<MobileElement> StartEmulator() throws IOException {
			Runtime.getRuntime().exec("appium --chromedriver-executable C:\\Users\\0014HO744\\Desktop\\AppiumSoftware\\EmulatorDriver\\chromedriver_win32\\chromedriver.exe");
			return driver;
		}	
	@After
	public void tearDown()
	{
		driver.close();
	}
	public static AndroidDriver<MobileElement> getDriver() {
		return null;
	}
	
}
