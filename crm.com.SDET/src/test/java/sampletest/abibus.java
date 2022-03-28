package sampletest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class abibus {
    public static void main(String[]args) {
    	
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver=new ChromeDriver();
    	driver.get("https://www.abhibus.com/");
    	driver.findElement(By.id("datepicker1"));
    }
}
