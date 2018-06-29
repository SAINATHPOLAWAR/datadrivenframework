package rough;

import org.apache.log4j.net.SyslogAppender;

import dd_Core.TestCore;
import dd_util.Xls_Reader;

public class TestRunMode extends TestCore {
	
	public static Xls_Reader excel = new Xls_Reader (System.getProperty("user.dir")+"\\src\\dd_Properties\\testdata.xlsx");

	
	public static boolean isexicutable () {

	
		for (int rownum = 2; rownum<=excel.getColumnCount("test_suite"); rownum++) {
			
			System.out.println("my name");
			
			if (excel.getCellData("test_suite", "tcid", rownum).equals("EnterIMEI")) {
				
				if (excel.getCellData("test_suite", "runmode", rownum).equals("Y")) {
					
					return true;					
					
				} else {	
					
					System.out.println("myname 1");
					
					return false;
				}				
				
				
			} 
		
			
		}
		
		return false;
	
	}
	
	public static void main (String[] args) {
		
		System.out.println(isexicutable());
		
	}

}
