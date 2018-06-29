package SSP;

import java.sql.ResultSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

import B2B.DBandEmailConfig;
import POM.BrowserOpen;
import B2B.ExcelReader;
import B2B.DbManager;


public class SSPProcess {
	
	public static ExcelReader SetinDB = new ExcelReader("D:\\Selenium\\WebDriver\\EmailApplication\\src\\qhid.xlsx");
	public static ExcelReader customer = new ExcelReader("D:\\Selenium\\WebDriver\\EmailApplication\\src\\Customer Details.xlsx");
	public static int rowStart = 2;
	//public static WebElement Placed = BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder1_B2BCurrentStatus_rptCurrentStatus_ctl00_liItem"));
	
	//Order Confirm 
	public static void OrderConfirmProcess () throws InterruptedException {
		
		BrowserOpen.driver.manage().timeouts().implicitlyWait(8000L, TimeUnit.SECONDS);
	
				
			//Confirm Button		
			BrowserOpen.driver.findElement(By.xpath(".//*[@id='aspnetForm']/section[2]/section/section/section[2]/div/div[2]/div/ul/li[1]/span/button")).click();
			
			Thread.sleep(3000L);
			BrowserOpen.driver.findElement(By.id("btnClosed")).click();
						
			Thread.sleep(6000L);
			
			//Customer Popup
			if (BrowserOpen.driver.findElement(By.xpath(".//*[@id='editCustInfo']/div/div")).isDisplayed()==true) {
				
				Thread.sleep(3000L);
					
				//New Customer Popup
				if (BrowserOpen.driver.findElement(By.id("CustomerInfoTitle")).getText().equals("Enter Customer Information")) {
					
					System.out.println(BrowserOpen.driver.findElement(By.id("CustomerInfoTitle")).getText());
										
					BrowserOpen.driver.findElement(By.id("txtFirstName")).sendKeys(customer.getCellData("Sheet1", "First Name", rowStart));
					Thread.sleep(200L);
					BrowserOpen.driver.findElement(By.id("txtLastName")).sendKeys(customer.getCellData("Sheet1", "Last Name", rowStart));
					Thread.sleep(200L);
					BrowserOpen.driver.findElement(By.id("txtCompanyName")).sendKeys(customer.getCellData("Sheet1", "Company Name", rowStart));	
					Thread.sleep(200L);
					BrowserOpen.driver.findElement(By.id("TxtComapnyHouseNo")).sendKeys(customer.getCellData("Sheet1", "Bulding No", rowStart));	
					Thread.sleep(200L);
					BrowserOpen.driver.findElement(By.id("TxtComapnyPostalCode")).sendKeys(customer.getCellData("Sheet1", "Postal Code", rowStart));	
					Thread.sleep(200L);
					BrowserOpen.driver.findElement(By.id("btnFindAddress")).click();
					BrowserOpen.driver.findElement(By.xpath(".//*[@id='findAddress']/div/div/div[2]/div[1]/div/div/div/a")).click();
					Thread.sleep(15000L);		
					Select fia = new Select (BrowserOpen.driver.findElement(By.id("lstGetAddress")));
					Thread.sleep(3000L);
					fia.selectByIndex(1);
					//fia.selectByVisibleText(text);
					Thread.sleep(3000L);
					BrowserOpen.driver.findElement(By.id("AManuallyAddress")).click();
					//System.out.println(fia.selectByIndex(1));
					//.indexOf(1);					
					Thread.sleep(200L);
					BrowserOpen.driver.findElement(By.id("txtCustomerTelephoneNumber")).sendKeys(customer.getCellData("Sheet1", "Tel Num", rowStart));
					Thread.sleep(200L);
					BrowserOpen.driver.findElement(By.id("txtBankAccountPayableName")).sendKeys(customer.getCellData("Sheet1", "Payble Name", rowStart));				
					Thread.sleep(200L);
					BrowserOpen.driver.findElement(By.id("txtVATNumber")).sendKeys(customer.getCellData("Sheet1", "VAT Number", rowStart));	
					Thread.sleep(1000L);
					BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder1_B2BPlacedAccountInfo_BtnValidateVAt")).click();
					Thread.sleep(1000L);
					BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder1_B2BPlacedAccountInfo_BtnSaveAccountInformation")).click();
					
				}
				
				//Existing Customer Popup
				else if (BrowserOpen.driver.findElement(By.id("CustomerInfoTitle")).getText().equals("Do you wish to edit your Account Information?")) {
					
					BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder1_B2BPlacedAccountInfo_BtnSaveAccountInformation")).click();
					
				}
				
				
			}		
		

	}
	
