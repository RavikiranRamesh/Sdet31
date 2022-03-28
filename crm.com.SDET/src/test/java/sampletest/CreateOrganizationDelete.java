package sampletest;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrganizationDelete {

	public static void main(String[] args) throws Throwable {
		Random random = new Random();
          int i= random.nextInt(1000);
          WebDriver driver=new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
          driver.get("http://localhost:8888/index.php");
          driver.findElement(By.name("user_name")).sendKeys("admin");
          driver.findElement(By.name("user_password")).sendKeys("admin");
          driver.findElement(By.id("submitButton")).click();
          driver.findElement(By.xpath("//a[text()='Organizations']")).click();
          driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
          String orgName = "ravi"+i;
          driver.findElement(By.name("accountname")).sendKeys(orgName);
          driver.findElement(By.name("button")).click();
          driver.findElement(By.xpath("//a[text()='Organizations']")).click();
          for(;;) {try {
        	  WebElement tablepath=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[text()='"+orgName+"']"));
        	  tablepath.click();
        	  break;
         } catch (Exception e) {
	          driver.findElement(By.xpath("//img[@src='themes/images/next.gif']")).click();
}
			
		}
         
       
	}

}
