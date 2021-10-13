package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedBusPojo extends BaseClass{
	
	public RedBusPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="src")
	private WebElement sourceLoc;

	@FindBy(id="dest")
	private WebElement destLoc;
	
	@FindBy(id="onward_cal")
	private WebElement dateOfJourney;

	public WebElement getSourceLoc() {
		return sourceLoc;
	}

	public WebElement getDestLoc() {
		return destLoc;
	}

	public WebElement getDateOfJourney() {
		return dateOfJourney;
	}

}
