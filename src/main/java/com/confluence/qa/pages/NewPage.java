package com.confluence.qa.pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.confluence.qa.base.TestBase;

public class NewPage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"content-title\"]")
	WebElement pageTitle;

	@FindBy(id="rte-button-publish")
	WebElement publishButton;
	
	@FindBy(id="rte-button-cancel")
	WebElement cancelButton;
	
	@FindBy(id="rte-toolbar")
	WebElement toolBar;
	
	@FindBy(id="savebar-container")
	WebElement saveBar;
	
	@FindBy(xpath="//body[@id=\"tinymce\"]/p")
	WebElement pageContent;

	public NewPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateToolBarisPresent() {
		return toolBar.isDisplayed();
		
	}
	
	public void waitForNewPageToLoad() {
		waitOnCondition("rte-button-publish", SELECT_BY.ID);
	}
	
	public void waitTillReadyToWrite() {
		waitOnCondition("//div[contains(@class,\"status-indicator-message\") and contains(text(),\"Ready to go\")]", SELECT_BY.XPATH);
	}
	
	public void waitTillReadyToSave() {
		waitOnCondition("//div[contains(@class,\"status-indicator-message\") and contains(text(),\"Changes saved\")]", SELECT_BY.XPATH);
	}
	
	public boolean validateSaveBarisPresent() {
		return saveBar.isDisplayed();
	}
	
	public DashboardPage createNewPage(String titleText) {
		waitTillReadyToWrite();
		pageTitle.sendKeys(titleText);
		driver.switchTo().frame(0);
		Actions actions = new Actions(driver);
		actions.moveToElement(pageContent);
		actions.click();
		actions.sendKeys("Confluence is where you create, organise and discuss work with your team. ... Unlike document and file-sharing tools, Confluence is open and accessible.");
		actions.build().perform();
		driver.switchTo().parentFrame();
		publishButton.click();
		return new DashboardPage();
	}
	
	public HomePage createDraft(String titleText) {
		waitTillReadyToWrite();
		pageTitle.sendKeys(titleText);
		waitTillReadyToSave();
		cancelButton.click();
		return new HomePage();
	}
	
	public int generateRandomNumber() {
		Random rand = new Random(); 
		int randomNumber = rand.nextInt(1000); 
		return randomNumber;
	}
	
	
}
