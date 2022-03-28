package sampletest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class celendertest {

	public static void main(String[] args) {
		String MonthAndYear="July 2022";
		String Date="7";
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 driver.get("https://www.makemytrip.com/");
		 Actions Actions = new Actions(driver);
		 Actions.moveByOffset(20, 20).click().perform();
		 driver.findElement(By.className("langCardClose")).click();
		 driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']")).click();
		 String Celenderxpath="//div[text()='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+Date+"']";
		 for(;;) {
		try {
			driver.findElement(By.xpath(Celenderxpath)).click();
			break;
		} catch (Exception e) {
			 driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
			 
			
		}
		
	}

}
