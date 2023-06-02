package com.steller.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Deletebenificiarypage {
	@FindBy(xpath = "//input[@value=' 71 ']") private WebElement deleteradiobtn;
@FindBy(name="delete_beneficiary")private WebElement deletebnfbtn;
	public Deletebenificiarypage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void clickRadBtn() {
		deleteradiobtn.click();	
	}

	public void clickDeleteBtn() {
		deletebnfbtn.click();	
	}
		
	}

