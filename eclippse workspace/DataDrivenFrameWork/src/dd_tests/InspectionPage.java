package dd_tests;

//import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_Core.TestCore;
import dd_util.TestUtil;

public class InspectionPage extends TestCore {
	
	@BeforeTest
	public void isskip () {
		
		System.out.println(TestUtil.isexicutable("InspectionPage"));
		
		if (! TestUtil.isexicutable("InspectionPage")) {
			
			System.out.println("Enter in exception");
			throw new SkipException("Run Mode Set as No");
			
			
		}
	}
	
	@Test(dataProvider="getData")
	public void Inspection(String Dummy) {
		
		//System.out.println("Welcome to second test");
		System.out.println(Dummy);
		//driver.findElement(By.id(object.getProperty("SelectCol"))).click();
		
	}

	@DataProvider
	public Object[] getData() {
		
		return TestUtil.getData("InspectionPage");
		
	}
}
