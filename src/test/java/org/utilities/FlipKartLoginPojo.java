package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKartLoginPojo extends BaseClass {

	public FlipKartLoginPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement textEmailID;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement textPwd;
	
	@FindBy(xpath="(//span[text()='Login'])[2]")
	private WebElement BtnLogin;
	
	public WebElement getTextEmailID() {
		return textEmailID;
	}

	public WebElement getTextPwd() {
		return textPwd;
	}

	public WebElement getBtnLogin() {
		return BtnLogin;
	}
	
}
