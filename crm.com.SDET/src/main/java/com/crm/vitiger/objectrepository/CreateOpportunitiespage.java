package com.crm.vitiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vitiger.genericutility.ExcelUtility;
import com.crm.vitiger.genericutility.WebDriverUtility;

public class CreateOpportunitiespage extends WebDriverUtility {
	public CreateOpportunitiespage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	  @FindBy(xpath="//input[@name='potentialname']")
	     private WebElement opportunitiesNameTextField;
	     
	     @FindBy(xpath="//table[@class='small']/following::img[@src='themes/softed/images/select.gif'][1]")
	     private WebElement organizationLookup;
	     
	     @FindBy(xpath="//a[text()='Tymanthra']")
	     private WebElement OrganizationName;
	     
	     @FindBy(xpath="//input[@name='assigntype'][2]")
	 	private WebElement selectGroup;
	 	
	 	@FindBy(xpath="//select[@name='assigned_group_id']")
	 	private WebElement DropDown;
	 	
	 	@FindBy(xpath="//img[@id='jscal_trigger_closingdate']")
	 	private WebElement calender;
	 	
	 	@FindBy(xpath="//select[@name='sales_stage']")
	 	private WebElement salesStage;
	 	
	 	@FindBy(xpath="//td[@class='dvtSelectedCell']/following::input[@title='Save [Alt+S]'][1]")
	 	private WebElement save;
	 	
	 	public WebElement getSave() {
			return save;
		}

		public WebElement getOrganizationName() {
			return OrganizationName;
		}

		public WebElement getDropDown() {
			return DropDown;
		}

		public WebElement getCalender() {
			return calender;
		}

		public WebElement getSalesStage() {
			return salesStage;
		}

		public WebElement clickClender() {
	 		return calender;
	 	}
	     
	     public WebElement getOpportunitiesNameTextField() {
	 		return opportunitiesNameTextField;
	 	}
	        /**
			 * this method is used to click on organizationLookup
			 */
	     
	     public WebElement getOrganizationLookup() {
	 		return organizationLookup;
	     }
	        /**
			 * this method is used to select organization in organizationLookup
			 */
	     public WebElement selectOrganization() {
	    	 return OrganizationName;
	     }
	        /**
			 * this method is used to select group radio button 
			 */
	     public WebElement getSelectGroup() {
	 				return selectGroup;
	 	}
	        /**
			 * this method is used to select Team Selling in Assigned to Group using drop down
			 */  
	 public void selectTeamSelling() {
		 selectByvisibleText(DropDown, "Team Selling");
	 }
	    /**
		 * this method is used to select Perception Analysis in sales stage using drop down
		 */
		 public void selectPerceptionAnalysis() {
			 selectByvisibleText(salesStage, "Perception Analysis");
		 }
		     /**
			 * this method is used to select Proposal/Price Quote in sales stage using drop down
			 */
		 public void SelectProposal() {
		     selectByvisibleText(salesStage, "Proposal/Price Quote");
		 }
		public void savebutton() {
			save.click();
		}
		 //Business Logic
		/**
		 * this method is used to create new opportunity
		 */
	     public void createOpportunity(WebDriver driver,String OpportunityName) {
	    	 opportunitiesNameTextField.sendKeys(OpportunityName);
	 		organizationLookup.click();
	 		switchtoWindow(driver, "Accounts");
			OrganizationName.click();
			switchtoWindow(driver, "Potentials");
			selectGroup.click();
			calender.click();
			salesStage.click();
			
		}

		
			
		}
	 

