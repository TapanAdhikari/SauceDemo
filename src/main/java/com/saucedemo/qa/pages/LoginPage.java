package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passWord;

	@FindBy(xpath = "//input[@type='submit' and @value='LOGIN']")
	WebElement loginBtn;

	@FindBy(xpath = "//div[@class='login_logo']")
	WebElement SWAGLABS;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public String validateLoginPage() {
		return driver.getTitle();

	}

	public HomePage login(String un, String pass) {
		userName.sendKeys(un);
		passWord.sendKeys(pass);
		loginBtn.click();
		return new HomePage();

	}

}
