package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(linkText="Sign in")
	public WebElement signinLink;
	
	@FindBy(linkText="Sign out")
	WebElement signoutLink;
	
	public void openLoginPage()
	{
		clickButton(signinLink);
	}
	public void signout()
	{
		clickButton(signoutLink);
	}
	

}
