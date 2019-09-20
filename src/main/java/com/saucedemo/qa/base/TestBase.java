package com.saucedemo.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.saucedemo.qa.util.TestUtil;
import com.saucedemo.qa.util.WebEventListener;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static WebEventListener eventListener;
	public static EventFiringWebDriver e_driver;
	public static Logger log = Logger.getLogger(TestBase.class);

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"D:\\My Software\\SELENIUM_JAVA\\Saucedemo\\src\\main\\java\\com\\saucedemo\\qa\\config\\config.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\My Software\\My Jar Files\\Drivers\\Version 75\\chromedriver.exe");
			System.setProperty("webdriver.chrome.logfile", "D:\\Temporary Soft files\\chromedriver.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			driver = new ChromeDriver();
			log.info("Launching Chrome Browser");

		} else if (browserName.equals("ff")) {
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");

			driver = new FirefoxDriver();
			log.info("Launching Firefox Browser");
		}
		e_driver = new EventFiringWebDriver(driver);
		// now create object of WebEventListener to register with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);

		log.info("Entering Application URL");
		driver.get(prop.getProperty("url"));

	}

}
