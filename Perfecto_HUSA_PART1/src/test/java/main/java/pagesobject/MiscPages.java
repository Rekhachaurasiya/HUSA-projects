package main.java.pagesobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.WebElement;

import main.java.utility.Projectcommonmethodes;
import main.java.utility.ReadExcelData;

public class MiscPages extends Projectcommonmethodes {
	FindDealer ob = new FindDealer();
	String vehicleTrim,vehicleModel = "";
	String compactsVehicleModel = "";

//	public MiscPages(RemoteWebDriver driver) throws InterruptedException {
//
//		this.driver =driver;
//		closeNotificationPopup();
//	}


	JavascriptExecutor js = (JavascriptExecutor)driver;


	public MiscPages ownerAssuVerify(String Testcasenumber) throws IOException, InterruptedException {


		closeWelcomePopup();
		sleepTime(5);
		closeNotificationPopup();
		sleepTime(5);

		clickByXpathjs(objValue.getProperty("xpath.MenuClick"), "Menu Click");
		sleepTime(5);
		clickByXpathjs(objValue.getProperty("xpath.ownersLearnMore"), "Owner Assurance link click");
		sleepTime(5);
		closeWelcomePopup();
		sleepTime(5);
		String urlOwners = driver.getCurrentUrl();
		List<WebElement> ownersSubNav = driver.findElements(By.xpath("//div[@class='dropdown-items subnav-dropdown-items']/a"));

		int subNavsize = ownersSubNav.size();
		System.out.println("Owners sub nav size "+subNavsize);


		String ownersSubNavigation = ReadExcelData.getdata(Testcasenumber, "OwnersAssuranceVerify");

		String[] subNavSplit = ownersSubNavigation.split(",");

		for(int j=0;j<=subNavsize;j++) {
			for(int i=1;i<=subNavsize;i++) {

				WebElement eachSubNav = driver.findElement(By.xpath("(//div[@class='dropdown-items subnav-dropdown-items']/a["+i+"])"));
				String eachSubNavtext = eachSubNav.getText();
				js.executeScript("arguments[0].click();", eachSubNav);
				sleepTime(10);
				reportStep("Owners Assurance Sub navigation"+ eachSubNav+"clicked successfully", "PASS", true);

				WebElement subnavtitle = driver.findElement(By.xpath(objValue.getProperty("xpath.ownerTitleVerify")));
				String titleVerify = subnavtitle.getText();
				System.out.println("Owners title"+titleVerify);

				if(subNavSplit[j].equalsIgnoreCase(titleVerify)) {

					reportStep("Owners Assurance "+eachSubNavtext+" Section verified successfully", "PASS", true);
					if(subNavSplit[j].equalsIgnoreCase("Remote access with seamless connectivity")) {

						clickByXpath(objValue.getProperty("xpath.OwnersAssuranceClick"), "overview click");
						sleepTime(5);
					}

				}
				else {	
					reportStep("Error occured in the owners page Section verification", "FAIL", true);
				}
				j++;
			}

		}	

		return this;	
	}

	public MiscPages headerVerify(String Testcasenumber) throws InterruptedException {

		closeWelcomePopup();
		sleepTime(10);

		List<WebElement> headerNav = driver.findElements(By.xpath("//nav[@class='global-header-nav']/a"));

		String[] headerPageVerify= {"Choose Your Hyundai","Build Your Hyundai","Find Your Hyundai","Why Hyundai?"};


		for(int j=0;j<=headerNav.size();j++) {

			for(int i=1;i<=headerNav.size();i++) {

				WebElement headerClick = driver.findElement(By.xpath("//nav[@class='global-header-nav']/a["+i+"]"));
				String headerClicktext = headerClick.getText();
				js.executeScript("arguments[0].click();", headerClick);
				sleepTime(30);

				if(i==1) {
					WebElement vehPage = driver.findElement(By.xpath(objValue.getProperty("xpath.vehiclesHeader")));

					String vehPagetext = vehPage.getText();
					System.out.println(vehPagetext);

					if(vehPagetext.equalsIgnoreCase(headerPageVerify[j])) {

						reportStep(headerClicktext+" Page verified successfully", "PASS", true);


					}
					else {
						reportStep(headerClicktext+"Error occured in the section verification", "FAIL", true);
					}

				}
				if(i==2) {
					WebElement buildPage = driver.findElement(By.xpath(objValue.getProperty("xpath.buildHeader")));

					String buildPagetext = buildPage.getText();
					System.out.println(buildPagetext);

					if(buildPagetext.equalsIgnoreCase(headerPageVerify[j])) {

						reportStep(headerClicktext+" Page verified successfully", "PASS", true);


					}
					else {
						reportStep(headerClicktext+"Error occured in the Page verification", "FAIL", true);
					}

				}
				if(i==3) {
					WebElement invPage = driver.findElement(By.xpath(objValue.getProperty("xpath.inventoryHeader")));

					String invPagetext = invPage.getText();
					System.out.println(invPagetext);

					if(invPagetext.equalsIgnoreCase(headerPageVerify[j])) {

						reportStep(headerClicktext+" Page verified successfully", "PASS", true);


					}
					else {
						reportStep(headerClicktext+"Error occured in the section verification", "FAIL", true);
					}

				}
				if(i==4) {
					WebElement whyHyundaiPage = driver.findElement(By.xpath(objValue.getProperty("xpath.whyHyundaiheader")));

					String whyHyundaiPagetext = whyHyundaiPage.getText();

					System.out.println(whyHyundaiPagetext);
					if(whyHyundaiPagetext.equalsIgnoreCase(headerPageVerify[j])) {

						reportStep(headerClicktext+" Page verified successfully", "PASS", true);


					}
					else {
						reportStep(headerClicktext+" Error occured in the section verification", "FAIL", true);
					}

				}

				j++;	
			}

		}

		return this;
	}


	public MiscPages homeHeaderNav(String Testcasenumber) {

		clickByXpath(objValue.getProperty("xpath.HomepageNav"), "Home Logo navigation");

		String homePageTitle = driver.getTitle();

		if(homePageTitle.equalsIgnoreCase("Hyundai Cars, Sedans, SUVs, Compacts, and Luxury | Hyundai")) {

			reportStep("Home page verified successfully", "PASS", true);

		}
		else {
			reportStep("Error occured while navigating to Home page", "FAIL", true);
		}

		clickByXpath(objValue.getProperty("xpath.offersNav"), "Offers section navigation");


		WebElement offersPagetext = driver.findElement(By.xpath(objValue.getProperty("xpath.offersPageVerify")));
		String offersPageVerify = offersPagetext.getText();

		if(offersPageVerify.equalsIgnoreCase("Offers")) {

			reportStep("Offers page verified successfully", "PASS", true);

		}
		else {
			reportStep("Error occured while navigating to Offers page", "FAIL", true);
		}

		clickByXpath(objValue.getProperty("xpath.dealerNav"), "Dealer section navigation");


		WebElement dealersPagetext = driver.findElement(By.xpath(objValue.getProperty("xpath.dealerNavVerify")));
		String dealersPageVerify = dealersPagetext.getText();
		System.out.println("Dealer Page"+dealersPageVerify);

		if(dealersPageVerify.contains("Hyundai Dealerships near")) {

			reportStep("Find a Dealer page verified successfully", "PASS", true);

		}
		else {
			reportStep("Error occured while navigating to Find a Dealer page", "FAIL", true);
		}

		return this;
	}

	public MiscPages paymentCalculator(String Testcasenumber) throws IOException, InterruptedException {

		closeWelcomePopup();
		sleepTime(10);
		clickByXpathjs(objValue.getProperty("xpath.MenuClick"), "Menu Click");
		sleepTime(5);
		clickByXpathjs(objValue.getProperty("xpath.calPayButton"), "Payment calculator navigation");

		sleepTime(5);
		closeWelcomePopup();
		sleepTime(10);

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.vehSelection"))).isDisplayed()) {

			String modelName = ReadExcelData.getdata(Testcasenumber, "Model");

			String trimName = ReadExcelData.getdata(Testcasenumber, "Trimselection");
			String modelNameUpdated = modelName.replaceAll("\\s+", "");

			selectVisibileTextByXPath(objValue.getProperty("xpath.vehSelection"), modelName);
			reportStep("Vehicle selected for payment calculator", "PASS", true);
			sleepTime(15);
			selectVisibileTextByXPath(objValue.getProperty("xpath.vehTrimSelection"), trimName);
			sleepTime(10);
			reportStep("Trim selected for payment calculator", "PASS", true);
			WebElement SelVehYear = driver.findElement(By.xpath(objValue.getProperty("xpath.PayVehYear")));
			WebElement SelVehName = driver.findElement(By.xpath(objValue.getProperty("xpath.PayVehName")));
			WebElement SelVehTrim = driver.findElement(By.xpath(objValue.getProperty("xpath.PayVehTrim")));
			String vehYear = SelVehYear.getText();
			String vehName = SelVehName.getText();
			String selVehNameYr = vehYear.concat(vehName);
			System.out.println(selVehNameYr);
			String selVehTrimValue = SelVehTrim.getText();
			if(selVehNameYr.equalsIgnoreCase(modelNameUpdated)) {
				reportStep("Selected vehicle in the Paymnet calculator page is matching with the vehicle displayed", "PASS", true);

			}
			else {

				reportStep("Selected vehicle in the Paymnet calculator page is not matching with the vehicle displayed", "FAIL", true);
			}

			if(selVehTrimValue.equalsIgnoreCase(trimName)) {
				reportStep("Selected trim in the Paymnet calculator page is matching with the Trim displayed", "PASS", true);

			}
			else {

				reportStep("Selected trim in the Paymnet calculator page is not matching with the Trim displayed", "FAIL", true);
			}


			clickByXpathjs(objValue.getProperty("xpath.calButton"), "Calculate Payment button");
			sleepTime(10);
			reportStep("Calculate Payment button clicked successfully", "PASS", true);

		}



