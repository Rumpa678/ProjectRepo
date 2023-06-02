package com.steller.objectrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customerloginpage {
	@FindBy(name="customer_id")
	private WebElement customeridtextfield;
	@FindBy(name="password")
	private WebElement passwordtextfield;
	@FindBy(name="login-btn")
	private WebElement loginbtn;
	public Customerloginpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	


	


	
	public void loggingInPage(HashMap<String, String>fields,WebDriver driver)
	{
		for(Entry<String, String>set:fields.entrySet()) {
			
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
	}
	public void clickOnLogin() {
		loginbtn.click();	
	}

}
