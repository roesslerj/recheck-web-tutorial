package com.mycompany;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;

public class MyFirstTest {

	private WebDriver driver;
	private Recheck re;

	@Before
	public void setup() {
		re = new RecheckImpl();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\retest\\Desktop\\recheck-web-tutorial\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
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
