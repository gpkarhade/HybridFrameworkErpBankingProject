package com.erpbanking.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erpbanking.qa.base.Base;
import com.erpbanking.qa.pages.LoginPage;
import com.erpbanking.qa.utils.Utilities;

public class LoginTest extends Base {
	
	public LoginTest() {
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
	
	
	
	@Test(priority=1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String username,String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickonLoginButton();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed());
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] SupplyTestData() {
		Object[][] data= Utilities.getTestDataFromExcel("Sheet1");
	    return data;
	}
	
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(dataprop.getProperty("invalidusername"));
		loginPage.enterPassword(dataprop.getProperty("invalidpassword"));
		loginPage.clickonLoginButton();
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		String alertpoup = alert.getText();
		System.out.println(alertpoup);
		alert.accept();
		 
	}
	
	@Test(priority = 3)
	public void verifyLoginWithoutProvidingAnyCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickonLoginButton();
		Alert alert = driver.switchTo().alert();
		String alertpoup = alert.getText();
		System.out.println(alertpoup);
		alert.accept();
		 
	}
	
	@Test(priority = 4)
	public void verifyLoginWithValidUsernameAndInvalidPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(dataprop.getProperty("validusername"));
		loginPage.enterPassword(dataprop.getProperty("invalidpassword"));
		loginPage.clickonLoginButton();
		Alert alert = driver.switchTo().alert();
		String alertpoup = alert.getText();
		System.out.println(alertpoup);
		alert.accept();
		 
		
	}
	
	@Test(priority = 5)
	public void verifyLoginWithInvalidUsernameAndValidPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(dataprop.getProperty("invalidusername"));
		loginPage.enterPassword(dataprop.getProperty("validpassword"));
		loginPage.clickonLoginButton();
		Alert alert = driver.switchTo().alert();
		String alertpoup = alert.getText();
		System.out.println(alertpoup);
		alert.accept();
		 
		
	}

}
