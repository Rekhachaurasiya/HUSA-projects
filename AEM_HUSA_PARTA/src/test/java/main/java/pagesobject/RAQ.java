package main.java.pagesobject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import main.java.utility.Projectcommonmethodes;
import main.java.utility.ReadExcelData;

public class RAQ extends Projectcommonmethodes {

	public RAQ (RemoteWebDriver driver) throws InterruptedException{
		this.driver = driver;
		closeWelcomePopup();
	} 
	JavascriptExecutor js = (JavascriptExecutor)driver;

	public RAQ menuClick(String Testcasenumber) throws InterruptedException {
		/*closeWelcomePopup();
		closeNotificationPopup();*/
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.menu")))!=null) {
			clickByXpath(objValue.getProperty("xpath.menu"),"Click Menu" );
			reportStep("Menu link is clicked", "PASS");

		}
		else {
			reportStep("Menu link is not clicked", "FAIL");
		}
		return this;

	}

	public RAQ menuRAQLink(String Testcasenumber) throws InterruptedException {
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.RAQlink")))!=null) {
			clickByXpath(objValue.getProperty("xpath.RAQlink"),"Click RAQ link from Menu" );
			reportStep("RAQ link from Menu is clicked", "PASS");

		}
		else {
			reportStep("RAQ link from Menu is not clicked", "FAIL");
		}
		return this;

	}

	public RAQ textRAQVerification(String Testcasenumber) throws InterruptedException {
		closeWelcomePopup();
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.RAQtextVerification")))!=null) {
			clickByXpath(objValue.getProperty("xpath.RAQtextVerification"),"RAQ text is verified" );
			reportStep("RAQ page is displayed and text is verified", "PASS");

		}
		else {
			reportStep("RAQ page is displayed and text is not verified", "FAIL");
		}
		return this;

	}

	public RAQ selectVehicle(String Testcasenumber) throws InterruptedException, IOException{
		sleepTime(20);
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.vehicledropdown")))!=null) {
			clickByXpath(objValue.getProperty("xpath.vehicledropdown"),"Click on Select Vehicle dropdown");
			reportStep("RAQ page is displayed and text is verified", "PASS");

			String modelName = ReadExcelData.getdata(Testcasenumber, "Vehiclemodel");
			System.out.println("Model name is selected from excel "+modelName);
			selectVisibileTextByXPath(objValue.getProperty("xpath.vehicledropdown"),modelName);
			reportStep("Model is selected from the Select vehicle dropdown", "PASS", true);
		}

		else {
			reportStep("Model is not selected from the Select vehicle dropdown", "PASS", true);

		}

		String trimName = ReadExcelData.getdata(Testcasenumber, "Trimselection");
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.trimdropdown")))!=null) {
			selectVisibileTextByXPath(objValue.getProperty("xpath.trimdropdown"), trimName);
			reportStep("Trim is selected from the Select vehicle dropdown", "PASS", true);
		}

		else {
			reportStep("Trim is not selected from the Select vehicle dropdown", "PASS", true);

		}

		String powertrain = ReadExcelData.getdata(Testcasenumber, "Powertrain");
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.powertraindropdown")))!=null) {
			selectVisibileTextByXPath(objValue.getProperty("xpath.powertraindropdown"), powertrain);
			reportStep("Powertrain is selected from the Select vehicle dropdown", "PASS", true);
		}

		else {
			reportStep("Powertrain is not selected from the Select vehicle dropdown", "PASS", true);

		}

		String exteriorColor = ReadExcelData.getdata(Testcasenumber, "Exterior Color");
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.exteriordropdown")))!=null) {
			selectVisibileTextByXPath(objValue.getProperty("xpath.exteriordropdown"), exteriorColor);
			reportStep("Exterior Color is selected from the Select vehicle dropdown", "PASS", true);
		}

		else {
			reportStep("Exterior Color is not selected from the Select vehicle dropdown", "PASS", true);

		}

		String interiorColor = ReadExcelData.getdata(Testcasenumber, "Interior Color");
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.interiordropdown")))!=null) {
			selectVisibileTextByXPath(objValue.getProperty("xpath.interiordropdown"), interiorColor);
			reportStep("Interior Color is selected from the Select vehicle dropdown", "PASS", true);
		}

		else {
			reportStep("Interior Color is not selected from the Select vehicle dropdown", "PASS", true);

		}
		return this;
	}


	public RAQ chooseDealer(String Testcasenumber) throws InterruptedException, IOException {
		sleepTime(20);
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.zippin"))) !=null) {
			clickByXpath(objValue.getProperty("xpath.zippin"), "Click on zipcode pin popup");
			reportStep("Zip Code Pin is clicked", "PASS", true);
		}

		else {
			reportStep("Zip Code Pin is not clicked", "FAIL", true);
		}

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.zippopup")))!= null) {
			driver.findElement(By.xpath(objValue.getProperty("xpath.zippopup"))).clear();
			sleepTime(10);

			String zipcode = ReadExcelData.getdata(Testcasenumber,"Zipcode");

			enterByXpath(objValue.getProperty("xpath.zippopup"), zipcode, "Zipcode value is entered");
			reportStep("Zipcode value is entered properly in the zipcode popup", "PASS", true);

		}
		else {
			reportStep("Zipcode value is not entered properly in the zipcode popup", "FAIL", true);
		}
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.confirm")))!=null) {
			clickByXpathjs(objValue.getProperty("xpath.confirm"), "Confirm button is clicked");
			reportStep("Confirm button is clicked properly", "PASS", true);
		}

		else {
			reportStep("Confirm button is not clicked properly", "FAIL", true);
		}
		sleepTime(20);
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.dealer")))!=null) {
			getTextByXpath(objValue.getProperty("xpath.dealer"));
			reportStep("After changing the zipcode dealer name is displayed", "PASS", true);

		}
		else {
			reportStep("After changing the zipcode dealer name is not displayed", "FAIL", true);

		}

		return this;

	}

	public RAQ enterYourInfo(String Testcasenumber) throws IOException {
		driver.findElement(By.xpath(objValue.getProperty("xpath.firstname")));
		String firstName = ReadExcelData.getdata(Testcasenumber, "FirstName");
		System.out.println("First Name is " +firstName);
		enterByXpath(objValue.getProperty("xpath.firstname"), firstName, "First Name is entered");
		reportStep("First Name is entered properly", "PASS", true);

		driver.findElement(By.xpath(objValue.getProperty("xpath.lastname")));
		String lastName = ReadExcelData.getdata(Testcasenumber, "LastName");
		System.out.println("Last Name is " +lastName);
		enterByXpath(objValue.getProperty("xpath.lastname"), lastName, "Last Name is entered");
		reportStep("Last Name is entered properly", "PASS", true);

		driver.findElement(By.xpath(objValue.getProperty("xpath.emailRaq")));
		String emailID = ReadExcelData.getdata(Testcasenumber, "Email");
		System.out.println("Email ID is " +emailID);
		enterByXpath(objValue.getProperty("xpath.emailRaq"), emailID, "Email ID is entered");
		reportStep("Email ID is entered properly", "PASS", true);

		//scrollElement(objValue.getProperty("xpath.raqbutton"));
		//js.executeScript("arguments[0].scrollIntoView(true);",selectveh);
	js.executeScript("window.scrollBy(0,300)", "");
		
		
		//            if(driver.findElement(By.xpath(objvalue.getProperty("xpath.raqbutton")))!=null) 
		clickByXpath(objValue.getProperty("Xpath.Raqbutton"), "RAQ submit button is clicked successfully");
		reportStep("RAQ submit button is clicked successfully", "PASS", true);

		sleepTime(30);
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.thankYouMessage")))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.thankYouMessage"), "Your quote has been submitted.");
			reportStep("Thank You message is displayed properly", "PASS", true);
		}
		else {
			reportStep("Thank You message is not displayed properly", "FAIL", true);
		}

		return this;

	}
}
