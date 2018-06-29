package appleOnlinePrices;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import appleOnlinePrices.ExcelReader;

public class AppleUKConsumer_MAC_113 {
	
	//Non-Portable
	
	public static int i,j;
	public static WebDriver driver;
	public static ExcelReader MACExcel;
	public static String Handsetidentity, deviceVlauecheck, DamagedVlauecheck;
	public static XSSFSheet priceSheet;
	public static  boolean existFromLoop;
	public static XSSFWorkbook NonIosPrices;
	public static int rowStart, rowEnd;
	

	public static void main(String[] args) throws InterruptedException, IOException {
				
		
		
		driver = new FirefoxDriver ();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 1000L);
	
		driver.get("https://qa-appleonline.mpxltd.co.uk");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(1000L, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50L, TimeUnit.SECONDS);
		
		
		//Excel Reader
		ExcelReader MACExcel = new ExcelReader("D:\\Selenium\\WebDriver\\AppleOnline\\src\\appleOnlinePrices\\113.xlsx");
			
		//Open Excel
		XSSFWorkbook MACPrices = new XSSFWorkbook("D:\\Selenium\\WebDriver\\AppleOnline\\src\\appleOnlinePrices\\113.xlsx");
		XSSFSheet priceSheet = MACPrices.getSheet("MAC");
		
		
		
		int rowCount = Math.min(2, priceSheet.getFirstRowNum())-Math.max(2, priceSheet.getLastRowNum());
		
		System.out.println("Total " + rowCount);
		
		int rowStart = Math.min(69, 69);
	    int rowEnd = Math.max(2, 77);
	    
	    //boolean exitFromLoop = false;
	    
	    for (j = rowStart; j<= rowEnd;	j++)
	    	
