package appleOnlinePrices;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class multipleTabwindows {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.bankofbaroda.com/");
		
		Set<String> winids = driver.getWindowHandles();
		Iterator<String> iterate = winids.iterator();
		
		System.out.println(iterate.next()); //first window(main)
		
		
//		driver.findElement(By.xpath("html/body/map[2]/area[1]")).click();
		driver.findElement(By.xpath("//img[@src='images/OnlineServices1-bg.gif']")).click();
		System.out.println("-------After the new tab is opened--------");
		
		winids = driver.getWindowHandles();
		iterate = winids.iterator();
		String firstwindow=iterate.next(); //window id of the main window
		String tabwindow=iterate.next(); //window id of the tab window
		
		//main tab
		System.out.println(firstwindow);
		
		//tabbed window
		System.out.println(tabwindow);
		
		
		//switch to the tab window
		
		driver.switchTo().window(tabwindow);
	
	//	driver.findElement(By.xpath("html/body/table[3]/tbody/tr/td/table/tbody/tr/td[2]/form/select")).sendKeys("India");
		driver.findElement(By.xpath("//select[@name='go']")).sendKeys("India");
		//driver.findElement(By.xpath("html/body/table[3]/tbody/tr/td/table/tbody/tr/td[2]")).click();
		driver.findElement(By.xpath("//img[@src='images/blank.gif']")).click();
		
		Thread.sleep(3000L);
	

		driver.findElement(By.xpath("//a[contains(@href,'http://www.bankofbaroda.com/epayment/default.asp')]")).click();
		winids = driver.getWindowHandles();
		iterate = winids.iterator();
		System.out.println("---------After the Second popup is clicked---------");
		System.out.println(iterate.next()); //main window
		System.out.println(iterate.next()); //tabbed window
		String pop_up=iterate.next();
		System.out.println("3rd pop up: "+pop_up); //pop up
		
		//Thread.sleep(3000L);
		driver.switchTo().window(pop_up); //3rd pop up window
		//Thread.sleep(3000L);
		driver.findElement(By.xpath("//select[@name='go']")).sendKeys("PERSONAL");
		//Thread.sleep(3000L);
		driver.close(); // latest window pop up
		driver.switchTo().window(tabwindow);
		driver.close();
		driver.switchTo().window(firstwindow);
		driver.close();
		
	}

}
