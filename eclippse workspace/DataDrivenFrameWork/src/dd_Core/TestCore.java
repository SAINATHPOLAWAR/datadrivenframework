package dd_Core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/*import javax.mail.MessagingException;
import javax.mail.internet.AddressException;*/

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/*import org.testng.annotations.AfterSuite;*/
import org.testng.annotations.BeforeSuite;

//import dd_util.TestConfig;
import dd_util.Xls_Reader;
//import dd_util.monitoringMail;

public class TestCore {
	
	/*	Step : 1

	 * Intializing properties, Xls, Creating DB Connection, Generating Logs, Inti WebDriver
	 * 
	 */
		
	public static Properties config = new Properties ();
	public static Properties object = new Properties (); 
	public static Xls_Reader excel = null;
	public static WebDriver driver; 
	public static Logger application_logs = Logger.getLogger("depinoyLogger");
	
	
	@BeforeSuite
	public static void init() throws IOException {
		
		if (driver == null) {		
		
		FileInputStream fis = new FileInputStream (System.getProperty("user.dir")+"\\src\\dd_Properties\\config.properties");
		config.load(fis);
		
		application_logs.debug("Loading the congig Log file");
		
		fis = new FileInputStream (System.getProperty("user.dir")+"\\src\\dd_Properties\\object.properties");
		object.load(fis);
		
		application_logs.debug("Loading the Object Log file");
		
		excel = new Xls_Reader (System.getProperty("user.dir")+"\\src\\dd_Properties\\testdata.xlsx");
		
		application_logs.debug("Loading the excel Log file");
		
		if (config.getProperty("browser").equals("Firefox")) {
			
			 System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			
			driver = new FirefoxDriver ();
			
			application_logs.debug("Loading the firefoxBrowser Log file");
			
		}else if (config.getProperty("browser").equals("Chrome")) {
			
			
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			
			driver = new ChromeDriver();
			
			}
		
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		driver.get(config.getProperty("testsite"));
		
		}
	}
	
/*	@AfterSuite
	public static void QuitDriver () throws AddressException, MessagingException {
		
		driver.quit();
		
		monitoringMail mail = new monitoringMail ();
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
		
	}*/

}
