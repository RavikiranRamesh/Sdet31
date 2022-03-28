package com.crm.vitiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productvarificationpage {
	/*Initialization of web element*/
	public Productvarificationpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	/*Declaration of Web element*/
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement actualproductname;

	public WebElement getActualproductname() {
		return actualproductname;
	}
	/*business logic*/
	public WebElement actualnameofproduct()
	{
		return actualproductname;
	}
	
	
}



