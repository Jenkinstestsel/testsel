package Data_Providers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_library.ExcelRW;

public class DP_Login {
	
	
	
	public static List<String[]> getLoginData(String Scriptname) throws IOException{
		ExcelRW excel_login = new ExcelRW();
		excel_login.WorkbookInitialize(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_Data.xlsx");
		XSSFSheet Loginsheet = excel_login.setSheet("Login");
//		get row count
		int login_Rows = excel_login.rowCount(Loginsheet);
		
//		create an array list to hold the values
		List<String[]> login_List = new ArrayList<String[]>();
		
//		iterating to fetch rows which contains specified script name
		for(int ilogin_Rows=1 ; ilogin_Rows<=login_Rows;ilogin_Rows++){
			
			if(excel_login.readCell(Loginsheet, ilogin_Rows, 3).equals(Scriptname)){
				if(excel_login.readCell(Loginsheet, ilogin_Rows, 2).equalsIgnoreCase("Y")){
//					create an array which hold 5 elments
					String[] Login_arr=new String[5];
					
					Login_arr[0] = excel_login.readCell(Loginsheet, ilogin_Rows, 0);
					Login_arr[1]= excel_login.readCell(Loginsheet, ilogin_Rows, 1);
					Login_arr[2]= excel_login.readCell(Loginsheet, ilogin_Rows, 4);
					Login_arr[3] = excel_login.readCell(Loginsheet, ilogin_Rows, 5);
					Login_arr[4] = excel_login.readCell(Loginsheet, ilogin_Rows, 6);
					
//					Add array to list
					login_List.add(Login_arr);
					
					
				}		
				
			}		
			
		}
		
		return login_List;
	}
	
	
	
	
	
@DataProvider(name="invalidLogin")
//Note: the Dataprovider signature should have static to make it accessible from outside class
public static Iterator<String[]> getinvalidlogindata() throws Exception{
	
//	call method "getloginData" and pass parameter "invlaid_login) ie the script name
	List<String[]> invloginData = getLoginData("Invalid_Login");
//	return back the list iterator
	return invloginData.iterator();	
//	second option to rerun the iterator
//	return getLoginData("Invalid_Login").iterator()
}

	
@DataProvider(name="validLogin")
//Note: the Dataprovider signature should have static to make it accessible from outside class
public static Iterator<String[]> getvalidlogindata() throws Exception{
//	call method "getloginData" and pass parameter "Valid_login) ie the script name
	List<String[]> vloginData = getLoginData("Valid_Login");
//	return back the list iterator
	return vloginData.iterator();		
	
}	
	
	
	
	

}
