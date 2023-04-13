package com.erpbanking.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	WebDriver driver;
	@FindBy(xpath="//a[normalize-space()='New Request']")
	WebElement newRequestButton;
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void newRequestButton() {
		newRequestButton.click();
	}
	
	
}
