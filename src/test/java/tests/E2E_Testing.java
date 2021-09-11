package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pages.DashBoardPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrderDeliveryAddressPage;
import Pages.OrderDetailsPage;
import Pages.OrderPaymentDetailsPage;
import Pages.OrderShippingPage;
import Pages.OrderSummaryDetailsPage;
import Pages.OrdersHistoryPage;
import Pages.PaymentMethodDetailsPage;
import Pages.RegistrationPage;

import data.ExcelReaderAndWriter;

public class E2E_Testing extends TestBase{
	Faker fakeData = new Faker();
	LoginPage LoginObject;
	HomePage HomeObject;
	RegistrationPage registerObject;
	DashBoardPage dashboardobject;
	OrderSummaryDetailsPage ordersummaryobject;
	OrderDeliveryAddressPage orderdeliveryaddressobject;
	OrderShippingPage ordershippingobject;
	
	OrderPaymentDetailsPage orderpaymentobject;
	PaymentMethodDetailsPage paymentmethodobject;
	OrderDetailsPage orderdetailsobject; 
	OrdersHistoryPage   orderhistoryobject;
	
	ExcelReaderAndWriter ER = new ExcelReaderAndWriter();
	String email = fakeData.internet().emailAddress();
	String firstname = fakeData.name().firstName();
	String lastname = fakeData.name().lastName();
	String password =fakeData.number().digits(8).toString();
	String address = fakeData.address().fullAddress();
	String city = fakeData.address().cityName();
	String state = fakeData.name().toString();
	String postcode =fakeData.number().digits(5).toString();
	String mobile = fakeData.phoneNumber().cellPhone();
	private static Logger log=LogManager.getLogger(E2E_Testing.class.getName());
	
	
	
	@Test (priority=1)
	public void Userregistersuccessfully() throws IOException
	{
		HomeObject =new HomePage(driver);
		HomeObject.openLoginPage();
		LoginObject = new LoginPage(driver);
		LoginObject.GotoregisterPage(email);
		registerObject= new RegistrationPage(driver);
		registerObject.userRegisteration1(firstname, lastname, password, address, city, state, postcode , mobile);
		ER.copydatatofile(firstname, lastname,email, address, mobile, password);
		registerObject.clicregisterbutton();
		Assert.assertTrue(registerObject.successmessage.getText().contains("Welcome to your account."));
		log.info("User registered successfully and wrote email and pssword to user data excel sheet");
		
	}

	@Test (dependsOnMethods = {"Userregistersuccessfully"})
	public void RegisteredUserCanLogout()
	{
		registerObject.userlogout();
		log.info("User logout");
	}
	
	@Test (dependsOnMethods = {"RegisteredUserCanLogout"})
	public void RegisterUserCanLogin() throws IOException 
	{
		HomeObject =new HomePage(driver);
		HomeObject.openLoginPage();
		LoginObject = new LoginPage(driver);
		String [] getdata=ER.getloginData();
		System.out.println(getdata[0]+ " "+ getdata[1]);
		LoginObject.UserLogin(getdata[0], getdata[1]);
		Assert.assertTrue(registerObject.SignoutLink.getText().contains("Sign out"));
	}
	
	@Test (dependsOnMethods = {"RegisterUserCanLogin"})
	public void RegisterUserCanSelectProduct() throws IOException, InterruptedException 
	{
		
		dashboardobject=new DashBoardPage(driver);
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dashboardobject.SelectProductFromMenu();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(dashboardobject.SucceessHeaderAddedToCart.getText().trim().contains("Product successfully added to your shopping cart"));
	}
	
