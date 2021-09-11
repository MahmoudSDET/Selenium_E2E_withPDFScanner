package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentMethodDetailsPage extends PageBase {

	

	WebDriverWait wait;
	Actions act;
	public PaymentMethodDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		wait =new WebDriverWait(driver, 30);
		act= new Actions(driver);
		
	}
	
	
	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button")
	public	WebElement confirmSelectingPaymentMethod;
	
	
	public void ConfirmOrder() {
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"step_end\"]/span")));
		act.moveToElement(confirmSelectingPaymentMethod).click().build().perform();
	}
	
	
	
    
}
