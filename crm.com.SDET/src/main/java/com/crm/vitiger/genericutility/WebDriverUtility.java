package com.crm.vitiger.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * it contains WebDriver specific reusable actions
 * @author Ravikiran
 *
 */

public class WebDriverUtility {
	/**
	 * wait for page to load before identifying any synchronized element in DOM [HTML-Document]
	 *@param driver 
	 */
	public void WaitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * used to wait for element to be clickable in GUI, & check for specific element for every 500 milli seconds
	 *@param driver
	 *@param element 
	 *@param pollingTime in the form second
	 * @throws Throwable 
	 */
	public void waitFotElementWithCustomTimeOut(WebDriver driver,WebElement element,int pollingTime) throws Throwable {
		FluentWait wait =new FluentWait(driver);
		wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to wait for element to be clickable in GUI, & check for specific element for every 500 milli seconds
	 *@param driver
	 *@param element 
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait Wait = new WebDriverWait(driver,20);
		Wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * used to wait 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		
	}
	/**
	 * used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchtoWindow(WebDriver driver,String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			String wID = it.next();
			driver.switchTo().window(wID) ;
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * used to switch to Alert Window & click on Ok button
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * used to switch to Frame window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchtoFrame(WebDriver driver,String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	/**
	 * used to select the value from the dropdown based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropDown based on value/option available in GUI
	 * @param element
	 * @param value
	 */
	public void selectByvisibleText(WebElement element,String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * used to right click on specified element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions act = new Actions((WebDriver) element);
		act.contextClick(element).perform();
	}
	/**
	 * used to execute java script
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver,String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
	/**
	 * used to wait and Click
	 * @param element
	 * @throws InterruptedException 
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count = 0;
		while(count<20) {
			try {
				element.click();
				break;
			}catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * used to take ScreenShot
	 * @param driver
	 * @param ScreenShot
	 * @throws Throwable 
	 */
	public String takeScreenshot(WebDriver driver,String ScreenshotName) throws Throwable {
		JavaUtility jLib = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
	     String timestamp = jLib.getSystemDateAndTime().replace(":", "-");
		File destination = new File("./screenshot/"+timestamp+ScreenshotName+".PNG");
		FileUtils.copyFile(source, destination);
		return destination.getAbsolutePath();
	}
	/**
	 * pass enter key operation in to Browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
}