package com.steller.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Staffhomepage {
	@FindBy(name="credit_cust_ac") private WebElement creditcustomerbtn;
	@FindBy(name="apprvac") private WebElement approveaccbtn;
	public Staffhomepage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public void clickCreditcusBtn() {
		creditcustomerbtn.click();	
	}
	public void clickOnApproveCustomer() {
		approveaccbtn.click();	
	}
}
