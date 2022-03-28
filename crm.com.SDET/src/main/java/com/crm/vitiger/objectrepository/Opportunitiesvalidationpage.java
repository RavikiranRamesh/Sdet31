package com.crm.vitiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opportunitiesvalidationpage {
	public Opportunitiesvalidationpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ActualOpportunityName;

	public WebElement getActualOpportunityName() {
		return ActualOpportunityName;
	}
	//Business Logic
	/**
	 * this method is used to validate Opportunity name
	 */
    public String ActualopportunityName() {
    	return ActualOpportunityName.getText();
    }
}
