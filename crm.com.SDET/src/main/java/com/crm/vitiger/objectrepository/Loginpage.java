package com.crm.vitiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vitiger.genericutility.FileUtility;

public class Loginpage extends FileUtility {
	public Loginpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
       @FindBy(name="user_name")
       private WebElement userNameTextField;
       
       @FindBy(name="user_password")
       private WebElement passwordTextField;
       
       @FindBy(id="submitButton")
       private WebElement loginButton;

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextFiled() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	//Business Logic
	/**
	 * this method is used to Login into the application
	 */
       public void login(String username,String password) {
    	   userNameTextField.sendKeys(username);
    	   passwordTextField.sendKeys(password);
    	   loginButton.click();
       }
}    
