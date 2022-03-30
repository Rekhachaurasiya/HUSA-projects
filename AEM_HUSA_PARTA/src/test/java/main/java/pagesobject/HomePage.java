package main.java.pagesobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import main.java.utility.Projectcommonmethodes;
import main.java.utility.ReadExcelData;

public class HomePage extends Projectcommonmethodes {
	String suvsVehicleModel,sedansVehicleModel,compactsVehicleModel = "";	

	public HomePage (RemoteWebDriver driver) throws InterruptedException{
		this.driver = driver;
		closeNotificationPopup();

	} 

	public HomePage nextFindingSection(String Testcasenumber) throws IOException, InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		scrollElement(objValue.getProperty("xpath.nextFindingSection"));
		String headerNextSection = ReadExcelData.getdata(Testcasenumber, "Header");
		if(driver.findElementByXPath(objValue.getProperty("xpath.nextFindingSection"))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.nextFindingSection"), headerNextSection);
			reportStep("Next Finding section is displayed", "PASS", true);
		}
		else {
			reportStep("Next Finding section is not displayed", "FAIL", true);
		}
		return this;	
	}

	public HomePage startBuildingSection(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.startBuilding"))!=null) {
			clickByXpath(objValue.getProperty("xpath.startBuilding"), "Start Building link is clicked");
			reportStep("Start Building link is clicked from Next Finding section", "PASS", true);
			verifyTextByXpath(objValue.getProperty("xpath.byoVerify"), "Build Your Hyundai");
			reportStep("Build and Price page is verified from Next Finding section", "PASS", true);
		}
		else {
			reportStep("Start Building link is not clicked from Next Finding section", "FAIL", true);
		}		
		driver.navigate().back();
		return this;
	}

	public HomePage localOffersSection(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.viewLocalOffers"))!=null) {
			clickByXpath(objValue.getProperty("xpath.viewLocalOffers"), "Local Offers link is clicked");
			reportStep("Local Offers link is clicked from Next Finding section", "PASS", true);
			verifyTextByXpath(objValue.getProperty("xpath.offerPageVerify"), "Offers");
			reportStep("Offers page is verified from Next Finding section", "PASS", true);
		}
		else {
			reportStep("Local Offers link is not clicked from Next Finding section", "FAIL", true);
		}

		driver.navigate().back();
		return this;
	}

	public HomePage locateDealerSection(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.locateDealer"))!=null) {
			clickByXpath(objValue.getProperty("xpath.locateDealer"), "Locate Dealer link is clicked");
			reportStep("Locate Dealer link is clicked from Next Finding section", "PASS", true);
			verifyTextContainsByXpath(objValue.getProperty("xpath.findADealerVerify"), "Hyundai Dealerships near");
			reportStep("Locate Dealer page is verified from Next Finding section", "PASS", true);
		}
		else {
			reportStep("Locate Dealer link is not clicked from Next Finding section", "FAIL", true);
		}
		driver.navigate().back();
		return this;

	}

	public HomePage vehicleLineUpSectionSUVs(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		scrollElement(objValue.getProperty("xpath.vehicleLineUp"));
		if(driver.findElementByXPath(objValue.getProperty("xpath.vehicleLineUp"))!=null) {
			isDisplayed(objValue.getProperty("xpath.vehicleLineUp"));
			reportStep("Vehicle Lineup Section is displayed", "PASS", true);
		}
		else {
			reportStep("Vehicle Lineup Section is not displayed", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.suvCategory"))!=null) {
			isDisplayed(objValue.getProperty("xpath.suvCategory"));
			reportStep("SUVs category is displayed in Vehicle LineUp section", "PASS", true);
		}
		else {
			reportStep("SUVs category is not displayed in Vehicle LineUp section", "FAIL", true);
		}

		int j=9;
		WebElement vehilcleModelName = driver.findElementByXPath("(//div[@class='vc-name '])[3]");
		String suvsVehicleName = vehilcleModelName.getText();
		suvsVehicleModel = suvsVehicleName.replaceAll("[\\n]", " ");
		vehilcleModelName.click();

		String vehicleName = getTextByXpath(objValue.getProperty("xpath.vehicleModelNameHeader"));
		if(suvsVehicleModel.contains(vehicleName)) {
			System.out.println("Vehicle is displayed properly");
			reportStep("Both vehicle name are displayed properly", "PASS", true);
		}
		driver.navigate().back();
		
		for ( int i=3;i<=j;i++) {
			WebElement vehicle = driver.findElementByXPath("(//div[@class='vc-name '])["+(i+0)+"]");
			String suvsVehicleNameMo = vehicle.getText();
			suvsVehicleModel = suvsVehicleNameMo.replaceAll("[\\n]", " ");

			System.out.println("Vehicle displayed in SUVs Category is "+suvsVehicleModel);
			reportStep("Vehicle displayed in SUVs Category is "+suvsVehicleModel, "PASS", true);
			clickByXpathjs(objValue.getProperty("xpath.nextButtonClick"), "Next Button is clicked");
			reportStep("Next link is clicked", "PASS", true);
		}

		return this;
	}

	public HomePage vehicleLineUpSectionSedans(String Testcasenumber) throws InterruptedException {
		sleepTime(30);
		closeNotificationPopup();
		closeWelcomePopup();
		
		
		if(driver.findElementByXPath(objValue.getProperty("xpath.sedanCategory"))!=null) {
			clickByXpath(objValue.getProperty("xpath.sedanCategory"),"Sedans link is clicked");			
			reportStep("Sedans category is displayed in Vehicle LineUp section", "PASS", true);
		}
		else {
			reportStep("Sedans category is not displayed in Vehicle LineUp section", "FAIL", true);
		}
		/*int k=16;
		WebElement vehilcleModelName = driver.findElementByXPath("(//h2[@class='vc-name-head'])[10]");
		String sedansVehicleName = vehilcleModelName.getText();
		sedansVehicleModel = sedansVehicleName.replaceAll("[\\n]", " ");
		
		vehilcleModelName.click();

		String vehicleName = getTextByXpath(objValue.getProperty("xpath.vehicleModelNameHeader"));
		if(sedansVehicleModel.contains(vehicleName)) {
			System.out.println("Vehicle is displayed properly");
			reportStep("Both vehicle name are displayed properly", "PASS", true);
		}
		driver.navigate().back();
		clickByXpath(objValue.getProperty("xpath.sedanCategory"),"Sedans link is clicked");*/	
		int k=16;
		for ( int i=10;i<=k;i++) {
			WebElement vehicle = driver.findElementByXPath("(//h2[@class='vc-name-head'])["+(i+0)+"]");
			String sedansVehicleNameMo = vehicle.getText();
			sedansVehicleModel = sedansVehicleNameMo.replaceAll("[\\n]", " ");
			reportStep("Vehicle displayed in Sedans Category is "+sedansVehicleModel, "PASS", true);

			clickByXpathjs(objValue.getProperty("xpath.nextButtonClick"), "Next Button is clicked");
			reportStep("Next link is clicked", "PASS", true);
		}
		
		return this;
	}

	public HomePage vehicleLineUpSectionCompacts(String Testcasenumber) throws InterruptedException {
	closeNotificationPopup();
		closeWelcomePopup();
		scrollElementByPixel(objValue.getProperty("xpath.CompactCategory"));
		if(driver.findElementByXPath(objValue.getProperty("xpath.CompactCategory"))!=null) {
			clickByXpathjs(objValue.getProperty("xpath.CompactCategory"),"Compacts link is clicked");		
			reportStep("Compact category is displayed in Vehicle LineUp section", "PASS", true);
		}
		else {
			reportStep("Compact category is not displayed in Vehicle LineUp section", "FAIL", true);
		}
		int a=20;
		WebElement vehilcleModelName = driver.findElementByXPath("(//div[@class='vc-name '])[15]");
		String compactsVehicleName = vehilcleModelName.getText();
		compactsVehicleModel = compactsVehicleName.replaceAll("[\\n]", " ");
		
		vehilcleModelName.click();
		String vehicleName = getTextByXpath(objValue.getProperty("xpath.vehicleModelNameHeader"));
		if(compactsVehicleModel.contains(vehicleName)) {
			System.out.println("Vehicle is displayed properly");
			reportStep("Both vehicle name are displayed properly", "PASS", true);
		}
		driver.navigate().back();
		clickByXpath(objValue.getProperty("xpath.CompactCategory"),"Compacts link is clicked");	
		for ( int i=15;i<=a;i++) {
			WebElement vehicle = driver.findElementByXPath("(//div[@class='vc-name '])["+(i+0)+"]");
			String compactsVehicleNameMo = vehicle.getText();
			compactsVehicleModel = compactsVehicleNameMo.replaceAll("[\\n]", " ");
			reportStep("Vehicle displayed in Compact Category is "+compactsVehicleModel, "PASS", true);
			clickByXpathjs(objValue.getProperty("xpath.nextButtonClick"), "Next Button is clicked");
			reportStep("Next link is clicked", "PASS", true);
		}
		return this;

	}
}
