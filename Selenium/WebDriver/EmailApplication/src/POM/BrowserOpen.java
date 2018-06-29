package POM;

import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import B2B.ExcelReader;




public class BrowserOpen {
	
	//public static String M = "all Pass"; 
	public static WebDriver driver;
	public static ExcelReader url = new ExcelReader("D:\\Selenium\\WebDriver\\EmailApplication\\src\\URL.xlsx");
	public static int rowStart = 2;
	//public static String Handsetidentity, Vlauecheck, DamagedVlauecheck, DamagedVlauecheck86;
	//public static XSSFSheet priceSheet;
	//public static  boolean existFromLoop;
	//public static XSSFWorkbook NonIosPrices;
	//public static int rowStart, rowEnd;
	//public static WebElement zero;
	
	public static void Browser () throws InterruptedException{
		
		driver = new FirefoxDriver ();
		
		//WebDriverWait wait = new WebDriverWait(driver, 10000L);
		
		driver.get(url.getCellData("Sheet1", "URL", rowStart));
		driver.manage().window().maximize();
		
		
	
	}
	
	
	
	
	

}
