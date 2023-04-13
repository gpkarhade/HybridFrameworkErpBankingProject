package com.erpbanking.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//objects
	WebDriver driver ;
	@FindBy(name="username")
	WebElement usernameField;
	
	@FindBy(name="password")
	WebElement passwordField;
	
	@FindBy(name="login")
	WebElement loginButton;

	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public void enterUsername(String usernameText) {
		usernameField.sendKeys(usernameText);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);

	}
	
	public void clickonLoginButton(){
		loginButton.click();
		
	}
	

}
