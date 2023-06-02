package com.steller.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Staffloginpage {
	@FindBy (name="staff_id")
	private WebElement staffidtextfield;
	@FindBy (name="password")
	private WebElement passwordtextfield;
	@FindBy (name="staff_login-btn")
	private WebElement loginbtn;
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homelink;
	public Staffloginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	public void enterStaffid(String staffid,String staffpwd ) {
		staffidtextfield.sendKeys(staffid);
	
		passwordtextfield.sendKeys(staffpwd);	
	
		
	}
	public void clickOnHomeLink() {
		 homelink.click();	
	}
}


