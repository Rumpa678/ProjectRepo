package creditcustomer_fundTransfer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcasefirst {

	public static void main(String[] args) throws InterruptedException {
		//open chrome browser
		WebDriver driver=WebDriverManager.firefoxdriver().create();
				//maximize browser
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				//enter the url of the screen
				driver.get("http://rmgtestingserver/domain/Online_Banking_System");
				driver.findElement(By.xpath("//a[.='Staff Login']")).click();
				driver.findElement(By.name("staff_id")).sendKeys("210001");
				driver.findElement(By.name("password")).sendKeys("password");
				driver.findElement(By.name("staff_login-btn")).click();
				//verify that the profile page is displayed or not
				String title1=driver.getTitle();
				System.out.println(driver.getTitle());
				if(title1.contains("Staff Home"))
				{
					System.out.println("stafflogin home page is displaying");
				}
				else {
					System.out.println("stafflogin home page is not displaying");
				}
				//click on credit customer button
				driver.findElement(By.xpath("//input[@value='Credit Customer']")).click();
				//enter the details of credit customer
				driver.findElement(By.name("customer_account_no")).sendKeys("101191011137");
				driver.findElement(By.name("credit_amount")).sendKeys("3000");
				driver.findElement(By.name("credit_btn")).click();
				Thread.sleep(3000);
				//verify wheather pop up is displayed or not
				Alert a1=driver.switchTo().alert();
				        String msg=  a1.getText();
				        System.out.println(a1.getText());
				       if (msg.contains("Amount credited Successfully to customer account"))
				        {
				        	System.out.println("amount is credited successfully");
				        }
				        else {
				        	System.out.println("amount is not credited successfully");
				        }
				        a1.accept();
				        Thread.sleep(2000);
				//click on logout button
				driver.findElement(By.name("logout_btn")).click();
				Thread.sleep(3000);
				//go to home page
				driver.findElement(By.xpath("//a[.='Home']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
				Thread.sleep(3000);
				//Enter the details of customer
				driver.findElement(By.name("customer_id")).sendKeys("1011137");
				driver.findElement(By.name("password")).sendKeys("Swathi123#");
				driver.findElement(By.name("login-btn")).click();
				Thread.sleep(3000);
				//verify that  home page should be displayed
				String title2=driver.getTitle();
				System.out.println(driver.getTitle());
				if(title2.contains("My Profile"))
				{
					System.out.println("My profile page is displaying");
				}
				else {
					System.out.println("My profile page is not displaying");
				}
				
				//click on statement tab
				driver.findElement(By.xpath("//li[.='Statement']")).click();
				Thread.sleep(3000);
				//verify that the amount should be credited
	String trand = driver.findElement(By.xpath("//td[.='765119677']")).getText();
	System.out.println(trand);
	if(trand.contains("765119677"))
	{
		System.out.println("amount should be credited");
	}
	else {
		System.out.println("amount should  not be credited");
	}
	driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.name("add_beneficiary")).click();
	//Enter the details of benificiary
	driver.findElement(By.name("beneficiary_name")).sendKeys("ammu");
	driver.findElement(By.name("beneficiary_acno")).sendKeys("1011391011840");
	driver.findElement(By.name("Ifsc_code")).sendKeys("1011");
WebElement ele=	driver.findElement(By.name("beneficiary_acc_type"));
	Select s1=new Select(ele);
	s1.selectByVisibleText("Saving");
	Thread.sleep(3000);
	//click on add benificiary button
	driver.findElement(By.name("add_beneficiary_btn")).click();
	Thread.sleep(3000);
	//verify that pop should be displayed
	Alert a2=driver.switchTo().alert();
	String msg1=a2.getText();
	System.out.println(a2.getText());
       if (msg1.contains("Beneficiary Added Successfully"))
        {
        	System.out.println("benificiary is added successfully");
        }
        else {
        	System.out.println(" benificiary is not added successfully");
        }
        a2.accept();
	
	Thread.sleep(3000);
	//click on fund transfer button
	driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
	Thread.sleep(2000);
	//click on benificiary button
	driver.findElement(By.name("view_beneficiary")).click();
	Thread.sleep(2000);
	//view the added benificiary
	String txt=driver.findElement(By.xpath("//td[.='16/05/23 11:11:21 AM']")).getText();
	System.out.println(driver.findElement(By.xpath("//td[.='16/05/23 11:11:21 AM']")).getText());
	if(txt.contains("16/05/23 11:11:21 AM"))
	{
	System.out.println("amount is credited");
	}
	else {
		System.out.println("amount is not  credited");
	}
	//click on fund transfer button
driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
//enter the details for sending amount
WebElement drop=driver.findElement(By.name("beneficiary"));
Select s2=new Select(drop);
s2.selectByVisibleText("ammu-1011391011840");
driver.findElement(By.name("trnsf_amount")).sendKeys("3000");
driver.findElement(By.name("trnsf_remark")).sendKeys("three thousand only");
driver.findElement(By.name("fnd_trns_btn")).click();
Thread.sleep(2000);
String otpMsg = driver.findElement(By.xpath("//label[@class='OTP_msg']")).getText();
String[] otpPart = otpMsg.split(":");
//Enter the otp

driver.findElement(By.name("otpcode")).sendKeys(otpPart[1]);
driver.findElement(By.name("verify-btn")).click();
Thread.sleep(2000);
//verify that pop should be displayed
Alert a5=driver.switchTo().alert();
String msg3=a5.getText();
System.out.println(a5.getText());
if(msg3.contains("Transaction Successful!"))
{
	System.out.println("Transaction is successfull");
}
else {
	System.out.println("Transaction is not successfull");
}

Thread.sleep(2000);
//click on logout button
driver.findElement(By.id("logout")).click();
//check that customer login page should be displayed
String page=driver.findElement(By.xpath("//label[.='LOGIN']")).getText();
System.out.println(driver.findElement(By.xpath("//label[.='LOGIN']")).getText());
if(page.contains("LOGIN"))
{
	System.out.println("Customer login page is displayed");
}
else
{
	System.out.println("Customer login page is not displayed");
}
		// TODO Auto-generated method stub

	}
	

}
