package com.confluence.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.confluence.qa.base.TestBase;

public class ExistingPage extends TestBase{
	
	@FindBy(id="action-menu-link")
	WebElement menuLink;
	
	@FindBy(className="action-page-permissions")
	WebElement restrictionsLink;
	
	@FindBy(className="restrictions-dialog-option")
	WebElement changeRestrictionsMenu;
	
	@FindBy(xpath="//*[@id='select2-drop']/ul/li[1]/div/div/span[1]")
	WebElement noRestrictions;
	
	@FindBy(id="page-restrictions-dialog-save-button")
	WebElement clickApply;
	
	@FindBy(id="title-text")
	WebElement ExistingPageTitle;
	
	@FindBy(id="editPageLink")
	WebElement EditLink;
	
	@FindBy(id="content-metadata-page-restrictions")
	WebElement changeRestrictionHeader;
	
	public ExistingPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return ExistingPageTitle.getText();
	}
	
	public void waitForExistingPage() {
		waitOnCondition("action-menu-link",SELECT_BY.ID);
	}
	
	public boolean hasEditLink() {
		return EditLink.isDisplayed();
	}
	
	public ExistingPage changeRestrictionFromMenu() {
		menuLink.click();
		restrictionsLink.click();
		driver.switchTo().activeElement();
		changeRestrictionsMenu.click();
		noRestrictions.click();
		clickApply.click();
		return new ExistingPage();
	}
	
	public ExistingPage changeRestrictionHeaderButton(){
		changeRestrictionHeader.click();
		driver.switchTo().activeElement();
		changeRestrictionsMenu.click();
		noRestrictions.click();
		clickApply.click();
		return new ExistingPage();
	}
}
