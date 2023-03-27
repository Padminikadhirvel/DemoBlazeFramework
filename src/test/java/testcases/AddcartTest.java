package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AddcartPage;


public class AddcartTest extends BaseClass {
	
@Test
public void Addproductoperation() {
	AddcartPage cart=new AddcartPage(driver);
	cart.Selectproduct();
	cart.Addcart();
	cart.getmsg();

	cart.cartclick();
	cart.verifyamt();
	cart.orderplacement();
	cart.Entername(prop.getProperty("Name"));
	cart.Entercountry(prop.getProperty("Country"));
	cart.Entercity(prop.getProperty("City"));
	cart.Entercard(prop.getProperty("Card"));
	cart.Entermonth(prop.getProperty("Month"));
	cart.Enteryear(prop.getProperty("Year"));
	cart.purchase();
	cart.displydetails();
}
}
