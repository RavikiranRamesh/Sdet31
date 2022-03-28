package com.crm.vitiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfopage {
	public OrganizationInfopage(WebDriver driver) {
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ActualOrgName;

	public WebElement getActOrgName() {
		return ActualOrgName;
	}
	//Business Logic
	/**
	 * this method is used to validate
	 */
	
	public String ActOrgName() {
		return ActualOrgName.getText();
	}

}