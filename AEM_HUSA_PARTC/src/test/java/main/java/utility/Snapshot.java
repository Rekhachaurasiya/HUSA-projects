package main.java.utility;


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



public abstract class Snapshot extends Projectcommonmethodes {
	public static  RemoteWebDriver driver;

	/*public static void  resultsnap() throws IOException, InterruptedException   {
	//static void main(String[] args) throws InterruptedException, IOException{
		String Workspace = prop.getProperty("Workspace");
		System. setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		WebDriver driver= new ChromeDriver();
		//String url= Workspace+Reporter.resultpath();
		String url= Workspace+"/test-output/Default suite/Default test.html";
		driver.get(url);
		//driver.manage().window().maximize();
		Thread.sleep(1000);
		String path="./Result.jpg";
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(),"jpg",new File(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        driver.quit();

		driver.findElement(By.xpath("//body/nav/ul/li[3]/a")).click();

		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(path);	
		FileUtils.copyFile(SrcFile, DestFile);



	}*/


	public static void  resultsnap() throws IOException, InterruptedException   {
		//static void main(String[] args) throws InterruptedException, IOException{


		/*String Workspace = prop.getProperty("Workspace");
		System. setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		WebDriver driver= new ChromeDriver();
		String url= Workspace+Reporter.resultpath();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//body/nav/ul/li[3]/a")).click();
		String path="./Result.jpg";
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(path);	
		FileUtils.copyFile(SrcFile, DestFile);*/

		String Workspace = prop.getProperty("Workspace");
		System. setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		/*ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);*/
		 driver= new ChromeDriver();
		String url= Workspace+"/HUSA_Automation.html";
		driver.get(url);
		/*Point  p= new Point(0,-3000);
		driver.manage().window().setPosition(p);*/

		Dimension d = new Dimension(10000,1000);
		//Dimension d = new Dimension(50000,80000);
		driver.manage().window().setSize(d);
		
		/*//driver.manage().window().maximize();
	
		Dimension d = new Dimension(20000,30000);
		
		driver.manage().window().setSize(d);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("window-size=1280,600");
		 driver = new ChromeDriver(chromeOptions);
			driver.get(url);*/
		//driver.manage().window().maximize();
		String file = Workspace+"/Result.png";
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		try {
			ImageIO.write(screenshot.getImage(),"png",new File(file));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		driver.quit();


	}




}



