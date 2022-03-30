package main.java.pagesobject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import main.java.utility.Projectcommonmethodes;
import main.java.utility.ReadExcelData;
import net.bytebuddy.asm.Advice.Local;
import java.util.List;

import org.openqa.selenium.WebElement;

public class LocalOffers extends Projectcommonmethodes{
	String firstModel = "";
	String secondModel = "";
	String offerTypeAfterFilter = "";
	String offerTypeSelectedInFilter = "";
	String zipcode = "";
	String changedZipCode = "";
	String modelOfferPrice = "";
	String modelPrice = "";
	String savingValue = "";
	String savingPage = "";
	String bonusDetailPage = "";
	String bonusDetailPage1 = "";
	String bonusDetailPage2 = "";
	String bonusDetailPage3 = "";
	String modelNameOffersPage = "";
	String APRValue = "";
	String financePage = "";
	String financeDetailPage1 = "";
	String financeDetailPage2 = "";
	String leaseValue = "";
	String LeasePage = "";
	String IventoryModelName = "";
	String exactMatchesInventoryNumber, milesDropdown, ZipCode,Dealer,savingExpiryDate,financeExpiryDate,leaseExpiryDate = "";

	public LocalOffers (RemoteWebDriver driver) throws InterruptedException{
		this.driver = driver;
		closeNotificationPopup();
	} 
	JavascriptExecutor js = (JavascriptExecutor)driver;

