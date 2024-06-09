package CloudGrid;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TwoInputFieldTests extends BaseTest
{

	@Test(groups = {"uiTest"})
	public void shouldVerifyAllElementsWhenThePageIsLoaded()
	{
		System.out.println("Verify Two Input Fields title is displayed.");
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Two')]")).isDisplayed());
		
		System.out.println("Verify enter first value label is displayed.");
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'first value')]")).isDisplayed());
		
		System.out.println("Verify enter first value textbox is displayed.");
		Assert.assertTrue(driver.findElement(By.id("sum1")).isDisplayed());
		
		System.out.println("Verify enter second value label is displayed.");
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'second value')]")).isDisplayed());
		
		System.out.println("Verify enter second value textbox is displayed.");
		Assert.assertTrue(driver.findElement(By.id("sum2")).isDisplayed());
		
		System.out.println("Verify Get Sum button is displayed.");
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Sum')]")).isDisplayed());
		
		System.out.println("Verify result label is displayed.");
		Assert.assertTrue(driver.findElement(By.id("user-message")).isDisplayed());
		
		status = "passed";
	}
	
	@Test(groups = {"positiveTest", "sanity"})
	public void shouldReturnTheResultWhenBothNumbersAreValid()
	{
		System.out.println("entering first value");
		driver.findElement(By.id("sum1")).sendKeys("5");
		
		System.out.println("entering second value");
		driver.findElement(By.id("sum2")).sendKeys("10");
		
		System.out.println("click on sum");
		driver.findElement(By.xpath("//*[contains(text(),'Sum')]")).click();
		
		System.out.println("fetch the result and assert it");
		String result =  driver.findElement(By.id("addmessage")).getText();
		Assert.assertEquals(result, "15", "Sum is incorrect. Expected : 15 but Found : " + result);
		
		status = "passed";
	}
	
	@Test(groups = {"errorTest", "sanity"})
	public void shouldShowErrorWhenAnyNumberIsMissing()
	{
		System.out.println("entering first value");
		driver.findElement(By.id("sum1")).sendKeys("5");
		
		System.out.println("click on sum");
		driver.findElement(By.xpath("//*[contains(text(),'Sum')]")).click();
		
		System.out.println("fetch the error message and assert it");
		String errorMessage =  driver.findElement(By.id("addmessage")).getText();
		String expectedError = "Entered value is not a number";
		Assert.assertEquals(errorMessage, expectedError, "Incorrect error message. Expected : " + expectedError + " but Found : " + errorMessage);
		
		status = "passed";
	}
	
}
