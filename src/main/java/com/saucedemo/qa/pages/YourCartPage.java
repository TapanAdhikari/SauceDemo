package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class YourCartPage extends TestBase {

	@FindBy(xpath = "//div[text()='Your Cart']")
	WebElement yourcart;
	@FindBy(xpath = "//a[text()='CHECKOUT']")
	WebElement checkOutBtn;

	public YourCartPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyYourCartTest() {

		return yourcart.getText();

	}

	public CheckOutPage clickOnCheckOutButton() {
		checkOutBtn.click();
		return new CheckOutPage();

	}

}
