
package B2B;

public class DBandEmailConfig{


	
	public static String server="smtp.gmail.com";
	public static String from = "bhps123456@gmail.com";
	public static String password = "1414141414";
	public static String[] to ={"seleniumcoaching@gmail.com","trainer@way2automation.com"};
	public static String subject = "Test Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath="C:\\screenshot\\abcd.jpg";
	public static String attachmentName="Error.jpeg";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://54.72.54.238;DatabaseName=MobilePhoneXchange;"; 
	public static String dbUserName="a_qa_user"; 
	public static String dbPassword="a_qa_password"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/gaurav";
	
	
	
	
	
	
	
	
	
}
