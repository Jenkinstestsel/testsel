package PageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pagefactory_Product {

	
	@FindBy(className="addtocartbtn")
	WebElement bt_BuyNow;
	
	public Pagefactory_Product(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	public void click_BuyNow(){
		
		bt_BuyNow.click();	
	}
	
	
	
	
	
	
	
	
	
}
