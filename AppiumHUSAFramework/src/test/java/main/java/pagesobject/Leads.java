package main.java.pagesobject;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import main.java.utility.Projectcommonmethodes;
import main.java.utility.ReadExcelData;

public class Leads extends Projectcommonmethodes{

	public Leads (AppiumDriver<MobileElement> driver) {

		this.driver=driver;
	}
	JavascriptExecutor js = (JavascriptExecutor)driver;
	public Leads keepMeUpdatePositive(String Testcasenumber) throws IOException, InterruptedException {

		closeNotificationPopup();
		sleepTime(10);
		String fName = ReadExcelData.getdata(Testcasenumber, "FirstName");
		String lName = ReadExcelData.getdata(Testcasenumber, "LastName");
		String eAddress = ReadExcelData.getdata(Testcasenumber, "Email");
		String zip = ReadExcelData.getdata(Testcasenumber, "Zipcode");


		clickByXpath(objValue.getProperty("Xpath.News"), "News Link");

		WebElement verifyNews = driver.findElement(By.xpath(objValue.getProperty("Xpath.NewsVerify")));
		String NewsSec = verifyNews.getText().trim();
		if(NewsSec.equalsIgnoreCase("Keep in touch.")) {
			reportStep("News Keep Me Update Section displayed properly", "PASS", true);

		}
		else {
			reportStep("News Keep Me Update Section not displayed", "FAIL", true);
		}

		enterByXpath(objValue.getProperty("Xpath.KeepFName"), fName, "First Name");
		enterByXpath(objValue.getProperty("Xpath.KeepLName"), lName, "Last Name");
		enterByXpath(objValue.getProperty("Xpath.KeepEmail"), eAddress, "Email Address");
		enterByXpath(objValue.getProperty("Xpath.KeepZip"), zip, "Zip");
		clickByXpath(objValue.getProperty("Xpath.KeepSubmit"), "Submit Button");
		sleepTime(30);

		WebElement successVerify = driver.findElement(By.xpath(objValue.getProperty("Xpath.KeepMeUpdateSubmitted")));
		if(successVerify.getText().equalsIgnoreCase("Request Submitted")) {
			reportStep("Keep Me Updated section Submitted successfully", "PASS", true);

		}
		else {
			reportStep("Error occured while submitting Keep Me Updated form", "FAIL", true);
		}

		return this;

	}

	public Leads emailVerifyKeepMeUpdate(String Testcasenumber) {

		clickByXpath(objValue.getProperty("Xpath.KeepMeEmailVerifiation"), "Email Link");
		sleepTime(30);
		js.executeScript("window.scrollBy(0,500)", "");
		WebElement emailName = driver.findElement(By.xpath(objValue.getProperty("Xpath.KeepMeEmailNameText")));
		String nameInEmail = emailName.getText();
		WebElement emailSub = driver.findElement(By.xpath(objValue.getProperty("Xpath.KeepMeEmailText")));
		String textInEmail = emailSub.getText();
		String emailContent = nameInEmail.concat(textInEmail);
		System.out.println(emailContent+"Email content");

		if(emailContent.contains("Dear Test,Thanks for signing up")) {
			reportStep("Email received successfully for Keep Me Update Section", "PASS", true);

		}
		else {
			reportStep("Email not received for Keep Me Update Section", "FAIL", true);
		}
		return this;


	}
	public Leads emailVerifyRequestAQuote(String Testcasenumber) throws IOException {
		
		String mailExpectedVenName = ReadExcelData.getdata(Testcasenumber, "expectedVehicleName");

		clickByXpath(objValue.getProperty("Xpath.RaqEmailLink"), "Email Link");
		sleepTime(30);
		WebElement emailName = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqVehName")));

		String RaqVehName = emailName.getText();
		if(RaqVehName.equalsIgnoreCase(mailExpectedVenName)) {
		reportStep(RaqVehName+"Email received successfully for Request A Quote page", "PASS", true);
		}
		else {
			reportStep(RaqVehName+"Email not received for Request A Quote page", "FAIL", true);
		}
		return this;


	}
public Leads emailVerifyRequestAQuoteSearchInv(String Testcasenumber) throws IOException {
		
		//String mailExpectedVenName = ReadExcelData.getdata(Testcasenumber, "expectedVehicleName");

		clickByXpath(objValue.getProperty("Xpath.RaqEmailLink"), "Email Link");
		sleepTime(30);
		WebElement emailName = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqVehName")));

		String RaqVehName = emailName.getText();
		//if(RaqVehName.equalsIgnoreCase(mailExpectedVenName)) {
		reportStep(RaqVehName+"Email received successfully for Request A Quote page", "PASS", true);
		//}
		//else {
		//	reportStep(RaqVehName+"Email not received for Request A Quote page", "FAIL", true);
		//}
		return this;


	}

