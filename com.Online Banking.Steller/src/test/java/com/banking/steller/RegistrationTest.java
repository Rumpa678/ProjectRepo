package com.banking.steller;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.steller.objectrepository.Applydebitcardpage;
import com.steller.objectrepository.Confirmbtnpage;
import com.steller.objectrepository.Homepage;
import com.steller.objectrepository.Openaccountpage;
import com.steller.objectrepository.Pendingcustomerpage;
import com.steller.objectrepository.Staffhomepage;
import com.steller.objectrepository.Staffloginpage;

import steller.utilities.Baseclass;

public class RegistrationTest extends Baseclass{
	@Test
	public void register() throws Exception {
		//fetch the dta from property file
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
	//mouse hover on internet button
	

		
	}

}
