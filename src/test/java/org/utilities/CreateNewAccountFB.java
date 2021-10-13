package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAccountFB extends BaseClass{
	public CreateNewAccountFB() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@data-cookiebanner='accept_button']")
	private WebElement acceptBtn;
	
	@FindBy(xpath="//a[contains(text(),'New')]")
	private WebElement newAccount;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	private WebElement emailID;
	
	@FindBy(xpath="//input[@name='reg_email_confirmation__']")
	private WebElement reEnterEmailID;
	
	@FindBy(xpath="//input[@name='reg_passwd__']")
	private WebElement password;
	
	@FindBy(id="day")
	private WebElement dayDOB;
	
	@FindBy(id="month")
	private WebElement monthDOB;
	
	@FindBy(id="year")
	private WebElement yearDOB;
	
	@FindBy(xpath="//label[text()='Female']")
	private WebElement female;
	
	@FindBy(xpath="//label[text()='Male']")
	private WebElement male;
	
	@FindBy(xpath="//label[text()='Custom']")
	private WebElement genderCustom;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement btnSubmit;
	
	public WebElement getAcceptBtn() {
		return acceptBtn;
	}
	public WebElement getNewAccount() {
		return newAccount;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmailID() {
		return emailID;
	}

	public WebElement getReEnterEmailID() {
		return reEnterEmailID;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getDayDOB() {
		return dayDOB;
	}

	public WebElement getMonthDOB() {
		return monthDOB;
	}

	public WebElement getYearDOB() {
		return yearDOB;
	}

	public WebElement getFemale() {
		return female;
	}

	public WebElement getMale() {
		return male;
	}

	public WebElement getGenderCustom() {
		return genderCustom;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	
}

