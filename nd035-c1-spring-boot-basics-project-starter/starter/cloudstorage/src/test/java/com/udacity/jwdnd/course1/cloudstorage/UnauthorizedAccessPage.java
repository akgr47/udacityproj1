package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UnauthorizedAccessPage {
	private WebDriver webDriver;
	
	public UnauthorizedAccessPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(this.webDriver, this);
	}

	public String getTitle() {
		return webDriver.getTitle();
	}
}
