package POM;


import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import POM.BrowserOpen;
import B2B.ExcelReader;


public class B2BOrderPlace {
	
	public static int i;
	//public static WebBrowserOpen.driver BrowserOpen.driver;
	public static ExcelReader excel = new ExcelReader("D:\\Selenium\\WebDriver\\EmailApplication\\src\\B2B Orders1.xlsx");
	public static XSSFSheet priceSheet;
	public static int rowStart = Math.min(2, 2);
	public static int rowEnd = Math.max(2, 2);
	public static int j = rowStart;
	public static Select dropdown, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5;
	
	
	public static void BuildYourQuote() throws InterruptedException{
		  
	  BrowserOpen.driver.manage().timeouts().pageLoadTimeout(1000L, TimeUnit.SECONDS);
	   BrowserOpen.driver.manage().timeouts().implicitlyWait(1000L, TimeUnit.SECONDS); 
	 	    
	    for (j = rowStart; j <= rowEnd;	j++) {
	    	
	    
	    Thread.sleep(5000L);
	    
	    //Build Your Quote
	    
	    dropdown = new Select(BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_B2BModel_ddlProduct")));
	    
	    dropdown.selectByVisibleText(excel.getCellData("Sheet1", "Select Product", j));   
	    
	    	    
	    Thread.sleep(200L);
    	dropdown = new Select(BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_B2BModel_ddlModel")));
    	dropdown.selectByVisibleText(excel.getCellData("Sheet1", "Select Model", j));
    	Thread.sleep(200L);
    	BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_B2BModel_ddlCapacity")).sendKeys(excel.getCellData("Sheet1", "Select Memory Size", j));
    	Thread.sleep(200L);
    	BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_B2BModel_txtQuantity")).sendKeys(excel.getCellData("Sheet1", "Select Quantity", j));
    	Thread.sleep(200L);
    	BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_BtnAddMoreDevice")).click();
    	Thread.sleep(2000L);
    	//if (BrowserOpen.driver.getCurrentUrl().equals("https://qa-appleb2bonlineuk.brightstar.com/#!")) {    		
    	BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_BtnGetQuote")).click();	        	
        Thread.sleep(200L);
    	//}
        
        //Quote Summary
    	Thread.sleep(1000);
    	BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_BtnGetQuote")).click();
    	BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_BtnProceed")).click();
    	
    	
    	Thread.sleep(2000L);
    	JavascriptExecutor jse3 = (JavascriptExecutor)BrowserOpen.driver;
		jse3.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000L);
    	BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_TxtEmail")).sendKeys(excel.getCellData("Sheet1", "Email", j));
    	Thread.sleep(2000L);
    	BrowserOpen.driver.findElement(By.xpath("//*[@id='aspnetForm']/section/div[2]/div[5]")).click();
    	Thread.sleep(4000L);
    	BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_BtnNext")).click();    
    	Thread.sleep(6000L);
    	BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_BtnNewQuote")).click();
    	    
    	continue;
	    }	
		

	}
	
public static void Login () throws InterruptedException {
		
		BrowserOpen.driver.findElement(By.xpath("//*[@id='Header_section']/li[2]/a")).click();
		Thread.sleep(2000L);
		BrowserOpen.driver.findElement(By.id("txtSignInEmail")).sendKeys(excel.getCellData("Sheet1", "Email", j));
	}
	
	}

