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
import com.saucedemo.qa.pages.OrderFinishPage;
import com.saucedemo.qa.pages.SauceLabsBackpackPage;
import com.saucedemo.qa.pages.YourCartPage;
import com.saucedemo.qa.util.TestUtil;

public class OrderFinishPageTest extends TestBase {

	public OrderFinishPageTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homePage;
	CheckOutPage checkoutPage;
	CheckOutConfirmPage checkoutconfirm;
	YourCartPage cartBadge;
	SauceLabsBackpackPage sauceBackPack;
	TestUtil testUtil;
	OrderFinishPage orderFinish;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("userID"), prop.getProperty("passWord"));
		testUtil = new TestUtil();
		cartBadge = new YourCartPage();
		sauceBackPack = new SauceLabsBackpackPage();
		sauceBackPack.clickOnAddtoCart();
		cartBadge = sauceBackPack.clickOnShoppingCartBadge();
		checkoutPage = cartBadge.clickOnCheckOutButton();
		checkoutconfirm = checkoutPage.checkoutSubmit(prop.getProperty("firstName"), prop.getProperty("lastName"),
				prop.getProperty("zipCode"));
		orderFinish = checkoutconfirm.clickOnFinishButton();

	}

	@Test(priority = 1)
	public void verifyTitleTextFinishTest() {
		String titleText = orderFinish.verifyTitleTextFinish();
		Assert.assertEquals(titleText, "Finish");

	}

	@Test(priority = 2)
	public void verifyGreetingsTest() {
		String titleGreetings = orderFinish.verifyGreetings();
		Assert.assertEquals(titleGreetings, "THANK YOU FOR YOUR ORDER");

	}

	@Test(priority = 3)
	public void clickOnlogoutBtnTest() {
		orderFinish.clickOnlogoutBtn();
	}

	@Test(priority = 4)
	public void fakeclickOnlogoutBtnTest() {
		orderFinish.deliberatelyfaildForScreenshot();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Closing Browser");
	}

}
