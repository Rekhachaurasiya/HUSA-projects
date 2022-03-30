package main.java.pagesobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import main.java.utility.Projectcommonmethodes;
import main.java.utility.ReadExcelData;


public class Byo extends Projectcommonmethodes {
	public Byo(RemoteWebDriver driver) {
		this.driver = driver;
	}

	/*public Vlp meetyourvehicle(String Testcasenumber) throws IOException, InterruptedException
	{
	    commoncomponents.ReadExcelData.getdata(Testcasenumber,"VehicleName");
		clickByXpath(objValue.getProperty("xpath.gmail"),"Gmail");
		//clickByXpath(objValue.getProperty("xpath.signin"));
		return new Vlp(driver);
	}*/
	
	public Byo zipcode(String Testcasenumber) throws IOException, InterruptedException
	{
		if(driver.findElement(By.xpath(objValue.getProperty("xpath.zipinput"))) != null)
		{
		enterByXpath(objValue.getProperty("xpath.zipinput"),"92606","Zipcode" );
		System.out.println("Zipcode entered");
		Thread.sleep(1000);
		clickByXpath(objValue.getProperty("xpath.zipsubmit"),"Submit" );
		
	}
		return this;
	}
	public Byo  offerclose(String Testcasenumber) throws InterruptedException
	{
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//iframe[@id='hlFrame']")) != null)
		{
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='hlFrame']")));
		clickByXpath(objValue.getProperty("xpath.offerclose"),"Offerclose");
		 driver.switchTo().defaultContent();
	
	}
		else
		{
		System.out.println("Popup not appear");
		}
		return this;
			
	}
	
	public Byo  buildandprice(String Testcasenumber) throws InterruptedException
	{
		//closeNotificationPopup();
		//closeWelcomePopup();
		driver.switchTo().defaultContent();
		sleepTime(15);
		clickByXpathjs(objValue.getProperty("xpath.buildandprice"),"buildandprice");
		sleepTime(25);
		verifyTextContainsByXpath(objValue.getProperty("xpath.buildHyundai"),"Build Your Hyundai");
		
		return this;
	}
	  String vehcompare ="";
	int i;
	public Byo comparevehiclelist(String Testcasenumber) throws IOException, InterruptedException
	{
//closeNotificationPopup();
		  String Vehiclemodelsheet = ReadExcelData.getdata(Testcasenumber,"Vehiclemodel");
		  String Vehiclemodelname = ReadExcelData.getdata(Testcasenumber,"VehicleName");
		  sleepTime(30);
		 /* WebElement closecookie = driver.findElement(By.xpath("//button[@class='cookie-disclaimer-cta button button-navy']"));
			closecookie.click();*/
		 // closeNotificationPopup();
			//Thread.sleep(5000);
		 
	
		  try
		{
			  List<WebElement> vehiclelist = driver.findElements(By.xpath("((//div[@class='bl-vehicle-card'])/div)"));
			  System.out.println(vehiclelist.size());
		  for ( i=1;i<vehiclelist.size();i++)
		   {			   		   
			  sleepTime(20);
			   WebElement	VehicleName1 =  driver.findElement(By.xpath("((//div[@class='bl-vehicle-card'])/div)["+(i)+"]"));
				System.out.println(VehicleName1);
			 //  String	VehicleName2= getTextByXpath(objValue.getProperty("xpath.vehiclemodelname"));  
			//   xpath.vehiclemodelname=(//div[@class='bl-vehicle-card'])["+(i+1)+"]//span[@class='bl-vehicle-model-name']
			   WebElement	WVehicleName2=  driver.findElement(By.xpath("((//div[@class='bl-vehicle-card'])/div)["+(i)+"]//span[@class='bl-vehicle-model-name']"));
			   String VehicleName2=WVehicleName2.getText().trim();
			   String VehicleName = VehicleName2.replaceAll("[^a-zA-Z0-9]", "");
			   System.out.println(VehicleName);
			  // String	Vehiclemodel1 =  getTextByXpath(objValue.getProperty("xpath.vehiclemodelyear"));  
			   WebElement	WVehicleName1=  driver.findElement(By.xpath("((//div[@class='bl-vehicle-card'])/div)["+(i)+"]//span[@class='bl-vehicle-model-year']"));
			   String Vehiclemodel1=WVehicleName1.getText().trim();
			   String Vehiclemodel = Vehiclemodel1.replaceAll("[^a-zA-Z0-9]", "");
		    vehcompare = VehicleName + Vehiclemodel;
			   String strMain =Vehiclemodelname+Vehiclemodelsheet; 
				/*String[] arrSplit = strMain.split(", ");
				String veharray = arrSplit[i];*/
								
				if(strMain.equals(vehcompare))
				{
				System.out.println("PASS" + strMain + " from the date sheet is matching with the UI vehicle list " + vehcompare);
				reportStep(strMain + " from the date sheet is matching with the UI vehicle list ", "PASS");
				//closeWelcomePopup();
				break;
				}
					
				
		   }
		
		}
		  catch (Exception e)
		{
				e.printStackTrace();
		}
			  		 
			
		      return this;
		  	   
	}
	

	  
	public Byo selecttrims(String Testcasenumber) throws InterruptedException
	{
		 sleepTime(10);
//	closeWelcomePopup();
		//String gettrimnumber= getTextByXpath(objValue.getProperty("xpath.vehiclemodeltrim"));  
	if(driver.findElement(By.xpath(" (((//div[@class='bl-vehicle-card'])/div)["+(i)+"]//parent::div//button)[2]")) != null) {
		 WebElement	Wgettrimnumber=  driver.findElement(By.xpath(" (((//div[@class='bl-vehicle-card'])/div)["+(i)+"]//parent::div//button)[2]"));

		   String gettrimnumber=Wgettrimnumber.getText().trim();
		  System.out.println("No of Trims" + gettrimnumber ) ;
		  Wgettrimnumber.click();
	}
	
		//  clickByXpath(objValue.getProperty("xpath.vehiclemodeltrim"),"Click Trims button"); 
		  sleepTime(15);
		  return this;
		  
	}
	
	String trimname="";

	public Byo selectfromtrimarry(String Testcasenumber) throws IOException, InterruptedException
	{
		String Vehicletrim = ReadExcelData.getdata(Testcasenumber,"Trimselection");
		 // Thread.sleep(5000);
		
		
		  
		 List<WebElement> trimlist = driver.findElements(By.xpath("(//ul[@class='bld-dwr-tab-list']//li)"));
		try
		{
			for ( int j=1;j<=trimlist.size();j++)
	
		   {			   		   			
				//WebElement	trimselect =  driver.findElement(By.xpath("(//ul[@class='bld-dwr-tab-list']//li)["+(i+1)+"]"));
				WebElement	trimselect =  driver.findElement(By.xpath("(//ul[@class='bld-dwr-tab-list']//li)["+(j)+"]//span[@class='bld-dwr-model-name']"));
				  trimname=trimselect.getText().trim();
				//trimname= getTextByXpath(objValue.getProperty("xpath.selecttrimname"));  
				System.out.println(trimname);
				 sleepTime(20);
				if(trimname.equalsIgnoreCase(Vehicletrim))
				{
					System.out.println("PASS" + Vehicletrim + " from the date sheet is matching with the UI vehicle trim list " + trimname);
					reportStep(Vehicletrim + " from the date sheet is matching with the UI vehicle trim list ", "PASS");
					sleepTime(20);
					//closeWelcomePopup();
					trimselect.click();
				//	clickByXpath(objValue.getProperty("xpath.selecttrimname"),"selecttrimname");
					sleepTime(40);
			
					clickByXpath(objValue.getProperty("xpath.selectbuild"),"selectbuild");
					sleepTime(50);
					break;
					}
					else
					{
						//System.out.println("FAIL" + Vehicletrim + " from the date sheet is NOT matching with the UI vehicletrim list " + trimname);
					//	reportStep(Vehicletrim + " from the date sheet is NOT matching with the UI vehicle list ", "FAIL");
					
					}			
			
			
			}
		}
			catch(Exception e)
			{
				reportStep("Trim page not responding as expected" , "FAIL", true);
			}
	
				
		 return this;
	}	
	
	String msrptot="";
	public Byo Buildaccessories(String Testcasenumber) throws InterruptedException
	{
		//sleepTime(10);
		//clickByXpath(objValue.getProperty("xpath.accessories"),"accessories");
		sleepTime(40);
		//closeWelcomePopup();
			//	clickByXpath(objValue.getProperty("xpath.defaultaccessories"),"defaultaccessories");
		 if ( ! driver.findElement(By.xpath("//li[@class='bo-choice-list-item'][1]//div[@class='form-checkbox-box']")).isSelected() )
		{
		     driver.findElement(By.xpath("//li[@class='bo-choice-list-item'][1]//div[@class='form-checkbox-box']")).click();
		     System.out.println("Accessories Check box selected");
		}
		 else
		{
			 System.out.println("Accessories Check box already selected");
		}
		msrptot= getTextByXpath(objValue.getProperty("xpath.buildmsrp"));  
		sleepTime(15);
		//clickByXpath(objValue.getProperty("xpath.finishbuild"),"finishbuild");
		WebElement	finishbuild = driver.findElement(By.xpath("(//a[text()='Finish build'])[1]"));
		finishbuild.click();
		return this;
		
	}

	public Byo NexofuelBuildaccessories(String Testcasenumber) throws InterruptedException
	{
		msrptot= getTextByXpath(objValue.getProperty("xpath.buildmsrp"));  
		Thread.sleep(5000);
		//clickByXpath(objValue.getProperty("xpath.finishbuild"),"finishbuild");
		WebElement	finishbuildNexo = driver.findElement(By.xpath("//a[@class='button button-navy bo-summary-finish-button']"));
		finishbuildNexo.click();
		return this;
	}
	
	public Byo Buildsummarycomapre(String Testcasenumber) throws InterruptedException
	{
		/*Thread.sleep(10000);
		closeWelcomePopup();*/
		String	sumyear= getTextByXpath(objValue.getProperty("xpath.yearsummary"));  
		String	summodel= getTextByXpath(objValue.getProperty("xpath.modelsummary"));  
		String	summtrim= getTextByXpath(objValue.getProperty("xpath.trimsummary"));
		String	msrptotsummary= getTextByXpath(objValue.getProperty("xpath.msrptotsummary"));
		//String	estimatedsummary= getTextByXpath(objValue.getProperty("xpath.estimatedsummary"));
		//String	netpricesummary= getTextByXpath(objValue.getProperty("xpath.netpricesummary"));
		String sumyearmodel =summodel+sumyear;
		String sumyearmodel1 = sumyearmodel.replaceAll("[^a-zA-Z0-9]", "");
		if(sumyearmodel1.equals(vehcompare))
		{
			System.out.println("PASS" + vehcompare + " vehicle model and year matches with summary " + vehcompare);
			reportStep(vehcompare + " vehicle model and year matches with summary ", "PASS");
						if(summtrim.equals(trimname))
						
							{
							System.out.println("PASS" + summtrim + " vehicle Trim matches with summary " + trimname);
							
							if(msrptot.equals(msrptotsummary))
							{
								System.out.println("PASS" + msrptot + " MSRP matches with summary " + msrptotsummary);
								reportStep( " MSRP matches with summary BYO summary "+msrptotsummary, "PASS");
								/*if(estimatedsummary.equals(netpricesummary))
								{
									System.out.println("PASS" + estimatedsummary + " net price matches with summary " + netpricesummary);
							}
								else
								{					

									System.out.println("FAIL"+ estimatedsummary + " net price NOT matches with summary " + netpricesummary);
								}*/
							}	
							else
						{
								System.out.println("FAIL" + msrptot + " MSRP NOT matches with summary " + msrptotsummary);
								reportStep( " MSRP not matches with BYO summary "+ msrptotsummary, "FAIL");
						}								
							
						}
						else
						{
	
								System.out.println("FAIL" + summtrim + " vehicle Trim NOT matches with summary " + trimname);
						}
						
						
						
			}
			else
			{
				System.out.println("FAIL" + vehcompare + " vehicle model,year not matches with summary " + sumyearmodel1 );
				
		}
	return this;
	}
		
	

