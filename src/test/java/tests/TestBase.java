package tests;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class TestBase {
	public  WebDriver driver;
	private static Logger log=LogManager.getLogger(TestBase.class.getName());

	public static String downloadPath = System.getProperty("user.dir")+"\\Downloads";
	
	public static String FiledownloadPath = System.getProperty("user.dir")+"\\Downloads\\IN211858.pdf";
	
	public static ChromeOptions chromeoption()
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeprefs = new HashMap<String, Object>();
		chromeprefs.put("profile.default.content_settings.popups", 0);
		chromeprefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromeprefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability("screenResolution", "1024x768");
		return options;

	}
	public static FirefoxOptions firefoxoption()
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		//option.setCapability("screenResolution", "1920x1080");
		return option;
	}

	
	@BeforeTest
	@Parameters("browser")
	public void startDriver(String browserName)
	{
		
		if (browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chrome driver isintializing");
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Firefox driver isintializing");
		}
		//driver.manage().window().setSize(new Dimension(1024, 768));
		//driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
    	driver.manage().window().setSize(new Dimension(1024, 768));
		log.info("Navigate to website");
	}
	@AfterSuite
	public void stopDriver()
	{

		//driver.close();

	}
	//Take screenshot when test case fail and add it in the screenshot folder
	public void captureScreenShot (String result)
	{
		Path dest =Paths.get(".//Screenshots//"+result+"schreetshot.png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());

			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} 
		catch (IOException e) 
		{

			System.out.println("Exception while taking screenshot"+ e.getMessage());
		}

	}
	
	
	public static File getLastModified()
	{
	    File directory = new File(downloadPath);
	    File[] files = directory.listFiles(File::isFile);
	    long lastModifiedTime = Long.MIN_VALUE;
	    File chosenFile = null;

	    if (files != null)
	    {
	        for (File file : files)
	        {
	            if (file.lastModified() > lastModifiedTime)
	            {
	                chosenFile = file;
	                lastModifiedTime = file.lastModified();
	            }
	        }
	    }

	    return chosenFile;
	}
}



