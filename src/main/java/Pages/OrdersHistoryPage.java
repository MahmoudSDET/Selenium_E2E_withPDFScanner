package Pages;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrdersHistoryPage  extends PageBase{

	
	WebDriverWait wait;
	Actions act;
	public OrdersHistoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		wait =new WebDriverWait(driver, 30);
		act= new Actions(driver);
	}
	
	@FindBy(xpath="//*[@id=\"order-list\"]/tbody/tr/td[1]/a")
public	WebElement OrderReference;
	
	@FindBy(xpath="//*[@id=\"block-order-detail\"]/div[2]/p[3]/a")
	public	WebElement downloadButton;
	
	
	public void downloadPDFInvoice() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(OrderReference));
		
		act.moveToElement(OrderReference).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfAllElements(downloadButton));
		act.moveToElement(downloadButton).click().build().perform();
		Thread.sleep(10000);
		
		
	}
	
     public String ReadPDFInvoice( String filepath) throws IOException {
		
    	 File file = new File(filepath);
         PDDocument document = PDDocument.load(file);
         //Instantiate PDFTextStripper class
         PDFTextStripper pdfStripper = new PDFTextStripper();
         //Retrieving text from PDF document
         String text = pdfStripper.getText(document);
         System.out.println(text);
         //Closing the document
         document.close();
         
         return text;
		
		
	   }
	
	

}
