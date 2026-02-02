package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//PageFactory
	@FindBy(id="userEmail")
	WebElement userEmailElement;
	@FindBy(id="userPassword")
	WebElement userPasswordElement;
	@FindBy(id="login")
	WebElement submit;
	
	public ProductCatalogPage login(String userEmail,String userPassword) 
	{
		userEmailElement.sendKeys(userEmail);
		userPasswordElement.sendKeys(userPassword);
		submit.click();	
		ProductCatalogPage productCatalog = new ProductCatalogPage(driver);
		return productCatalog;
	}
	public void open()
	{
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}

}
