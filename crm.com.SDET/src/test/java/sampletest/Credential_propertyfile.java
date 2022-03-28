package sampletest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Credential_propertyfile {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("./src/main/resources/Commondata/commondata.properties");
        Properties pro_obj = new Properties();
        pro_obj.load(fis);
        String browser = pro_obj.getProperty("browser");
        String url = pro_obj.getProperty("url");
        String username = pro_obj.getProperty("username");
        String password = pro_obj.getProperty("password");
        System.out.println(browser);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        WebDriver driver = null;
        if(browser.equalsIgnoreCase("chrome")) {
        	WebDriverManager.chromedriver().setup();
        	driver=new ChromeDriver();
        	System.out.println("launched browser is"+ browser);
        }else {
        	System.out.println("specify a valid browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.name("user_name")).sendKeys(username);
        driver.findElement(By.name("user_password")).sendKeys(password);
        driver.findElement(By.id("submitButton")).click();
        driver.quit();
        
        	
        }
        
	}


