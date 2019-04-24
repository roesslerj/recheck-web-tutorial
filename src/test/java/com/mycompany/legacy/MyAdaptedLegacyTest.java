package com.mycompany.legacy;

import java.nio.file.Paths;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import de.retest.web.selenium.RecheckDriver;

public class MyAdaptedLegacyTest {

	RecheckDriver driver;

	@Before
	public void setup() {
		driver = new RecheckDriver( new ChromeDriver());
	}

	@Test
	public void check_order() throws Exception {
		driver.startTest();
		String url = Paths.get( "src/test/resources/formPage.html" ).toUri().toURL().toString();
		driver.get(url);

		driver.findElement(By.id("email")).sendKeys("Max");
		driver.findElement(By.id("age")).sendKeys("16");
		driver.findElement(By.name("login")).submit();
		Assert.assertTrue(driver.getTitle().equals("We Leave From Here"));

		WebElement nestedForm = driver.findElement(By.id("nested_form"));
		WebElement input = nestedForm.findElement(By.name("x"));
		input.sendKeys("\n");
		Assert.assertTrue(driver.getTitle().equals("We Leave From Here"));

		driver.findElement(By.id("imageButton")).click();
		driver.capTest();
	}

	@After
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
