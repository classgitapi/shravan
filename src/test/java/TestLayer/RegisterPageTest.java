package TestLayer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.RegisterPage;
import utilsLayer.ExcelReader;

public class RegisterPageTest extends BaseClass{
	
	@BeforeTest
	public void setUp() {
		initialization();
	}
	
	@Test(dataProvider="addUserData")
	public void validateRegisterPage(String firstname, String surname, String mobNo, String newPass, String day, String month) {
	
		RegisterPage reg = new RegisterPage();
		reg.registerPageFunctionality(firstname, surname, mobNo, newPass, day, month);
		driver.navigate().refresh();
	}
	
	@DataProvider
	public Object [][] addUserData(){
		ExcelReader exr = new ExcelReader(System.getProperty("user.dir")+ "\\src\\main\\java\\TestDataLayer\\abcd.xlsx");
		Object data [][] = exr.getTestData(0);
		return data;
	}

}






