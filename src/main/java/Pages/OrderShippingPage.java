package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderShippingPage extends PageBase {

	
	WebDriverWait wait;
	Actions act;
	public OrderShippingPage(WebDriver driver) {
		super(driver);
		wait =new WebDriverWait(driver, 30);
		act= new Actions(driver);
		
	}
	
	
	@FindBy(xpath="//input[@type='radio']//parent::span/input")
	WebElement shippingradio;
	
	@FindBy(xpath="//*[@id=\"cgv\"]")
	WebElement AggreedWithTerms;
	
	@FindBy(xpath="//*[@id=\"form\"]/p/button")
	WebElement GotoOrderPaymentDetailsPage;
	
	public void GoToOrderPaymentPage()
	{
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='radio']//parent::span/input")));
		act.moveToElement(AggreedWithTerms).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfAllElements(GotoOrderPaymentDetailsPage));
		clickButton(GotoOrderPaymentDetailsPage);
		
		
		
	}

}
