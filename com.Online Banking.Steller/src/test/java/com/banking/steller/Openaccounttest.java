package com.banking.steller;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.steller.objectrepository.Applydebitcardpage;
import com.steller.objectrepository.Confirmbtnpage;
import com.steller.objectrepository.Homepage;
import com.steller.objectrepository.Openaccountpage;
import com.steller.objectrepository.Pendingcustomerpage;
import com.steller.objectrepository.Staffhomepage;
import com.steller.objectrepository.Staffloginpage;

import steller.utilities.Baseclass;
//@Listeners(steller.utilities.Listnerimplementation.class)
public class Openaccounttest extends Baseclass {
	@Test(groups= {"smokeTest","regTest"})
	public void openacc() throws Exception {
		Homepage hp=new Homepage(driver);
    	Openaccountpage opp=new Openaccountpage(driver);
    	Confirmbtnpage cbp=new Confirmbtnpage(driver);
    	Staffloginpage slp=new Staffloginpage(driver);
    	Staffhomepage shp=new Staffhomepage(driver);
    	Pendingcustomerpage pcp=new Pendingcustomerpage(driver);
    	Applydebitcardpage adp=new Applydebitcardpage(driver);
    	hp.clickOnOpenaccountBtn();
    	
    	
    	HashMap<String, String> map = exutil.getMultipledata("openaccount");
    	String DATE=exutil.getExcelData("DateDetails", 1, 0);
    	String MONTH=exutil.getExcelData("DateDetails", 1, 1);
    	String YEAR=exutil.getExcelData("DateDetails", 1, 2);
    	System.out.println(DATE+" "+MONTH+" "+YEAR);
    	String name = opp.enterAccountDetails(map, driver, wutil, jutil);
      
        opp.enterDateOfBirth(DATE, MONTH, YEAR);
        Thread.sleep(3000);
    	opp.clickOnSubmitBtn();
    	cbp.clickOnConfirmBtn();
    	   //verify
        String visibletxt =wutil.switchToAlertPopupAndAccept(driver, "Application submitted successfully");
        System.out.println(visibletxt);
            String appno="";
             for(int i=0;i<visibletxt.length();i++) {
          	   if(Character.isDigit(visibletxt.charAt(i))) {
          		   appno=appno+visibletxt.charAt(i);
             }
             }
   
    	
	exutil.insertDataIntoExcel("Datedetails", 11, 10, appno);
	//verify that user home page is displayed
	String url3=driver.getCurrentUrl();
	
	Assert.assertTrue(url3.contains("index"));

//	System.out.println(url3);
//if(url3.contains("index")) {
//	System.out.println("user home page is displayed");
//}
//else {
//	System.out.println("user home page is not displayed");
//}
//click on staff login 
hp.Staffloginlink();
String STAFFID=futil.getPropertyKeyValue("staffid");
String STAFFPWD=futil.getPropertyKeyValue("staffpwd");
slp.enterStaffid(STAFFID, STAFFPWD);
slp.getLoginbtn().click();
//click on approve button
shp.clickOnApproveCustomer();
//verify wheather approve pending account page is displayed or noT
String appurl=driver.getCurrentUrl();
System.out.println(appurl);
Assert.assertTrue(appurl.contains("pending_customers")); 
//	System.out.println("Pending customer page is displayed");
//}
//else {
//	System.out.println("Pending customer page is not displayed");
//}
//enter the application number
pcp.enterAppNo(appno);
Thread.sleep(2000);
pcp.clickOnSearch();
pcp.clickOnApproveBtn();
Thread.sleep(2000);
//get text account no
String account=wutil.switchToAlertPopupAndAccept(driver,"Account Created Successfully");
System.out.println(account);
Thread.sleep(2000);
String AccountNo="";
for(int i=0;i<account.length();i++) {
	if(Character.isDigit(account.charAt(i))) {
		AccountNo=AccountNo+account.charAt(i);
	}
}
//fetch the data from excel

//verify that account created successfully
if(account.contains("Account Created Successfully")) {

	System.out.println("Account created successfully popup is displaying");
}
else
{
	System.out.println("Account created successfully popup is not displaying");
}
//click on homelink
slp.clickOnHomeLink();
//click on applydebitcardbtn
hp.clickOnApplyBtn();
//verify that debit card form is displayed or not
String debiturl=driver.getCurrentUrl();
System.out.println(debiturl);
Assert.assertTrue(debiturl.contains("debit_card_form")); 
//	System.out.println("debitcard form page is displayed");
//}
//else {
//	System.out.println("debitcard form page is not displayed");
//}
//enter the details of applydebitcard
String DATE1=exutil.getExcelData("DateDetails", 1, 0);
String MONTH1=exutil.getExcelData("DateDetails", 1, 1);
String YEAR1=exutil.getExcelData("DateDetails", 1, 2);
System.out.println(DATE+" "+MONTH+" "+YEAR);
	adp.enterDobDetails(DATE1, MONTH1, YEAR1);
//Assert.fail();
	String PAN=exutil.getExcelData("openaccount", 5, 1);
	String MOBILE=exutil.getExcelData("openaccount",2 ,1 );
	adp.enterAccountDetails(name,PAN,MOBILE);
	adp.getAccounttxtfield().sendKeys(AccountNo);
	adp.clickOnSubmitBtn();
//get text from alert
	String debitpop=wutil.switchToAlertPopupAndAccept(driver, "Debit Card issued successfully");
	System.out.println(debitpop);
	Thread.sleep(2000);
	//verify that pop is displayed or not
	if(debitpop.contains("Debit Card issued successfully")) {
		System.out.println("Debit Card issued successfully pop up is displayed");
	}
	else {
		System.out.println("Debit Card issued successfully pop up is not displayed");
	}
	//convert and fetch the application no
	String pincode=debitpop.split("pin is: ")[1].split("")[0].trim();
	
	//click on home link
	hp.clickonHomelink();
	}
}


