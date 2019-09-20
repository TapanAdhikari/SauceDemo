package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class CheckOutPage extends TestBase {

	@FindBy(xpath = "//div[text()='Checkout: Your Information']")
	WebElement titleText;
	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lastName;
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalcode;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitBtn;

	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyTitletext() {
		return titleText.getText();

	}

	public CheckOutConfirmPage checkoutSubmit(String fstName, String lstName, String zip) {

		firstName.sendKeys(fstName);
		lastName.sendKeys(lstName);
		postalcode.sendKeys(zip);
		submitBtn.click();
		return new CheckOutConfirmPage();

	}

}
