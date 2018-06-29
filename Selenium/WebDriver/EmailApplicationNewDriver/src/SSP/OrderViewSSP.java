package SSP;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*import org.apache.log4j.Logger;
import org.apache.log4j.FileAppender;
import org.apache.log4j.ConsoleAppender;*/
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.google.common.base.Predicate;

import POM.BrowserOpen;
import B2B.ExcelReader;
import B2B.B2BEmailApplication;
import B2B.DbManager;

public class OrderViewSSP {

	public static ExcelReader SetinDB = new ExcelReader("D:\\Selenium\\WebDriver\\EmailApplication\\src\\qhid.xlsx");
	public static int rowStart = 2;
	/*static Logger log = Logger.getLogger(OrderViewSSP.class);
	static Logger dlog = Logger.getLogger("devpinoyLogger");*/
	 
	
	public static void SSPOrderView () throws InterruptedException{
		
		BrowserOpen.driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
		
		
		//System.out.println(BrowserOpen.driver.findElement(By.id("mCSB_4")).getText());
		
		Thread.sleep(6000L);
		
		if (BrowserOpen.driver.getCurrentUrl().equals("https://qa-appleb2bonlineuk.brightstar.com/MyQuotes.aspx#!")==true) {
			System.out.println("Page");
			
			String exc = SetinDB.getCellData("Sheet1", "QuoteHeaderID", rowStart);
			
			/*log.debug("Get from excel");
			log.info("Get from info");
			log.error("test");
			
			dlog.debug("   :Depiloyer Log 1");
			dlog.debug("   : Depiloyer Log 2");*/
				
			System.out.println(exc);	
			
		BrowserOpen.driver.findElement(By.id("TxtSearch")).sendKeys(exc);
		BrowserOpen.driver.findElement(By.xpath("//*[@id='imagesearch']")).click();
		
		
			Thread.sleep(5000L);

/*	WebElement orderslist = BrowserOpen.driver.findElement(By.xpath("//*[@id='mCSB_4_container']/div/table"));
	List <WebElement> totalorders1 =	orderslist.findElements(By.xpath("//td/span"));
	//System.out.println(totalorders.size());
	
	System.out.println(totalorders1.size());
	
	for (int i=0;i<totalorders1.size();i++) {
	    //WebElement key = BrowserOpen.driver.findElement(By.xpath("//*[@id='mCSB_4_container']/div/table/tbody/tr[ " + i+"]/td[1]/span"));
	    System.out.println(totalorders1.get(i).getText());
	}
	*/

	
	//BrowserOpen.driver.findElement(By.xpath("//*[@id='mCSB_4_container']/div/table/tbody/tr/td[1]/span")).click();
			
			
			//BrowserOpen.driver.findElement(By.xpath("//div/div/div/div/div/div/table/tbody/tr/td[@class='Stacksalign']/span"));
	
	WebElement e = 	BrowserOpen.driver.findElement(By.xpath("//div/div/div/div/div/div/table/tbody/tr/td[@class='Stacksalign']/span"));	

	
	System.out.println(e.getText());
	e.click();
			

		}
		
	}

}

