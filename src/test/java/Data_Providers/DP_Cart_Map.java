package Data_Providers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_library.ExcelRW;

public class DP_Cart_Map {
	
	public static List<Object[]> getCartData_map(String Scriptname) throws IOException{
		ExcelRW excel_Cart = new ExcelRW();
		excel_Cart.WorkbookInitialize(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_Data.xlsx");
		XSSFSheet Cartsheet = excel_Cart.setSheet("Cart");
//		get row count
		int cart_Rows = excel_Cart.rowCount(Cartsheet);
		
//		create an array list to hold the values
		List<Object[]> Cart_List = new ArrayList<Object[]>();
		
//		iterating to fetch rows which contains specified script name
		for(int icart_Rows=1 ; icart_Rows<=cart_Rows;icart_Rows++){
			
			if(excel_Cart.readCell(Cartsheet, icart_Rows, 3).equals(Scriptname)){
				if(excel_Cart.readCell(Cartsheet, icart_Rows, 2).equalsIgnoreCase("Y")){
//					create a Map to hold the data in Key value pair
					Map<String, String> dMap = new HashMap<String,String>();
//					Add the data into map
					dMap.put("TCID", excel_Cart.readCell(Cartsheet, icart_Rows, "TCID")) ;
					dMap.put("Order", excel_Cart.readCell(Cartsheet, icart_Rows, "Order")) ;
					dMap.put("Username", excel_Cart.readCell(Cartsheet, icart_Rows, "Username")) ;
					dMap.put("Password", excel_Cart.readCell(Cartsheet, icart_Rows, "Password")) ;
					dMap.put("SearchString", excel_Cart.readCell(Cartsheet, icart_Rows, "SearchString")) ;
					dMap.put("Exp_Result", excel_Cart.readCell(Cartsheet, icart_Rows, "Exp_Result")) ;
					dMap.put("Quantity", excel_Cart.readCell(Cartsheet, icart_Rows, "Quantity")) ;
//					
//					Add map to Object array
					Object[] omap = new Object[1];
					omap[0] = dMap;
					
					
					Cart_List.add(omap);
					
					
				}		
				
			}		
			
		}
		
		return Cart_List;
	}
	
	
	@DataProvider(name="Add_Cart_map")
	 public static Iterator<Object[]> getAddCartdata() throws IOException{
		 
		 List<Object[]> lcartData = getCartData_map("Add_Cart");
		 return lcartData.iterator();
		 
		 
	 }
	
	 
	
	
	
	
	
	
	
	
	
	

}
