package com.confluence.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.confluence.qa.base.TestBase;
import com.confluence.qa.pages.DashboardPage;
import com.confluence.qa.pages.HomePage;
import com.confluence.qa.pages.LoginPage;
import com.confluence.qa.pages.NewPage;

import junit.framework.Assert;

public class NewPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homepage;
	NewPage newPage;
	DashboardPage dashboardPage;
	
	private static String PageTitle =  "Confluence test page title ";
	
	public NewPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		homepage.waitForHomePageToLoad();
		newPage = homepage.NavigateToNewPage();
		newPage.waitForNewPageToLoad();
	}
	
	@Test
	public void validateToolBarPresentTest() {
		Assert.assertTrue(newPage.validateToolBarisPresent());
	}
	
	@Test
	public void validateSaveBarPresentTest() {
		Assert.assertTrue(newPage.validateSaveBarisPresent());
	}
	
	@Test
	public void createNewPageTest() {
		int randomNumber = newPage.generateRandomNumber();
		dashboardPage = newPage.createNewPage(PageTitle+randomNumber);
		dashboardPage.waitForDashboadPageToLoad();
		String activePageTitle = dashboardPage.getActivePageTitle();
		Assert.assertEquals(PageTitle+randomNumber,activePageTitle);
	}
	
	@Test
	public void saveDraftVersion() {
		int randomNumber = newPage.generateRandomNumber();
		homepage = newPage.createDraft(PageTitle+randomNumber);
		homepage.waitForHomePageToLoad();
		String draftTitle = homepage.validateFirstItem();
		Assert.assertEquals(PageTitle+randomNumber,draftTitle);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
