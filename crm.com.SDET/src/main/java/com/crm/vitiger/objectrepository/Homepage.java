package com.crm.vitiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vitiger.genericutility.WebDriverUtility;

public class Homepage extends WebDriverUtility{

	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		@FindBy(linkText="Organizations")
		private WebElement organizationlink;
		
		@FindBy(linkText="Opportunities")
		private WebElement Opportunitieslink;
		
		@FindBy(linkText="Contacts")
		private WebElement contactsLink;
		
		@FindBy(linkText="Products")
		private WebElement productsLink;
		
		
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement administratorimg;
	
        @FindBy(linkText="Sign Out")
        private WebElement signoutlink;

		public WebElement getOrganizationlink() {
			return organizationlink;
		}
		
		public WebElement getOpportunitieslink() {
			return Opportunitieslink;
		}
		public WebElement getContactsLink() {
			return contactsLink;
		}
		

		public WebElement getProductsLink() {
			return productsLink;
		}


		public WebElement getSignouticonimage() {
			return administratorimg;
		}

		public WebElement getSignoutlink() {
			return signoutlink;
		}
        
		//business logic
		/**
		 * This method will click on organization link
		 */
		public void clickOnOrganizationLink() {
			organizationlink.click();
		}
		/**
		 *  This method will click on Opportunities link
		 */
		public void clickOnOpportunitiesLink() {
			Opportunitieslink.click();
		}
		
		public void clickOnProductLink() {
			productsLink.click();
		}
		public void clickOnContactLink() {
			contactsLink.click();
		}
		
		
		/**
		 * This method will logout the application
		 * @param driver
		 */
        public void  logOut(WebDriver driver) {
        	mouseOverOnElement(driver,administratorimg);
        	signoutlink.click();
        }
       
}