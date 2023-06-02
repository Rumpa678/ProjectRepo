package com.steller.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	@FindBy(xpath = "//a[text()='Staff Login']") private WebElement staffloginlink;
	@FindBy(xpath = "//li[text()='Fund Transfer']")private WebElement fundtransbtn; 
	@FindBy(xpath = "//li[.='Open Account']") private WebElement openAccountBtn;
	@FindBy(xpath = "//li[.='Apply Debit Card']")private WebElement applydebitcardbtn;
	@FindBy(xpath = "//a[.='Home']")private WebElement homelink;
	public Homepage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	

	public void Staffloginlink() 
	{
		staffloginlink.click();
	}

	public void fundtransBtn() {
		 fundtransbtn.click();
	}
	public void clickOnOpenaccountBtn() {
		openAccountBtn.click();	
	}
	public void clickOnApplyBtn() {
		
		applydebitcardbtn.click();	
	}
	public void clickonHomelink() {
		homelink.click();	
	}

}
	


