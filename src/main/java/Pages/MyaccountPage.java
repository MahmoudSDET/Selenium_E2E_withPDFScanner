package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends PageBase{

	public MyaccountPage(WebDriver driver) {
		super(driver);
		
		
	}
	@FindBy (css="h1.page-heading")
	public WebElement Myaccounttxt;

}
