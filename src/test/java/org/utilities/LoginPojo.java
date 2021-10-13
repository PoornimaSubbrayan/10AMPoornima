package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseClass{
	
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@data-cookiebanner='accept_button']")
	private WebElement acceptBtn;

	//AND Operator
	//@FindBys({
	@FindBy(id="email")
	//@FindBy(name="email")
	//})
	private WebElement txtUser;
	
	@FindBy(id="pass")
	private WebElement txtPass;
	
//	//OR Operator
//	@FindAll({
//		@FindBy(name="login"),
//		@FindBy(xpath="//button[@type='submit']"),
//		@FindBy(xpath="//button[@value='1']")
//	})
	@FindBy(name="login")
	private WebElement btnLogin;
	
	
	public WebElement getAcceptBtn() {
		return acceptBtn;
	}

	public WebElement getTxtUser() {
		return txtUser;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	
	
}
