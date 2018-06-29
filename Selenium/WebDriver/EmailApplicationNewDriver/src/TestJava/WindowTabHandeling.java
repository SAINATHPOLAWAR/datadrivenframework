package TestJava;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowTabHandeling {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		 System.setProperty("webdriver.gecko.driver", "D://geckodriver.exe");
		 //gecko.driver
		
		driver = new FirefoxDriver ();
		
		driver.get("https://www.bankofbaroda.co.in/");
		
		driver.manage().window().maximize();
		
		Set<String> window1 = driver.getWindowHandles();
		Iterator<String> itwindow = window1.iterator();
		
		System.out.println(itwindow.next());
		
		//4294967297

	}

}
