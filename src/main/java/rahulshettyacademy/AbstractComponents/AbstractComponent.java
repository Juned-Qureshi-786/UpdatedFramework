package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.source.util.TreePathScanner;

import rahulshettyacademy.pageobjects.CartPage;

public class AbstractComponent {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartButtonElement;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		this.actions=new Actions(driver);
	}

	public void waitForElementToAppear(By findBy) {
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
}
	public void waitForElementToAppear1(WebElement findBy) {
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	public void waitForElementToDisAppear(WebElement disappearElement) throws InterruptedException {
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOf(disappearElement));
	}
	public void waitForElementToClickable(WebElement addCart) {
		wait.until(ExpectedConditions.elementToBeClickable(addCart));
	}
	public void waitForElementToMove(WebElement moveElement) {
		//Actions a = new Actions(driver);
		 actions.moveToElement(moveElement).click().build().perform();
	}
public CartPage navigateToCart() {
	waitForElementToMove(cartButtonElement);
	CartPage cartPage = new CartPage(driver);
	return cartPage;
}

}
	