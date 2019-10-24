package com.confluence.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.confluence.qa.base.TestBase;

public class HomePage extends TestBase{

	//Page Factory - Object Repository
		@FindBy(id="create-page-button")
		WebElement NewPageButton;
		
		@FindBy(id="create-dialog")
		WebElement moveToDialog;
		
		@FindBy(xpath="//ol[@class=\"templates\"]/li[contains(@class,\"template\")]")
		WebElement blankPageTemplate;
		
		@FindBy(xpath="//button[contains(@class,\"create-dialog-create-button\")]")
		WebElement createPageButton;
		
		@FindBy(className="dialog-title")
		WebElement getTitleofdialog;
		
		@FindBy(xpath="//span[contains(@class,\"ItemParts__Content-\") and contains(text(),\"Confluence\")]")
		WebElement mySpaces;
		
		@FindBy(xpath="//p[contains(@class,\"ContentListItem_itemTitle\")]")
		WebElement firstItemName;
		
		//Innitializing Page Objects
		public HomePage(){
			PageFactory.initElements(driver, this);
		}
		public void waitForHomePageToLoad() {
			waitOnCondition("create-page-button", SELECT_BY.ID);
		}
		//Actions:
		public String validateHomePageTitle() {
			return driver.getTitle();
		}
		
		public void waitForPageCreationDialogToLoad() {
			waitOnCondition("dialog-components", SELECT_BY.CLASS_NAME);
		}
		public NewPage NavigateToNewPage() {
			NewPageButton.click();
			waitForPageCreationDialogToLoad();
			driver.switchTo().activeElement();
			blankPageTemplate.click();
			createPageButton.click();
			return new NewPage();
		}
		
		public DashboardPage gotoDashBoard() {
			mySpaces.click();
			return new DashboardPage();
		}
		
		public String validateFirstItem() {
			return firstItemName.getText();
		}
}
