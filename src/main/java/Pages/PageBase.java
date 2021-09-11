package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	protected WebDriver driver;
	
	//create constructor
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	protected static void clickButton(WebElement button)
	{
		button.click();
	}

	protected static void setTextElementText(WebElement textElement, String value)
	{
		textElement.sendKeys(value);
	}
	
	
	public void clearText(WebElement element) 
	{
		element.clear();
	}
	public void Checkcheckbox(WebElement checkbox)
	{
		checkbox.click();
	}
	
}


