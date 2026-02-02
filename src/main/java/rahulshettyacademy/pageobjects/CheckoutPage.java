package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
 WebDriver driver;
	@FindBy(css="li.totalRow button")
	WebElement checkOutElement;
	@FindBy(css="input[placeholder='Select Country'")
	WebElement countryElements;
	@FindBy(css="section.ta-results button:nth-of-type(2)")
	WebElement selectCountryElement;
	@FindBy(css="a.btnn.action__submit")
	WebElement submitElement;
	@FindBy(css="#toast-container")
	WebElement toastElement;
	
	By spinnerBy=By.cssSelector(".ta-results");
	By submitSpinnerBy= By.cssSelector("a.btnn.action__submit");
	public CheckoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void submitOrder() {
		checkOutElement.click();
		countryElements.sendKeys("india");
		waitForElementToAppear(spinnerBy);
		selectCountryElement.click();
		waitForElementToAppear(submitSpinnerBy);
		waitForElementToMove(submitElement);
		//waitForElementToDisAppear(toastElement);
	}
}
