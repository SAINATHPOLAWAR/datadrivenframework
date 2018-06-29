package B2B;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;


public class B2B {

	public static ExcelReader b2bExcel;
	public static String Fullprice;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	WebDriver driver = new FirefoxDriver ();
		driver.manage().window().maximize();
		
	
		
		driver.manage().timeouts().pageLoadTimeout(1000L, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1000L, TimeUnit.SECONDS);
		
		
	b2bExcel = new ExcelReader("D:\\Selenium\\Appleprices\\src\\b2B.xlsx");
	
	driver.get(b2bExcel.getCellData("Sheet1", "URL", 2));
	
	System.out.println("1.Entered URL from Excel");
	
	int rowStart = Math.min(2, 2);
    int rowEnd = Math.max(2, 115);
	
	
	for (int j = rowStart; j <= rowEnd;	j++) {
		
		Thread.sleep(2000L);
		
		System.out.println("2.Enter in to loop");
		
		
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder_Content2_B2BModel_ddlProduct']")).sendKeys(b2bExcel.getCellData("Sheet2", "Product", j));
			System.out.println("3.Product selected");
			Thread.sleep(2000L);
			driver.findElement(By.xpath("//*[@id='aspnetForm']/section/div[1]/section[2]/div")).click();
			Thread.sleep(3000L);
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder_Content2_B2BModel_ddlModel']")).sendKeys(b2bExcel.getCellData("Sheet2", "Model", j));
			System.out.println("4.Model selected");
			Thread.sleep(3000L);
			driver.findElement(By.xpath("//*[@id='aspnetForm']/section/div[1]/section[2]/div")).click();
			Thread.sleep(3000L);
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder_Content2_B2BModel_ddlCapacity']")).sendKeys(b2bExcel.getCellData("Sheet2", "Capacity", j));
			System.out.println("5.Capacity selected");
			Thread.sleep(2000L);
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder_Content2_B2BModel_txtQuantity']")).sendKeys(b2bExcel.getCellData("Sheet2", "Quantity", j));
			System.out.println("6.Quantity selected");
			Thread.sleep(2000L);
			driver.findElement(By.xpath("//*[@id='aspnetForm']/section/div[1]/section[2]/div")).click();
			Thread.sleep(2000L);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder_Content2_BtnAddMoreDevice']")).click();
			Thread.sleep(2000L);
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder_Content2_BtnGetQuote']")).click();
			Thread.sleep(2000L);
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder_Content2_BtnGetQuote']")).click();
			Thread.sleep(2000L);
		
			
			Fullprice = driver.findElement(By.xpath(".//*[@id='aspnetForm']/section/div[2]/div[3]/div[2]/table/tbody/tr[2]/td[5]")).getText();
			Thread.sleep(2000L);
			
			b2bExcel.setCellData("Sheet2", "Price", j, Fullprice);
			
			System.out.println("7.Full price printed");
			
			driver.findElement(By.xpath("//*[@id='aspnetForm']/nav/div/div[1]/a/img")).click();
			
			
			Thread.sleep(2000L);
			
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder_Content2_rptDeviceDetails_ctl01_BtnDeleteDeviceDetail']")).click();
			
			continue;
			
			
			
		
		
	}
	

	

		
	}
		

}
