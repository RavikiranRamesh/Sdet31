package com.crm.vitiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationpage {
	public Organizationpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
		@FindBy(xpath="//img[@title='Create Organization...']")
		private WebElement createOrganizationImgage;

		public WebElement getCreateOrgImg() {
			return createOrganizationImgage;
		}
		//business logic
		/**
		 * This method will click on Create organization image
		 */
		public void createOrganizationImgage() {
			createOrganizationImgage.click();
		}
	}



