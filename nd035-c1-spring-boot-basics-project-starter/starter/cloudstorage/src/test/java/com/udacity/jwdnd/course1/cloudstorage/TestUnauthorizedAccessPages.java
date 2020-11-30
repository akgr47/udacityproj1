package com.udacity.jwdnd.course1.cloudstorage;

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
class TestUnauthorizedAccessPages {
	@LocalServerPort
	private Integer port;
	private static WebDriver webDriver;
	private UnauthorizedAccessPage unauthorizedAccessPage;
	
	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		webDriver = new ChromeDriver();
	}
	
	@AfterAll
	public static void afterAll() {
		webDriver.quit();
	}
	
	@BeforeEach
	public void beforeEach() {
		unauthorizedAccessPage = new UnauthorizedAccessPage(webDriver);
	}
	
	@Test
	public void testAccessLoginPage() {
		webDriver.get("http://localhost:" + port + "/login");
		String loginTitle = "Login";
		Assertions.assertEquals(loginTitle, unauthorizedAccessPage.getTitle());
	}
	
	@Test
	public void testAccessSignupPage() {
		webDriver.get("http://localhost:" + port + "/signup");
		String signupTitle = "Sign Up";
		Assertions.assertEquals(signupTitle, unauthorizedAccessPage.getTitle());
	}
	
	@Test
	public void testAccessHomePage() {
		webDriver.get("http://localhost:" + port + "/signup");
		String homeTitle = "Home";
		Assertions.assertNotEquals(homeTitle, unauthorizedAccessPage.getTitle());
	}
}
