package com.mycompany;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;

public class MyFirstTest {

	private WebDriver driver;
	private Recheck re;

	@Before
	public void setup() {
		re = new RecheckImpl();

		final ChromeOptions opts = new ChromeOptions();
		opts.addArguments(
				// Enable headless mode for faster execution.
				"--headless",
				// Use Chrome in container-based Travis CI environment (see https://docs.travis-ci.com/user/chrome#Sandboxing).
				"--no-sandbox",
				// Fix window size for stable results.
				"--window-size=1200,800" );
		driver = new ChromeDriver(opts);
	}

	@Test
	public void scratchpad() throws Exception {
		re.startTest();
		driver.get("http://scratchpad.io/recheck-45678");
		re.check(driver, "open");

		re.capTest();
	}

	@After
	public void tearDown() {
		driver.quit();
		re.cap();
	}
}
