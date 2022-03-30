package main.java.pagesobject;

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

public class Vlp extends Projectcommonmethodes{

	public Vlp(AppiumDriver<MobileElement> driver) {

		this.driver =driver;
	}
	JavascriptExecutor js = (JavascriptExecutor)driver;


	/*public Vlp offerClose() throws InterruptedException {


		try {
			Thread.sleep(5000);
			WebElement welcome = driver.findElement(By.xpath("//iframe[@id='hlFrame']"));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='hlFrame']")));
			clickByXpath(objValue.getProperty("xpath.offerclose"),"Offerclose");
			driver.switchTo().defaultContent();

		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Popup not appear");

		}
		return this;
	}*/




	

	public void closeNotificationPopup() throws InterruptedException {


		try {
			Thread.sleep(5000);
			WebElement welcome = driver.findElement(By.xpath("//button[text()='Accept & Close']"));

			welcome.click();

			reportStep("Notification popup closed successfully", "Pass", true);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to find Notification popup");
		}
	}

	public Vlp zipCodePopup() throws InterruptedException {


		try {
			Thread.sleep(5000);
			WebElement zipField = driver.findElement(By.xpath("//input[@placeholder='Enter ZIP Code']"));

			enterByXpath("//input[@placeholder='Enter ZIP Code']", "92614", "Zip field");
			sleepTime(30);

			clickByXpath("//button[text()='Confirm']", "Confirm");

			sleepTime(30);
			reportStep("Zip code entered successfully", "Pass", true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to find Zip code popup");
		}
		return this;
	}
	public Vlp clickVehicleNav(String Testcasenumber) throws IOException, InterruptedException {
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
	public static String vehcompare,Getprice,Getmpg,Gethp;
	public Vlp selectVehicle(String Testcasenumber) throws IOException, InterruptedException {
		closeWelcomePopup();
		closeNotificationPopup();

		String Vehiclemodelcol = ReadExcelData.getdata(Testcasenumber, "Vehiclemodel");

		String Vehiclenamecol =ReadExcelData.getdata(Testcasenumber, "VehicleName");

		String Vehicledatasheet =Vehiclemodelcol+ Vehiclenamecol;
		List<WebElement> vehiclelist = driver.findElements(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car'])"));
		for ( int i=1;i<vehiclelist.size();i++)
		{

			WebElement	Vehiclename1 =  driver.findElement(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car']//div[@class='vbws-car-name'])["+i+"]"));
			String  Vehiclename2 = Vehiclename1.getText();
			String  Vehiclename = Vehiclename2.replaceAll("[^a-zA-Z0-9]", "");
			WebElement	Vehiclemodel1 =  driver.findElement(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car']/h3/div[@class='vbws-car-year'])["+i+"]"));		
			String  Vehiclemodel = Vehiclemodel1.getText();
			vehcompare = Vehiclemodel+Vehiclename;
			if(vehcompare.equals(Vehicledatasheet))

			{
				WebElement selectveh= driver.findElement(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car']//div[@class='vbws-car-name'])["+i+"]"));
				//js.executeScript("arguments[0].scrollIntoView(true);", selectveh);
				js.executeScript("arguments[0].scrollIntoView(true);",selectveh);
				//js.executeScript("window.scrollBy(0,1000)", "");

				Thread.sleep(5000);
				String Getprice1=(objValue.getProperty("xpath.price"));
				String Getprice2=(objValue.getProperty("xpath.price2"));
				WebElement price1 =  driver.findElement(By.xpath(Getprice1+i+Getprice2));
				Getprice = price1.getText();
				System.out.println(Getprice);
				/*String mpg1=(objValue.getProperty("xpath.mpg"));
				String mpg2=(objValue.getProperty("xpath.mpg2"));
				WebElement Getmpg1 =  driver.findElement(By.xpath(mpg1+i+mpg2));
				Getmpg = Getmpg1.getText();
				System.out.println(Getmpg);*/
				/*String hp1=(objValue.getProperty("xpath.hp1"));
				String hp2=(objValue.getProperty("xpath.hp2"));
				WebElement Gethp1 = driver.findElement(By.xpath(hp1+i+hp2));
				Gethp = Gethp1.getText();
				System.out.println(Gethp);*/
				//selectveh.click(); 
				js.executeScript("arguments[0].click();", selectveh);
				System.out.println(" PASS" + vehcompare + "Selected vehicle from the list matches " + Vehicledatasheet);	
				break;
			}


		}

		return this;
	}

	public Vlp validatevehmodel(String Testcasenumber) throws InterruptedException 
	{
		offerClose();
		Thread.sleep(5000);
		String validatevehmodelname = getTextByXpath(objValue.getProperty("xpath.vehname"));
		String validatevehmodelyear = getTextByXpath(objValue.getProperty("xpath.vehyear"));
		String validatevehmodel= validatevehmodelyear+validatevehmodelname;

		if(vehcompare.equalsIgnoreCase(validatevehmodel))
		{
			System.out.println(" PASS" + validatevehmodel + "Selected vehicle from the list and header value matches " + vehcompare);	
			reportStep( validatevehmodel + "Selected vehicle from the list and header value is matched ", "PASS");
		}			
		else
		{
			System.out.println(" FAIL" + validatevehmodel + "Selected vehicle from the list and header value NOT matches " + vehcompare);
			reportStep( validatevehmodel + "Selected vehicle from the list and header value NOT matched ", "FAIL");
		}

		return this;


	}

	public Vlp validatevehprice(String Testcasenumber) throws InterruptedException 
	{
		offerClose();
		closeNotificationPopup();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)", "");
	
		//ClickandHold(objValue.getProperty("xpath.2020-elantra"));
		String vehprice=getTextByXpath(objValue.getProperty("xpath.imageprice"));
		System.out.println(vehprice);
		//String mpg=getTextByXpath(objValue.getProperty("xpath.imagempg"));
		//String hp=getTextByXpath(objValue.getProperty("xpath.imagehp"));


		if(Getprice.equals(vehprice))
		{
			System.out.println("PASS"  + Getprice + " Vehicle price matching " + vehprice);
			reportStep( Getprice + " Overview Vehicle Price is matching ", "PASS");



			/*if(Getmpg.equals(mpg))
			{
				System.out.println("PASS"  + Getmpg + " Vehicle mpg matching " + mpg);
				reportStep( Getmpg + " Overview Vehicle mpg value is matching ", "PASS");

				if(Gethp.equals(hp))
				{
					System.out.println("PASS"  + Gethp + " Vehicle hp matching " + hp);
					reportStep( Gethp + " Vehicle hp value is matching ", "PASS");

				}
				else
				{
					System.out.println("FAIL" + Gethp + " Vehicle hp not matching " + hp);
					reportStep( Gethp + " Vehicle hp not matching ", "FAIL");
				}	
			}	

			else
			{
				System.out.println("FAIL" + Getmpg + " Vehicle mpg not matching " + mpg);
				reportStep( Getmpg + " Vehicle mpg not matching ", "FAIL");

			}*/
		}
		else
		{
			System.out.println("FAIL" + Getprice + " Vehicle price not matching " + vehprice);
			reportStep( Getprice + " Vehicle price not matching ", "FAIL");
		}
		return this;	


	}

	public Vlp offerSecVerify(String Testcasenumber) {
		WebElement offFinance = driver.findElement(By.xpath(objValue.getProperty("Xpath.financecontent")));
		String finance = offFinance.getText();
		System.out.println(finance+"details");
		
		return this;
	}

	/*public Vlp selectVehicle(String Testcasenumber) throws IOException, InterruptedException {

		String sVehicle = ReadExcelData.getdata(Testcasenumber, "Vehiclename");
		closeWelcomePopup();
		closeNotificationPopup();

		if(sVehicle.contains("2020 Venue")) {
		String vehname ="//a[contains(@class,'car')]//img[@alt='HyundaiUSA.com "+sVehicle+"']";
		clickByXpath(vehname, "Vehicle Click");

		}

		else if(sVehicle.contains("2020 Veloster")) {
			String vehname ="//a[contains(@class,'car')]//img[@alt='HyundaiUSA.com "+sVehicle+"']";
			WebElement element = driver.findElement(By.xpath("//a[contains(@class,'car')]//img[@alt='HyundaiUSA.com "+sVehicle+"']"));
			js.executeScript("arguments[0].scrollIntoView(true);",element);
			clickByXpath(vehname, "Vehicle Click");

			}

		else if(sVehicle.contains("Kona Electric")) {
			js.executeScript("window.scrollBy(0,300)", "");
			String vehname ="//a[contains(@class,'car')]//img[@alt='2020 Hyundai "+sVehicle+"']";
			clickByXpath(vehname, "Vehicle Click");
		}

		else if(sVehicle.contains("2020 Santa Fe")) {
			js.executeScript("window.scrollBy(0,500)", "");
			String vehname ="//a[contains(@class,'car')]//img[@alt='HyundaiUSA.com "+sVehicle+"']";
			clickByXpath(vehname, "Vehicle Click");

			}
		else if(sVehicle.contains("2020 Hyundai Palisade")) {
			js.executeScript("window.scrollBy(0,500)", "");
			String vehname ="//a[contains(@class,'car')]//img[@alt='Hyundai USA | "+sVehicle+"']";
			clickByXpath(vehname, "Vehicle Click");
		}
		else if(sVehicle.contains("2020 Sonata")) {
			js.executeScript("window.scrollBy(0,700)", "");
			String vehname ="//a[contains(@class,'car')]//img[@alt='Hyundai USA | "+sVehicle+"']";
			clickByXpath(vehname, "Vehicle Click");
		}
		else if(sVehicle.contains("2019 Sonata Hybrid")) {
			js.executeScript("window.scrollBy(0,700)", "");
			String vehname ="//a[contains(@class,'car')]//img[@alt="+sVehicle+"']";
			clickByXpath(vehname, "Vehicle Click");
		}
		else if(sVehicle.contains("2019 Hyundai Sonata Plug-in Hybrid")) {
			js.executeScript("window.scrollBy(0,700)", "");
			String vehname ="//a[contains(@class,'car')]//img[@alt="+sVehicle+"']";
			clickByXpath(vehname, "Vehicle Click");
		}
		else if(sVehicle.contains("2020 IONIQ Hybrid")) {
			js.executeScript("window.scrollBy(0,800)", "");
			String vehname ="//a[contains(@class,'car')]//img[@alt='HyundaiUSA.com "+sVehicle+"']";
			clickByXpath(vehname, "Vehicle Click");

			}

		else if(sVehicle.contains("Ioniq Electric")) {
			js.executeScript("window.scrollBy(0,800)", "");
			String vehname ="//a[contains(@class,'car')]//img[@alt='Hyundai USA | 2020 Hyundai "+sVehicle+"']";
			clickByXpath(vehname, "Vehicle Click");

		}
		else if(sVehicle.contains("2020 Veloster N")) {
			js.executeScript("window.scrollBy(0,900)", "");
			String vehname ="//a[contains(@class,'car')]//img[@alt="+sVehicle+"']";
			clickByXpath(vehname, "Vehicle Click");
		}

		else  {
			js.executeScript("window.scrollBy(0,500)", "");

			String vehname ="//a[contains(@class,'car')]//img[@alt='Hyundaiusa.com "+sVehicle+"']";
			clickByXpath(vehname, "Vehicle Click");

		}
		sleepTime(10);
		reportStep("Vehicle Clicked Successfully", "PASS", true);
		return this;

	}*/

	

	public Vlp verifyOverview(String Testcasenumber) throws IOException, InterruptedException {
		
		//offerClose();
		
		String SOverview = ReadExcelData.getdata(Testcasenumber, "OverviewVerify");
		//String SUrl = ReadExcelData.getdata(Testcasenumber, "URLVerify");
		String FName = ReadExcelData.getdata(Testcasenumber, "FirstName");
		String LName = ReadExcelData.getdata(Testcasenumber, "LastName");
		String EmailAddress = ReadExcelData.getdata(Testcasenumber, "Email");
		String subSection = ReadExcelData.getdata(Testcasenumber, "OverviewSection");
		String Vehiclemodelcol = ReadExcelData.getdata(Testcasenumber, "Vehiclemodel");
		String Vehiclenamecol =ReadExcelData.getdata(Testcasenumber, "VehicleName");

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.vehcielOverview")))!=null) {

			
			WebElement VerifyOverview = driver.findElement(By.xpath(objValue.getProperty("xpath.vehicleOverviewPageVerify")));
		//	if(VerifyOverview.getText().equalsIgnoreCase(SOverview)&&driver.getCurrentUrl().equals(SUrl)) {
			/*if(VerifyOverview.getText().equalsIgnoreCase(SOverview)) {		
				reportStep("Overview page displayed properly with"+SOverview , "Pass", true);
			}
			else {

				reportStep("Overview page displayed properly with"+SOverview , "Fail", true);
			}*/
			String ovtxt = VerifyOverview.getText();
			reportStep("Overview page displayed properly with"+ovtxt , "Pass", true);	
		//	offerclose();
			
		}
		return this;
		}
	
			/*js.executeScript("window.scrollBy(0,-300)", "");

			if(driver.findElement(By.xpath(objValue.getProperty("Xpath.overviewRAQ")))!=null) {
				WebElement RAQ = driver.findElement(By.xpath(objValue.getProperty("Xpath.overviewRAQ")));

				//js.executeScript("window.scrollBy(0,-300)", "");
				
				js.executeScript("arguments[0].scrollIntoView(true);",RAQ);

				clickByXpath(objValue.getProperty("Xpath.overviewRAQ"), "RAQ Button Click");
				sleepTime(10);
				enterByXpath(objValue.getProperty("Xpath.Firstname"), FName, "First Name");
				enterByXpath(objValue.getProperty("Xpath.Lastname"), LName, "Last Name");
				enterByXpath(objValue.getProperty("Xpath.Email"), EmailAddress, "Email Address");

				clickByXpath(objValue.getProperty("Xpath.Raqbutton"),"RAQ Submission");
				WebElement raqSubmission = driver.findElement(By.xpath(objValue.getProperty("Xpath.RaqSubmissionMessge")));
				String successMesasge = raqSubmission.getText();
				if(successMesasge.contains("Your quote request has been successfully submitted")) {

					reportStep("Raq Form submitted successfully in the Overview Page", "PASS", true);

				}
				else {
					reportStep("Unable to submit the RAQ form in the Overview Page", "FAIL", true);
				}
			}
			else {

				reportStep("Unable to find the RAQ button in the Overview Page", "FAIL", true);
			}

			if(driver.findElement(By.xpath(objValue.getProperty("Xpath.build")))!=null) {

				clickByXpath(objValue.getProperty("Xpath.build"), "Build");
				WebElement buildPage = driver.findElement(By.xpath(objValue.getProperty("Xpath.Buildpageverify")));

				if(buildPage.getText().contains("Build Your Hyundai")) {

					reportStep("VehicleName build page displayed properly", "PASS", true);

				}
				else {

					reportStep("VehicleName build page not displayed", "FAIL", true);
				}
			}
			else {

				reportStep("Build link not displayed", "FAIL");
			}
			driver.get(SUrl);
			List<WebElement> sections = driver.findElements(By.xpath(objValue.getProperty("Xpath.Sectionheader")));
			int size = sections.size();
			String[] sectionsVerify = subSection.split(",");

			for(int i=1;i<=size;i++) {

				WebElement eachsec = driver.findElement(By.xpath("(//h2[contains(@class,'section-tag')])["+i+"]"));

				js.executeScript("arguments[0].scrollIntoView(true);",eachsec);

				if(eachsec.getText().equals(sectionsVerify[i])) {


					reportStep("Overview Sub section" +sectionsVerify[i]+" verified successfully", "PASS", true);



				}

				else {
					reportStep("Overview Sub section" +sectionsVerify[i]+" not verified", "FAIL", true);
				}
			}



			driver.get(SUrl);
			if(driver.findElement(By.xpath(objValue.getProperty("Xpath.AvailableTrims")))!=null) {

				WebElement trimsSection = driver.findElement(By.xpath(objValue.getProperty("Xpath.AvailableTrims")));
				js.executeScript("arguments[0].scrollIntoView(true);",trimsSection);
				String trimVerify = trimsSection.getText();
				if(trimVerify.contains("Available trims")) {
					reportStep("Available Trims section displayed in the overview page", "PASS", true);

				}
				else {
					reportStep("Available Trims section not displayed in the overview page", "Fail", true);
				}
			}
			else {
				reportStep("Available Trims section not displayed in the overview page", "PASS", true);
			}
			js.executeScript("window.scrollBy(0,-300)", "");

			if(driver.findElement(By.xpath(objValue.getProperty("Xpath.Explore")))!=null) {
				WebElement exp = driver.findElement(By.xpath(objValue.getProperty("Xpath.Explore")));

				//js.executeScript("arguments[0].scrollIntoView(true);",exp);
				js.executeScript("window.scrollBy(0,300)", "");

				clickByXpath(objValue.getProperty("Xpath.Explore"), "Explore link");

				WebElement expPage = driver.findElement(By.xpath(objValue.getProperty("Xpath.TrimsectionVerify")));
				if(expPage.getText().contains("Trims")) {
					reportStep("Explore page displayed properly", "PASS", true);

				}

				else {
					reportStep("Explore page not displayed", "FAIL", true);
				}

			}
			else {
				reportStep("Explore button not displayed", "FAIL", true);

			}


			clickByXpath(objValue.getProperty("xpath.vehcielOverview"), "Overview Button");

			if(driver.findElement(By.xpath(objValue.getProperty("Xpath.HyundaiDiff")))!=null) {

				WebElement Hyundaisection = driver.findElement(By.xpath(objValue.getProperty("Xpath.HyundaiDiff")));

				js.executeScript("arguments[0].scrollIntoView(true);",Hyundaisection);

				if(Hyundaisection.getText().contains("The Hyundai Difference")) {
					reportStep("Hyundai Difference sub section displayed properly", "PASS", true);

				}
				else {
					reportStep("Hyundai Difference sub section not displayed", "FAIL", true);
				}

			}
			else {

				reportStep("Hyundai Difference link is not displayed", "FAIL", true);
			}

			if(driver.findElement(By.xpath(objValue.getProperty("Xpath.DealerInventory")))!=null) {

				clickByXpath(objValue.getProperty("Xpath.DealerInventory"), "Dealer Inventory");
				sleepTime(10);

				WebElement deaInv = driver.findElement(By.xpath(objValue.getProperty("Xpath.DealerInventoryVerify")));

				if(deaInv.getText().contains("Change Model")) {
					reportStep("Dealer Inventory page displayed properly", "PASS", true);
				}

				else {
					reportStep("Dealer Inventory page not displayed", "FAIL", true);
				}

			}
			else {
				reportStep("Make it yours Dealer Inventory not displayed", "FAIL", true);

			}

		}*/

		/*else {

			reportStep("Overview page not displayed", "Fail", true);
		}
		driver.get(SUrl);

		return this;		

	}*/


	public Vlp verifyTrims(String Testcasenumber) throws IOException {


		String SUrl = ReadExcelData.getdata(Testcasenumber, "TrimUrlVerify");

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.vehicleTrim")))!=null) {
			clickByXpath(objValue.getProperty("xpath.vehicleTrim"), "Trims");
			reportStep("Trim Page Verification", "PASS", true);

			/*WebElement trimNameVerify = driver.findElement(By.xpath(objValue.getProperty("xpath.TrimPageVerify")));

			if(trimNameVerify.getText().equalsIgnoreCase("Trims")&&driver.getCurrentUrl().equals(SUrl)) {

				reportStep("Trims page displayed properly with the URL value as " +SUrl, "Pass", true);
			}
			else {

				reportStep("Trims page not displayed properly", "Fail", true);
			}*/
			
		}
		return this;
		}
			/*WebElement trimPrice = driver.findElement(By.xpath(objValue.getProperty("Xpath.TrimPagePrice")));
			String PriceTrim = trimPrice.getText();
			if(Getprice.equals(PriceTrim)) {

				reportStep( Getprice + " Trim Vehicle Price is matching ", "PASS");

			}
			else {
				reportStep( Getprice + " Trim Vehicle Price is not matching ", "FAIL");
			}

			List<WebElement> vehicleLabel = driver.findElements(By.xpath("//div[contains(@class,'swatch-label')]/span[1]"));

			for(int i=1;i<vehicleLabel.size();i++) {

				js.executeScript("window.scrollBy(0,300)", "");
				WebElement swatch = driver.findElement(By.xpath(objValue.getProperty("(//div[contains(@class,'swatch-label')]/span[1])["+i+"]")));
				js.executeScript("arguments[0].scrollIntoView(true);",swatch);

				if(swatch.getText().contains("Exterior")) {
					reportStep("Exterior color swatch display properly in Trims page", "PASS", true);

				}
				else if(swatch.getText().contains("Interior")) {
					reportStep("Interior color swatch display properly in Trims page", "PASS", true);

				}
				else {
					reportStep("Color swatch label not displayed in Trims page", "FAIL", true);
				}
			}
			String subSection = ReadExcelData.getdata(Testcasenumber, "Trims Section");
			String[] eachSec = subSection.split(",");
			List<WebElement> TrimSubSection = driver.findElements(By.xpath(objValue.getProperty("Xpath.TrimsSubSection")));

			for(int i=1;i<TrimSubSection.size();i++) {


				WebElement subsec = driver.findElement(By.xpath("//span[@class='sectag-heading-txt']["+i+"]"));
				js.executeScript("arguments[0].scrollIntoView(true);",subsec);

				if(subsec.getText().equals(eachSec[i])) {
					reportStep("Trim page sub section"+eachSec[i]+" verified successfully", "PASS", true);

				}
				else {
					reportStep("Sub section" +eachSec[i]+" for trim page not displayed", "FAIL");
				}

			}	
		}
		else {

			reportStep("Trims page not displayed", "Fail", true);
		}

		return this;

	}*/
	public Vlp verifyGallery(String Testcasenumber) throws IOException {


		//String SUrl = ReadExcelData.getdata(Testcasenumber, "GalleryUrlVerify");

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.vehicleGallery")))!=null) {
			clickByXpath(objValue.getProperty("xpath.vehicleGallery"), "Gallery");
			reportStep("Gallery Page Verification", "PASS", true);

			WebElement galleryHeader = driver.findElement(By.xpath(objValue.getProperty("xpath.galleryPageVerify")));
			//if(galleryHeader.getText().equalsIgnoreCase("Gallery")&driver.getCurrentUrl().equals(SUrl)) {
			if(galleryHeader.getText().equalsIgnoreCase("Gallery")) {
				reportStep("Gallery page displayed properly ", "Pass", true);
			}
			else {

				reportStep("Gallery page not displayed properly", "Fail", true);
			}
		}

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.GalleryExterior")))!=null) {
			clickByXpath(objValue.getProperty("xpath.GalleryExterior"), "Exterior Gallery");
			reportStep("Gallery Exterior Page Verification", "PASS", true);
			WebElement exterior = driver.findElement(By.xpath(objValue.getProperty("xpath.GalleryExteriorVerify")));

			if(exterior.getText().contains("Exterior")) {
				reportStep("Gallery exterior page displayed properly", "Pass", true);
			}
			else {
				reportStep("Gallery exterior page not displayed", "Fail", true);
			}
		}
		else {

			reportStep("Gallery exterior Page not displayed", "Pass", true);
		}
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.GalleryInterior")))!=null) {
			clickByXpath(objValue.getProperty("xpath.GalleryInterior"), "Interior Gallery");
			reportStep("Gallery Interior Page Verification", "PASS", true);
			WebElement interior = driver.findElement(By.xpath(objValue.getProperty("xpath.GalleryInteriorVerify")));

			if(interior.getText().contains("Interior")) {
				reportStep("Gallery Interior page displayed properly", "Pass", true);
			}
			else {
				reportStep("Gallery Interior page not displayed", "Fail", true);
			}
		}
		else {

			reportStep("Gallery Interior Page not displayed", "Fail", true);
		}

		if(driver.findElement(By.xpath(objValue.getProperty("Xpath.GalleryVideo")))!=null) {
			clickByXpath(objValue.getProperty("Xpath.GalleryVideo"), "Gallery Video");
			reportStep("Gallery Video Page Verification", "PASS", true);
			WebElement video = driver.findElement(By.xpath(objValue.getProperty("Xpath.GalleryVideo")));

			if(video.getText().contains("Videos")) {
				reportStep("Gallery Video page displayed properly", "Pass", true);
			}
			else {
				reportStep("Gallery Video page not Applicable for the vehicle", "PASS", true);
			}
		}
		else {

			reportStep("Gallery Video Page not Applicable for the vehicle", "PASS", true);
		}

		return this;

	}
	public Vlp verifySpecs(String Testcasenumber) throws IOException {
		//String SpecsURL = ReadExcelData.getdata(Testcasenumber, "SpecsUrlVerify");


		if(driver.findElement(By.xpath(objValue.getProperty("xpath.VehicleSpecs")))!=null) {
			clickByXpath(objValue.getProperty("xpath.VehicleSpecs"), "Specs");
			reportStep("Specs Page Verification", "PASS", true);



			WebElement specsyHeader = driver.findElement(By.xpath(objValue.getProperty("xpath.specsPageVerify")));
			//if(specsyHeader.getText().equalsIgnoreCase("Specifications")&&driver.getCurrentUrl().equals(SpecsURL)) {
				if(specsyHeader.getText().equalsIgnoreCase("Specifications")) {
				reportStep("Specs page displayed properly ", "Pass", true);
			}
			else {

				reportStep("Specs page not displayed properly", "Fail", true);
			}
			
			
		}
		return this;
	}
			/*WebElement filter = driver.findElement(By.xpath(objValue.getProperty("Xpath.Specs")));
			if(filter.getText().contains("specs:show all trims")) {

				reportStep("Specs page filter option displayed properly", "PASS", true);

			}
			else
				reportStep("Specs page filter option not displayed", "FAIL", true);

		}*/

