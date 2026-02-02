package rahulshettyacademy.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ProductCatalogPage;
//yes
public class SubmitOrderTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//String productName = "ZARA COAT 3";

		// Login
		ProductCatalogPage productCatalog = loginPage.login(input.get("email"),input.get("password"));

		// Product catalog
		List<WebElement> products = productCatalog.getProductList();
		WebElement prod = productCatalog.getProductByName(input.get("productName"), products);
		productCatalog.addProductToCart(prod);
		CartPage cartPage = productCatalog.navigateToCart();

		// Cart
		boolean match = cartPage.getCartProduct(input.get("productName"));
		Assert.assertTrue(match);

		// CheckOut
		// CheckoutPage checkoutPage = new CheckoutPage(driver);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.submitOrder();

		// Confirmation
		String confirmMsg = driver.findElement(By.cssSelector("h1")).getText();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
		// driver.quit();
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		/*
		 * Object[][] dataObjects= new Object[2][3];
		 * dataObjects[0][0]="oraib59@gmaiil.com"; dataObjects[0][1]="Oraib@786";
		 * dataObjects[0][2]="ZARA COAT 3"; dataObjects[1][0]="juned59@gmail.com";
		 * dataObjects[1][1]="Oraib@786"; dataObjects[1][2]="ADIDAS ORIGINAL";
		 */
		/*
		 * HashMap<String,String> map= new HashMap<String,String>(); map.put("email",
		 * "oraib59@gmaiil.com"); map.put("password", "Oraib@786");
		 * map.put("productName", "ZARA COAT 3"); HashMap<String,String> map1=new
		 * HashMap<String,String>(); map1.put("email", "juned59@gmail.com");
		 * map1.put("password", "Oraib@786"); map1.put("productName",
		 * "ADIDAS ORIGINAL");
		 */
		List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir")
				+ "/src/test/java/rahulshettyacademy/data/PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
		
}
