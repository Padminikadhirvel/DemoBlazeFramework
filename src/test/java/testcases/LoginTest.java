package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;

public class LoginTest extends BaseClass{
	@Test
	public void LoginOperation(){
//		LoginPage login=new LoginPage(driver);
		LoginPage page=new LoginPage(driver);
		page.LoginClk();
		page.EnterUsername(prop.getProperty("User"));
		page.EnterPassword(prop.getProperty("Password"));
		page.LoginSubmit();
		page.VerifyLogin();
	}

	
}
