package B2B;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestB2b {
	
	public static WebDriver driver;
	public static int i,j;
	public static ExcelReader excel = new ExcelReader("D:\\Selenium\\WebDriver\\EmailApplication\\src\\B2B Orders.xlsx");
	public static XSSFSheet priceSheet;
	public static int rowStart, rowEnd;
	public static Select dropdown, dropdown1, dropdown2, dropdown3, dropdown4, dropdown5;
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new FirefoxDriver ();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(1000L, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1000L, TimeUnit.SECONDS);
		
		driver.get("https://qa-appleb2bonlineuk.brightstar.com");
		
		
		
		rowStart = Math.min(2, 10);
	    rowEnd = Math.max(2, 2);
	    
	    j = rowStart;
	    
	    Thread.sleep(5000L);
	    
	    dropdown = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_B2BModel_ddlProduct")));
	    
	    dropdown.selectByVisibleText(excel.getCellData("Sheet1", "Select Product", j));
	    
	    
	    
	    //driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_B2BModel_ddlProduct")).sendKeys(excel.getCellData("Sheet1", "Select Product", j));
    	//Thread.sleep(200L);
    	//driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_B2BModel_ddlBrand")).sendKeys(excel.getCellData("Sheet1", "Select Brand", j));
    	Thread.sleep(2000L);
    	dropdown = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_B2BModel_ddlModel")));
    	dropdown.selectByVisibleText(excel.getCellData("Sheet1", "Select Model", j));
    	Thread.sleep(2000L);
    	driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_B2BModel_ddlCapacity")).sendKeys(excel.getCellData("Sheet1", "Select Memory Size", j));
    	Thread.sleep(2000L);
    	driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_B2BModel_txtQuantity")).sendKeys(excel.getCellData("Sheet1", "Select Quantity", j));
    	//driver.findElement(By.id("aspnetForm']/section")).click();
    	//JavascriptExecutor jse4 = (JavascriptExecutor)driver;
    	//jse4.executeScript("window.scrollBy(0,250)", "");
    	Thread.sleep(2000L);
    	driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_BtnAddMoreDevice")).click();
    	//Thread.sleep(200L);
    	//driver.findElement(By.id("aspnetForm']/section")).click();
    	Thread.sleep(5000L);
    	if (driver.getCurrentUrl().equals("https://qa-appleb2bonlineuk.brightstar.com/#!")) {
    		System.out.println("Get Quote");    		
    		driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_BtnGetQuote")).click();	        	
        	Thread.sleep(200L);
    	}
    	Thread.sleep(10000L);
    	driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_BtnGetQuote")).click();
    	driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_BtnProceed")).click();
    	
    	
    	Thread.sleep(2000L);
    	JavascriptExecutor jse3 = (JavascriptExecutor)driver;
		jse3.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000L);
    	driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_TxtEmail")).sendKeys(excel.getCellData("Sheet1", "Email", j));
    	Thread.sleep(2000L);
    	driver.findElement(By.xpath("//*[@id='aspnetForm']/section/div[2]/div[5]")).click();
    	Thread.sleep(4000L);
    	driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_BtnNext")).click();    
    	//Thread.sleep(5000L);
    	//driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_BtnNewQuote"));

	}

}
