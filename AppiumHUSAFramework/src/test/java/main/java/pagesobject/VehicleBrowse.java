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




public class VehicleBrowse extends Projectcommonmethodes{
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
	String valueMPG3 = "";

	public VehicleBrowse(AppiumDriver<MobileElement> driver) {

		this.driver =driver;
	}
	JavascriptExecutor js = (JavascriptExecutor)driver;

	public VehicleBrowse clickVehicleNav(String Testcasenumber) throws IOException, InterruptedException {
		//zipCodePopup();
		sleepTime(10);
		//closeWelcomePopup();
		//closeNotificationPopup();

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

	public VehicleBrowse allCategoryVerification(String Testcasenumber) throws InterruptedException {
		closeWelcomePopup();
		sleepTime(5);
		closeNotificationPopup();
		sleepTime(5);

		clickByXpath(objValue.getProperty("xpath.VehicleNav"), "Vehicles navigation");
		sleepTime(5);

		WebElement vehicleHeader = driver.findElement(By.xpath(objValue.getProperty("xpath.Vehiclelandingheader")));

		String vehicleBrowseVerify = vehicleHeader.getText().trim();

		if(vehicleBrowseVerify.equalsIgnoreCase("Choose Your Hyundai")) {
			reportStep("Vehcle browse page dislayed properly", "PASS", true);


		}
		else {

			reportStep("Error occured while navigating to Vehcle browse page", "FAIL", true);
		}
		List<MobileElement> categories = driver.findElements(By.xpath("//div[@class='vbws-group-title']"));
		int countCat = categories.size();

		for(int i=1;i<=countCat;i++) {

			WebElement cateogry1 = driver.findElement(By.xpath("(//div[@class='vbws-group-title'])["+i+"]"));

			String categoryTxt = cateogry1.getText().trim();

			if(categoryTxt.equalsIgnoreCase("SUVs")) {


				reportStep(categoryTxt+"category displayed in vehicle browse page", "PASS");


			}
			else if(categoryTxt.equalsIgnoreCase("Sedans")) {


				reportStep(categoryTxt+"category displayed in vehicle browse page", "PASS");


			}
			else if(categoryTxt.equalsIgnoreCase("Compacts")) {


				reportStep(categoryTxt+"category displayed in vehicle browse page", "PASS");


			}

			else {
				reportStep("Unable to find vehicle category", "FAIL");


			}

		}


		return this;
	}
	public static String vehcompare,Getprice,Getmpg,Gethp;
	public VehicleBrowse allCategoryVehicleList(String Testcasenumber) throws IOException {

		String VehicleList = ReadExcelData.getdata(Testcasenumber, "AllVehiclesList");

		String[] vehicleListArray = VehicleList.split(",");
		System.out.println("Vehicle List"+vehicleListArray);

	
		List<MobileElement> vehiclelist = driver.findElements(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car'])"));
		int vehSize = vehiclelist.size();
		System.out.println("Total Vehicle List"+vehSize);
		for ( int i=1;i<=vehiclelist.size();i++)
		{

			WebElement	Vehiclename1 =  driver.findElement(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car']//div[@class='vbws-car-name'])["+i+"]"));
			String  Vehiclename2 = Vehiclename1.getText();
			String  Vehiclename = Vehiclename2.replaceAll("[^a-zA-Z0-9]", "");
			WebElement	Vehiclemodel1 =  driver.findElement(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car']/h3/div[@class='vbws-car-year'])["+i+"]"));		
			String  Vehiclemodel = Vehiclemodel1.getText();
			vehcompare = Vehiclemodel+Vehiclename;
			if(vehcompare.equalsIgnoreCase(vehicleListArray[i]))

			{
				
				System.out.println(vehicleListArray[i]);
				reportStep(vehicleListArray[i]+"Vehicle displayed in the All vehicles List in browse page", "PASS", true);
				

			}
			else {
				reportStep(vehicleListArray[i]+"Vehicle not displayed in the All vehicles List in browse page", "FAIL", true);
			
			}


		}

		return this;

	}
	
	public VehicleBrowse suvsCategoryVerify(String Testcasenumber) throws IOException, InterruptedException {
		
		closeWelcomePopup();
		sleepTime(5);
		closeNotificationPopup();
		sleepTime(5);

		clickByXpath(objValue.getProperty("xpath.VehicleNav"), "Vehicles navigation");
		sleepTime(5);
		closeWelcomePopup();
		sleepTime(5);
		
		clickByXpathjs(objValue.getProperty("xpath.suvVehCategory"), "SUVs category Vehicle");
		sleepTime(5);
		String SuvsVehicleList = ReadExcelData.getdata(Testcasenumber, "SUVSVehicleList");

		String[] SuvvehicleListArray = SuvsVehicleList.split(",");
		
		List<MobileElement> suvsVehicleList = driver.findElements(By.xpath("//div[@class='vbws-group vbws-group-active']/div"));
		WebElement vehCategory = driver.findElement(By.xpath("(//div[@class='vbws-group vbws-group-active']/div)[1]"));
		String categoryName = vehCategory.getText().trim();
		
		int vehSuvs = suvsVehicleList.size();
		for(int i=1;i<vehSuvs;i++) {
			
			/*WebElement suvVehList = driver.findElement(By.xpath("//div[@class='vbws-group vbws-group-active']/div["+i+"]//div//div//a//following::label//span[@class='sr-only']"));
			String vehNameSuvs = suvVehList.getText().trim();
			System.out.println("Veh name in the Application"+vehNameSuvs);*/
			
			WebElement	Vehiclename1 =  driver.findElement(By.xpath("(//div[@class='vbws-car-name'])["+i+"]"));
			String  Vehiclename2 = Vehiclename1.getText();
			String  Vehiclename = Vehiclename2.replaceAll("[^a-zA-Z0-9]", "");
			WebElement	Vehiclemodel1 =  driver.findElement(By.xpath("(//div[@class='vbws-car-year'])["+i+"]"));		
			String  Vehiclemodel = Vehiclemodel1.getText();
			vehcompare = Vehiclemodel+Vehiclename;
			
			if(vehcompare.equalsIgnoreCase(SuvvehicleListArray[i])) {
				
				System.out.println(SuvvehicleListArray[i]);
				
				reportStep(SuvvehicleListArray[i]+categoryName+" vehicle category displayed in the Vehicle Browse page", "PASS", true);
				
			}
			else {
				reportStep(SuvvehicleListArray[i]+"Error occured while navigating to" +categoryName+" vehicle category", "FAIL", true);
				
			}
			
			
			
		}
		
		return this;
	}
	
/*public VehicleBrowse sedansCategoryVerify(String Testcasenumber) throws IOException, InterruptedException {
	
	closeWelcomePopup();
	sleepTime(5);
	closeNotificationPopup();
	sleepTime(5);

	clickByXpath(objValue.getProperty("xpath.VehicleNav"), "Vehicles navigation");
	sleepTime(5);
	closeWelcomePopup();
	sleepTime(5);
	clickByXpathjs(objValue.getProperty("xpath.sedansVehCategory"), "Sedans category Vehicle");
		
		String sedansVehicleList = ReadExcelData.getdata(Testcasenumber, "SedansVehicleList");

		String[] sedansvehicleListArray = sedansVehicleList.split(",");
		
		List<WebElement> sedanVehicleList = driver.findElements(By.xpath("//div[@class='vbws-group vbws-group-active']/div"));
		int vehsedan = sedanVehicleList.size();
		for(int i=2;i<vehsedan;i++) {
			
			WebElement sedanVehList = driver.findElement(By.xpath("//div[@class='vbws-group vbws-group-active']/div["+i+"]//div//div//a//following::label//span"));
			String vehNameSedans = sedanVehList.getText().trim();
			
			WebElement	Vehiclename1 =  driver.findElement(By.xpath("(//div[@class='vbws-car-name'])["+i+"]"));
			String  Vehiclename2 = Vehiclename1.getText();
			String  Vehiclename = Vehiclename2.replaceAll("[^a-zA-Z0-9]", "");
			WebElement	Vehiclemodel1 =  driver.findElement(By.xpath("(//div[@class='vbws-car-year'])["+i+"]"));		
			String  Vehiclemodel = Vehiclemodel1.getText();
			vehcompare = Vehiclemodel+Vehiclename;
			
			if(vehNameSedans.equalsIgnoreCase(sedansvehicleListArray[i])) {
				
				reportStep(sedansvehicleListArray[i]+"Sedans vehicle category displayed properly", "PASS", true);
				
			}
			else {
				reportStep(sedansvehicleListArray[i]+"Error occured while navigating to Sedans vehicle category", "FAIL", true);
				
			}
			
			
			
		}
		
		return this;
	}*/
public VehicleBrowse sedansCategoryVerifyNew(String Testcasenumber) throws IOException, InterruptedException {
	
	closeWelcomePopup();
	sleepTime(5);
	closeNotificationPopup();
	sleepTime(5);

	clickByXpath(objValue.getProperty("xpath.VehicleNav"), "Vehicles navigation");
	sleepTime(5);
	closeWelcomePopup();
	sleepTime(5);
	clickByXpathjs(objValue.getProperty("xpath.sedansVehCategory"), "Sedans category Vehicle");
		
		String sedansVehicleList = ReadExcelData.getdata(Testcasenumber, "SedansVehicleList");

		String[] sedansvehicleListArray = sedansVehicleList.split(",");
		
		List<MobileElement> suvsVehicleList = driver.findElements(By.xpath("//div[@class='vbws-group vbws-group-active']/div"));
		WebElement vehCategory = driver.findElement(By.xpath("(//div[@class='vbws-group vbws-group-active']/div)[1]"));
		String categoryName = vehCategory.getText().trim();
		
		int vehSuvs = suvsVehicleList.size();
		int k=14;
for(int j=0;j<vehSuvs;j++) {
		for(int i=8;i<k;i++) {
			
			
			
			/*WebElement suvVehList = driver.findElement(By.xpath("//div[@class='vbws-group vbws-group-active']/div["+i+"]//div//div//a//following::label//span[@class='sr-only']"));
			String vehNameSuvs = suvVehList.getText().trim();
			System.out.println("Veh name in the Application"+vehNameSuvs);*/
			
			WebElement	Vehiclename1 =  driver.findElement(By.xpath("(//div[@class='vbws-car-name'])["+i+"]"));
			String  Vehiclename2 = Vehiclename1.getText();
			String  Vehiclename = Vehiclename2.replaceAll("[^a-zA-Z0-9]", "");
			WebElement	Vehiclemodel1 =  driver.findElement(By.xpath("(//div[@class='vbws-car-year'])["+i+"]"));		
			String  Vehiclemodel = Vehiclemodel1.getText();
			vehcompare = Vehiclemodel+Vehiclename;
			
			if(vehcompare.equalsIgnoreCase(sedansvehicleListArray[j])) {
				
				reportStep(sedansvehicleListArray[j]+categoryName+" vehicle category displayed properly", "PASS", true);
				
			}
			
			else {
				reportStep(sedansvehicleListArray[j]+"Error occured while navigating to"+categoryName+" Sedans vehicle category", "FAIL", true);
				
			}
			
			j++;	
			
		}
			
		
		}
		return this;
	}
public VehicleBrowse compactsCategoryVerify(String Testcasenumber) throws InterruptedException, IOException {
	

	closeWelcomePopup();
	sleepTime(5);
	closeNotificationPopup();
	sleepTime(5);

	clickByXpath(objValue.getProperty("xpath.VehicleNav"), "Vehicles navigation");
	sleepTime(5);
	closeWelcomePopup();
	sleepTime(5);
	clickByXpathjs(objValue.getProperty("xpath.compactVehCategory"), "Compact category Vehicle");
		
		String compactsVehicles = ReadExcelData.getdata(Testcasenumber, "CompactsVehicleList");

		String[] compactsvehicleListArray = compactsVehicles.split(",");
		
		List<MobileElement> compactsVehicleList = driver.findElements(By.xpath("//div[@class='vbws-group vbws-group-active']/div"));
		WebElement vehCategory = driver.findElement(By.xpath("(//div[@class='vbws-group vbws-group-active']/div)[1]"));
		String categoryName = vehCategory.getText().trim();
		
		int vehSuvs = compactsVehicleList.size();
		int k=20;
for(int j=0;j<vehSuvs;j++) {
		for(int i=15;i<=k;i++) {
			
			
			
			/*WebElement suvVehList = driver.findElement(By.xpath("//div[@class='vbws-group vbws-group-active']/div["+i+"]//div//div//a//following::label//span[@class='sr-only']"));
			String vehNameSuvs = suvVehList.getText().trim();
			System.out.println("Veh name in the Application"+vehNameSuvs);*/
			
			WebElement	Vehiclename1 =  driver.findElement(By.xpath("(//div[@class='vbws-car-name'])["+i+"]"));
			String  Vehiclename2 = Vehiclename1.getText();
			String  Vehiclename = Vehiclename2.replaceAll("[^a-zA-Z0-9]", "");
			WebElement	Vehiclemodel1 =  driver.findElement(By.xpath("(//div[@class='vbws-car-year'])["+i+"]"));		
			String  Vehiclemodel = Vehiclemodel1.getText();
			vehcompare = Vehiclemodel+Vehiclename;
			
			if(vehcompare.equalsIgnoreCase(compactsvehicleListArray[j])) {
				
				reportStep(compactsvehicleListArray[j]+categoryName+" vehicle category displayed properly", "PASS", true);
				
			}
			
			else {
				reportStep(compactsvehicleListArray[j]+"Error occured while navigating to"+categoryName+" Sedans vehicle category", "FAIL", true);
				
			}
			
			j++;	
			
		}
			
		
		}
		return this;
	
}


public VehicleBrowse compactsCategoryVerifyOld(String Testcasenumber) throws IOException, InterruptedException {
	
	closeWelcomePopup();
	sleepTime(5);
	closeNotificationPopup();
	sleepTime(5);

	clickByXpath(objValue.getProperty("xpath.VehicleNav"), "Vehicles navigation");
	sleepTime(5);

	
	clickByXpath(objValue.getProperty("xpath.compactVehCategory"), "Compacts category Vehicle");
	
	String compactsVehicleList = ReadExcelData.getdata(Testcasenumber, "CompactsVehicleList");

	String[] compactsvehicleListArray = compactsVehicleList.split(",");
	
	List<MobileElement> compactVehicleList = driver.findElements(By.xpath("//div[@class='vbws-group vbws-group-active']/div"));
	int vehcompact= compactVehicleList.size();
	for(int i=2;i<vehcompact;i++) {
		
		WebElement compactVehList = driver.findElement(By.xpath("//div[@class='vbws-group vbws-group-active']/div["+i+"]//div//div//a//following::label//span"));
		String vehNameCompact = compactVehList.getText().trim();
		
		if(vehNameCompact.equals(compactsvehicleListArray[i])) {
			
			reportStep(compactsvehicleListArray[i]+"Compacts vehicle category displayed properly", "PASS", true);
			
		}
		else {
			reportStep(compactsvehicleListArray[i]+"Error occured while navigating to Compacts vehicle category", "FAIL", true);
			
		}
		
	}
	
	return this;
}

public VehicleBrowse comparePopupVerify(String Testcasenumber) throws InterruptedException {
	clickByXpath(objValue.getProperty("xpath.VehicleNav"), "Vehicles navigation");
	sleepTime(5);
	closeWelcomePopup();
	sleepTime(5);
	closeNotificationPopup();
	
	if(driver.findElement(By.xpath(objValue.getProperty("xpath.compareLink")))!=null) {
		clickByXpath(objValue.getProperty("xpath.compareLink"), "Compare link is clicked");
		reportStep("Compare link is clicked from Compare page", "PASS", true);
	}
	else {
		reportStep("Compare link is not clicked from Compare page", "FAIL", true);
	}
	return this;
}


public VehicleBrowse vehicleSelector(String Testcasenumber) throws IOException, InterruptedException {
	closeWelcomePopup();

	modelFirst = ReadExcelData.getdata(Testcasenumber, "Model");
	modelSecond = ReadExcelData.getdata(Testcasenumber, "Model1");
	modelThird = ReadExcelData.getdata(Testcasenumber, "Model2");
	clickByXpathjs(objValue.getProperty("xpath.compareLink"), "Compare Link");
	sleepTime(5);
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

public VehicleBrowse compareVehiclesPopup(String Testcasenumber) throws IOException {

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
	reportStep("Model Name is dispalyed from Compare popup " +comparePopupNameValue, "PASS", true);
	
	return this;
}




}
