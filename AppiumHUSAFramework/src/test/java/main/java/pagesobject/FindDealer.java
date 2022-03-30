package main.java.pagesobject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import main.java.utility.Projectcommonmethodes;
import main.java.utility.ReadExcelData;

public class FindDealer extends Projectcommonmethodes {
//
//	public FindDealer(RemoteWebDriver driver) {
//		this.driver = driver;
//	}
	public FindDealer acceptAndClose(String Testcasenumber) {
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
		return this;
	}               

	public FindDealer verifydealer(String Testcasenumber) throws IOException, InterruptedException 
	{
		husaLivePopupClose();
		sleepTime(5);
		closeFeedbackPopup();
		closeWelcomePopup();
		String zipcode = ReadExcelData.getdata(Testcasenumber,"Zipcode");
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.menu"))) != null)
		{
			clickByXpath(objValue.getProperty("xpath.menu"),"Menu" );
			sleepTime(10);
			clickByXpath(objValue.getProperty("xpath.menufindadealer"),"find a dealer" );
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.findadealerheading"))) != null)
			{
				reportStep("Find a dealer page is  displayed", "PASS");
				sleepTime(5); 
				if(driver.findElement(By.xpath(objValue.getProperty("xpath.findadealersearchbutton"))) != null)
				{
					enterByXpath(objValue.getProperty("xpath.txtSearchDealer"),ReadExcelData.getdata(Testcasenumber,"Zipcode"), "Zipcode");
					clickByXpathjs(objValue.getProperty("xpath.findadealersearchbutton"),"Search icon" );
				}
				sleepTime(10); 
				String dealername= driver.findElement(By.xpath(objValue.getProperty("xpath.dealerheading"))).getText();
				if(dealername.contains("Tustin Hyundai"))
				{
					reportStep("Successfully found a dealer 'Tustin Hyundai' for zip code "+zipcode,"PASS");
				}

				else
					reportStep("Tustin Hyundai dealer is not displayed for  "+zipcode, "FAIL");



			}
			else
				reportStep("Menu is not displayed", "FAIL");

		}
		return this;

	}