public Byo Requestaquote (String Testcasenumber) throws InterruptedException

{
	//closeNotificationPopup();
	enterByXpath(objValue.getProperty("xpath.firstname"),"TestMichael"," firstname");
	enterByXpath(objValue.getProperty("xpath.lastname"),"TestMichael"," lastname");
	enterByXpath(objValue.getProperty("xpath.raqemail"),"Mybcc20@yahoo.com"," email");
	sleepTime(30);
	clickByXpath(objValue.getProperty("xpath.raq"),"raq");
	sleepTime(80);
    String raqsuccessmsg = getTextByXpath(objValue.getProperty("xpath.successraq"));
    System.out.println(raqsuccessmsg);
    String  graqsuccesstxt = getTextByXpath(objValue.getProperty("xpath.successraqtest"));
    String raqsub="Request Submitted";
           if(graqsuccesstxt.equals(raqsub))
    {
           System.out.println( graqsuccesstxt +"Request Submitted successfully");
           reportStep("Request a Quote submitted Successfully" , "PASS", true);
    }
    
           else
           {
                  System.out.println(graqsuccesstxt + "Request NOT Submitted successfully");
                  reportStep("Request a Quote" , "FAIL", true);
           }
           System.out.println("B&P Testcase Completed");
		return this;
}
}


