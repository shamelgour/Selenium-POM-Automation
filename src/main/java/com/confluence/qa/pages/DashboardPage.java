package com.confluence.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.confluence.qa.base.TestBase;

public class DashboardPage extends TestBase{
	
	@FindBy(id="title-text")
	WebElement titleText;
	
	@FindBy(id="main-content")
	WebElement mainContent;
	
	@FindBy(xpath="//div[contains(@class,\"ConfigurableSpaceSidebar\")]/div[3]/div[2]/div[1]/div[1]/div/a")
	WebElement linkToExistingPage;
	
	public DashboardPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void waitForDashboadPageToLoad() {
		waitOnCondition("title-text",SELECT_BY.ID);
	}
	public String getActivePageTitle() {
		return titleText.getText();
	}
	
//	public void pageExistsInPageList() {
//		
//	}
	
	public ExistingPage openExistingPage() {
		linkToExistingPage.click();
		return new ExistingPage();
	}
	
}