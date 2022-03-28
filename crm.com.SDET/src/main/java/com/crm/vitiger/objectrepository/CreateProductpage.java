package com.crm.vitiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductpage {
	/*Initialization of web element*/
public CreateProductpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
/*declaration of web element*/
@FindBy(xpath="//img[@title='Create Product...']")
private WebElement clickonnewproductimage;

public WebElement getClickonnewproducticon() {
	return clickonnewproductimage;
}
/*business logic*/
public void clickonProducticon()
{
	clickonnewproductimage.click();
}


}



