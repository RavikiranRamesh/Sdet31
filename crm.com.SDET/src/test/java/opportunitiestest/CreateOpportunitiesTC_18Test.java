package opportunitiestest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vitiger.genericutility.*;
import com.crm.vitiger.objectrepository.CreateOpportunitiespage;
import com.crm.vitiger.objectrepository.Homepage;
import com.crm.vitiger.objectrepository.Loginpage;
import com.crm.vitiger.objectrepository.Opportunitiespage;
import com.crm.vitiger.objectrepository.Opportunitiesvalidationpage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.vitiger.genericutility.ListenerImplimentationClass.class)
public class CreateOpportunitiesTC_18Test extends BaseClass {
	@Test(groups="smoke testing")
	public void createOpportunity () throws Throwable {
	
	     //Read Test data/ 
	       String OpportunityName = eLib.getDataFromExcel("sheet3", 1, 0)+ jLib.getRanDomNumber();
	       
	      
	       /* Navigate to Opportunities */
	       Homepage homepage = new Homepage(driver);
	       homepage.clickOnOpportunitiesLink();
	       
	       /* Navigate to Create Opportunities */
	      Opportunitiespage op = new Opportunitiespage(driver);
	      op.createNewOpportunity();
	      
	      /* Create Opportunities */ 
	     Assert.fail();
	      CreateOpportunitiespage crateOpportunity = new CreateOpportunitiespage(driver);
	      crateOpportunity.createOpportunity(driver, OpportunityName);
	      crateOpportunity.selectTeamSelling();
	      crateOpportunity.selectPerceptionAnalysis();
	      crateOpportunity.savebutton();
	      
	      /* Verify Opportunities name*/
	      Opportunitiesvalidationpage Opportunityinfo = new Opportunitiesvalidationpage(driver);
	      wLib.waitForElementToBeVisible(driver, Opportunityinfo.getActualOpportunityName());
	      String success = Opportunityinfo.ActualopportunityName();
	      
	      if(success.contains(OpportunityName)) {
	    	  System.out.println("Opportunity is created successfully");
	      }else {
	    	  System.out.println("Opportunity creation Failed");
	      }
	      
	     
	}

}
