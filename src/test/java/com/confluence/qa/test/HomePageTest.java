package com.confluence.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.confluence.qa.base.TestBase;
import com.confluence.qa.pages.HomePage;
import com.confluence.qa.pages.LoginPage;
import com.confluence.qa.pages.NewPage;

import junit.framework.Assert;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homepage;
	NewPage newPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		homepage.waitForHomePageToLoad();
	}
	
	@Test
	public void homePageTitleTest() {
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals("Dashboard - Confluence", title);
	}
	
//	@Test 
//	public void homePageNewPAgeCreationTest() {
//		newPage = homepage.NavigateToNewPage();
//	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
