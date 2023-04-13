package com.erpbanking.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewRequestEchallanPage {
	WebDriver driver;
	
	
	@FindBy(name="sro")
	WebElement sro;
	
	@FindBy(name="stamp_amount")
	WebElement stampAmount;
	
	@FindBy(name="reg_fees")
	WebElement regFees;

	@FindBy(name="purchaser_name")
	WebElement purchaserName;
	
	@FindBy(name="pur_pan_no")
	WebElement purchaserPanNo;
	
	@FindBy(name="pur_mobile_no")
	WebElement purchaserMobileNo;
	
	@FindBy(name="seller_name")
	WebElement sellerName;
	
	@FindBy(name="seller_pan_no")
	WebElement sellerPanNo;
	
	@FindBy(name="survey_no")
	WebElement surveyNo;
	
	@FindBy(name="mouza")
	WebElement mouzaNo;
	
	@FindBy(name="area")
	WebElement areaName;
	
	@FindBy(name="city")
	WebElement cityName;
	
	@FindBy(name="pin_code")
	WebElement pinCodeNo;

	
	
	public NewRequestEchallanPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterSRO(String sroNameText) {
		sro.sendKeys(sroNameText);
		
	}
	
	public void enterStampAmount(String stampAmountText) {
		stampAmount.sendKeys(stampAmountText);
		
	}
	
	public void enterRegFees(String regFeesText) {
		regFees.sendKeys(regFeesText);
	}
	
	public void enterPurchaserName(String purchaserNameText){
		purchaserName.sendKeys(purchaserNameText);
	}
	
	public void enterpurchaserPanNo(String purchaserPanNoText) {
		purchaserPanNo.sendKeys(purchaserPanNoText);
	}
	
	public void enterpurchaserMobileNo(String purchaserMobileNoText) {
		purchaserMobileNo.sendKeys(purchaserMobileNoText);
		
	}

	public void entersellerName(String sellerNameText) {
		sellerName.sendKeys(sellerNameText);
	}
	
	public void entersellerPanNo(String sellerPanNoText) {
		sellerPanNo.sendKeys(sellerPanNoText);
	}
	
	public void entersurveyNo(String surveyNoText) {
		surveyNo.sendKeys(surveyNoText);
	}
	
	public void entermouzaNo(String mouzaNoText) {
		mouzaNo.sendKeys(mouzaNoText);
	}
	
	public void enterareaName(String areaNameText) {
		areaName.sendKeys(areaNameText);
	}
	
	public void entercityName(String cityNameText) {
		cityName.sendKeys(cityNameText);
	}
	
	public void enterpinCodeNo(String pinCodeNoText) {
		pinCodeNo.sendKeys(pinCodeNoText);
	}
}



