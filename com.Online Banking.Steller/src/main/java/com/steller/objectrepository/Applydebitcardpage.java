package com.steller.objectrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import steller.utilities.Javautility;
import steller.utilities.Webutility;

public class Applydebitcardpage {
	@FindBy(name="holder_name") private WebElement holdernametxtfield;
	@FindBy(name="dob") private WebElement dateofbirthtxtfield;
	@FindBy(name="pan") private WebElement pantxtfield;
	@FindBy(name="mob") private WebElement mobiletxtfield;
	@FindBy(name="acc_no") private WebElement accounttxtfield;
	@FindBy(name="dbt_crd_submit")private WebElement submitbtn;
	public Applydebitcardpage(WebDriver driver ) {
		PageFactory.initElements(driver,this);
	}
	
		

	public WebElement getAccounttxtfield() {
		return accounttxtfield;
	}

	

		public void enterDobDetails(String date,String month,String year) {
		dateofbirthtxtfield.click();
		dateofbirthtxtfield.sendKeys(date);
		dateofbirthtxtfield.sendKeys(month);
		dateofbirthtxtfield.sendKeys(year);
		}
		public void enterAccountDetails(String holder_name,String pan,String mob ) {
			 holdernametxtfield.sendKeys(holder_name);
			 pantxtfield.sendKeys(pan);
			 mobiletxtfield.sendKeys(mob);
			}
		
		
	public void clickOnSubmitBtn() {
		submitbtn.click();	
	}
	
	

}
