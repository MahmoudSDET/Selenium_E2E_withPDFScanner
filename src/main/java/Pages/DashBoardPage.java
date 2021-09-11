package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage extends PageBase {

	
	WebDriverWait wait;
	Actions act;
	public DashBoardPage(WebDriver driver) {
		super(driver);
		wait =new WebDriverWait(driver, 30);
		act= new Actions(driver);
		
	}
	
	@FindBy (xpath ="//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	WebElement womenSectionTapMenu;

	@FindBy (xpath="//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a")
	WebElement selectBlouseProduct;
	
	@FindBy (xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	WebElement selectBlouseProductInStock;
	
	@FindBy (xpath="//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")
	WebElement addToCard;
	
	@FindBy (xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	public WebElement SucceessHeaderAddedToCart;
	
	@FindBy (xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
	public WebElement   proceedToCheckOutPage;
	
	
	public void SelectProductFromMenu()
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(womenSectionTapMenu));
		act.moveToElement(womenSectionTapMenu).build().perform();
		wait.until(ExpectedConditions.visibilityOfAllElements(selectBlouseProduct));
		clickButton(selectBlouseProduct);
		wait.until(ExpectedConditions.visibilityOfAllElements(selectBlouseProductInStock));
		act.moveToElement(selectBlouseProductInStock).build().perform();
		wait.until(ExpectedConditions.visibilityOfAllElements(addToCard));
		clickButton(addToCard);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(SucceessHeaderAddedToCart));
	}
	public void GoToOrderSummaryDetailsPage()
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(proceedToCheckOutPage));
		act.moveToElement(proceedToCheckOutPage).click().build().perform();
		
		
	}
	
	
	
	

}
