package Data_Providers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_library.ExcelRW;

public class DP_Cart {
	
	public static List<String[]> getCartData(String Scriptname) throws IOException{
		ExcelRW excel_Cart = new ExcelRW();
		excel_Cart.WorkbookInitialize(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_Data.xlsx");
		XSSFSheet Cartsheet = excel_Cart.setSheet("Cart");
//		get row count
		int cart_Rows = excel_Cart.rowCount(Cartsheet);
		
//		create an array list to hold the values
		List<String[]> Cart_List = new ArrayList<String[]>();
		
//		iterating to fetch rows which contains specified script name
		for(int icart_Rows=1 ; icart_Rows<=cart_Rows;icart_Rows++){
			
			if(excel_Cart.readCell(Cartsheet, icart_Rows, 3).equals(Scriptname)){
				if(excel_Cart.readCell(Cartsheet, icart_Rows, 2).equalsIgnoreCase("Y")){
//					create an array which hold 5 elments
					String[] Cart_arr=new String[7];
					
					Cart_arr[0] = excel_Cart.readCell(Cartsheet, icart_Rows, 0);
					Cart_arr[1]= excel_Cart.readCell(Cartsheet, icart_Rows, 1);
					Cart_arr[2]= excel_Cart.readCell(Cartsheet, icart_Rows, 4);
					Cart_arr[3] = excel_Cart.readCell(Cartsheet, icart_Rows, 5);
					Cart_arr[4] = excel_Cart.readCell(Cartsheet, icart_Rows, 6);
					Cart_arr[5] = excel_Cart.readCell(Cartsheet, icart_Rows, 7);
					Cart_arr[6] = excel_Cart.readCell(Cartsheet, icart_Rows, 8);

					
//					Add array to list
					Cart_List.add(Cart_arr);
					
					
				}		
				
			}		
			
		}
		
		return Cart_List;
	}
	
	
	@DataProvider(name="Add_Cart")
	 public static Iterator<String[]> getAddCartdata() throws IOException{
		 
		 List<String[]> lcartData = getCartData("Add_Cart");
		 return lcartData.iterator();
		 
		 
	 }
	
	 
	@DataProvider(name="Delete_Cart")
		 public static Iterator<String[]> getDeleteCartdata() throws IOException{
			 
			 List<String[]> lcartData = getCartData("Delete_Cart");
			 return lcartData.iterator();
			 
			 
	}
	
	
	
	
	
	
	
	
	

}