	public LocalOffers clickMenu(String Testcasenumber) throws InterruptedException {
		closeWelcomePopup();
		closeNotificationPopup();
		closeWelcomePopup();
	
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.menu")))!=null) {
			clickByXpath(objValue.getProperty("xpath.menu"),"Click Menu" );
			sleepTime(10);
			reportStep("Menu link is clicked", "PASS");

		}
		else {	
			reportStep("Menu link is not clicked", "FAIL");
		}
		return this;

	}

	public LocalOffers offerLink(String Testcasenumber) throws InterruptedException, IOException {
		//closeWelcomePopup();

		sleepTime(10);
		if(driver.findElementByXPath(objValue.getProperty("xpath.offerLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.offerLink"), "Offer link is clicked from Menu");
			reportStep("Offer link is clicked from Menu", "PASS", true);
		}

		else {
			reportStep("Offer link is not clicked from Menu", "FAIL", true);
		}

		String pageTitle = ReadExcelData.getdata(Testcasenumber, "Title");
		if(verifyTitle(pageTitle)) {
			reportStep("Page title is verified", "PASS", true);
		}
		else {
			reportStep("Page title is not verified", "FAIL", true);
		}
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.offerPageVerify"))!=null){
			getTextByXpath(objValue.getProperty("xpath.offerPageVerify"));
			reportStep("Offers Page is verified", "PASS", true);
		}
		else {
			reportStep("Offers Page is not verified", "FAIL", true);
		}

		return this;

	}

	public LocalOffers zipPopup(String Testcasenumber) throws IOException, InterruptedException {
		/*closeNotificationPopup();
		closeWelcomePopup();*/
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.offersZip"))) !=null) {
			clickByXpath(objValue.getProperty("xpath.offersZip"), "Click on zipcode pin popup");
			reportStep("Zip Code Pin is clicked", "PASS", true);
		}

		else {
			reportStep("Zip Code Pin is not clicked", "FAIL", true);
		}

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.zippopup")))!= null) {
			driver.findElement(By.xpath(objValue.getProperty("xpath.zippopup"))).clear();
			sleepTime(10);

			zipcode = ReadExcelData.getdata(Testcasenumber,"Zipcode");

			enterByXpath(objValue.getProperty("xpath.zippopup"), zipcode, "Zipcode value is entered");
			reportStep("Zipcode value is entered properly in the zipcode popup", "PASS", true);

		}
		else {
			reportStep("Zipcode value is not entered properly in the zipcode popup", "FAIL", true);
		}


		if(driver.findElement(By.xpath(objValue.getProperty("xpath.confirm")))!=null) {
			clickByJavaScript(objValue.getProperty("xpath.confirm"), "Confirm button is clicked");
			reportStep("Confirm button is clicked properly", "PASS", true);
		}

		else {
			reportStep("Confirm button is not clicked properly", "FAIL", true);
		}

		sleepTime(60);
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.changedZip")))!=null) {
			changedZipCode = getTextByXpath(objValue.getProperty("xpath.changedZip"));
			if(changedZipCode.equals(zipcode)) {
				reportStep("Zipcode is displayed same", "PASS", true);
			}
		}
		else {
			reportStep("Zipcode is not displayed same", "FAIL", true);

		}

		return this;

	}

	public LocalOffers filterVehicle(String Testcasenumber) throws IOException, InterruptedException {
		/*closeNotificationPopup();
		closeWelcomePopup();*/
		if(driver.findElementByXPath(objValue.getProperty("xpath.filterVehicle"))!=null) {
			clickByXpath(objValue.getProperty("xpath.filterVehicle"), "Vehicle filter button is clicked");
			reportStep("Vehicle filter button is clicked from Filter By section", "PASS", true);
		}
		else {
			reportStep("Vehicle filter button is not clicked from Filter By section", "FAIL", true);
		}

		//Filter: Offer by Vehicle section
		if(driver.findElementByXPath(objValue.getProperty("xpath.currentModel"))!=null) {
			clickByXpath(objValue.getProperty("xpath.currentModel"), "Current Model is clicked");
			reportStep("Current Model is clicked from Filter by vehicle dropdown", "PASS", true);
		}

		else {
			reportStep("Current Model is not clicked from Filter by vehicle dropdown", "PASS", true);
		}		

		firstModel = ReadExcelData.getdata(Testcasenumber, "Model");
		//	secondModel = ReadExcelData.getdata(Testcasenumber, "Model1");
		WebElement vehicleModel1 = driver.findElementByXPath("//span[text()='"+firstModel+"']");
		vehicleModel1.click();


		/*		WebElement vehicleModel2 = driver.findElementByXPath("//span[text()='"+secondModel+"']");
		vehicleModel2.click();*/

		if(driver.findElementByXPath(objValue.getProperty("xpath.vehicleDoneButton"))!=null) {
			clickByXpath(objValue.getProperty("xpath.vehicleDoneButton"), "Done button is clicked");
			reportStep("Done button is clicked from vehicle filter dropdown", "PASS", true);
		}		
		else {
			reportStep("Done button is not clicked from vehicle filter dropdown", "FAIL", true);
		}

		sleepTime(100);
		if(driver.findElementByXPath(objValue.getProperty("xpath.firstVehicle"))!=null) {
			String firstSelectedModel = getTextByXpath(objValue.getProperty("xpath.firstVehicle"));
			if(firstSelectedModel.equals(firstModel)) {
				System.out.println("First Model selected from filter is " +firstModel+ " and Model selected after filter is " +firstSelectedModel+ " same");
			}
			reportStep("Selected first model from filter is displayed", "PASS", true);

		}
		else {
			reportStep("Selected first model from filter is not displayed", "PASS", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.offerModelName"))!=null) {
			String modelNameOffersPage = getTextByXpath(objValue.getProperty("xpath.offerModelName"));
			reportStep("Model name is displayed in the Offers page is "+modelNameOffersPage, "PASS", true);
		}
		else {
			reportStep("Model name is not displayed in the Offers page is "+modelNameOffersPage, "PASS", true);
		}
		return this;
	}

	public LocalOffers priceValidation(String Testcasenumber) throws InterruptedException {
		//closeNotificationPopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.offerPrice"))!=null) {
			modelOfferPrice = getTextByXpath(objValue.getProperty("xpath.offerPrice"));
			modelPrice = modelOfferPrice.replaceAll("[^\\d+$,]", "");
			System.out.println("Model price value is after replacing is "+modelPrice);
			reportStep("Price is displayed under the vehicle model "+modelPrice, "PASS", true);
		}

		else {
			reportStep("Price is not displayed under the vehicle model", "FAIL", true);
		}


		/*		if(driver.findElementByXPath(objvalue.getProperty("xpath.secondVehicle"))!=null) {
			String secondSelectedModel = getTextByXpath(objvalue.getProperty("xpath.secondVehicle"));
			if(secondSelectedModel.equals(secondModel)) {
				System.out.println("Second Model selected from filter is " +secondModel+ " and Model selected after filter is " +secondSelectedModel+ " same");
			}
			reportStep("Selected second model from filter is displayed", "PASS", true);

		}
		else {
			reportStep("Selected second model from filter is not displayed", "PASS", true);
		}*/

		return this;
	}

	public LocalOffers firstModelDisplay(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.firstOffer"))!=null) {
			boolean firstOfferDisplay = driver.findElementByXPath("(//div[@class='og-row'])[1]").isDisplayed();
			reportStep("First Offer is displayed "+firstOfferDisplay, "PASS", true);	
		}
		else {
			reportStep("First Offer is not displayed", "FAIL", true);
		}
		return this;

	}

	/*public LocalOffers viewDetailsButtonClick(String Testcasenumber) throws IOException, InterruptedException {
		LocalOffers ob = new LocalOffers(driver);
	if(driver.findElementByXPath(objValue.getProperty("xpath.offerPrice"))!=null) {
			ob.priceValidation(Testcasenumber);
			reportStep("Model Price is displayed from offers page", "PASS", true);
		
	}
	else {
		reportStep("Model Price is not displayed from offers page", "FAIL", true);	
	}
	
	List <WebElement> viewDetailsButton = driver.findElementsByXPath(objValue.getProperty("xpath.viewDetailButtonCTA"));
	for(int i=0;i<viewDetailsButton.size();i++) {
		try {
			if(i == 1) {
				
					ob.savingOffers(Testcasenumber);
					ob.savingDetailsPage(Testcasenumber);
					ob.offerRAQInfo(Testcasenumber);
					ob.offerInventorySection(Testcasenumber);
					ob.offerSeeInventory(Testcasenumber);
					ob.dealerShipSection(Testcasenumber);
					ob.offerGetDirection(Testcasenumber);
					ob.offerVisitDealer(Testcasenumber);
					ob.offerSTD(Testcasenumber);
					ob.offerTestDrive(Testcasenumber);		
					reportStep("Saving offer is dispalyed", "PASS", true);
					driver.navigate().back();
					ob.filterVehicle(Testcasenumber);
						
			}
			else if(i == 2) {
				ob.financeOffer(Testcasenumber);
				ob.financeDetailsPage(Testcasenumber);
				ob.offerRAQInfo(Testcasenumber);
				ob.offerInventorySection(Testcasenumber);
				ob.offerSeeInventory(Testcasenumber);
				ob.dealerShipSection(Testcasenumber);
				ob.offerGetDirection(Testcasenumber);
				ob.offerVisitDealer(Testcasenumber);
				ob.offerSTD(Testcasenumber);
				ob.offerTestDrive(Testcasenumber);
				reportStep("Finance offer is dispalyed", "PASS", true);
				driver.navigate().back();
				ob.filterVehicle(Testcasenumber);
			}
			else if(i == 3){
				ob.leaseOffers(Testcasenumber);
				ob.leaseDetailsPage(Testcasenumber);
				ob.offerRAQInfo(Testcasenumber);
				ob.offerInventorySection(Testcasenumber);
				ob.offerSeeInventory(Testcasenumber);
				ob.dealerShipSection(Testcasenumber);
				ob.offerGetDirection(Testcasenumber);
				ob.offerVisitDealer(Testcasenumber);
				ob.offerSTD(Testcasenumber);
				ob.offerTestDrive(Testcasenumber);
				reportStep("Lease offer is dispalyed", "PASS", true);
				driver.navigate().back();
				ob.filterVehicle(Testcasenumber);
			}				
			
			else {
				reportStep("Offers cards are not displayed", "FAIL", true);
			}
			
		} catch (Exception e) {
			
				reportStep("Offer cards are not displayed "+e, "FAIL");
		}
	}
		return this;
	}*/

	public LocalOffers filterOfferType(String Testcasenumber) throws InterruptedException {
		/*closeNotificationPopup();
		closeWelcomePopup();*/
		//Filter: Offer by Type section
		if(driver.findElementByXPath(objValue.getProperty("xpath.filterOfferType"))!=null) {
			clickByXpath(objValue.getProperty("xpath.filterOfferType"), "Vehicle filter button is clicked");
			reportStep("Offer Type filter button is clicked from Filter By section", "PASS", true);
		}
		else {
			reportStep("Offer Type filter button is not clicked from Filter By section", "FAIL", true);
		}
		if(driver.findElementByXPath(objValue.getProperty("xpath.offerType"))!=null) {
			clickByXpath(objValue.getProperty("xpath.offerType"), "Savings Offer Type is selected");
			offerTypeSelectedInFilter = getTextByXpath(objValue.getProperty("xpath.offerType"));
			reportStep("Savings Offer Type is selected", "PASS", true);
		}
		else {
			reportStep("Savings Offer Type is not selected", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.offerDoneButton"))!=null) {
			clickByXpath(objValue.getProperty("xpath.offerDoneButton"), "Done button is clicked");
			reportStep("Done button is clicked from offer type filter dropdown", "PASS", true);
		}		
		else {
			reportStep("Done button is not clicked from offer type filter dropdown", "FAIL", true);
		}

		sleepTime(20);
		if(driver.findElementByXPath(objValue.getProperty("xpath.offerTypeVerify"))!=null) {
			offerTypeAfterFilter = getTextByXpath(objValue.getProperty("xpath.offerTypeVerify"));
			if(offerTypeAfterFilter.equalsIgnoreCase(offerTypeSelectedInFilter)) {
				System.out.println("offer type is "+offerTypeAfterFilter+ " and " +offerTypeSelectedInFilter);
				reportStep("Offer Type displayed in the filter dropdown " +offerTypeSelectedInFilter+ " is same as offer type displayed " 
						+offerTypeAfterFilter+ " in the Offers page" , "PASS", true);
			}
		}

		else {
			reportStep("Offer Type is not displayed properly in the Offers page" , "FAIL", true);

		}
		System.out.println("Offer TC completed");
		
		return this;

	}

	public LocalOffers savingOffers(String Testcasenumber) throws IOException, InterruptedException {
		closeNotificationPopup();
		//closeWelcomePopup();*/
		if(driver.findElementByXPath(objValue.getProperty("xpath.bonus"))!=null) {
			getTextByXpath(objValue.getProperty("xpath.bonus"));
			savingValue = getTextByXpath(objValue.getProperty("xpath.bonusValue"));
			reportStep("Saving Offer Value is " +savingValue+ " displayed under Bonus Cash" , "PASS", true);
		}

		else {
			reportStep("Saving Offer Value is not displayed under Bonus Cash", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.savingExpiry"))!=null) {
			String savExpiryDate = getTextByXpath(objValue.getProperty("xpath.savingExpiry"));
			savingExpiryDate = savExpiryDate.replaceAll("[^\\d+/]", "");
			reportStep("Saving Expiry date is " +savingExpiryDate+ " displayed properly" , "PASS", true);
		}

		else {
			reportStep("Saving Expiry date is not displayed properly", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.savingViewDetailsButton"))!=null) {
			clickByXpath(objValue.getProperty("xpath.savingViewDetailsButton"),"View Details button is clicked");
			reportStep("View Details button is clicked for Saving Offer", "PASS", true);
		}
		else {
			reportStep("View Details button is not clicked for Saving Offer", "FAIL", true);
		}
		return this;

	}

	public LocalOffers savingDetailsPage(String Testcasenumber) throws IOException, InterruptedException {
		/*closeNotificationPopup();
		closeWelcomePopup();*/
		if(driver.findElementByXPath(objValue.getProperty("xpath.detailsPageVerify"))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.detailsPageVerify"), "Savings");
			reportStep("Saving Offer page is verified", "PASS", true);
		}

		else {
			reportStep("Saving Offer page is not verified", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.offerImage"))!=null) {
			boolean financeImage = driver.findElementByXPath("//img[@alt='Offers Vehicle Image']").isDisplayed();
			System.out.println("Vehicle image is displayed in Saving Offer details page" +financeImage);
			reportStep("Vehicle image is displayed in Saving Offer details page", "PASS", true);
		}
		else {
			reportStep("Vehicle image is not displayed in Saving Offer details page", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.detailsPageBonusVerify"))!=null) {
			bonusDetailPage1 = getTextByXpath(objValue.getProperty("xpath.detailsPageBonusVerifyUpto"));
			String onlyLetters = bonusDetailPage1.replaceAll("[^A-Za-z\\s]","");
			bonusDetailPage2 =  bonusDetailPage1.replaceAll("[^\\d+$,]", "");
			String aftermerging = onlyLetters + " " + bonusDetailPage2;
			System.out.println("after replacing "+aftermerging);
			bonusDetailPage3 = getTextByXpath(objValue.getProperty("xpath.detailsPageSavings"));
			bonusDetailPage= aftermerging + " " + bonusDetailPage3;	
			System.out.println("Saving Offer in offers page is " +bonusDetailPage+ " and details page is "+savingValue); 
			if(bonusDetailPage.contains(savingValue)) {
				reportStep("Both saving offers are displayed same", "PASS", true);
			}
			else {
				reportStep("Both saving offers are displayed different", "FAIL", true);
			}
		}


		if(driver.findElementByXPath(objValue.getProperty("xpath.detailOfferModelName"))!=null) {
			String offerDetailModelPage = getTextByXpath(objValue.getProperty("xpath.detailOfferModelName"));

			if(offerDetailModelPage.contains(modelNameOffersPage)) {
				reportStep("Model name are displayed same", "PASS", true);
			}
		}
		else {
			reportStep("Model name are displayed different", "FAIL", true);
		}

		String estValue = getTextByXpath(objValue.getProperty("xpath.estimatePrice"));
		System.out.println("Estimate Net price Value is "+estValue);
		reportStep("Estimate Net price Value is "+estValue, "PASS", true);

		if(driver.findElementByXPath(objValue.getProperty("xpath.toolTip"))!=null) {
			clickByXpath(objValue.getProperty("xpath.toolTip"), "Tooltip disclaimer is clicked");
			reportStep("Tooltip disclaimer is clicked", "PASS", true);
		}
		else {
			reportStep("Tooltip disclaimer is not clicked", "FAIL", true);
		}

		/*if(driver.findElementByXPath(objValue.getProperty("xpath.tipMSRP"))!=null) {
			String msrpValue = getTextByXpath(objValue.getProperty("xpath.tipMSRP"));

			System.out.println("value of "+msrpValue);
			if(msrpValue.contains(modelPrice)) {
				System.out.println("Value of offers page is "+modelPrice+ " and Value of details page is " +msrpValue);
				reportStep("MSRP disclaimer value is displayed properly both in offerslanding page & offerdetails page", "PASS", true);
			}			
		}
		else {
			reportStep("MSRP disclaimer value is not displayed", "FAIL", true);
		}*/


		if(driver.findElementByXPath(objValue.getProperty("xpath.closeButton"))!=null) {
			clickByXpath(objValue.getProperty("xpath.closeButton"), "Close button is clicked");
			reportStep("Close button is clicked from Saving offer popup", "PASS", true);
		}
		else {
			reportStep("Close button is not clicked from Saving offer popup", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.expirydate"))!=null) {
			String expiryDate = getTextByXpath(objValue.getProperty("xpath.expirydate"));

			System.out.println("value of offer details section is "+expiryDate);
			if(expiryDate.contains(savingExpiryDate)) {
				System.out.println("Value of offers page is "+savingExpiryDate+ " and Value of details page is " +expiryDate);
				reportStep("Expiry date displayed properly both in offerslanding page & offerdetails page", "PASS", true);
			}			
		}
		else {
			reportStep("Expiry date is not displayed", "FAIL", true);
		}

		return this;

	}

	public LocalOffers financeOffer(String Testcasenumber) throws InterruptedException {
		/*closeNotificationPopup();
		closeWelcomePopup();*/
		if(driver.findElementByXPath(objValue.getProperty("xpath.APR"))!=null) {
			getTextByXpath(objValue.getProperty("xpath.APR"));
			APRValue = getTextByXpath(objValue.getProperty("xpath.aprValue"));
			reportStep("Finance Offer Value is " +APRValue+ " displayed under Financing" , "PASS", true);
		}

		else {
			reportStep("Finance Offer Value is not displayed under Financing", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.APRExpiry"))!=null) {
			String savExpiryDate = getTextByXpath(objValue.getProperty("xpath.APRExpiry"));
			financeExpiryDate = savExpiryDate.replaceAll("[^\\d+/]", "");
			reportStep("Finance Expiry date is " +financeExpiryDate+ " displayed properly" , "PASS", true);
		}

		else {
			reportStep("Finance Expiry date is not displayed properly", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.financeViewDetailsButton"))!=null) {
			clickByXpath(objValue.getProperty("xpath.financeViewDetailsButton"),"View Details button is clicked");
			reportStep("View Details button is clicked for Finance Offer", "PASS", true);
		}
		else {
			reportStep("View Details button is not clicked for Finance Offer", "FAIL", true);
		}
		return this;
	}

	public LocalOffers financeDetailsPage(String Testcasenumber) throws IOException, InterruptedException {
		/*closeNotificationPopup();
		closeWelcomePopup();*/
		if(driver.findElementByXPath(objValue.getProperty("xpath.detailsPageVerify"))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.detailsPageVerify"), "Finance");
			reportStep("Finance Offer page is verified", "PASS", true);
		}

		else {
			reportStep("Finance Offer page is not verified", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.offerImage"))!=null) {
			boolean financeImage = driver.findElementByXPath("//img[@alt='Offers Vehicle Image']").isDisplayed();
			System.out.println("Vehicle image is displayed in Finance Offer details page" +financeImage);
			reportStep("Vehicle image is displayed in Finance Offer details page", "PASS", true);
		}
		else {
			reportStep("Vehicle image is not displayed in Finance Offer details page", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.detailOfferModelName"))!=null) {
			String offerDetailModelPage = getTextByXpath(objValue.getProperty("xpath.detailOfferModelName"));

			if(offerDetailModelPage.contains(modelNameOffersPage)) {
				reportStep("Model name are displayed same", "PASS", true);
			}
		}
		else {
			reportStep("Model name are displayed different", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.detailsPageBonusVerify"))!=null) {
			financeDetailPage1 = getTextByXpath(objValue.getProperty("xpath.detailsPageBonusVerifyUpto"));
			financeDetailPage2 = getTextByXpath(objValue.getProperty("xpath.detailsPageSavings"));
			bonusDetailPage = financeDetailPage1 + " " + financeDetailPage2;	
			System.out.println("Finance Offer in offers page is " +bonusDetailPage+ " and details page is "+APRValue); 
			if(bonusDetailPage.contains(APRValue)) {
				reportStep("Both finance offers are displayed same", "PASS", true);
			}
			else {
				reportStep("Both finance offers are displayed different", "FAIL", true);
			}
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.msrpValueFinance"))!=null) {
			String msrpValue = getTextByXpath(objValue.getProperty("xpath.msrpValueFinance"));

			System.out.println("value of "+msrpValue);
			if(msrpValue.contains(modelPrice)) {
				System.out.println("Value of offers page is "+modelPrice+ " and Value of finance details page is " +msrpValue);
				reportStep("MSRP disclaimer value is displayed properly both in offerslanding page & offerdetails page", "PASS", true);
			}			
		}
		else {
			reportStep("MSRP disclaimer value is not displayed", "FAIL", true);
		}

		/*		if(driver.findElementByXPath(objvalue.getProperty("xpath.closeButton"))!=null) {
			clickByXpath(objvalue.getProperty("xpath.closeButton"), "Close button is clicked");
			reportStep("Close button is clicked from Lease offer popup", "PASS", true);
		}
		else {
			reportStep("Close button is not clicked from Lease offer popup", "FAIL", true);
		}*/

		if(driver.findElementByXPath(objValue.getProperty("xpath.expirydate"))!=null) {
			String expiryDate = getTextByXpath(objValue.getProperty("xpath.expirydate"));

			System.out.println("value of "+expiryDate);
			if(expiryDate.contains(financeExpiryDate)) {
				System.out.println("Value of offers page is "+financeExpiryDate+ " and Value of details page is " +expiryDate);
				reportStep("Expiry date displayed properly both in offerslanding page & offerdetails page", "PASS", true);
			}			
		}
		else {
			reportStep("Expiry date is not displayed", "FAIL", true);
		}

		return this;

	}

	public LocalOffers leaseOffers(String Testcasenumber) throws IOException, InterruptedException {
		/*closeNotificationPopup();
		closeWelcomePopup();*/

		if(driver.findElementByXPath(objValue.getProperty("xpath.lease"))!=null) {
			getTextByXpath(objValue.getProperty("xpath.lease"));
			String leaseValueAfterReplacing = getTextByXpath(objValue.getProperty("xpath.leaseValue"));
			leaseValue = leaseValueAfterReplacing.replaceAll("[\\s+]", "");
			reportStep("Lease Offer Value is " +leaseValue+ " displayed" , "PASS", true);
		}

		else {
			reportStep("Lease Offer Value is not displayed", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.LeaseExpiry"))!=null) {
			String savExpiryDate = getTextByXpath(objValue.getProperty("xpath.LeaseExpiry"));
			leaseExpiryDate = savExpiryDate.replaceAll("[^\\d+/]", "");
			reportStep("Lease Expiry date is " +leaseExpiryDate+ " displayed properly" , "PASS", true);
		}

		else {
			reportStep("Lease Expiry date is not displayed properly", "FAIL", true);
		}


		if(driver.findElementByXPath(objValue.getProperty("xpath.leaseViewDetailsButton"))!=null) {
			clickByXpath(objValue.getProperty("xpath.leaseViewDetailsButton"),"View Details button is clicked");
			reportStep("View Details button is clicked for Lease Offer", "PASS", true);
		}
		else {
			reportStep("View Details button is not clicked for Lease Offer", "FAIL", true);
		}
		return this;

	}

	public LocalOffers leaseDetailsPage(String Testcasenumber) throws IOException, InterruptedException {
		/*closeNotificationPopup();
		closeWelcomePopup();*/
		if(driver.findElementByXPath(objValue.getProperty("xpath.detailsPageVerify"))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.detailsPageVerify"),"Lease");
			reportStep("Lease Offer page is verified", "PASS", true);
		}

		else {
			reportStep("Lease Offer page is not verified", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.offerImage"))!=null) {
			boolean LeaseImage = driver.findElementByXPath("//img[@alt='Offers Vehicle Image']").isDisplayed();
			System.out.println("Vehicle image is displayed in Lease Offer details page " +LeaseImage);
			reportStep("Vehicle image is displayed in Lease Offer details page", "PASS", true);
		}
		else {
			reportStep("Vehicle image is not displayed in Lease Offer details page", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.detailOfferModelName"))!=null) {
			String offerDetailModelPage = getTextByXpath(objValue.getProperty("xpath.detailOfferModelName"));

			if(offerDetailModelPage.contains(modelNameOffersPage)) {
				reportStep("Model name are displayed same", "PASS", true);
			}
		}
		else {
			reportStep("Model name are displayed different", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.detailsPageBonusVerify"))!=null) {
			financeDetailPage1 = getTextByXpath(objValue.getProperty("xpath.detailsPageBonusVerifyUpto"));
			financeDetailPage2 = getTextByXpath(objValue.getProperty("xpath.detailsPageSavings"));
			bonusDetailPage= financeDetailPage1 + " " + financeDetailPage2;	
			System.out.println("Lease Offer in offers page is " +bonusDetailPage+ " and details page is "+leaseValue); 
			if(bonusDetailPage.contains(leaseValue)) {
				reportStep("Both Lease offers are displayed same", "PASS", true);
			}
			else {
				reportStep("Both Lease offers are displayed different", "FAIL", true);
			}
		}

		String estValue = getTextByXpath(objValue.getProperty("xpath.estimatePrice"));
		System.out.println("Est.Monthly Cost Value is "+estValue);
		reportStep("Est.Monthly Cost Value is "+estValue, "PASS", true);

		if(driver.findElementByXPath(objValue.getProperty("xpath.leaseToolTip"))!=null) {
			clickByXpath(objValue.getProperty("xpath.leaseToolTip"), "Tooltip disclaimer is clicked");
			reportStep("Tooltip disclaimer is clicked from Lease offers page", "PASS", true);
		}
		else {
			reportStep("Tooltip disclaimer is not clicked from Lease offers page" , "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.tipMSRP"))!=null) {
			getTextByXpath(objValue.getProperty("xpath.tipMSRP"));
			reportStep("Diclaimer icon is clicked and popup displayed", "PASS", true);
		}			

		else {
			reportStep("Diclaimer icon is not clicked and popup not displayed", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.closeButton"))!=null) {
			clickByXpath(objValue.getProperty("xpath.closeButton"), "Close button is clicked");
			reportStep("Close button is clicked from Lease offer popup", "PASS", true);
		}
		else {
			reportStep("Close button is not clicked from Lease offer popup", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.expirydate"))!=null) {
			String expiryDate = getTextByXpath(objValue.getProperty("xpath.expirydate"));

			System.out.println("value of "+expiryDate);
			if(expiryDate.contains(leaseExpiryDate)) {
				System.out.println("Value of offers page is "+leaseExpiryDate+ " and Value of details page is " +expiryDate);
				reportStep("Expiry date displayed properly both in offerslanding page & offerdetails page", "PASS", true);
			}			
		}
		else {
			reportStep("Expiry date is not displayed", "FAIL", true);
		}

		return this;

	}
	

	public LocalOffers offerRAQInfo(String Testcasenumber) throws IOException {

		String dealerName = ReadExcelData.getdata(Testcasenumber, "Dealer");
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.offerDealerValue")))!=null) {
			
			WebElement dealerValue = driver.findElement(By.xpath(objValue.getProperty("xpath.offerDealerValue")));
			String dealerDetails = dealerValue.getText();
			if(dealerDetails.contains(dealerName)) {
				reportStep("Dealer Name " +dealerName+ " is displayed properly", "PASS", true);
				
			}
		}

		else {
			reportStep("Dealer Name " +dealerName+ " is displayed properly", "FAIL", true);

		}

		String zipCode = ReadExcelData.getdata(Testcasenumber, "Zipcode");
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.offerZipRAQValue")))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.offerZipRAQValue"), zipCode);
			reportStep("Zip Code value in offer landing page is " +zipCode+ " displayed properly", "PASS", true);
		}

		else {
			reportStep("Zip Code value in offer landing page is not displayed properly", "FAIL", true);

		}



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

		driver.findElement(By.xpath(objValue.getProperty("xpath.raqemail")));
		String emailID = ReadExcelData.getdata(Testcasenumber, "Email");
		System.out.println("Email ID is " +emailID);
		enterByXpath(objValue.getProperty("xpath.raqemail"), emailID, "Email ID is entered");
		reportStep("Email ID is entered properly", "PASS", true);

		driver.findElement(By.xpath(objValue.getProperty("xpath.addCommentText")));
		clickByXpath(objValue.getProperty("xpath.addCommentText"), "Comment dropdown is clicked");
		String comment = ReadExcelData.getdata(Testcasenumber, "Comment");
		System.out.println("Comment is " +comment);
		enterByXpath(objValue.getProperty("xpath.textarea"), comment, "Comment is entered");
		reportStep("Comment is entered properly", "PASS", true);


		js.executeScript("window.scrollBy(0,500)", "");
	
			clickByXpath(objValue.getProperty("xpath.offerRAQButton"), "RAQ submit button is clicked successfully");
			reportStep("RAQ submit button is clicked successfully", "PASS", true);
		
		/*clickByXpath(objValue.getProperty("xpath.offersGetOffers"), "RAQ Get Offers button is clicked successfully");
		reportStep("RAQ Get Offers submit button is clicked successfully", "PASS", true);
		sleepTime(20);*/
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.thankYouMessage")))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.thankYouMessage"), "Your quote request has been successfully submitted.");
			reportStep("Thank You message is displayed properly", "PASS", true);
		}
		else {
			reportStep("Thank You message is not displayed properly", "FAIL", true);
		}

		return this;
	}

	public LocalOffers offerInventorySection(String Testcasenumber) throws IOException {
		if(driver.findElementByXPath(objValue.getProperty("xpath.inventoryHeading"))!=null) {
			getTextByXpath(objValue.getProperty("xpath.inventoryHeading"));
			reportStep("Local Inventory section is displayed in offer details page", "PASS", true);
		}
		else {
			reportStep("Local Inventory section is not displayed in offer details page", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.exactMatches"))!=null) {
			String exactMatchesInventory = getTextByXpath(objValue.getProperty("xpath.exactMatches"));
			exactMatchesInventoryNumber = exactMatchesInventory.replaceAll("[^\\d]", "");
			System.out.println("Exact match count is "+exactMatchesInventoryNumber);
			reportStep("Exact match count displayed in offers detail page is "+exactMatchesInventoryNumber, "PASS", true);
		}
		else {
			reportStep("Exact match count is not displayed in offers detail page", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.miles"))!=null) {
			milesDropdown = getTextByXpath(objValue.getProperty("xpath.miles"));
			//String exactMatchesInventoryNumber = exactMatchesInventory.replaceAll("\\d", "");
			System.out.println("Miles dropdown value is "+milesDropdown);
			reportStep("Miles dropdown displayed in offers detail page is "+milesDropdown, "PASS", true);
		}
		else {
			reportStep("Miles dropdown is not displayed in offers detail page", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.offerDetailsZip"))!=null) {
			ZipCode = getTextByXpath(objValue.getProperty("xpath.offerDetailsZip"));
			//String exactMatchesInventoryNumber = exactMatchesInventory.replaceAll("\\d", "");
			System.out.println("Zipcode value is "+ZipCode);
			reportStep("Zipcode displayed in offers detail page is "+ZipCode, "PASS", true);
		}
		else {
			reportStep("Zipcode is not displayed in offers detail page", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.offerIventoryModelName"))!=null) {
			String IventoryName = getTextByXpath(objValue.getProperty("xpath.offerIventoryModelName"));
			String IventoryTrimName = getTextByXpath(objValue.getProperty("xpath.offerIventoryTrimName"));
			IventoryModelName = IventoryName + " " +IventoryTrimName;
			//String exactMatchesInventoryNumber = exactMatchesInventory.replaceAll("\\d", "");
			System.out.println("Vehicle model value is "+IventoryModelName);
			reportStep("Vehicle model in offers detail page is "+IventoryModelName, "PASS", true);
		}
		else {
			reportStep("Vehicle model is not displayed in offers detail page", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.offerViewDetailsButton"))!=null) {
			clickByXpath(objValue.getProperty("xpath.offerViewDetailsButton"), "View Details button is clicked");
			reportStep("View Details button is clicked", "PASS", true);
		}
		else {
			reportStep("View Details button is not clicked", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.viewDetailInventoryModel"))!=null) {
			String DetailInventoryModelName = getTextByXpath(objValue.getProperty("xpath.viewDetailInventoryModel"));
			String modelName = DetailInventoryModelName.replaceAll("[\\n]", " ");
			if(IventoryModelName.contains(modelName)) {
				System.out.println("Model name in offer inventory section is "+IventoryModelName+ " Model name in inventory section is "+modelName); 
				reportStep("Model displayed in offer detail page of Local Inventory section is same as Inventory details page", "PASS", true);
			}
		}
		else {
			reportStep("Model displayed in offer detail page of Local Inventory section is different from Inventory details page", "FAIL", true);
		}

		driver.navigate().back(); 
		if(driver.findElementByXPath(objValue.getProperty("xpath.detailsPageVerify"))!=null) {
			boolean parentSavingOfferDetailPage = driver.findElementByXPath("//h1[@class='odt-heading']").isDisplayed();
			reportStep("Saving Offer detail page is displayed from Inventory details page "+parentSavingOfferDetailPage, "PASS", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.offerInventoryButton"))!=null) {
			clickByXpath(objValue.getProperty("xpath.offerInventoryButton"), "View Details button is clicked");
			reportStep("View All Inventory button is clicked", "PASS", true);
		}
		else {
			reportStep("View All Inventory button is not clicked", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.inventoryPageOfferDetails"))!=null) {
			String InventoryHeader = ReadExcelData.getdata(Testcasenumber, "Message");
			verifyTextByXpath(objValue.getProperty("xpath.inventoryPageOfferDetails"), InventoryHeader);
			reportStep("Inventory landing page is displayed", "PASS", true);
		}
		else {
			reportStep("Inventory landing page is not displayed", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.inventoryMilesDropdown"))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.inventoryMilesDropdown"), milesDropdown);
			reportStep("Miles displayed in local inventory section is same as miles displayed Inventory landing page", "PASS", true);
		}
		else {
			reportStep("Miles displayed in local inventory section is different as miles displayed Inventory landing page", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.inventoryzipCodeDropdown"))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.inventoryzipCodeDropdown"), ZipCode);
			reportStep("Zipcode value displayed in local inventory section is same as miles displayed Inventory landing page", "PASS", true);
		}
		else {
			reportStep("Zipcode value displayed in local inventory section is different as miles displayed Inventory landing page", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.inventoryVehicleModelName"))!=null) {
			String vehicleModelName = getTextByXpath(objValue.getProperty("xpath.inventoryVehicleModelName"));
			if(IventoryModelName.contains(vehicleModelName)) {
				System.out.println("model name "+vehicleModelName+ " model name "+IventoryModelName);
				reportStep("Model name displayed in local inventory section is same as model displayed Inventory landing page", "PASS", true);
			}
		}
		else {
			reportStep("Model name displayed in local inventory section is different as model displayed Inventory landing page", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.inventoryExactMatch"))!=null) {
			String inventoryPagecount = getTextByXpath(objValue.getProperty("xpath.inventoryExactMatch"));
			if(inventoryPagecount.contains(exactMatchesInventoryNumber)) {
				System.out.println("Both are displayed same");
				reportStep("Exact matches count is " +exactMatchesInventoryNumber+ " displayed in local inventory section is same as matches " +inventoryPagecount+ " displayed Inventory landing page", "PASS", true);
			}
		}
		else {
			reportStep("Exact matches count displayed in local inventory section is different as matches displayed Inventory landing page", "FAIL", true);
		}
		driver.navigate().back();
		return this;

	}

	public LocalOffers dealerShipSection(String Testcasenumber) throws IOException {
		scrollElement(objValue.getProperty("xpath.dealerOfferSection"));
		if(driver.findElementByXPath(objValue.getProperty("xpath.dealerOfferSection"))!=null) {
			String dealerHeading = getTextByXpath(objValue.getProperty("xpath.dealerOfferSection"));
			reportStep("Dealerships Near By section is dispalyed "+dealerHeading, "PASS", true);
		}
		else {
			reportStep("Dealerships Near By section is not dispalyed", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.zipDealerSection"))!=null) {
			getTextByXpath(objValue.getProperty("xpath.zipDealerSection"));
			reportStep("Dealerships Near By section zipcode is "+zipcode, "PASS", true);
		}
		else {
			reportStep("Dealerships Near By section zipcode is not same as offers page", "FAIL", true);
		}

		String dealerName = ReadExcelData.getdata(Testcasenumber, "Dealer");
		if(driver.findElementByXPath(objValue.getProperty("xpath.dealerName"))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.dealerName"), dealerName);
			reportStep("Dealerships Near By section dealer name is "+dealerName, "PASS", true);
		}
		else {
			reportStep("Dealerships Near By section dealer name is not same as offers page", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.dealerMiles"))!=null) {
			String dealerMiles = getTextByXpath(objValue.getProperty("xpath.dealerMiles"));
			reportStep("Dealerships Near By section miles is dispalyed "+dealerMiles, "PASS", true);
		}
		else {
			reportStep("Dealerships Near By section miles is not dispalyed", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.dealerAddress"))!=null) {
			String dealerAddress = getTextByXpath(objValue.getProperty("xpath.dealerAddress"));
			reportStep("Dealerships Near By section address is dispalyed "+dealerAddress, "PASS", true);
		}
		else {
			reportStep("Dealerships Near By section address is not dispalyed", "FAIL", true);
		}
		return this;
	}

	public LocalOffers offerGetDirection(String Testcasenumber) {
		if(driver.findElementByXPath(objValue.getProperty("xpath.getDirectionLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.getDirectionLink"), "Get Direction link is clicked");
			reportStep("Get Direction link is clicked from dealership nearby section", "PASS", true);
			switchToLastWindow();
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.txtDirectionsPage"))) != null)
			{

				reportStep("Navigate to GetDirections Tab", "PASS");
				System.out.println("title is "+driver.getTitle());
				closeBrowser();
				switchToParentWindow();
			}
			else {
				reportStep("Navigate to GetDirections Tab", "FAIL");

				switchToParentWindow();
			}

		}
		else {
			reportStep("Click GetDirections Tab", "FAIL");

		}
		return this;
	}

	public LocalOffers offerVisitDealer(String Testcasenumber) {

		if(driver.findElementByXPath(objValue.getProperty("xpath.visitDealerLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.visitDealerLink"), "Visit Dealer Page link is clicked");
			switchToLastWindow();
			sleepTime(20);
			reportStep("Navigate to VisitDealer Window", "PASS");
			System.out.println("title is "+driver.getTitle());
			closeBrowser();
			switchToParentWindow();
		}

		else {
			reportStep("Click VisitDealer Tab", "FAIL");
		}
		return this;
	}

	public LocalOffers offerSTD(String Testcasenumber) throws InterruptedException, IOException {
		if(driver.findElementByXPath(objValue.getProperty("xpath.scheduleLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.scheduleLink"), "Schedule Test Drive link is clicked");
			reportStep("Schedule Test Drive link is clicked", "PASS", true);
		}
		else {
			reportStep("Schedule Test Drive link is not clicked", "FAIL", true);
		}		
		switchToLastWindow();
		sleepTime(20);
		if(driver.findElementByXPath(objValue.getProperty("xpath.stdPageVerification"))!=null) {
			offerClose();
			String headerSTD = ReadExcelData.getdata(Testcasenumber, "AutoshowsHeader");
			verifyTextByXpath(objValue.getProperty("xpath.stdPageVerification"), headerSTD);
			offerClose();
			reportStep("Schedule Test Drive page is displayed", "PASS", true);
			closeBrowser();
			switchToParentWindow();

		}
		else {
			reportStep("Schedule Test Drive page is not displayed", "FAIL", true);

		}	

		return this;

	}
	public LocalOffers offerTestDrive(String Testcasenumber) throws InterruptedException, IOException {
		scrollElementByPixelUp(objValue.getProperty("xpath.testDrive"));
		if(driver.findElementByXPath(objValue.getProperty("xpath.testDrive"))!=null) {
			clickByXpath(objValue.getProperty("xpath.testDrive"), "Test Drive link is clicked");
			reportStep("Test Drive link is clicked", "PASS", true);
		}
		else {
			reportStep("Test Drive link is not clicked", "FAIL", true);
		}		
		switchToLastWindow();
		sleepTime(30);

		if(driver.findElementByXPath(objValue.getProperty("xpath.stdPageVerification"))!=null) {
			String headerSTD = ReadExcelData.getdata(Testcasenumber, "AutoshowsHeader");
			verifyTextByXpath(objValue.getProperty("xpath.stdPageVerification"), headerSTD);
			offerClose();
			reportStep("Schedule Test Drive page is displayed from test drive link", "PASS", true);
			closeBrowser();
			switchToParentWindow();		
		}
		else {
			reportStep("Schedule Test Drive page is not displayed from test drive link", "FAIL", true);

		}	
		return this;

	}

	public LocalOffers offerSeeInventory(String Testcasenumber) throws IOException, InterruptedException  {
		/*closeNotificationPopup();
		closeWelcomePopup();*/
		if(driver.findElementByXPath(objValue.getProperty("xpath.seeInventory"))!=null) {
			clickByXpath(objValue.getProperty("xpath.seeInventory"), "See Inventory link is clicked");
			reportStep("See Inventory link is clicked", "PASS", true);
		}
		else {
			reportStep("See Inventory link is not clicked", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.inventoryPageOfferDetails"))!=null) {
			String InventoryHeader = ReadExcelData.getdata(Testcasenumber, "Message");
			verifyTextByXpath(objValue.getProperty("xpath.inventoryPageOfferDetails"), InventoryHeader);
			reportStep("Inventory landing page is displayed", "PASS", true);
		}
		else {
			reportStep("Inventory landing page is not displayed", "FAIL", true);
		}

		driver.navigate().back();
		System.out.println("Offer TC completed");
		return this;
	}

	public LocalOffers offerHeader(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.offerHeaderLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.offerHeaderLink"), "Offer link is clicked from Header");
			reportStep("Offer link is clicked from Header", "PASS", true);
		}
		else {
			reportStep("Offer link is not clicked from Header", "FAIL", true);
		}

		closeWelcomePopup();

		if(driver.findElementByXPath(objValue.getProperty("xpath.offerPageVerify"))!=null){
			getTextByXpath(objValue.getProperty("xpath.offerPageVerify"));
			reportStep("Offers Page is verified", "PASS", true);
		}
		else {
			reportStep("Offers Page is not verified", "FAIL", true);
		}

		return this;

	}

	public LocalOffers homepageOffersBanner(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.offerHomepageBanner"))!=null) {
			clickByXpath(objValue.getProperty("xpath.offerHomepageBanner"), "Offers link is clicked from Offer banner home page");
			reportStep("Offers link is clicked from Offer banner home page", "PASS", true);
		}
		else {
			reportStep("Offers link is not clicked from Offer banner home page", "FAIL", true);
		}
/*		closeNotificationPopup();
		closeWelcomePopup();*/
		if(driver.findElementByXPath(objValue.getProperty("xpath.offerPageVerify"))!=null){
			getTextByXpath(objValue.getProperty("xpath.offerPageVerify"));
			reportStep("Offers Page is verified", "PASS", true);
		}
		else {
			reportStep("Offers Page is not verified", "FAIL", true);
		}

		return this;

	}

	public LocalOffers specialPromotions(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
	//	LocalOffers obj = new LocalOffers(driver);
		if(driver.findElementByXPath(objValue.getProperty("xpath.specialOffers"))!=null) {
			clickByXpath(objValue.getProperty("xpath.specialOffers"), "Special promotions link is clicked");
			reportStep("Special promotions link is clicked", "PASS", true);
		}
		else {
			reportStep("Special promotions link is not clicked", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.specialHeader"))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.specialHeader"), "Special Programs");
			reportStep("Special promotions page is displayed", "PASS", true);
		}
		else {
			reportStep("Special promotions page is not displayed", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.hyundaiAssBanner"))!=null) {
			boolean displayed = isDisplayed(objValue.getProperty("xpath.hyundaiAssBanner"));
			clickByXpath(objValue.getProperty("xpath.hyundaiAssofferDetailsCTA"), "Hyundai Assurance offer details link is clicked");
			verifyTextContainsByXpath(objValue.getProperty("xpath.studentPage"), "Hyundai Assurance");
			specialPromotionsBackLink(Testcasenumber);
			reportStep("Hyundai Assurance banner is displayed "+displayed+ " link is clicked", "PASS", true);		
		}
		else {
			reportStep("Hyundai Assurance banner is not displayed and link is not clicked", "FAIL", true);
		}		
		
		if(driver.findElementByXPath(objValue.getProperty("xpath.collegeBanner"))!=null) {
			boolean displayed = isDisplayed(objValue.getProperty("xpath.collegeBanner"));
			clickByXpath(objValue.getProperty("xpath.collegeofferDetailsCTA"), "College Grad offer details link is clicked");
			reportStep("College Grad banner is displayed "+displayed+ " link is clicked", "PASS", true);	
			verifyTextContainsByXpath(objValue.getProperty("xpath.studentPage"), "College Grad Program");
			specialPromotionsBackLink(Testcasenumber);
		}
		else {
			reportStep("College Grad banner is not displayed and link is not clicked", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.nationalDriveBanner"))!=null) {
			boolean displayed = isDisplayed(objValue.getProperty("xpath.nationalDriveBanner"));
			clickByXpath(objValue.getProperty("xpath.nationalDriveofferDetailsCTA"), "National Test Drive offer details link is clicked");
			reportStep("National Test Drive banner is displayed "+displayed+ " link is clicked", "PASS", true);		
			verifyTextContainsByXpath(objValue.getProperty("xpath.studentPage"), "National Test Drive Offer");
		specialPromotionsBackLink(Testcasenumber);
		}
		else {
			reportStep("National Test Drive banner is not displayed and link is not clicked", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.militaryBanner"))!=null) {
			boolean displayed = isDisplayed(objValue.getProperty("xpath.militaryBanner"));
			clickByXpath(objValue.getProperty("xpath.militaryofferDetailsCTA"), "Military program offer details link is clicked");
			reportStep("Military program banner is displayed "+displayed+ " link is clicked", "PASS", true);
			verifyTextContainsByXpath(objValue.getProperty("xpath.studentPage"), "Military Program");
			specialPromotionsBackLink(Testcasenumber);
		}
		else {
			reportStep("Military program banner is not displayed and link is not clicked", "FAIL", true);
		}		

		if(driver.findElementByXPath(objValue.getProperty("xpath.firstResponderBanner"))!=null) {
			boolean displayed = isDisplayed(objValue.getProperty("xpath.firstResponderBanner"));
			clickByXpath(objValue.getProperty("xpath.firstResponderofferDetailsCTA"), "First Responder program offer details link is clicked");
			reportStep("First Responders program banner is displayed "+displayed+ " link is clicked", "PASS", true);	
			verifyTextContainsByXpath(objValue.getProperty("xpath.studentPage"), "First Responders Program");
			specialPromotionsBackLink(Testcasenumber);
		}
		else {
			reportStep("First Responder program banner is not displayed and link is not clicked", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.mobilityBanner"))!=null) {
			boolean displayed = isDisplayed(objValue.getProperty("xpath.mobilityBanner"));
			clickByXpath(objValue.getProperty("xpath.mobilityofferDetailsCTA"), "Mobility program offer details link is clicked");
			reportStep("Mobility program banner is displayed "+displayed+ " link is clicked", "PASS", true);
			verifyTextContainsByXpath(objValue.getProperty("xpath.studentPage"), "Mobility Program");
		specialPromotionsBackLink(Testcasenumber);
		}
		else {
			reportStep("Mobility program banner is not displayed and link is not clicked", "FAIL", true);
		}
		return this;

	}
	
	public LocalOffers specialPromotionsBackLink(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.backOffersLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.backOffersLink"), "Back link is clicked from Promotions page");
			reportStep("Back link is clicked from Special Promotions Detail page", "PASS", true);
			verifyTextByXpath(objValue.getProperty("xpath.specialHeader"), "Special Programs");
		}
		else {
			reportStep("Back link is clicked from Special Promotions Detail page", "PASS", true);
		}
		return this;
		
	}

	public LocalOffers offerLinkFooter(String Testcasenumber) throws InterruptedException, IOException {
		closeNotificationPopup();
		closeWelcomePopup();
	
		//scrollElement(objValue.getProperty("xpath.offerLinkFooter"));
		WebElement footerSection = driver.findElementByXPath("(//a[text()='Offers & Promotions'])[2]");
		js.executeScript("arguments[0].scrollIntoView(true);",footerSection);
		if(driver.findElementByXPath(objValue.getProperty("xpath.offerLinkFooter"))!=null) {
			clickByXpath(objValue.getProperty("xpath.offerLinkFooter"), "Offer link is clicked from footer");
			reportStep("Offer link is clicked from footer", "PASS", true);
		}

		else {
			reportStep("Offer link is not clicked from footer", "FAIL", true);
		}
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.offerPageVerify"))!=null){
			getTextByXpath(objValue.getProperty("xpath.offerPageVerify"));
			reportStep("Offers Page is verified", "PASS", true);
		}
		else {
			reportStep("Offers Page is not verified", "FAIL", true);
		}

		return this;

	}

	public LocalOffers offerLinkNextFindingSection(String Testcasenumber) throws InterruptedException, IOException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.offerLinkHomePage"))!=null) {
			clickByXpath(objValue.getProperty("xpath.offerLinkHomePage"), "Offer link is clicked from Next Finding section");
			reportStep("Offer link is clicked from Next Finding section", "PASS", true);
		}

		else {
			reportStep("Offer link is not clicked from Next Finding section", "FAIL", true);
		}
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.offerPageVerify"))!=null){
			getTextByXpath(objValue.getProperty("xpath.offerPageVerify"));
			reportStep("Offers Page is verified", "PASS", true);
		}
		else {
			reportStep("Offers Page is not verified", "FAIL", true);
		}

		return this;

	}

}



