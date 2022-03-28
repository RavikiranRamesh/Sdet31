package com.crm.vitiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opportunitiespage {
	public Opportunitiespage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
     
     @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
     private WebElement createOpportunities;
     
	public WebElement getCreateOpportunities() {
		return createOpportunities;
	}
    //Business Logic
	/**
	 * this method is used to click on new opportunity
	 */
	public void createNewOpportunity() {
		createOpportunities.click();
		
	}
     
     
}
