package appleOnlinePrices;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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

public class AppleUKConsumer_113 {
	
	public static int i,j;
	public static WebDriver driver;
	//public static ExcelReader Iosexcel = new ExcelReader("D:\\Selenium\\WebDriver\\AppleAPR\\src\\APRPrices\\113.xlsx");
	public static String Handsetidentity, Vlauecheck, DamagedVlauecheck, DamagedVlauecheck86, DamagedVlauecheck4;
	public static XSSFSheet priceSheet;
	public static  boolean existFromLoop;
	public static XSSFWorkbook IosPrices;
	public static int rowStart, rowEnd;

	public static void main(String[] args) throws InterruptedException, IOException {
	
		System.out.println("Hi");
		
		WebDriver driver = new FirefoxDriver ();
		
		ExcelReader Iosexcel = new ExcelReader("D:\\Selenium\\WebDriver\\AppleAPR\\src\\APRPrices\\113.xlsx");
		
		
		WebDriverWait wait = new WebDriverWait(driver, 60L);
	
		driver.get("https://qa-appleonline.mpxltd.co.uk");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(1000L, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1000L, TimeUnit.SECONDS);
		
		
		//Excel Reader
		//Iosexcel;
		System.out.println(Iosexcel.getCellData("113", "Channelid", 2));	

		//Open Excel
		//@SuppressWarnings("deprecation")
		XSSFWorkbook IosPrices = new XSSFWorkbook("D:\\Selenium\\WebDriver\\AppleOnline\\src\\AppleOnlinePrices\\113.xlsx");
		XSSFSheet priceSheet = IosPrices.getSheet("113");
		
		int rowCount = Math.min(2, priceSheet.getFirstRowNum())-Math.max(3, priceSheet.getLastRowNum());
		System.out.println("Total " + rowCount);
		
		int rowStart = Math.min(88, 88);
	    int rowEnd = Math.max(2, 91);
	    

	    
	    boolean existFromLoop = false;
	    
	    for (j = rowStart; j <= rowEnd;	j++)
	    	
	    	{	
	    	
	    	XSSFRow row = priceSheet.getRow(j); 
			    
			    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtIMEIVal")).sendKeys(Iosexcel.getCellData("113", "IMEI", j));
		 
		        //Thread.sleep(5000);	
		        
		        driver.findElement(By.id("ctl00_ContentPlaceHolder1_imeiValidate")).click();	

		        Thread.sleep(11000L);
		       
		      
		        if (driver.getCurrentUrl().equals("https://qa-appleonline.mpxltd.co.uk/")
		        		
		        		|driver.getCurrentUrl().equals("https://qa-appleonline.mpxltd.co.uk/search.aspx"))		
		        	
		        	   	{
		        	
		        	System.out.println("Enter into invaled if condition");
		        	System.out.println(driver.getCurrentUrl());        		
	        		//Clear IMEI Search Box
	        		if(driver.findElement(By.xpath("//*[@id='txtSearchValidation']")).isDisplayed())
	        			{
	        		
	        		System.out.println("Error On Apple Renew Page");
	        		
		        	Thread.sleep(2000);
		        	
		        	System.out.println(Iosexcel.getCellData("113", "IMEI", j)+ "       " + "Reason :  "+ driver.findElement(By.id("errorMsg")).getText());
		        	
		        	driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtIMEIVal")).clear();	 
		        	
		        	       	continue;
	        			}	        		
	        		
	        		//Enter MPN Number if iPAD Selected
	        		
	        		WebElement MPXbox = driver.findElement(By.xpath("//*[@id='MPNBoxLabel']"));
	        		
	        		if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='MPNBoxLabel']"))).getText().contains("Enter Model Number")) {
	        			
	        		System.out.println("Explicity wait");
	        			        	
		        	if (driver.findElement(By.xpath("//*[@id='MPNBox']/div[2]/div")) != null){
		        				        		        	
			        	System.out.println("Enter in MPN if condition");
			        	Thread.sleep(4000L);
			        	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtMPN']")).sendKeys(Iosexcel.getCellData("113", "MPN", j));
			        	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btn_MPNSearch']")).click();
			        	
			        }
		        	
		        	   	}
		        	
	        }  
	    	//}  
		        else	{
	        				
	         				System.out.println("Entered in else condition");
	         				
	         				System.out.println(Iosexcel. getCellData("113", "IMEI", j)+ "       Reason :  Is Valid IMEI.");
	         	
	        	}			        
		        
		        
			//Image Identification		        
		    
