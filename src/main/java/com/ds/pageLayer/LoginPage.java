package com.ds.pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//-------------- obj repo -----------------
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email_txtbox;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password_txtbox;
	
	@FindBy(xpath="//button[text()='Log In']")
	private WebElement login_btn;
	
	//------------ action methods -------------
	
	public void enterEmailAddress(String email)
	{
		email_txtbox.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		password_txtbox.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		login_btn.click();
	}

}
