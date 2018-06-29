package dd_tests;

import java.io.IOException;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_Core.TestCore;
import dd_util.TestUtil;

public class ValidateIMEI extends TestCore {
	
	@BeforeTest
	public void isskip () {
		
		if (! TestUtil.isexicutable("EnterIMEI")) {
			
			throw new SkipException("Run Mode Set as No");
			
		}
	}
	
	@Test(dataProvider="getData")
	public void enterIMEI (String IMEI) throws IOException {
		
		try {
			
			application_logs.debug("Loading the Application Log file");
			
			driver.findElement(By.id(object.getProperty("IMEIFieldID"))).sendKeys(IMEI);
			driver.findElement(By.id(object.getProperty("SearchButtonID"))).click();			
		} catch (Throwable t) {
			
			TestUtil.CaptureScreenshot();
			Assert.assertTrue(false, t.getMessage());
		}
	
		//
	}
	
	@DataProvider
	public Object[] getData() {
		
		return TestUtil.getData("EnterIMEI");
		
	}

}
