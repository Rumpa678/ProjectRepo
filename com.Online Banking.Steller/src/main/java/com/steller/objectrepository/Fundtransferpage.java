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

public class Fundtransferpage {
	
@FindBy(name="add_beneficiary")
private WebElement addbnfbtn;
@FindBy(name="delete_beneficiary")
private WebElement deletebtn;

@FindBy(name="view_beneficiary")
private WebElement viewbtn;
@FindBy(name="beneficiary")
private WebElement selectbnfdropdown;
@FindBy(name="trnsf_amount")
private WebElement amounttextfield;
@FindBy(name="trnsf_remark")
private WebElement transremarktextfield;
@FindBy(name="fnd_trns_btn")
private WebElement fundtransferbtn;
@FindBy(name="logout_btn")
private WebElement logoutbtn;

	
	
public	Fundtransferpage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}


public void clickOnAddBnfBtn() {
	addbnfbtn.click();	
}


public void enterBenificiary(HashMap<String, String>fields,WebDriver driver, Webutility wutil,Javautility jutil) {
	for(Entry<String, String>set:fields.entrySet()) {
		if(set.getKey().equalsIgnoreCase("beneficiary")) {
		wutil.selectElementInDropdown(set.getValue(),selectbnfdropdown );	
		}
	else {
		
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
}
	}
}
	public void clickOnFundTransBtn() {
	fundtransferbtn.click();
}
	
	public void clickOnDeleteBtn() {
		deletebtn.click();
	}

public void clickOnViewBtn() {
	viewbtn.click();
}








public void clickingLogOutBtn() {
	logoutbtn.click();
}
}