			Handsetidentity = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_imgPhone']")).getAttribute("src");
			String result = Iosexcel.getCellData("113", "Modelid", j);	
			int resultValue = Integer.parseInt(result.substring(0, result.indexOf('.')));
			System.out.println(resultValue);
			boolean hand = Handsetidentity.contains(Integer.toString(resultValue));
			Iosexcel.setCellData("113", "ModelResult", j, Boolean.toString(Handsetidentity.contains(Integer.toString(resultValue))));
			
			
			// Inspection Color
			WebElement Color = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_errorSpecification']"));
			if (Color.isDisplayed()){
				
				if (Color.getText().contains("Please select colour and capacity")){
					
					System.out.println("Insert in colour If Condition");
					
					Thread.sleep(1000L);
					
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy(0,250)", "");
					
					driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelColor_ctl01_RdBxMasterModelColor']")).click();			
					Thread.sleep(10000);
					AppleUKConsumer_113 Capacity = new AppleUKConsumer_113 ();
					//Capacity.HandsetCapacity();
					Thread.sleep(1000L);
					JavascriptExecutor jse12 = (JavascriptExecutor)driver;
					jse12.executeScript("window.scrollBy(0,-250)", "");
					
				}		
				
				AppleUKConsumer_113 Capacity = new AppleUKConsumer_113 ();
				//Capacity.HandsetCapacity();
				
				Thread.sleep(3000L);
				
				//Color Inspection Activities
				
				AppleUKConsumer_113 ColorInspection = new AppleUKConsumer_113 ();
				ColorInspection.inspection();
				
				Vlauecheck = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_withoutzero3']")).getText();
				System.out.println("Full Net Price of after pass an all activities " + " " + resultValue + "  is  " + Vlauecheck);
				Iosexcel.setCellData("113", "Is Price", j, Vlauecheck);
				
				}else {
					
					AppleUKConsumer_113 ColorInspection = new AppleUKConsumer_113 ();
					ColorInspection.inspection();	
					
					Vlauecheck = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_withoutzero3']")).getText();
					System.out.println("Full Net Price of after pass an all activities " + " " + resultValue + "  is  " + Vlauecheck);
					Iosexcel.setCellData("113", "Is Price", j, Vlauecheck);
				
			}	
			
			Thread.sleep(1000L);
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_LnkBackBtn']")).click();
			
			Thread.sleep(1000L);
			
			driver.findElement(By.xpath("//*[@id='aspnetForm']")).click();
			
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl01_no")).click();
			
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl03_no")).click();
			
			Thread.sleep(1000L);
			
			jse.executeScript("window.scrollBy(0,250)", "");
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']")).click();
			
			Thread.sleep(100L);
			
			DamagedVlauecheck = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_withoutzero3']")).getText();
			System.out.println("Damaged Net Price of after fail an activity (Keyboard and Display) " + " " + resultValue + "  is  " + DamagedVlauecheck);
			Iosexcel.setCellData("113", "Damage Price", j,DamagedVlauecheck);
			
			
			Thread.sleep(1000L);
			
			JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			jse2.executeScript("window.scrollBy(0,250)", "");
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_LnkBackBtn']")).click();
							
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl01_yes")).click();
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl02_no']/span")).click();
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl03_yes']")).click();
			
			Thread.sleep(1000L);
			
			jse.executeScript("window.scrollBy(0,250)", "");
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl04_no']/span")).click();
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']")).click();
			
			
			DamagedVlauecheck86 = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_withoutzero3']")).getText();
			System.out.println("Damaged Net Price of after fail an activity (Case,Liquid Damage) " + " " + resultValue + "  is  " + DamagedVlauecheck86);
			Iosexcel.setCellData("113", "DamagedPriceSubsidy", j,DamagedVlauecheck86);
			
