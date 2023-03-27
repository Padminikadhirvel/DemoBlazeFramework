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

public class AddcartPage {
	public WebDriver driver;
	public AddcartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(.,'Samsung galaxy s6')]")
	WebElement selectgalaxy;
	@FindBy(xpath="//a[@onclick='addToCart(1)']")
	WebElement addcartbtn;
	
	
	@FindBy(xpath="//a[@id='cartur']")
	WebElement cartclk;
	@FindBy(xpath="//h3[@id='totalp']")
	WebElement amount;
	@FindBy(xpath="//a[.='Delete']")
	WebElement delete;
	@FindBy(xpath="//button[.='Place Order']")
	WebElement placeorder;
	@FindBy(xpath="//input[@id='name']")
	WebElement entername;
	@FindBy(xpath="//input[@id='country']")
	WebElement entercountry;
	@FindBy(xpath="//input[@id='city']")
	WebElement entercity;
	@FindBy(xpath="//input[@id='card']")
	WebElement entercardno;
	@FindBy(xpath="//input[@id='month']")
	WebElement entermonth;
	@FindBy(xpath="//input[@id='year']")
	WebElement enteryear;
	@FindBy(xpath="//button[@onclick='purchaseOrder()']")
	WebElement purchasebtn;
	
	@FindBy(xpath="//h2[contains(text(),'Thank you for your purchase!')]")
	WebElement thankmsg;
	@FindBy(xpath="//p[@class='lead text-muted ']")
	WebElement purchasedetails;
	@FindBy(xpath="//button[@class='confirm btn btn-lg btn-primary']")
	WebElement purchaseokbtn;
	
	
	public void Selectproduct() {
		selectgalaxy.click();
	}
	public void Addcart() {
		addcartbtn.click();
	}
	public void getmsg() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String msg=alert.getText();
		alert.accept();
		Assert.assertEquals(msg, "Product added");
		System.out.println("Product added successfuly");
	}
	
	
	
	public void cartclick() {
		cartclk.click();
	}
	public void verifyamt() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(amount));
		String amt=amount.getText();
		
		if(!amt.equalsIgnoreCase("360")) {
			delete.click();
			System.out.println("Selected Product Amount is mismatched with the Amount, Kindly Add the Product Again.");
		}
		else
			System.out.println("Your Payment is : "+amt);
		Assert.assertEquals(amt, "360");
	}
	
	public void orderplacement() {
		placeorder.click();		
	}
	public void Entername(String Name) {
		entername.sendKeys(Name);
	}
	public void Entercountry(String Country) {
		entercountry.sendKeys(Country);
	}
	public void Entercity(String City) {
		entercity.sendKeys(City);
	}
	public void Entercard(String Card) {
		entercardno.sendKeys(Card);
	}
	public void Entermonth(String Month) {
		entermonth.sendKeys(Month);
	}
	public void Enteryear(String Year) {
		enteryear.sendKeys(Year);
	}
	public void purchase() {
		purchasebtn.click();
	}
	public void displydetails() {
		Assert.assertEquals(thankmsg.getText(), "Thank you for your purchase!");
		String detail=purchasedetails.getText();
		System.out.println(detail);
		purchaseokbtn.click();
	}
}