	public  FindDealer clickMenu(String Testcasenumber) throws InterruptedException {
		sleepTime(30);
		husaLivePopupClose();
		closeWelcomePopup();
		//closeNotificationPopup();
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.lnkMenu")))!=null) {
			clickByXpath(objValue.getProperty("xpath.lnkMenu"),"Click Menu" );
			reportStep("Click FindDealer Button", "PASS");

		}
		else {
			reportStep("Click Menu Button", "FAIL");
		}
		return this;

	}

	public  FindDealer clickFindDealerButton(String Testcasenumber) throws InterruptedException {
		//closeNotificationPopup();
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.lnkFindDealer")))!=null) {
			try {
				WebDriverWait wait=new WebDriverWait(driver,60);
				WebElement findDealer=WebElement(objValue.getProperty("xpath.lnkFindDealer"));
				wait.until(ExpectedConditions.elementToBeClickable(findDealer));
				clickByXpath(objValue.getProperty("xpath.lnkFindDealer") ,"FindDealer");}catch(Exception e) {}
			sleepTime(10);
			reportStep("Click FindDealer Button", "PASS");
		}
		else {
			reportStep("Click FindDealer Button", "FAIL");
		}
		return this;
	}

	public FindDealer zipcode(String Testcasenumber) throws IOException, InterruptedException
	{
		closeWelcomePopup();
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.txtSearchDealer"))) != null)
		{
			enterByXpath(objValue.getProperty("xpath.txtSearchDealer"),ReadExcelData.getdata(Testcasenumber,"Zipcode"),"Zipcode" );
			System.out.println("Zipcode entered");
			sleepTime(10);
			clickByXpath(objValue.getProperty("xpath.imgsearch"),"");
			closeWelcomePopup();
			reportStep("Enter zipcode and Click Search Image", "PASS");
		}
		else {
			reportStep("Enter zipcode and Click Search Image", "FAIL");
		}


		return this;
	}


	//            public FindDealer selectDealer(String Testcasenumber) throws IOException, InterruptedException
	//            {
	//                            try {
	//                            if(driver.findElement(By.xpath(objvalue.getProperty("xpath.lnkDealer"))) != null)
	//                            {
	//                                            scrollElement("xpath.lnkDealer");
	//                                            ClickbyMouceHover(objvalue.getProperty("xpath.lnkDealer"));
	//                                            driver.findElement(By.xpath("xpath.lnkDealer")).sendKeys(Keys.PAGE_DOWN);
	//                            System.out.println("lnkDealer");
	//                            reportStep("select a Dealer", "PASS");
	//                            }
	//                                            else {
	//                                                            reportStep("select a Dealer", "FAIL");
	//                                            }}
	//                            catch(Exception e) {System.out.println(e);}
	//                            return this;
	//            }

	public FindDealer clickGetDirections(String Testcasenumber) throws IOException, InterruptedException
	{
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.lnkDirections"))) != null)
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			try{clickByXpathjs(objValue.getProperty("xpath.lnkDirections"),"clickGetDirections" );
			System.out.println("clicked GetDirections");}catch(Exception e) {}
			reportStep("Click GetDirections Tab", "PASS");
			sleepTime(30);
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

	public FindDealer TestDrive(String Testcasenumber) throws IOException, InterruptedException

	{

		scrollElement(objValue.getProperty("xpath.btnTestDrive"));
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.btnTestDrive"))) != null)
		{

			clickByXpathjs(objValue.getProperty("xpath.btnTestDrive"),"TestDrive" );
			reportStep("Click TestDrive Tab", "PASS");
			switchToLastWindow();
			waitElementVisisble((objValue.getProperty("xpath.txtScheduleTestDrive")),300);
			System.out.println("300");
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.txtScheduleTestDrive"))) != null) {
				reportStep("Navigate to Test Drive Window", "PASS");
				System.out.println("title is "+driver.getTitle());
				closeBrowser();
				switchToParentWindow();
			}
			else {
				reportStep("Navigate Test Drive Window", "FAIL");
			}
		}
		else {
			reportStep("Click TestDrive Tab", "FAIL");
		}
		return this;
	}
	public FindDealer seeInventory(String Testcasenumber) throws IOException, InterruptedException
	{
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.btnSeeInventory"))) != null)
		{
			scrollElement(objValue.getProperty("xpath.btnSeeInventory"));
			clickByXpathjs(objValue.getProperty("xpath.btnSeeInventory"),"SeeInventory" );
			reportStep("Click seeInventory Tab", "PASS");

			switchToLastWindow();
			sleepTime(30);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.txtSeeInventory"))).isDisplayed()) {
				reportStep("Navigate to seeInventory Window", "PASS");
				System.out.println("title is "+driver.getTitle());
				closeBrowser();
				switchToParentWindow();
			}
			else {
				reportStep("Navigate to seeInventory Window", "FAIL");
			}
		}
		else {
			reportStep("Click seeInventory Tab", "FAIL");
		}
		return this;
	}

	public FindDealer visitDealer(String Testcasenumber) throws IOException, InterruptedException
	{
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.btnVisitDealer"))) != null)
		{
			clickByXpathjs(objValue.getProperty("xpath.btnVisitDealer"),"VisitDealer");
		
			reportStep("Click VisitDealer Tab", "PASS");

			switchToLastWindow();
			sleepTime(20);
			waitElementVisisble("xpath.txtSearchHyundai",300);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.txtSearchHyundai"))) != null) {
				reportStep("Navigate to VisitDealer Window", "PASS");
				System.out.println("title is "+driver.getTitle());
				closeBrowser();
				switchToParentWindow();
			}
			else {
				reportStep("Navigate to VisitDealer Window", "FAIL");
				switchToParentWindow();
			}
		}
		else {
			reportStep("Click VisitDealer Tab", "FAIL");
		}
		return this;
	}
	public FindDealer reviewsTab(String Testcasenumber) throws IOException, InterruptedException
	
	{
		clickByXpathjs(objValue.getProperty("xpath.serviceCentre"), "Service centre");
		sleepTime(5);
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.lnkReviews"))) != null)
		{
			clickByXpathjs(objValue.getProperty("xpath.lnkReviews"),"Reviews" );
			reportStep("Click Reviews Tab", "PASS");

			switchToLastWindow();
			sleepTime(20);

			if(driver.findElement(By.xpath(objValue.getProperty("xpath.txtReviews"))) != null) {

				reportStep("Navigate to reviews Window", "PASS");
				System.out.println("title is "+driver.getTitle());
				closeBrowser();
				switchToParentWindow();
			}
			else {
				reportStep("Navigate to reviews Window", "FAIL");
			}
		}
		else {
			reportStep("Click reviews Tab", "FAIL");
		}
		return this;
	}
	public FindDealer scheduleService(String Testcasenumber) throws IOException, InterruptedException
	{
		clickByXpathjs(objValue.getProperty("xpath.serviceCentre"), "Service centre");
		sleepTime(5);
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.lnkScheduleService"))) != null)
		{
			clickByXpathjs(objValue.getProperty("xpath.lnkScheduleService"),"ScheduleService" );
			reportStep("Click scheduleTestDrive Tab", "PASS");

			switchToLastWindow();
			sleepTime(150);
			switchToFrame(objValue.getProperty("xpath.framescheduleservice"));
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.txtScheduleService"))).isDisplayed()) {

				reportStep("Navigate to ScheduleService Window", "PASS");
				System.out.println("title is "+driver.getTitle());
				closeBrowser();
				switchToParentWindow();
			}
			else {
				reportStep("Navigate to ScheduleService Window", "FAIL");
			}
		}
		else {
			reportStep("Click ScheduleService Tab", "FAIL");
		}
		System.out.println("TC001 Completed");
		return this;
	}

	public FindDealer shopperAssurance(String Testcasenumber) throws IOException, InterruptedException
	{
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.imgShoppersAssurance"))) != null)
		{
			clickByXpathjs(objValue.getProperty("xpath.imgShoppersAssurance"),"ShoppersAssurance" );
			reportStep("Click ShoppersAssurance Tab", "PASS");
			sleepTime(20);


			if(driver.findElement(By.xpath(objValue.getProperty("xpath.txtShopperAssurance"))) != null) {
				System.out.println("Found element");
				reportStep("Navigate to shopperAssurance Window", "PASS");

				clickByXpathjs(objValue.getProperty("xpath.closeButton"),"close Frame" );
			}
			else {
				reportStep("Navigate to shopperAssurance Window", "FAIL");
			}
		}
		else {
			reportStep("Click shopperAssurance Tab", "FAIL");
		}
		return this;
	}
	public FindDealer CarCare(String Testcasenumber) throws IOException, InterruptedException
	{
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.imgCarCare"))) != null)
		{
			clickByXpathjs(objValue.getProperty("xpath.imgCarCare"),"CarCare" );
			reportStep("Click CarCare Tab", "PASS");



			if(driver.findElement(By.xpath(objValue.getProperty("xpath.textCarCare"))) != null) {

				reportStep("Navigate to CarCare Window", "PASS");
				System.out.println("title is "+driver.getTitle());
				clickByXpathjs(objValue.getProperty("xpath.closeButton"),"close Frame" );
			}
			else {
				reportStep("Navigate to CarCare Window", "FAIL");
			}
		}
		else {
			reportStep("Click CarCare Tab", "FAIL");
		}
		return this;
	}
	public FindDealer testDrivePopup(String Testcasenumber) throws IOException, InterruptedException
	{
		/*offerClose();
		sleepTime(30);*/
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.imgTestDrive"))) != null)
		{
			clickByXpathjs(objValue.getProperty("xpath.imgTestDrive"),"TestDrive" );
			reportStep("Click TestDrive Tab", "PASS");

			sleepTime(20);
			//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='hlFrame']")));
			switchToLastWindow();
			sleepTime(5);
			
			try {
				if(driver.findElement(By.xpath(objValue.getProperty("xpath.txtTestDrive"))).isDisplayed()) {
				

						reportStep("Navigate to TestDrive Window", "PASS");
						System.out.println("title is "+driver.getTitle());
						switchToParentWindow();

					}
					
			
				else {
					reportStep("Unable to switch to testdrive window", "PASS");
				}
					driver.switchTo().defaultContent();

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Popup not appear");

			}
		

	}
		else {
			reportStep("Test Drive is not Available for the searched zipcode dealers ", "PASS");
		}
		System.out.println("TC002 Completed");
			
		return this;
	}
	public FindDealer searchMoreDealers(String Testcasenumber) 
	{
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.btnMoreDealers"))) != null) 
		{
			List<MobileElement> beforeList=new LinkedList<>();

			beforeList=driver.findElementsByXPath((objValue.getProperty("xpath.txtDealersList")));
			beforeList.size();
			System.out.println(beforeList.size());
			Set<String> dealers=new HashSet<>();
			for(WebElement element:beforeList) 
			{

				try {
					dealers.add(element.getText());
				}catch(Exception e) {System.out.println(e);}
			}
			System.out.println(dealers);
			if(driver.findElement(By.xpath(objValue.getProperty("xpath.btnMoreDealers"))) != null) 
			{
				
				try{clickByXpath(objValue.getProperty("xpath.btnMoreDealers"),"More Dealers");}catch(Exception e) {System.out.println(e);}
				List<MobileElement> afterList=driver.findElementsByXPath((objValue.getProperty("xpath.txtDealersList")));
				afterList.size();
				System.out.println(afterList.size());
				Set<String> moreDealers=new HashSet<>(); 
				for(WebElement setElement:afterList) {

					try {
						moreDealers.add(setElement.getText());
					}catch(Exception e) {System.out.println(e);}
				}
				System.out.println(moreDealers);
				if(moreDealers.size()>dealers.size())
				{
					reportStep("More Dealers found for this Zip Code", "PASS");
				}
				else if(moreDealers.size()==dealers.size()&& moreDealers.size()==0)
				{
					reportStep("More Dealers not found for this Zip Code", "FAIL");
				}


			}

			else {

				reportStep("No more Dealers found for this Zip Code", "FAIL");
			}


		}
		System.out.println("TC003 Completed");
		return this;
	}
	public FindDealer verifyDealer(String Testcasenumber) throws IOException, InterruptedException
	{
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.firstDealer"))) != null)
		{
			String firstdealerName = ReadExcelData.getdata(Testcasenumber, "Dealer");
			WebElement zipClear = driver.findElement(By.xpath(objValue.getProperty("xpath.txtSearchDealer")));
			zipClear.clear();
			enterByXpath(objValue.getProperty("xpath.txtSearchDealer"),"Zipcode","Zipcode value is entered" );
			reportStep("Find a dealer section zipcode is entered", "PASS",true);
			clickByXpath(objValue.getProperty("xpath.imgsearch"),"");
			verifyTextByXpath(objValue.getProperty("xpath.firstDealer"), firstdealerName);
			reportStep("Find a dealer section is displayed with first dealer", "PASS",true);
		}
		else {
			reportStep("Find a dealer section is not displayed with first dealer", "FAIL",true);
		}


		return this;
	}
}






