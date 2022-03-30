package main.java.testcase;

import java.awt.AWTException;
import java.io.IOException;

import main.java.pagesobject.Byo;
import main.java.pagesobject.CompareVehicles;
import main.java.pagesobject.FindDealer;
import main.java.pagesobject.HeaderNavigation;
import main.java.pagesobject.HomePage;
import main.java.pagesobject.Leads;
import main.java.pagesobject.LocalOffers;
import main.java.pagesobject.MiscPages;
import main.java.pagesobject.RAQ;
import main.java.pagesobject.Search_Inventory;
import main.java.pagesobject.VehicleBrowse;
import main.java.pagesobject.Vlp;
import main.java.pagesobject.Vlp_New;
import main.java.utility.Projectcommonmethodes;
import main.java.utility.Reporter;

public class Testcase extends  Projectcommonmethodes
{	
	public static void getsetData(String Testcasenumber, String Description,String Execute) throws IOException, InterruptedException, AWTException {

		if(Execute.contains("YES")){
			
			Reporter.testcasenumber(Testcasenumber);
			
			Projectcommonmethodes.testcasenumber(Testcasenumber);	
			switch(Testcasenumber)
			{
			
			case "TC001" :
				new Vlp_New().clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGalleryVideo(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC002" :
				new Vlp_New().clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).nexoGalleryVerify(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC003" :
				new Vlp_New().clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGalleryVideo(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC004" :
				new Vlp_New().clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGallery(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC005" :
				new Vlp_New().clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGalleryVideo(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC006" :
				new Vlp_New().clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGallery(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC007" :
				new Vlp_New().clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).tucson2022vehicle(Testcasenumber);
				break;
			case "TC008" :
				new Vlp_New().clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGallery(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC009" :
				new Vlp_New().clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGallery(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC010" :
				new Vlp_New().clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGallery(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC011" :
				new Vlp_New().clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGallery(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC012" :
				new Vlp_New().clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverviewVelosterN(Testcasenumber).verifyTrims(Testcasenumber).verifyGallery(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC013" :
				new Vlp_New().clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGallery(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			
			/*case "TC014":
				new HeaderNavigation(driver).menuClick(Testcasenumber);
				break;*/
			case "TC014":
				new HeaderNavigation(driver).menuClick(Testcasenumber).cpoLinkClick(Testcasenumber).cpoTextVerification(Testcasenumber);
				break;
			case "TC015":
				new RAQ().menuClick(Testcasenumber).menuRAQLink(Testcasenumber).textRAQVerification(Testcasenumber).
				selectVehicle(Testcasenumber).chooseDealer(Testcasenumber).enterYourInfo(Testcasenumber);
				break;
			case "TC016":
				new RAQ().menuClick(Testcasenumber).menuRAQLink(Testcasenumber).textRAQVerification(Testcasenumber).
				selectVehicle(Testcasenumber).chooseDealer(Testcasenumber).enterYourInfo(Testcasenumber);
				break;
			case "TC017":
				new RAQ().menuClick(Testcasenumber).menuRAQLink(Testcasenumber).textRAQVerification(Testcasenumber).
				selectVehicle(Testcasenumber).chooseDealer(Testcasenumber).enterYourInfo(Testcasenumber);
				break;
			case "TC018":
				new RAQ().menuClick(Testcasenumber).menuRAQLink(Testcasenumber).textRAQVerification(Testcasenumber).
				selectVehicle(Testcasenumber).chooseDealer(Testcasenumber).enterYourInfo(Testcasenumber);
				break;
			case "TC019":
				new RAQ().menuClick(Testcasenumber).menuRAQLink(Testcasenumber).textRAQVerification(Testcasenumber).
				selectVehicle(Testcasenumber).chooseDealer(Testcasenumber).enterYourInfo(Testcasenumber);
				break;
			case "TC020":
				new RAQ().menuClick(Testcasenumber).menuRAQLink(Testcasenumber).textRAQVerification(Testcasenumber).
				selectVehicle(Testcasenumber).chooseDealer(Testcasenumber).enterYourInfo(Testcasenumber);
				break;
			case "TC021" :
				new Leads(driver).keepMeUpdateLeadForm(Testcasenumber);
				break;
			case "TC022" :
				new Leads(driver).menuClick(Testcasenumber).menuRAQLink(Testcasenumber).textRAQVerification(Testcasenumber).
				selectVehicle(Testcasenumber).chooseDealer(Testcasenumber).requestAQuoteLeadsFlow(Testcasenumber).outlookMailLogin(Testcasenumber).emailVerifyRequestAQuote(Testcasenumber);
				break;
			case "TC023" :
				new Leads(driver).menuClick(Testcasenumber).menuRAQLink(Testcasenumber).textRAQVerification(Testcasenumber).
				selectVehicle(Testcasenumber).chooseDealer(Testcasenumber).requestAQuoteLeadsFlow(Testcasenumber).outlookMailLogin(Testcasenumber).emailVerifyRequestAQuote(Testcasenumber);
				break;
			case "TC024" :
				new Leads(driver).clickVehicleNav(Testcasenumber).selectVehicleVLP(Testcasenumber).vlpRaqLeadFlow(Testcasenumber).outlookMailLogin(Testcasenumber).emailVerifyRequestAQuote(Testcasenumber);
				break;
			case "TC025" :
				new Leads(driver).clickVehicleNav(Testcasenumber).selectVehicleVLP(Testcasenumber).vlpRaqLeadFlow(Testcasenumber).outlookMailLogin(Testcasenumber).emailVerifyRequestAQuote(Testcasenumber);
				break;
			case "TC026" :
				new Leads(driver).vehicleModel(Testcasenumber).vehicleResult(Testcasenumber).searchInvRaqSubmit(Testcasenumber).outlookMailLogin(Testcasenumber).emailVerifyRequestAQuoteSearchInv(Testcasenumber);
				break;
			/*case "TC022" :
				new Leads(driver).menuClick(Testcasenumber).menuRAQLink(Testcasenumber).textRAQVerification(Testcasenumber).
				selectVehicle(Testcasenumber).chooseDealer(Testcasenumber).requestAQuoteLeadsFlow(Testcasenumber).outlookMailLogin(Testcasenumber).emailVerifyRequestAQuote(Testcasenumber);
				break;
			case "TC023" :
				new Leads(driver).menuClick(Testcasenumber).menuRAQLink(Testcasenumber).textRAQVerification(Testcasenumber).
				selectVehicle(Testcasenumber).chooseDealer(Testcasenumber).requestAQuoteLeadsFlow(Testcasenumber);
				break;
			case "TC024" :
				new Leads(driver).clickVehicleNav(Testcasenumber).selectVehicleVLP(Testcasenumber).vlpRaqLeadFlow(Testcasenumber);
				break;
			case "TC025" :
				new Leads(driver).clickVehicleNav(Testcasenumber).selectVehicleVLP(Testcasenumber).vlpRaqLeadFlow(Testcasenumber);
				break;
			case "TC026" :
				new Leads(driver).vehicleModel(Testcasenumber).vehicleResult(Testcasenumber).searchInvRaqSubmit(Testcasenumber);
				break;*/
			case "TC027" :
				new Leads(driver).vehicleModel(Testcasenumber).vehicleResult(Testcasenumber).searchInvRaqNegativeFlow(Testcasenumber);
				break;
			case "TC028" :
				new Leads(driver).autoLinkClick(Testcasenumber).autoShowsNegative(Testcasenumber).autoPage(Testcasenumber).KeepInForm(Testcasenumber);
                break;
			case "TC029" :
                new Leads(driver).offersPageIoniq(Testcasenumber).negativeFirstName(Testcasenumber).rateQuoteForm(Testcasenumber).outlookMailLogin(Testcasenumber).mailValidations(Testcasenumber);
                break;
			case "TC030" :
				 new Leads(driver).offersPageAccent(Testcasenumber).negativeFirstName(Testcasenumber).rateQuoteForm(Testcasenumber).outlookMailLogin(Testcasenumber).mailValidations(Testcasenumber);
	                break;
			case "TC031" :
				new Leads(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber).outlookMailLogin(Testcasenumber).emailVerifyRequestAQuote(Testcasenumber);
				break;
			case "TC032" :
				new Leads(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber).outlookMailLogin(Testcasenumber).emailVerifyRequestAQuote(Testcasenumber);
				break;
             /*case "TC029" :
                new Leads(driver).offersPageIoniq(Testcasenumber).negativeFirstName(Testcasenumber).rateQuoteForm(Testcasenumber);
                break;
			case "TC030" :
				 new Leads(driver).offersPageAccent(Testcasenumber).negativeFirstName(Testcasenumber).rateQuoteForm(Testcasenumber);
	                break;
			case "TC031" :
				new Leads(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC032" :
				new Leads(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;*/
			case "TC033":
				new HeaderNavigation(driver).menuClick(Testcasenumber).scheduleTestDriveLink(Testcasenumber);
				break;
			case "TC034":
				new CompareVehicles(driver).clickMenu(Testcasenumber).comparePage(Testcasenumber).vehicleSelector(Testcasenumber).compareVehiclesPopup(Testcasenumber)
				.buildCTACompare(Testcasenumber);
				break;
			case "TC035":
				new CompareVehicles(driver).clickMenu(Testcasenumber).comparePage(Testcasenumber).vehicleSelector(Testcasenumber).compareVehiclesPopup(Testcasenumber)
				.exploreCTACompare(Testcasenumber);
				break;
			case "TC036":
				new CompareVehicles(driver).clickMenu(Testcasenumber).comparePage(Testcasenumber).vehicleSelector(Testcasenumber).compareVehiclesPopup(Testcasenumber)
				.compareCompetitorsCTA(Testcasenumber).vehicleComparison(Testcasenumber).buildLink(Testcasenumber);
				break;
			case "TC037":
				new CompareVehicles(driver).clickMenu(Testcasenumber).comparePage(Testcasenumber).vehicleSelector(Testcasenumber).compareVehiclesPopup(Testcasenumber)
				.compareCompetitorsCTA(Testcasenumber).vehicleComparison(Testcasenumber).exploreLink(Testcasenumber);
				break;
			case "TC038":
				new CompareVehicles(driver).clickMenu(Testcasenumber).comparePage(Testcasenumber).vehicleSelector(Testcasenumber).compareVehiclesPopup(Testcasenumber)
				.compareCompetitorsCTA(Testcasenumber).vehicleComparison(Testcasenumber).compareSection(Testcasenumber).changeVehicleCTA(Testcasenumber);
				break;
			
			case "TC039":
				new LocalOffers(driver).clickMenu(Testcasenumber).offerLink(Testcasenumber).zipPopup(Testcasenumber).filterVehicle(Testcasenumber)
				.filterOfferType(Testcasenumber);
				break;
			case "TC040":
				new LocalOffers(driver).clickMenu(Testcasenumber).offerLink(Testcasenumber).zipPopup(Testcasenumber).filterVehicle(Testcasenumber).priceValidation(Testcasenumber)
				.savingOffers(Testcasenumber).savingDetailsPage(Testcasenumber).offerRAQInfo(Testcasenumber).offerInventorySection(Testcasenumber)
				.offerSeeInventory(Testcasenumber).dealerShipSection(Testcasenumber).offerGetDirection(Testcasenumber).offerVisitDealer(Testcasenumber).
				offerSTD(Testcasenumber).offerTestDrive(Testcasenumber);
				break;
			
				
			default : 
				reportStep("Method name not present for the test case", "FAIL");
			}

		}

	}
}