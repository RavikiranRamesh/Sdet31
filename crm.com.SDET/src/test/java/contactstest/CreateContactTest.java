package contactstest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vitiger.genericutility.BaseClass;
import com.crm.vitiger.objectrepository.Contactinfopage;
import com.crm.vitiger.objectrepository.Contactpage;
import com.crm.vitiger.objectrepository.CreateContactpage;
import com.crm.vitiger.objectrepository.Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest extends BaseClass {
	@Test(groups="smoke testing")
	public void CreateContact() throws Throwable {
		
		
		String lastName = eLib.getDataFromExcel("Sheet2", 1, 0);
		
		  
        /*navigate to contacts link*/
        Homepage hp = new Homepage(driver);
        hp.clickOnContactLink();
        /*click on create contact image*/
       CreateContactpage cci = new CreateContactpage(driver);
       cci.clickoncontactimg();
        /*create new contact page*/
        Contactpage ccp = new Contactpage(driver);
       ccp.createnewcontactname(lastName);
        
        /*validation for contact name*/
        Contactinfopage contactinfo = new Contactinfopage(driver);
        wLib.waitForElementToBeClickable(driver, contactinfo.getActualcontactname());
        String actualmsg = contactinfo.actualcontactname().getText();
        if(actualmsg.contains(lastName))
       {
        	System.out.println(lastName+"is verified==pass");
        }
        else
        {
        	System.out.println(lastName+ "is not verified==fail");
        }
        
      
       }
        
 	}
