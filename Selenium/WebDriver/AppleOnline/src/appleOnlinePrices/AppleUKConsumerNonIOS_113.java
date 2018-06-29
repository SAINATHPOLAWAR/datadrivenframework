package appleOnlinePrices;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appleOnlinePrices.ExcelReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppleUKConsumerNonIOS_113 {
	
	public static int i,j;
	public static WebDriver driver;
	public static ExcelReader NonIosexcel = new ExcelReader("D:\\Selenium\\WebDriver\\AppleOnline\\src\\AppleOnlinePrices\\113.xlsx");
	public static String Handsetidentity, Vlauecheck, DamagedVlauecheck, DamagedVlauecheck486;
	public static XSSFSheet priceSheet;
	public static  boolean existFromLoop;
	public static XSSFWorkbook NonIosPrices;
	public static int rowStart, rowEnd;

	public static void main(String[] args) throws InterruptedException, IOException {
			
		driver = new FirefoxDriver ();
		
		WebDriverWait wait = new WebDriverWait(driver, 10000L);
	
		driver.get("https://qa-appleonline.mpxltd.co.uk");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10000L, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(100L, TimeUnit.SECONDS);
		
		//Excel Reader
		
		System.out.println(NonIosexcel.getCellData("NonIOS", "Channelid", 2));	
	
		XSSFWorkbook NonIosPrices = new XSSFWorkbook("D:\\Selenium\\WebDriver\\AppleOnline\\src\\AppleOnlinePrices\\113.xlsx");
		XSSFSheet priceSheet = NonIosPrices.getSheet("NonIOS");
		
		int rowCount = Math.min(2, priceSheet.getFirstRowNum())-Math.max(3, priceSheet.getLastRowNum());
		System.out.println("Total " + rowCount);
		
		int rowStart = Math.min(50, 50);
	    int rowEnd = Math.max(2, 53);
	    
	    //boolean exitFromLoop = false;
	    
	    for (j = rowStart; j <= rowEnd;	j++)
	    	
	    	{	
	    	
	    	XSSFRow row = priceSheet.getRow(j); 
			    
			    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtIMEIVal")).sendKeys(NonIosexcel.getCellData("NonIOS", "IMEI", j));
	
		        
		        driver.findElement(By.id("ctl00_ContentPlaceHolder1_imeiValidate")).click();	
		        
		        Thread.sleep(10000L);
		        
		       /* if (driver.getCurrentUrl().equals("https://qa-appleonline.mpxltd.co.uk/SearchResults.aspx")) {
		        	
		        	System.out.println("Enter into Old Page");
		        
		        	if (driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_RptSlaveModel_ctl00_devicemodel']")).getText().contains("16GB"))
		        	 {
		        		
		        		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_RptSlaveModel_ctl00_devicemodel']")).click();
		        	 }
		        			
		        		
		        	
		        	
		        }*/
		        		        	        
		        if (driver.getCurrentUrl().equals("https://qa-appleonline.mpxltd.co.uk/")
		        		
		        		|driver.getCurrentUrl().equals("https://qa-appleonline.mpxltd.co.uk/search.aspx"))		
		        	
		        	   	{
		        	System.out.println("Entered into MPN box");
		        	System.out.println(driver.getCurrentUrl());        		
	        		//Clear IMEI Search Box
	        		if(driver.findElement(By.xpath("//*[@id='txtSearchValidation']")).isDisplayed())
	        			{
	        		
	        		System.out.println("Error On Apple Renew Page");
	        		
		        	Thread.sleep(2000);
		        	
		        	System.out.println(NonIosexcel.getCellData("NonIOS", "IMEI", j)+ "       " + "Reason :  "+ driver.findElement(By.id("errorMsg")).getText());
		        	
		        	driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtIMEIVal")).clear();	 
		        	
		        	       	continue;
	        			}	        		
	        	
	        }   
		     
	        			/*else	{
	        				
	         				//System.out.println("Entered in else condition");
	         				
	         				//System.out.println(NonIosexcel. getCellData("NonIOS", "IMEI", j)+ "       Reason :  Is Valied IMEI.");
	         			
	         				existFromLoop = true;
	         				break;
	        	}	*/
		        
		        
		       /* if (driver.getCurrentUrl().equals("https://qa-appleonline.mpxltd.co.uk/SearchResults.aspx") {
		        	
		        	
		        }*/
		        
		        
		        
			//Image Identification		        
		    
			Handsetidentity = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_imgPhone']")).getAttribute("src");
			System.out.println(Handsetidentity);
			String result = NonIosexcel.getCellData("NonIOS", "Modelid", j);	
			int resultValue = Integer.parseInt(result.substring(0, result.indexOf('.')));
			System.out.println("Present inspected Handset Model ID is : " + resultValue);
			System.out.println("Following value will be printing in Excel Sheet " + NonIosexcel.setCellData("MAC", "ModelResult", j, Handsetidentity));
			boolean hand = Handsetidentity.contains(Integer.toString(resultValue));
			NonIosexcel.setCellData("NonIOS", "ModelResult", j, Boolean.toString(Handsetidentity.contains(Integer.toString(resultValue))));
			
			
			// Inspection Color
			WebElement Color = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_errorSpecification']"));
			if (Color.isDisplayed()){
				
				if (Color.getText().contains("Please select colour and capacity")){
					
					System.out.println("Insert in colour If Condition");
					driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelColor_ctl01_RdBxMasterModelColor']")).click();			
					Thread.sleep(10000);
					AppleUKConsumerNonIOS_113 capacity = new AppleUKConsumerNonIOS_113 ();
					capacity.handsetcapacity();
					
				}	
				
				AppleUKConsumerNonIOS_113 capacity = new AppleUKConsumerNonIOS_113 ();
				capacity.handsetcapacity();
				
				Thread.sleep(3000L);
				
				AppleUKConsumerNonIOS_113 ColorInspection = new AppleUKConsumerNonIOS_113 ();
				ColorInspection.inspection();
				
				Vlauecheck = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_withoutzero3']")).getText();	
				System.out.println("Full Net Price of after pass an all activities " + " " + resultValue + "  is  " + Vlauecheck);
				NonIosexcel.setCellData("NonIOS", "Is Price", j, Vlauecheck);
				
				}	else {
					
					AppleUKConsumerNonIOS_113 ColorInspection = new AppleUKConsumerNonIOS_113 ();
					ColorInspection.inspection();	
					
				Vlauecheck = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_withoutzero3']")).getText();
				System.out.println("Full Net Price of after pass an all activities " + " " + resultValue + "  is  " + Vlauecheck);
				NonIosexcel.setCellData("NonIOS", "Is Price", j, Vlauecheck);
				
			}	
			
			Thread.sleep(1000L);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)", "");
				
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_LnkBackBtn']")).click();
			
			driver.findElement(By.xpath("//*[@id='aspnetForm']")).click();
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl01_no']/span")).click();
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl03_no']/span")).click();	
			
			
			Thread.sleep(1000L);
			jse.executeScript("window.scrollBy(0,250)", "");
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']")).click();
			
			DamagedVlauecheck = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_withoutzero3']")).getText();
			System.out.println("Damaged Net Price of after fail an activity (Keyboard and Display) " + " " + resultValue + "  is  " + DamagedVlauecheck);
			NonIosexcel.setCellData("NonIOS", "Damage Price", j, DamagedVlauecheck);
			
			Thread.sleep(1000L);
			JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			jse2.executeScript("window.scrollBy(0,250)", "");
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_LnkBackBtn']")).click();
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl00_no']/span")).click();
			
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl01_yes")).click();
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl02_no']/span")).click();
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl03_yes']")).click();
			
			
			Thread.sleep(1000L);
			
			jse.executeScript("window.scrollBy(0,250)", "");
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl04_no']/span")).click();
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']")).click();
				
			DamagedVlauecheck486 = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_withoutzero3']")).getText();
			System.out.println("Damaged Net Price of after fail an activity (Power,Case,Liquid Damage) " + " " + resultValue + "  is  " + DamagedVlauecheck486);
			NonIosexcel.setCellData("NonIOS", "DamagedPriceSubsidy", j, DamagedVlauecheck486);
			
			System.out.println("----------------------------------------------------------------");
			
			Thread.sleep(1000L);
			
			JavascriptExecutor jse3 = (JavascriptExecutor)driver;
			jse3.executeScript("window.scrollBy(0,250)", "");

			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_LnkBtnDecline']")).click();
			
		}
	    	

	}
	
