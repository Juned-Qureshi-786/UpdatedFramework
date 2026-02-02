package rahulshettyacademy.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.ProductCatalogPage;

public class ErrorValidationsTest extends BaseTest{

	@Test
	public void errorValidation()
	{
		
	// Login
	ProductCatalogPage productCatalog = loginPage.login("oraib59@gmaiil.com", "Oraib786");
	String error=productCatalog.getErrorMessage();
	System.out.println(error);
	Assert.assertEquals("Incorrect email or password.", productCatalog.getErrorMessage());
}}