			Thread.sleep(1000L);
			
			jse2.executeScript("window.scrollBy(0,250)", "");
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_LnkBackBtn']")).click();
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl00_no']/span")).click();
			
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl01_yes")).click();

			driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl02_yes")).click();
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl03_yes']")).click();
			
			Thread.sleep(1000L);
			
			jse.executeScript("window.scrollBy(0,250)", "");
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl04_yes']")).click();
			
			Thread.sleep(500L);
			jse.executeScript("window.scrollBy(0,250)", "");
			
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']")).click();
			
			DamagedVlauecheck4 = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_withoutzero3']")).getText();
			System.out.println("Damaged Net Price of after fail an activity (Power,Case,Liquid Damage) " + " " + resultValue + "  is  " + DamagedVlauecheck4);
			Iosexcel.setCellData("113", "Power Fail Price", j,DamagedVlauecheck4);
			
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
		
		JavascriptExecutor jse10 = (JavascriptExecutor)driver;
		jse10.executeScript("window.scrollBy(0,-250)", "");	
	
	System.out.println("Enter into ");
	//Inspection Activities
	driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl00_yes")).click();
		
	driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl01_yes")).click();

	driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl02_yes")).click();
	
	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl03_yes']")).click();
	
	Thread.sleep(1000L);
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)", "");
	
	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl04_yes']")).click();
	
	Thread.sleep(500L);
	jse.executeScript("window.scrollBy(0,250)", "");
	
	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']")).click();
	
		}
	
/*public static void HandsetCapacity () {
	
	if (driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("16")){
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,50)", "");
		
								System.out.println(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText());
		
		if (Iosexcel.getCellData("113", "Capacity" ,j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).getText())) {
			
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).click();					
								
		}
	}
	
	if (driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("16")&
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("32")&
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("64")) {				
					
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,50)", "");
		
								System.out.println(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText());
								
	if (Iosexcel.getCellData("113", "Capacity" ,j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).getText())) {
						
						driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).click();					
											
					}

	if (Iosexcel.getCellData("113", "Capacity", j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).getText())) {
		
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).click();					
							
					}

		

	if (Iosexcel.getCellData("113", "Capacity", j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl02_LblMasterModelSize']")).getText())) {
		
		driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl02_LblMasterModelSize']")).click();					
							
					}
				
	}	

	else if (driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("16")&
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("32")) {
		
					System.out.println("Enter into 2 capacity category");
					
		if (Iosexcel.getCellData("113", "Capacity" ,j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).getText())) {
			
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).click();					
								
		}

	if (Iosexcel.getCellData("113", "Capacity", j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).getText())) {

	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).click();					
				
		}
		
	}

	else if (driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("32")&
		driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("64")&
		driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("128")) {
		
		System.out.println("Enter into 3 category 32,64 and 128 capacity");
		
		if (Iosexcel.getCellData("113", "Capacity" ,j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).getText())) {
			
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).click();					
								
		}

	if (Iosexcel.getCellData("113", "Capacity", j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).getText())) {

	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).click();					
				
		}



	if (Iosexcel.getCellData("113", "Capacity", j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl02_LblMasterModelSize']")).getText())) {

	driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl02_LblMasterModelSize']")).click();					
				
		}
	}

	else if (driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("32")&
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("64")) {
		
					System.out.println("Enter into 2 capacity 32 and 64 category");
					
		if (Iosexcel.getCellData("113", "Capacity" ,j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).getText())) {
			
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).click();					
								
		}

	if (Iosexcel.getCellData("113", "Capacity", j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).getText())) {

	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).click();					
				
		}
		
	}
	
	else if (driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("16")&
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_devicecapacity']")).getText().contains("64")) {
		
					System.out.println("Enter into 2 capacity 16 and 64 category");
					
		if (Iosexcel.getCellData("113", "Capacity" ,j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).getText())) {
			
			driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LblMasterModelSize']")).click();					
								
		}

	if (Iosexcel.getCellData("113", "Capacity", j).contains(driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).getText())) {

	driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl01_LblMasterModelSize']")).click();
	
	}
	}
}*/

}
