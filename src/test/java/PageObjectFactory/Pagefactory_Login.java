package PageObjectFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pagefactory_Login {
	
	@FindBy(linkText="Sign In")
	private WebElement Signin;
	
//	WebElement Signin = driver.findElement(By.linkText("Sign In"));
	
	@FindBy(name="logid")
	WebElement login_username;
	
	@FindBy(name="pswd")
	WebElement login_password;
	
	
	@FindBy(css="input[value='Login']")
	WebElement login_button;
	
	@FindBy(className="proper")
	WebElement login_vaildname;
	
	@FindBy(xpath="//b[contains(text(),'Sorry we were unable to complete this step because :')]")
	WebElement login_invalidmsg;
	
	public Pagefactory_Login(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void click_SigninButton(){
		Signin.click();
	}
	public void enter_username(String uname){
		login_username.sendKeys(uname);
	}
	public void enter_Password(String pwd){
		login_password.sendKeys(pwd);
	}
	
	public void click_LoginButton(){
		login_button.click();
	}
	public String extract_invalidLoginMessage(){
		return login_invalidmsg.getText();
	}
	public String extract_validLoginMessage(){
		return login_vaildname.getText();
	}
	
	public void Enter_logindetails(String uname,String Pwd){
		enter_username(uname);
		enter_Password(Pwd);
		click_LoginButton();
		
	}

}








