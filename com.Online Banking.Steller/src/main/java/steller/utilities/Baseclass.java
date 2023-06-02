package steller.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.steller.objectrepository.Staffloginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public Excelutility exutil=new Excelutility();
	public Fileutility futil=new Fileutility();
	public Webutility wutil=new Webutility();
	public Javautility jutil=new Javautility();
	public static WebDriver sdriver;
      public  WebDriver driver;
	@BeforeSuite
	public void config_BS(){
		
	System.out.println("connection to db");	
	}
	@AfterSuite(groups = {"smokeTest","regTest"})
	public void config_AS(){
		
		System.out.println("close connection with db");
		
	}
//@Parameters ("BROWSER")
	@BeforeClass(groups= {"smokeTest","regTest"})
	public void config_BC() throws IOException {
		String  BROWSER=futil.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();	
		}
		else if(BROWSER.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
			sdriver=driver;
			driver=new ChromeDriver();
		wutil.maximizeWindow(driver);
		
	}
	//close the browser
	@AfterClass(groups= {"smokeTest","regTest"})
	public void config_AC(){
		//driver.quit();
		
	}
	//login to app
	@BeforeMethod(groups= {"smokeTest","regTest"})
	public void config_BM() throws IOException {
	String URL=futil.getPropertyKeyValue("url");
	driver.get(URL);
	wutil.waitTillPageGetLoad(driver);
	
	}
	
	
	}
	
		
	


