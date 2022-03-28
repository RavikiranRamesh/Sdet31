package sampletest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CelenderTodayDateTest {

	@Test 
	public void calender(){

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com/");
		
		LocalDateTime dateTime = LocalDateTime.now().plusDays(5);
		int day = dateTime.getDayOfMonth();
		int year = dateTime.getYear();
		String month = dateTime.getMonth().name();
		
		
		
		
		Actions action =new Actions(driver);
		action.moveByOffset(20, 30).click().perform();
		
		driver.findElement(By.cssSelector("span[class='langCardClose']")).click();
		
		
		driver.findElement(By.cssSelector("label[for='departure']")).click();
		
	
		
		String actualmonth = month.substring(0, 1).toUpperCase()+month.substring(1).toLowerCase();
		String monthandYear = actualmonth+" "+year;
		//String finalFormat = +day+"-"+monthandYear;
		
		String calendarelement="//div[text()='"+monthandYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']";
		
		for(int i=0;i<12;i++) {
			 
			 try {
				 driver.findElement(By.xpath(calendarelement)).click();
				 break;
			 }catch(Exception e) {
				 driver.findElement(By.cssSelector("span[aria-label='Next Month']")).click();
			 }
			 
		}
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
        driver.findElement(By.xpath("//p[text()='Bangalore, India']")).click();
        driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//p[text()='Goa, India']")).click();
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']")).click();
		List<WebElement> listOfPlanes = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
		
        for(WebElement planes:listOfPlanes)	{
        	System.out.println(planes.getText());
        	System.out.println("______________________________");
        }
        
        driver.quit();
	}

}
