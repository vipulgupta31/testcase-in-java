package LocalGrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class BaseTest 
{
	public static WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
	
		/*
		//to execute on Edge browser
		driver = new EdgeDriver();
		
		//to execute on Firefox browser
		driver = new FirefoxDriver();
		
		//to execute on Safari browser
		driver = new SafariDriver(); */
		
		System.out.println("Navigating to Two Input Field section");
		driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
