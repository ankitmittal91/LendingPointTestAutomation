package com.TestAutomation.dataProvider;

import org.testng.annotations.DataProvider;

import com.TestAutomation.utility.NewExcelLibrary;

public class DataProviders {
	NewExcelLibrary obj = new NewExcelLibrary();
	
	//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

		@DataProvider(name = "credentials")
		public Object[][] getCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("Credentials");
			// Total Columns
			int column = obj.getColumnCount("Credentials");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) { 
				for (int j = 0; j < column; j++) { 
					data[i][j] = obj.getCellData("Credentials", j, i + 2);
				}
			}
			return data;
		}
		
		@DataProvider(name = "searchproduct")
		public Object[][] GetProductName() {
			
			int rows = obj.getRowCount("SearchProduct");
			int column = obj.getColumnCount("SearchProduct");
			int actRows = rows - 1;
			
			Object[][] data = new Object[actRows][column];
			
			for (int i=0; i<actRows; i++) {
				for(int j=0; j<column; j++) {
					data[i][j] = obj.getCellData("SearchProduct", j, i+2);
				}
			}
			return data;
		}
}
