package creditcustomer_fundTransfer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase3 {

	public static void main(String[] args) throws InterruptedException{
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
						driver.findElement(By.name("password")).sendKeys("Swathi@30");
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
						
						
						//click on fund transfer button
						driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
						Thread.sleep(2000);
						//delete benificiary
						driver.findElement(By.name("delete_beneficiary")).click();
						driver.findElement(By.xpath("//input[@value=' 15 ']")).click();
						Thread.sleep(2000);
						driver.findElement(By.name("delete_beneficiary")).click();
						//verify that popup should be displayed
						Alert a3=driver.switchTo().alert();
						String msg2=a3.getText();
						System.out.println(a3.getText());
						if(msg2.contains("Beneficiary Deleated Successfully")) {
							System.out.println("benificiary is deleted");
							
						}
						else {
							System.out.println("benificiary is deleted");
						}
						a3.getText();
						//logout
						driver.findElement(By.xpath("logout_btn")).click();
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
