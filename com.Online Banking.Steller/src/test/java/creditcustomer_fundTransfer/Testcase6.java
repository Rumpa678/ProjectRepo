package creditcustomer_fundTransfer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase6 {

	public static void main(String[] args) throws Exception{
		
		// TODO Auto-generated method stub
		// Launching new browser
		WebDriver driver=WebDriverManager.chromedriver().create();
				// Launching application
				driver.get("http://rmgtestingserver/domain/Online_Banking_System");
				
				// Entering implicitlywait
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				//Window Maximization
				driver.manage().window().maximize();
				
				//verifying the application home page
				String title = driver.getTitle();
				if(title.contains("Online Banking System"))
				{
					System.out.println("Application Home page is displaying");
				}
				else
				{
					System.out.println("Application Home page is not displaying");
				}
				
				// click on open account button
				WebElement Open_account = driver.findElement(By.xpath("//a[@href='customer_reg_form.php']"));
				Open_account.click();
				
				//verifying the Online account opening form
				title = driver.getTitle();
				if(title.contains("Registration Form"))
				{
					System.out.println("Online account opening form is displayed");
					
				}
				else
				{
					System.out.println("Online account opening form is not displayed");
					
				}
				
				// Entering Name into the Name textfield
				String Name="Praveen";
				driver.findElement(By.name("name")).sendKeys(Name);
				
				// Selecting Gender in Gender dropdown
				WebElement dopdown = driver.findElement(By.name("gender"));       
				Select slc=new Select(dopdown);                                  
				slc.selectByVisibleText("Male");                                 
				
				// Entering Mobile Number into the Mobile Number textfield
				String Mobile="0123456789";
				driver.findElement(By.name("mobile")).sendKeys(Mobile);
				
				// Entering Email_id into the Email_id textfield
				driver.findElement(By.name("email")).sendKeys("0123456789");
				
				// Entering Landline Number into the Landline Number textfield
				driver.findElement(By.name("landline")).sendKeys("0123456789");
				
				// Entering Date of Birth into the Date of Birth textfield
				WebElement DOB = driver.findElement(By.name("dob")); 			  
				DOB.click();
				String Day="01";
				String Mon="06";
				String Year="1995";
				DOB.sendKeys(Day);
				DOB.sendKeys(Mon);
				DOB.sendKeys(Year);
				
				// Entering Pan Number into the Pan textfield
				String Pan="1234567";                                             
				driver.findElement(By.name("pan_no")).sendKeys(Pan); 
				
				// Entering Citizenship Number into the Citizenship Number textfield
				driver.findElement(By.name("citizenship")).sendKeys("456123"); 
				
				// Entering Home Address into the Home Address textfield
				driver.findElement(By.name("homeaddrs")).sendKeys("a"); 
				
				// Entering Office Address into the Office Address textfield
				driver.findElement(By.name("officeaddrs")).sendKeys("b"); 
				
				// Selecting State in State dropdown
				dopdown = driver.findElement(By.name("state"));                     
				slc=new Select(dopdown);                                            
				slc.selectByVisibleText("Texas");                                    
				
				// Selecting City in City dropdown
				dopdown = driver.findElement(By.name("city"));   					 
				slc=new Select(dopdown);                                      		 
				slc.selectByVisibleText("Dallas");                                   
				
				// Entering PinCode into the Pin textfield
				driver.findElement(By.name("pin")).sendKeys("561123");
				
				// Entering Location into the Location textfield
				driver.findElement(By.name("arealoc")).sendKeys("ab"); 
				
				// Entering Nominee Name into the Nominee Name textfield
				driver.findElement(By.name("nominee_name")).sendKeys("abc"); 
				
				// Entering Nominee Account Number into the Nominee Account textfield
				driver.findElement(By.name("nominee_ac_no")).sendKeys("123456789012");
				
				// Selecting Account type in Account type dropdown
				dopdown = driver.findElement(By.name("acctype"));   					 
				slc=new Select(dopdown);                                      		 	
				slc.selectByVisibleText("Saving"); 
				
				//Click on submit Button
				driver.findElement(By.name("submit")).click(); 
				
				// Verifying Confirm page is displaying
				title=driver.getTitle();
				if(title.contains("Confirm"))
				{
					System.out.println("Confirm page is displaying");
					
				}
				else
				{
					System.out.println("Confirm page is not displaying");
					
				}
				
				//Click on Confirm_submit Button
				driver.findElement(By.name("cnfrm-submit")).click(); 
				
				// Verifying Application submitted successfully popup is displaying
				Alert alrt = driver.switchTo().alert();
				String text = alrt.getText();
				if (text.contains("Application submitted successfully"))
				{
					System.out.println("Application submitted successfully popup is displaying");
				}
				else
				{
					System.out.println("Application submitted successfully popup is not displaying");
				}
				
				// Initializing the variable using Application no
				String [] arr=text.split(" ");
				String Acno=arr[5].substring(0, 9);
				
				// Click on the OK in the alert popup
				alrt.accept();
				
				//verifying the application home page
				title = driver.getTitle();
				if(title.contains("Online Banking System"))
				{
					System.out.println("Application Home page is displaying");
				}
				else{
					System.out.println("Application Home page is not displaying");
				}
				
				//Click on Staff login_button
				driver.findElement(By.linkText("Staff Login")).click();
				
				//Verifying staff home page is displaying
				title = driver.getTitle();
				if(title.contains("Staff"))
				{
					System.out.println("Staff login page is displaying");
				}
				else
				{
					System.out.println("Staff login page is not displaying");
				}
				
				// Entering Staff Id into the Staff Id textfield
				driver.findElement(By.name("staff_id")).sendKeys("210001");
				
				// Entering Password into the Password textfield
				driver.findElement(By.name("password")).sendKeys("password");
				
				//Click on login button
				driver.findElement(By.name("staff_login-btn")).click();
				
				//Verifying staff home page is displaying
				title = driver.getTitle();
				if(title.contains("Staff Home"))
				{
					System.out.println("Staff Home page is displaying");
				}
				else
				{
					System.out.println("Staff Home page is not displaying");
				}
				
				//Click on Approve Account 
				driver.findElement(By.name("apprvac")).click();
				
				//Verifying Pending Customers page is displaying
				title = driver.getTitle();
				
				if(title.contains("Pending Customers"))
				{
					System.out.println("Pending Customers page is displaying");
				}
				else
				{
					System.out.println("Pending Customers page is not displaying");
				}
				
				//Entering application number into the application number textfield
				driver.findElement(By.name("application_no")).click();
				driver.findElement(By.name("application_no")).sendKeys(Acno);
				
				//Click on search button
				driver.findElement(By.name("search_application")).click();
				
				//Verifying Pending Customers page is displaying
				title = driver.getTitle();
				if(title.contains("Pending Customers"))
				{
					System.out.println("Pending Customers page is displaying");
				}
				else
				{
					System.out.println("Pending Customers page is not displaying");
				}
				
				// Click on approve button
				driver.findElement(By.name("approve_cust")).click();
				
				//Verifying account created successfully popup is displaying
				alrt = driver.switchTo().alert();
				text = alrt.getText();
				if (text.contains("Account Created Successfully"))
				{
					System.out.println("Account created successfully popup is displaying");
				}
				else
				{
					System.out.println("Account created successfully popup is not displaying");
				}
				
				// Initializing the variable using Account no
				arr=text.split(" ");
				Acno=arr[4].substring(1,14);
				
				// Click on the OK in the alert popup
			    alrt.accept();
			    
			    //Verifying staff home page is displaying
			  	title = driver.getTitle();
			  	if(title.contains("Staff"))
			  	{
			  		System.out.println("Staff Home page is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Staff Home page is not displaying");
			  	}
				
			    //Click on login button
			  	driver.findElement(By.name("logout_btn")).click();
			  	
			    //Verifying staff home page is displaying
			    title = driver.getTitle();
			  	if(title.contains("Staff"))
			  	{
			  		System.out.println("Staff login page is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Staff login page is not displaying");
			  	}
			  	
			  	//Click on login button
			  	driver.findElement(By.linkText("Home")).click();
			  	
			    //verifying the application home page
			  	title = driver.getTitle();
			  	if(title.contains("Online Banking System"))
			  	{
			  		System.out.println("Application Home page is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Application Home page is not displaying");
			  	}
			  	
			  	//Click on apply debit card button
			  	driver.findElement(By.xpath("//a[@href='debit_card_form.php']")).click();
			  	
			  	//verifying the application home page
			  	title = driver.getTitle();
			  	if(title.contains("Apply Debit Card"))
			  	{
			  		System.out.println("Apply Debit Card page is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Apply Debit Card page is not displaying");
			  	}
			  	
			    // Entering Account Holder Name into the Account Holder Name textfield
			  	driver.findElement(By.name("holder_name")).sendKeys(Name);
			  	
			    // Entering Date of Birth into the Date of Birth textfield
			  	DOB=driver.findElement(By.name("dob"));
			  	DOB.click();
			  	DOB.sendKeys(Day);
			  	DOB.sendKeys(Mon);
			  	DOB.sendKeys(Year);
			  	
			    // Entering Pan Number into the Pan textfield
			  	driver.findElement(By.name("pan")).sendKeys(Pan);
			  	
			  	// Entering Mobile Number into the Mobile Number textfield
			  	driver.findElement(By.name("mob")).sendKeys(Mobile);
			  	
			    // Entering Account Number into the Account Number textfield
			  	driver.findElement(By.name("acc_no")).sendKeys(Acno);
			  	
			  	// Click on Submit buttun
			  	driver.findElement(By.name("dbt_crd_submit")).click();
			  	
			    //Verifying Debit Card issued successfully popup is displaying
			    alrt = driver.switchTo().alert();
			  	text = alrt.getText();
			  	if (text.contains("Debit Card issued successfully"))
			  	{
			  		System.out.println("Debit Card issued successfully popup is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Debit Card issued successfully popup is not displaying");
			  	}
			  		
			  	// Initializing the variable using Account no
			  	arr=text.split(" ");
			  	String D_card_no=arr[17];
			  	String Pin=arr[22];
			  		
			  	// Click on the OK in the alert popup
			  	alrt.accept();
			  	
			    //Click on Home button
			  	driver.findElement(By.linkText("Home")).click();
			  	
			    //verifying the application home page
			  	title = driver.getTitle();
			  	if(title.contains("Online Banking System"))
			  	{
			  		System.out.println("Application Home page is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Application Home page is not displaying");
			  	}
			  	
			  	//Scrolling to the Internet banking button
			  	WebElement ele = driver.findElement(By.xpath("//div[@class='ebanking']"));
			  	JavascriptExecutor js=(JavascriptExecutor) driver;
			  	js.executeScript("arguments[0].scrollIntoView();", ele);
			  	
			    //Mouse hover on Internet banking button
			  	Actions act=new Actions(driver);
			  	act.moveToElement(ele).perform();
			  	
			  	//Click on Register button
			  	driver.findElement(By.xpath("//a[@href='ebanking_reg_form.php']")).click();
			  	
			  	//verifying the Internet Banking Registration page
			  	title = driver.getTitle();
			  	if(title.contains("Internet Banking Registration"))
			  	{
			  		System.out.println("Internet Banking Registration page is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Internet Banking Registration page is not displaying");
			  	}
			  	
			  	//Entering Account Holder Name into Account Holder Name text field
			  	driver.findElement(By.name("holder_name")).sendKeys(Name);
			  	
			    //Entering Account Number into Account Number text field
			  	driver.findElement(By.name("accnum")).sendKeys(Acno);
			  	
			  	//Entering Debit Card Number into Debit Card Number text field
			  	driver.findElement(By.name("dbtcard")).sendKeys(D_card_no);
			  	
			  	//Entering Debit Card Pin into Debit Card Pin text field
			  	driver.findElement(By.name("dbtpin")).sendKeys(Pin);
			  	
			  	//Entering Registered Mobile Number into Registered Mobile Number text field
			  	driver.findElement(By.name("mobile")).sendKeys(Mobile);
			  	
			    //Entering PAN Number into PAN Number text field
			  	driver.findElement(By.name("pan_no")).sendKeys(Pan);
			  	
			  	//Entering Date of Birth into Date of Birth text field
			  	DOB=driver.findElement(By.name("dob"));
			  	DOB.click();
			  	DOB.sendKeys(Day);
			  	DOB.sendKeys(Mon);
			  	DOB.sendKeys(Year);
			  	
			  	//Entering PAN Number into PAN Number text field
			  	String Last="0";
			  	driver.findElement(By.name("last_trans")).sendKeys(Last);
			  	
			    //Entering Password into Password text field
			  	String Password="Praveen";
			  	driver.findElement(By.name("password")).sendKeys(Password);
			  	
			    //Entering Password into Confirm Password text field
			  	driver.findElement(By.name("cnfrm_password")).sendKeys(Password);
			  	
			  	//Click on Submit button
			  	driver.findElement(By.name("submit")).click();
			  	
			  	//Verifying Debit Card issued successfully popup is displaying
			    alrt = driver.switchTo().alert();
			  	text = alrt.getText();
			  	if (text.contains("Registration Successfull"))
			  	{
			  		System.out.println("Registration Successfull popup is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Registration Successfull popup is not displaying");
			  	}
			  		
			  	// Initializing the variable using Account no
				arr=text.split(" ");
				String Cust_id=arr[4];
				
			  	// Click on Ok in Debit Card issued successfully popup
				alrt.accept();
				
				//verifying the Internet Banking Registration page
			  	title = driver.getTitle();
			  	if(title.contains("Internet Banking Registration"))
			  	{
			  		System.out.println("Internet Banking Registration page is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Internet Banking Registration page is not displaying");
			  	}
			  	
			    //Click on Home button
			  	driver.findElement(By.linkText("Home")).click();
			  	
			    //verifying the application home page
			  	title = driver.getTitle();
			  	if(title.contains("Online Banking System"))
			  	{
			  		System.out.println("Application Home page is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Application Home page is not displaying");
			  	}
			  	
				//Scrolling to the Internet banking button
			  	ele = driver.findElement(By.xpath("//div[@class='ebanking']"));
			  	js=(JavascriptExecutor) driver;
			  	js.executeScript("arguments[0].scrollIntoView();", ele);
			  	
			    //Mouse hover on Internet banking button
			  	act=new Actions(driver);
			  	act.moveToElement(ele).perform();
			  	
			  	//Click on Login button
			  	driver.findElement(By.xpath("//a[@href='customer_login.php']")).click();
			  	
			  	//verifying the Internet Banking Registration page
			  	title = driver.getTitle();
			  	if(title.contains("Login Page"))
			  	{
			  		System.out.println("Login Page page is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Login Page page is not displaying");
			  	}
			  	
			  	//Entering Customer ID into Customer ID text field
			  	driver.findElement(By.name("customer_id")).sendKeys(Cust_id);
			  	
			  	//Entering Customer ID into Customer ID text field
			  	driver.findElement(By.name("password")).sendKeys(Password);
			  	
			  	//Click on Login button
				driver.findElement(By.name("login-btn")).click();
				
				//verifying the Internet Banking Registration page
			  	title = driver.getTitle();
			  	if(title.contains("My Profile"))
			  	{
			  		System.out.println("My Profile page is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("My Profile page is not displaying");
			  	}
			  	
			    //Click on Change Password button
			  	driver.findElement(By.xpath("//div[@class=\"profile_nav\"]//a[3]/li")).click();
			  	
			  	//verifying the Change Password page
			  	title = driver.getTitle();
			  	if(title.contains("Change Password"))
			  	{
			  		System.out.println("Change Password page is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Change Password page is not displaying");
			  	}
			  	
			    //Entering Password into Old Password text field
			  	driver.findElement(By.name("oldpass")).sendKeys(Password);
			  	
			  	//Entering Password into confirm Old Password text field
			  	driver.findElement(By.name("cnfrm")).sendKeys(Password);
			  	
			  	//Entering Password into new Password text field
			  	Password="PraveenP";
			  	driver.findElement(By.name("newpass")).sendKeys(Password);
			  	
			  	//Click on Change Password button
			  	driver.findElement(By.name("change_pass")).click();
			  	
			    //Verifying Password Changed successfully popup is displaying
			    alrt = driver.switchTo().alert();
			  	text = alrt.getText();
			  	if (text.contains("Password Changed"))
			  	{
			  		System.out.println("Password Changed successfully popup is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Password Changed successfully popup is not displaying");
			  	}
			  	
			  	//Click on OK in Password Changed successfully popup
			  	alrt.accept();
			  	
			    //verifying the Change Password page
			  	title = driver.getTitle();
			  	if(title.contains("Change Password"))
			  	{
			  		System.out.println("Change Password page is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Change Password page is not displaying");
			  	}
			  	
			    //Click on Logout Button
			  	driver.findElement(By.name("logout_btn")).click();
			  	
			  //verifying the Internet Banking Registration page
			  	title = driver.getTitle();
			  	if(title.contains("Login Page"))
			  	{
			  		System.out.println("Login Page page is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("Login Page page is not displaying");
			  	}
			  	
			  	//Entering Customer ID into Customer ID text field
			  	driver.findElement(By.name("customer_id")).sendKeys(Cust_id);
			  	
			  	//Entering Customer ID into Customer ID text field
			  	driver.findElement(By.name("password")).sendKeys(Password);
			  	
			  	//Click on Login button
				driver.findElement(By.name("login-btn")).click();
				
				//verifying the Internet Banking Registration page
			  	title = driver.getTitle();
			  	if(title.contains("My Profile"))
			  	{
			  		System.out.println("My Profile page is displaying");
			  	}
			  	else
			  	{
			  		System.out.println("My Profile page is not displaying");
			  	}
			  	
			  	driver.quit();
			  	
			}
}