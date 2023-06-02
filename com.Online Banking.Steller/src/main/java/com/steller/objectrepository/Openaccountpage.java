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

public class Openaccountpage {
	@FindBy(name="name") private WebElement nametxtField;
	@FindBy(name="gender") private WebElement genderdropdown;
	@FindBy(name="mobile") private WebElement mobiletxtfield;
	@FindBy(name="email") private WebElement emailtxtfield;
	@FindBy(name="landline") private WebElement landlinetxtfield;
	@FindBy(name="dob") private WebElement dobtxtfield;
	@FindBy(name="pan_no") private WebElement pannotxtfield;
	@FindBy(name="citizenship") private WebElement citizentxtfield;
	@FindBy(name="homeaddrs") private WebElement homeaddress;
	@FindBy(name="officeaddrs") private WebElement officeaddress;
	@FindBy(name="state") private WebElement statedropdown;
	@FindBy(name="city") private WebElement citydropdown;
	@FindBy(name="pin") private WebElement pincodetxtfield;
	@FindBy(name="arealoc") private WebElement areatxtfield;
	@FindBy(name="nominee_name") private WebElement nomineetxtfield;
	@FindBy(name="nominee_ac_no") private WebElement nomaccnotxtfield;
	@FindBy(name="acctype") private WebElement acctypedropdown;
	@FindBy(name="submit") private WebElement submitbtn;
	
	
	public Openaccountpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	public void enterDateOfBirth(String date,String month,String year) 
	{
		dobtxtfield.click();
		dobtxtfield.sendKeys(date);
		dobtxtfield.sendKeys(month);
		dobtxtfield.sendKeys(year);
	}
	public String enterAccountDetails(HashMap<String, String>fields,WebDriver driver, Webutility wutil,Javautility jutil) {
		String name="";
		for(Entry<String, String>set:fields.entrySet()) {
			if(set.getKey().equalsIgnoreCase("gender")) {
			wutil.selectElementInDropdown(set.getValue(),genderdropdown );	
			}
		else if(set.getKey().equalsIgnoreCase("state")) {
			wutil.selectElementInDropdown(set.getValue(),statedropdown);
		}
		else if (set.getKey().equalsIgnoreCase("city")) {
		wutil.selectElementInDropdown(set.getValue(),citydropdown);
		}
		else if (set.getKey().equalsIgnoreCase("acctype")) {
		wutil.selectElementInDropdown(set.getValue(),acctypedropdown);	
		}
//		else if(set.getKey().equalsIgnoreCase("dob"))
//			{
//				Openaccountpage opa=new Openaccountpage(driver);
//				opa.enterDateOfBirth(date, month, year);
//			}
		else if (set.getKey().equalsIgnoreCase("name")) {
			name=set.getValue()+jutil.getRandomNumber();
			driver.findElement(By.name(set.getKey())).sendKeys(name);
						
		}
		else {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		
		}
		return name;
	}
	
	public void clickOnSubmitBtn() {
		submitbtn.click();	
	}
	
}
	
	


