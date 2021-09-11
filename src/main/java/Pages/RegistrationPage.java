package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends PageBase{

	
	WebDriverWait wait;
	public RegistrationPage(WebDriver driver) {
		super(driver);
		wait =new WebDriverWait(driver, 30);
	}

	@FindBy(xpath="//*[@id='customer_firstname']")
	WebElement firstnameTxtbox;

	@FindBy(xpath="//*[@id='customer_lastname']")
	WebElement lastnameTxtbox;

	@FindBy(id="passwd")
	public WebElement passwordTxtbox;
	
	@FindBy(id="address1")
	WebElement addressTxtbox;
	
	@FindBy(id="city")
	WebElement cityTxtbox;
	
	@FindBy(xpath="//*[@id='uniform-id_state']/select")
	WebElement stateTxtbox;
	
	@FindBy(id="postcode")
	public WebElement postcodeTxtbox;
	
	@FindBy(id="phone_mobile")
	WebElement mobileTxtbox;
	
	
	@FindBy(id="submitAccount")
	WebElement registerbtn;
	
	@FindBy(css= "p.info-account")
	public WebElement successmessage;

	@FindBy(xpath="//*[@id='center_column']/div/ol/li[1]")
	public WebElement mobilevalidation;
	
	@FindBy(xpath="//*[@id='center_column']/div/ol/li[2]")
	public WebElement lnamevalidation;
	
	@FindBy(xpath="//*[@id='center_column']/div/ol/li[3]")
	public WebElement fnamevalidation;
	
	@FindBy(xpath="//*[@id='center_column']/div/ol/li[4]")
	public WebElement passwordValidation;
	
	@FindBy(xpath="//*[@id='center_column']/div/ol/li[5]")
	public WebElement addressValidation;
	
	@FindBy(xpath="//*[@id='center_column']/div/ol/li[6]")
	public WebElement cityValidation;
	
	@FindBy(xpath="//*[@id='center_column']/div/ol/li[7]")
	public WebElement codeValidation;
	
	@FindBy(xpath="//*[@id='center_column']/div/ol/li[8]")
	public WebElement stateValidation;
	
	@FindBy(linkText="Sign out")
	public WebElement SignoutLink;
	
	public void userRegisteration(String firstName, String lastName, String password, String address, String city,
			String state, String code, String mobile)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(firstnameTxtbox));
		setTextElementText(firstnameTxtbox, firstName);
		setTextElementText(lastnameTxtbox, lastName);
		setTextElementText(passwordTxtbox, password);
		setTextElementText(addressTxtbox, address);
		setTextElementText(cityTxtbox, city);
		setTextElementText(stateTxtbox, state);
		setTextElementText(postcodeTxtbox, code);
		setTextElementText(mobileTxtbox, mobile);
		clickButton(registerbtn);
	}
	
	public void userlogout()
	{
		clickButton(SignoutLink);
	}
	public void userRegisteration1(String firstName, String lastName, String password, String address, String city,
			String state, String code, String mobile)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(firstnameTxtbox));
		setTextElementText(firstnameTxtbox, firstName);
		setTextElementText(lastnameTxtbox, lastName);
		setTextElementText(passwordTxtbox, password);
		setTextElementText(addressTxtbox, address);
		setTextElementText(cityTxtbox, city);
		setTextElementText(stateTxtbox, state);
		setTextElementText(postcodeTxtbox, code);
		setTextElementText(mobileTxtbox, mobile);
		
	}
	
	public void clicregisterbutton()
	{
		clickButton(registerbtn);
	}
}
