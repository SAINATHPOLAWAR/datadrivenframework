package B2B;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
	private static Connection con = null;
	private static Connection conn = null;
	public static ResultSet rs;
	public static ExcelReader SetinDB = new ExcelReader("D:\\Selenium\\WebDriver\\EmailApplication\\src\\qhid.xlsx");
	public static int rowStart = 1;

	public static void setDbConnection() throws SQLException, ClassNotFoundException {
		try {
			Class.forName(DBandEmailConfig.driver);
			con = DriverManager.getConnection(DBandEmailConfig.dbConnectionUrl, DBandEmailConfig.dbUserName,
					DBandEmailConfig.dbPassword);
			DriverManager.setLoginTimeout(180);

			if (!con.isClosed())
				System.out.println("Successfully connected to SQL server");

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());

		}

	}

	public static List<TableColumnManager> callStoreProcedure() throws SQLException {

		//ExcelReader SetinDB = new ExcelReader("D:\\Selenium\\WebDriver\\EmailApplication\\src\\qhid.xlsx");

		// int j1 = rowStart;

		String storedProcudureCall = "{call USP_TESTSELENIUM 188, 'sainath@veridic.in'};";

		CallableStatement cStmt = con.prepareCall(storedProcudureCall);
		List<TableColumnManager> table = new ArrayList<TableColumnManager>();

		rs = cStmt.executeQuery();
		
		System.out.println("Customer ID" + ", " + "Quote Header ID" + ", " + "Handset Quote ID");
		
		//int rowStart = 1;
		
		while (rs.next()) {
			//SetinDB.setCellData("Sheet1", "CustomerID", rowStart, String.valueOf(rs.getLong(1)));
			SetinDB.setCellData("Sheet1", "QuoteHeaderID", rowStart, String.valueOf(rs.getLong(1)));
			//SetinDB.setCellData("Sheet1", "HandsetQuoteID", rowStart, String.valueOf(rs.getLong(3)));
			rowStart++;
			
		}

		return table;
	}

	public static Connection getConnection() {
		return con;
	}
}
