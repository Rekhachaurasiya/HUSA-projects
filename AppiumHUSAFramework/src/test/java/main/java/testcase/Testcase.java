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
				new FindDealer().verifydealer(Testcasenumber).clickGetDirections(Testcasenumber).TestDrive(Testcasenumber).
				seeInventory(Testcasenumber).visitDealer(Testcasenumber).scheduleService(Testcasenumber);
				break;
			case "TC002" :
				new FindDealer().clickMenu(Testcasenumber).clickFindDealerButton(Testcasenumber).zipcode(Testcasenumber).shopperAssurance(Testcasenumber).CarCare(Testcasenumber).testDrivePopup(Testcasenumber);
				break;
			case "TC003" :
				new FindDealer().clickMenu(Testcasenumber).clickFindDealerButton(Testcasenumber).zipcode(Testcasenumber).searchMoreDealers(Testcasenumber);
				break;
			case "TC004" :
				new Search_Inventory().vehicleModel(Testcasenumber);
				break;
			case "TC005" :
				new Search_Inventory().vehicleModel(Testcasenumber).vehicleResult(Testcasenumber);
				break;
			case "TC006" :
				new Search_Inventory().vehicleModel(Testcasenumber).vehicleResult(Testcasenumber).vehicleDetails(Testcasenumber);
				break;
			case "TC007" :
				new Search_Inventory().vehicleModel(Testcasenumber).vehicleResult(Testcasenumber).vehicleDetails(Testcasenumber).vehicelDetailsLinks(Testcasenumber).raqSubmit(Testcasenumber);
				break;
			case "TC008" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC009" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC010" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC011" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC012" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC013" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC014" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).NexofuelBuildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC015" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC016" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC017" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC018" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC019" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).tucson2022(Testcasenumber);
				break;
			case "TC020" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC021" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC022" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC023" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC024" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC025" :
				new Byo(driver).buildandprice(Testcasenumber).comparevehiclelist(Testcasenumber).selecttrims(Testcasenumber).selectfromtrimarry(Testcasenumber).Buildaccessories(Testcasenumber).Buildsummarycomapre(Testcasenumber).Requestaquote(Testcasenumber);
				break;
			case "TC026" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).offerSectionVerification(Testcasenumber);
				break;
			case "TC027" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).verifyVlpHyundaiAwards(Testcasenumber);
				break;
			case "TC028" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).offersRaq(Testcasenumber);
				break;
			case "TC029" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).verifyVlpHyundaiDiff(Testcasenumber);
				break;
			case "TC030" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).offersRaq(Testcasenumber);
				break;
			case "TC031" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).offerSectionVerification(Testcasenumber);
				break;
			case "TC032" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).verifyVlpHyundaiDiff(Testcasenumber);
				break;
			case "TC033" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).offerSectionVerification(Testcasenumber);
				break;
			case "TC034" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).offerSectionVerificationWithLease(Testcasenumber);
				break;
			case "TC035" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).offerSectionVerificationWithLease(Testcasenumber);
				break;
			case "TC036" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGalleryVideo(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC037" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGalleryVideo(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC038" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGalleryVideo(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC039" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGalleryVideo(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			case "TC040" :
				new Vlp_New(driver).clickVehicleNav(Testcasenumber).selectVehicle(Testcasenumber).validatevehprice(Testcasenumber).verifyOverview(Testcasenumber).verifyTrims(Testcasenumber).verifyGalleryVideo(Testcasenumber).verifySpecs(Testcasenumber);
				break;
			
				
			default : 
				reportStep("Method name not present for the test case", "FAIL");
			}

		}

	}
}