package com.confluence.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.confluence.qa.util.TestUtil;
import com.confluence.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties properties;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public enum SELECT_BY {		
		CLASS_NAME, ID, LINK_TEXT, NAME, PARTIAL_LINK_TEXT, TAG_NAME, XPATH, CSS
	}
	
	public By getSelectBy(SELECT_BY selectBy, String value) {
	        By by = null;
	        switch (selectBy) {
	            case CLASS_NAME:
	                by = By.className(value);
	                break;
	            case ID:
	                by = By.id(value);
	                break;
	            case LINK_TEXT:
	                by = By.linkText(value);
	                break;
	            case NAME:
	                by = By.name(value);
	                break;
	            case PARTIAL_LINK_TEXT:
	                by = By.partialLinkText(value);
	                break;
	            case TAG_NAME:
	                by = By.tagName(value);
	                break;
	            case XPATH:
	                by = By.xpath(value);
	                break;
	            case CSS:
	                by = By.cssSelector(value);
	                break;
	            default:
	                by = By.id(value);
	                break;
	        }
	        return by;
	    }
	
	
	public TestBase() {
		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream("/Users/gours/eclipse-workspace/ConfluenceTest/src/main/java/com/confluence/qa/config/config.properties");
			properties.load(ip);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {		
		String browserName = properties.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(properties.getProperty("url"));
	}
	
	public void waitOnCondition(String elementName, SELECT_BY selectBy) {
        try {
        	WebDriverWait wait = new WebDriverWait(driver, 30);
        	wait.until(ExpectedConditions.visibilityOfElementLocated(getSelectBy(selectBy, elementName)));
        } catch (TimeoutException e) {
            String message = "Could not find the element with a " + selectBy.toString() + " of " + elementName;
            System.out.println(message);
        }
    }
	
}
