package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
public WebDriver driver;
	public LoginPage( WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@id='login2']")
	WebElement loginlink;
	@FindBy(xpath="//input[@id='loginusername']")
	WebElement loginuser;
	@FindBy(xpath="//input[@id='loginpassword']")
	WebElement loginpasswd;
	@FindBy(xpath="//button[@onclick='logIn()']")
	WebElement loginclk;
	@FindBy(xpath="//a[@id='nameofuser']")
	WebElement verifyclk;
	public void LoginClk() {
		loginlink.click();
	}
	public void EnterUsername(String User) {
		loginuser.sendKeys(User);
	}
	
	public void EnterPassword(String Passwd) {
		loginpasswd.sendKeys(Passwd);
//		Thread.sleep(2000);
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));		
//		wait.until(ExpectedConditions.textToBePresentInElement(loginpasswd, Passwd));
		
	}
	public void LoginSubmit() {		
		loginclk.click();
	}
	public void VerifyLogin() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(verifyclk));
		verifyclk.getText();
//		Assert.assertEquals(verifyclk, "Welcome Padmini");

		if(verifyclk.isDisplayed()) {
			String msg=verifyclk.getText();
			System.out.println(msg);
		}
		
		
	}
	
}