/*	public Byo Buildsummary(String Testcasenumber) 
	{
		String Totalmsrp = getTextByXpath(objValue.getProperty("xpath.totalmsrp"));
		
	}
	
	public static String vehcompare,Getprice,Getmpg,Gethp;
	
	public Byo selectfromvehiclelist(String Testcasenumber) throws IOException, InterruptedException
	{

		String VehicleNamecol =ReadExcelData.getdata(Testcasenumber,"VehicleName");
		String Vehiclemodelcol = ReadExcelData.getdata(Testcasenumber,"Vehiclemodel");
		String Vehicledatasheet = VehicleNamecol + Vehiclemodelcol;
		 List <WebElement> vehiclelist = driver.findElements(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car'])"));
		   for ( int i=1;i<vehiclelist.size();i++)
		   {
			   
			   WebElement	VehicleName1 =  driver.findElement(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car']//div[@class='vbws-car-name'])["+i+"]"));
			   String  VehicleName2 = VehicleName1.getText();
			   String  VehicleName = VehicleName2.replaceAll("[^a-zA-Z0-9]", "");
			   WebElement	Vehiclemodel1 =  driver.findElement(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car']/h3/div[@class='vbws-car-year'])["+i+"]"));		
			   String  Vehiclemodel = Vehiclemodel1.getText();
			   vehcompare = VehicleName + Vehiclemodel;
			   if(vehcompare.equals(Vehicledatasheet))
			   
			   {
				 WebElement selectveh= driver.findElement(By.xpath("(//div[@class='vbws-group']//div[@class='vbws-car']//div[@class='vbws-car-name'])["+i+"]"));
				Thread.sleep(5000);
				String Getprice1=(objValue.getProperty("xpath.price"));
				String Getprice2=(objValue.getProperty("xpath.price2"));
				  WebElement price1 =  driver.findElement(By.xpath(Getprice1+i+Getprice2));
				    Getprice = price1.getText();
					System.out.println(Getprice);
				  String mpg1=(objValue.getProperty("xpath.mpg"));
					String mpg2=(objValue.getProperty("xpath.mpg2"));
					  WebElement Getmpg1 =  driver.findElement(By.xpath(mpg1+i+mpg2));
					    Getmpg = Getmpg1.getText();
						 System.out.println(Getmpg);
						 String hp1=(objValue.getProperty("xpath.hp1"));
							String hp2=(objValue.getProperty("xpath.hp2"));
							  WebElement Gethp1 = driver.findElement(By.xpath(hp1+i+hp2));
							   Gethp = Gethp1.getText();
								 System.out.println(Gethp);
								selectveh.click(); 
				System.out.println(" PASS" + vehcompare + "Selected vehicle from the list matches " + Vehicledatasheet);	
				 break;
			   }
			   
		    
		   }

		   return this;
	}

	public Byo validatevehmodel(String Testcasenumber) throws InterruptedException 
	{
		Thread.sleep(5000);
		String validatevehmodelname = getTextByXpath(objValue.getProperty("xpath.vehname"));
		String validatevehmodelyear = getTextByXpath(objValue.getProperty("xpath.vehyear"));
		String validatevehmodel= validatevehmodelname + validatevehmodelyear;
		
		if(vehcompare.equalsIgnoreCase(validatevehmodel))
		{
			System.out.println(" PASS" + validatevehmodel + "Selected vehicle from the list and header value matches " + vehcompare);	
		}			
			else
			{
				System.out.println(" FAIL" + validatevehmodel + "Selected vehicle from the list and header value NOT matches " + vehcompare);
				reportStep( validatevehmodel + "Selected vehicle from the list and header value NOT matches ", "FAIL");
			}
							
		return this;
		
	}
	
	public Byo validatevehprice(String Testcasenumber) throws InterruptedException 
	{
		Thread.sleep(3000);
		ClickandHold(objValue.getProperty("xpath.2020-elantra"));
		String vehprice=getTextByXpath(objValue.getProperty("xpath.imageprice"));
		System.out.println(vehprice);
		String mpg=getTextByXpath(objValue.getProperty("xpath.imagempg"));
		String hp=getTextByXpath(objValue.getProperty("xpath.imagehp"));
		
		if(Getprice.equals(vehprice))
		{
			System.out.println("PASS"  + Getprice + " Vehicle price matching " + vehprice);

					
		if(Getmpg.equals(mpg))
		{
			System.out.println("PASS"  + Getmpg + " Vehicle mpg matching " + mpg);
			
			if(Gethp.equals(hp))
			{
				System.out.println("PASS"  + Gethp + " Vehicle hp matching " + hp);
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
					
			}
		}
			else
			{
				System.out.println("FAIL" + Getprice + " Vehicle price not matching " + vehprice);
				reportStep( Getprice + " Vehicle price not matching ", "FAIL");
			}
		return this;	
	
		
		}
	
	
	public Byo validatetrim(String Testcasenumber) throws InterruptedException 
	{
				
		String validatevehmodelname = getTextByXpath(objValue.getProperty("xpath.vehname"));
		String validatevehmodelyear = getTextByXpath(objValue.getProperty("xpath.vehyear"));
		String validatevehmodel= validatevehmodelname + validatevehmodelyear;
		String estprice= getTextByXpath(objValue.getProperty("xpath.estprice"));  
		String esttrim= getTextByXpath(objValue.getProperty("xpath.esttrim"));  
		String availabletrim= getTextByXpath(objValue.getProperty("xpath.availabletrim"));  
		Thread.sleep(2000);
		clickByXpath(objValue.getProperty("xpath.trim"), "trimlink");
		String trimvehyear= getTextByXpath(objValue.getProperty("xpath.trimvehyear")); 
		String trimvehmodel= getTextByXpath(objValue.getProperty("xpath.trimvehmodel")); 
		String validatevehtrim=trimvehmodel+trimvehyear;
		String trimcount= getTextByXpath(objValue.getProperty("xpath.trimcount")); 	
		String basetrim= getTextByXpath(objValue.getProperty("xpath.basetrim")); 	
	
		if(validatevehmodel.equalsIgnoreCase(validatevehtrim))
		{
			System.out.println("PASS"  + validatevehmodel + " Vehicle model year matching " + validatevehtrim);

					
		if(availabletrim.contains(trimcount))
		{
			System.out.println("PASS"  +  "No of trims" +  trimcount);
			
			if(esttrim.equalsIgnoreCase(basetrim))
					{
						System.out.println("PASS"  + esttrim  + "Trim type matches" +  basetrim);
						clickByXpath(objValue.getProperty("xpath.basetrimbutton"), "Click base trim");
						Thread.sleep(50000);
						String basetrimprice= getTextByXpath(objValue.getProperty("xpath.basetrimprice")); 
						if(estprice.equals(basetrimprice))
						{
						
							System.out.println("PASS"  +  estprice + "Trim PRICE" + basetrim  +  "matches" + basetrimprice);
													}
						else
						{
							System.out.println("FAIL" +  estprice + "Trim PRICE" + basetrim  +  " NOT matches" + basetrimprice);
							reportStep("Trim PRICE:" + basetrimprice + "NOT matches", "FAIL");
						}
		
					}
			else
			{
				System.out.println("FAIL" +  esttrim + "Trim type doesn not matches" + basetrim);
				reportStep( esttrim + "Trim type doesn not matches", "FAIL");
			}
		}
			else
			{
				System.out.println("FAIL" +  "No of trims doesnt match" +  trimcount);
				reportStep( trimcount + "No of trims doesnt match", "FAIL");
			}
		}
				
			else
			{
				System.out.println("FAIL" + validatevehmodel + " Vehicle model year NOT matching " + validatevehtrim);
				reportStep( validatevehtrim + "Vehicle model year NOT matching", "FAIL");
	
			}
		return this;
		
		
	}
		
}
	
*/
	



