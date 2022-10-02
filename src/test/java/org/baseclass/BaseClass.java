package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;
//=========================BROWSER LAUNCH===========================	
	public static void browserLaunch(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Elangovan\\eclipse-workspace\\CucumberBDD\\src\\test\\resources\\chromedriver.exe");
		     driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Elangovan\\eclipse-workspace\\Seleniummm\\Driver\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Elangovan\\eclipse-workspace\\Seleniummm\\Library\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
	}
//=========================URL LAUNCH =========================================
	public static void urlLaunch(String url) {
		driver.get(url);

	}
//==========================SEND KEYS=============================================
	public static String sendKeys(WebElement element,String value) {
	element.sendKeys(value);
	return value;

	}
//============================CLICK==================================================    

    public static void click(WebElement element) {
		element.click();

	}
//=============================JAVA SCRIPT EXECUTOR=============================================
    public static void javaScript(String Action,WebElement element) {
    	if(Action.equalsIgnoreCase("scrolldown")) {
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true)", element);
    	}
    	else if(Action.equalsIgnoreCase("scrollup")) {
    		JavascriptExecutor js= (JavascriptExecutor)driver;
    		js.executeScript("arguments[0].scrollIntoView(false)", element);
    	}
    	else if(Action.equalsIgnoreCase("click")) {
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click()", element);
    	}
    	
    	}
      
     public static String javaScriptsk(WebElement element,String value) {
    	 JavascriptExecutor js= (JavascriptExecutor)driver;
     	js.executeScript("arguments[0].setAttribute('value','"+value+"')", element);
		return value;
     }
//==============================ROBOT CLASS================================================

   public static void keyboard(String event) throws AWTException {
	   Robot r = new Robot();
	if(event.equalsIgnoreCase("select")) {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		
	}
	else if(event.equalsIgnoreCase("clear")) {
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
	}
	else if(event.equalsIgnoreCase("down")) {
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	else if(event.equalsIgnoreCase("enter")) {
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
}

//=============================IMPLICITY WAIT============================================

 public static void implicityWait(int seconds) {
	driver.manage().timeouts().implicitlyWait(seconds,TimeUnit.SECONDS);

}
































}