	public Leads keepMeUpdateLeadForm(String Testcasenumber) throws InterruptedException, IOException {
		closeWelcomePopup();
		sleepTime(5);
		String FNameErrMsg = ReadExcelData.getdata(Testcasenumber, "FNameError");
		String LNameErrMsg = ReadExcelData.getdata(Testcasenumber, "LNameError");
		String EmailAddErrMsg = ReadExcelData.getdata(Testcasenumber, "EmailError");
		String ZipErrMsg = ReadExcelData.getdata(Testcasenumber, "ZipError");
		closeNotificationPopup();
		sleepTime(10);
		clickByXpath(objValue.getProperty("Xpath.News"), "News Link");
		sleepTime(10);
		String newsUrl = driver.getCurrentUrl();
		closeWelcomePopup();
		sleepTime(5);
		WebElement verifyNews = driver.findElement(By.xpath(objValue.getProperty("Xpath.NewsVerify")));
		String NewsSec = verifyNews.getText().trim();
		if(NewsSec.equalsIgnoreCase("Keep in touch.")) {
			reportStep("News Keep Me Update Section displayed properly", "PASS", true);

		}
		else {
			reportStep("News Keep Me Update Section not displayed", "FAIL", true);
		}
		js.executeScript("window.scrollBy(0,300)", "");
		clickByXpath(objValue.getProperty("Xpath.KeepSubmit"), "Submit Button");
		sleepTime(30);

		WebElement fNameError = driver.findElement(By.xpath(objValue.getProperty("Xpath.KeepMeErrorFName")));
		WebElement lNameError = driver.findElement(By.xpath(objValue.getProperty("Xpath.KeepMeErrorLName")));
		WebElement emailAddError = driver.findElement(By.xpath(objValue.getProperty("Xpath.KeepMeErrorEmail")));
		WebElement zipError = driver.findElement(By.xpath(objValue.getProperty("Xpath.KeepMeErrorZip")));

		String firstNameError = fNameError.getText();
		String lastNameError = lNameError.getText();
		String emailAddressError = emailAddError.getText();
		String ZipCodeError = zipError.getText();

		if(firstNameError.equalsIgnoreCase(FNameErrMsg)) {

			reportStep(firstNameError+"First Name error message displayed properly", "PASS", true);

		}
		else {
			reportStep("Unable to find First Name error message", "FAIL", true);
		}
		if(lastNameError.equalsIgnoreCase(LNameErrMsg)) {

			reportStep(lastNameError+"Last Name error message displayed properly", "PASS", true);

		}
		else {
			reportStep("Unable to find Last Name error message", "FAIL", true);
		}
		if(emailAddressError.equalsIgnoreCase(EmailAddErrMsg)) {

			reportStep(emailAddressError+"Email Address error message displayed properly", "PASS", true);

		}
		else {
			reportStep("Unable to find Email Address error message", "FAIL", true);
		}
		if(ZipCodeError.equalsIgnoreCase(ZipErrMsg)) {

			reportStep(ZipCodeError+"Zip code error message displayed properly", "PASS", true);

		}
		else {
			reportStep("Unable to find Zip code error message", "FAIL", true);
		}
		driver.get(newsUrl);
		closeWelcomePopup();
		sleepTime(5);

		sleepTime(10);
		String fName = ReadExcelData.getdata(Testcasenumber, "FirstName");
		String lName = ReadExcelData.getdata(Testcasenumber, "LastName");
		String eAddress = ReadExcelData.getdata(Testcasenumber, "Email");
		String zip = ReadExcelData.getdata(Testcasenumber, "Zipcode");

		enterByXpath(objValue.getProperty("Xpath.KeepFName"), fName, "First Name");
		enterByXpath(objValue.getProperty("Xpath.KeepLName"), lName, "Last Name");
		enterByXpath(objValue.getProperty("Xpath.KeepEmail"), eAddress, "Email Address");
		
		enterByXpath(objValue.getProperty("Xpath.KeepZip"), zip, "Zip");
		js.executeScript("window.scrollBy(0,300)", "");
		sleepTime(10);
		clickByXpath(objValue.getProperty("Xpath.KeepSubmit"), "Submit Button");
		sleepTime(30);

		WebElement successVerify = driver.findElement(By.xpath(objValue.getProperty("Xpath.KeepMeUpdateSubmitted")));
		if(successVerify.getText().equalsIgnoreCase("Request Submitted")) {
			reportStep("Keep Me Updated section Submitted successfully", "PASS", true);

		}
		else {
			reportStep("Error occured while submitting Keep Me Updated form", "FAIL", true);
		}

		return this;

	}
	public Leads requestAQuoteLeadsFlow(String Testcasenumber) throws InterruptedException, IOException {
		
		
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

		js.executeScript("window.scrollBy(0,300)", "");
		scrollElement(objValue.getProperty("xpath.raqbuttonClick"));
		//            if(driver.findElement(By.xpath(objvalue.getProperty("xpath.Leadsbutton")))!=null) 
		clickByXpath(objValue.getProperty("xpath.raqbuttonClick"), "RAQ submit button is clicked successfully");
		reportStep("RAQ submit button is clicked successfully", "PASS", true);

		sleepTime(30);
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.thankYouMessage")))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.thankYouMessage"), "Your quote has been submitted.");
			reportStep("Thank You message is displayed properly", "PASS", true);
		}
		else {
			reportStep("Thank You message is not displayed properly", "FAIL", true);
		}
		
		scrollElement(objValue.getProperty("xpath.raqbuttonClick"));
		//            if(driver.findElement(By.xpath(objvalue.getProperty("xpath.Leadsbutton")))!=null) 
		clickByXpath(objValue.getProperty("xpath.raqbuttonClick"), "RAQ submit button is clicked successfully");
		reportStep("RAQ submit button is clicked successfully", "PASS", true);

		sleepTime(30);

		String FNameErrMsg = ReadExcelData.getdata(Testcasenumber, "FNameError");
		String LNameErrMsg = ReadExcelData.getdata(Testcasenumber, "LNameError");
		String EmailAddErrMsg = ReadExcelData.getdata(Testcasenumber, "EmailError");


		WebElement fNameError = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqErrorFName")));
		WebElement lNameError = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqErrorlName")));
		WebElement emailAddError = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqErrorEmail")));


		String firstNameError = fNameError.getText();
		String lastNameError = lNameError.getText();
		String emailAddressError = emailAddError.getText();


		if(firstNameError.equalsIgnoreCase(FNameErrMsg)) {

			reportStep(firstNameError+"First Name error message displayed properly", "PASS", true);

		}
		else {
			reportStep("Unable to find First Name error message", "FAIL", true);
		}
		if(lastNameError.equalsIgnoreCase(LNameErrMsg)) {

			reportStep(lastNameError+"Last Name error message displayed properly", "PASS", true);

		}
		else {
			reportStep("Unable to find Last Name error message", "FAIL", true);
		}
		if(emailAddressError.equalsIgnoreCase(EmailAddErrMsg)) {

			reportStep(emailAddressError+"Email Address error message displayed properly", "PASS", true);

		}
		else {
			reportStep("Unable to find Email Address error message", "FAIL", true);
		}


		return this;

	}
	public Leads menuClick(String Testcasenumber) throws InterruptedException {
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

	public Leads menuRAQLink(String Testcasenumber) throws InterruptedException {
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.RAQlink")))!=null) {
			clickByXpath(objValue.getProperty("xpath.RAQlink"),"Click Leads link from Menu" );
			reportStep("RAQ link from Menu is clicked", "PASS");

		}
		else {
			reportStep("RAQ link from Menu is not clicked", "FAIL");
		}
		return this;

	}

	public Leads textRAQVerification(String Testcasenumber) throws InterruptedException {
		closeWelcomePopup();
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.RAQtextVerification")))!=null) {
			clickByXpath(objValue.getProperty("xpath.RAQtextVerification"),"Leads text is verified" );
			reportStep("RAQ page is displayed and text is verified", "PASS");

		}
		else {
			reportStep("RAQ page is displayed and text is not verified", "FAIL");
		}
		return this;

	}

	public Leads selectVehicle(String Testcasenumber) throws InterruptedException, IOException{
		sleepTime(20);
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.vehicledropdown")))!=null) {
			clickByXpath(objValue.getProperty("xpath.vehicledropdown"),"Click on Select Vehicle dropdown");
			reportStep("Leads page is displayed and text is verified", "PASS");

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


	public Leads chooseDealer(String Testcasenumber) throws InterruptedException, IOException {
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

	public Leads enterYourInfo(String Testcasenumber) throws IOException {
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

		driver.findElement(By.xpath(objValue.getProperty("xpath.email")));
		String emailID = ReadExcelData.getdata(Testcasenumber, "Email");
		System.out.println("Email ID is " +emailID);
		enterByXpath(objValue.getProperty("xpath.email"), emailID, "Email ID is entered");
		reportStep("Email ID is entered properly", "PASS", true);

		scrollElement(objValue.getProperty("xpath.raqbuttonClick"));
		
		//            if(driver.findElement(By.xpath(objvalue.getProperty("xpath.Leadsbutton")))!=null) 
		clickByXpath(objValue.getProperty("xpath.raqbuttonClick"), "RAQ submit button is clicked successfully");
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
	//---------------------VLP Page-----------------------

	public Leads clickVehicleNav(String Testcasenumber) throws IOException, InterruptedException {
		//zipCodePopup();
		sleepTime(10);
		closeWelcomePopup();
		closeNotificationPopup();

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.VehicleNav"))) != null) {

			clickByXpath(objValue.getProperty("xpath.VehicleNav"), "vehiclenav");
			sleepTime(10);
			reportStep("Vehicle Navigation clicked successfully", "PASS", true);

		}
		else {
			reportStep("Vehicle Navigation not clicked", "Fail", true);
		}


		return this;        
	}
	String vehPriceNew="";
	String Getprice="";

	public static String vehcompare,Getmpg,Gethp;
	public Leads selectVehicleVLP(String Testcasenumber) throws IOException, InterruptedException {

		String Vehiclemodelcol = ReadExcelData.getdata(Testcasenumber, "Vehiclemodel");

		String Vehiclenamecol =ReadExcelData.getdata(Testcasenumber, "VehicleName");
		//String VehiclePrice =ReadExcelData.getdata(Testcasenumber, "VehiclePrice");

		String Vehicledatasheet =Vehiclemodelcol+ Vehiclenamecol;
		List<MobileElement> vehiclelist = driver.findElements(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car'])"));
		int vehSize = vehiclelist.size();
		List<MobileElement> vehiPrice = driver.findElements(By.xpath("//div[@class='vbws-specs']//div[@data-service='price']"));
		
		System.out.println("Total Vehicle List"+vehSize);
		int priceSize = vehiPrice.size();
		for ( int i=1;i<=vehiclelist.size();i++)
		{
			
		

			WebElement	Vehiclename1 =  driver.findElement(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car']//div[@class='vbws-car-name'])["+i+"]"));
			String  Vehiclename2 = Vehiclename1.getText();
			String  Vehiclename = Vehiclename2.replaceAll("[^a-zA-Z0-9]", "");
			WebElement	Vehiclemodel1 =  driver.findElement(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car']/h3/div[@class='vbws-car-year'])["+i+"]"));		
			String  Vehiclemodel = Vehiclemodel1.getText();
			vehcompare = Vehiclemodel+Vehiclename;
			
		 
		 
		/*String pricenew1="(//div[@class='vbws-group']//div[@class='vbws-item '])[";
		String pricenew="]//span[@data-price='value']";*/
		
		
		
			
			if(vehcompare.equals(Vehicledatasheet)) {
				
				WebElement vehPrice = driver.findElement(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car']//div[@class='vbws-car-name'])["+i+"]//following::div/div/div/span[2]/following::div/span/span"));
				WebElement selectveh= driver.findElement(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car']//div[@class='vbws-car-name'])["+i+"]"));
				String vehPriceNewVal = vehPrice.getText();
				vehPriceNew = vehPriceNewVal.replaceAll("\\W", "");
				System.out.println("Application price"+vehPriceNew);
				js.executeScript("arguments[0].click();", selectveh);
				sleepTime(30);

				System.out.println(" PASS" + vehcompare + "Selected vehicle from the list matches " + Vehicledatasheet);
				break;
				/*if(vehPriceNew.equals(vehPriceValue)) {
					
					reportStep("Vehicle Price details is matching with the data Sheet", "PASS", true);
					break;
				}*/
				
				
		} }                                                                                                                                                                                                                                                     
	
	

		return this;
		}
	public Leads searchInvRaqNegativeFlow(String Testcasenumber) throws IOException, InterruptedException {


		js.executeScript("window.scrollBy(0,100)", "");
		/*WebElement RAQ = driver.findElement(By.xpath(objValue.getProperty("Xpath.overviewRAQ")));

			//js.executeScript("window.scrollBy(0,-300)", "");

			js.executeScript("arguments[0].scrollIntoView(true);",RAQ);
		 */
		clickByXpath(objValue.getProperty("Xpath.RaqSubmit"), "Raq Submit");
		sleepTime(20);
		String FNameErrMsg = ReadExcelData.getdata(Testcasenumber, "FNameError");
		String LNameErrMsg = ReadExcelData.getdata(Testcasenumber, "LNameError");
		String EmailAddErrMsg = ReadExcelData.getdata(Testcasenumber, "EmailError");


		WebElement fNameError = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqErrorFName")));
		WebElement lNameError = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqErrorlName")));
		WebElement emailAddError = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqErrorEmail")));


		String firstNameError = fNameError.getText();
		String lastNameError = lNameError.getText();
		String emailAddressError = emailAddError.getText();


		if(firstNameError.equalsIgnoreCase(FNameErrMsg)) {

			reportStep(firstNameError+"First Name error message displayed properly", "PASS", true);

		}
		else {
			reportStep("Unable to find First Name error message", "FAIL", true);
		}
		if(lastNameError.equalsIgnoreCase(LNameErrMsg)) {

			reportStep(lastNameError+"Last Name error message displayed properly", "PASS", true);

		}
		else {
			reportStep("Unable to find Last Name error message", "FAIL", true);
		}
		if(emailAddressError.equalsIgnoreCase(EmailAddErrMsg)) {

			reportStep(emailAddressError+"Email Address error message displayed properly", "PASS", true);

		}
		else {
			reportStep("Unable to find Email Address error message", "FAIL", true);
		}

		return this;
	}

	public Leads vlpRaqLeadFlow(String Testcasenumber) throws IOException, InterruptedException {
		//offerClose();
		
		String SOverview = ReadExcelData.getdata(Testcasenumber, "OverviewVerify");
		//String SUrl = ReadExcelData.getdata(Testcasenumber, "URLVerify");
		String FName = ReadExcelData.getdata(Testcasenumber, "FirstName");
		String LName = ReadExcelData.getdata(Testcasenumber, "LastName");
		String EmailAddress = ReadExcelData.getdata(Testcasenumber, "Email");

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.vehicleOverview")))!=null) {

			WebElement VerifyOverview = driver.findElement(By.xpath(objValue.getProperty("xpath.vehicleOverviewPageVerify")));
			//	if(VerifyOverview.getText().equalsIgnoreCase(SOverview)&&driver.getCurrentUrl().equals(SUrl)) {
			if(VerifyOverview.getText().equalsIgnoreCase(SOverview)) {		
				reportStep("Overview page displayed properly with"+SOverview , "Pass", true);
			}
			else {

				reportStep("Overview page displayed properly with"+SOverview , "Fail", true);
			}

			js.executeScript("window.scrollBy(0,300)", "");


			if(driver.findElement(By.xpath(objValue.getProperty("Xpath.overviewRAQ")))!=null) {

				//clickByXpath(objValue.getProperty("Xpath.overviewRAQ"), "RAQ Button Click");
				clickByXpathjs(objValue.getProperty("Xpath.overviewRAQ"), "RAQ Button Click");
				sleepTime(10);

				clickByXpath(objValue.getProperty("Xpath.Raqbutton"),"RAQ Submission");

			}
			else {

				reportStep("Unable to find the RAQ button in the Overview Page", "FAIL", true);
			}
			String FNameErrMsg = ReadExcelData.getdata(Testcasenumber, "FNameError");
			String LNameErrMsg = ReadExcelData.getdata(Testcasenumber, "LNameError");
			String EmailAddErrMsg = ReadExcelData.getdata(Testcasenumber, "EmailError");


			WebElement fNameError = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqErrorFName")));
			WebElement lNameError = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqErrorlName")));
			WebElement emailAddError = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqErrorEmail")));


			String firstNameError = fNameError.getText();
			String lastNameError = lNameError.getText();
			String emailAddressError = emailAddError.getText();


			if(firstNameError.equalsIgnoreCase(FNameErrMsg)) {

				reportStep(firstNameError+"First Name error message displayed properly", "PASS", true);

			}
			else {
				reportStep("Unable to find First Name error message", "FAIL", true);
			}
			if(lastNameError.equalsIgnoreCase(LNameErrMsg)) {

				reportStep(lastNameError+"Last Name error message displayed properly", "PASS", true);

			}
			else {
				reportStep("Unable to find Last Name error message", "FAIL", true);
			}
			if(emailAddressError.equalsIgnoreCase(EmailAddErrMsg)) {

				reportStep(emailAddressError+"Email Address error message displayed properly", "PASS", true);

			}
			else {
				reportStep("Unable to find Email Address error message", "FAIL", true);
			}


		}

		//clickByXpathjs(objValue.getProperty("Xpath.overviewRAQ"), "RAQ Button Click");
		sleepTime(10);
		enterByXpath(objValue.getProperty("xpath.VlpFirstName"), FName, "First Name");
		enterByXpath(objValue.getProperty("xpath.VlplastName"), LName, "Last Name");
		enterByXpath(objValue.getProperty("xpath.VlpEmail"), EmailAddress, "Email Address");

		clickByXpath(objValue.getProperty("Xpath.Raqbutton"),"RAQ Submission");
		WebElement raqSubmission = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqSubmissionMessge")));
		String successMesasge = raqSubmission.getText();
		if(successMesasge.contains("Your quote request has been successfully submitted")) {

			reportStep("Raq Form submitted successfully in the Overview Page", "PASS", true);

		}
		else {
			reportStep("Unable to submit the RAQ form in the Overview Page", "FAIL", true);
		}

		return this;


	}



	//------Search Inventory----------------------------
	public Leads searchInvRaqSubmit(String Testcasenumber) throws IOException {

		String Fname = ReadExcelData.getdata(Testcasenumber, "FirstName");
		String Lname = ReadExcelData.getdata(Testcasenumber, "LastName");
		String eAddress = ReadExcelData.getdata(Testcasenumber, "Email");

		enterByXpath(objValue.getProperty("Xpath.fName"), Fname, "First name");
		enterByXpath(objValue.getProperty("Xpath.lName"), Lname, "Last name");
		enterByXpath(objValue.getProperty("Xpath.eMail"), eAddress, "Email Address");
		clickByXpath(objValue.getProperty("Xpath.RaqSubmit"), "Raq Submit");
		sleepTime(20);
		WebElement successMsg = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqThankyouMsg")));
		if(successMsg.getText().contains("Your quote request has been successfully submitted")) {
			reportStep("Search Invnetory RAQ submitted successfully", "PASS", true);

		}
		else {
			reportStep("Error occured while submitting Search Invnetory RAQ form", "FAIL", true);
		}

		return this;
	}
	String vehName="";
	public Leads vehicleModel(String Testcasenumber) throws InterruptedException {
		closeWelcomePopup();
		closeNotificationPopup();
		if(driver.findElement(By.xpath(objValue.getProperty("Xpath.SearchInventory")))!=null) {

			clickByXpath(objValue.getProperty("Xpath.SearchInventory"), "Header-Search Inventory");
			closeWelcomePopup();
			sleepTime(10);
			WebElement searchInveVerify = driver.findElement(By.xpath(objValue.getProperty("Xpath.SearchInventoryPage")));
			if(searchInveVerify.getText().trim().equalsIgnoreCase("Find Your Hyundai")) {
				reportStep("Search Ivnentory landing page displayed properly", "PASS", true);

			}

			sleepTime(30);
			clickByXpath(objValue.getProperty("Xpath.MilesDropdown"), "Miles-Dropdown");
			System.out.println("Miles dropdown clicked");

			clickByXpath(objValue.getProperty("Xpath.MilesSelection"), "Miles-Selection");
			reportStep("Miles Dropdown clicked successfully", "PASS", true);
			clickByXpath(objValue.getProperty("Xpath.ZipLocation"), "Zip Location");
			sleepTime(30);
			reportStep("Zipfield clicked successfully", "PASS", true);
			WebElement zipField = driver.findElement(By.xpath("//input[@placeholder='Enter ZIP Code']"));

			enterByXpath(objValue.getProperty("Xpath.ZipField"), "92614", "Zip field");
			sleepTime(30);
			closeWelcomePopup();
			closeNotificationPopup();

			clickByXpath(objValue.getProperty("Xpath.confirmButton"), "Confirm");
			sleepTime(30);
			reportStep("Zip code entered successfully", "Pass", true);
			enterByXpath(objValue.getProperty("Xpath.Msrpfield"), "1,00,000", "Maximum MSRP");
			reportStep("MSRP value entered successfully", "PASS", true);
			WebElement fuel = driver.findElement(By.xpath(objValue.getProperty("Xpath.Fuelcheck")));
			js.executeScript("arguments[0].scrollIntoView(true);",fuel);
			clickByXpath(objValue.getProperty("Xpath.Fuelcheck"), "Fuel source");
			reportStep("Fuel check clicked successfully", "PASS", true);
			WebElement searchresultcount = driver.findElement(By.xpath(objValue.getProperty("Xpath.searchCount")));
			String count = searchresultcount.getText();
			reportStep("Search results" +count+ "displayed", "PASS", true);
			closeNotificationPopup();
			/*WebElement searchresultName = driver.findElement(By.xpath(objValue.getProperty("Xpath.vehiceleName")));
		vehName = searchresultName.getText().trim();*/
			WebElement result = driver.findElement(By.xpath(objValue.getProperty("Xpath.firstResult")));
			js.executeScript("arguments[0].scrollIntoView(true);",result);
			clickByXpath(objValue.getProperty("Xpath.firstResult"), "First Result");
			reportStep("First vehicle"+vehName+" clicked successfully in the search results page", "PASS", true);
		}
		else {
			reportStep("Error occured in the navigation of Search Ivnentory landing page ", "FAIL", true);
		} 

		return this;
	}
	String vehNameResultPrice ="";
	String vehNameResultDealer ="";
	String vehNameResultpage="";
	String selInColo="";
	String selExColo="";
	String SelPower="";
	String selpackage="";
	String selTrim="";
	public Leads vehicleResult(String Testcasenumber) {



		List<MobileElement> dropdown = driver.findElements(By.xpath(objValue.getProperty("Xpath.filterDropdown")));

		for(int i=1;i<dropdown.size();i++) {

			WebElement dropdownClick = driver.findElement(By.xpath("(//div[contains(@class,'filters-choice-category')])["+i+"]"));
			js.executeScript("arguments[0].scrollIntoView(true);",dropdownClick);

			String filterOptions = dropdownClick.getText();
			reportStep("Filter Option"+ filterOptions+"displayed properly in Vehicle Results page ", "PASS", true);
			System.out.println(filterOptions);
			if(i==1){ 
				if(filterOptions.contains("Maximum MSRP")) {

					enterByXpath(objValue.getProperty("Xpath.Msrpfield"), "1,00,000", "Maximum MSRP");
					reportStep("MSRP value entered successfully in"+filterOptions+"Field", "PASS", true);
				}
				else {
					reportStep("MSRP value not entered in"+filterOptions+"Field", "FAIL", true);
				}
			}
			if(i==2){ 
				if(filterOptions.contains("Trims")) {

					clickByXpath(objValue.getProperty("Xpath.TrimDropdown"), "Trim selection");
					reportStep("Trim"+selTrim+" clicked successfully in Vehicle Results page ", "PASS", true);

				}
				else {
					reportStep("Trim filter option not displayed in Vehicle Results page ", "FAIL", true);
				}
			}
			if(i==3){
				if(filterOptions.contains("Packages & Options")) {

					js.executeScript("arguments[0].click();", dropdownClick);

					clickByXpath(objValue.getProperty("Xpath.packClick"), "Packages selection");
					reportStep("Packages"+selpackage+ " clicked successfully in Vehicle Results page ", "PASS", true);

					System.out.println("Dropdown clicked");
				}
				else {
					reportStep("Packages filter option not displayed in Vehicle Results page ", "FAIL", true);
				}
			}
			if(i==4){
				if(filterOptions.contains("Exterior Color")) {

					js.executeScript("arguments[0].click();", dropdownClick);
					sleepTime(30);

					System.out.println("Exterior color"+selExColo);
					clickByXpath(objValue.getProperty("Xpath.ExteriorColorselection"), "Exterior selection");
					reportStep("Exterior color"+selExColo+" clicked successfully in Vehicle Results page ", "PASS", true);
					System.out.println("Dropdown clicked");

				}
				else {
					reportStep("Exterior color not clicked in Vehicle Results page ", "FAIL", true);
				}
			}
			if(i==5){
				if(filterOptions.contains("Interior Color")) {

					js.executeScript("arguments[0].click();", dropdownClick);
					clickByXpath(objValue.getProperty("Xpath.InteriorColorselection"), "Interior selection");
					reportStep("Interior"+selInColo+" color clicked successfully in Vehicle Results page ", "PASS", true);
					System.out.println("Dropdown clicked");
					sleepTime(30);
				}
				else {
					reportStep("Interior color not clicked in Vehicle Results page ", "FAIL", true);
				}
			}


		}


		WebElement powerCat = driver.findElement(By.xpath(objValue.getProperty("Xpath.vehiclePowerCat")));
		js.executeScript("arguments[0].click();", powerCat);
		clickByXpath(objValue.getProperty("Xpath.Power"), "Power and Handling selection");
		reportStep("Power and Handling"+SelPower+" clicked successfully in Vehicle Results page ", "PASS", true);
		System.out.println("Dropdown clicked");




		WebElement searchresultName = driver.findElement(By.xpath(objValue.getProperty("Xpath.VehicleNameresults")));

		vehNameResultpage = searchresultName.getText().trim();
		reportStep(vehNameResultpage+ " vehicle displayed in the search results page", "PASS");

		//Getting the vehicle price and dealer details:
		WebElement searchresultPrice = driver.findElement(By.xpath(objValue.getProperty("Xpath.VehicleResultPrice")));

		vehNameResultPrice = searchresultPrice.getText().trim();
		reportStep(vehNameResultpage+ "Price value dispalyed" +searchresultPrice+ " displayed in the search results page", "PASS");

		WebElement searchresultDealer = driver.findElement(By.xpath(objValue.getProperty("Xpath.VehicleResultsDealer")));

		vehNameResultDealer = searchresultDealer.getText().trim();
		WebElement TrimVal = driver.findElement(By.xpath(objValue.getProperty("Xpath.Trimtext")));

		selTrim = TrimVal.getText();
		System.out.println("Trim"+selTrim);
		WebElement PackageVal = driver.findElement(By.xpath(objValue.getProperty("Xpath.packClicktext")));

		selpackage = PackageVal.getText();
		System.out.println("Trim"+selpackage);
		WebElement exColor = driver.findElement(By.xpath(objValue.getProperty("Xpath.ExteriorColorselectionVerify")));

		selExColo = exColor.getText();
		WebElement InColor = driver.findElement(By.xpath(objValue.getProperty("Xpath.InteriorColorselection")));

		selInColo = InColor.getText();
		System.out.println("Exterior color"+selInColo);
		WebElement powerVal = driver.findElement(By.xpath(objValue.getProperty("Xpath.Powertext")));

		SelPower = powerVal.getText();
		System.out.println("Power value"+SelPower);

		reportStep("Vehicle filter selected successfully", "PASS", true);
		clickByXpath(objValue.getProperty("Xpath.Vehicleresultclick"), "Vehicle results");
		reportStep(vehNameResultpage+"clicked successfully in Vehicle Results page ", "PASS", true);

		return this;

	}
	public Leads vehicleDetails(String Testcasenumber) {

		WebElement vehName = driver.findElement(By.xpath(objValue.getProperty("Xpath.VehNameDetailPage")));
		String vehNameDetail = vehName.getText();

		WebElement vehTrim = driver.findElement(By.xpath(objValue.getProperty("Xpath.VehTrimDetailPage")));
		String vehTrimDetail = vehTrim.getText();

		WebElement vehPackage = driver.findElement(By.xpath(objValue.getProperty("Xpath.VehPackDetailPage")));
		String vehPackageDetail = vehPackage.getText();

		WebElement vehPrice = driver.findElement(By.xpath(objValue.getProperty("Xpath.VehiclePriceDetailPage")));
		String vehPriceDetail = vehPrice.getText();

		WebElement vehExterior = driver.findElement(By.xpath(objValue.getProperty("Xpath.vehicleExtDetailPage")));
		String vehExtDetail = vehExterior.getText();

		WebElement vehinterior = driver.findElement(By.xpath(objValue.getProperty("Xpath.vehicleIntDetailPage")));
		String vehIntDetail = vehinterior.getText();

		WebElement vehPower= driver.findElement(By.xpath(objValue.getProperty("Xpath.vehiclepowerDetailPage")));
		String vehPowerDetail = vehPower.getText();

		WebElement vehDealer= driver.findElement(By.xpath(objValue.getProperty("Xpath.vehicleDealerDetailPage")));
		String vehDealerDetail = vehDealer.getText();


		reportStep(vehNameResultpage+" Vehicle Name in the vehicle Result page is displaying properly", "PASS");

		reportStep(vehNameResultPrice+" Vehicle Price in the vehicle Result page is displayed properly", "PASS");


		if(vehNameResultDealer.equalsIgnoreCase(vehDealerDetail)) {
			reportStep(vehNameResultDealer+" Vehicle Dealer in the vehicle Result page is matching with the" +vehDealerDetail+ " vehicle Dealer in the Vehicle details page", "PASS");

		}
		else {
			reportStep(vehNameResultDealer+" Vehicle Dealer in the vehicle Result page is not matching with the" +vehDealerDetail+ " vehicle Dealer in the Vehicle details page", "FAIL");


		}
		/*if(selTrim.equalsIgnoreCase(vehTrimDetail)) {
		reportStep(selTrim+" Vehicle Trim in the vehicle Result page is matching with the" +vehTrimDetail+ " vehicle Dealer in the Vehicle details page", "PASS");

	}
	else {
		reportStep(selTrim+" Vehicle Trim in the vehicle Result page is not matching with the" +vehTrimDetail+ " vehicle Dealer in the Vehicle details page", "FAIL");


	}*/
		/*if(selExColo.equalsIgnoreCase(vehExtDetail)) {
			reportStep(selExColo+" Vehicle Exterior color in the vehicle Result page is matching with the" +vehExtDetail+ " vehicle Exterior color in the Vehicle details page", "PASS");

		}
		else {
			reportStep(selExColo+" Vehicle Exterior color in the vehicle Result page is not matching with the" +vehExtDetail+ " vehicle Exterior color in the Vehicle details page", "FAIL");


		}
		if(selInColo.equalsIgnoreCase(vehIntDetail)) {
			reportStep(selInColo+" Vehicle Interior color in the vehicle Result page is matching with the" +vehIntDetail+ " vehicle Interior color in the Vehicle details page", "PASS");

		}
		else {
			reportStep(selInColo+" Vehicle Interior color in the vehicle Result page is not matching with the" +vehIntDetail+ " vehicle Interior color in the Vehicle details page", "FAIL");


		}*/
		if(SelPower.equalsIgnoreCase(vehPowerDetail)) {
			reportStep(SelPower+" Vehicle Power  in the vehicle Result page is matching with the" +vehPowerDetail+ " vehicle Power color in the Vehicle details page", "PASS");

		}
		else {
			reportStep(SelPower+" Vehicle Power  in the vehicle Result page is not matching with the" +vehPowerDetail+ " vehicle Power color in the Vehicle details page", "FAIL");


		}
		/*if(selpackage.equalsIgnoreCase(vehPackageDetail)) {
		reportStep(selpackage+" in the vehicle Result page is matching with the" +vehPackageDetail+ " vehicle Package  in the Vehicle details page", "PASS");

	}
	else {
		reportStep(selpackage+" in the vehicle Result page is not matching with the" +vehPackageDetail+ " vehicle Package  in the Vehicle details page", "FAIL");


	}*/



		return this;


	}
	//----------------------------Auto Shows-Leads-----------------------
	public Leads autoLinkClick(String Testcasenumber) throws InterruptedException {
		/*closeWelcomePopup();
		closeNotificationPopup();*/
		scrollElement(objValue.getProperty("xpath.autoshowLink"));
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.autoshowLink")))!=null) {
			clickByXpathjs(objValue.getProperty("xpath.autoshowLink"), "Autoshows link is clicked");
			reportStep("Autoshows link is clicked from Footer", "PASS", true);
		}

		else {
			reportStep("Autoshows link is not clicked from Footer", "FAIL", true);
		}
		return this;                 
	}
	public Leads autoShowsNegative(String Testcasenumber) throws InterruptedException {
		scrollElement(objValue.getProperty("xpath.firstNameAutoShows"));
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.firstNameAutoShows")))!=null)
		{
			clickByXpathjs(objValue.getProperty("xpath.submit"), "Submit button is clicked");
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.firstNameErrorAutoShows", "firstName Negative")))!=null) 
			{
				reportStep("error message displayed for Empty FirstName Field", "Pass");
			}
			else
			{
				reportStep("error message not displayed for Empty FirstName Field", "FAIL");    
			}
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.lastNameErrorAutoShows", "lastName Negative")))!=null) 
			{
				reportStep("error message displayed for Empty LastName Field", "Pass");
			}
			else
			{
				reportStep("error message not displayed for Empty LastName Field", "FAIL");     
			}
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.emailErrorAutoShows", "EMail Negative")))!=null) 
			{
				reportStep("error message displayed for Empty EMail Field", "Pass");
			}
			else
			{
				reportStep("error message not displayed for Empty EMail Field", "FAIL");              
			}
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.zipErrorAutoShows", "EMail Negative")))!=null) 
			{
				reportStep("error message displayed for Empty ZipCode Field", "Pass");
			}
			else
			{
				reportStep("error message not displayed for Empty ZipCode Field", "FAIL");         
			}

		}
		else
		{
			reportStep("firstName not displayed", "FAIL");  
		}


		return this;

	}
	public Leads autoPage(String Testcasenumber) throws IOException, InterruptedException {
		closeWelcomePopup();
		String pageheader = ReadExcelData.getdata(Testcasenumber, "AutoshowsHeader");
		System.out.println("Autoshow page is "+pageheader);



		if(driver.findElement(By.xpath(objValue.getProperty("xpath.pageAuto")))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.pageAuto"),pageheader);
			reportStep("Autoshows page is verified properly", "PASS", true);
		}

		else {
			reportStep("Autoshows page is not verified properly", "FAIL", true);
		}                       
		return this;

	}

	public Leads KeepInForm(String Testcasenumber) throws IOException {
		scrollElement(objValue.getProperty("xpath.keepForm"));
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.firstNameAutoShows")))!=null) {
			String firstName = ReadExcelData.getdata(Testcasenumber, "FirstName");
			enterByXpath(objValue.getProperty("xpath.firstNameAutoShows"), firstName, "First Name is entered");

			String lastName = ReadExcelData.getdata(Testcasenumber, "LastName");
			enterByXpath(objValue.getProperty("xpath.lastNameAutoShows"), lastName, "Last Name is entered");

			String email = ReadExcelData.getdata(Testcasenumber, "Email");
			enterByXpath(objValue.getProperty("xpath.emailAutoShows"), email, "Email Address is entered");

			String zip = ReadExcelData.getdata(Testcasenumber, "Zipcode");
			enterByXpath(objValue.getProperty("xpath.zipAutoShows"), zip, "Zip Code is entered");
			reportStep("Zip Code is entered properly", "PASS", true);                                              

			clickByXpathjs(objValue.getProperty("xpath.submit"), "Submit button is clicked");
			reportStep("Submit button is clicked properly", "PASS", true);
		}
		else {
			reportStep("First Name Field Not Found", "FAIL", true);
		}
		sleepTime(20);
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.thankYou")))!=null){
			String thankYouMessage = ReadExcelData.getdata(Testcasenumber, "Message");
			System.out.println("Thank You message is "+thankYouMessage);
			String textByXpath = getTextByXpath(objValue.getProperty("xpath.thankYou"));
			String trimmsg = textByXpath.trim();
			if(trimmsg.equals(thankYouMessage)) {
				reportStep("Thank You message displayed", "PASS", true);

			/*String thankYouMessage = ReadExcelData.getdata(Testcasenumber, "Message");
			System.out.println("Thank You message is "+thankYouMessage);

			verifyTextByXpath(objValue.getProperty("xpath.thankYou"),thankYouMessage);
			reportStep("Thank You message displayed", "PASS", true);*/
		}
		else {
			reportStep("Thank You message not displayed", "FAIL", true);
		}
		}
		return this;
	} 


	public Leads mailValidationsAutoShows(String Testcasenumber) throws IOException {
		sleepTime(10);
		System.out.println("100");
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.autoShowsSelectMail", "autoShowsSelectMail")))!=null) 
		{
			clickByXpathjs(objValue.getProperty("xpath.autoShowsSelectMail"), "autoShowsSelectMail");
			sleepTime(40);

			if(driver.findElement(By.xpath(objValue.getProperty("xpath.userName", "userName")))!=null) 
			{
				String actualUserName=driver.findElement(By.xpath(objValue.getProperty("xpath.userName", "UserName"))).getText();
				String expectedUserName=ReadExcelData.getdata(Testcasenumber,"firstName");
				if(actualUserName.contains(expectedUserName)) {
					reportStep("UserName matches with Mail", "PASS");      
				}
				else 
				{
					reportStep("UserName not matches with Mail", "FAIL");
					switchToParentWindow();
				}
			}
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailContent", "mailContent")))!=null) 
			{
				String mailContent=driver.findElement(By.xpath(objValue.getProperty("xpath.mailContent"))).getText();
				System.out.println(mailContent);
				String actualMailContent="Thanks for signing up. We’ll let you know the latest on the all-new Hyundai Sonata, including when it arrives in dealerships.";
				if(mailContent.contains(actualMailContent)) 
				{
					reportStep("Mail Content matched with Expected Content ", "PASS");     
				}
				else
				{
					reportStep("Mail Content matched with Expected Content ", "FAIL");       
				}
			}
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailHyundaiLinkOne", "mailHyundaiLinkOne")))!=null) 
			{
				clickByXpathjs(objValue.getProperty("xpath.mailHyundaiLinkOne"),"mailHyundaiLinkOne");
				switchToLastWindow();
				sleepTime(100);
				if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailHyundaiLinkOnePage", "mailHyundaiLinkOnePage")))!=null) 
				{
					reportStep("Navigate to Hyundai Page", "PASS");              
					closeBrowser();
					switchToParentWindow();
				}
				else 
				{
					reportStep("Navigate to Hyundai Page", "FAIL");
					switchToParentWindow();
				}
			}
			else 
			{
				reportStep("autoShowsSelectMail not Displayed", "FAIL");            
			}
		}
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyundaiSite", "mailLinkHyundaiSite")))!=null) 
		{
			clickByXpathjs(objValue.getProperty("xpath.mailLinkHyundaiSite"),"mailLinkHyundaiSite");
			switchToLastWindow();
			sleepTime(30);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailHyundaiLinkOnePage", "mailHyundaiLinkOnePage")))!=null) 
			{
				reportStep("Navigate to Hyundai Page", "PASS");
				closeBrowser();
				switchToParentWindow();
			}
			else 
			{
				reportStep("Navigate to Hyundai Page", "FAIL");
				switchToParentWindow();
			}              
		}

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyunaiTwitter", "mailLinkHyunaiTwitter")))!=null) 
		{
			clickByXpathjs(objValue.getProperty("xpath.mailLinkHyunaiTwitter"),"mailLinkHyunaiTwitter");
			switchToLastWindow();
			sleepTime(30);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyunaiTwitterpage", "mailLinkHyunaiTwitterpage")))!=null) 
			{
				reportStep("Navigate to Hyundai Twitter Page", "PASS");               
				closeBrowser();
				switchToParentWindow();
			}
			else 
			{
				reportStep("Navigate to Hyundai Twitter Page", "FAIL");
				switchToParentWindow();
			}
		}
		return this;

	}

	public Leads socialMediaLinks(String Testcasenumber) throws IOException {
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyundaiInstagram", "mailLinkHyundaiInstagram")))!=null) 
		{
			clickByXpathjs(objValue.getProperty("xpath.mailLinkHyundaiInstagram"),"mailLinkHyundaiInstagram");
			switchToLastWindow();
			sleepTime(30);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyundaiInstagramPage", "mailLinkHyundaiInstagramPage")))!=null) 
			{
				reportStep("Navigate to Hyundai Instagram Page", "PASS");         
				closeBrowser();
				switchToParentWindow();
			}
			else 
			{
				reportStep("Navigate to Hyundai Instagram Page", "FAIL");
				switchToParentWindow();
			}              
		}
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyunaiFacebook", "mailLinkHyunaiFacebook")))!=null) 
		{
			clickByXpathjs(objValue.getProperty("xpath.mailLinkHyunaiFacebook"),"mailLinkHyunaiFacebook");
			switchToLastWindow();
			sleepTime(30);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyunaiFacebookPage", "mailLinkHyunaiFacebookPage")))!=null) 
			{
				reportStep("Navigate to Hyundai FaceBook Page", "PASS");          
				closeBrowser();
				switchToParentWindow();
			}
			else 
			{
				reportStep("Navigate to Hyundai FaceBook Page", "FAIL");
				closeBrowser();
				switchToParentWindow();
			}              
		}
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyunaiYoutube", "mailLinkHyunaiYoutube")))!=null) 
		{
			clickByXpathjs(objValue.getProperty("xpath.mailLinkHyunaiYoutube"),"mailLinkHyunaiYoutube");
			switchToLastWindow();
			sleepTime(30);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyunaiYoutubePage", "mailLinkHyunaiYoutubePage")))!=null) 
			{
				reportStep("Navigate to Hyundai Youtube Page", "PASS");            
				closeBrowser();
				switchToParentWindow();
			}
			else 
			{
				reportStep("Navigate to Hyundai Youtube Page", "FAIL");
				closeBrowser();
				switchToParentWindow();
			}              
		}
		return this;

	}
	//---------Offers RAQ_--------------------------
	public Leads offersPageIoniq(String Testcasenumber) throws IOException, InterruptedException, AWTException {
		/*closeWelcomePopup();
		closeNotificationPopup();*/
		zipValueEnter();
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.offers", "offers")))!=null)
		{
			sleepTime(20);
			try {
				clickByXpathjs(objValue.getProperty("xpath.offers", "Offer"), "Offer Button");
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}      
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.viewDetailsioniq", "viewDetailsIoniq")))!=null)
			{
				clickByXpathjs(objValue.getProperty("xpath.viewDetailsioniq"), "viewDetailsIoniq Button");
			}
			else
			{
				reportStep("viewDetails Button not displayed", "FAIL");   
			}
			sleepTime(10);

		}
		else
		{
			reportStep("Offers Button not displayed", "FAIL");
		}
		return this;

	}
	public Leads offersPageAccent(String Testcasenumber) throws IOException, InterruptedException, AWTException {
		/*closeWelcomePopup();
		closeNotificationPopup();*/
		zipValueEnter();
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.offers", "offers")))!=null)
		{
			sleepTime(20);
			try {
				clickByXpathjs(objValue.getProperty("xpath.offers", "Offer"), "Offer Button");
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}      
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.viewDetails", "viewDetails")))!=null)
			{
				clickByXpathjs(objValue.getProperty("xpath.viewDetails"), "viewDetails Button");
			}
			else
			{
				reportStep("viewDetails Button not displayed", "FAIL");   
			}
			sleepTime(10);

		}
		else
		{
			reportStep("Offers Button not displayed", "FAIL");
		}
		return this;

	}
	public Leads negativeFirstName(String Testcasenumber) throws IOException, InterruptedException {
		zipValueEnter();

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.firstName", "FirstName")))!=null)
		{


			clickByXpathjs(objValue.getProperty("xpath.selectEmail"), "selectEmail Button");                

			clickByXpathjs(objValue.getProperty("xpath.selectComment"), "selectComment Button");                
			enterByXpath(objValue.getProperty("xpath.comments"),ReadExcelData.getdata(Testcasenumber,"comments"), "comments");
			sleepTime(10);
			clickByXpathjs(objValue.getProperty("xpath.rateAQuote"), "rateAQuote Button");
		}
		sleepTime(20);
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.firstNameError", "firstName Negative")))!=null) 
		{
			reportStep("error message displayed for Empty FirstName Field", "Pass");
		}
		else
		{
			reportStep("firstName textField not displayed", "FAIL"); 
		}
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.lastNameError", "lastName Negative")))!=null) 
		{
			reportStep("error message displayed for Empty LastName Field", "Pass");
		}
		else
		{
			reportStep("firstName textField not displayed", "FAIL"); 
		}
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.EMailError", "EMail Negative")))!=null) 
		{
			reportStep("error message displayed for Empty EMail Field", "Pass");
		}
		else
		{
			reportStep("firstName textField not displayed", "FAIL"); 
		}
		return this;
	}


	public Leads rateQuoteForm(String Testcasenumber) throws IOException {

		try {
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.firstName", "firstName")))!=null)
			{
				enterByXpath(objValue.getProperty("xpath.firstName"),ReadExcelData.getdata(Testcasenumber,"FirstName"), "firstName");
				enterByXpath(objValue.getProperty("xpath.lastName"),ReadExcelData.getdata(Testcasenumber,"LastName"), "lastName");
				enterByXpath(objValue.getProperty("xpath.email"),ReadExcelData.getdata(Testcasenumber,"Email"), "Email");              
				enterByXpath(objValue.getProperty("xpath.comments"),ReadExcelData.getdata(Testcasenumber,"comments"), "comments");
				sleepTime(10);
				clickByXpathjs(objValue.getProperty("xpath.offerRAQButton"), "rateAQuote Button");
				sleepTime(20);
				if(driver.findElement(By.xpath(objValue.getProperty("xpath.quoteSuccess", "quoteSuccess")))!=null)
				{
					reportStep("Rate a Quote", "PASS");
				}
				else {
					reportStep("Rate a Quote", "FAIL");
				}
			}
			else 
			{
				reportStep("firstName textField not displayed", "FAIL");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}

		return this;

	}
	public Leads yahooMailLogin(String Testcasenumber) throws IOException {

		try {
			driver.get((prop.getProperty("urlYahooLogin")));
			reportStep("Launch Yahoo Mail Login Page", "Pass");
		}
		catch(Exception e) {

			reportStep("Launch Yahoo Mail Login Page"+e, "FAIL");
		}
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLoginId", "Yahoo LogIn ID")))!=null) {
			enterByXpath(objValue.getProperty("xpath.mailLoginId"),ReadExcelData.getdata(Testcasenumber,"Email"), "LogInID");
			clickByXpathjs(objValue.getProperty("xpath.mailNextButton"), "mailNextButton");
			enterByXpath(objValue.getProperty("xpath.mailPassword"),ReadExcelData.getdata(Testcasenumber,"Password"), "mailPassword");
			clickByXpathjs(objValue.getProperty("xpath.mailButtonSignIn"), "ButtonSignIn");
			sleepTime(10);
			clickByXpathjs(objValue.getProperty("Xpath.emailLink"), "Email Link");
			sleepTime(10);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailInboxPage", "InboxPage")))!=null) 
			{
				reportStep("Landed in Yahoo mail Page", "PASS");
			}
			else
			{
				reportStep("Landed in Yahoo mail Page", "FAil");
			}
		}
		else
		{
			reportStep("Yahoo Login ID field not Found", "FAIL");
		}

		return this;

	}
	public Leads mailValidations(String Testcasenumber) throws IOException {
		sleepTime(10);
		String vehNameExpected = ReadExcelData.getdata(Testcasenumber, "expectedVehicleName");
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.selectMail", "selectMail")))!=null) 
		{

			clickByXpathjs(objValue.getProperty("xpath.selectMail"), "selectMail");
			String vehicleName=driver.findElement(By.xpath(objValue.getProperty("xpath.mailVehicleName"))).getText();
			System.out.println(vehicleName);
			if(vehicleName.contains(vehNameExpected)) 
			{
				reportStep(vehicleName+" Vehicle Name matched with RAQ submitted and Mail Triggered ", "PASS");               
			}
			else
			{
				reportStep(vehicleName+" Vehicle Name is not matched with RAQ submitted and Mail Triggered ", "FAIL");        
			}
		}
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailOffers", "mailOffers")))!=null) 
		{
			clickByXpathjs(objValue.getProperty("xpath.mailOffers"),"mailOffers");
			switchToLastWindow();
			sleepTime(30);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.offerPageVerify", "mailOffersPage")))!=null) 
			{
				reportStep("Navigate to Offers Page", "PASS");  
				closeBrowser();
				switchToParentWindow();

			}
			else 
			{
				reportStep("Navigate to Offers Page", "FAIL");
				switchToParentWindow();
			}


			if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailBuildPrice", "mailBuildPrice")))!=null) 
			{
				clickByXpathjs(objValue.getProperty("xpath.mailBuildPrice"),"mailBuildPrice");
				switchToLastWindow();
				sleepTime(30);
				if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailBuildPricePage", "mailBuildPricePage")))!=null) 
				{
					reportStep("Navigate to BuildPrice Page", "PASS");
					closeBrowser();
					switchToParentWindow();
				}
				else 
				{
					reportStep("Navigate to BuildPrice Page", "FAIL");
					switchToParentWindow();
				}
				if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailInventory", "mailInventory")))!=null) 
				{
					clickByXpathjs(objValue.getProperty("xpath.mailInventory"),"Inventory");
					switchToLastWindow();
					sleepTime(60);
					if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailInventoryPage", "mailInventoryPage")))!=null) 
					{
						reportStep("Navigate to Inventory Page", "PASS");
						closeBrowser();
						switchToParentWindow();
					}
					else 
					{
						reportStep("Navigate to Inventory Page", "FAIL");
						switchToParentWindow();
					}
				}
				if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailHyundaiLinkOne", "mailHyundaiLinkOne")))!=null) 
				{
					clickByXpathjs(objValue.getProperty("xpath.mailHyundaiLinkOne"),"mailHyundaiLinkOne");
					switchToLastWindow();
					sleepTime(100);
					if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailHyundaiLinkOnePage", "mailHyundaiLinkOnePage")))!=null) 
					{
						reportStep("Navigate to Hyundai Page", "PASS");              
						closeBrowser();
						switchToParentWindow();
					}
					else 
					{
						reportStep("Navigate to Hyundai Page", "FAIL");
						switchToParentWindow();
					}
				}
				else 
				{
					reportStep("Offers not Displayed", "FAIL");          
				}
			}


		}
		return this;
	}
	public Leads socialLinkMail(String Testcasenumber) throws IOException {
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.selectMail", "selectMail")))!=null) 
		{

			clickByXpathjs(objValue.getProperty("xpath.selectMail"), "selectMail");
		}
		sleepTime(10);
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkMap", "mailLinkMap")))!=null) 
		{
			clickByXpathjs(objValue.getProperty("xpath.mailLinkMap"),"LinkMap");
			switchToLastWindow();
			sleepTime(100);
			String title = driver.getTitle();
			verifyTitle(title);
			reportStep("Navigate to Maps Page", "PASS");   
			closeBrowser();
			switchToParentWindow();	
			             
		}
		
		if(driver.findElementByXPath(objValue.getProperty("xpath.mailLinkDealerIcon"))!=null) {
			clickByXpath(objValue.getProperty("xpath.mailLinkDealerIcon"), "Dealer icon");
			switchToLastWindow();
			String title = driver.getTitle();
			verifyTitle(title);
			reportStep("Navigate to Dealer Site Page", "PASS");   
			closeBrowser();
			switchToParentWindow();
		}
		
		else {
			reportStep("Unable to navigate to Dealer Site Page", "FAIL");   	
		}
		

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyundaiSite", "mailLinkHyundaiSite")))!=null) 
		{
			clickByXpathjs(objValue.getProperty("xpath.mailLinkHyundaiSite"),"mailLinkHyundaiSite");
			switchToLastWindow();
			sleepTime(30);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailHyundaiLinkOnePage", "mailHyundaiLinkOnePage")))!=null) 
			{
				reportStep("Navigate to Hyundai Page", "PASS");
				closeBrowser();
				switchToParentWindow();
			}
			else 
			{
				reportStep("Navigate to Hyundai Page", "FAIL");
				switchToParentWindow();
			}              
		}

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyunaiTwitter", "mailLinkHyunaiTwitter")))!=null) 
		{
			clickByXpathjs(objValue.getProperty("xpath.mailLinkHyunaiTwitter"),"mailLinkHyunaiTwitter");
			switchToLastWindow();
			sleepTime(30);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyunaiTwitterpage", "mailLinkHyunaiTwitterpage")))!=null) 
			{
				reportStep("Navigate to Hyundai Twitter Page", "PASS");                
				closeBrowser();
				switchToParentWindow();
			}
			else 
			{
				reportStep("Navigate to Hyundai Twitter Page", "FAIL");
				switchToParentWindow();
			}

		}
		return this;
	}
	public Leads emailLinksNav(String Testcasenumber) throws IOException {
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyundaiInstagram", "mailLinkHyundaiInstagram")))!=null) 
		{
			clickByXpathjs(objValue.getProperty("xpath.mailLinkHyundaiInstagram"),"mailLinkHyundaiInstagram");
			switchToLastWindow();
			sleepTime(30);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyundaiInstagramPage", "mailLinkHyundaiInstagramPage")))!=null) 
			{
				reportStep("Navigate to Hyundai Instagram Page", "PASS");                
				closeBrowser();
				switchToParentWindow();
			}
			else 
			{
				reportStep("Navigate to Hyundai Instagram Page", "FAIL");
				switchToParentWindow();
			}              
		}
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyunaiFacebook", "mailLinkHyunaiFacebook")))!=null) 
		{
			clickByXpathjs(objValue.getProperty("xpath.mailLinkHyunaiFacebook"),"mailLinkHyunaiFacebook");
			switchToLastWindow();
			sleepTime(30);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyunaiFacebookPage", "mailLinkHyunaiFacebookPage")))!=null) 
			{
				reportStep("Navigate to Hyundai FaceBook Page", "PASS");                
				closeBrowser();
				switchToParentWindow();
			}
			else 
			{
				reportStep("Navigate to Hyundai FaceBook Page", "FAIL");
				closeBrowser();
				switchToParentWindow();
			}              
		}
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyunaiYoutube", "mailLinkHyunaiYoutube")))!=null) 
		{
			clickByXpathjs(objValue.getProperty("xpath.mailLinkHyunaiYoutube"),"mailLinkHyunaiYoutube");
			switchToLastWindow();
			sleepTime(30);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.mailLinkHyunaiYoutubePage", "mailLinkHyunaiYoutubePage")))!=null) 
			{
				reportStep("Navigate to Hyundai Youtube Page", "PASS");                
				closeBrowser();
				switchToParentWindow();
			}
			else 
			{
				reportStep("Navigate to Hyundai Youtube Page", "FAIL");
				closeBrowser();
				switchToParentWindow();
			}              
		}
		return this;
	}
	public Leads  buildandprice(String Testcasenumber) throws InterruptedException
	{
		closeWelcomePopup();
		clickByXpath(objValue.getProperty("xpath.buildandprice"),"buildandprice");
		sleepTime(15);
		verifyTextContainsByXpath(objValue.getProperty("xpath.buildHyundai"),"Build Your Hyundai");
		
		return this;
	}
	//String vehcompare ="";
	int i;
	public Leads comparevehiclelist(String Testcasenumber) throws IOException, InterruptedException
	{
		//closeNotificationPopup();
		  String Vehiclemodelsheet = ReadExcelData.getdata(Testcasenumber,"Vehiclemodel");
		  String Vehiclemodelname = ReadExcelData.getdata(Testcasenumber,"VehicleName");
		  sleepTime(10);
		 /* WebElement closecookie = driver.findElement(By.xpath("//button[@class='cookie-disclaimer-cta button button-navy']"));
			closecookie.click();*/
		 // closeNotificationPopup();
			//Thread.sleep(5000);
		 
	
		  try
		{
			  List<MobileElement> vehiclelist = driver.findElements(By.xpath("((//div[@class='bl-vehicle-card'])/div)"));
			  System.out.println(vehiclelist.size());
		  for ( i=1;i<vehiclelist.size();i++)
		   {			   		   
			  sleepTime(10);
			   WebElement	VehicleName1 =  driver.findElement(By.xpath("((//div[@class='bl-vehicle-card'])/div)["+(i)+"]"));
				System.out.println(VehicleName1);
			 //  String	VehicleName2= getTextByXpath(objValue.getProperty("xpath.vehiclemodelname"));  
			//   xpath.vehiclemodelname=(//div[@class='bl-vehicle-card'])["+(i+1)+"]//span[@class='bl-vehicle-model-name']
			   WebElement	WVehicleName2=  driver.findElement(By.xpath("((//div[@class='bl-vehicle-card'])/div)["+(i)+"]//span[@class='bl-vehicle-model-name']"));
			   String VehicleName2=WVehicleName2.getText().trim();
			   String VehicleName = VehicleName2.replaceAll("[^a-zA-Z0-9]", "");
			   System.out.println(VehicleName);
			  // String	Vehiclemodel1 =  getTextByXpath(objValue.getProperty("xpath.vehiclemodelyear"));  
			   WebElement	WVehicleName1=  driver.findElement(By.xpath("((//div[@class='bl-vehicle-card'])/div)["+(i)+"]//span[@class='bl-vehicle-model-year']"));
			   String Vehiclemodel1=WVehicleName1.getText().trim();
			   String Vehiclemodel = Vehiclemodel1.replaceAll("[^a-zA-Z0-9]", "");
			    vehcompare = VehicleName + Vehiclemodel;
			   String strMain =Vehiclemodelname+Vehiclemodelsheet; 
				/*String[] arrSplit = strMain.split(", ");
				String veharray = arrSplit[i];*/
								
				if(strMain.equals(vehcompare))
				{
				System.out.println("PASS" + strMain + " from the date sheet is matching with the UI vehicle list " + vehcompare);
				reportStep(strMain + " from the date sheet is matching with the UI vehicle list ", "PASS");
				//closeWelcomePopup();
				break;
				}
					
				
		   }
		
		}
		  catch (Exception e)
		{
				e.printStackTrace();
		}
			  		 
			
		      return this;
		  	   
	}
	public Leads selecttrims(String Testcasenumber) throws InterruptedException
	{
		 sleepTime(10);
	closeWelcomePopup();
		//String gettrimnumber= getTextByXpath(objValue.getProperty("xpath.vehiclemodeltrim"));  
		 WebElement	Wgettrimnumber=  driver.findElement(By.xpath(" (((//div[@class='bl-vehicle-card'])/div)["+(i)+"]//parent::div//button)[2]"));

		   String gettrimnumber=Wgettrimnumber.getText().trim();
		  System.out.println("No of Trims" + gettrimnumber ) ;
		  Wgettrimnumber.click();
		//  clickByXpath(objValue.getProperty("xpath.vehiclemodeltrim"),"Click Trims button"); 
		  sleepTime(15);
		  return this;
		  
	}
	
	String trimname="";

	public Leads selectfromtrimarry(String Testcasenumber) throws IOException, InterruptedException
	{
		String Vehicletrim = ReadExcelData.getdata(Testcasenumber,"Trimselection");
		 // Thread.sleep(5000);
		  
		 List<MobileElement> trimlist = driver.findElements(By.xpath("(//ul[@class='bld-dwr-tab-list']//li)"));
		try
		{
			for ( int j=1;j<=trimlist.size();j++)
	
		   {			   		   			
				//WebElement	trimselect =  driver.findElement(By.xpath("(//ul[@class='bld-dwr-tab-list']//li)["+(i+1)+"]"));
				WebElement	trimselect =  driver.findElement(By.xpath("(//ul[@class='bld-dwr-tab-list']//li)["+(j)+"]//span[@class='bld-dwr-model-name']"));
				  trimname=trimselect.getText().trim();
				//trimname= getTextByXpath(objValue.getProperty("xpath.selecttrimname"));  
				System.out.println(trimname);
				 sleepTime(10);
				if(trimname.equalsIgnoreCase(Vehicletrim))
				{
					System.out.println("PASS" + Vehicletrim + " from the date sheet is matching with the UI vehicle trim list " + trimname);
					reportStep(Vehicletrim + " from the date sheet is matching with the UI vehicle trim list ", "PASS");
					sleepTime(10);
					//closeWelcomePopup();
					trimselect.click();
				//	clickByXpath(objValue.getProperty("xpath.selecttrimname"),"selecttrimname");
					sleepTime(10);
			
					clickByXpath(objValue.getProperty("xpath.selectbuild"),"selectbuild");
					break;
					}
					else
					{
						//System.out.println("FAIL" + Vehicletrim + " from the date sheet is NOT matching with the UI vehicletrim list " + trimname);
						//reportStep(Vehicletrim + " from the date sheet is NOT matching with the UI vehicle list ", "FAIL");
					
					}			
			
			}
		}
			catch(Exception e)
			{
				reportStep("Trim page not responding as expected" , "FAIL", true);
			}
	
				
		 return this;
	}
	
	String msrptot="";
	public Leads Buildaccessories(String Testcasenumber) throws InterruptedException
	{
		//sleepTime(10);
		clickByXpath(objValue.getProperty("xpath.accessories"),"accessories");
		sleepTime(10);
		//closeWelcomePopup();
			//	clickByXpath(objValue.getProperty("xpath.defaultaccessories"),"defaultaccessories");
		 if ( ! driver.findElement(By.xpath("//li[@class='bo-choice-list-item'][1]//div[@class='form-checkbox-box']")).isSelected() )
		{
		     driver.findElement(By.xpath("//li[@class='bo-choice-list-item'][1]//div[@class='form-checkbox-box']")).click();
		     System.out.println("Accessories Check box selected");
		}
		 else
		{
			 System.out.println("Accessories Check box already selected");
		}
		msrptot= getTextByXpath(objValue.getProperty("xpath.buildmsrp"));  
		sleepTime(15);
		//clickByXpath(objValue.getProperty("xpath.finishbuild"),"finishbuild");
		WebElement	finishbuild = driver.findElement(By.xpath("(//a[text()='Finish build'])[1]"));
		finishbuild.click();
		return this;
		
	}
	
	public Leads Buildsummarycomapre(String Testcasenumber) throws InterruptedException
	{
		/*Thread.sleep(10000);
		closeWelcomePopup();*/
		String	sumyear= getTextByXpath(objValue.getProperty("xpath.yearsummary"));  
		String	summodel= getTextByXpath(objValue.getProperty("xpath.modelsummary"));  
		String	summtrim= getTextByXpath(objValue.getProperty("xpath.trimsummary"));
		String	msrptotsummary= getTextByXpath(objValue.getProperty("xpath.msrptotsummary"));
		//String	estimatedsummary= getTextByXpath(objValue.getProperty("xpath.estimatedsummary"));
		//String	netpricesummary= getTextByXpath(objValue.getProperty("xpath.netpricesummary"));
		String sumyearmodel =summodel+sumyear;
		String sumyearmodel1 = sumyearmodel.replaceAll("[^a-zA-Z0-9]", "");
		if(sumyearmodel1.equals(vehcompare))
		{
			System.out.println("PASS" + vehcompare + " vehicle model and year matches with summary " + vehcompare);
			reportStep(vehcompare + " vehicle model and year matches with summary ", "PASS");
						if(summtrim.equals(trimname))
						
							{
							System.out.println("PASS" + summtrim + " vehicle Trim matches with summary " + trimname);
							
							if(msrptot.equals(msrptotsummary))
							{
								System.out.println("PASS" + msrptot + " MSRP matches with summary " + msrptotsummary);
								reportStep( " MSRP matches with summary BYO summary "+msrptotsummary, "PASS");
								/*if(estimatedsummary.equals(netpricesummary))
								{
									System.out.println("PASS" + estimatedsummary + " net price matches with summary " + netpricesummary);
							}
								else
								{					

									System.out.println("FAIL"+ estimatedsummary + " net price NOT matches with summary " + netpricesummary);
								}*/
							}	
							else
						{
								System.out.println("FAIL" + msrptot + " MSRP NOT matches with summary " + msrptotsummary);
								reportStep( " MSRP not matches with BYO summary "+ msrptotsummary, "FAIL");
						}								
							
						}
						else
						{
	
								System.out.println("FAIL" + summtrim + " vehicle Trim NOT matches with summary " + trimname);
						}
						
						
						
			}
			else
			{
				System.out.println("FAIL" + vehcompare + " vehicle model,year not matches with summary " + sumyearmodel1 );
				
		}
	return this;
	}
	
	public Leads Requestaquote (String Testcasenumber) throws InterruptedException, IOException

	{
		
		
		
		String FNameErrMsg = ReadExcelData.getdata(Testcasenumber, "FNameError");
		String LNameErrMsg = ReadExcelData.getdata(Testcasenumber, "LNameError");
		String EmailAddErrMsg = ReadExcelData.getdata(Testcasenumber, "EmailError");

		clickByXpath(objValue.getProperty("xpath.raq"),"raq");
		sleepTime(30);
		WebElement fNameError = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqErrorFName")));
		WebElement lNameError = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqErrorlName")));
		WebElement emailAddError = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqErrorEmail")));


		String firstNameError = fNameError.getText();
		String lastNameError = lNameError.getText();
		String emailAddressError = emailAddError.getText();


		if(firstNameError.equalsIgnoreCase(FNameErrMsg)) {

			reportStep(firstNameError+"First Name error message displayed properly", "PASS", true);

		}
		else {
			reportStep("Unable to find First Name error message", "FAIL", true);
		}
		if(lastNameError.equalsIgnoreCase(LNameErrMsg)) {

			reportStep(lastNameError+"Last Name error message displayed properly", "PASS", true);

		}
		else {
			reportStep("Unable to find Last Name error message", "FAIL", true);
		}
		if(emailAddressError.equalsIgnoreCase(EmailAddErrMsg)) {

			reportStep(emailAddressError+"Email Address error message displayed properly", "PASS", true);

		}
		else {
			reportStep("Unable to find Email Address error message", "FAIL", true);
		}
		enterByXpath(objValue.getProperty("xpath.firstname"),"TestMichael"," firstname");
		enterByXpath(objValue.getProperty("xpath.lastname"),"TestMichael"," lastname");
		enterByXpath(objValue.getProperty("xpath.raqemail"),"Mybcc20@yahoo.com"," email");
		sleepTime(15);
		clickByXpath(objValue.getProperty("xpath.raq"),"raq");
		/*Thread.sleep(10000);
		String raqsuccessmsg = getTextByXpath(objValue.getProperty("xpath.successraq"));
		System.out.println(raqsuccessmsg);
		String  graqsuccesstxt = getTextByXpath(objValue.getProperty("xpath.successraqtest"));
		String raqsub="Request Submitted";
			if(graqsuccesstxt.equals(raqsub))
		{
			System.out.println( graqsuccesstxt +"Request Submitted successfully");
		}
		
			else
			{
				System.out.println(graqsuccesstxt + "Request NOT Submitted successfully");
				reportStep("Request a Quote" , "FAIL", true);
			}

	*/
			return this;
	}
	
}
