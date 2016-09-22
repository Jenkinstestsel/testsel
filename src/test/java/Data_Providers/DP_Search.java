package Data_Providers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_library.ExcelRW;

public class DP_Search {
	
	
	public static List<String[]> getSearchData(String Scriptname) throws IOException{
		ExcelRW excel_login = new ExcelRW();
		excel_login.WorkbookInitialize(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_Data.xlsx");
		XSSFSheet Searchsheet = excel_login.setSheet("Search");
//		get row count
		int search_Rows = excel_login.rowCount(Searchsheet);
		
//		create an array list to hold the values
		List<String[]> search_List = new ArrayList<String[]>();
		
//		iterating to fetch rows which contains specified script name
		for(int isearch_Rows=1 ; isearch_Rows<=search_Rows;isearch_Rows++){
			
			if(excel_login.readCell(Searchsheet, isearch_Rows, 3).equals(Scriptname)){
				if(excel_login.readCell(Searchsheet, isearch_Rows, 2).equalsIgnoreCase("Y")){
//					create an array which hold 5 elments
					String[] Login_arr=new String[4];
					
					Login_arr[0] = excel_login.readCell(Searchsheet, isearch_Rows, 0);
					Login_arr[1]= excel_login.readCell(Searchsheet, isearch_Rows, 1);
					Login_arr[2]= excel_login.readCell(Searchsheet, isearch_Rows, 4);
					Login_arr[3] = excel_login.readCell(Searchsheet, isearch_Rows, 5);

					
//					Add array to list
					search_List.add(Login_arr);
					
					
				}		
				
			}		
			
		}
		
		return search_List;
	}
	
	@DataProvider(name="ValidSearch")
	 public static Iterator<String[]> getvalidSearchdata() throws IOException{
		 
		 List<String[]> lsearchData = getSearchData("Valid_Search");
		 return lsearchData.iterator();
		 
		 
	 }
	
	 
		@DataProvider(name="InvalidSearch")
		 public static Iterator<String[]> getinvalidSearchdata() throws IOException{
			 
			 List<String[]> lsearchData = getSearchData("Invalid_Search");
			 return lsearchData.iterator();
			 
			 
		 }
	

}
