package com.confluence.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.confluence.qa.base.TestBase;
import com.confluence.qa.pages.HomePage;
import com.confluence.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals("Log in to continue - Log in with Atlassian account", title);
	}
	
//	@Test
//	public void loginTest() {
//		homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
//		
//	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
