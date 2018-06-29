package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import appleOnlinePrices.ExcelReader;

public class AppleUKRetailDataBase {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ExcelReader IosexcelDB = new ExcelReader("D:\\Selenium\\WebDriver\\AppleOnline\\src\\appleOnlinePrices\\113_1.xlsx");
		//System.out.println(IosexcelDB.getCellData("114", "Channelid", 2));	
		//Firstname
		//CustomerID

		DbManager.setDbConnection();

		List<TestClass>DBPrices=	DbManager.getQuery("select * from t_pricingmatrix where phonemodelid = 4525 and "
				+ "contactchannelid = 113 and activityid = 0");
		for(int i = 2 ;i<DBPrices.size(); i++){
			
			IosexcelDB.setCellData("Sheet1", "PhoneModelId", i, DBPrices.get(i).PhoneModelId);
			IosexcelDB.setCellData("Sheet1", "NetworkId", i, DBPrices.get(i).NetworkId);	
			IosexcelDB.setCellData("Sheet1", "ActivityId", i, DBPrices.get(i).ActivityId);	
			IosexcelDB.setCellData("Sheet1", "Value", i, DBPrices.get(i).Value);
			IosexcelDB.setCellData("Sheet1", "SKU", i, DBPrices.get(i).SKU);	
			//IosexcelDB.setCellData("Sheet1", "PD2_UPC", i+2, l.get(i).PD2_UPC);	
			IosexcelDB.setCellData("Sheet1", "Startdate", i, DBPrices.get(i).Startdate);
			IosexcelDB.setCellData("Sheet1", "enddate", i, DBPrices.get(i).enddate);	
			IosexcelDB.setCellData("Sheet1", "ContactChannelId", i, DBPrices.get(i).ContactChannelId);	
			IosexcelDB.setCellData("Sheet1", "PromoAddition", i, DBPrices.get(i).PromoAddition);
			IosexcelDB.setCellData("Sheet1", "GrossValue", i, DBPrices.get(i).GrossValue);
			//IosexcelDB.setCellData(sheetName, colName, rowNum, data)

			
			
			
		System.out.print(DBPrices.get(i).PhoneModelId);
		System.out.print("        " + DBPrices.get(i).ContactChannelId);
		System.out.print("        " + DBPrices.get(i).ActivityId);
		System.out.print("        " + DBPrices.get(i).Value);
		System.out.println();
		
		
		
		
		
	
			
			
		}
		
		  
	}

}
