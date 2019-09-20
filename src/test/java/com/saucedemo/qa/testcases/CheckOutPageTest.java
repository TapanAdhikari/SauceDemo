package com.saucedemo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.base.TestBase;
import com.saucedemo.qa.pages.CheckOutConfirmPage;
import com.saucedemo.qa.pages.CheckOutPage;
import com.saucedemo.qa.pages.HomePage;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.SauceLabsBackpackPage;
import com.saucedemo.qa.pages.YourCartPage;
import com.saucedemo.qa.util.TestUtil;

public class CheckOutPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	CheckOutPage checkoutPage;
	CheckOutConfirmPage checkoutconfirm;
	YourCartPage cartBadge;
	SauceLabsBackpackPage sauceBackPack;
	TestUtil testUtil;

	public CheckOutPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("userID"), prop.getProperty("passWord"));
		testUtil = new TestUtil();
		cartBadge = new YourCartPage();
		sauceBackPack = new SauceLabsBackpackPage();
		cartBadge = sauceBackPack.clickOnShoppingCartBadge();
		checkoutPage = cartBadge.clickOnCheckOutButton();

	}

	@Test(priority = 1)
	public void verifyTitleTextTest() {

		String title = checkoutPage.verifyTitletext();

		Assert.assertEquals(title, "Checkout: Your Information");

	}

	@Test(priority = 2)
	public void checkoutSubmitTest() {
		checkoutPage.checkoutSubmit(prop.getProperty("firstName"), prop.getProperty("lastName"),
				prop.getProperty("zipCode"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Closing Browser");
	}

}
