package steller.utilities;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author RUPA
 *
 */
public class Javautility {
	
public int getRandomNumber() {
	Random random=new Random();
	int randum=random.nextInt(1000);
	return randum;
	
}
/**
 * this method is used to get  currentsystemdate
 * @return
 */
public String currentSystemDate() {
	Date date=new Date();
	String currentdate=date.toString();
	return currentdate;
}
/**
 * 
 * @return
 */
public String getSystemDateInformat(){
	Date date=new Date();
	String cdate=date.toString();
	String[] d=cdate.split(" ");
	
int month=date.getMonth();
String week=d[0];
String cdat=d[2];
String year=d[5];
String dateFormat=month+" "+week+" "+cdat+" "+year;
return dateFormat;
}
}

