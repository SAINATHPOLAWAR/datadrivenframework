package B2B;

import java.util.List;

//import appleOnlinePrices.ExcelReader;

import java.sql.SQLException;

public class DataBaseVerifycation {

	public static void orderplacequry() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		//ExcelReader IosexcelDB = new ExcelReader("D:\\Selenium\\WebDriver\\EmailApplication\\src\\qhid.xlsx");

		DbManager.setDbConnection();
		TableColumnManager data1 = new TableColumnManager();
		
		List<TableColumnManager> Orderplace = DbManager.callStoreProcedure();
		
		
		
		
		//System.out.println(Orderplace.size());

		/*for (int i = 0; i == Orderplace.size(); i++) {
			System.out.print("Customer Id : " + Orderplace.get(i).customerid + "      ");
			System.out.print("Quoted Header Id : " + Orderplace.get(i).quoteheaderid +  "      ");
			System.out.print("Handset Quoted Id : " + Orderplace.get(i).handsetquoteid +  "      ");
		}*/

		
	}
	
	
	public static void orderplacequry1() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		//ExcelReader IosexcelDB = new ExcelReader("D:\\Selenium\\WebDriver\\EmailApplication\\src\\qhid.xlsx");

		DbManager.setDbConnection();
		TableColumnManager data1 = new TableColumnManager();
		
		DbManager.callAwaitingStoreProcedure();
		
	}

}
