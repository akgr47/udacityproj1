package com.udacity.jwdnd.course1.cloudstorage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import io.github.bonigarcia.wdm.WebDriverManager;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestSignupLoginAccessHomePage {
	@LocalServerPort
	private Integer port;
	
	private static WebDriver webDriver;
	
	private SignupPage signupPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		webDriver = new ChromeDriver();
	}
	
	@AfterAll
	public static void afterAll() {
		webDriver.quit();
	}
	
	@BeforeEach() 
	public void beforeEach() {
		signupPage = new SignupPage(webDriver);
		loginPage = new LoginPage(webDriver);
		homePage = new HomePage(webDriver);
	}
	
	@Test
	void testRegistrationAndSignInProcess() throws InterruptedException {
		String localhost = "http:localhost:";
		String signupTitle = "Sign Up";
		
		webDriver.get(localhost + port + "/signup");
		Assertions.assertEquals(signupTitle, webDriver.getTitle());
		
		signupPage.signUp();
		signupPage.goLoginPage();
		Thread.sleep(2000);
		
		String loginTitle = "Login";
		Assertions.assertEquals(loginTitle, webDriver.getTitle());
		loginPage.login();
		Thread.sleep(2000);
		
		String homeTitle = "Home";
		Assertions.assertEquals(homeTitle, webDriver.getTitle());
		homePage.logout();
		Thread.sleep(2000);
		
		webDriver.get(localhost + port + "/home");
		Thread.sleep(2000);
		Assertions.assertNotEquals(homeTitle, webDriver.getTitle());
	}

}