		return this;

	}

	public MiscPages payCalLinkVerify(String Testcasenumber) throws InterruptedException {

		closeWelcomePopup();
		sleepTime(5);
		closeNotificationPopup();
		sleepTime(5);
		List<WebElement> linksNav = driver.findElements(By.xpath("//div[@class='pcnf-link-container']/a"));

		for(int i=1;i<=linksNav.size();i++) {
			closeWelcomePopup();
			sleepTime(5);
			WebElement links = driver.findElement(By.xpath("//div[@class='pcnf-link-container']/a["+i+"]"));

			js.executeScript("arguments[0].click();", links);
			switchToLastWindow();
			sleepTime(30);
			if(i==1) {
				/*	WebElement credit = driver.findElement(By.xpath(objValue.getProperty("xpath.freeCreditscore")));
				String creditscore = credit.getText();*/
				//System.out.println("Credit score content"+creditscore);
				String creditTitle = driver.getTitle();
				if(creditTitle.equalsIgnoreCase("FREE Equifax Credit Score")) {
					reportStep("Free credit score displayed properly", "PASS", true);
				}	
				else {

					reportStep("Error occured while navigating to Free credit score page", "FAIL", true);
				}

			}
			if(i==2) {
				/*WebElement trade = driver.findElement(By.xpath(objValue.getProperty("xpath.valueTrade")));
				String tradevalue = trade.getText();*/
				//System.out.println("Credit score content"+tradevalue);
				String tradeValueTitle = driver.getTitle();
				if(tradeValueTitle.equalsIgnoreCase("Value Your Trade")) {
					reportStep("Trade-In Value displayed properly", "PASS", true);
				}	
				else {

					reportStep("Error occured while navigating to Trade-In Value page", "FAIL", true);
				}

			}


			driver.close();
			switchToParentWindow();
			sleepTime(5);
		}
		return this;
	}


	public MiscPages companyVeify(String Testcasenumber) throws InterruptedException {
		closeWelcomePopup();
		sleepTime(10);
		closeNotificationPopup();
		sleepTime(5);
		String carreresTitleVerify="";
		String eachSubNavVerify="";

		String[] companySubNav= {"Our Company","People come first","What’s Happening","Showing the world what we do best."};

		clickByXpath(objValue.getProperty("xpath.ourcompany"), "Our Company");
		sleepTime(5);

		List<WebElement> comsubNav = driver.findElementsByXPath("//div[@class='dropdown-items subnav-dropdown-items']/a");
		for(int j=0;j<=comsubNav.size();j++)	{
			for(int i=1;i<=comsubNav.size();i++) {

				WebElement eachSubNav = driver.findElement(By.xpath("//div[@class='dropdown-items subnav-dropdown-items']/a["+i+"]"));

				js.executeScript("arguments[0].click();", eachSubNav);



				if(i==2) {
					WebElement carreresTitle = driver.findElement(By.xpath(objValue.getProperty("xpath.careerText")));

					carreresTitleVerify = carreresTitle.getText();
					System.out.println("Our company sub navigation"+carreresTitleVerify);

				}

				else {

					WebElement companyTitle = driver.findElement(By.xpath(objValue.getProperty("xpath.comapnyTitleVerify")));

					eachSubNavVerify = companyTitle.getText();
					System.out.println("Our company sub navigation"+eachSubNavVerify);
				}

				if(eachSubNavVerify.equalsIgnoreCase(companySubNav[j])) {

					reportStep("Our company "+eachSubNavVerify+" subnavigation verified successfully", "PASS", true);

				}
				else if(carreresTitleVerify.equalsIgnoreCase(companySubNav[j])) {

					reportStep("Our company carreres subnavigation verified successfully", "PASS", true);
				}
				else {
					reportStep("Error occured in Our company subnavigation verification", "FAIL", true);

				}

				j++;
			}

		}
		return this;

	}

	public MiscPages newsVerify(String Testcasenumber) throws InterruptedException {

		closeWelcomePopup();
		sleepTime(5);
		closeNotificationPopup();
		sleepTime(5);

		//String[] newsSubNav= {"The latest Hyundai news","Social"};


		clickByXpath(objValue.getProperty("Xpath.News"), "News Link");
		closeWelcomePopup();
		sleepTime(5);
		WebElement verifyNews = driver.findElement(By.xpath(objValue.getProperty("xpath.NewsTitleVerify")));
		String NewsSec = verifyNews.getText().trim();
		System.out.println(NewsSec);
		if(NewsSec.equalsIgnoreCase("What’s Happening")) {
			reportStep("News Keep Me Update Section displayed properly", "PASS", true);

		}
		else {
			reportStep("News Keep Me Update Section not displayed", "FAIL", true);
		}

		List<WebElement> newsSubSec = driver.findElements(By.xpath("//span[@class='sectag-heading-txt']"));



		for(int i=1;i<=newsSubSec.size();i++) {

			WebElement eachSubNav = driver.findElement(By.xpath("(//span[@class='sectag-heading-txt'])["+i+"]"));
			String eachSubNavtext = eachSubNav.getText();

			if(eachSubNavtext.equalsIgnoreCase("The latest Hyundai news")) {
				reportStep("News sub section verified successfully", "PASS", true);



				/*WebElement latestHyundaiLink = driver.findElement(By.xpath(objValue.getProperty("xpath.hyundaiMedia")));
					js.executeScript("arguments[0].scrollIntoView(true);",latestHyundaiLink);*/

				js.executeScript("window.scrollBy(0,400)", "");

				clickByXpathjs(objValue.getProperty("xpath.hyundaiMedia"), "Latest Hyundai");

				sleepTime(5);
				switchToLastWindow();
				String newsTitle = driver.getTitle();
				System.out.println(newsTitle);
				if(newsTitle.equalsIgnoreCase("Official Media Site - Hyundai Newsroom")) {

					reportStep("Hyundai Newsroom Section verified successfully", "PASS", true);

				}
				else {

					reportStep("Error occured in the verification of Hyundai Newsroom Section", "FAIL", true);
				}
				driver.close();
				switchToParentWindow();
				sleepTime(5);
			}
			else if(eachSubNavtext.equalsIgnoreCase("Social")) {

				js.executeScript("window.scrollBy(0,800)", "");
				List<WebElement> socialLinks = driver.findElements(By.xpath("//div[@class='cac-external-link-container']/a"));

				for(int j=1;j<=socialLinks.size();j++) {

					WebElement eachSocialIcon=driver.findElement(By.xpath("((//div[@class='cac-external-link-container'])/a[1])["+j+"]"));

					js.executeScript("arguments[0].click();", eachSocialIcon);

					sleepTime(10);
					switchToLastWindow();
					sleepTime(10);
					String socialTitle = driver.getTitle();
					System.out.println("Social Title"+socialTitle);
					driver.close();
					switchToParentWindow();
					sleepTime(5);

					if(socialTitle.contains("Photos")) {
						reportStep("Social" +socialTitle+"navigation verified successfully", "PASS", true);

					}
					else if(socialTitle.contains("Twitter")) {

						reportStep("Social" +socialTitle+"navigation verified successfully", "PASS", true);
					}
					else if(socialTitle.contains("Instagram")) {

						reportStep("Social" +socialTitle+"navigation verified successfully", "PASS", true);
					}
					else {

						reportStep("Error occured in the social icon verification", "FAIL", true);
					}
				}


			}

		}


		return this;
	}

	public MiscPages autoShowsVerify(String Testcasenumber) throws InterruptedException {


		String[] subSection= {"Featured","2020 Auto Show Schedule","Social"};

		closeWelcomePopup();
		sleepTime(10);

		closeNotificationPopup();
		sleepTime(5);

		clickByXpath(objValue.getProperty("xpath.autoshowslink"), "Auto Shows link");
		sleepTime(5);
		closeWelcomePopup();
		sleepTime(5);
		WebElement autoShowsVerify = driver.findElement(By.xpath(objValue.getProperty("xpath.autoShowstitleVerify")));
		String autoShowsVerifytext = autoShowsVerify.getText().trim();

		if(autoShowsVerifytext.equalsIgnoreCase("Showing the world what we do best.")) {

			reportStep("Hyundai Autoshows page verified successfully", "PASS", true);
		}
		else {

			reportStep("Error occured in the navigation of Hyundai Autoshows page", "FAIL", true);
		}
		WebElement featureSection = driver.findElement(By.xpath(objValue.getProperty("xpath.autoShowsFeatureSubSection")));
		String featureSectionText = featureSection.getText();
		System.out.println(featureSectionText);

		WebElement socialSection = driver.findElement(By.xpath(objValue.getProperty("xpath.autoShowssocialSec")));
		String socialSectionText = socialSection.getText();
		System.out.println(socialSectionText);

		WebElement scheduleSection = driver.findElement(By.xpath(objValue.getProperty("xpath.autoScheduleSubSection")));
		String scheduleSectionText = scheduleSection.getText();
		System.out.println(scheduleSectionText);

		for(int j=0;j<=subSection.length;j++) {

			if(subSection[j].equalsIgnoreCase(featureSectionText)) {
				reportStep("Hyundai Autoshows"+featureSectionText+ " sub section verified successfully", "PASS", true);

				js.executeScript("window.scrollBy(0,400)", "");
				clickByXpath(objValue.getProperty("xpath.learnMoreFeature"), "Learn More");
				sleepTime(5);
				switchToLastWindow();
				driver.close();
				switchToParentWindow();
				sleepTime(5);
				String FeatureSectionTitle = driver.getTitle();
				System.out.println("Feature Title"+FeatureSectionTitle);

				if(FeatureSectionTitle.equalsIgnoreCase("Hyundai Auto Show & Events Schedule | Hyundai")) {

					reportStep("Hyundai Autoshows feature sub section Learn More link verified successfully", "PASS", true);
				}
				else {
					reportStep("Error occured in the verification of Hyundai Autoshows feature sub section", "FAIL", true);

				}
			}
			else if(subSection[j].equalsIgnoreCase(scheduleSectionText)) {

				reportStep("Hyundai Autoshows"+scheduleSectionText+ " sub section verified successfully", "PASS", true);

			}
			else if(subSection[j].equalsIgnoreCase(socialSectionText)) {

				js.executeScript("arguments[0].scrollIntoView(true);",socialSection);

				js.executeScript("window.scrollBy(0,400)", "");

				reportStep("Hyundai Autoshows"+socialSectionText+ " sub section verified successfully", "PASS", true);
				List<WebElement> socialSectionVerify = driver.findElements(By.xpath(objValue.getProperty("xpath.socialLinks")));

				for(int k=1;k<=socialSectionVerify.size();k++) {

					WebElement eachSocialIcon=driver.findElement(By.xpath("((//div[@class='cac-external-link-container'])/a[1])["+k+"]"));

					js.executeScript("arguments[0].click();", eachSocialIcon);

					sleepTime(10);
					switchToLastWindow();
					sleepTime(10);
					String socialTitle = driver.getTitle();
					System.out.println("Social Title"+socialTitle);
					driver.close();
					switchToParentWindow();
					sleepTime(5);

					if(socialTitle.contains("Photos")) {
						reportStep("Social" +socialTitle+"navigation verified successfully", "PASS", true);

					}
					else if(socialTitle.contains("Twitter")) {

						reportStep("Social" +socialTitle+"navigation verified successfully", "PASS", true);
					}
					else if(socialTitle.contains("Instagram")) {

						reportStep("Social" +socialTitle+"navigation verified successfully", "PASS", true);
					}
					else {

						reportStep("Error occured in the social icon verification", "FAIL", true);
					}
				}


			}

			else {
				reportStep("Error occured in the verification of Hyundai Autoshows sub section", "FAIL", true);

			}

		}


		return this;
	}

	public MiscPages compareCompetitorVerify(String Testcasenumber) throws IOException, InterruptedException {

		closeWelcomePopup();
		sleepTime(5);
		closeNotificationPopup();
		sleepTime(5);
		String modelYear = ReadExcelData.getdata(Testcasenumber, "Vehiclemodel");
		String comVehName = ReadExcelData.getdata(Testcasenumber, "VehicleName");
		String comVehTrim = ReadExcelData.getdata(Testcasenumber, "Trimselection");

		clickByXpath(objValue.getProperty("xpath.compareCompetitor"), "Compare competitor");
		sleepTime(5);
		closeWelcomePopup();
		sleepTime(5);

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.comparePageVerify"))).isDisplayed()) {
			reportStep("Compare to Competitor page displayed properly", "PASS", true);
			sleepTime(15);
			selectVisibileTextByXPath(objValue.getProperty("xpath.compareYear"), modelYear);
			reportStep("Vehicle year selected from year dropdown", "PASS", true);
			sleepTime(10);
			selectVisibileTextByXPath(objValue.getProperty("xpath.compareModel"), comVehName);
			sleepTime(10);
			reportStep("Vehicle Model selected from dropdown", "PASS", true);
			selectVisibileTextByXPath(objValue.getProperty("xpath.compareTrim"), comVehTrim);
			sleepTime(10);
			reportStep("Vehicle trim selected from dropdown", "PASS", true);

			clickByXpath(objValue.getProperty("xpath.compareAddButton"), "Add Button");
			sleepTime(10);

			WebElement vehEachLinks = driver.findElementByXPath("//button[text()='Compare']");
			js.executeScript("arguments[0].scrollIntoView(true);",vehEachLinks);
			clickByXpath(objValue.getProperty("xpath.compareButton"), "Compare button");
			sleepTime(10);

		}

		else {

			reportStep("Error occured in the navigation of Compare to Competitor page", "FAIL", true);
		}



		return this;
	}
	public MiscPages comparePageSectionVerify(String Testcasenumber) {


		sleepTime(30);
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
					sleepTime(30);
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


	public MiscPages vehiclesFooterVerify(String Testcasenumber) throws InterruptedException {
		driver.manage().window().setSize(new Dimension(1920,1080));
		closeWelcomePopup();
		sleepTime(5);
		closeNotificationPopup();
		sleepTime(5);
		String[] vehFooterLinks = {"Choose Your Hyundai","Hyundai SUVs","Hyundai Sedans","Hyundai Compacts","Hyundai Alternative Fuel Vehicles","Hyundai Vehicle Brochures","Genesis USA"};
		String[] vehFooterNav= {"All Vehicles","SUVs","Sedans","Compacts","Alt-Fuel","Vehicle Brochures","Genesis"};

		for(int j=0;j<=vehFooterLinks.length;j++) {
			for(int k=0;k<=vehFooterNav.length;k++) {	
				for(int i=1;i<=vehFooterLinks.length;i++) {

					if(driver.findElement(By.xpath(objValue.getProperty("xpath.footerVehicles"))).isDisplayed()) {
						WebElement vehEachLinks = driver.findElement(By.xpath("(//li[@class='footer-panel-item'])["+i+"]/a"));
						js.executeScript("arguments[0].scrollIntoView(true);",vehEachLinks);
						sleepTime(5);

						js.executeScript("arguments[0].click();", vehEachLinks);

						if(vehFooterNav[k].equals("All Vehicles")) {

							WebElement allVehHeader = driver.findElement(By.xpath(objValue.getProperty("xpath.footerAllVehiclesVerify")));
							String allVehVerify = allVehHeader.getText();

							if(vehFooterLinks[j].equalsIgnoreCase(allVehVerify)) {
								reportStep("All Vehicles Page verified successfully", "PASS", true);

							}
							else {

								reportStep("Error occured in the All vehicles Page verification", "FAIL", true);

							}

						}
						else if(vehFooterNav[k].equals("Vehicle Brochures")) {
							switchToLastWindow();
							sleepTime(20);
							WebElement vehBrochures = driver.findElement(By.xpath(objValue.getProperty("xpath.VehBrochuresVerify")));
							String vehBrochurestext = vehBrochures.getText();

							if(vehFooterLinks[j].equalsIgnoreCase(vehBrochurestext)) {
								reportStep("Vehicle Brochures page verified successfully", "PASS", true);

							}
							else {
								reportStep("Error occured in Vehicle Brochures page verification", "FAIL", true);
							}
							driver.close();
							switchToParentWindow();
							sleepTime(10);
						}
						else if(vehFooterNav[k].equals("Genesis")) {


							switchToLastWindow();
							sleepTime(15);
							/*	WebElement vehGenesis = driver.findElement(By.xpath(objValue.getProperty("xpath.genesisHeader")));
							String vehGenesistext = vehGenesis.getText();*/
							String genesistitle = driver.getTitle();
							System.out.println("Genesis Page Title"+genesistitle);

							if(vehFooterLinks[j].contains(genesistitle)) {
								reportStep("Vehicle Genesis page verified successfully", "PASS", true);

							}
							else {
								reportStep("Error occured in Vehicle Genesis page verification", "FAIL", true);
							}
							driver.close();
							switchToParentWindow();
							sleepTime(10);

						}

						else {

							WebElement categoryVehicleVerify = driver.findElement(By.xpath(objValue.getProperty("xpath.VehiclesHeader")));

							String categoryVehicleVerifytext = categoryVehicleVerify.getText();

							if(vehFooterLinks[j].equalsIgnoreCase(categoryVehicleVerifytext)) {

								reportStep(categoryVehicleVerifytext+" Verified successfully", "PASS", true);

							}
							else {
								reportStep("Error occured in the verification of each category vehicles", "FAIL", true);

							}
						}



					}
					else {

						reportStep("Error occured in the verification of vehicles footer section", "FAIL", true);
					}
					j++;
					k++;
				}


			}



		}
		return this;

	}

	public MiscPages linkClick (String Testcasenumber) throws IOException, InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.WhyHyundaiLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.WhyHyundaiLink"), "Why Hyundai Link is clicked");
			reportStep("Why Hyundai Link is clicked from header link", "PASS", true);
		}
		else {
			reportStep("Why Hyundai Link is not clicked from header link", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.WhyHeaderText"))!=null) {
			String pageTitle = ReadExcelData.getdata(Testcasenumber, "Title");
			boolean verifyTitle = verifyTitle(pageTitle);
			reportStep("Title is verified properly "+verifyTitle , "PASS", true);

			String whyPage = getTextByXpath(objValue.getProperty("xpath.whyPageText"));
			verifyTextContainsByXpath(objValue.getProperty("xpath.whyPageText"), whyPage);
			reportStep("Why Hyundai page is displayed properly", "PASS", true);
		}	
		else {
			reportStep("Why Hyundai page is not displayed properly", "FAIL", true);
		}


		return this;		
	}

	public MiscPages footerLinks(String Testcasenumber) throws IOException, InterruptedException {



		scrollElement(objValue.getProperty("xpath.moreReasonsText"));
		closeWelcomePopup();

		if(driver.findElementByXPath(objValue.getProperty("xpath.hyundaiMotorsText"))!=null) {
			clickByXpath(objValue.getProperty("xpath.hyundaiMotorsText"), "Learn More link is clicked");
			reportStep("Learn more link is clicked from Hyundai Motors section", "PASS", true);
		}
		else {
			reportStep("Learn more link is not clicked from Hyundai Motors section", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.motorsPageVerify"))!=null) {
			verifyTextContainsByXpath(objValue.getProperty("xpath.motorsPageVerify"), "Hyundai Motorsports");
			reportStep("Hyundai Motorsports page is verified properly", "PASS", true);
			driver.navigate().back();	
		}
		else {
			reportStep("Hyundai Motorsports page is not verified properly", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.shopperAssuranceCTA"))!=null) {
			clickByXpath(objValue.getProperty("xpath.shopperAssuranceCTA"), "Learn More link is clicked");
			reportStep("Learn more link is clicked from Shopper Assurance section", "PASS", true);
		}
		else {
			reportStep("Learn more link is not clicked from Shopper Assurance section", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.shopperPageVerify"))!=null) {
			verifyTextContainsByXpath(objValue.getProperty("xpath.shopperPageVerify"), "Car shopping made simple.");
			reportStep("Shopper Assurance page is verified properly", "PASS", true);
			driver.navigate().back();
		}
		else {
			reportStep("Shopper Assurance page is not verified properly", "PASS", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.hyundaiWay"))!=null) {
			clickByXpath(objValue.getProperty("xpath.hyundaiWay"), "Learn More link is clicked");
			reportStep("Learn more link is clicked from Hyundai Way section", "PASS", true);
		}
		else {
			reportStep("Learn more link is not clicked from Hyundai Way section", "FAIL", true);
		}

		String headerHyundaiWhy = ReadExcelData.getdata(Testcasenumber, "Header");
		verifyTitle(headerHyundaiWhy);
		reportStep("Hyundai Why page is verified properly", "PASS", true);

		return this;

	}

	public MiscPages PhilanthropyPage(String Testcasenumber) throws InterruptedException {
		driver.manage().window().setSize(new Dimension(1920,1080));
		closeNotificationPopup();
		closeWelcomePopup();
		scrollElement(objValue.getProperty("xpath.philanthropyText"));
		//js.executeScript("window.scrollBy(0,-1000)", "");	
		if(driver.findElementByXPath(objValue.getProperty("xpath.philanthropyText"))!=null) {
			clickByXpath(objValue.getProperty("xpath.philanthropyText"), "Philanthropy link is clicked");
			String PhilanthropyVerify = getTextByXpath(objValue.getProperty("xpath.verifyPhilanthropyPage"));
			System.out.println("Header text is "+PhilanthropyVerify);
			verifyTextByXpath(objValue.getProperty("xpath.verifyPhilanthropyPage"), PhilanthropyVerify);
			reportStep("Philanthropy page is displayed properly", "PASS", true);				
		}
		else {
			reportStep("Philanthropy page is not displayed properly", "FAIL", true);	
		}

		return this;


	}

	public MiscPages madeAmericaPage(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.madeAmericaLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.madeAmericaLink"), "Made in America link");
			String madePage = getTextByXpath(objValue.getProperty("xpath.verifyMadeAmericaPage"));
			System.out.println("America page is "+madePage);
			verifyTextByXpath(objValue.getProperty("xpath.verifyMadeAmericaPage"), madePage);
			reportStep("Made in America page is verified properly", "PASS", true);
		}
		else {
			reportStep("Made in America page is not verified properly", "FAIL", true);
		}

		return this;

	}

	public MiscPages happyDriversPage(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.happyLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.happyLink"), "Happy Drivers link");
			String happyPage = getTextByXpath(objValue.getProperty("xpath.verifyHappyPage"));
			System.out.println("Happy driver page is "+happyPage);
			verifyTextByXpath(objValue.getProperty("xpath.verifyHappyPage"), happyPage);
			reportStep("Happy Driver page is verified properly", "PASS", true);
		}
		else {
			reportStep("Happy Driver page is not verified properly", "FAIL", true);
		}

		return this;

	}

	public MiscPages buildingPage(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.buildTomorrowLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.buildTomorrowLink"), "Building for Tomorrow link");
			String happyPage = getTextByXpath(objValue.getProperty("xpath.verifyBuilding"));
			System.out.println("Building page is "+happyPage);
			verifyTextByXpath(objValue.getProperty("xpath.verifyBuilding"), happyPage);
			reportStep("Building for Tomorrow page is verified properly", "PASS", true);
		}
		else {
			reportStep("Building for Tomorrow page is not verified properly", "FAIL", true);
		}

		return this;

	}

	public MiscPages menuClick(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.menu")))!=null) {
			clickByXpath(objValue.getProperty("xpath.menu"),"Click Menu" );
			reportStep("Menu link is clicked", "PASS");

		}
		else {	
			reportStep("Menu link is not clicked", "FAIL");
		}

		if(driver.findElement(By.xpath(objValue.getProperty("xpath.shopperLink")))!=null) {
			clickByXpath(objValue.getProperty("xpath.shopperLink"),"Shopper Assurance link" );
			reportStep("Shopper Assurance link is clicked from Menu", "PASS",true);

		}
		else {	
			reportStep("Shopper Assurance link is not clicked from Menu", "FAIL",true);
		}

		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.shopperPageVerify"))!=null) {
			verifyTextContainsByXpath(objValue.getProperty("xpath.shopperPageVerify"), "Car shopping made simple.");
			reportStep("Shopper Assurance page is verified properly", "PASS", true);
		}
		else {
			reportStep("Shopper Assurance page is not verified properly", "PASS", true);
		}

		return this;

	}

	public MiscPages dealerSection(String Testcasenumber) throws IOException, InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		scrollElement(objValue.getProperty("xpath.dealerSectionText"));
		if(driver.findElementByXPath(objValue.getProperty("xpath.dealerSectionText"))!=null) {
			boolean dealerSection = isDisplayed(objValue.getProperty("xpath.dealerSectionText"));
			reportStep("Find a Dealer section is displayed "+dealerSection, "PASS", true);
		}
		else {
			reportStep("Find a Dealer section is not displayed", "FAIL", true);
		}

		ob.verifyDealer(Testcasenumber);
		reportStep("Find a dealer section is verified", "PASS", true);

		return this;

	}

	public MiscPages faqSection(String Testcasenumber) throws IOException, InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		scrollElement(objValue.getProperty("xpath.haveQuestion"));
		if(driver.findElementByXPath(objValue.getProperty("xpath.haveQuestion"))!=null) {
			boolean faqSection = isDisplayed(objValue.getProperty("xpath.haveQuestion"));
			reportStep("FAQ section is displayed "+faqSection, "PASS", true);
		}
		else {
			reportStep("FAQ section is not displayed", "FAIL", true);
		}	

		List<WebElement> faqList = driver.findElementsByXPath(objValue.getProperty("xpath.firstFAQ"));
		for(int i=1;i<=faqList.size();i++) {
			if(driver.findElementByXPath(objValue.getProperty("xpath.firstFAQ"))!=null) {
				WebElement question = driver.findElementByXPath("(//label[@class='faq-question-label'])["+(i+0)+"]");
				String faqQuestionsList = question.getText();
				System.out.println("FAQ list is "+faqQuestionsList);
				reportStep("FAQ Questions is "+faqQuestionsList, "PASS", true);
			}
			else {
				reportStep("FAQ Questions is not displayed", "FAIL", true);
			}
		}




		return this;

	}

	public MiscPages menu(String Testcasenumber) throws InterruptedException, IOException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.menu")))!=null) {
			clickByXpath(objValue.getProperty("xpath.menu"),"Click Menu" );
			reportStep("Menu link is clicked", "PASS",true);

		}
		else {	
			reportStep("Menu link is not clicked", "FAIL",true);
		}

		String searchText = ReadExcelData.getdata(Testcasenumber, "Search");
		if(driver.findElementByXPath(objValue.getProperty("xpath.searchField"))!=null) {
			enterByXpath(objValue.getProperty("xpath.searchField"), searchText, "Search value is entered");
			clickByXpath(objValue.getProperty("xpath.searchIcon"), "Search Value");
			reportStep("Search icon is clicked successfully", "PASS", true);
		}
		else {
			reportStep("Search icon is not clicked", "PASS", true);
		}

		return this;

	}

	public MiscPages searchResults(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.resultsSearch"))!=null) {
			String resultsPageHeader = getTextByXpath(objValue.getProperty("xpath.resultsSearch"));	
			System.out.println("Results page is displayed "+resultsPageHeader);
			reportStep("Results page is displayed "+resultsPageHeader, "PASS", true);
		}
		else {
			reportStep("Results page is not displayed", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.resultsCount"))!=null) {
			String resultsCount = getTextByXpath(objValue.getProperty("xpath.resultsCount"));	
			System.out.println("Results page is displayed "+resultsCount);
			reportStep("Results count is displayed "+resultsCount, "PASS", true);
		}
		else {
			reportStep("Results count is not displayed", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.filterDropdownValues"))!=null) {
			List<WebElement> filterDropdown = driver.findElementsByXPath("(//div[@class='dropdown g-sr-filter-dropdown']//following::div[@class='dropdown-items g-sr-filters'])//span");
			for(int i =1;i<=filterDropdown.size();i++) {
				WebElement filterdropdownResults = driver.findElementByXPath("((//div[@class='dropdown g-sr-filter-dropdown']//following::div[@class='dropdown-items g-sr-filters'])//span)["+(i+0)+"]");
				String filterdropdownResultsCount = filterdropdownResults.getText();
				System.out.println("Results category count for vehicles search is "+filterdropdownResultsCount);
				reportStep("Results category count for vehicles search is "+filterdropdownResultsCount, "PASS", true);
			}

		}
		else {
			reportStep("Results category count for vehicles search is not displayed", "FAIL", true);
		}
		return this;

	}

	public MiscPages menuLinkClick(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.menu")))!=null) {
			clickByXpath(objValue.getProperty("xpath.menu"),"Click Menu" );
			reportStep("Menu link is clicked", "PASS",true);

		}
		else {	
			reportStep("Menu link is not clicked", "FAIL",true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.applyCreditLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.applyCreditLink"), "Apply for credit link");
			reportStep("Apply for credit link is clicked", "PASS", true);
		}
		else {
			reportStep("Apply for credit link is not clicked", "FAIL", true);
		}

		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.applyCreditPage"))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.applyCreditPage"), "Apply for Financing");
			reportStep("Apply for credit page is verified properly", "PASS", true);
		}
		else {
			reportStep("Apply for credit page is not verified properly", "FAIL", true);
		}

		return this;

	}

	public MiscPages vehicleSelection(String Testcasenumber) throws IOException, InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.applySelectVehicleDropdown"))!=null) {
			clickByXpath(objValue.getProperty("xpath.applySelectVehicleDropdown"), "Vehicle Dropdown");
			reportStep("Vehicle dropdown is clicked", "PASS", true);

			vehicleModel = ReadExcelData.getdata(Testcasenumber, "Vehiclemodel");
			selectVisibileTextByXPath(objValue.getProperty("xpath.applySelectVehicleDropdown"), vehicleModel);
			reportStep("Vehicle is selected from vehicle dropdown "+vehicleModel, "PASS", true);
		}
		else {
			reportStep("Vehicle dropdown is not clicked", "FAIL", true);
		}

		sleepTime(30);
		if(driver.findElementByXPath(objValue.getProperty("xpath.applySelectTrimDropdown"))!=null) {
			clickByXpath(objValue.getProperty("xpath.applySelectTrimDropdown"), "Vehicle Dropdown");
			reportStep("Vehicle dropdown is clicked", "PASS", true);

			vehicleTrim = ReadExcelData.getdata(Testcasenumber, "Trimselection");
			selectVisibileTextByXPath(objValue.getProperty("xpath.applySelectTrimDropdown"), vehicleTrim);
			reportStep("Vehicle is selected from vehicle dropdown "+vehicleTrim, "PASS", true);
		}
		else {
			reportStep("Vehicle dropdown is not clicked", "FAIL", true);
		}

		return this;

	}

	public MiscPages selectedVehicleDetails(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.selectedModelName"))!=null) {
			String modelName = getTextByXpath(objValue.getProperty("xpath.selectedModelName"));
			System.out.println("Selected model is "+modelName);
			verifyTextByXpath(objValue.getProperty("xpath.selectedModelName"), modelName);
			reportStep("Model selected in the dropdown is dispalyed properly", "PASS", true);			
		}

		else {
			reportStep("Model selected in the dropdown is not dispalyed properly", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.applyVehicleDetails"))!=null) {
			boolean displayed = isDisplayed(objValue.getProperty("xpath.applyHeroImage"));
			reportStep("Hero image is dispalyed properly "+displayed, "PASS", true);

			String MSRPValue = getTextByXpath(objValue.getProperty("xpath.applyMSRPValue"));
			reportStep("Selected model MSRP value is "+MSRPValue, "PASS", true);

			clickByXpath(objValue.getProperty("xpath.applyMSRPToolTip"), "MSRP disclaimer");
			reportStep("MSRP disclaimer icon is displayed", "PASS", true);
			clickByXpath(objValue.getProperty("xpath.closeButton"), "Close button");

			String MPGValue = getTextByXpath(objValue.getProperty("xpath.applyMPGValue"));
			reportStep("Selected model MPG value is "+MPGValue, "PASS", true);

			clickByXpath(objValue.getProperty("xpath.applyMPGToolTip"), "MPG disclaimer");
			reportStep("MPG disclaimer icon is displayed", "PASS", true);
			clickByXpath(objValue.getProperty("xpath.closeButton"), "Close button");

			String HPValue = getTextByXpath(objValue.getProperty("xpath.applyHPValue"));
			reportStep("Selected model HP value is "+HPValue, "PASS", true);

		}
		return this;

	}

	public MiscPages linkNavigation(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.freeCreditButton"))!=null) {
			clickByXpath(objValue.getProperty("xpath.freeCreditButton"), "Free Credit link");
			reportStep("Free Credit link is clicked", "PASS", true);

			switchToLastWindow();
			sleepTime(90);
			String freeCreditPage = driver.getTitle();
			verifyTitle(freeCreditPage);

			switchToFrameByXpath(objValue.getProperty("xpath.tradeFrameValue"));
			String freePageText = getTextByXpath(objValue.getProperty("xpath.freeCreditPageVerify"));

			verifyTextContainsByXpath(objValue.getProperty("xpath.freeCreditPageVerify"), freePageText);
			reportStep("Free Credit page is verified properly", "PASS", true);	
			closeBrowser();
			switchToParentWindow();
		}
		else {
			reportStep("Free Credit page is not verified properly", "PASS", true);	
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.valueYourTradeButton"))!=null) {
			clickByXpath(objValue.getProperty("xpath.valueYourTradeButton"), "Value Your Trade link");
			reportStep("Value Your Trade link is clicked", "PASS", true);

			switchToLastWindow();
			sleepTime(90);
			String valueTradePage = driver.getTitle();
			verifyTitle(valueTradePage);
			/*switchToFrame(objValue.getProperty("xpath.valueYourTradePageVerify"));

				String valueTradePageText = getTextByXpath(objValue.getProperty("xpath.valueYourTradePageVerify"));
				verifyTextContainsByXpath(objValue.getProperty("xpath.valueYourTradePageVerify"), valueTradePageText);
				reportStep("Value Your Trade page is verified properly", "PASS", true);	*/
			closeBrowser();
			switchToParentWindow();
		}
		else {
			reportStep("Value Your Trade page is not verified properly", "PASS", true);	
		}

		return this;

	}

	public MiscPages applyCTAClick(String Testcasenumber) throws IOException, InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.applyButton"))!=null) {
			clickByXpath(objValue.getProperty("xpath.applyButton"), "Apply button");
			reportStep("Apply Button is clicked", "PASS", true);
		}
		else {
			reportStep("Apply Button is not clicked", "FAIL", true);
		}

		switchToFrame(objValue.getProperty("xpath.applyPopup"));
		String headerPopup = ReadExcelData.getdata(Testcasenumber, "Header");
		if(driver.findElementByXPath(objValue.getProperty("xpath.applyPopup"))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.applyPopup"), headerPopup);
			reportStep("Apply for Credit popup is displayed", "PASS", true);
		}
		else {
			reportStep("Apply for Credit popup is not displayed", "PASS", true);	
		}

		return this;

	}

	public MiscPages linkCareersClick(String Testcasenumber) throws IOException, InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		scrollElementByPixel(objValue.getProperty("xpath.careerLink"));
		if(driver.findElementByXPath(objValue.getProperty("xpath.careerLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.careerLink"), "Careers link");
			reportStep("Careers link is clicked", "PASS", true);
		}
		else {
			reportStep("Careers link is not clicked", "FAIL", true);
		}

		String pageVerify = getTextByXpath(objValue.getProperty("xpath.allPageVerify"));
		verifyTextByXpath(objValue.getProperty("xpath.allPageVerify"), pageVerify);
		reportStep("Career page is verified properly", "PASS", true);

		return this;

	}

	public MiscPages subNavigation(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		List<WebElement> subLinks = driver.findElementsByXPath("(//div[@class='dropdown-items ternav-items'])//a");
		if(driver.findElementByXPath(objValue.getProperty("xpath.subNavigationLinks"))!=null) {
			for(int i=1;i<=subLinks.size();i++) {
				WebElement links = driver.findElementByXPath("((//div[@class='dropdown-items ternav-items'])//a)["+(i+0)+"]");
				links.click();
				reportStep("Sub links is clicked from Careers page", "PASS", true);

				String pageVerify = getTextByXpath(objValue.getProperty("xpath.allPageVerify"));
				verifyTextByXpath(objValue.getProperty("xpath.allPageVerify"), pageVerify);
				reportStep("Sub navigation pages are verified properly", "PASS", true);

			}		
		}
		else {
			reportStep("Sub links are not clicked and verified", "PASS", true);
		}

		return this;

	}

	public MiscPages motorsPage(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		scrollElementByPixel(objValue.getProperty("xpath.motorsLink"));
		if(driver.findElementByXPath(objValue.getProperty("xpath.motorsLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.motorsLink"), "Motors link");
			reportStep("Motors link is displayed properly", "PASS", true);
		}
		else {
			reportStep("Motors link is not displayed properly", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.motorsPageVerify"))!=null) {
			verifyTextContainsByXpath(objValue.getProperty("xpath.motorsPageVerify"), "Hyundai Motorsports");
			reportStep("Hyundai Motorsports page is verified properly", "PASS", true);	
		}
		else {
			reportStep("Hyundai Motorsports page is not verified properly", "FAIL", true);
		}

		return this;

	}

	public MiscPages verifyMotorsPage(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.driveRaceSection"))!=null) {
			isDisplayed(objValue.getProperty("xpath.driveRaceSection"));
			reportStep("Drive our race-inspired lineup is displayed", "PASS", true);
		}
		else {
			reportStep("Drive our race-inspired lineup is not displayed", "FAIL", true);
		}

		int j=5;
		WebElement vehilcleModelName = driver.findElementByXPath("(//div[@class='vc-name '])[3]");
		String compactsVehicleName = vehilcleModelName.getText();
		compactsVehicleModel = compactsVehicleName.replaceAll("[\\n]", " ");

		vehilcleModelName.click();
		String vehicleName = getTextByXpath(objValue.getProperty("xpath.vehicleModelNameHeader"));
		if(compactsVehicleModel.contains(vehicleName)) {
			System.out.println("Vehicle is displayed properly");
			reportStep("Both vehicle name are displayed properly", "PASS", true);
		}
		driver.navigate().back();

		for(int i=3;i<=j;i++) {
			WebElement vehicle = driver.findElementByXPath("(//div[@class='vc-name '])["+(i+0)+"]");
			String compactsVehicleNameMo = vehicle.getText();
			compactsVehicleModel = compactsVehicleNameMo.replaceAll("[\\n]", " ");
			reportStep("Vehicle displayed in Compact Category is "+compactsVehicleModel, "PASS", true);
			clickByXpath(objValue.getProperty("xpath.nextButtonClick"), "Next Button is clicked");
			reportStep("Next link is clicked", "PASS", true);
		}

		return this;

	}

	public MiscPages awardsPage(String Testcasenumber) throws InterruptedException, IOException {
		closeNotificationPopup();
		closeWelcomePopup();
		scrollElementByPixel(objValue.getProperty("xpath.awardLink"));
		if(driver.findElementByXPath(objValue.getProperty("xpath.awardLink"))!=null) {
			clickByXpath(objValue.getProperty("xpath.awardLink"), "Award link");
			reportStep("Award link is clicked", "PASS", true);
		}
		else {
			reportStep("Award link is not clicked", "FAIL", true);
		}

		String awardHeader = ReadExcelData.getdata(Testcasenumber, "Header");
		if(driver.findElementByXPath(objValue.getProperty("xpath.awardHeader"))!=null) {
			verifyTextByXpath(objValue.getProperty("xpath.awardHeader"), awardHeader);
			reportStep("Award Page is verified", "PASS", true);
		}
		else {
			reportStep("Award Page is not verified", "FAIL", true);
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.awardResults"))!=null) {
			String resultsCount = getTextByXpath(objValue.getProperty("xpath.awardResults"));
			reportStep("Awards result count is "+resultsCount, "PASS", true);
		}
		else {
			reportStep("Awards result count is not displayed", "FAIL", true);
		}		
		return this;

	}

	public MiscPages awardPageVerify(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.firstAwardCard"))!=null) {
			clickByXpath(objValue.getProperty("xpath.awardCardLink"), "Read More");
			reportStep("Read More link is clicked", "PASS", true);
		}
		else {
			reportStep("Read More link is not clicked", "FAIL", true);
		}

		switchToLastWindow();
		String title = driver.getTitle();
		if(title!=null) {
			verifyTitle(title);
			reportStep("Award page is verified properly", "PASS", true);
		}
		else {
			reportStep("Award page is not verified properly", "FAIL", true);
		}
		return this;

	}

	public MiscPages menuLinkNavClick(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.menu")))!=null) {
			clickByXpath(objValue.getProperty("xpath.menu"),"Click Menu" );
			reportStep("Menu link is clicked", "PASS");

		}
		else {	
			reportStep("Menu link is not clicked", "FAIL");
		}
		return this;

	}

	public MiscPages menuResearchLinkNav(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		//MiscPages ob = new MiscPages(driver);
		if(driver.findElementByXPath(objValue.getProperty("xpath.researchSection"))!=null) {

			if(driver.findElementByXPath(objValue.getProperty("xpath.MenuResearchHeader"))!=null) {
				String researchHeader = 	getTextByXpath(objValue.getProperty("xpath.MenuResearchHeader"));
				reportStep("Header is displayed in Menu is "+researchHeader, "PASS", true);
			}
			else {
				reportStep("Header is not displayed in Menu", "FAIL", true);
			}

			String reseachLink[] = {"Why Hyundai","All Vehicles","Compare our Vehicles","America's Best Warranty","Vehicle Brochures"};
			String linkNavHeader [] = {"Why Hyundai?","Choose Your Hyundai","Choose Your Hyundai","America's Best Warranty","Hyundai Vehicle Brochures"};

			List<WebElement> menuList = driver.findElementsByXPath("((//div[@class='global-header-dropdown-column'])[1]//a)");
			for(int i=0;i<=reseachLink.length;i++) {
				for(int k=0;k<=linkNavHeader.length;k++) {           
					for(int j = 1;j<=menuList.size();j++) {

						if(reseachLink[i].equals("Why Hyundai")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[1]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.WhyHeaderText"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								menuLinkNavClick(Testcasenumber);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("All Vehicles")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[1]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.allVehiclesHeader"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								menuLinkNavClick(Testcasenumber);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("Compare our Vehicles")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[1]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.allVehiclesHeader"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								menuLinkNavClick(Testcasenumber);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("America's Best Warranty")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[1]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.americaHeader"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								menuLinkNavClick(Testcasenumber);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("Vehicle Brochures")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[1]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							switchToLastWindow();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.cpoHeaderTitle"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();


							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}
						else {
							reportStep("Links are displayed properly", "PASS", true);					


						}
						i++;
						k++;

					}


				}
			}

		}

		else {
			reportStep("Menu Links are not displayed properly", "FAIL", true);
		}

		return this;

	}

	public MiscPages menuShopLink(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();

		//MiscPages ob = new MiscPages(driver);

		if(driver.findElementByXPath(objValue.getProperty("xpath.shopSection"))!=null) {

			if(driver.findElementByXPath(objValue.getProperty("xpath.MenuShopHeader"))!=null) {
				String researchHeader = 	getTextByXpath(objValue.getProperty("xpath.MenuShopHeader"));
				reportStep("Header is displayed in Menu is "+researchHeader, "PASS", true);
			}
			else {
				reportStep("Header is not displayed in Menu", "FAIL", true);
			}

			String reseachLink[] = {"Find a Dealer","Build & Price","Search New Inventory","Schedule a Test Drive","Search Certified Pre-Owned"};
			String linkNavHeader [] = {"Hyundai Dealerships near","Build Your Hyundai","Find Your Hyundai","Schedule a Hyundai Test Drive","Hyundai Certified Pre-Owned"};

			List<WebElement> menuList = driver.findElementsByXPath("((//div[@class='global-header-dropdown-column'])[2]//a)");
			for(int i=0;i<=reseachLink.length;i++) {
				for(int k=0;k<=linkNavHeader.length;k++) {           
					for(int j = 1;j<=menuList.size();j++) {

						if(reseachLink[i].equals("Find a Dealer")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[2]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.dealerPageVerify"));
							String replaceAllheader = headerVerify.replaceAll("\\n", " ");
							if(replaceAllheader.contains(linkNavHeader[k])) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								menuLinkNavClick(Testcasenumber);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("Build & Price")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[2]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.buildPageVerify"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								menuLinkNavClick(Testcasenumber);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("Search New Inventory")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[2]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.inventoryPageVerify"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								menuLinkNavClick(Testcasenumber);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("Schedule a Test Drive")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[2]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							switchToLastWindow();
							sleepTime(60);
							offerClose();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.stdPageVerification"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("Search Certified Pre-Owned")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[2]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							switchToLastWindow();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.VerifyTextCPO"));
							String replaceAllheaderVerify = headerVerify.replaceAll("\\n", " ");
							if(linkNavHeader[k].equals(replaceAllheaderVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}
						else {
							reportStep("Links are displayed properly", "PASS", true);					


						}
						i++;
						k++;

					}


				}
			}

		}

		else {
			reportStep("Menu Links are not displayed properly", "FAIL", true);
		}

		return this;


	}

	public MiscPages menuBuyLink(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();

		//MiscPages ob = new MiscPages(driver);

		if(driver.findElementByXPath(objValue.getProperty("xpath.buySection"))!=null) {

			if(driver.findElementByXPath(objValue.getProperty("xpath.MenubuyHeader"))!=null) {
				String researchHeader = 	getTextByXpath(objValue.getProperty("xpath.MenubuyHeader"));
				reportStep("Header is displayed in Menu is "+researchHeader, "PASS", true);
			}
			else {
				reportStep("Header is not displayed in Menu", "FAIL", true);
			}

			String reseachLink[] = {"Offers & Promotions","Request a Quote","Calculate Payment","Apply for Credit","Estimate Trade-in Value"};
			String linkNavHeader [] = {"Offers","Request a quote","Payment Calculator","Apply for Financing","Let’s Get Your Trade-In Value"};

			List<WebElement> menuList = driver.findElementsByXPath("((//div[@class='global-header-dropdown-column'])[3]//a)");
			for(int i=0;i<=reseachLink.length;i++) {
				for(int k=0;k<=linkNavHeader.length;k++) {           
					for(int j = 1;j<=menuList.size();j++) {

						if(reseachLink[i].equals("Offers & Promotions")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[3]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.offersPageVerify"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								menuLinkNavClick(Testcasenumber);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("Request a Quote")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[3]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.raqPageVerify"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								menuLinkNavClick(Testcasenumber);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("Calculate Payment")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[3]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.applyCreditPage"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								menuLinkNavClick(Testcasenumber);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("Apply for Credit")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[3]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.applyCreditPage"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								menuLinkNavClick(Testcasenumber);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("Estimate Trade-in Value")) {
							WebElement listMenu = driver.findElementByXPath("((//div[@class='global-header-dropdown-column'])[3]//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							switchToLastWindow();
							switchToFrameByXpath(objValue.getProperty("xpath.tradeFrameValue"));
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.valueYourTradePageVerify"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}
						else {
							reportStep("Links are displayed properly", "PASS", true);					


						}
						i++;
						k++;

					}


				}
			}

		}

		else {
			reportStep("Menu Links are not displayed properly", "FAIL", true);
		}

		return this;


	}

	public MiscPages menuOwnersLink(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();

		//MiscPages ob = new MiscPages(driver);

		if(driver.findElementByXPath(objValue.getProperty("xpath.ownerSection"))!=null) {

			if(driver.findElementByXPath(objValue.getProperty("xpath.MenuOwnerHeader"))!=null) {
				String researchHeader = 	getTextByXpath(objValue.getProperty("xpath.MenuOwnerHeader"));
				reportStep("Header is displayed in Menu is "+researchHeader, "PASS", true);
			}
			else {
				reportStep("Header is not displayed in Menu", "FAIL", true);
			}

			String reseachLink[] = {"Login to MyHyundai","Make a Payment","Schedule Service","Owner's Manuals","24/7 Roadside Assistance","Safety Recalls"};
			String linkNavHeader [] = {"MyHyundai","","Hyundai Dealerships near","Hyundai Resources","Hyundai Assurance 24/7 Roadside Assistance","SAFETY RECALLS AND SERVICE CAMPAIGNS"};

			List<WebElement> menuList = driver.findElementsByXPath("(//div[@class='global-header-dropdown-column global-header-dropdown-more-container']//a)");
			for(int i=0;i<=reseachLink.length;i++) {
				for(int k=0;k<=linkNavHeader.length;k++) {           
					for(int j = 1;j<=menuList.size();j++) {

						if(reseachLink[i].equals("Login to MyHyundai")) {
							WebElement listMenu = driver.findElementByXPath("(//div[@class='global-header-dropdown-column global-header-dropdown-more-container']//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							switchToLastWindow();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.ownerPageVerify"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();
								closeWelcomePopup();

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("Make a Payment")) {
							WebElement listMenu = driver.findElementByXPath("(//div[@class='global-header-dropdown-column global-header-dropdown-more-container']//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							switchToLastWindow();
							String title = driver.getTitle();
							verifyTitle(title);
							reportStep("title is verified properly", "PASS", true);
							closeBrowser();
							switchToParentWindow();

						}

						else if(reseachLink[i].equals("Schedule Service")) {
							WebElement listMenu = driver.findElementByXPath("(//div[@class='global-header-dropdown-column global-header-dropdown-more-container']//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.dealerPageVerify"));
							String replaceAllheaderVerify = headerVerify.replaceAll("\\n", " ");
							if(replaceAllheaderVerify.contains(linkNavHeader[k])) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								menuLinkNavClick(Testcasenumber);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("Owner's Manuals")) {
							WebElement listMenu = driver.findElementByXPath("(//div[@class='global-header-dropdown-column global-header-dropdown-more-container']//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							switchToLastWindow();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.ownersManualVerify"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("24/7 Roadside Assistance")) {
							WebElement listMenu = driver.findElementByXPath("(//div[@class='global-header-dropdown-column global-header-dropdown-more-container']//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							//switchToLastWindow();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.roadsidePageVerify"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								menuLinkNavClick(Testcasenumber);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(reseachLink[i].equals("Safety Recalls")) {
							WebElement listMenu = driver.findElementByXPath("(//div[@class='global-header-dropdown-column global-header-dropdown-more-container']//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +reseachLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							switchToLastWindow();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.recallPageVerify"));
							if(linkNavHeader[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else {
							reportStep("Links are displayed properly", "PASS", true);					


						}
						i++;
						k++;

					}


				}
			}

		}

		else {
			reportStep("Menu Links are not displayed properly", "FAIL", true);
		}

		return this;		
	}

	public MiscPages menuAssuranceLink(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
			closeWelcomePopup();
		//MiscPages ob = new MiscPages(driver);
	

		if(driver.findElementByXPath(objValue.getProperty("xpath.assuranceMenuLink"))!=null) {

			List<WebElement> assuranceLinks = driver.findElementsByXPath("//a[@class='global-header-feature-cta']");
			for(int i = 1;i<=assuranceLinks.size();i++) {
				if(i==1) {

					WebElement linkShopper = driver.findElementByXPath("(//a[@class='global-header-feature-cta'])["+(i+0)+"]");
					linkShopper.click();

					String shopperPageVerify = getTextByXpath(objValue.getProperty("xpath.shopperPageVerify"));
					verifyTextByXpath(objValue.getProperty("xpath.shopperPageVerify"), shopperPageVerify);
					reportStep("Page is clicked and verified successfully", "PASS", true);
					menuLinkNavClick(Testcasenumber);

				}
				if(i==2) {

					WebElement linkOwner = driver.findElementByXPath("(//a[@class='global-header-feature-cta'])["+(i+0)+"]");
					linkOwner.click();

					String shopperPageVerify = getTextByXpath(objValue.getProperty("xpath.shopperPageVerify"));
					verifyTextByXpath(objValue.getProperty("xpath.shopperPageVerify"), shopperPageVerify);
					reportStep("Page is clicked and verified successfully", "PASS", true);



				}}


		}
		return this;

	}

	public MiscPages shoppingToolsFooterLink(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.shopSectionFooterLink"))!=null) {

			if(driver.findElementByXPath(objValue.getProperty("xpath.shoppingToolsHeader"))!=null) {
				String shopHeader = 	getTextByXpath(objValue.getProperty("xpath.shoppingToolsHeader"));
				reportStep("Footer Header is displayed sucessfully  "+shopHeader, "PASS", true);
			}
			else {
				reportStep("Footer Header is not displayed sucessfully", "FAIL", true);
			}

			String footerLink[] = {"Find a Dealer","Build & Price","Offers & Promotions","Request a Quote","Search New Inventory",
					"Schedule a Test Drive","Search Certified Pre-Owned","Compare our Vehicles","Compare to Competitors","Calculate a Payment",
					"Estimate Trade-in Value","Apply for Credit"};
			String linkNavFooter [] = {"Hyundai Dealerships near","Build Your Hyundai","Offers","Request a quote","Find Your Hyundai",
					"Schedule a Hyundai Test Drive","Hyundai Certified Pre-Owned","Choose Your Hyundai","Compare Hyundai with the Competition",
					"Payment Calculator","Let’s Get Your Trade-In Value","Apply for Financing"};

			List<WebElement> menuList = driver.findElementsByXPath("((//nav[@class='footer-cell'])[2]//li)//a");
			for(int i=0;i<=footerLink.length;i++) {
				for(int k=0;k<=linkNavFooter.length;k++) {           
					for(int j = 1;j<=menuList.size();j++) {

						scrollElementByPixel(objValue.getProperty("xpath.shopSectionFooterLink"));
						if(footerLink[i].equals("Find a Dealer")) {

							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[2]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.dealerPageVerify"));
							String replaceAllheader = headerVerify.replaceAll("\\n", " ");
							if(replaceAllheader.contains(linkNavFooter[k])) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}

							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Build & Price")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[2]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.buildPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Offers & Promotions")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[2]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.offersPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Request a Quote")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[2]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.raqPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Search New Inventory")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[2]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.inventoryPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Schedule a Test Drive")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[2]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							switchToLastWindow();
							sleepTime(60);
							offerClose();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.stdPageVerification"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Search Certified Pre-Owned")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[2]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							switchToLastWindow();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.VerifyTextCPO"));
							String replaceAllheaderVerify = headerVerify.replaceAll("\\n", " ");
							if(linkNavFooter[k].equals(replaceAllheaderVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Compare our Vehicles")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[2]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.allVehiclesHeader"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Compare to Competitors")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[2]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.compareCompetitorsFooterVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Calculate a Payment")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[2]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.applyCreditPage"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Estimate Trade-in Value")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[2]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							sleepTime(20);
							switchToLastWindow();
							switchToFrameByXpath(objValue.getProperty("xpath.tradeFrameValue"));
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.valueYourTradePageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Apply for Credit")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[2]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.applyCreditPage"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else {
							reportStep("Links are displayed properly", "PASS", true);					


						}
						i++;
						k++;

					}


				}
			}

		}

		else {
			reportStep("Footer Links are not displayed properly", "FAIL", true);
		}

		return this;

	}

	public MiscPages whyFooterLinksNav(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();

		if(driver.findElementByXPath(objValue.getProperty("xpath.whyHyundaiSectionFooterLink"))!=null) {

			if(driver.findElementByXPath(objValue.getProperty("xpath.shoppingToolsHeader"))!=null) {
				String whyHyundaiHeader = 	getTextByXpath(objValue.getProperty("xpath.shoppingToolsHeader"));
				reportStep("Footer Header is displayed sucessfully  "+whyHyundaiHeader, "PASS", true);
			}
			else {
				reportStep("Footer Header is not displayed sucessfully", "FAIL", true);
			}

			String footerLink[] = {"Overview","America's Best Warranty","Shopper Assurance","Owner Assurance","Hyundai Assurance","Complimentary Maintenance",
					"Happy Drivers","Philanthropy","Made in America","Build for Tomorrow","Social Responsibility"};
			String linkNavFooter [] = {"Why Hyundai?","America's Best Warranty","Car shopping made simple.","The benefits of ownership","Hyundai Assurance",
					"Hyundai Complimentary Maintenance","Staying by our drivers’ side","Helping kids fight cancer","Building cars all across America",
					"Building a better world for tomorrow","Hyundai Corporate Social Responsibility"};

			List<WebElement> menuList = driver.findElementsByXPath("((//nav[@class='footer-cell'])[3]//li)//a");
			for(int i=0;i<=footerLink.length;i++) {
				for(int k=0;k<=linkNavFooter.length;k++) {           
					for(int j = 1;j<=menuList.size();j++) {
						WebElement footerSection = driver.findElementByXPath("(//nav[@class='footer-cell'])[3]");
						js.executeScript("arguments[0].scrollIntoView(true);",footerSection);
						//scrollElementByPixel(objvalue.getProperty("xpath.shopSectionFooterLink"));
						if(footerLink[i].equals("Overview")) {

							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[3]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							closeWelcomePopup();
							driver.manage().window().setSize(new Dimension(1920,1080));
							sleepTime(5);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.WhyHeaderText"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}

							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("America's Best Warranty")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[3]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.americaHeader"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Shopper Assurance")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[3]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.shopperPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Owner Assurance")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[3]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.shopperPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}
						else if(footerLink[i].equals("Hyundai Assurance")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[3]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.hyundaiAssurancePageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Complimentary Maintenance")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[3]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.shopperPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Philanthropy")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[3]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.verifyPhilanthropyPage"));
							String replaceAllheaderVerify = headerVerify.replaceAll("\\n", " ");
							if(linkNavFooter[k].equals(replaceAllheaderVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Made in America")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[3]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							sleepTime(30);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.verifyMadeAmericaPage"));
							String replaceAllheaderVerify = headerVerify.replaceAll("\\n", " ");
							if(linkNavFooter[k].equals(replaceAllheaderVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Happy Drivers")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[3]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.verifyHappyPage"));
							String replaceAllheaderVerify = headerVerify.replaceAll("\\n", " ");
							if(linkNavFooter[k].equals(replaceAllheaderVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Build for Tomorrow")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[3]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.verifyBuilding"));
							String replaceAllheaderVerify = headerVerify.replaceAll("\\n", " ");
							if(linkNavFooter[k].equals(replaceAllheaderVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Social Responsibility")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[3]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							switchToLastWindow();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.footerSocialPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}


						else {
							reportStep("Links are displayed properly", "PASS", true);					


						}
						i++;
						k++;

					}


				}
			}

		}

		else {
			reportStep("Footer Links are not displayed properly", "FAIL", true);
		}

		return this;


	}

	public MiscPages ownerFooterLink(String Testcasenumber) throws InterruptedException {
		/*closeNotificationPopup();
		closeWelcomePopup();*/

		if(driver.findElementByXPath(objValue.getProperty("xpath.ownerFooterLink"))!=null) {

			if(driver.findElementByXPath(objValue.getProperty("xpath.ownerFooterHeader"))!=null) {
				String ownerHeader = 	getTextByXpath(objValue.getProperty("xpath.ownerFooterHeader"));
				reportStep("Footer Header is displayed sucessfully  "+ownerHeader, "PASS", true);
			}
			else {
				reportStep("Footer Header is not displayed sucessfully", "FAIL", true);
			}

			String footerLink[] = {"Ownership Resources","Login to MyHyundai","Make a Payment","Maintenance Schedules","Schedule Service",
					"Owners Manuals","24/7 Roadside Assistance","Blue Link®","Accessories","Merchandise & Apparel","Safety Recalls","Engine Recalls"};
			String linkNavFooter [] = {"Ownership Resources","MyHyundai","Make a Payment","Recommended Maintenance Schedules","Hyundai Dealerships near",
					"Hyundai Resources","Hyundai Assurance 24/7 Roadside Assistance","Remote access with seamless connectivity",
					"ACCESSORY RESOURCE CENTER","Home | Hyundai Merchandise Collection","SAFETY RECALLS AND SERVICE CAMPAIGNS","Hyundai Engine Recall and Software Update Information"};

			List<WebElement> menuList = driver.findElementsByXPath("((//nav[@class='footer-cell'])[4]//li)//a");
			for(int i=0;i<=footerLink.length;i++) {
				for(int k=0;k<=linkNavFooter.length;k++) {           
					for(int j = 1;j<=menuList.size();j++) {
						WebElement footerSection = driver.findElementByXPath("(//nav[@class='footer-cell'])[4]");
						js.executeScript("arguments[0].scrollIntoView(true);",footerSection);
						//scrollElementByPixel(objvalue.getProperty("xpath.ownerFooterLink"));
						if(footerLink[i].equals("Ownership Resources")) {

							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[4]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							sleepTime(30);
							switchToLastWindow();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.shopperPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();
							}

							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Login to MyHyundai")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[4]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);
							sleepTime(30);
							closeWelcomePopup();
							js.executeScript("arguments[0].click();", listMenu);
							
							sleepTime(30);
							switchToLastWindow();
							sleepTime(30);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.ownerPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								closeWelcomePopup();
								switchToParentWindow();

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Make a Payment")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[4]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);
							js.executeScript("arguments[0].click();", listMenu);
							switchToLastWindow();
							String title = driver.getTitle();
							verifyTitle(title);
							reportStep("title is verified properly", "PASS", true);
							closeBrowser();
							switchToParentWindow();

						}

						else if(footerLink[i].equals("Maintenance Schedules")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[4]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.maintenanceFooterPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Schedule Service")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[4]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.dealerPageVerify"));
							String replaceAllheaderVerify = headerVerify.replaceAll("\\n", " ");
							if(replaceAllheaderVerify.contains(linkNavFooter[k])) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Owners Manuals")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[4]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							switchToLastWindow();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.ownersManualVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("24/7 Roadside Assistance")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[4]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.roadsidePageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Blue Link®")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[4]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.shopperPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Accessories")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[4]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							switchToLastWindow();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.accessoriesPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}
						else if(footerLink[i].equals("Merchandise & Apparel")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[4]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							switchToLastWindow();
							String titleMerchandise = driver.getTitle();
							System.out.println("Merchandise title"+titleMerchandise);
							if(linkNavFooter[k].equals(titleMerchandise)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Safety Recalls")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[4]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							switchToLastWindow();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.recallPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Engine Recalls")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[4]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							js.executeScript("arguments[0].click();", listMenu);
							switchToLastWindow();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.engineRecallPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}


						else {
							reportStep("Links are displayed properly", "PASS", true);					


						}
						i++;
						k++;

					}


				}
			}

		}

		else {
			reportStep("Footer Links are not displayed properly", "FAIL", true);
		}

		return this;



	}

	public MiscPages aboutFooterLinkNav(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();

		if(driver.findElementByXPath(objValue.getProperty("xpath.aboutFooterLink"))!=null) {

			if(driver.findElementByXPath(objValue.getProperty("xpath.aboutFooterHeader"))!=null) {
				String ownerHeader = 	getTextByXpath(objValue.getProperty("xpath.aboutFooterHeader"));
				reportStep("Footer Header is displayed sucessfully  "+ownerHeader, "PASS", true);
			}
			else {
				reportStep("Footer Header is not displayed sucessfully", "FAIL", true);
			}

			String footerLink[] = {"Our Company","Careers","News","Motorsports","Auto Shows","Awards & Accolades","Contact Us"};
			String linkNavFooter [] = {"Our Company","People come first","What’s Happening","Hyundai Motorsports",
					"Showing the world what we do best.","Awards & Accolades","Consumer Assistance Center"};

			List<WebElement> menuList = driver.findElementsByXPath("((//nav[@class='footer-cell'])[5]//li)//a");
			for(int i=0;i<=footerLink.length;i++) {
				for(int k=0;k<=linkNavFooter.length;k++) {           
					for(int j = 1;j<=menuList.size();j++) {

						scrollElementByPixel(objValue.getProperty("xpath.ownerFooterLink"));
						if(footerLink[i].equals("Our Company")) {

							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[5]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.shopperPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}

							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Careers")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[5]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);
							closeWelcomePopup();
							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.allPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("News")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[5]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.shopperPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Motorsports")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[5]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.shopperPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Auto Shows")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[5]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.shopperPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Awards & Accolades")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[5]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.awardHeader"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Contact Us")) {
							WebElement listMenu = driver.findElementByXPath("(((//nav[@class='footer-cell'])[5]//li)//a)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.contactFooterpageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								driver.navigate().back();
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else {
							reportStep("Links are displayed properly", "PASS", true);					


						}
						i++;
						k++;

					}


				}
			}

		}

		else {
			reportStep("Footer Links are not displayed properly", "FAIL", true);
		}

		return this;




	}

	public MiscPages secondaryFooterLink(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.siteMapSection"))!=null) {

			String footerLink[] = {"Site Map","FAQ's","Terms of Use","Legal","Privacy Policy","Owner Privacy Policy",
					"Do not sell my information","AdChoices"};
			String linkNavFooter [] = {"Site Map","Frequently Asked Questions","Terms of Use","Hyundai Motor America Legal Disclaimer",
					"Hyundai Motor America Privacy Policy","Hyundai Vehicle Owner Privacy Policy","Personal Information Request",
			"Interest Based Advertising Policies"};

			List<WebElement> menuList = driver.findElementsByXPath("//ul[@class='footer-privacy-container']//li");
			for(int i=0;i<=footerLink.length;i++) {
				for(int k=0;k<=linkNavFooter.length;k++) {           
					for(int j = 1;j<=menuList.size();j++) {

						scrollElementByPixel(objValue.getProperty("xpath.siteMapSection"));
						if(footerLink[i].equals("Site Map")) {

							WebElement listMenu = driver.findElementByXPath("(//ul[@class='footer-privacy-container']//li)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.sitePageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}

							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("FAQ's")) {
							WebElement listMenu = driver.findElementByXPath("(//ul[@class='footer-privacy-container']//li)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.shopperPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Terms of Use")) {
							WebElement listMenu = driver.findElementByXPath("(//ul[@class='footer-privacy-container']//li)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.sitePageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}
						else if(footerLink[i].equals("Legal")) {
							WebElement listMenu = driver.findElementByXPath("(//ul[@class='footer-privacy-container']//li)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.sitePageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Privacy Policy")) {
							WebElement listMenu = driver.findElementByXPath("(//ul[@class='footer-privacy-container']//li)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.sitePageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Owner Privacy Policy")) {
							WebElement listMenu = driver.findElementByXPath("(//ul[@class='footer-privacy-container']//li)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.sitePageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("Do not sell my information")) {
							WebElement listMenu = driver.findElementByXPath("(//ul[@class='footer-privacy-container']//li)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							switchToLastWindow();
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.dontsellPageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								closeBrowser();
								switchToParentWindow();

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else if(footerLink[i].equals("AdChoices")) {
							WebElement listMenu = driver.findElementByXPath("(//ul[@class='footer-privacy-container']//li)[" +(j+0)+ "]");
							String linksName = listMenu.getText();
							reportStep("Both links " +footerLink[i]+ " & " +linksName+ " are displayed same", "PASS", true);

							listMenu.click();
							switchToFrameByXpath(objValue.getProperty("xpath.adChoicePopup"));
							sleepTime(30);
							String headerVerify = getTextByXpath(objValue.getProperty("xpath.adChoicePageVerify"));
							if(linkNavFooter[k].equals(headerVerify)) {
								reportStep("Link is clicked successfully and page is verified", "PASS", true);
								clickByXpath(objValue.getProperty("xpath.adChoiceCloseButton"), "Close button");

							}
							else {
								reportStep("Link is not displayed successfully and page is not verified", "FAIL", true);
							}
						}

						else {
							reportStep("Links are displayed properly", "PASS", true);					


						}
						i++;
						k++;

					}


				}
			}

		}

		else {
			reportStep("Footer Links are not displayed properly", "FAIL", true);
		}

		return this;
	}
	public MiscPages socialLinksFooterNav(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();

		if(driver.findElementByXPath(objValue.getProperty("xpath.footersocialSection"))!=null) {

			List<WebElement> menuList = driver.findElementsByXPath("//li[@class='footer-social-list']//a");     
			for(int j = 1; j<=menuList.size();j++) {
				if(j==1) {
					WebElement listMenu = driver.findElementByXPath("(//li[@class='footer-social-list']//a)[" +(j+0)+ "]");
					listMenu.click();
					switchToLastWindow();
					String title = driver.getTitle();
					verifyTitle(title);
					reportStep("Facebook page is displayed properly", "PASS", true);
					closeBrowser();
					switchToParentWindow();
				}

				else if(j == 2) {
					WebElement listMenu = driver.findElementByXPath("(//li[@class='footer-social-list']//a)[" +(j+0)+ "]");
					listMenu.click();
					switchToLastWindow();
					String title = driver.getTitle();
					verifyTitle(title);
					reportStep("Twitter page is displayed properly", "PASS", true);
					closeBrowser();
					switchToParentWindow();

				}

				else if(j == 3) {
					WebElement listMenu = driver.findElementByXPath("(//li[@class='footer-social-list']//a)[" +(j+0)+ "]");
					listMenu.click();
					switchToLastWindow();
					String title = driver.getTitle();
					verifyTitle(title);
					reportStep("Instagram page is displayed properly", "PASS", true);
					closeBrowser();
					switchToParentWindow();

				}

				else if(j == 4) {
					WebElement listMenu = driver.findElementByXPath("(//li[@class='footer-social-list']//a)[" +(j+0)+ "]");
					listMenu.click();
					switchToLastWindow();
					String title = driver.getTitle();
					verifyTitle(title);
					reportStep("You Tube page is displayed properly", "PASS", true);
					closeBrowser();
					switchToParentWindow();

				}

				else if(j == 5) {
					WebElement listMenu = driver.findElementByXPath("(//li[@class='footer-social-list']//a)[" +(j+0)+ "]");
					listMenu.click();
					switchToLastWindow();
					String title = driver.getTitle();
					verifyTitle(title);
					reportStep("Pinterest page is displayed properly", "PASS", true);
					closeBrowser();
					switchToParentWindow();

				}

				else if(j == 6) {
					WebElement listMenu = driver.findElementByXPath("(//li[@class='footer-social-list']//a)[" +(j+0)+ "]");
					listMenu.click();
					switchToLastWindow();
					String title = driver.getTitle();
					verifyTitle(title);
					reportStep("Communication Preference page is displayed properly", "PASS", true);
					closeBrowser();
					switchToParentWindow();

				}

				else {
					reportStep("Social Links are not dispalyed properly", "PASS", true);
				}



			}
		}
		return this;

	}

	public MiscPages logoFooterNav(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();
		if(driver.findElementByXPath(objValue.getProperty("xpath.footerLogos"))!=null) {
			List<WebElement> footerLogosLink = driver.findElementsByXPath("(//div[@class='footer-logo-items']//a)");
			for(int i = 1;i<=footerLogosLink.size();i++) {
				if(i==1) {
					WebElement footerLink = driver.findElementByXPath("(//div[@class='footer-logo-items']//a)[" +(i+0)+ "]");
					footerLink.click();
					String title = driver.getTitle();
					verifyTitle(title);
					reportStep("Hyundai Logo is clicked sucessfully", "PASS", true);
				}		
				else if(i == 2) {
					WebElement footerMotorLogoLink = driver.findElementByXPath("(//div[@class='footer-logo-items']//a)[" +(i+0)+ "]");
					footerMotorLogoLink.click();
					String motorPage = getTextByXpath(objValue.getProperty("xpath.motorsPageVerify"));
					verifyTextByXpath(objValue.getProperty("xpath.motorsPageVerify"), motorPage);
					reportStep("Motors Page is verified successfully", "PASS", true);
				}

				else {
					reportStep("Footer Logos are not clicked sucessfully", "FAIL", true);
				}

			}
		}

		if(driver.findElementByXPath(objValue.getProperty("xpath.footerCopy"))!=null) {
			String footerCopy = getTextByXpath(objValue.getProperty("xpath.footerCopy"));
			verifyTextByXpath(objValue.getProperty("xpath.footerCopy"), footerCopy);
			reportStep("Footer content is verified successfully", "PASS", true);
		}

		else {
			reportStep("Footer content is not verified successfully", "FAIL", true);
		}

		return this;

	}

	public MiscPages langFooterNav(String Testcasenumber) throws InterruptedException {
		closeNotificationPopup();
		closeWelcomePopup();

		if(driver.findElementByXPath(objValue.getProperty("xpath.footerLanguage"))!=null) {
			List<WebElement> languageLinks = driver.findElementsByXPath("(//div[@class='dropdown-items'])//a");
			//scrollElementByPixel(objValue.getProperty("xpath.footerLanguage"));
			for(int i =1;i<=languageLinks.size();i++) {

				clickByXpathjs(objValue.getProperty("xpath.footerLanguage"), "Language dropdown");

				if(i == 1) {				
					WebElement langEnglishLink = driver.findElementByXPath("((//div[@class='dropdown-items'])//a)["+(i+0)+"]");
					js.executeScript("arguments[0].click();", langEnglishLink);
					//langEnglishLink.click();
					String title = driver.getTitle();
					verifyTitle(title);
					reportStep("English link is clicked successfully", "PASS", true);
				}

				else if(i == 2) {
					WebElement langKoLink = driver.findElementByXPath("((//div[@class='dropdown-items'])//a)["+(i+0)+"]");
					js.executeScript("arguments[0].click();", langKoLink);
					//langKoLink.click();
					String title = driver.getTitle();
					verifyTitle(title);
					reportStep("Korean link is clicked successfully", "PASS", true);
				}

				else if(i == 3) {
					WebElement langzhLink = driver.findElementByXPath("((//div[@class='dropdown-items'])//a)["+(i+0)+"]");
					js.executeScript("arguments[0].click();", langzhLink);
					//langzhLink.click();
					String title = driver.getTitle();
					verifyTitle(title);
					reportStep("Zh link is clicked successfully", "PASS", true);
				}

				else if(i == 4) {
					WebElement langSpLink = driver.findElementByXPath("((//div[@class='dropdown-items'])//a)["+(i+0)+"]");
					js.executeScript("arguments[0].click();", langSpLink);
					//langSpLink.click();
					String title = driver.getTitle();
					verifyTitle(title);
					reportStep("Spanish link is clicked successfully", "PASS", true);
				}

				else {
					reportStep("Language links are not clicked successfully", "FAIL", true);
				}

			}
		}
		return this;
	}


}
