package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderDeliveryAddressPage extends PageBase {
	
	WebDriverWait wait;
	Actions act;
	public OrderDeliveryAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		wait =new WebDriverWait(driver, 30);
		act= new Actions(driver);
	}

	@FindBy(xpath="//*[@id=\"center_column\"]/form/p/button")
	WebElement GotoOrderShippingPage;
	
	
	public void GoToOrderShippingPage()
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(GotoOrderShippingPage));
		act.moveToElement(GotoOrderShippingPage).click().build().perform();
		
		
	}
	
	
	
	
	
	

}
