package com.saucedemo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.HomePage;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.SauceLabsBackpackPage;
import com.saucedemo.qa.pages.YourCartPage;
import com.saucedemo.qa.util.TestUtil;

public class SauceLabsBackpackPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	YourCartPage cartBadge;
	SauceLabsBackpackPage sauceBackPack;
	TestUtil testUtil;

	public SauceLabsBackpackPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("userID"), prop.getProperty("passWord"));
		sauceBackPack = new SauceLabsBackpackPage();
		testUtil = new TestUtil();
		sauceBackPack = homePage.userProductBackPack();

	}

	@Test(priority = 1)
	public void verifyHeaderLabel() {
		String title = sauceBackPack.verifyBackPackHeaderLabel();
		Assert.assertEquals(title, "Sauce Labs Backpack");

	}

	@Test(priority = 2)
	public void clickOnAddtoCartTest() {
		sauceBackPack.clickOnAddtoCart();

	}

	@Test(priority = 3)
	public void clickOnShoppingCartBadgeTest() {

		cartBadge = sauceBackPack.clickOnShoppingCartBadge();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
