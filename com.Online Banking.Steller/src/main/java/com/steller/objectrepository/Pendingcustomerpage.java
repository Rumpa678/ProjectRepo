package com.steller.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pendingcustomerpage {
	@FindBy(name="application_no") private WebElement applicationnotxtfield;
	@FindBy(name="search_application") private WebElement searchapplicationicon;
	@FindBy(name="approve_cust") private WebElement approvebtn;
	@FindBy(name="home")private WebElement homelink;
	public Pendingcustomerpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	public void clickOnApproveBtn() {
		approvebtn.click();
	}
	public void enterAppNo(String application_no) {
		applicationnotxtfield.sendKeys(application_no);	
	}
  public void clickOnSearch() {
	  searchapplicationicon.click();  
  }
  public void clickOnHomeLink() {
	  homelink.click(); 
  }
}
