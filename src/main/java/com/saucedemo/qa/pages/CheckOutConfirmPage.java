package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class CheckOutConfirmPage extends TestBase {
	@FindBy(xpath = "//div[text()='Checkout: Overview']")
	WebElement titleText;
	@FindBy(xpath = "//div[text()='Payment Information:']")
	WebElement paymentText;
	@FindBy(xpath = "//a[text()='FINISH']")
	WebElement clickOnFinish;

	public CheckOutConfirmPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyTitleText() {
		return titleText.getText();

	}

	public String verifyPaymentInfo() {
		return paymentText.getText();

	}

	public OrderFinishPage clickOnFinishButton() {
		clickOnFinish.click();
		return new OrderFinishPage();
	}

}
