package sampletest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsTestNGTest {
	@Test(dataProvider="getdata")
	public void MultipleData(String LastName,String Number){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.get("http://localhost:8888/index.php");
         driver.findElement(By.name("user_name")).sendKeys("admin");
         driver.findElement(By.name("user_password")).sendKeys("admin");
         driver.findElement(By.id("submitButton")).click();
         driver.findElement(By.xpath("//a[text()='Contacts']")).click();
         driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
         driver.findElement(By.name("lastname")).sendKeys(LastName);
         driver.findElement(By.id("mobile")).sendKeys(Number);
         driver.findElement(By.name("button")).click();
		
		
	}
    @DataProvider
    public Object[][] getdata() {
    Object[][] ConArray = new Object[5][2];
    
    ConArray[0][0]="Ravikiran";
    ConArray[0][1]="6361467892";
   
   
    ConArray[1][0]="Abhishek";
    ConArray[1][1]="6361467893";
   
    ConArray[2][0]="Kiran";
    ConArray[2][1]="6361467894";
  
    ConArray[3][0]="Sagar";
    ConArray[3][1]="6361467895";
  
    ConArray[4][0]="Kishor";
    ConArray[4][1]="6361467896";
    	
    return ConArray;
    }
}
