package com.erpbanking.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.erpbanking.qa.base.Base;

public class LogoutTest extends Base {
	
	public LogoutTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {

		
		driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browser"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyLogoutApplication() {
		driver.findElement(By.name("username")).sendKeys(dataprop.getProperty("validusername"));
		driver.findElement(By.name("password")).sendKeys(dataprop.getProperty("validpassword"));
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Sign in']")).isDisplayed(),"Appliction is not Logout");
	}

}
