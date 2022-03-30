package com.hyundai.stepdefinitions;




import java.util.Set;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//Reg exp
//1. \"([^\"]*)\"
//2. \"(.*)\"
public class HomePage {
	private static  AndroidDriver<MobileElement> driver;
	@Given("^Launch the Hyundai USA url$")
	public void launch_the_hyundai_usa_site() {
		driver.get("http://hyundaiusa.com/");
	    System.out.println("Launching url");
	}

	@When("^close notification popUp if any$")
	public void close_notification_pop_up_if_any() throws InterruptedException {
			 driver.get("https://www.hyundaiusa.com/us/en");
			 Thread.sleep(2000);
			 System.out.println(driver.getContext());
			 Thread.sleep(2000);
			 String webContext = driver.getContext();
			    Set<String> contexts = driver.getContextHandles();
			    for (String handle: contexts){
			    	System.out.println(handle);
			        if (handle.contains("NATIVE_APP")){
			        	driver.context(handle);
			        	driver.findElement(By.id("android:id/button1")).click();
			            break;
			        }
			    }
		  
			    driver.context(webContext); 
			    driver.manage().deleteCookieNamed("Cookies accept and close");
				driver.findElement(By.xpath("/html/body/div[1]/div/button")).click(); 
		 }
	@Given("user enter the zip code")
	public void user_enter_the_zip_code() {
		driver.findElement(By.xpath("//*[@id=\"zipModalInput\"]")).sendKeys("92708");
     	driver.findElement(By.xpath("/html/body/div[3]/div/div/div/form/div[3]/button")).click();
	}

	@Given("click on the accept and close cookie")
	public void click_on_the_accept_and_close_cookie() {
	driver.findElement(By.xpath("/html/body/div[1]/div/button")).click();
	}
	
	@When("Click on {string} icon in global navigation")
	public void click_on_icon_in_global_navigation(String string) {
	    System.out.println("global navigation");
	}

	@When("Enter a search term in search field")
	public void enter_a_search_term_in_search_field() {
		System.out.println("global navigation");
	}

	@When("Click on Search CTA")
	public void click_on_search_cta() {
		System.out.println("global navigation");
	}

	@When("Click on following links and Observe")
	public void click_on_following_links_and_observe() {
		System.out.println("global navigation");
	}

	@Then("verify Hyundai Logo")
	public void verify_hyundai_logo() {
		System.out.println("global navigation");
	}


}

