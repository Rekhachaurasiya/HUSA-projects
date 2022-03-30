package main.java.commonComponents;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import ch.qos.logback.core.Context;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.serverevents.CustomEvent;
import main.java.utility.Reporter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.google.common.base.Function;

public class Commoncomponents extends Reporter  {
    
    private static final WebElement WebElement = null;
    public static Properties prop;
    public static Properties objValue;
    public static Properties email;
    
    JavascriptExecutor js = (JavascriptExecutor)driver;
    
    public Properties load(){
        String gobalproperties = "./src/test/resources/global.properties";
        prop = new Properties();
        try{
            prop.load(new FileInputStream(gobalproperties));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return prop;
    }
    public Properties emaiid(){
        String kiaproperties = "./src/test/resources//Emailid.Properties";
        email = new Properties();
        try{
                        email.load(new FileInputStream(kiaproperties));
        } catch (IOException e) {
                        throw new RuntimeException(e.getMessage());
        }
        return email;
}
     public Properties commonproperties(){
         String kiaproperties = "./src/test/resources/Husa.properties";
            objValue = new Properties();
            try{
                objValue.load(new FileInputStream(kiaproperties));
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
            return objValue;
        }
    public void unloadObjects() {
        objValue = null;
        
    }
    /**
     * This method will enter the value to the text field using id attribute to locate
     * 
     * @param idValue - id of the webelement
     * @param data - The data to be sent to the webelement
     * @author Rekha
     * @throws IOException 
     */
    public void enterById(String idValue, String data, String fieldvalue ) {
        try {
            driver.findElementById(idValue).clear();
            driver.findElementById(idValue).sendKeys(data);    
            reportStep("The data: "+data+" entered successfully in field : "+fieldvalue, "PASS");
        } catch (NoSuchElementException e) {
            reportStep("The data: "+data+" could not be entered in the field :"+fieldvalue, "FAIL");
        } catch (Exception e) {
            reportStep("Unknown exception occured while entering "+data+" in the field :"+fieldvalue, "FAIL");
        }
    }
    /**
     * This method will enter the value to the text field using name attribute to locate
     * 
     * @param nameValue - name of the webelement
     * @param data - The data to be sent to the webelement
     * @author Rekha
     * @throws IOException 
     */
    public void enterByName(String nameValue, String data,String fieldvalue) {
        try {
            driver.findElement(By.name(nameValue)).clear();
            driver.findElement(By.name(nameValue)).sendKeys(data);    
            reportStep("The data: "+data+" entered successfully in field :"+fieldvalue, "PASS");
        } catch (NoSuchElementException e) {
            reportStep("The data: "+data+" could not be entered in the field :"+fieldvalue, "FAIL");
        } catch (Exception e) {
            reportStep("Unknown exception occured while entering "+data+" in the field :"+fieldvalue, "FAIL");
        }
    }
    public boolean findElementFlag (By by){
        
        boolean bFlag = false;
        WebElement wEle = null; int cntr = 0;
        do{
            try {
                sleepTime(3);
                wEle = driver.findElement(by);    
                if(!wEle.isDisplayed()){
                    wEle = null;
                }
            } catch (Exception e) {
                wEle = null;
            }            
            cntr++;            
        }while(wEle == null && cntr <= 3);
        
        if(wEle != null){
            bFlag = true;
        }
        
        return bFlag;
        
    }
    public static void sleepTime(int Seconds) {
        try {
            Thread.sleep(Seconds *500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method will enter the value to the text field using name attribute to locate
     * 
     * @param xpathValue - xpathValue of the webelement
     * @param data - The data to be sent to the webelement
     * @author Rekha
     * @throws IOException 
     */
    public void enterByXpath(String xpathValue, String data,String fieldvalue) {
        try {
            driver.findElement(By.xpath(xpathValue)).clear();
            System.out.println("text cleared from text box");
            driver.findElement(By.xpath(xpathValue)).sendKeys(data);    
            reportStep("The data: "+data+" entered successfully in field :"+fieldvalue, "PASS");
        } catch (NoSuchElementException e) {
            reportStep("The data: "+data+" could not be entered in the field :"+fieldvalue, "FAIL");
        } catch (Exception e) {
            reportStep("Unknown exception occured while entering "+data+" in the field :"+fieldvalue, "FAIL");
        }
    }
    /**
     * This method will verify the title of the browser 
     * @param title - The expected title of the browser
     * @author Rekha
     */
    public boolean verifyTitle(String title){
        boolean bReturn = false;
        try{
            if (driver.getTitle().equalsIgnoreCase(title)){
                reportStep("The title of the page matches with the value :"+title, "PASS");
                bReturn = true;
            }else
                System.out.println();
            reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "SUCCESS");
        }catch (Exception e) {
            reportStep("Unknown exception occured while verifying the title", "FAIL");
        }
        return bReturn;
    }
    /**
     * This method will verify the given text matches in the element text
     * @param xpath - The locator of the object in xpath
     * @param text  - The text to be verified
     * @author Rekha
     */
    public void verifyTextByXpath(String xpath, String text){
        try {
            String sText = driver.findElementByXPath(xpath).getText();
            if (sText.equalsIgnoreCase(text)){
                reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
            }else{
                reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
            }
        }catch (Exception e) {
            reportStep("Unknown exception occured while verifying the title", "FAIL");
        }
    }
    /**
     * This method will verify the given text is available in the element text
     * @param xpath - The locator of the object in xpath
     * @param text  - The text to be verified
     * @author Rekha
     */
    public void verifyTextContainsByXpath(String xpath, String text){
        try{
            String sText = driver.findElementByXPath(xpath).getText();
            if (sText.contains(text)){
                reportStep("The text: "+sText+" contains the value :"+text, "PASS");
            }else{
                reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
            }
        }catch (Exception e) {
            reportStep("Unknown exception occured while verifying the title", "FAIL");
        }
    }
    /**
     * This method will verify the given text is available in the element text
     * @param id - The locator of the object in id
     * @param text  - The text to be verified
     * @author Rekha
     */
    public void verifyTextById(String id, String text) {
        try{
            String sText = driver.findElementById(id).getText();
            if (sText.equalsIgnoreCase(text)){
                reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
            }else{
                reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
            }
        }catch (Exception e) {
            reportStep("Unknown exception occured while verifying the title", "FAIL");
        }
    }
    /**
     * This method will verify the given text is available in the element text
     * @param id - The locator of the object in id
     * @param text  - The text to be verified
     * @author Rekha
     */
    public void verifyTextContainsById(String id, String text) {
        try{
            String sText = driver.findElementById(id).getText();
            if (sText.contains(text)){
                reportStep("The text: "+sText+" contains the value :"+text, "PASS");
            }else{
                reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
            }
        }catch (Exception e) {
            reportStep("Unknown exception occured while verifying the title", "FAIL");
        }
    }
    /**
     * This method will close all the browsers
     * @author Rekha
     */
    public void closeAllBrowsers() {
        try {
            if(driver!=null){
            driver.quit();
            }
        } catch (Exception e) {
            reportStep("The browser could not be closed.", "WARN");
        }
    }
    public void closeBrowser() {
        try {
            driver.close();
        } catch (Exception e) {
            reportStep("The browser could not be closed.", "WARN");
        }
    }
    /**
     * This method will click the element using id as locator
     * @param id  The id (locator) of the element to be clicked
     * @author Rekha
     */
    public void clickById(String id,String fieldvalue) {
        try{
            driver.findElement(By.id(id)).click();
            reportStep("The element with id: "+fieldvalue+" is clicked.", "PASS");
        } catch (Exception e) {
            reportStep("The element with id: "+fieldvalue+" could not be clicked.", "FAIL");
        }
    }
    /**
     * This method will click the element using id as locator
     * @param id  The id (locator) of the element to be clicked
     * @author Rekha
     */
    public void clickByClassName(String classVal,String fieldvalue) {
        try{
            driver.findElement(By.className(classVal)).click();
            reportStep("The element with class Name: "+fieldvalue+" is clicked.", "PASS");
        } catch (Exception e) {
            reportStep("The element with class Name: "+fieldvalue+" could not be clicked.", "FAIL");
        }
    }
    /**
     * This method will click the element using name as locator
     * @param name  The name (locator) of the element to be clicked
     * @author Rekha
     */
    public void clickByName(String name,String fieldvalue) {
        try{
            driver.findElement(By.name(name)).click();
            reportStep("The element with name: "+fieldvalue+" is clicked.", "PASS");
        } catch (Exception e) {
            reportStep("The element with name: "+fieldvalue+" could not be clicked.", "FAIL");
        }
    }
    /**
     * This method will click the element using link name as locator
     * @param name  The link name (locator) of the element to be clicked
     * @author Rekha
     */
    public void clickByLink(String name,String fieldvalue) {
        try{
            driver.findElement(By.linkText(name)).click();
            reportStep("The element with link name: "+fieldvalue+" is clicked.", "PASS");
        } catch (Exception e) {
            reportStep("The element with link name: "+fieldvalue+" could not be clicked.", "FAIL");
        }
    }
    /**
     * This method will click the element using xpath as locator
     * @param xpathVal  The xpath (locator) of the element to be clicked
     * @author Rekha
     */
    public void clickByXpath(String xpathVal,String fieldvalue) {
        try{
            driver.findElement(By.xpath(xpathVal)).click();
            reportStep("The element : "+fieldvalue+" is clicked.", "PASS");
        } catch (Exception e) {
            reportStep("The element with xpath: "+fieldvalue+" could not be clicked.", "FAIL");
        }
    }
    public void clickByLinkNoSnap(String name) {
        try{
            driver.findElement(By.linkText(name)).click();
            reportStep("The element with link name: "+name+" is clicked.", "PASS",false);
        } catch (Exception e) {
            reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
        }
    }
    public void clickByXpathNoSnap(String xpathVal) {
        try{
            driver.findElement(By.xpath(xpathVal)).click();
            reportStep("The element : "+xpathVal+" is clicked.", "PASS",false);
        } catch (Exception e) {
            reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
        }        
    }
    /**
     * This method will mouse over on the element using xpath as locator
     * @param xpathVal  The xpath (locator) of the element to be moused over
     * @author Rekha
     */
    public void mouseOverByXpath(String xpathVal) {
        try{
            new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
            reportStep("The mouse over by xpath : "+xpathVal+" is performed.", "PASS");
        } catch (Exception e) {
            reportStep("The mouse over by xpath : "+xpathVal+" could not be performed.", "FAIL");
        }
    }
    /**
     * This method will mouse over on the element using link name as locator
     * @param xpathVal  The link name (locator) of the element to be moused over
     * @author Rekha
     */
    public void mouseOverByLinkText(String linkName) {
        try{
            new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
            reportStep("The mouse over by link : "+linkName+" is performed.", "PASS");
        } catch (Exception e) {
            reportStep("The mouse over by link : "+linkName+" could not be performed.", "FAIL");
        }
    }
    /**
     * This method will click on the element and hold using link name as locator
     * @param xpathVal  The link name (locator) of the element to be clicked and hold
     * @author Rekha
     */
    public void ClickandHold(String xpathVal) {
        try{
            new Actions(driver).clickAndHold(driver.findElement(By.xpath(xpathVal))).build().perform();
            System.out.println("SUCCESSFULL");
            reportStep("The mouse over by link : "+xpathVal+" is performed.", "PASS");
        } catch (Exception e) {
            reportStep("The mouse over by link : "+xpathVal+" could not be performed.", "FAIL");
        }
    }
    /**
     * This method will return the text of the element using xpath as locator
     * @param xpathVal  The xpath (locator) of the element
     * @author Rekha
     */
    public String getTextByXpath(String xpathVal){
        String bReturn = "";
        try{
            return driver.findElement(By.xpath(xpathVal)).getText();
        } catch (Exception e) {
            reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
        }
        return bReturn; 
    }
    /**
     * This method will return the text of the element using id as locator
     * @param xpathVal  The id (locator) of the element
     * @author Rekha
     */
    public String getTextById(String idVal) {
        String bReturn = "";
        try{
            return driver.findElementById(idVal).getText();
        } catch (Exception e) {
            reportStep("The element with id: "+idVal+" could not be found.", "FAIL");
        }
        return bReturn; 
    }
    /**
     * This method will select the drop down value using id as locator
     * @param id The id (locator) of the drop down element
     * @param value The value to be selected (visibletext) from the dropdown 
     * @author Rekha
     */
    public void selectVisibileTextById(String id, String value) {
        try{
            new Select(driver.findElement(By.id(id))).selectByVisibleText(value);;
            reportStep("The element with id: "+id+" is selected with value :"+value, "PASS");
        } catch (Exception e) {
            reportStep("The value: "+value+" could not be selected.", "FAIL");
        }
    }

    public void selectVisibileTextByXPath(String xpath, String value) {
        try{
            new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(value);;
            reportStep("The element with xpath: "+xpath+" is selected with value :"+value, "PASS");
        } catch (Exception e) {
            reportStep("The value: "+value+" could not be selected.", "FAIL");
        }
    }
    public void selectIndexById(String id, int value) {
        try{
            new Select(driver.findElement(By.id(id))).selectByIndex(value);
            reportStep("The element with id: "+id+" is selected with index :"+value, "PASS");
        } catch (Exception e) {
            reportStep("The index: "+value+" could not be selected.", "FAIL");
        }
    }
    /**
     * This method will switch to the parent Window
     * @author Rekha
     */
    public void switchToParentWindow() {
        try {
            Set<String> winHandles = driver.getWindowHandles();
            for (String wHandle : winHandles) {
                driver.switchTo().window(wHandle);
                break;
            }
        } catch (Exception e) {
            reportStep("The window could not be switched to the first window.", "FAIL");
        }
    }
    /**
     * This method will move the control to the last window
     * @author Rekha
     */
    public void switchToLastWindow() {
        try {
            Set<String> winHandles = driver.getWindowHandles();
            for (String wHandle : winHandles) {
                driver.switchTo().window(wHandle);
            }
        } catch (Exception e) {
            reportStep("The window could not be switched to the last window.", "FAIL");
        }
    }

    /**
     * This method will accept the alert opened
     * @author Rekha
     */
    public void acceptAlert() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            reportStep("The alert could not be found.", "FAIL");
        } catch (Exception e) {
            reportStep("The alert could not be accepted.", "FAIL");
        }
    }
    /**
     * This method will return the text of the alert
     * @author Rekha
     */
    public String getAlertText() {        
        String text = null;
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            reportStep("The alert could not be found.", "FAIL");
        } catch (Exception e) {
            reportStep("The alert could not be accepted.", "FAIL");
        }
        return text;
    }
    /**
     * This method will dismiss the alert opened
     * @author Rekha
     */
    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            reportStep("The alert could not be found.", "FAIL");
        } catch (Exception e) {
            reportStep("The alert could not be accepted.", "FAIL");
        }
    }

    /**
     * This method will take snapshot of the browser
     * @author Rekha
     */
    public long takeSnap(){
        long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
        try {
        
            FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./images/"+number+".jpg"));
        } catch (WebDriverException e) {
            reportStep("The browser has been closed.", "FAIL");
        } catch (IOException e) {
            reportStep("The snapshot could not be taken", "WARN");
        }
        return number;
    }
    public static String getdata(String rowvalue,String columnvalue) throws IOException
    {
        String Runmangerpath=prop.getProperty("Runmangername");
        String Workspace = prop.getProperty("Workspace");
        FileInputStream fis = new FileInputStream(new File("./"+Runmangerpath+".xls"));
        HSSFWorkbook workbook = new  HSSFWorkbook(fis);
        HSSFSheet sheet = workbook.getSheet("TestConfigurations");
        HSSFRow row = sheet.getRow(0);
        int col_num = -1;
        for(int i=0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals(columnvalue))
                col_num = i;
        }
        Sheet Sheet1=workbook.getSheet("TestConfigurations");
        String rowValue = rowvalue;
        Integer i = null;
        for( i=1;i<=Sheet1.getLastRowNum();i++)
        {
            if (rowValue.equals(Sheet1.getRow(i).getCell(0).getStringCellValue()))
            {
            //    System.out.println(i);
                break;
            }
        }
        row = sheet.getRow(i);
        HSSFCell cell = row.getCell(col_num);
        String value = cell.getStringCellValue();
    //    System.out.println("Value of the Excel Cell is - "+ value);
        return value;
    }
    
    public static void closeWelcomePopup() throws InterruptedException {

        try {
            Thread.sleep(5000);
            WebElement welcome = driver.findElement(By.xpath("//area[@alt='close']"));
            welcome.click();
            reportStep("Welcome popup closed successfully", "Pass", true);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.println("Unable to find welcome popup");
        }
    
    }
    
    public static void closeFeedbackPopup() throws InterruptedException {

        try {
            Thread.sleep(5000);
            WebElement welcome = driver.findElement(By.xpath("//area[@alt='close']"));
            welcome.click();
            reportStep("Feed Back popup closed successfully", "Pass", true);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.println("Unable to find Feed back popup");
        }
    
    }
    public List<org.openqa.selenium.WebElement> findElementsByXpath(String xpathVal) {
        try{
            driver.findElements(By.xpath(xpathVal));
            reportStep("Elements Found by  "+xpathVal , "PASS");
        } catch (Exception e) {
            reportStep("Could not Find Elements by " +e, "FAIL");
        }
        return null;
    }
    public WebElement findElementByXpath(String xpathVal) {
        try{
            driver.findElement(By.xpath(xpathVal));
            reportStep("Elements Found by  "+xpathVal , "PASS");
        } catch (Exception e) {
            reportStep("Could not Find Elements by " +e, "FAIL");
        }
        return WebElement;
    }
    public void scrollElement(String xpathVal) {
        try{
            WebElement element=driver.findElement(By.xpath(xpathVal));
            JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(True);",element);
            
        }
            catch (Exception e) {}
        }
    public void waitElementVisisble(String xpathVal,int timeOutInSeconds) {
        try{
            WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
            WebElement Element=driver.findElement(By.xpath(xpathVal));
            wait.until(ExpectedConditions.visibilityOf(Element));
            
        }
            catch (Exception e) {}
        }
    public void switchToFrame(String xpathVal) {
        try{
            WebElement el=driver.findElement(By.xpath(xpathVal));
            driver.switchTo().frame(el);
            System.out.println("Switched to frame");
            
        }
            catch (Exception e) {}
        }
        
        
    public WebElement WebElement(String xpathVal) {
        
        WebElement element=driver.findElement(By.xpath(xpathVal));
        return element;
    
}
    
    public void clickByXpathjs(String xpathVal,String fieldvalue) {
        try{
            WebElement element = driver.findElement(By.xpath(xpathVal));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
            
            reportStep("The element : "+fieldvalue+" is clicked.", "PASS");
        } catch (Exception e) {
            reportStep("The element with xpath: "+fieldvalue+" could not be clicked.", "FAIL");
        }
    } 
    
    public void closeNotificationPopup() throws InterruptedException {

        try {
            sleepTime(10);
            //driver.switchTo().defaultContent();
            if(driver.findElement(By.xpath("//button[contains(text(),'Accept & Close')]")).isDisplayed()) {
            WebElement welcome = driver.findElement(By.xpath("//button[contains(text(),'Accept & Close')]"));
            //js.executeScript("arguments[0].click();", welcome);
            welcome.click();
            System.out.println("Notification popup closed successfully");
            }
            else if(driver.findElement(By.xpath("(//button[text()='Accept & Close'])[2]")).isDisplayed()) {
                WebElement welcome = driver.findElement(By.xpath("(//button[text()='Accept & Close'])[2]"));
                //js.executeScript("arguments[0].click();", welcome);
                welcome.click();
                
                System.out.println("Notification popup closed successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to find Notification popup");
        }
        
    }
    public void  offerClose() throws InterruptedException
    {
        Thread.sleep(5000);
        try {
            if(driver.findElement(By.xpath("//iframe[@id='hlFrame']")) != null)
            {
                driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='hlFrame']")));
                WebElement offerCloseButton = driver.findElementByXPath((objValue.getProperty("xpath.offerclose")));
                offerCloseButton.click();
                sleepTime(10);
                
                //clickByXpath(objValue.getProperty("xpath.offerclose"),"Offerclose");
                driver.switchTo().defaultContent();
            }
            else
            {
                System.out.println("Popup not appear");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Popup not appear");
        }
    
}
    public void zipValueEnter() throws InterruptedException {
        
        try {
            //WebElement zipField = driver.findElement(By.xpath("//input[@id='zipModalInput']"));
            WebElement zipFieldVal = driver.findElement(By.xpath(objValue.getProperty("Xpath.ZipField")));
            zipFieldVal.sendKeys("92614");
            //enterByXpath(objValue.getProperty("Xpath.ZipField"), "92614", "Zip field");
            sleepTime(30);
//            closeWelcomePopup();
//            closeNotificationPopup();
            WebElement zipConfirm = driver.findElement(By.xpath(objValue.getProperty("Xpath.confirmButton")));
            zipConfirm.click();
            //clickByXpath(objValue.getProperty("Xpath.confirmButton"), "Confirm");
            sleepTime(30);
            reportStep("Zip code entered successfully", "Pass", true);
            System.out.println("Zip code entered successfully");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Zip popup not appear");
        }
    }
    public void scrollElementByPixelUp(String xpathVal)
    {
        try{
            driver.findElement(By.xpath(xpathVal));
            JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(500,0)");
            
        }
            catch (Exception e) {}
            
    }
    
    public void clickByJavaScript(String xpathVal,String fieldvalue) {
        try{
            WebElement element=driver.findElement(By.xpath(xpathVal));
            JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
            reportStep("The element : "+fieldvalue+" is clicked.", "PASS");
        } catch (Exception e) {
            reportStep("The element with xpath: "+fieldvalue+" could not be clicked."+e, "FAIL");
        }
    }
    
    public boolean isDisplayed(String xpath){
        boolean bReturn = false;
        try {
            driver.findElementByXPath(xpath).isDisplayed();
            //reportStep("Content is displayed properly "+sText, "PASS", true);
            bReturn = true;
        }            
        catch (Exception e) {
            reportStep("Unknown exception occured while verifying the title", "FAIL");
        }
        return bReturn;
    }
    
    public void scrollElementByPixel(String xpathVal)
    {
        try{
            driver.findElement(By.xpath(xpathVal));
            JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");
        }
        catch (Exception e) {}
    }
    
    public void switchToFrameByXpath(String xpathVal) {
        try{
            WebElement Element=driver.findElement(By.xpath(xpathVal));
            driver.switchTo().frame(Element);
            System.out.println("Switched to frame");

        }
        catch (Exception e) {System.out.println("not able to switch to frame");}
    }
    
    public void husaLivePopupClose()
    {    
        try {
            //driver.switchTo().defaultContent();
            
        
            if(driver.findElement(By.xpath("//iframe[contains(@id,'wframe')]")).isDisplayed())
            {
                
                sleepTime(10);
                //driver.switchTo().frame("hlFrame");
                WebElement element = driver.findElement(By.xpath("//iframe[contains(@id,'wframe')]"));
                driver.switchTo().frame(element);
            sleepTime(3); 
                WebElement welcome = driver.findElement(By.xpath(".//div[@id='app__close']"));
                //js.executeScript("arguments[0].click();", welcome);
                welcome.click();
                
                System.out.println("Live Popup closed successfully");
                
        
                sleepTime(5);
                
            }
            
            /*else if(driver.findElement(By.xpath("//div[@class='otm-session']//app-header/div/div[2]")).isDisplayed())
            {
                WebElement welcome = driver.findElement(By.xpath("//div[@class='otm-session']//app-header/div/div[2]"));
                //js.executeScript("arguments[0].click();", welcome);
                welcome.click();
                sleepTime(5);
                System.out.println("Live Popup closed successfully");
                
            }*/

            else
            {
                System.out.println("HUSA Live Popup is not available");
            }
            
            //driver.switchTo().defaultContent();
        } 
        catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("HUSA Live Popup is not available");
            //e.printStackTrace();
        }
    }
//      public void handleMobileBrowserPopup() throws InterruptedException {
//    	try {
//    	System.out.println(driver.getContext());
//   		 String webContext = driver.getContext();
//   		    Set<String> contexts = driver.getContextHandles();
//   		    for (String handle: contexts){
//   		    	System.out.println(handle);
//   		        if (handle.contains("NATIVE_APP")){
//   		        	driver.context(handle);
//   		        	driver.findElement(By.xpath("//*[@resource-id=\"com.android.chrome:id/positive_button\"]")).click();
//   		            break;
//   		        }
//   		    }
//   	  
//   		    driver.context(webContext); 
//   		
//    }catch(Exception e)
//    	{
//    	System.out.println("Unable to handled the pop up");
//    	e.printStackTrace();
//    	} 
//      }
      
	

public void allowAppPermission() {
	try {
    while(driver.findElement(By.id("android:id/button1")) != null)
    { driver.findElement(By.id("android:id/button1")).click();
    }
	}catch(Exception e)
    {
		System.out.println("Unable to handled the pop up");
    	e.printStackTrace();
    }
}
}