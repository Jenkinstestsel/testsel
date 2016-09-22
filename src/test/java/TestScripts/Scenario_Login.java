package TestScripts;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;







import com.relevantcodes.extentreports.LogStatus;

import Generic_library.Baseclass;
import PageObjectFactory.Pagefactory_Login;


public class Scenario_Login extends Baseclass {

	static Logger loginlog = Logger.getLogger(Scenario_Login.class);
	@Test(dataProvider="invalidLogin",dataProviderClass=Data_Providers.DP_Login.class,groups={"smoke","regression"})
	public void Invalid_Login(String TC_ID,String order,String Uname,String Pwd,String Exp_Result) throws Exception{
		startTest = Projreports.startTest(btype + "-" + TC_ID );
		SoftAssert softAssert = new SoftAssert();
// commented as added before method and after method in base class
//		initialize_Browser();
		
		Pagefactory_Login pom_login = new Pagefactory_Login(driver);
		
		
//		--------------------------------------------------
//		driver.findElement(By.linkText("Sign In")).click();
		pom_login.click_SigninButton();
//		------------------------------------------------------

//		--------------------------------------------------	
//		driver.findElement(By.name("logid")).sendKeys(Uname);
//		driver.findElement(By.name("pswd")).sendKeys(Pwd);
//		driver.findElement(By.cssSelector("input[value='Login']")).click();
		pom_login.Enter_logindetails(Uname, Pwd);
//		---------------------------------------------------		

//		---------------------------------------------------	
//		String Actual_Result = driver.findElement(By.xpath("//b[contains(text(),'Sorry we were unable to complete this step because :')]")).getText();
		String Actual_Result=pom_login.extract_invalidLoginMessage();
//		---------------------------------------------------------------
if(Actual_Result.equals(Exp_Result)){
	startTest.log(LogStatus.PASS, "Invalid login", "Passed as Actual and expected results mached");
}else{
	startTest.log(LogStatus.FAIL, "Invalid login", "Failed as message not matching." + startTest.addScreenCapture(Screenshot(TC_ID , order)));
}
		softAssert.assertEquals(Actual_Result, Exp_Result);
		// commented as added before method and after method in base class
//		teardown();
		softAssert.assertAll();
	}
	
//	@Test(dataProvider="validLogin",dataProviderClass=Data_Providers.DP_Login.class,groups={"smoke"})
	public void Valid_Login(String TC_ID,String order,String Uname,String Pwd,String Exp_Result){
		SoftAssert softAssert = new SoftAssert();
		
//// commented as added before method and after method in base class
//		initialize_Browser();
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.name("logid")).sendKeys(Uname);
		driver.findElement(By.name("pswd")).sendKeys(Pwd);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		String Actual_Result = driver.findElement(By.className("proper")).getText();
//		HardAssert : Note- it means a assert failur will not not execute remaining script
//		Assert.assertEquals(Actual_Result, Exp_Result);
		
		
//		Soft Assert
		softAssert.assertEquals(Actual_Result, Exp_Result);
		// commented as added before method and after method in base class
//		teardown();
		softAssert.assertAll();
		
	}

	
	
}








