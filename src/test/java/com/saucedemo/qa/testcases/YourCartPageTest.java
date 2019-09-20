package com.saucedemo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.CheckOutPage;
import com.saucedemo.qa.pages.HomePage;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.SauceLabsBackpackPage;
import com.saucedemo.qa.pages.YourCartPage;
import com.saucedemo.qa.util.TestUtil;

public class YourCartPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	YourCartPage cartBadge;
	CheckOutPage checkoutPage;
	SauceLabsBackpackPage sauceBackPack;
	TestUtil testUtil;

	public YourCartPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("userID"), prop.getProperty("passWord"));
		testUtil = new TestUtil();
		sauceBackPack = new SauceLabsBackpackPage();
		cartBadge = sauceBackPack.clickOnShoppingCartBadge();

	}

	@Test(priority = 1)
	public void verifyHeaderTextl() {

		String getTitle = cartBadge.verifyYourCartTest();

		Assert.assertEquals(getTitle, "Your Cart");

	}

	@Test(priority = 2)
	public void clickOnCheckoutButtonTest() {

		checkoutPage = cartBadge.clickOnCheckOutButton();
		System.out.println("********Clicked on Checkout*************");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Closing Browser");
	}

}
