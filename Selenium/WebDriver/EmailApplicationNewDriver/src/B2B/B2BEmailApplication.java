package B2B;


import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import POM.B2BOrderPlace;
import POM.BrowserOpen;
import SSP.OrderViewSSP;
import SSP.SSPProcess;

public class B2BEmailApplication {
	
	
	public static String decode (String encodedpassword) {
		
		byte[] bytedecoded = Base64.decodeBase64(encodedpassword);
		
		return new String(bytedecoded);
	}
	

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException, IOException {
				
		//BrowserOpen.driver.manage().timeouts().implicitlyWait(8000L, TimeUnit.SECONDS);
		
		BrowserOpen.Browser();
		
		
		//B2BOrderPlace.BuildYourQuote();
		
		//I am using 'USP_TESTSELENIUM' for recent order place, 
		//for excution please use 'exec USP_TESTSELENIUM  188  ,'sainath@veridic.in''
		
		//DataBaseVerifycation.orderplacequry();
		
		Thread.sleep(5000L);
		
		B2BOrderPlace.Login();
		
		Thread.sleep(2000L);
		
		
		
	/*	byte[] bytesencoded = Base64.encodeBase64("mpx@1234".getBytes());
		System.out.println("Encoded Value is" + new String(bytesencoded));
		
		byte[] bytedecoded = Base64.decodeBase64(bytesencoded);
		System.out.println("Decoded Value is" + new String(bytedecoded));*/
				
		
		BrowserOpen.driver.findElement(By.id("txtPassword")).sendKeys(decode("bXB4QDEyMzQ="));
		Thread.sleep(2000L);
		BrowserOpen.driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000L);
		
		OrderViewSSP.SSPOrderView();
		
		Thread.sleep(4000L);
	if (BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder1_B2BCurrentStatus_rptCurrentStatus_ctl00_liItem")).isDisplayed()==true
			&& BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblQuoteStatus")).getText().equals("Quote Placed")) {
		
		SSPProcess.OrderConfirmProcess();
	
		Thread.sleep(5000L);
	
	}

	
	if (BrowserOpen.driver.getCurrentUrl().contains("https://qa-appleb2bonlineuk.brightstar.com/OrderConfirmed.aspx?QuoteHeaderID=")
			&& BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder1_B2BCurrentStatus_rptCurrentStatus_ctl01_liItem")).getText().equals("Confirmed")
			&& BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblQuoteStatus")).getText().equals("Quote Confirmed") ) {
		
		SSPProcess.RequestPackaging();
		}
	
	
	if (BrowserOpen.driver.getCurrentUrl().contains("https://qa-appleb2bonlineuk.brightstar.com/OrderPackageRequested.aspx?QuoteHeaderID=")
			&& BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder1_B2BCurrentStatus_rptCurrentStatus_ctl02_liItem")).getText().equals("Packaging Requested")
			&& BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblQuoteStatus")).getText().equals("Packaging Requested") ) {
		
		
		DataBaseVerifycation.orderplacequry1();
		
		
		
		BrowserOpen.driver.findElement(By.id("ctl00_ContentPlaceHolder1_BtnBack")).click();
		
		
		OrderViewSSP.SSPOrderView();
		
	}
	
	}

}
