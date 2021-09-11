package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSummaryDetailsPage extends PageBase{

	
	WebDriverWait wait;
	Actions act;
	public OrderSummaryDetailsPage(WebDriver driver) {
		super(driver);
		wait =new WebDriverWait(driver, 30);
		act= new Actions(driver);
	}
	
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]")
	WebElement GotoOrderDeliveryAddressPage;
	
	@FindBy(xpath="//*[@id=\"total_product\"]")
public	WebElement TotalPriceOfProducts;
	
	public void GoToOrderDeliveryAddressDetailsPage()
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(GotoOrderDeliveryAddressPage));
		act.moveToElement(GotoOrderDeliveryAddressPage).click().build().perform();
		
		
	}
	
	
	

}
