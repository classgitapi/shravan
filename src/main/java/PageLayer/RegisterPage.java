package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utilsLayer.UtilsClass.*;

import BaseLayer.BaseClass;

public class RegisterPage extends BaseClass{
	
	@FindBy(name="firstname")
	private WebElement fname;
	
	@FindBy(name="lastname")
	private WebElement lname;
	
	@FindBy(name="reg_email__")
	private WebElement email;
	
	@FindBy(name="reg_passwd__")
	private WebElement pwd;
	
	@FindBy(name="birthday_day")
	private WebElement day;
	
	@FindBy(name="birthday_month")
	private WebElement month;
	
	
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void registerPageFunctionality(String firstname1, String surname1, String mobNo1, String newPass1, String day1,
			String month1){
	
		sendKeys(fname, firstname1);
		sendKeys(lname, surname1);
		sendKeys(email, mobNo1);
		sendKeys(pwd, newPass1);
		sendKeys(day, day1);
		sendKeys(month, month1);
		
		
	}

	

}














