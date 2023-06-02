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

public class Addbenificiarypage {
	//declaration
@FindBy(name="beneficiary_name") private WebElement bnfnametxtfield;
@FindBy(name="beneficiary_acno") private WebElement bnfaccno;
@FindBy(name="Ifsc_code")private WebElement ifsccode;
@FindBy(name="beneficiary_acc_type")private WebElement accounttypedropdown;
@FindBy(name="add_beneficiary_btn") private WebElement addbnfbtn;
//Initialization
public Addbenificiarypage(WebDriver driver){
	PageFactory.initElements(driver,this);
}








//utilization
public void enterBenificiary(HashMap<String, String>fields,WebDriver driver, Webutility wutil,Javautility jutil) {
	for(Entry<String, String>set:fields.entrySet()) {
		if(set.getKey().equalsIgnoreCase("beneficiary_acc_type")) {
		wutil.selectElementInDropdown(set.getValue(), accounttypedropdown);	
		}
	else {
		
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
}
	}
}

public void clickOnAddBtn() {
	addbnfbtn.click();	
}
}

