package com.erpbanking.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.erpbanking.qa.base.Base;
import com.erpbanking.qa.pages.DashboardPage;
import com.erpbanking.qa.pages.LoginPage;
import com.erpbanking.qa.pages.NewRequestEchallanPage;

public class DashboardTest extends Base {
	public DashboardTest() {
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
	public void NewRequest(){
		
		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		NewRequestEchallanPage newRequestEchallan = new NewRequestEchallanPage(driver);
		loginPage.enterUsername(dataprop.getProperty("validusername"));
		loginPage.enterPassword(dataprop.getProperty("validpassword"));
		loginPage.clickonLoginButton();
		dashboardPage.newRequestButton();
		
		WebElement dropDown_ServiceType = driver.findElement(By.id("service_type"));
		Select select = new Select(dropDown_ServiceType);
		select.selectByVisibleText("Echallan");
		
		
		WebElement dropDown_CustomerName = driver.findElement(By.name("cust_id"));
		Select selects = new Select(dropDown_CustomerName);
		selects.selectByVisibleText("SNEHAL JANGDE ");
		
		WebElement dropDown_SelectDocumentType = driver.findElement(By.name("document_type"));
		Select selectss = new Select(dropDown_SelectDocumentType);
		selectss.selectByVisibleText("25.1 -Conveyance/Sale/Transfer");
		
		newRequestEchallan.enterSRO(dataprop.getProperty("sro"));
		newRequestEchallan.enterStampAmount(dataprop.getProperty("stampAmount"));
		newRequestEchallan.enterRegFees(dataprop.getProperty("regFees"));
		newRequestEchallan.enterPurchaserName(dataprop.getProperty("purchaserName"));
		newRequestEchallan.enterpurchaserPanNo(dataprop.getProperty("purPan"));
		newRequestEchallan.enterpurchaserMobileNo(dataprop.getProperty("purMobile"));
		newRequestEchallan.entersellerName(dataprop.getProperty("sellerName"));
		newRequestEchallan.entersellerPanNo(dataprop.getProperty("sellerPan"));
		newRequestEchallan.entersurveyNo(dataprop.getProperty("surveyNo"));
		newRequestEchallan.entermouzaNo(dataprop.getProperty("mouza"));
		newRequestEchallan.enterareaName(dataprop.getProperty("area"));
		newRequestEchallan.entercityName(dataprop.getProperty("city"));
		newRequestEchallan.enterpinCodeNo(dataprop.getProperty("pinCode"));
		
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//h1[text()='Entry Request Dashboard']")));
		*/
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='form-group']/following::button[@name='echallan']")));
		element.click();
		
		//Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Entry Request Dashboard']")).isDisplayed(),"Does not Navigate to Entry Request Dashboard Page");

		
	}
	

}
