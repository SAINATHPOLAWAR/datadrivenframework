package rough;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_Usage {

	public static void main(String[] args) {
		
		FirefoxDriver driver = new FirefoxDriver ();
		
		driver.get("https://qa-appleb2bonlineuk.brightstar.com/");
		
		WebElement product = driver.findElement(By.id("ctl00_ContentPlaceHolder_Content2_B2BModel_ddlProduct"));
		
		Select dropdown = new Select (product);
		
		List <WebElement> values = dropdown.getOptions();
		
		System.out.println(values.get(2).getText());
		
		//int i = 0; i<values.size(); i++
		
		for (WebElement VALUE : values ) {
			
			System.out.println(VALUE.getText() + "----------" + VALUE.getAttribute("value"));
			
			
		/*	boolean verify = values.get(i).getText().contains("iPhone");
			
			if ( verify == true) {
				
				System.out.println("Hellow");
				
								
			}*/
		}
		
		

	}

}
