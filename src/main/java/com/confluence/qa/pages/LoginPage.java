package com.confluence.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.confluence.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - Object Repository
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="login-submit")
	WebElement submit;
	
	@FindBy(id="password")
	WebElement password;
	
	//Innitializing Page Objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String usr, String pssd) {
		username.sendKeys(usr);
		submit.click();
		password.sendKeys(pssd);
		submit.click();
		return new HomePage();
	}
	
	
	
	
	
}
