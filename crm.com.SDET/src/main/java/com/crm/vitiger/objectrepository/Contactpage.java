package com.crm.vitiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {
	//Initialization of web elements

		public Contactpage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		
		//Declaration of web elements
		@FindBy(name="lastname")
		private WebElement newcontactname;
		
		@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
		private WebElement clickthecontactimg;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement  SaveButton;
		
		//getters method used in test script
		public WebElement getClickthecontactimg() {
			return clickthecontactimg;
		}
		
		public WebElement getNewcontactname() {
			return newcontactname;
		}
		
		public WebElement getSaveButton() {
			return SaveButton;
		}
		
		
		//business logic
		/**
		 * this method is used to create contact name
		 * @param contactname
		 */
		public void clickOnCreateContactimg() {
			 clickthecontactimg.click();
		}
		
		public void createnewcontactname(String contactname) {
			newcontactname.sendKeys(contactname);
			SaveButton.click();
		
		}

	}



