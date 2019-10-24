package com.confluence.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.confluence.qa.base.TestBase;
import com.confluence.qa.pages.DashboardPage;
import com.confluence.qa.pages.ExistingPage;
import com.confluence.qa.pages.HomePage;
import com.confluence.qa.pages.LoginPage;

import junit.framework.Assert;

public class ExistingPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homepage;
	DashboardPage dashboardPage;
	ExistingPage existingPage;
	ExistingPage existingPagenew;
	
	public ExistingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		homepage.waitForHomePageToLoad();
		dashboardPage = homepage.gotoDashBoard();
		dashboardPage.waitForDashboadPageToLoad();
		existingPage = dashboardPage.openExistingPage();
	}
	
	@Test
	public void changePageRestrictionFromMenuTest() {
		existingPage = existingPage.changeRestrictionFromMenu();
		existingPage.waitForExistingPage();
		Assert.assertTrue(existingPage.hasEditLink());
	}
	
	@Test
	public void changePageRestrictionFromHeaderButtonTest() {
		existingPage = existingPage.changeRestrictionHeaderButton();
		existingPage.waitForExistingPage();
		Assert.assertTrue(existingPage.hasEditLink());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