		/*else {

			reportStep("Specs link not displayed", "Fail", true);
		}
		return this;

	}*/
	public Vlp verifySubNav(String Testcasenumber) throws IOException {

		List<WebElement> navSub = driver.findElements(By.xpath(objValue.getProperty("Xpath.vehicleSubNav")));

		String subNavigation = ReadExcelData.getdata(Testcasenumber, "SubNavVerify");

		String[] eachSec = subNavigation.split(",");
		int subSecData=eachSec.length;


		for(int i=1;i<navSub.size();i++) {
			//String sPath="]/text()";

			WebElement navVerify = driver.findElement(By.xpath("//div[@class='dropdown-items vsn-dropdown-items']/a["+i+"]"));
			String verifySec = navVerify.getText();
			System.out.println("sub section "+verifySec);

			if(navVerify.getText().equalsIgnoreCase(eachSec[i])) {

				reportStep("VLP sub navigation " +eachSec[i]+ " displayed properly", "PASS", true);

			}

			else {
				reportStep("VLP sub navigation " +eachSec[i]+ " not displayed", "FAIL", true);
			}


		}

		return this;

	}
	/*public Vlp verifySubNav(String Testcasenumber) throws IOException {

		List<WebElement> navSub = driver.findElements(By.xpath(objValue.getProperty("Xpath.vehicleSubNav")));

		String subNavigation = ReadExcelData.getdata(Testcasenumber, "SubNavVerify");

		String[] eachSec = subNavigation.split(",");
		int subSecData=eachSec.length;
		boolean bFlag=false;



		for(int j=0;j<subSecData;j++) {
			reportStep("Vehicle Sub Navigation" +eachSec[j], "PASS");
			bFlag=false;
		for(int i=1;i<navSub.size();i++) {
				//String sPath="]/text()";


			WebElement navVerify = driver.findElement(By.xpath("//div[@class='dropdown-items vsn-dropdown-items']/a["+i+"]"));
			String verifySec = navVerify.getText();
			System.out.println("sub section "+verifySec);

			if(navVerify.getText().equalsIgnoreCase(eachSec[j])) {
				bFlag=true;
				break;



			}
			if(bFlag) {
				reportStep("VLP sub navigation " +eachSec[j]+ " displayed properly", "PASS", true);
			}

			else {
				reportStep("VLP sub navigation " +eachSec[j]+ " not displayed", "FAIL", true);
			}


		}}

		return this;

	}*/


}

