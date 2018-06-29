package TestJava;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DateSelection {
	
	
	static int targetdate = 0,
			targetmonth = 0,
			targetyear = 0;
	
	static int currentdate = 0,
			currentmonth = 0,
			currentyear = 0;
	
	static int jumpmonthby = 0;
	
	static boolean increment = true;

	public static void main(String[] args) throws InterruptedException {
		
		
		String DateToSet = "02/10/2018";
		
		
		getCurrentDateMonthAndYear ();
		System.out.println(currentdate + "  " + currentmonth + "   " + currentyear + "  ");
		
		GetTargetDateMonthAndYear(DateToSet);
		System.out.println(targetdate + "  "+targetmonth + "  "+targetyear);
		
		
		jumpcalculatemonths();
		System.out.println(jumpmonthby);
		System.out.println(increment);
		
		System.setProperty("webdriver.gecko.driver", "D://geckodriver.exe");
		WebDriver driver = new FirefoxDriver ();
		driver.get("https://timesheet.mpxltd.co.uk/Login.aspx");
		
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='txtLoginName']")).clear();
		
		driver.findElement(By.xpath("//*[@id='txtLoginName']")).sendKeys("E00043");
		
		driver.findElement(By.xpath("//*[@id='txtPassword']")).clear();
		
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("test123");
		driver.findElement(By.xpath("//*[@id='btnSubmit']")).click();
		Thread.sleep(5000L);
		driver.findElement(By.xpath("//*[@id='btnSubmit']")).click();
		
		driver.findElement(By.id("datepicker")).click();
		
		
		for (int i = 0; i<jumpmonthby; i++) {
			
			if (increment) {
				
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]")).click();
			}else {
				
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[1]")).click();
			}
			
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.linkText(Integer.toString(targetdate))).click();
		
		
		/*
		 * TargetDay, Month, Year
		 * CurrentDay, Month, Year
		 * Jump to the Month
		 * Increment or Decrement
		 * 
		 */
	}
	
	public static void getCurrentDateMonthAndYear () {
		
		Calendar cal = Calendar.getInstance();
		
		currentdate = cal.get(Calendar.DAY_OF_MONTH);
		currentmonth = cal.get(Calendar.MONTH)+1;
		currentyear = cal.get(Calendar.YEAR);
		
	}
	
	public static void GetTargetDateMonthAndYear (String dateString) {
		
		int firstindex = dateString.indexOf("/");
		int lastindex = dateString.lastIndexOf("/");
		
		String day = dateString.substring(0, firstindex);
		targetdate = Integer.parseInt(day);
		
		String Month = dateString.substring(firstindex+1, lastindex);
		targetmonth = Integer.parseInt(Month);
		
		String Year = dateString.substring(lastindex+1, dateString.length());
		targetyear = Integer.parseInt(Year);
		
	}
	
	public static void jumpcalculatemonths () {
		
		
		if ((targetmonth-currentmonth)>0) {
			
			jumpmonthby = (targetmonth-currentmonth);
			
		}else {
			
			jumpmonthby = (currentmonth-targetmonth);
			increment = false;
		}
		
	}

}
