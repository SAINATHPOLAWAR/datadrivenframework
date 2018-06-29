package TestJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import POM.BrowserOpen;

public class SliderMovement {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.gecko.driver", "D://geckodriver.exe");
		 //gecko.driver
		
		driver = new FirefoxDriver ();
		
		driver.get("https://qa-appleb2bonlineuk.brightstar.com/Login.aspx#!");
		
		Thread.sleep(2000L);
		
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("txtSignInEmail")).sendKeys("sainath@veridic.in");
		driver.findElement(By.id("txtPassword")).sendKeys("mpx@1234");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(5000L);
		
	WebElement scroller = driver.findElement(By.xpath("//*[@id='mCSB_4_dragger_vertical']"));
		
		Actions scroller1 = new Actions(driver);
		Thread.sleep(6000L);
		scroller1.dragAndDropBy(scroller, 0, 150).perform();

	}

}
