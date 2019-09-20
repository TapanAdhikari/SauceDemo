package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class SauceLabsBackpackPage extends TestBase {

	@FindBy(xpath = "//div[@class='inventory_details_name' and text()='Sauce Labs Backpack']")
	WebElement headerLabel;
	@FindBy(xpath = "//button[@class='btn_primary btn_inventory' and text()='ADD TO CART']")
	WebElement addToCart;
	@FindBy(xpath = "//*[@data-icon='shopping-cart' and @role ='img']")
	WebElement shoppingCartBadge;

	public SauceLabsBackpackPage() {
		PageFactory.initElements(driver, this);

	}

	public String verifyBackPackHeaderLabel() {
		return headerLabel.getText();

	}

	public void clickOnAddtoCart() {
		addToCart.click();
	}

	public YourCartPage clickOnShoppingCartBadge() {
		shoppingCartBadge.click();
		return new YourCartPage();
	}

}
