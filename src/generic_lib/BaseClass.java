package generic_lib;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass 
{
	public static WebDriver driver;
	
	
	
	@BeforeClass
	
	//putting @parameter anotation for cross browser testing
	@Parameters("Browser")
	public void configBc(String browser) throws Throwable
	{
		String url= "http://www.imdb.com/chart/top";
		
		//configureing log4j with the baseClass
		BasicConfigurator.configure();
		PropertyConfigurator.configure("./log4j.properties");
		Logger log = Logger.getLogger("BaseClass");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"./servers/chromedriver.exe");
			driver=new ChromeDriver();
			log.info("Lunching chorme");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			log.info("Lunching Firefox");
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./servers/IEDriverServer.exe");
			   DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		       caps.setCapability("ignoreZoomSetting", true);
		       caps.setCapability("unexpectedAlertBehaviour", "accept");
		       caps.setCapability("ignoreProtectedModeSettings", true);
		       caps.setCapability("disable-popup-blocking", true);
		       caps.setCapability("enablePersistentHover", true);
		       caps.setCapability("nativeEvents",false);
		       driver = new InternetExplorerDriver(caps);
		       log.info("Lunching ie");
		}
		else if(browser.equalsIgnoreCase("opera"))
	   {
		   driver=new OperaDriver();
		   log.info("Lunching opera");
	   }
		
		
		//maximize the browser
		driver.manage().window().maximize();
		//Giving the url to the browser
		driver.get(url);
		//putting wait 
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	
	
	
	@AfterSuite
	public void browserClose()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
}
