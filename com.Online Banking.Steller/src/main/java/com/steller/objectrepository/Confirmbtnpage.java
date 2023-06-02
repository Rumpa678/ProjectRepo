package com.steller.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmbtnpage {
	@FindBy(name="cnfrm-submit") private WebElement confirmbtn;
	
	public Confirmbtnpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void clickOnConfirmBtn() {
		confirmbtn.click();	
	}

}
