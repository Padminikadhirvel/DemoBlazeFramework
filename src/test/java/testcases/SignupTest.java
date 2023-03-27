package testcases;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.SignupPage;

public class SignupTest extends BaseClass {
@Test
public void SignupOperation() throws InterruptedException {
	SignupPage signup=new SignupPage(driver);
	signup.SignupClk();
	signup.EnterUser(prop.getProperty("User"));
	Thread.sleep(1000);
	signup.EnterPass(prop.getProperty("Password"));
	signup.SignupButton();
	signup.alertaccept();
	
	
}

}
