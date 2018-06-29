package B2B;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import POM.B2BOrderPlace;
import POM.BrowserOpen;
import SSP.OrderViewSSP;
import SSP.SSPProcess;

public class B2BEmailApplication {
	
	
	

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		
		
		
		BrowserOpen.Browser();
		
		
		//B2BOrderPlace.BuildYourQuote();
		
		//I am using 'USP_TESTSELENIUM' for recent order place, 
		//for excution please use 'exec USP_TESTSELENIUM  188  ,'sainath@veridic.in''
		//DataBaseVerifycation.orderplacequry();
		
		//Thread.sleep(5000L);
		
		B2BOrderPlace.Login();
		
		Thread.sleep(4000L);
		BrowserOpen.driver.findElement(By.id("txtPassword")).sendKeys("mpx@1234");
		Thread.sleep(4000L);
		BrowserOpen.driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000L);
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
	
	}

}
