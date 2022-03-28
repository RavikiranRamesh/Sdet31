package com.crm.vitiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vitiger.genericutility.ExcelUtility;
import com.crm.vitiger.genericutility.WebDriverUtility;

public class CreateOrganizationpage extends WebDriverUtility {
	public CreateOrganizationpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
}
	
	
		
		@FindBy(name="accountname")
		private WebElement  OrgNameTextField;
		
		@FindBy(xpath="//select[@name='industry']")
		private WebElement IndustryListBox;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement  SaveButton;
		
		
		

		public WebElement getOrgNameTextField() {
			return OrgNameTextField;
		}

		public WebElement getSaveButton() {
			return SaveButton;
		}
		
		public WebElement getIndustryListBox() {
			return IndustryListBox;
		}
		//Business Logic
		/**
		 * this method is used to input organization Name
		 */
		public void createOrg(String orgName) {
			OrgNameTextField.sendKeys(orgName);
		}
		/**
		 * this method is used to click on IndustryBox
		 */
		public void clickOnOrganizationBox() {
			IndustryListBox.click();
		}
		/**
		 * this method is used to click on Healthcare using drop down
		 */
        public void selectOrganization() {
        	selectByvisibleText(IndustryListBox, "Healthcare");
        }
        /**
		 * this method is used to save organization
		 */
        public void SaveOrgButton() {
			SaveButton.click();
		}
	}



