package appleOnlinePrices;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class web_windows {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://icicibank.com");
		
		Thread.sleep(15000L);
		Set<String> winids = driver.getWindowHandles();
		Iterator<String> iterate = winids.iterator();
		
		System.out.println(iterate.next()); //first window(main)
		
		
		driver.findElement(By.xpath("//*[@id='footer_links']/a[1]")).click();
		
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
		driver.findElement(By.linkText("Grouping Current Account")).click();
		
		System.out.println("-------After the new pdf popup is opened--------");
		winids = driver.getWindowHandles();
		iterate = winids.iterator();
		
		System.out.println(iterate.next()); //main window
		System.out.println(iterate.next()); //tabbed window
		String pop_up=iterate.next();
		System.out.println(pop_up); //pop up
		
		Thread.sleep(3000L);
		driver.switchTo().window(pop_up);
		
		driver.close(); // latest window pop up
		driver.switchTo().window(tabwindow);
		driver.close();
		driver.switchTo().window(firstwindow);
		driver.close();
		
	}

}
