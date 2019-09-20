package com.saucedemo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.HomePage;
import com.saucedemo.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;

	public LoginPageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void lginPageTitleTest() {

		String title = loginpage.validateLoginPage();
		Assert.assertEquals(title, "Swag Labs");
	}

	@Test(priority = 2)
	public void loginTest() {
		homePage = loginpage.login(prop.getProperty("userID"), prop.getProperty("passWord"));

	}

	@AfterMethod
	public void tearDown() {
		log.info("Browser Closing");
		driver.quit();

	}

}
