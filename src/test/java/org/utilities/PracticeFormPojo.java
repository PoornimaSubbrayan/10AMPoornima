package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeFormPojo extends BaseClass {
	
	public PracticeFormPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstName")
	private WebElement firstName;
	
	@FindBy(id="lastName")
	private WebElement lastName;
	
	@FindBy(id="userEmail")
	private WebElement emailID;
	
	@FindBy(xpath="//label[text()='Male']")
	private WebElement male;
	
//	@FindAll({
//	@FindBy(xpath="//input[@value='Female']"),
//	@FindBy(id="gender-radio-2"),
//	@FindBy(xpath="//input[@name='gender']"),
//	@FindBy(xpath="//label[text()='Female']")
//	})
		
	@FindBy(xpath="//label[text()='Female']")
	private WebElement female;
	
	@FindBy(xpath="//label[text()='Other']")
	private WebElement other;
	
	@FindBy(id="userNumber")
	private WebElement phoneNo;
	
	@FindBy(id="dateOfBirthInput")
	private WebElement DOB;
	
	@FindBy(id="currentAddress")
	private WebElement address;
	
	@FindBy(id="uploadPicture")
	private WebElement picture;
	
	@FindBy(xpath="//div[text()='Select State']")
	private WebElement state;
	
	@FindBy(id="city")
	private WebElement city;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitBtn;
	
		
	public WebElement getSubmitBtn() {
		return submitBtn;
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

	public WebElement getMale() {
		return male;
	}

	public WebElement getFemale() {
		return female;
	}

	public WebElement getOther() {
		return other;
	}

	public WebElement getPhoneNo() {
		return phoneNo;
	}

	public WebElement getDOB() {
		return DOB;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getPicture() {
		return picture;
	}

	public WebElement getState() {
		return state;
	}
	
	public WebElement getCity() {
		return city;
	}

}
