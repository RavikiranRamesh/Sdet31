package sampletest;

import java.awt.Desktop.Action;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tester1 {

	public static void main(String[] args) {
		Random r=new Random();
		int i=r.nextInt(1000);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String expected="Tymanthra"+i;
       driver.get("http://localhost:8888/index.php");
       driver.findElement(By.name("user_name")).sendKeys("admin");
       driver.findElement(By.name("user_password")).sendKeys("admin");
       driver.findElement(By.id("submitButton")).click();
       driver.findElement(By.linkText("Organizations")).click();
       driver.findElement(By.cssSelector("img[Title='Create Organization...']")).click();
       driver.findElement(By.name("accountname")).sendKeys(expected);
       driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
      String actual = driver.findElement(By.className("dvHeaderText")).getText();
       if(actual.contains(expected))
       {
    	   System.out.println("validation pass");
       }else {
    	   System.out.println("validation fail");
	}
	 WebElement admin = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	 Actions actions = new Actions(driver);
	 actions.moveToElement(admin).perform();
	 driver.findElement(By.linkText("Sign Out")).click();
	
	driver.quit();

	}
}