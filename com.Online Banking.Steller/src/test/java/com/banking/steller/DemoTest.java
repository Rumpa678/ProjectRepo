package com.banking.steller;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.steller.objectrepository.Creditcustomerpage;
import com.steller.objectrepository.Homepage;
import com.steller.objectrepository.Staffhomepage;
import com.steller.objectrepository.Staffloginpage;

import steller.utilities.Baseclass;

public class DemoTest extends Baseclass {

	@Test
public void demo1() throws Throwable  {
		
		Homepage hp=new Homepage(driver);
	       Staffloginpage sp=new Staffloginpage(driver);
	       Staffhomepage sm=new Staffhomepage(driver);
	       Creditcustomerpage cp=new Creditcustomerpage(driver);
	       
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
			//click on credit customer button
			sm.clickCreditcusBtn();
			//enter the details
		    cp.creditingTheAmount(exutil.getMultipledata("creditcustomer"), driver);
		    cp.clickonCredit();
		    wutil.switchToAlertPopupAndAccept( driver, "Amount credited Successfully to customer account");
	}
		// TODO Auto-generated method stub

	}


