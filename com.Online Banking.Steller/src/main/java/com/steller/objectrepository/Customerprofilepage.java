package com.steller.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customerprofilepage {
	@FindBy(xpath = "//li[text()='Fund Transfer']") private WebElement fundtransferlink;
	@FindBy(xpath="//li[text()='Change Password']") private WebElement changepwdlink;
	@FindBy(xpath="//li[.='Statement']")private WebElement statementlink;
	@FindBy(name = "logout_btn") private WebElement logoutbtn;
	public Customerprofilepage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	public void clickOnFundTransferLink() {
		fundtransferlink.click();	
	}
	public void clickOnChangePasswordLink() {
		 changepwdlink.click();	
	}
	public void clickOnLogOutBtn() {
		logoutbtn.click();	
	}
	public void clickOnStatement() {
		statementlink.click();
	}

}
