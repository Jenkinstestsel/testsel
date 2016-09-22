package TestScripts;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;







import Generic_library.Baseclass;
import PageObjectFactory.Pagefactory_Cart;
import PageObjectFactory.Pagefactory_Login;
import PageObjectFactory.Pagefactory_Product;
import PageObjectFactory.Pagefactory_Search;

public class Scenario_Cart_Map extends Baseclass {
	
	static Logger cartlog = Logger.getLogger(Scenario_Cart_Map.class);
	
	@Test(dataProvider="Add_Cart_map",dataProviderClass=Data_Providers.DP_Cart_Map.class)
	public void AddtoCart(Map Cartdata) throws Exception{
	String TCID = Cartdata.get("TCID").toString();
	String order =Cartdata.get("Order").toString();
//	perform Logine
		Pagefactory_Login pom_login = new Pagefactory_Login(driver);
		pom_login.click_SigninButton();
		pom_login.Enter_logindetails(Cartdata.get("Username").toString(),Cartdata.get("Password").toString());
		Thread.sleep(7000);
		Assert.assertEquals("Buy Books Online | Online Bookstore India | Online Book Shopping | Free Shipping Across India", driver.getTitle());
		Screenshot(TCID,order);
		Pagefactory_Search pom_search=new Pagefactory_Search(driver);
		pom_search.enterandclick_searchopration(Cartdata.get("SearchString").toString());

		pom_search.wait_msg_Foundresult(driver);
		pom_search.wait_msg_img_product(driver);
		pom_search.click_product();
		
		if(driver.getTitle().contains("Flood and Fire")){
			Screenshot(TCID,order);
			cartlog.info(btype +":" +TCID + ":" + order + "--" + "Passed as user has landed on Product page");
			Reporter.log(btype+":" +TCID + ":" + order + "--" + "Passed as user has landed on Product page");
		}else{
			Screenshot(TCID,order);
			cartlog.info(btype+":" +TCID + ":" + order + "--" + "Failed as user was not able to reach the page");
			Reporter.log(btype+":" +TCID + ":" + order + "--" + "Failed as user was not able to reach the page");
			Assert.fail(btype+":" +  TCID + ":" + order + "--" + "Failed as user was not able to reach the page");	
		}
		
		Pagefactory_Product pom_product = new Pagefactory_Product(driver);
		pom_product.click_BuyNow();
		
		Pagefactory_Cart pom_cart = new Pagefactory_Cart(driver);
		String Act_res = pom_cart.extract_productname();
		Screenshot(TCID,order);
		Assert.assertEquals(Act_res, Cartdata.get("Exp_Result").toString());
		
	
	
	}

}





