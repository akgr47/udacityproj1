package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	@FindBy(id = "inputFirstName")
	private WebElement inputFirstName;
	
	@FindBy(id = "inputLastName")
	private WebElement inputLastName;
	
	@FindBy(id = "inputUsername")
	private WebElement inputUsername;
	
	@FindBy(id = "inputPassword")
	private WebElement inputPassword;
	
	@FindBy(id = "btn-signup")
	private WebElement buttonSignup;
	
	@FindBy(id = "login-link")
	private WebElement loginLink;
	
	public SignupPage(final WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
	}
	
	public void signUp() {
		String username = "username";
		String password = "secret";
		String firstName = "John";
		String lastName = "Dio";
		
		inputFirstName.sendKeys(firstName);
		inputLastName.sendKeys(lastName);
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		
		buttonSignup.click();
	}
	
	public void goLoginPage() {
		loginLink.click();
	}
}
