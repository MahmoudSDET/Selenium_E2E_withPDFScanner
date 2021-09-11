package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPaymentDetailsPage extends PageBase {

	
	WebDriverWait wait;
	Actions act;
	public OrderPaymentDetailsPage(WebDriver driver) {
		super(driver);
		wait =new WebDriverWait(driver, 30);
		act= new Actions(driver);
		
		
	}
	
	@FindBy(xpath="//*[@id=\"total_price\"]")
     public	WebElement TotalPriceOfProductsAfterShipping;
	
	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	public	WebElement Selectingbankwireoption;
	
	public void SelectingBankWireoption() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"step_end\"]/span")));
		act.moveToElement(Selectingbankwireoption).click().build().perform();
		
	}
	
	
	
	
	
	
	
	

}
