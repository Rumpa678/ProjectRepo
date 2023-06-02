package com.steller.objectrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import steller.utilities.Webutility;

public class Registerpage {
	@FindBy(name="holder_name") private WebElement holdernametxtfield;
	@FindBy(name="accnum") private WebElement accountnotxt;
	@FindBy(name="dbtcard")private WebElement dbcardnotxt;
	@FindBy(name="dbtpin")private WebElement dbpintxt;
	@FindBy(name="mobile")private WebElement mobilenotxt;
	@FindBy(name="pan_no")private WebElement pannotxt;
	@FindBy(name="dob")private WebElement dobtxt;
	@FindBy(name="last_trans") private WebElement lasttanstxt;
	@FindBy(name="password") private WebElement passwordtxtfield;
	@FindBy(name="submit") private WebElement submitbtn;
	@FindBy(name="cnfrm_password") private WebElement confirmpwdtxt;
	
	public  Registerpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void enterDateOfBirth(String date,String month,String year) 
	{
		dobtxt.click();
		dobtxt.sendKeys(date);
		dobtxt.sendKeys(month);
		dobtxt.sendKeys(year);
	}
	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public void enterTheDetailsofRegister(HashMap<String, String>fields,WebDriver driver, Webutility wutil) {
		for(Entry<String, String>set:fields.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			
		}
		
	
		
	}

}
