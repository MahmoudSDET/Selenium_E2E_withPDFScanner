package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderDetailsPage extends PageBase{

	JavascriptExecutor js ;
	
	WebDriverWait wait;
	Actions act;
	public OrderDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		wait =new WebDriverWait(driver, 30);
		act= new Actions(driver);
		js = (JavascriptExecutor) driver;
	}
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div")
public	WebElement containingOrderReference;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div/p/strong")
public	WebElement OrderCompletedElement;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p/a")
	WebElement backToOrders;
	
	
	public void moveToContainingOrderReferenceElement() throws InterruptedException {
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"step_end\"]/span")));
		js.executeScript("window.scrollBy(0,250)", "");
		//act.moveToElement(containingOrderReference).build().perform();
	}
	
	public void GoToHistoryOrders() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"step_end\"]/span")));
		act.moveToElement(backToOrders).click().build().perform();
		
	}
	
	
	

}
