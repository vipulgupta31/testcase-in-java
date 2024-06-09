package CloudGrid;

import java.net.*;
import java.util.HashMap;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {
	public RemoteWebDriver driver = null;

	String username = System.getenv("LT_USERNAME") == null ? "<lambdatest_username>" : System.getenv("LT_USERNAME");
	String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "<lambdatest_accesskey>" : System.getenv("LT_ACCESS_KEY");

	String status = "failed";

	@BeforeMethod
	public void setup() {
		try {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPlatformName("Windows 10");
			chromeOptions.setBrowserVersion("125");

			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("build", "Test case in Java");
			ltOptions.put("name", "Test case in Java");
			ltOptions.put("w3c", true);
			chromeOptions.setCapability("LT:Options", ltOptions);

			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), chromeOptions);

			System.out.println("Navigating to Two Input Field section");
			driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.executeScript("lambda-status=" + status);
		driver.quit();
	}

}
