package main.java.pagesobject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import main.java.utility.Projectcommonmethodes;
import main.java.utility.ReadExcelData;
import java.util.List; 


public class CompareVehicles extends Projectcommonmethodes {
	String modelFirst = "";
	String modelSecond = "";
	String modelThird = "";
	String comparemodel = "";
	String comparemodel1 = "";
	String comparemodel2 = "";
	String priceFirst = "";
	String priceSecond = "";
	String priceThird = "";
	String valueMPGFirst = "";
	String valueMPGSecond = "";
	String valueMPGThird = "";
	String priceContent1 = "";
	String priceContent2 = "";
	String priceContent3 = "";
	String valueMPG = "";
	String valueMPG2 = "";
	String valueMPG3,vehiclemodelname,year,compareFirstModel2,comparePopupYearValue2,comparePopupNameValue2 = "";

	public CompareVehicles (RemoteWebDriver driver) throws InterruptedException{
		this.driver = driver;
		closeWelcomePopup();
	} 

	public CompareVehicles clickMenu(String Testcasenumber) throws InterruptedException {
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

	public CompareVehicles comparePage(String Testcasenumber) throws IOException, InterruptedException {
		//closeWelcomePopup();
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.compareLinkmenu")))!= null) {
			clickByXpath(objValue.getProperty("xpath.compareLinkmenu"), "Compare link is clicked");
			reportStep("Compare link is clicked from Menu", "PASS", true);
		}

		else {
			reportStep("Compare link is not clicked from Menu", "FAIL", true);
		}
		//closeWelcomePopup();
		String pageHeader = ReadExcelData.getdata(Testcasenumber, "Header");
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.comparePage")))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.comparePage"), pageHeader);
			reportStep("Compare page is verified properly", "PASS", true);
		}
		else {
			reportStep("Compare page is not verified properly", "FAIL", true);
		}
		closeWelcomePopup();
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.compareLink")))!=null) {
			clickByXpath(objValue.getProperty("xpath.compareLink"), "Compare link is clicked");
			reportStep("Compare link is clicked from Compare page", "PASS", true);
		}
		else {
			reportStep("Compare link is not clicked from Compare page", "FAIL", true);
		}

		return this;

	}

	public CompareVehicles vehicleSelector(String Testcasenumber) throws IOException, InterruptedException {
		//closeWelcomePopup();

		modelFirst = ReadExcelData.getdata(Testcasenumber, "Model");
		modelSecond = ReadExcelData.getdata(Testcasenumber, "Model1");
		modelThird = ReadExcelData.getdata(Testcasenumber, "Model2");

		WebElement firstModel = driver.findElement(By.xpath("//input[@data-vbws-compare='" + modelFirst+"']"));	

		WebElement msrp = driver.findElement(By.xpath("//input[@data-vbws-compare='" + modelFirst+"']" + "//following::span[2]"));
		String msrpValue = msrp.getText();

		WebElement priceValue = driver.findElementByXPath("//input[@data-vbws-compare='" + modelFirst+"']" + "//following::span[2]//following::span[2]");
		priceContent1 = priceValue.getText();
		System.out.println("First selected model is " + modelFirst + " MSRP " + msrpValue + " value is " + priceContent1);

		/*priceFirst = msrpValue+" "+priceContent1;
		System.out.println("First model price is "+priceFirst);*/

		WebElement secondModel = driver.findElement(By.xpath("//input[@data-vbws-compare='" + modelSecond+"']"));
		WebElement msrp1 = driver.findElement(By.xpath("//input[@data-vbws-compare='" + modelSecond+"']" + "//following::span[2]"));
		String msrpValue1 = msrp1.getText();

		WebElement priceValue1 = driver.findElementByXPath("//input[@data-vbws-compare='" + modelSecond+"']" + "//following::span[2]//following::span[2]");
		priceContent2 = priceValue1.getText();
		System.out.println("Second selected model is " + modelSecond + " MSRP " + msrpValue1 + " value is " + priceContent2);

		//priceSecond = msrpValue1+" "+priceContent2;
		//System.out.println("Second model price is "+priceSecond);

		WebElement thirdModel = driver.findElement(By.xpath("//input[@data-vbws-compare='" + modelThird+"']"));
		WebElement msrp2 = driver.findElement(By.xpath("//input[@data-vbws-compare='" + modelThird+"']" + "//following::span[2]"));
		String msrpValue2 = msrp2.getText();

		WebElement priceValue2 = driver.findElementByXPath("//input[@data-vbws-compare='" + modelThird+"']" + "//following::span[2]//following::span[2]");
		priceContent3 = priceValue2.getText();
		System.out.println("Third selected model is " + modelThird + " MSRP " + msrpValue2 + " value is " + priceContent3);

		/*	priceThird = msrpValue2+" "+priceContent3;
		System.out.println("Third model price is "+priceThird);*/

		WebElement mpgFirst = driver.findElementByXPath("(//input[@data-vbws-compare='" + modelFirst+"']" + "//following::div[contains(text(),'EPA-est. Range')])[1]");
		String mpgContent = mpgFirst.getText();
		System.out.println("MPG value is "+ mpgContent );

		WebElement mpgvalue = driver.findElementByXPath("(//input[@data-vbws-compare='" + modelFirst+"']" + "//following::div[@class='vbws-spec-value'])[2]");
		String valueMPG = mpgvalue.getText();
		valueMPGFirst = valueMPG.replaceAll("[^0-9]","");
		System.out.println("MPG value is "+ valueMPGFirst );

		WebElement mpgSecond = driver.findElementByXPath("(//input[@data-vbws-compare='" + modelSecond+"']" + "//following::div[@class='vbws-spec-label'])[2]");
		String mpgContentSecond = mpgSecond.getText();
		System.out.println("MPG value is "+ mpgContentSecond );

		WebElement mpgvalueSecond = driver.findElementByXPath("(//input[@data-vbws-compare='" + modelSecond+"']" + "//following::div[@class='vbws-spec-value'])[1]");
		String valueMPG2 = mpgvalueSecond.getText().trim();
		valueMPGSecond = valueMPG2.replaceAll("[^0-9]","");
		System.out.println("MPG value is "+ valueMPGSecond );

		WebElement mpgThird = driver.findElementByXPath("(//input[@data-vbws-compare='" + modelThird+"']" + "//following::div[contains(text(),'EPA-est. Range')])[1]");
		String mpgContentThird = mpgThird.getText();
		System.out.println("MPG value is "+ mpgContentThird );

		WebElement mpgvalueThird = driver.findElementByXPath("(//input[@data-vbws-compare='" + modelThird+"']" + "//following::div[@class='vbws-spec-value'])[1]");
		String valueMPG3 = mpgvalueThird.getText().trim();
		valueMPGThird = valueMPG3.replaceAll("[^0-9]","");
		System.out.println("MPG value is "+ valueMPGThird );

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", firstModel);	
		js.executeScript("arguments[0].click();", secondModel);
		js.executeScript("arguments[0].click();", thirdModel);


		String vehicleCount = ReadExcelData.getdata(Testcasenumber, "Vehicle Count");
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.vehicleCount")))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.vehicleCount"), vehicleCount);
			reportStep("Selected vehicle count is dispalyed properly", "PASS", true);
		}
		else {
			reportStep("Selected vehicle count is not dispalyed properly", "FAIL", true);
		}


		if(driver.findElement(By.xpath(objValue.getProperty("xpath.compareButton")))!=null) {
			clickByXpath(objValue.getProperty("xpath.compareButton"), "Compare button is clicked from header");
			reportStep("Compare button is clicked from header after selecting the vehicle", "PASS", true);
		}
		else {
			reportStep("Compare button is not clicked from header after selecting the vehicle", "FAIL", true);
		}




		return this;	
	}

	public CompareVehicles compareVehiclesPopup(String Testcasenumber) throws IOException {

		String comparePopup = ReadExcelData.getdata(Testcasenumber, "ComparePopup");

		WebElement popupVehicle = driver.findElement(By.xpath(objValue.getProperty("xpath.comparePopup")));
		String vehicleComparePopup = popupVehicle.getText().trim();

		if(vehicleComparePopup.contains(comparePopup)) {
			reportStep("Compare Vehicle popup is verified properly", "PASS", true);
		}
		else {
			reportStep("Compare Vehicle popup is not verified properly", "PASS", true);
		}

		String comparePopupYearValue = getTextByXpath(objValue.getProperty("xpath.compareModelYear1"));
		reportStep("Model Year is dispalyed from Compare popup " +comparePopupYearValue, "PASS", true);

		String comparePopupNameValue = getTextByXpath(objValue.getProperty("xpath.compareModelName1"));
		reportStep("Model Year is dispalyed from Compare popup " +comparePopupNameValue, "PASS", true);


		String compareFirstModel = comparePopupYearValue+" "+comparePopupNameValue;
		if(compareFirstModel.equals(modelFirst)) {
			System.out.println("First Model "+compareFirstModel);
			reportStep("First Model is verified from Compare page to Compare Competitors popup", "PASS", true);
		}

		else {
			reportStep("First Model is not verified from Compare page to Compare Competitors popup", "FAIL", true);
		}

		String comparePopupPriceValue = getTextByXpath(objValue.getProperty("xpath.compareModelPrice1"));
		reportStep("Price is dispalyed from Compare popup " +comparePopupPriceValue, "PASS", true);

		String comparePopupPriceContent = getTextByXpath(objValue.getProperty("xpath.compareModelPriceContent1"));
		reportStep("Price is dispalyed from Compare popup " +comparePopupPriceContent, "PASS", true);

		String compareFirstModelPrice = comparePopupPriceValue+" "+comparePopupPriceContent;	

		if(compareFirstModelPrice.contains(priceContent1)) {
			System.out.println("First Model Price "+compareFirstModelPrice);
			reportStep("First Model Price is verified from Compare page to Compare Competitors popup", "PASS", true);
		}

		else {
			reportStep("First Model Price is not verified from Compare page to Compare Competitors popup", "FAIL", true);
		}

		String comparePopupMPGValue = getTextByXpath(objValue.getProperty("xpath.compareMPGValue1"));
		valueMPG = comparePopupMPGValue.replaceAll("[^\\d]","");
		reportStep("MPG value is dispalyed from Compare popup " +valueMPG, "PASS", true);

		/*if(valueMPG.contains(valueMPGFirst)) {
			System.out.println("MPG Value is "+comparePopupMPGValue);
			reportStep("MPG Value is verified from Compare page to Compare Competitors popup for first vehicle", "PASS", true);
		}

		else {
			reportStep("MPG Value is not verified from Compare page to Compare Competitors popup for first vehicle", "FAIL", true);
		}*/

		// Verifying second model from the popup
		 comparePopupYearValue2 = getTextByXpath(objValue.getProperty("xpath.compareModelYear2"));
		reportStep("Model Year is dispalyed from Compare popup " +comparePopupYearValue2, "PASS", true);

		 comparePopupNameValue2 = getTextByXpath(objValue.getProperty("xpath.compareModelName2"));
		reportStep("Model Year is dispalyed from Compare popup " +comparePopupNameValue2, "PASS", true);


		 compareFirstModel2 = comparePopupYearValue2+" "+comparePopupNameValue2;
		if(compareFirstModel2.equals(modelSecond)) {
			System.out.println("Second Model "+compareFirstModel2);
			reportStep("Second Model is verified from Compare page to Compare Competitors popup", "PASS", true);
		}

		else {
			reportStep("Second Model is not verified from Compare page to Compare Competitors popup", "FAIL", true);
		}

		String comparePopupPriceValue2 = getTextByXpath(objValue.getProperty("xpath.compareModelPrice2"));
		reportStep("Second Model Price is dispalyed from Compare popup " +comparePopupPriceValue2, "PASS", true);

		String comparePopupPriceContent2 = getTextByXpath(objValue.getProperty("xpath.compareModelPriceContent2"));
		reportStep("Second Model Price is dispalyed from Compare popup " +comparePopupPriceContent2, "PASS", true);

		String compareFirstModelPrice2 = comparePopupPriceValue2+" "+comparePopupPriceContent2;	

		if(compareFirstModelPrice2.contains(priceContent2)) {
			System.out.println("Second Model Price "+compareFirstModelPrice2);
			reportStep("Second Model Price is verified from Compare page to Compare Competitors popup", "PASS", true);
		}

		else {
			reportStep("Second Model Price is not verified from Compare page to Compare Competitors popup", "FAIL", true);
		}

		String comparePopupMPGValue2 = getTextByXpath(objValue.getProperty("xpath.compareMPGValue2"));
		valueMPG2 = comparePopupMPGValue2.replaceAll("[^\\d]","");
		reportStep("MPG value is dispalyed from Compare popup " +valueMPG2, "PASS", true);

		if(valueMPG2.contains(valueMPGSecond)) {
			System.out.println("MPG Value is "+comparePopupMPGValue2);
			reportStep("Second Model MPG Value is verified from Compare page to Compare Competitors popup for second vehicle", "PASS", true);
		}

		else {
			reportStep("Second Model MPG Value is not verified from Compare page to Compare Competitors popup for second vehicle", "FAIL", true);
		}

		//Verifying for third vehicle

		String comparePopupYearValue3 = getTextByXpath(objValue.getProperty("xpath.compareModelYear3"));
		reportStep("Third Model Year is dispalyed from Compare popup " +comparePopupYearValue3, "PASS", true);

		String comparePopupNameValue3 = getTextByXpath(objValue.getProperty("xpath.compareModelName3"));
		reportStep("Third Model Year is dispalyed from Compare popup " +comparePopupNameValue3, "PASS", true);


		String compareFirstModel3 = comparePopupYearValue3+" "+comparePopupNameValue3;
		if(compareFirstModel3.equals(modelThird)) {
			System.out.println("Third Model "+compareFirstModel3);
			reportStep("Third Model is verified from Compare page to Compare Competitors popup", "PASS", true);
		}

		else {
			reportStep("Third Model is not verified from Compare page to Compare Competitors popup", "FAIL", true);
		}

		String comparePopupPriceValue3 = getTextByXpath(objValue.getProperty("xpath.compareModelPrice3"));
		reportStep("Third Model Price is dispalyed from Compare popup " +comparePopupPriceValue3, "PASS", true);

		String comparePopupPriceContent3 = getTextByXpath(objValue.getProperty("xpath.compareModelPriceContent3"));
		reportStep("Third Model Price is dispalyed from Compare popup " +comparePopupPriceContent3, "PASS", true);

		String compareFirstModelPrice3 = comparePopupPriceValue3+" "+comparePopupPriceContent3;	

		if(compareFirstModelPrice3.contains(priceContent3)) {
			System.out.println("Third Model Price "+compareFirstModelPrice3);
			reportStep("Third Model Price is verified from Compare page to Compare Competitors popup", "PASS", true);
		}

		else {
			reportStep("Third Model Price is not verified from Compare page to Compare Competitors popup", "FAIL", true);
		}

		String comparePopupMPGValue3 = getTextByXpath(objValue.getProperty("xpath.compareMPGValue3"));
		valueMPG3 = comparePopupMPGValue3.replaceAll("[^\\d]","");
		reportStep("MPG value is dispalyed from Compare popup " +valueMPG3, "PASS", true);

		/*if(valueMPG3.contains(valueMPGThird)) {
			System.out.println("MPG Value is "+comparePopupMPGValue3);
			reportStep("Third Model MPG Value is verified from Compare page to Compare Competitors popup for third vehicle", "PASS", true);
		}

		else {
			reportStep("Third Model MPG Value is not verified from Compare page to Compare Competitors popup for third vehicle", "FAIL", true);
		}*/

		return this;

	}

	public CompareVehicles buildCTACompare(String Testcasenumber) throws IOException {
		comparemodel = ReadExcelData.getdata(Testcasenumber, "CompareModel");
		WebElement buildButton = driver.findElementByXPath("(//a[@aria-label='Build " +comparemodel+ "'])[2]");
		buildButton.click();
		reportStep("First Model " +comparemodel+ " build button is clicked from Compare popup", "PASS", true);

		String build = getTextByXpath(objValue.getProperty("xpath.buildVerify"));
		reportStep("Build page " +build+" is verified from Compare popup", "PASS", true);

		return this;
	}

	public CompareVehicles exploreCTACompare(String Testcasenumber) throws IOException {
		comparemodel2 = ReadExcelData.getdata(Testcasenumber, "CompareModel1");
		WebElement exploreButton = driver.findElementByXPath("(//a[@aria-label='Explore " +comparemodel2+ "'])[2]");
		exploreButton.click();
		reportStep("Second Model " +comparemodel2+ " explore button is clicked from Compare popup", "PASS", true);

		String explore = getTextByXpath(objValue.getProperty("xpath.vlpVerify"));
		reportStep("Explore page " +explore+" is verified from Compare popup", "PASS", true);

		return this;
	}


	public CompareVehicles compareCompetitorsCTA(String Testcasenumber) throws IOException {
		String comparemodel2 = ReadExcelData.getdata(Testcasenumber, "CompareModel1");
		WebElement compareCompetitorsButton = driver.findElementByXPath("(//a[@aria-label='Compare " +comparemodel2+ " with competitors'])[2]");
		compareCompetitorsButton.click();
		reportStep("Second Model " +comparemodel2+ " Compare Competitors button is clicked from Compare popup", "PASS", true);

		WebElement compare = driver.findElementByXPath("//h1[text()='Compare Hyundai with the Competition']");
		String competitorsPage = compare.getText();
		reportStep("Compare Competitors Page " +competitorsPage+" is verified from Compare popup", "PASS", true);

		sleepTime(40);
		String modelYear = ReadExcelData.getdata(Testcasenumber, "Vehiclemodel");
		if(driver.findElementByXPath(objValue.getProperty("xpath.modelYear")).isDisplayed()) {
			if(comparePopupYearValue2.equals(modelYear)) {
				reportStep("Model Year "+comparePopupYearValue2+ " is prepopulated from Compare popup page", "PASS", true);	
			}
			//selectVisibileTextByXPath(objvalue.getProperty("xpath.modelYear"), modelYear);

		}

		else {
			reportStep("Model Year "+modelYear+ " is not prepopulated from Compare popup page", "FAIL", true);
		}

		String modelName = ReadExcelData.getdata(Testcasenumber, "VehicleName");
		if(driver.findElementByXPath(objValue.getProperty("xpath.modelName")).isDisplayed()) {
			if(comparePopupNameValue2.equals(modelName)) {
				reportStep("Model Year "+comparePopupNameValue2+ " is prepopulated from Compare popup page", "PASS", true);		
				
			}
			//selectVisibileTextByXPath(objvalue.getProperty("xpath.modelName"), modelName);

		}

		else {
			reportStep("Model Year "+modelName+ " is not prepopulated from Compare popup page", "FAIL", true);
		}

		String modelSecond = ReadExcelData.getdata(Testcasenumber, "Model1");
		String vehicleName	= comparePopupYearValue2+ " " +comparePopupNameValue2;
		System.out.println("Vehicle Model name is "+vehicleName); 
		if(modelSecond.equals(vehicleName)) {
			reportStep("Vehicle selected in Compare popup is displayed in Compare Competitors page", "PASS", true);
		}

		else {
			reportStep("Vehicle selected in Compare popup is not displayed in Compare Competitors page", "FAIL", true);
		}

		String modelTrim = ReadExcelData.getdata(Testcasenumber, "Trimselection");
		if(driver.findElementByXPath(objValue.getProperty("xpath.modelTrim"))!=null) {
			selectVisibileTextByXPath(objValue.getProperty("xpath.modelTrim"), modelTrim);
			reportStep("Model Year "+modelTrim+ " is prepopulated from Compare popup page", "PASS", true);		
		}

		else {
			reportStep("Model Year "+modelTrim+ " is not prepopulated from Compare popup page", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.addCTA"))!=null) {
			clickByXpath(objValue.getProperty("xpath.addCTA"),"Add button is clicked");
			reportStep("Add button is clicked from Compare Competitors page", "PASS", true);		
		}

		else {
			reportStep("Add button is not clicked from Compare Competitors page", "FAIL", true);
		}

		return this;

	}

	public CompareVehicles vehicleComparison(String Testcasenumber) {
		sleepTime(20);
		if(driver.findElementByXPath(objValue.getProperty("xpath.make"))!=null) {
			String make1 = getTextByXpath(objValue.getProperty("xpath.make"));
			System.out.println("first Model is "+make1);
			reportStep("First " +make1+" compare model is displayed", "PASS", true);
		}

		else
		{
			reportStep("First compare model is displayed", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.makemodel"))!=null) {
			String make2 = getTextByXpath(objValue.getProperty("xpath.makemodel"));
			reportStep("Second " +make2+" compare model is displayed", "PASS", true);
		}

		else
		{
			reportStep("Second compare model is displayed", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.compareCTA"))!=null) {
			clickByXpath(objValue.getProperty("xpath.compareCTA"), "Compare button is clicked");
			reportStep("Compare button is clicked", "PASS", true);
		}
		else {
			reportStep("Compare button is not clicked", "FAIL", true);
		}

		return this;

	}

	public CompareVehicles compareSection(String Testcasenumber) {
		sleepTime(10);
		if(driver.findElementByXPath(objValue.getProperty("xpath.features"))!=null) {
			if(driver.findElementByXPath(objValue.getProperty("xpath.price"))!=null) {
				String Price = getTextByXpath(objValue.getProperty("xpath.price"));
				reportStep("Default accordion under Features toggle " +Price+ " is displayed", "PASS", true);	
			}
			else {
				reportStep("Default accordion under Features toggle is not displayed", "FAIL", true);	
			}

			//scrollElementByPixel(objvalue.getProperty("xpath.exterior"));
			if(driver.findElementByXPath(objValue.getProperty("xpath.exterior"))!=null) {
				String exterior = getTextByXpath(objValue.getProperty("xpath.exterior"));
				System.out.println("Exterior toggle "+exterior);
				reportStep("Feature accordion under Features toggle " +exterior+ " is displayed", "PASS", true);
			}
			else {			
				reportStep("Feature toggle is not displayed properly", "FAIL", true);
			}

			if(driver.findElementByXPath(objValue.getProperty("xpath.specifications"))!=null) {
				clickByXpath(objValue.getProperty("xpath.specifications"), "Specification toggle is clicked");
				if(driver.findElementByXPath(objValue.getProperty("xpath.price"))!=null) {
					String Price = getTextByXpath(objValue.getProperty("xpath.price"));
					reportStep("Default accordion under Specifications toggle " +Price+ " is displayed", "PASS", true);		
				}
				else {
					reportStep("Default accordion under Specifications toggle is not displayed", "FAIL", true);	
				}

				//scrollElementByPixel(objvalue.getProperty("xpath.engine"));
				if(driver.findElementByXPath(objValue.getProperty("xpath.engine"))!=null) {
					String engine = getTextByXpath(objValue.getProperty("xpath.engine"));
					System.out.println("Specifications toggle "+engine);
					reportStep("Specifications accordion under Specifications toggle " +engine+ " is displayed", "PASS", true);
				}
				else {			
					reportStep("Specifications toggle is not displayed properly", "FAIL", true);
				}

				if(driver.findElementByXPath(objValue.getProperty("xpath.images"))!=null) {
					clickByXpath(objValue.getProperty("xpath.images"), "Images toggle is clicked");
					sleepTime(15);
					if(driver.findElementByXPath(objValue.getProperty("xpath.imagePhotos"))!=null) {
						String Photos = getTextByXpath(objValue.getProperty("xpath.imagePhotos"));
						System.out.println("Images toggle "+Photos);
						reportStep("Images toggle " +Photos+ " is displayed", "PASS", true);				
					}
					else {			
						reportStep("Images toggle is not displayed properly", "FAIL", true);
					}
				}	

			}
		}
		return this;
	}



	public CompareVehicles changeVehicleCTA(String Testcasenumber) throws IOException {
		if(driver.findElementByXPath(objValue.getProperty("xpath.changeCTA"))!=null) {
			clickByXpath(objValue.getProperty("xpath.changeCTA"), "Change Vehicle link is clicked");
			reportStep("Change Vehicle link is clicked properly", "PASS", true);
		}

		else {
			reportStep("Change Vehicle link is not clicked properly", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.changeVehicleLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.changeVehicleLink"), "Change Vehicle link is clicked");
			reportStep("Change Vehicle link is clicked properly from Competitors Page", "PASS", true);
		}

		else {
			reportStep("Change Vehicle link is not clicked properly from Competitors Page", "FAIL", true);
		}

		String changeHeader = ReadExcelData.getdata(Testcasenumber, "CompareHeader");
		if(driver.findElementByXPath(objValue.getProperty("xpath.compareVehiclePage"))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.compareVehiclePage"), changeHeader);
			reportStep("Competitors Page is displayed by clicking change link", "PASS", true);
		}

		else {
			reportStep("Competitors Page is not displayed by clicking change link", "FAIL", true);
		}

		return this;

	}

	public CompareVehicles buildLink(String Testcasenumber) {
		sleepTime(20);
		if(driver.findElementByXPath(objValue.getProperty("xpath.buildLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.buildLink"), "Build link is clicked");
			String build = getTextByXpath(objValue.getProperty("xpath.buildVerify"));
			reportStep("Build page " +build+" is verified from Compare Competitors Page", "PASS", true);
		}
		else {
			reportStep("Build page is not verified from Compare Competitors Page", "FAIL", true);
		}

		return this;

	}

	public CompareVehicles exploreLink(String Testcasenumber) {
		sleepTime(20);
		if(driver.findElementByXPath(objValue.getProperty("xpath.exploreLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.exploreLink"), "Explore link is clicked");
			String explore = getTextByXpath(objValue.getProperty("xpath.vlpVerify"));
			reportStep("Explore page " +explore+" is verified from Compare Competitors Page", "PASS", true);
		}
		else {
			reportStep("Explore page is not verified from Compare Competitors Page", "FAIL", true);
		}

		return this;

	}

}
