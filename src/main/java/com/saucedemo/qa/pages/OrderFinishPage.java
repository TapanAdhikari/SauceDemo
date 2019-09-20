package com.saucedemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.qa.base.TestBase;

public class OrderFinishPage extends TestBase {
	@FindBy(xpath = "//div[text()='Finish']")
	WebElement titleTextFinish;
	@FindBy(xpath = "//h2[text()='THANK YOU FOR YOUR ORDER']")
	WebElement greetingsTextFinish;
	@FindBy(xpath = "//div[@style='z-index: 1000;']")
	WebElement sideBarLink;
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement logoutBtn;
	@FindBy(xpath = "//div[@id='logoutsidebarlink']")
	WebElement fakelogoutBtn;

	public OrderFinishPage() {
		PageFactory.initElements(driver, this);

	}

	public String verifyTitleTextFinish() {
		return titleTextFinish.getText();
	}

	public String verifyGreetings() {

		return greetingsTextFinish.getText();

	}

	public void deliberatelyfaildForScreenshot() {
		fakelogoutBtn.click();
	}

	public void clickOnlogoutBtn() {
		sideBarLink.click();
		Actions action = new Actions(driver);
		action.moveToElement(logoutBtn).click();

	}

}
