package com.steller.objectrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Creditcustomerpage {
	@FindBy(name="customer_account_no")
	private  WebElement customeraccnotextfield;
	@FindBy(name="credit_amount")
	private WebElement amounttextfield;
	@FindBy(name="credit_btn")
	private WebElement creditbtn;
	@FindBy(name="logout_btn")
	private WebElement logoutbtn;
	
	public Creditcustomerpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonCredit() {
		creditbtn.click();	
	}


	

	public void creditingTheAmount(HashMap<String, String>fields,WebDriver driver)
	{
		for(Entry<String, String>set:fields.entrySet()) {
			
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
	}

	public void clickOnLogOutBtn() {
		logoutbtn.click();	
	}
}
