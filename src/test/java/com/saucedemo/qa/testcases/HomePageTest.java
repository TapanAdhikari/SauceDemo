package com.saucedemo.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.HomePage;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.SauceLabsBackpackPage;

import junit.framework.Assert;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	SauceLabsBackpackPage sauceLabelBack;

	public HomePageTest() {
		super();

	}

	@BeforeMethod

	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("userID"), prop.getProperty("passWord"));
		sauceLabelBack = new SauceLabsBackpackPage();
	}

	@Test(priority = 1)
	public void verifyHomePageTest() {

		Assert.assertTrue("App-Logo is not matched", homePage.verifyAppLogo());
	}

	@Test(priority = 2)
	public void veriFyProductsLabelTest() {

		Assert.assertEquals(homePage.veriFyuserProductsLabel(), "Products");

	}

	@Test(priority = 3)
	public void veriFySauceLabsBackpackPage() {

		sauceLabelBack = homePage.userProductBackPack();

	}

	@AfterMethod()

	public void tearDown() {
		log.info("Closing Browser");
		driver.quit();

	}
}
