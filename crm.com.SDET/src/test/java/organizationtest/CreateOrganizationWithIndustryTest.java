package organizationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.vitiger.genericutility.BaseClass;
import com.crm.vitiger.genericutility.ExcelUtility;
import com.crm.vitiger.genericutility.FileUtility;
import com.crm.vitiger.genericutility.JavaUtility;
import com.crm.vitiger.genericutility.WebDriverUtility;
import com.crm.vitiger.objectrepository.CreateOrganizationpage;
import com.crm.vitiger.objectrepository.Homepage;
import com.crm.vitiger.objectrepository.Loginpage;
import com.crm.vitiger.objectrepository.OrganizationInfopage;
import com.crm.vitiger.objectrepository.Organizationpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustryTest extends BaseClass {

@Test(groups="regression testing")
public void CreateOrganizationWithIndustry() throws Throwable
	 {
		
		//Read Test data/
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 0) + jLib.getRanDomNumber();
	
		/* Navigate to organization */
		Homepage hp = new Homepage(driver);
		hp.clickOnOrganizationLink();
		
		/* Navigate to Create organization */
		Organizationpage op = new Organizationpage(driver);
		op.createOrganizationImgage();
		
		
		/* Create organization */
		CreateOrganizationpage cop = new CreateOrganizationpage(driver);
		cop.createOrg(orgName);
		cop.clickOnOrganizationBox();
		cop.selectOrganization();
		cop.SaveOrgButton();
		
		/* Verify Organization name*/
		OrganizationInfopage orginfo = new OrganizationInfopage(driver);
		wLib.waitForElementToBeClickable(driver, orginfo.getActOrgName());
		String SuccessMsg=orginfo.ActOrgName();
		
		
		
		if(SuccessMsg.contains(orgName)) {
			System.out.println("Organization created successfully = Pass");
		}else {
			System.out.println("Organization page is failed to create = Fail");
		}
		
	}

}