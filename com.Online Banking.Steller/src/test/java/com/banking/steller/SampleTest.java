package com.banking.steller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
@Test
public void fetch()
	{
	WebDriver driver;
	String BROWSER=System.getProperty("Browser");
		
	String URL=System.getProperty("Url");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}   
	else if (BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
	}
	else {
		WebDriverManager.edgedriver().setup();
	}

}
}
