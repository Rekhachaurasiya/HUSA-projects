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
			
			case "TC001":
				new LocalOffers(driver).clickMenu(Testcasenumber).offerLink(Testcasenumber).zipPopup(Testcasenumber).filterVehicle(Testcasenumber).priceValidation(Testcasenumber)
				.financeOffer(Testcasenumber).financeDetailsPage(Testcasenumber).offerRAQInfo(Testcasenumber).offerInventorySection(Testcasenumber)
				.offerSeeInventory(Testcasenumber).dealerShipSection(Testcasenumber).offerGetDirection(Testcasenumber).offerVisitDealer(Testcasenumber).
				offerSTD(Testcasenumber).offerTestDrive(Testcasenumber);
				break;
			case "TC002":
				new LocalOffers(driver).clickMenu(Testcasenumber).offerLink(Testcasenumber).zipPopup(Testcasenumber).filterVehicle(Testcasenumber).priceValidation(Testcasenumber)
				.leaseOffers(Testcasenumber).leaseDetailsPage(Testcasenumber).offerRAQInfo(Testcasenumber).offerInventorySection(Testcasenumber)
				.offerSeeInventory(Testcasenumber).dealerShipSection(Testcasenumber).offerGetDirection(Testcasenumber).offerVisitDealer(Testcasenumber).
				offerSTD(Testcasenumber).offerTestDrive(Testcasenumber);
				break;	
			case "TC003":
				new LocalOffers(driver).clickMenu(Testcasenumber).offerLink(Testcasenumber).zipPopup(Testcasenumber).filterVehicle(Testcasenumber).priceValidation(Testcasenumber)
				.savingOffers(Testcasenumber).savingDetailsPage(Testcasenumber).offerRAQInfo(Testcasenumber).offerInventorySection(Testcasenumber)
				.offerSeeInventory(Testcasenumber).dealerShipSection(Testcasenumber).offerGetDirection(Testcasenumber).offerVisitDealer(Testcasenumber).
				offerSTD(Testcasenumber).offerTestDrive(Testcasenumber);
				break;
			case "TC004":
				new LocalOffers(driver).clickMenu(Testcasenumber).offerLink(Testcasenumber).zipPopup(Testcasenumber).filterVehicle(Testcasenumber).priceValidation(Testcasenumber)
				.leaseOffers(Testcasenumber).leaseDetailsPage(Testcasenumber).offerRAQInfo(Testcasenumber).offerInventorySection(Testcasenumber)
				.offerSeeInventory(Testcasenumber).dealerShipSection(Testcasenumber).offerGetDirection(Testcasenumber).offerVisitDealer(Testcasenumber).
				offerSTD(Testcasenumber).offerTestDrive(Testcasenumber);
				break;
			case "TC005":
				new LocalOffers(driver).offerLinkNextFindingSection(Testcasenumber).zipPopup(Testcasenumber).filterVehicle(Testcasenumber).priceValidation(Testcasenumber)
				.financeOffer(Testcasenumber).financeDetailsPage(Testcasenumber).offerRAQInfo(Testcasenumber).offerInventorySection(Testcasenumber)
				.offerSeeInventory(Testcasenumber).dealerShipSection(Testcasenumber).offerGetDirection(Testcasenumber).offerVisitDealer(Testcasenumber).
				offerSTD(Testcasenumber).offerTestDrive(Testcasenumber);
				break;
			case "TC006":
				new LocalOffers(driver).offerLinkFooter(Testcasenumber).zipPopup(Testcasenumber).filterVehicle(Testcasenumber).priceValidation(Testcasenumber)
				.savingOffers(Testcasenumber).savingDetailsPage(Testcasenumber).offerRAQInfo(Testcasenumber).offerInventorySection(Testcasenumber)
				.offerSeeInventory(Testcasenumber).dealerShipSection(Testcasenumber).offerGetDirection(Testcasenumber).offerVisitDealer(Testcasenumber).
				offerSTD(Testcasenumber).offerTestDrive(Testcasenumber);
				break;
			case "TC007":
				new LocalOffers(driver).clickMenu(Testcasenumber).offerLink(Testcasenumber).specialPromotions(Testcasenumber);
				break;
			case "TC008":
				new LocalOffers(driver).offerHeader(Testcasenumber).zipPopup(Testcasenumber).firstModelDisplay(Testcasenumber).priceValidation(Testcasenumber)
				.financeOffer(Testcasenumber).financeDetailsPage(Testcasenumber).offerRAQInfo(Testcasenumber).offerInventorySection(Testcasenumber)
				.offerSeeInventory(Testcasenumber).dealerShipSection(Testcasenumber).offerGetDirection(Testcasenumber).offerVisitDealer(Testcasenumber).
				offerSTD(Testcasenumber).offerTestDrive(Testcasenumber);
				break;
				
			case "TC009":
				new HomePage(driver).vehicleLineUpSectionSUVs(Testcasenumber);
				break;
			case "TC010":
				new HomePage(driver).vehicleLineUpSectionSedans(Testcasenumber);
				break;
			case "TC011":
				new HomePage(driver).vehicleLineUpSectionCompacts(Testcasenumber);
				break;
			case "TC012":
				new HomePage(driver).nextFindingSection(Testcasenumber).startBuildingSection(Testcasenumber);
				break;
			case "TC013":
				new HomePage(driver).nextFindingSection(Testcasenumber).localOffersSection(Testcasenumber);
				break;
			case "TC014":
				new HomePage(driver).nextFindingSection(Testcasenumber).locateDealerSection(Testcasenumber);
				break;
			case "TC015":
				new VehicleBrowse(driver).allCategoryVerification(Testcasenumber).allCategoryVehicleList(Testcasenumber);
				break;
			case "TC016":
				new VehicleBrowse(driver).suvsCategoryVerify(Testcasenumber);
				break;
			case "TC017":
				new VehicleBrowse(driver).sedansCategoryVerifyNew(Testcasenumber);
				break;
			case "TC018":
				new VehicleBrowse(driver).compactsCategoryVerify(Testcasenumber);
				break;
			case "TC019":
				new VehicleBrowse(driver).comparePopupVerify(Testcasenumber);
				break;
			case "TC020":
				new VehicleBrowse(driver).clickVehicleNav(Testcasenumber).vehicleSelector(Testcasenumber).compareVehiclesPopup(Testcasenumber);
				break;
			case "TC021":
				new MiscPages(driver).ownerAssuVerify(Testcasenumber);
				break;
			case "TC022":
				new MiscPages(driver).headerVerify(Testcasenumber).homeHeaderNav(Testcasenumber);
				break;
			case "TC023":
				new MiscPages(driver).paymentCalculator(Testcasenumber).payCalLinkVerify(Testcasenumber);
				break;
			case "TC024":
				new MiscPages(driver).companyVeify(Testcasenumber);
				break;
			case "TC025":
				new MiscPages(driver).newsVerify(Testcasenumber);
				break;
			case "TC026":
				new MiscPages(driver).autoShowsVerify(Testcasenumber);
				break;
			case "TC027":
				new MiscPages(driver).compareCompetitorVerify(Testcasenumber).comparePageSectionVerify(Testcasenumber);
				break;
			case "TC028":
				new MiscPages(driver).linkClick(Testcasenumber).footerLinks(Testcasenumber).PhilanthropyPage(Testcasenumber).madeAmericaPage(Testcasenumber)
				.happyDriversPage(Testcasenumber).buildingPage(Testcasenumber);
				break;
			case "TC029":
				new MiscPages(driver).menuClick(Testcasenumber).dealerSection(Testcasenumber).faqSection(Testcasenumber);
				break;
			case "TC030":
				new MiscPages(driver).menu(Testcasenumber).searchResults(Testcasenumber);
				break;
			case "TC031":
				new MiscPages(driver).menuLinkClick(Testcasenumber).vehicleSelection(Testcasenumber).selectedVehicleDetails(Testcasenumber)
				.linkNavigation(Testcasenumber).applyCTAClick(Testcasenumber);
				break;
			case "TC032":
				new MiscPages(driver).linkCareersClick(Testcasenumber).subNavigation(Testcasenumber);
				break;
			case "TC033":
				new MiscPages(driver).motorsPage(Testcasenumber).verifyMotorsPage(Testcasenumber);
				break;
			case "TC034":
				new MiscPages(driver).awardsPage(Testcasenumber).awardPageVerify(Testcasenumber);
				break;
			case "TC035":
				new MiscPages(driver).menuLinkNavClick(Testcasenumber).menuResearchLinkNav(Testcasenumber).menuShopLink(Testcasenumber)
				.menuBuyLink(Testcasenumber).menuOwnersLink(Testcasenumber).menuAssuranceLink(Testcasenumber);
				break;
			case "TC036":
				new MiscPages(driver).vehiclesFooterVerify(Testcasenumber).shoppingToolsFooterLink(Testcasenumber);
				break;
			case "TC037":
				new MiscPages(driver).ownerFooterLink(Testcasenumber).whyFooterLinksNav(Testcasenumber);
				break;
			case "TC038":
				new MiscPages(driver).aboutFooterLinkNav(Testcasenumber);
				break;
			case "TC039":
				new MiscPages(driver).socialLinksFooterNav(Testcasenumber).logoFooterNav(Testcasenumber);
				break;
			case "TC040":
				new MiscPages(driver).secondaryFooterLink(Testcasenumber);
				break;
			case "TC041":
				new MiscPages(driver).langFooterNav(Testcasenumber);
				break;
				
			default : 
				reportStep("Method name not present for the test case", "FAIL");
			}

		}

	}
}