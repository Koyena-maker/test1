package koyenamukherjee.Abstractreusable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import koyenamukherjee.pageobjects.cartpage;

public class abstractComponents {
	 
	WebDriver driver;
	
	

	public abstractComponents(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css="[routerlink=\"/dashboard/cart\"]")
	WebElement cartIcon;
	
	

	public void waitForElementToAppear(By locator)
	{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}
	public void waitForElementToDisappear(WebElement locator) throws InterruptedException
	{
		Thread.sleep(1000);
//	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	}
	
	public cartpage goToCartPage()
	{
		cartIcon.click();
		cartpage cp=new cartpage(driver);
		return cp;
	}
	
	public void selectByVisibleText(String value, WebElement dropDown)
	{
		 Select select=new Select(dropDown);
		 select.selectByVisibleText(value);
	}
}