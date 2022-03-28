package com.crm.vitiger.genericutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.vitiger.objectrepository.Homepage;
import com.crm.vitiger.objectrepository.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;
  
public class BaseClass {
	
	 public WebDriver driver=null;
	   public FileUtility fLib=new FileUtility();
	   public ExcelUtility eLib=new ExcelUtility();
	   public JavaUtility jLib=new JavaUtility();
	   public WebDriverUtility wLib=new WebDriverUtility();
	   public static WebDriver rDriver;
	@BeforeSuite(groups= {"smoke testing","regression testing"})
	public void bs() {
		System.out.println("data base connection");
	}
	
	@BeforeTest(groups= {"smoke testing","regression testing"})
	public void bt() {
		System.out.println("execute scrip in parallel mode");
		
	}
	//@Parameters("browser")
	@BeforeClass(groups= {"smoke testing","regression testing"})
	public void bc() throws Throwable   {
	   String BrowserName = fLib.getPropertyKeyValue("browser");
	  String url = fLib.getPropertyKeyValue("url");
	   if(BrowserName.equalsIgnoreCase("chrome")) {
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
	   }else if(BrowserName.equalsIgnoreCase("firefox")) {
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
	   }else {
		   throw new Exception("browser is not compatible");
	   }
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.get(url);
	   rDriver=driver;
	   
	}
	@BeforeMethod(groups= {"smoke testing","regression testing"})
	public void bm() throws Throwable {
		
		String USSERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.login(USSERNAME, PASSWORD);
	}
	
	@AfterMethod(groups= {"smoke testing","regression testing"})
	public void am() {
		Homepage homepage = new Homepage(driver);
		homepage.logOut(driver);
	}
	
	@AfterClass(groups= {"smoke testing","regression testing"})
	public void ac() {
		driver.quit();
	}
	
	@AfterTest(groups= {"smoke testing","regression testing"})
	public void at() {
		System.out.println("close parallel mode execution");
	}
	
	@AfterSuite(groups= {"smoke testing","regression testing"})
	public void as() {
		System.out.println("close all the base connections");
	}

}
