package creditcustomer_fundTransfer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase4 {

	public static void main(String[] args)  throws Exception{
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
				driver.findElement(By.name("password")).sendKeys("Swathi@110");
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
	driver.findElement(By.xpath("//li[.='My Account']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@value='Change Password']")).click();
	// TODO Auto-generated method stub
	driver.findElement(By.name("oldpass")).sendKeys("Swathi@110");
	driver.findElement(By.name("cnfrm")).sendKeys("Swathi@110");
	driver.findElement(By.name("newpass")).sendKeys("Swathi@30");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Alert pop=driver.switchTo().alert();
	String msgs=pop.getText();
	System.out.println(pop.getText());
	if(msgs.contains("Password Changed Successfully!"))
	{
		System.out.println("password is changed ");
	}
	else {
		
		System.out.println("password is not changed ");
	}
	pop.accept();

	}

}
