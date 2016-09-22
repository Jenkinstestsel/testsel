package TestScripts;



import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Generic_library.Baseclass;
import PageObjectFactory.Pagefactory_Search;

public class Scenario_Search extends Baseclass {
	
	static Logger searchlog = Logger.getLogger(Scenario_Search.class);
	
	
	@Test(dataProvider="InvalidSearch",dataProviderClass=Data_Providers.DP_Search.class)
	public void Invalid_Search(String TCID,String order,String searchitem,String Exp_res) throws Exception{
		startTest = Projreports.startTest(btype + "-" + "InvalidSearch" );
		Pagefactory_Search psearch = new Pagefactory_Search(driver);
		Thread.sleep(10000);
		psearch.enterandclick_searchopration(searchitem);
		Thread.sleep(5000);
		String Act_res = psearch.extract_Sorryresult();
		startTest.log(LogStatus.PASS, "enter search result", "successfully entered the search criteria");
//		one way assert
//		Assert.assertEquals(Exp_res, Act_res);
		System.out.println(Act_res);
//		second method
		if(Act_res.equals(Exp_res)){
//			write to log file
			startTest.log(LogStatus.PASS, "Validate result", "Passed as Actual and expected results mached");
			searchlog.info( TCID + ":" + order + "-" + "Passed as Actual and expected results mached");
			
		}else{
//			write to log file
			
			 
			startTest.log(LogStatus.FAIL, "Validate result", "Failed as Actual result is " + Act_res + " and expected results is " + Exp_res+ "." + startTest.addScreenCapture(Screenshot(TCID , order)));
//			startTest.addScreenCapture(Screenshot(TCID , order)) ;
			searchlog.info( TCID + ":" + order + "-" + "Failed as Actual result is " + Act_res + " and expected results is " + Exp_res+ ".");
//			write to TESTNGreports
			Assert.fail(TCID + ":" + order + "-" + "Failed as Actual result is " + Act_res + " and expected results is " + Exp_res+ ".");
			
		}
//		
//		
		
	}
	
	
	@Test(dataProvider="ValidSearch",dataProviderClass=Data_Providers.DP_Search.class)
	public void Valid_Search(String TCID,String order,String searchitem,String Exp_res) throws Exception{
		startTest = Projreports.startTest(btype + "-" + TCID );
		Pagefactory_Search psearch = new Pagefactory_Search(driver);
		Thread.sleep(10000);
		psearch.enterandclick_searchopration(searchitem);
		psearch.wait_msg_Foundresult(driver);
		Thread.sleep(5000);
		String Act_res = psearch.extract_Foundresult();
//		one way assert
//		Assert.assertEquals(Exp_res, Act_res);
		
//		second method
		if(Act_res.equals(Exp_res.replace(".0", ""))){
//			write to log file
			startTest.log(LogStatus.PASS, "Validate result", "Passed as Actual and expected results mached");
			searchlog.info( btype + ":" + TCID + ":" + order + "-" + "Passed as Actual and expected results mached");
			
		}else{
//			write to log file
			startTest.log(LogStatus.FAIL, "Validate result", "Failed as Actual result is " + Act_res + " and expected results is " + Exp_res+ "." + startTest.addScreenCapture(Screenshot(TCID , order)));
			searchlog.info( btype + ":" + TCID + ":" + order + "-" + "Failed as Actual result is " + Act_res + " and expected results is " + Exp_res+ ".");
//			write to TESTNGreports
			Assert.fail(btype + ":" + TCID + ":" + order + "-" + "Failed as Actual result is " + Act_res + " and expected results is " + Exp_res+ ".");
			
		}
		
		
		
	}
	
	

}
