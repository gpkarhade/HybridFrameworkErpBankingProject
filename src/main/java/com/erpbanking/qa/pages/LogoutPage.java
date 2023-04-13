package com.erpbanking.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logoutButton;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickonlogoutButton() {
		logoutButton.click();
		
	}

}
