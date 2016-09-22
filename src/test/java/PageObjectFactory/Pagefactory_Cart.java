package PageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pagefactory_Cart {

	@FindBy(xpath=".//*[@id='currentcartdiv']/div/form/div/table[1]/tbody/tr[3]/td/table/tbody/tr/td[1]/div[2]/span[2]")
	private WebElement txtmsg_productname;
	
	
	public Pagefactory_Cart(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String extract_productname(){
		return txtmsg_productname.getText();
	}
	
	
	
	
	
	
}
