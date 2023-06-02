package com.banking.steller;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.steller.objectrepository.Addbenificiarypage;
import com.steller.objectrepository.Creditcustomerpage;
import com.steller.objectrepository.Customerloginpage;
import com.steller.objectrepository.Customerprofilepage;
import com.steller.objectrepository.Deletebenificiarypage;
import com.steller.objectrepository.Fundtransferpage;
import com.steller.objectrepository.Homepage;
import com.steller.objectrepository.Otpverificationpage;
import com.steller.objectrepository.Staffhomepage;
import com.steller.objectrepository.Staffloginpage;

import steller.utilities.Baseclass;

public class FundotpverificationsTest  extends Baseclass{
	@Test(groups= {"smokeTest","regTest"})
	public void fundotpverify() throws EncryptedDocumentException, IOException, InterruptedException {
		 Homepage hp=new Homepage(driver);
	       Staffloginpage sp=new Staffloginpage(driver);
	       Staffhomepage sm=new Staffhomepage(driver);
	       Creditcustomerpage cp=new Creditcustomerpage(driver);
	       Customerloginpage clp=new Customerloginpage(driver);
	       Fundtransferpage ft=new Fundtransferpage(driver);
	       Addbenificiarypage abp=new Addbenificiarypage(driver);
	       Deletebenificiarypage dp=new Deletebenificiarypage(driver);
	       Customerprofilepage cpp=new Customerprofilepage(driver);
	       Otpverificationpage otpp=new Otpverificationpage(driver);
	       //click on fund transfer button
	       hp.fundtransBtn();
	       //verify that the customer log in page is displayed or not
	               String url=driver.getCurrentUrl();
	               System.out.println(url);
//	               Assert.assertTrue(url.contains(""));
//	               //enter the details of customer
//	               clp.loggingInPage(exutil.getMultipledata("customerdetails"), driver);
//	               Thread.sleep(2000);
//	               clp.clickOnLogin();
//	               //verify that customer profile page should be displayed
//	               String url1=driver.getCurrentUrl();
//	               System.out.println(url1);
//	               Assert.assertTrue(url1.contains("My Profile"));
//	               //click on fund transfer link
//	               cpp.clickOnFundTransferLink();
//	               //verify that the fund transfer profile page is displayed or not
//	               String url2=driver.getCurrentUrl();
//	               Assert.assertTrue(url2.contains("My Profile"));
//	               //enter the details of benificiary
//	               
	               
	}

}
