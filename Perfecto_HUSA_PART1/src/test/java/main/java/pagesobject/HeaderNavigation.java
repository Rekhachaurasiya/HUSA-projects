package main.java.pagesobject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.WebElement;

import main.java.utility.Projectcommonmethodes;
import main.java.utility.ReadExcelData;

public class HeaderNavigation extends Projectcommonmethodes{
	public HeaderNavigation(RemoteWebDriver driver) throws InterruptedException {
		this.driver = (AppiumDriver<MobileElement>) driver;
		closeWelcomePopup();
	} 


	public HeaderNavigation menuClick(String Testcasenumber) throws InterruptedException {
		//closeWelcomePopup();
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.MenuClick")))!=null) {
			clickByXpath(objValue.getProperty("xpath.MenuClick"),"Click Menu" );
			reportStep("Click on the Menu link", "PASS");

		}
		else {
			reportStep("Click on the Menu link", "FAIL");
		}
		return this;

	}

	public HeaderNavigation cpoLinkClick(String Testcasenumber) {

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.CPOLink")))!=null) {
			clickByXpath(objValue.getProperty("xpath.CPOLink"),"Click CPO Link" );
			reportStep("Click on the Certified Pre Owned link from Menu", "PASS");
			switchToLastWindow();

		}
		else {
			reportStep("Click on the Certified Pre Owned link from Menu", "FAIL");
		}
		return this;

	}


	public HeaderNavigation cpoTextVerification(String Testcasenumber) throws IOException {
		switchToLastWindow();
		sleepTime(30);
		String cpoUrlVerify = ReadExcelData.getdata(Testcasenumber, "CPOUrl");

		WebElement cpoHeader = driver.findElement(By.xpath(objValue.getProperty("xpath.VerifyTextCPO")));
		String cpoHeaderVerify = cpoHeader.getText().trim();
		System.out.println("CPO text verification is  "+ cpoHeaderVerify);

		String cpoUrl = driver.getCurrentUrl();
		System.out.println("The currenty URL is " +cpoUrl);

		if(cpoHeaderVerify.contains("Hyundai Certified") && cpoUrl.equals(cpoUrlVerify)) {                                         
			reportStep("Certified pre owned landing page displayed properly", "PASS", true);

		}
		else {
			reportStep("Error occured in the navigation of Certified pre owned landing page", "FAIL", true);
		}
		return this;


	}
	
	public HeaderNavigation scheduleTestDriveLink(String Testcasenumber) throws IOException, InterruptedException {
		if(driver.findElementByXPath(objValue.getProperty("xpath.stdMenuLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.stdMenuLink"), "Schedule Link is clicked");
			reportStep("Schedule Link is clicked from Menu", "PASS", true);
		}
		else {
			reportStep("Schedule Link is not clicked from Menu", "FAIL", true);
		}
			
		switchToLastWindow();
		sleepTime(90);
		if(driver.findElementByXPath(objValue.getProperty("xpath.stdPageVerification"))!=null) {
			offerClose();
			String headerSTD = ReadExcelData.getdata(Testcasenumber, "Header");
			verifyTextByXpath(objValue.getProperty("xpath.stdPageVerification"), headerSTD);
			offerClose();
			reportStep("Schedule Test Drive page is verified", "PASS", true);

		}
		else {
			reportStep("Schedule Test Drive page is not verified", "FAIL", true);
		}
		
		
		
		return this;
		
	}
	
	


}
