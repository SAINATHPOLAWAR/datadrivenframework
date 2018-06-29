package dd_util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import dd_Core.TestCore;

public class TestUtil extends TestCore {
	
	public static boolean isexicutable (String tcid) {
		

	for (int rownum = 2; rownum<=excel.getRowCount("test_suite"); rownum++) {	
				
			if (excel.getCellData("test_suite", "tcid", rownum).equals(tcid)) {
				
				if (excel.getCellData("test_suite", "runmode", rownum).equals("YES")) {

					return true;					
					
				} else {					
					
					return false;
				}				
				
				
			} 
		
			
		}
		
		return false;
	
	}
	
	
	public static Object[] getData(String Sheetname1) {
		
		int totalrows = excel.getRowCount(Sheetname1)-1;
		if (totalrows<=0) {
			
			Object data[][] = new Object[1][0];
			return data;
		}
		
		totalrows = excel.getRowCount(Sheetname1); //Get Row Count
		int totalColumns = excel.getColumnCount(Sheetname1); //Get Column Count
		
		Object data[][] = new Object[totalrows-1][totalColumns];
		
		for(int rownum = 2; rownum<=totalrows; rownum++) {
			
			for (int colNum=0; colNum<totalColumns; colNum++) {
				
				data[rownum-2][colNum]=excel.getCellData(Sheetname1, colNum, rownum);
			}
		}
		
		return data;
		
	}
	
	
	public static void CaptureScreenshot() throws IOException{
		
				
		  Calendar cal = new GregorianCalendar();
		  int month = cal.get(Calendar.MONTH); //3
		  int year = cal.get(Calendar.YEAR); //2014
		  int sec =cal.get(Calendar.SECOND);
		  int min =cal.get(Calendar.MINUTE);
		  int date = cal.get(Calendar.DATE);
		  int day =cal.get(Calendar.HOUR_OF_DAY);
		  
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		try {
		 String mailscreenshotpath = System.getProperty("user.dir")+"\\Screenshot\\"+"Screenshot"+ "_"+year+"_"+date+"_"+(month+1)+".jpeg";
		  
		  Files.copy(scrFile, new File(mailscreenshotpath));	     
		} catch (IOException e) { 
			
			e.printStackTrace();
			
		}
		
	}

}
