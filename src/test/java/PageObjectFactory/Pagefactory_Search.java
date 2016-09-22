package PageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pagefactory_Search {

	
	@FindBy(id="srchword")
	WebElement txt_search;
	
	@FindBy(className="newsrchbtn")
	WebElement bt_Searchforbooks;
	
	@FindBy(id="find")
	WebElement msg_Foundresult;
	
	@FindBy(className="sorrymsg")
	WebElement msg_Sorryresult;
	
	@FindBy(css="img[alt='Flood and Fire: Book by Janet Elaine Smith']")
	WebElement img_product;
	
	
	public Pagefactory_Search(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	public void enter_Searchitem(String sitem){
		
		txt_search.sendKeys(sitem);		
	}
	
	public void click_Searchforbooks(){
		
		bt_Searchforbooks.click();	
	}
	
	public void click_product(){
		
		img_product.click();	
	}
	
	public void wait_msg_Foundresult(WebDriver driver){
//		Explicit wait for the driver
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(msg_Foundresult));
		
	}
	
	public void wait_msg_img_product(WebDriver driver){
//		Explicit wait for the driver
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(img_product));
		
	}
	public String extract_Foundresult(){
		
		return msg_Foundresult.getText();	
	}
	
	
	public String extract_Sorryresult(){
		
		return msg_Sorryresult.getText();	
	}
	
	public void enterandclick_searchopration(String searchitem){
		
		enter_Searchitem(searchitem);
		click_Searchforbooks();
	}
	
}
