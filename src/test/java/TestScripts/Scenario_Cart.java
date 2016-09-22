package TestScripts;




import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



import Generic_library.Baseclass;
import PageObjectFactory.Pagefactory_Cart;
import PageObjectFactory.Pagefactory_Login;
import PageObjectFactory.Pagefactory_Product;
import PageObjectFactory.Pagefactory_Search;

public class Scenario_Cart extends Baseclass {
	
	static Logger cartlog = Logger.getLogger(Scenario_Cart.class);
	
	@Test(dataProvider="Add_Cart",dataProviderClass=Data_Providers.DP_Cart.class)
	public void AddtoCart(String TCID,String order,String Uname,String pwd,String Searchstring, String quantity, String Exp_Result ){
	
//	perform Logine
		Pagefactory_Login pom_login = new Pagefactory_Login(driver);
		pom_login.click_SigninButton();
		pom_login.Enter_logindetails(Uname,pwd);
		Assert.assertEquals("Buy Books Online | Online Bookstore India | Online Book Shopping | Free Shipping Across India", driver.getTitle());
		
		Pagefactory_Search pom_search=new Pagefactory_Search(driver);
		pom_search.enterandclick_searchopration(Searchstring);
		pom_search.click_product();
		
		if(driver.getTitle().contains("Flood and Fire")){
			cartlog.info(TCID + ":" + order + "--" + "Passed as user has landed on Product page");
			Reporter.log(TCID + ":" + order + "--" + "Passed as user has landed on Product page");
		}else{
			cartlog.info(TCID + ":" + order + "--" + "Failed as user was not able to reach the page");
			Reporter.log(TCID + ":" + order + "--" + "Failed as user was not able to reach the page");
			Assert.fail(TCID + ":" + order + "--" + "Failed as user was not able to reach the page");	
		}
		
		Pagefactory_Product pom_product = new Pagefactory_Product(driver);
		pom_product.click_BuyNow();
		
		Pagefactory_Cart pom_cart = new Pagefactory_Cart(driver);
		String Act_res = pom_cart.extract_productname();
	
		Assert.assertEquals(Act_res, Exp_Result);
		
	
	
	}

}





