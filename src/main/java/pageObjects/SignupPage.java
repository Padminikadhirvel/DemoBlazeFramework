package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignupPage {
	public WebDriver driver;
	public SignupPage( WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="signin2")
	WebElement signuplink;
	@FindBy(id="sign-username")
	WebElement username;
	@FindBy(id="sign-password")
	WebElement passwd;
	@FindBy(xpath="//button[@onclick='register()']")
	WebElement signupclk;
	@FindBy(xpath="//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']")
	WebElement signupclose;
	public void SignupClk() {
		signuplink.click();
	}
	public void EnterUser(String User) {
		username.sendKeys(User);
	}
	public void EnterPass(String Password) {
		passwd.sendKeys(Password);
	}
	public void SignupButton() {
		signupclk.click();
	}
	public void alertaccept() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String alertmsg=alert.getText();
		alert.accept();
		Assert.assertEquals(alertmsg, "This user already exist.");
		if(alertmsg.equalsIgnoreCase("This user already exist."))
		{
		signupclose.click();
		System.out.println(alertmsg);
		}
		
	}
}