public static void inspection() throws InterruptedException, IOException{
		
		driver.manage().timeouts().pageLoadTimeout(100L, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

	//Inspection Activities
	driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl00_yes")).click();
		
	driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl01_yes")).click();

	driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl02_yes")).click();
	
	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl03_yes']")).click();
	
	Thread.sleep(1000L);
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)", "");
	
	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl04_yes']")).click();
	
	JavascriptExecutor jse6 = (JavascriptExecutor)driver;
	jse6.executeScript("window.scrollBy(0,250)", "");
	
	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']")).click();
	
		}

public static void handsetcapacity () {
	
	
	if (driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("16")&
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("32")&
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("64")) {				
					
								System.out.println(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText());
								
	if (NonIosexcel.getCellData("NonIOS", "Capacity" ,j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).getText())) {
						
						driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).click();					
											
					}

	if (NonIosexcel.getCellData("NonIOS", "Capacity", j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).getText())) {
		
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).click();					
							
					}

		

	if (NonIosexcel.getCellData("NonIOS", "Capacity", j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl02_LblMasterModelSize']")).getText())) {
		
		driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl02_LblMasterModelSize']")).click();					
							
					}
				
	}	

if (driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("16")&
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("32")) {
		
					System.out.println("Enter into 2 capacity category");
					
		if (NonIosexcel.getCellData("NonIOS", "Capacity" ,j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).getText())) {
			
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).click();					
								
		}

	if (NonIosexcel.getCellData("NonIOS", "Capacity", j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).getText())) {

	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).click();					
				
		}
		
	}

	if (driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("32")&
		driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("64")&
		driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("128")) {
		
		System.out.println("Enter into 3 category 32,64 and 128 capacity");
		
		if (NonIosexcel.getCellData("NonIOS", "Capacity" ,j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).getText())) {
			
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).click();					
								
		}

	if (NonIosexcel.getCellData("NonIOS", "Capacity", j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).getText())) {

	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).click();					
				
		}



	if (NonIosexcel.getCellData("NonIOS", "Capacity", j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl02_LblMasterModelSize']")).getText())) {

	driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl02_LblMasterModelSize']")).click();					
				
		}
	}

if (driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("32")&
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("64")) {
		
					System.out.println("Enter into 2 capacity 32 and 64 category");
					
		if (NonIosexcel.getCellData("NonIOS", "Capacity" ,j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).getText())) {
			
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).click();					
								
		}

	if (NonIosexcel.getCellData("NonIOS", "Capacity", j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).getText())) {

	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).click();					
				
		}
		
	}
	
}

	

}
