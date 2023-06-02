package com.steller.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Otpverificationpage {

	@FindBy(name="otpcode") private WebElement Otpcodetxtfield;
	@FindBy(name="verify-btn")private WebElement verifybtn;
	
	public Otpverificationpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void clickOnVerify() {
		verifybtn.click();	
	}
	public WebElement getOtpcodetxtfield() {
		return Otpcodetxtfield;
	}
	
	
	}

 

