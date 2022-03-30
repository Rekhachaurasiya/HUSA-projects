package TestRunners;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = {"src/test/java/AppFeatures/HomePage.feature"},
					glue = {"stepdefinitions"},
					plugin = {"pretty" , "html:test-output" , "json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"},
					monochrome = true,
					strict = true,
					dryRun = true,
					tags= "@TC001"
		)

public class TestRunner {
	private static  AndroidDriver<MobileElement> driver;
	@Before("@TC001")
	public void appiumSetUp() throws MalformedURLException {
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
	}
	 
	@After
	public void tearDown()
	{
		driver.close();
	}
	

}
