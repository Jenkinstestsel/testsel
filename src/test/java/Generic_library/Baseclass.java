package Generic_library;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Baseclass {
	
	public WebDriver driver;
	public String btype;
	public static ExtentReports Projreports;
	public ExtentTest startTest;
	
	
	
	@BeforeSuite
	public void intialsetup(){
		
		Date date= new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		Projreports= new ExtentReports("E:\\Snapshot\\" + "Automation_" + dateFormat.format(date) + ".html",false);
				
	}

	@Parameters("browser")
	@BeforeMethod
	public void initialize_Browser(String tbrowser) throws Exception{
		btype = tbrowser;
		if(tbrowser.equals("firefox")){
			driver = new FirefoxDriver();
			
		}else if(tbrowser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe" );
			driver=new ChromeDriver();
		}else if(tbrowser.equals("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\IEDriverServer.exe" );
			driver=new InternetExplorerDriver();
		}
		
		driver.get(Utility.getValue("URL"));
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
		Projreports.endTest(startTest);
		Projreports.flush();
		
			
	}
	
	@AfterSuite
	public void Projectend(){
		
//		Projreports.close();		
	}
	
	public String Screenshot(String TCID , String Order) throws Exception{
		Date date= new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		
//		String x = "34";
//		String y = (String)x;
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("E:\\Snapshot\\" +TCID +"_" + Order +"_"+ dateFormat.format(date) + ".png" ));
		return "E:\\Snapshot\\" +TCID +"_" + Order +"_"+ dateFormat.format(date) + ".png" ;
		
	}

}







