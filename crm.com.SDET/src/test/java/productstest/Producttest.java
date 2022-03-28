package productstest;

import org.testng.annotations.Test;

import com.crm.vitiger.genericutility.BaseClass;
import com.crm.vitiger.objectrepository.CreateProductpage;
import com.crm.vitiger.objectrepository.Homepage;
import com.crm.vitiger.objectrepository.Productinfopage;
import com.crm.vitiger.objectrepository.Productvarificationpage;

public class Producttest extends BaseClass {
	@Test(groups="smoke testing")
	public void CreateProduct() throws Throwable{
	
			/*read test data*/
			
			String product=eLib.getDataFromExcel("Sheet3",1,0)+jLib.getRanDomNumber();
	
			
			/*navigate to home page*/
			Homepage hp=new Homepage(driver);
		     hp.clickOnProductLink();
		     
		     /*click on icon to create new product*/
		     CreateProductpage pp=new CreateProductpage(driver);
		     pp.clickonProducticon();
		     
		     /*enter the new product name*/
		     Productinfopage pip=new Productinfopage(driver);
		     pip.entertheproductname(product);
		     
		     /*validate whether product is created or not*/
		     Productvarificationpage pps=new Productvarificationpage(driver);
		     wLib.waitForElementToBeClickable(driver, pps.actualnameofproduct());
		     String actualnameofproduct=pps.actualnameofproduct().getText();
		     if(actualnameofproduct.contains(product))
		     {
		    	 System.out.println("product is created ===pass");
		     }
		     else
		     {
		    	 System.out.println("product is not created====fail");
		     }
		   
		}	

	}
