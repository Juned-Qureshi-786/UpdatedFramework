package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogPage extends AbstractComponent{

	WebDriver driver;
	WebElement prod;
	public ProductCatalogPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="div.mb-3")
	List<WebElement> products; 	
	By productsBy = By.cssSelector("div.mb-3");
	By toastBy=By.cssSelector("#toast-container");
	@FindBy(css=".card-body button:last-child")
	WebElement addToCart;
	@FindBy(css=".ng-animating")
	WebElement disappearElement;
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessagElement;
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products; 
	}
	public WebElement getProductByName(String productName,List<WebElement> products) {
		prod=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public String getErrorMessage() {
		waitForElementToAppear1(errormessagElement);
		return errormessagElement.getText();
	}
	public void addProductToCart(WebElement prod) throws InterruptedException {
	WebElement addCart= prod.findElement(By.cssSelector(".card-body button:last-child"));
	waitForElementToClickable(addCart);
	waitForElementToMove(addCart);
	waitForElementToAppear(toastBy);
	waitForElementToDisAppear(disappearElement);
	}
}
