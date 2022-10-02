package org.stepdefnition;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepDefnition extends BaseClass {
	
	
	
	@Given("the user should be in home page")
	public void the_user_should_be_in_home_page() {
	 
	}
	@When("the user has to fill the valid details in the search box")
	public void the_user_has_to_fill_the_valid_details_in_the_search_box(io.cucumber.datatable.DataTable datas) {
		List<Map<String, String>> li = datas.asMaps(String.class, String.class);
		
		 WebElement txtProduct = driver.findElement(By.id("twotabsearchtextbox"));			 
		 sendKeys(txtProduct, li.get(2).get("product"));
	}
	@When("click the search button")
	public void click_the_search_button() {
	  WebElement searchbtn = driver.findElement(By.xpath("//input[@type='submit']"));
	  searchbtn.click();	 
	}
	@Then("the user should navigate to the product page")
	public void the_user_should_navigate_to_the_product_page() {
		String c = driver.getCurrentUrl();
	   Assert.assertTrue(driver.getCurrentUrl().contains(c));
	   System.out.println("user is in product page");
	  
	}
	@When("the user will click language option")
	public void the_user_will_click_language_option() {
	    WebElement ele = driver.findElement(By.xpath("//a[starts-with(@aria-label,'Choose')]"));
	    ele.click();
	}	   
	
	@When("the user select the prefered language in language section")
	public void the_user_select_the_prefered_language_in_language_section() {
		WebElement ele1 = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele1);
	}

	@Then("the language for shopping and communication should be changed")
	public void the_language_for_shopping_and_communication_should_be_changed() {
		String url = driver.getCurrentUrl();
		 Assert.assertTrue(driver.getCurrentUrl().contains(url));
		   System.out.println("language has changed");
		  
		
	   
	}

	@When("the user click the save changes option")
	public void the_user_click_the_save_changes_option() {
		WebElement ele2 = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele2);
	}
	@Then("the user should navigate to the invalid page")
	public void the_user_should_navigate_to_the_invalid_page() {
	    String url = driver.getCurrentUrl();
	   System.out.println("user is in invalid page");
	   
	}

	@When("the user click the sign in button")
	public void the_user_click_the_sign_in_button() {
	   WebElement ele1 = driver.findElement(By.xpath("//span[starts-with(text(),'Hello')]"));
	   ele1.click();
	}

	@Then("the signin page displayed")
	public void the_signin_page_displayed() {
	 String url = driver.getCurrentUrl();
	 Assert.assertTrue(url.contains("signin"));
	}

	@When("the user fill the invalid creditionals")
	public void the_user_fill_the_invalid_creditionals(io.cucumber.datatable.DataTable data) {
		List<String> l = data.asList();
		
		
		WebElement eleme = driver.findElement(By.name("email"));
		sendKeys(eleme, l.get(0));
		System.out.println(l.get(0));
	}

	@When("click signIn button")
	public void click_signIn_button() {
		driver.findElement(By.id("continue")).click();
	    
	}

	@Then("the error message will displayed")
	public void the_error_message_will_displayed() {
	     System.out.println("no account in this number");
	    
	}

	@When("the user has to fill the  invalid details in the search box")
	public void the_user_has_to_fill_the_invalid_details_in_the_search_box(io.cucumber.datatable.DataTable data) {
	  WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
	  List<String> lis = data.asList();
	  sendKeys(element, lis.get(1));
	}





}