	@Test (dependsOnMethods = {"RegisterUserCanSelectProduct"})
	public void RegisterUserCanFollowCheckOutProcedure() throws IOException 
	{
		dashboardobject=new DashBoardPage(driver);
		dashboardobject.GoToOrderSummaryDetailsPage();
		ordersummaryobject=new OrderSummaryDetailsPage(driver);
		// System.out.print(ordersummaryobject.TotalPriceOfProducts.getText().toString());
		 String totalpricebeforeshipping=ordersummaryobject.TotalPriceOfProducts.getText().toString().substring(1);
		 
		double totalOfProductsBeforeShipping=Double.parseDouble(totalpricebeforeshipping);
		System.out.print(totalOfProductsBeforeShipping);
		ordersummaryobject.GoToOrderDeliveryAddressDetailsPage();
		
		orderdeliveryaddressobject=new OrderDeliveryAddressPage(driver);
		orderdeliveryaddressobject.GoToOrderShippingPage();
		ordershippingobject=new OrderShippingPage(driver);
		ordershippingobject.GoToOrderPaymentPage();
		orderpaymentobject=new OrderPaymentDetailsPage(driver);
	    System.out.print(orderpaymentobject.TotalPriceOfProductsAfterShipping.getText().toString());
		String totalOfProductsAfterShipping=orderpaymentobject.TotalPriceOfProductsAfterShipping.getText().toString().substring(1);
		double totalpriceafterhipping=Double.parseDouble(totalOfProductsAfterShipping);
		
		
		Assert.assertTrue(totalpriceafterhipping > totalOfProductsBeforeShipping);
	}
	
	@Test (dependsOnMethods = {"RegisterUserCanFollowCheckOutProcedure"})
	public void RegisterUserCanConfirmCheckOrderBySelectingBankWireOption() throws IOException 
	{
		orderpaymentobject=new OrderPaymentDetailsPage(driver);
		
		orderpaymentobject.SelectingBankWireoption();
		
		paymentmethodobject=new PaymentMethodDetailsPage(driver);
		
		paymentmethodobject.ConfirmOrder();
		
		orderdetailsobject=new OrderDetailsPage(driver);
		
		Assert.assertTrue(orderdetailsobject.OrderCompletedElement.getText().trim().contains("Your order on My Store is complete."));
		
		
		
	}
	
	@Test (dependsOnMethods = {"RegisterUserCanConfirmCheckOrderBySelectingBankWireOption"})
	public void Validateorderwasplacedfromorderhistorypage() throws IOException, InterruptedException 
	{
		
		orderdetailsobject=new OrderDetailsPage(driver);
		
		
		orderdetailsobject.moveToContainingOrderReferenceElement();
		
		assertTrue(orderdetailsobject.containingOrderReference.isDisplayed());
		System.out.println(orderdetailsobject.containingOrderReference.getText().trim().replace("\n", "").replace("\r", ""));
		String [] OrderReferenceOnOrderDetailsarrays=orderdetailsobject.containingOrderReference.getText()
				.trim().replace("\n", "").replace("\r", "").split("reference");
		
	
	    String OrderReferenceOnOrderDetails=OrderReferenceOnOrderDetailsarrays[1].split(" ")[1];
	    
	    orderdetailsobject.GoToHistoryOrders();
	    
	    orderhistoryobject  =new OrdersHistoryPage(driver);
	   
	    String ExpectedOrderReference=orderhistoryobject.OrderReference.getText().trim().toString();
	    assertEquals(OrderReferenceOnOrderDetails, ExpectedOrderReference);
	}
	
	@Test (dependsOnMethods = {"Validateorderwasplacedfromorderhistorypage"})
	public void ValidateOrderDetailsOnBillInvoice() throws IOException, InterruptedException 
	{
		
		
	    
	    orderhistoryobject  =new OrdersHistoryPage(driver);
	    String ExpectedOrderReference=orderhistoryobject.OrderReference.getText().trim().toString();
	    
	    orderhistoryobject.downloadPDFInvoice();
	    
	String OrderPDFText=orderhistoryobject.ReadPDFInvoice(TestBase.getLastModified().getAbsolutePath());
	   
	   
	   assertTrue(OrderPDFText.contains(ExpectedOrderReference));
	}
	
	
	
}
