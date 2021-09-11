package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage extends PageBase{
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		super(driver);
		wait =new WebDriverWait(driver, 30);
		
	}

	@FindBy (id="email_create")
	WebElement EmailAddresstxtBox;

	@FindBy (id="SubmitCreate")
	WebElement CreatAccountbtn;
	
	@FindBy (id="email")
	public WebElement Emailtxtbox;
	
	@FindBy (id="passwd")
	public WebElement Passwordtxtbox;

	@FindBy(linkText="Forgot your password?")
	WebElement ForgetpasswordLink;

	@FindBy (id="SubmitLogin")
	public WebElement Signinbtn;
	
	public void UserLogin(String email, String password)
	{
		setTextElementText(Emailtxtbox, email);
		setTextElementText(Passwordtxtbox, password);
		clickButton(Signinbtn);
	}
	
	public void GotoregisterPage(String Email)
	{
		
		wait.until(ExpectedConditions.visibilityOfAllElements(EmailAddresstxtBox));
		setTextElementText(EmailAddresstxtBox, Email);
		clickButton(CreatAccountbtn);
	}
	public void GotoForgetPasswordPage()
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(ForgetpasswordLink));
		clickButton(ForgetpasswordLink);
	}


}
