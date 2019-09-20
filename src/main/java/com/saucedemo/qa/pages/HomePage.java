package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement userAppLogo;

	@FindBy(xpath = "//div[@class='product_label'and text()='Products']")
	WebElement productLabel;

	@FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']")
	WebElement productBackPack;

	@FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Bolt T-Shirt']")
	WebElement productShirt;
	@FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Fleece Jacket']")
	WebElement productJacket;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyAppLogo() {

		return userAppLogo.isDisplayed();
	}

	public String veriFyuserProductsLabel() {

		return productLabel.getText();
	}

	public SauceLabsBackpackPage userProductBackPack() {
		productBackPack.click();
		return new SauceLabsBackpackPage();
	}

	public SauceLabsBoltTShirtPage userProductShirt() {

		productShirt.click();
		return new SauceLabsBoltTShirtPage();

	}

	public SauceLabsFleeceJacketPage userProductJacket() {

		productJacket.click();
		return new SauceLabsFleeceJacketPage();
	}

}