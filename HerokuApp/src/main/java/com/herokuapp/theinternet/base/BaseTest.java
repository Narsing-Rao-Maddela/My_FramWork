package com.herokuapp.theinternet.base;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	public WebDriver driver;
	public Logger log;
	private String AppUrl = "http://www.webdriveruniversity.com/";
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser, ITestContext cxt, Method method) {

		String testName = cxt.getCurrentXmlTest().getName();

		log = LogManager.getLogger(testName);

		BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
		driver = factory.createDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(AppUrl);

		this.testSuiteName = cxt.getSuite().getName();
		this.testName = testName;
		this.testMethodName = method.getName();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {
		
		log.info("Driver closed");

		driver.quit();
	}

	
}
