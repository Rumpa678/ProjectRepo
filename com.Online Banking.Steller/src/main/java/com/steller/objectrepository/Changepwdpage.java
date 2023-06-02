package com.steller.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Changepwdpage {
	@FindBy(name="oldpass")private WebElement oldpwdtxtfield;
	@FindBy(name="cnfrm") private WebElement cnfrmpwdtxt;
	@FindBy(name="newpass") private WebElement newpwdtxt;
	@FindBy(name="change_pass")private WebElement submitquerybtn;
	Changepwdpage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void changeThePwd(String oldpwd,String cnfrmpwd,String newpwd) {
		oldpwdtxtfield.sendKeys(oldpwd);
		cnfrmpwdtxt.sendKeys(cnfrmpwd);
		newpwdtxt.sendKeys(newpwd);
		 submitquerybtn.click();
		
	}

}
