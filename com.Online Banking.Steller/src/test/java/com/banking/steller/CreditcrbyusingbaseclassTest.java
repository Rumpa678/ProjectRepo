package com.banking.steller;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.steller.objectrepository.Addbenificiarypage;
import com.steller.objectrepository.Creditcustomerpage;
import com.steller.objectrepository.Customerloginpage;
import com.steller.objectrepository.Customerprofilepage;
import com.steller.objectrepository.Deletebenificiarypage;
import com.steller.objectrepository.Fundtransferpage;
import com.steller.objectrepository.Homepage;
import com.steller.objectrepository.Staffhomepage;
import com.steller.objectrepository.Staffloginpage;

import steller.utilities.Baseclass;

public class CreditcrbyusingbaseclassTest extends Baseclass {
	@Test(groups= {"smokeTest","regTest"})
	public void creditcustomer() throws IOException {
		Homepage hp=new Homepage(driver);
	       Staffloginpage sp=new Staffloginpage(driver);
	       Staffhomepage sm=new Staffhomepage(driver);
	       Creditcustomerpage cp=new Creditcustomerpage(driver);
	       Customerloginpage clp=new Customerloginpage(driver);
	       Fundtransferpage ft=new Fundtransferpage(driver);
	       Addbenificiarypage abp=new Addbenificiarypage(driver);
	       Deletebenificiarypage dp=new Deletebenificiarypage(driver);
	       Customerprofilepage cpp=new Customerprofilepage(driver);
	       //click on stafflogin link
	       String STAFFID=futil.getPropertyKeyValue("staffid");
	       String STAFFPWD=futil.getPropertyKeyValue("staffpwd");
	       //click on staffloginlink
	       hp.Staffloginlink();
	       //verify the home page is displayed or not
	       sp.enterStaffid(STAFFID, STAFFPWD);
	       sp.getLoginbtn().click();
	       String title1=driver.getTitle();
			System.out.println(driver.getTitle());
			Assert.assertTrue(title1.contains("Staff Home"));
			
//			{
//				System.out.println("stafflogin home page is displaying");
//			}
//			else {
//				System.out.println("stafflogin home page is not displaying");
//			}
			//click on credit customer button
			sm.clickCreditcusBtn();
			//enter the details
		    cp.creditingTheAmount(exutil.getMultipledata("creditcustomer"), driver);
		    cp.clickonCredit();
		    wutil.switchToAlertPopupAndAccept( driver, "Amount credited Successfully to customer account");
		    sp.clickOnHomeLink();
		    //click on fundtransferlink
		    hp.fundtransBtn();
		    clp.loggingInPage(exutil.getMultipledata("customerdetails"), driver);
		    clp.clickOnLogin();
		    //click on statement button
		    cpp.clickOnStatement();
		    //verify that the statement page should be displayed or noy
		   String url =driver.getCurrentUrl();
		   System.out.println(url);
		   Assert.assertTrue(url.contains("cust_statement"));
		    cpp.clickOnFundTransferLink();
		    ft.clickOnAddBnfBtn();
		    //enter the details of addbenificiary
		    abp.enterBenificiary(exutil.getMultipledata("addbenificiarydetails"),driver,wutil,jutil);
		    abp.clickOnAddBtn();
		    //verify that the pop up should be displayed
		    String addbnf=wutil.switchToAlertPopupAndAccept(driver, "Beneficiary Added Successfully");
		    System.out.println(addbnf);
		    
	       
	}

}