	    	{	
	    	
	    	//XSSFRow row = priceSheet.getRow(j); 
			    
	    	driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtIMEIVal")).sendKeys(MACExcel.getCellData("MAC", "Serial Number", j));
	        
	        driver.findElement(By.id("ctl00_ContentPlaceHolder1_imeiValidate")).click();	
	        
	       Thread.sleep(10000L);	        
	        	        		        	        
		        if (driver.getCurrentUrl().equals("https://qa-appleonline.mpxltd.co.uk/")
		        		
		        		|driver.getCurrentUrl().equals("https://qa-appleonline.mpxltd.co.uk/search.aspx"))		
		        	
		        	   	{
		        	Thread.sleep(2000L);
		        	if(driver.findElement(By.xpath("//*[@id='txtSearchValidation']")).isDisplayed())
        			{
	        		
	        		System.out.println("Error On Apple Renew Page");
	        		
		        	Thread.sleep(2000);
		        	
		        	System.out.println(MACExcel.getCellData("MAC", "Serial Number", j)+ "       " + "Reason :  "+ driver.findElement(By.id("errorMsg")).getText());
		        	
		        	driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtIMEIVal")).clear(); 
		        	
		        	       	continue;
	        			}
		        
		        	Thread.sleep(2000L);
		        	
		        	if (driver.findElement(By.xpath("//*[@id='MACProceedBox']/div[2]/div")).getText().contains("Please select the following to search the device.")) {
		        		
		        		
		        		System.out.println("Enter in MAC Condition");
		        		
		        	driver.findElement(By.xpath("//*[@id='MACProceedBox']/div[2]/div/div[2]")).click();
		        	Thread.sleep(1000L);
		        	
		        	Select Category = new Select (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_drpdwn_Category']")));
		        	Category.selectByValue(MACExcel.getCellData("MAC", "Model", j));		        		
			        Thread.sleep(2000L);
			        
			        driver.findElement(By.xpath("//*[@id='MACProceedBox']/div[2]/div/div[2]")).click();
			        
			        Thread.sleep(8000L);
			        
			        if (driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpdwn_screensize")).isEnabled()) {
			        	
			        	System.out.println("In Screen Size");			        	
			        	
			        	driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpdwn_screensize")).sendKeys(MACExcel.getCellData("MAC", "ScreenSize", j));
			        	
			        	Thread.sleep(1000L);
				        
				        driver.findElement(By.xpath("//*[@id='MACProceedBox']/div[2]/div/div[2]")).click();
				        
				        Thread.sleep(8000L);
				        
			        }
				        driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_drpdwn_Year']")).sendKeys(MACExcel.getCellData("MAC", "Year", j));
				        //Thread.sleep(1000L);
				        
				        driver.findElement(By.xpath("//*[@id='MACProceedBox']/div[2]/div/div[2]")).click();
				        Thread.sleep(1000L);
				        
				        driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_drpdwn_Processor']")).sendKeys(MACExcel.getCellData("MAC", "Processer", j));
				        Thread.sleep(1000L);
				        
				        driver.findElement(By.xpath("//*[@id='MACProceedBox']/div[2]/div/div[2]")).click();
				        Thread.sleep(2000L);
				        
				        if (driver.findElement(By.xpath("//*[@id='MACProceedBox']/div[2]/div")).getText().contains("Select Device Model Identifier")) {
				        	
				        	System.out.println("Enter in Model Identifier");
				        	
				        	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_drpdwn_modelss']")).sendKeys(MACExcel.getCellData("MAC", "Identifier", j));
				        
				        	Thread.sleep(2000L);
				        }
				        
				        driver.findElement(By.xpath("//*[@id='MACProceedBox']/div[2]/div/div[2]")).click();
				        Thread.sleep(2000L);
				        
				        driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lnk_SearchMAC']")).click();
				        Thread.sleep(1000L);			      
			      
		        	}
	
	        }   

	        			else	{
	        				
	        				System.out.println("Entered in else condition");
	         				
	         				System.out.println(MACExcel.getCellData("MAC", "Serial Number", j)+ "       Reason :  Is Valied IMEI.");
	         			
	        	}	
		        
		        
		        
			//Image Identification		        
		        System.out.println("----------------------------------------------------------");
		        Thread.sleep(3000L);
		     /* Handsetidentity = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_imgPhone']")).getAttribute("src");
		        System.out.println(Handsetidentity);*/
				String Excelresult = MACExcel.getCellData("MAC", "Modelid", j);
				int resultValue = Integer.parseInt(Excelresult.substring(0, Excelresult.indexOf('.')));
				/*System.out.println("Present inspected Handset Model ID is : " + resultValue);
				System.out.println("Following value will be printing in Excel Sheet " + MACExcel.setCellData("MAC", "ModelResult", j, Handsetidentity));
				MACExcel.setCellData("MAC", "ModelResult", j, Boolean.toString(Handsetidentity.contains(Integer.toString(resultValue))));
				Thread.sleep(2000L);*/
				
				AppleUKConsumer_MAC_113 ColorInspection = new AppleUKConsumer_MAC_113 ();
				ColorInspection.inspection();	
					
				deviceVlauecheck = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_withoutzero3']")).getText();
				System.out.println("Full Net Price of " + " " + resultValue + "  is  " + deviceVlauecheck);
				String NetPrice = MACExcel.getCellData("MAC", "Full Net Price", j);
				//System.out.println(NetPrice);			
				int FullNetPrice = Integer.parseInt(NetPrice.substring(0, NetPrice.indexOf('.')));
				//System.out.println(FullNetPrice);
				//System.out.println(deviceVlauecheck);
				MACExcel.setCellData("MAC", "Is Price", j, deviceVlauecheck);
				
				
				//Thread.sleep(2000L);
				
				JavascriptExecutor jse1 = (JavascriptExecutor)driver;
				jse1.executeScript("window.scrollBy(0,450)", "");
				
				driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_LnkBackBtn']")).click();
				
				Thread.sleep(3000L);
				
				JavascriptExecutor jse2 = (JavascriptExecutor)driver;
				jse2.executeScript("window.scrollBy(0,450)", "");
				
				driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_reptMacSelection_ctl00_no']/span")).click();
			
				
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']")).click();
			
			DamagedVlauecheck = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_withoutzero3']")).getText();	
			System.out.println("Damaged Net Price of after fail an activity (Keyboard) " + " " + resultValue + "  is  " + DamagedVlauecheck);
			String DamagedPrice = MACExcel.getCellData("MAC", "Incomplete Net Price", j);
			//System.out.println(DamagedPrice);				
			int DamagedNetPrice = Integer.parseInt(DamagedPrice.substring(0, DamagedPrice.indexOf('.')));
			//System.out.println(DamagedNetPrice);
			MACExcel.setCellData("MAC", "Incomplete Price", j, DamagedVlauecheck);
			System.out.println("--------------------------------------------------------------");
			
			JavascriptExecutor jse3 = (JavascriptExecutor)driver;
			jse3.executeScript("window.scrollBy(0,350)", "");
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_LnkBtnDecline']")).click();
			
		}
	    	

	}
	
	
	
public static void inspection() throws InterruptedException, IOException{
		
		driver.manage().timeouts().pageLoadTimeout(100L, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);	
	
	System.out.println("Enter into inspection");
	//Inspection Activities
	
	if (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_InspectionContainer_view']")).getText().contains("Keyboard")){
		
		System.out.println("With Keyboard");
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl00_yes")).click();
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl01_yes")).click();

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl02_yes")).click();
		
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl03_yes']")).click();
			
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");	
		
		if (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_InspectionContainer_view']")).getText().contains("Display")) {
			
			System.out.println("Display found");
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl04_yes']")).click();
			
		}
		
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_reptMacSelection_ctl00_yes']")).click();
		
		jse.executeScript("window.scrollBy(0,250)", "");
			
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_reptMacSelection_ctl01_yes']")).click();
			
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_reptMacSelection_ctl02_yes']")).click();
	
	} else {
		
		System.out.println("With out Keyboard");	
	
	driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl00_yes")).click();
		
	driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl01_yes")).click();

	driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl02_yes")).click();
	
	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl03_yes']")).click();
		
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,450)", "");
	
	Thread.sleep(1000L);
	
	
	if (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_InspectionContainer_view']")).getText().contains("Display")) {
		
		System.out.println("Display found");
		
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl04_yes']")).click();
		
	}
	
	Thread.sleep(1000L);
	
	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_reptMacSelection_ctl00_yes']")).click();


	}
	
	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']")).click();
	
		}
	

}