	//Request Packaging
	public static void RequestPackaging () throws InterruptedException {
		
		System.out.println("RequestPackaging Page");
		
		try{
			if (BrowserOpen.driver.getCurrentUrl().contains("https://qa-appleb2bonlineuk.brightstar.com/OrderConfirmed.aspx?QuoteHeaderID=")) {
			
		BrowserOpen.driver.findElement(By.xpath(".//*[@id='aspnetForm']/section[2]/section/section/section[2]/div/div[2]/div/ul/li[1]/span/button")).click();
		Thread.sleep(5000);
		
		if (BrowserOpen.driver.findElement(By.xpath(".//*[@id='addCA']/div/div")).isDisplayed()==true) {
			
		BrowserOpen.driver.findElement(By.id("txtContactPerson")).sendKeys(customer.getCellData("Sheet1", "First Name", rowStart));
		BrowserOpen.driver.findElement(By.id("txtHouseNo")).sendKeys(customer.getCellData("Sheet1", "Bulding No", rowStart));
		
		BrowserOpen.driver.findElement(By.id("txtPOstalCode")).sendKeys(customer.getCellData("Sheet1", "Postal Code", rowStart));	
		Thread.sleep(200L);
		BrowserOpen.driver.findElement(By.id("btnFindAddress")).click();
		BrowserOpen.driver.findElement(By.xpath(".//*[@id='findAddress']/div/div/div[2]/div[1]/div/div/div/a")).click();
		Thread.sleep(15000L);		
		Select fia = new Select (BrowserOpen.driver.findElement(By.id("lstGetAddress")));
		Thread.sleep(3000L);
		fia.selectByIndex(1);
		//fia.selectByVisibleText(text);
		Thread.sleep(3000L);
		BrowserOpen.driver.findElement(By.id("AManuallyAddress")).click();
		Thread.sleep(200L);
		BrowserOpen.driver.findElement(By.id("txtTelephoneNumber")).sendKeys(customer.getCellData("Sheet1", "Tel Num", rowStart));
		Thread.sleep(200L);
		BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder1_CustomerAddresss_DefaultAddressCollection")).click();
		Thread.sleep(3000L);
		BrowserOpen.driver.findElement(By.id("btnSaveRecords")).click();
		
		/*if (BrowserOpen.driver.findElement(By.xpath(".//*[@id='Confirmedpopup']/div/div")).isDisplayed()==true) {
			
			BrowserOpen.driver.findElement(By.xpath(".//*[@id='Confirmedpopup']/div/div/div[3]/a")).click();	
			}*/
		}
		
		Thread.sleep(5000L);
		
		if (BrowserOpen.driver.findElement(By.xpath(".//*[@id='addSel']/div/div")).isDisplayed()==true) {
			
						
			BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder1_CustomerAddressCollections_DefaultAddressCollection")).click();
			Thread.sleep(3000L);
			BrowserOpen.driver.findElement(By.id("btnSave")).click();
		}
		
		Thread.sleep(8000L);
		BrowserOpen.driver.findElement(By.xpath(".//*[@id='Confirmedpopup']/div/div/div[3]/a")).click();
		
		
		
			}
		
		} catch (Exception e) {
			
			System.out.println("Enter into cath block");
    		
	   		
    		System.out.println(e.getMessage());
    		    		
    		}
		}
	
	/*public static void AwaitingShipment () {
		
		if (BrowserOpen.driver.getCurrentUrl().contains("https://qa-appleb2bonlineuk.brightstar.com/OrderConfirmed.aspx?QuoteHeaderID=")) {
			
			
						
			
			}
		
		}*/
	
	}

