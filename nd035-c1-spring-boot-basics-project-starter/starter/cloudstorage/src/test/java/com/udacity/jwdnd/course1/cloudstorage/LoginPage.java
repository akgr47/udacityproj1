package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id = "inputUsername")
	WebElement inputUsername;
	
	@FindBy(id = "inputPassword")
	WebElement inputPassword;
	
	@FindBy(id = "btn-login")
	WebElement buttonLogin;
	
	public LoginPage(final WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
	
	public void login() {
		String username = "username";
		String password = "secret";
		
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		
		buttonLogin.click();
	}
}
