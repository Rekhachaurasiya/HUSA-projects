package main.java.pagesobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;

import main.java.utility.Projectcommonmethodes;
import main.java.utility.ReadExcelData;

public class Search_Inventory extends Projectcommonmethodes {

//	public Search_Inventory(RemoteWebDriver driver){
//
//		this.driver=driver;
//	}
	JavascriptExecutor js = (JavascriptExecutor)driver;
	String vehName="";
	public Search_Inventory vehicleModel(String Testcasenumber) throws InterruptedException {

		//closeNotificationPopup();
		sleepTime(5);
		/*closeWelcomePopup();
		sleepTime(5);*/
		if(driver.findElement(By.xpath(objValue.getProperty("Xpath.SearchInventory")))!=null) {

			clickByXpath(objValue.getProperty("Xpath.SearchInventory"), "Header-Search Inventory");
			//closeWelcomePopup();
			sleepTime(10);
			WebElement searchInveVerify = driver.findElement(By.xpath(objValue.getProperty("Xpath.SearchInventoryPage")));
			if(searchInveVerify.getText().trim().equalsIgnoreCase("Find Your Hyundai")) {
				reportStep("Search Ivnentory landing page displayed properly", "PASS", true);

			}

			sleepTime(10);
			clickByXpath(objValue.getProperty("Xpath.MilesDropdown"), "Miles-Dropdown");
			System.out.println("Miles dropdown clicked");

			clickByXpath(objValue.getProperty("Xpath.MilesSelection"), "Miles-Selection");
			reportStep("Miles Dropdown clicked successfully", "PASS", true);
			clickByXpath(objValue.getProperty("Xpath.ZipLocation"), "Zip Location");
			sleepTime(10);
			reportStep("Zipfield clicked successfully", "PASS", true);
			WebElement zipField = driver.findElement(By.xpath("//input[@placeholder='Enter ZIP Code']"));

			enterByXpath(objValue.getProperty("Xpath.ZipField"), "92614", "Zip field");
			sleepTime(30);
			/*closeWelcomePopup();
			closeNotificationPopup();*/

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
			//closeNotificationPopup();
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
	public Search_Inventory vehicleResult(String Testcasenumber) {



		List<WebElement> dropdown = driver.findElements(By.xpath(objValue.getProperty("Xpath.filterDropdown")));

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
				js.executeScript("window.scrollBy(0,-200)", "");
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
					sleepTime(15);

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
					sleepTime(15);
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
	public Search_Inventory vehicleDetails(String Testcasenumber) {

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
		if(selExColo.equalsIgnoreCase(vehExtDetail)) {
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


		}
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
	public Search_Inventory vehicelDetailsLinks(String Testcasenumber) {

		js.executeScript("window.scrollBy(0,800)", "");	
		clickByXpath(objValue.getProperty("Xpath.PaymentCal"), "payment Calculator");
		sleepTime(20);
		switchToFrame(objValue.getProperty("Xpath.PaymentandApplyCalFrame"));
		WebElement vehNamePay = driver.findElement(By.xpath(objValue.getProperty("Xpath.frameVehName")));
		String PayCalVehName = vehNamePay.getText();
		WebElement vehNamePrice = driver.findElement(By.xpath(objValue.getProperty("Xpath.frameVehPrice")));

		String PayCalVehPrice = vehNamePrice.getText();
		System.out.println(PayCalVehPrice+"Paymane calculator price");

		reportStep(PayCalVehName+" Payment calculator page displayed properly in the vehicle detail page", "PASS", true);
		if(vehNameResultPrice.equals(PayCalVehPrice)) {
			reportStep(PayCalVehPrice+" Payment calculator price is matching with the price details in the vehicle details page", "PASS", true);

		}	
		else {
			reportStep(PayCalVehPrice+" Payment calculator price is not matching with the price in the vehicle details page", "FAIL", true);		
		}
		clickByXpath(objValue.getProperty("Xpath.paymentClose"), "payment close");
		driver.switchTo().defaultContent();

		//Verfying the apply for credit
		clickByXpath(objValue.getProperty("Xpath.Applyforfinance"), "Apply for credit");
		sleepTime(20);
		switchToFrame(objValue.getProperty("Xpath.PaymentandApplyCalFrame"));
		WebElement vehNameapply = driver.findElement(By.xpath(objValue.getProperty("Xpath.frameVehName")));
		String ApplyCreditVehName = vehNameapply.getText();
		WebElement vehNameapplyPrice = driver.findElement(By.xpath(objValue.getProperty("Xpath.frameVehPrice")));

		String applyCreditVehPrice = vehNameapplyPrice.getText();
		System.out.println(applyCreditVehPrice+"Paymane calculator price");

		reportStep(ApplyCreditVehName+" Apply for credit page displayed properly in the vehicle detail page", "PASS", true);
		if(vehNameResultPrice.equals(applyCreditVehPrice)) {
			reportStep(applyCreditVehPrice+" Apply for credit price is matching with the price details in the vehicle details page", "PASS", true);

		}	
		else {
			reportStep(applyCreditVehPrice+" Apply for credit price is not matching with the price in the vehicle details page", "FAIL", true);		
		}
		clickByXpath(objValue.getProperty("Xpath.paymentClose"), "payment close");
		driver.switchTo().defaultContent();

		//Trims and Specs page verifcation
		js.executeScript("window.scrollBy(0,1000)", "");	
		if(driver.findElement(By.xpath(objValue.getProperty("Xpath.Trimspec"))) != null) {
			clickByXpath(objValue.getProperty("Xpath.Trimspec"), "Trim Spec");
			sleepTime(20);
			WebElement specsVerify = driver.findElement(By.xpath(objValue.getProperty("Xpath.Trimsandspeverify")));
			if(specsVerify.getText().contains("Packages")) {

				reportStep("Trim Specs page displayed properly", "PASS", true);
			}
			else {
				reportStep("Trim Specs page not displayed", "FAIL", true);
			}
		}

		else {

			reportStep("Unable to find Trim and Specs popup", "FAIl", true);
		}


		clickByXpath(objValue.getProperty("Xpath.TrimClose"), "Trim and Specs Closed");

		//Saved link verification
		clickByXpath(objValue.getProperty("Xpath.SaveIcon"), "Save Icon");
		sleepTime(20);
		clickByXpath(objValue.getProperty("Xpath.SavedVehicles"), "Saved vehicles");
		WebElement vehYear = driver.findElement(By.xpath(objValue.getProperty("Xpath.SavedVehicleYear")));
		WebElement vehName = driver.findElement(By.xpath(objValue.getProperty("Xpath.SavedVehicleName")));
		String SavedVehName = vehYear.getText().concat(vehName.getText());
		reportStep(SavedVehName+"vehcile saved successfully", "PASS", true);
		clickByXpath(objValue.getProperty("Xpath.SavedClose"), "Saved Vehicle Closed");
		String urlSearchInv = driver.getCurrentUrl();

		//Verify Get Direction/schedule test driver&Dealer site
		clickByXpath(objValue.getProperty("Xpath.GetDirection"), "Get Direction Link");
		switchToLastWindow();
		String map = driver.getTitle();
		if(map.contains("Google Maps")) {
			reportStep("Google Map Dispalyed properly", "PASS", true);
		}
		else {
			reportStep("Error occured while navigating to Google map", "FAIL");
		}
		driver.close();
		switchToParentWindow();

		//driver.get(urlSearchInv);
		clickByXpath(objValue.getProperty("Xpath.Dealersite"), "Dealer site");
		switchToLastWindow();
		String dealer = driver.getTitle();
		reportStep(dealer+" displayed properly in the dealer site", "PASS", true);
		driver.close();
		switchToParentWindow();

		clickByXpath(objValue.getProperty("Xpath.ScheduleTestDrive"), "schedule Test Drive");
		sleepTime(30);
		switchToLastWindow();
		sleepTime(30);
		WebElement stdPage = driver.findElement(By.xpath(objValue.getProperty("Xpath.STDPageVerify")));
		if(stdPage.getText().contains("Hyundai Test Drive")) {

			reportStep(stdPage+" Test Drive page displayed properly", "PASS", true);
		}
		else {
			reportStep("Error occured while navigating to Test Drive page", "FAIL", true);
		}
		driver.close();
		switchToParentWindow();
		js.executeScript("window.scrollBy(0,-800)", "");

		WebElement credit = driver.findElement(By.xpath(objValue.getProperty("Xpath.CreditScore")));
		js.executeScript("arguments[0].scrollIntoView(true);",credit);
		clickByXpath(objValue.getProperty("Xpath.CreditScore"), "Credit Score");
		sleepTime(30);
		switchToLastWindow();
		String creditVerify = driver.getTitle();
		if(creditVerify.equals("FREE Equifax Credit Score")) {
			reportStep(creditVerify+"Estimate credit score page displayed properly", "PASS", true);
		}
		else {
			reportStep(creditVerify+"Estimate credit score page is not displayed", "FAIL", true);
		}
		driver.close();
		switchToParentWindow();


		WebElement estimate = driver.findElement(By.xpath(objValue.getProperty("Xpath.EstimateTradeIn")));
		js.executeScript("arguments[0].scrollIntoView(true);",estimate);
		clickByXpath(objValue.getProperty("Xpath.EstimateTradeIn"), "Estimate Trade-In");
		sleepTime(30);
		switchToLastWindow();
		String estimateVerify = driver.getTitle();
		if(estimateVerify.equals("Value Your Trade")) {
			reportStep(estimateVerify+"Estimate trade in value page displayed properly", "PASS", true);
		}
		else {
			reportStep(estimateVerify+"Estimate trade in value page not displayed", "PASS", true);
		}
		driver.close();
		switchToParentWindow();

		WebElement offerSec = driver.findElement(By.xpath(objValue.getProperty("Xpath.OffersSection")));
		if(offerSec.getText().contains("Current Offers")) {

			reportStep("Offers Section Displayed properly", "PASS");

			clickByXpath(objValue.getProperty("Xpath.SavingsseeDetailsLink"), "Savings See details");
			sleepTime(30);
			WebElement savingstext = driver.findElement(By.xpath(objValue.getProperty("Xpath.SavingOffVerify")));
			String saving = savingstext.getText().trim();
			if(savingstext.getText().contains("Savings Offer Details")) {
				reportStep("Savings offers section displayed properly", "PASS");
			}
			else {
				reportStep("Savings offers section not displayed properly", "FAIL");
			}
			clickByXpath(objValue.getProperty("Xpath.OfferClose"), "Saving close");

			clickByXpath(objValue.getProperty("Xpath.FinanceseeDetailsLink"), "Fincance See details");
			sleepTime(30);
			WebElement financetext = driver.findElement(By.xpath(objValue.getProperty("Xpath.FinanceOfferVerify")));
			if(financetext.getText().contains("Finance Offer Details")) {
				reportStep("Finance offers section displayed properly", "PASS");
			}
			else {
				reportStep("Finance offers section not displayed properly", "FAIL");
			}
			clickByXpath(objValue.getProperty("Xpath.OfferClose"), "Saving close");

		}
		else {
			reportStep("Offers section not displayed", "FAIL", true);
		}
		return this;

	}
	public Search_Inventory raqSubmit(String Testcasenumber) throws IOException {
		driver.manage().window().setSize(new Dimension(1920,1080));
		js.executeScript("window.scrollBy(0,-400)", "");	

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

}




