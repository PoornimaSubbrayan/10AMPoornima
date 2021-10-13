package org.testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.BaseClass;
import org.utilities.FlipKartLoginPojo;
import org.utilities.LoginPojo;
import org.utilities.PracticeFormPojo;

public class TestNG2ndProgram extends BaseClass{
	@BeforeClass
	private void launchingBrowser() {
		launchChrome();
		System.out.println("Browser launch");
	}
	@AfterClass
	private void closingBrowser() {
		driver.close();
		System.out.println("Close Browser");
	}
	@BeforeMethod
	private void startTime() {
		printStartTime();
	}
	@AfterMethod
	private void endTime() {
	printEndTime();
	}

	
	@Test(enabled = false)
	public void FlipKartTC01() throws IOException, InterruptedException {
		driver.navigate().refresh();
		loadUrl("https://www.flipkart.com/account/login");
		driver.manage().window().maximize();
		printTitle();
		printCurrentUrl();
		
		FlipKartLoginPojo fl = new FlipKartLoginPojo();
		//implicitWait();
		fillValues(fl.getTextEmailID(), getData(3, 0));
		fillValues(fl.getTextPwd(), getData(3, 1));
		sleepWait();
		btnClick(fl.getBtnLogin());
		System.out.println("FlipKart Login executed");
	}
	
	@Test(enabled=false,dataProvider="FormFillDetails", dataProviderClass=SampleDataProviderTestNG.class)
	public void FormFillingTC01(String FN, String LN, String email, String phone, String address, String gender) throws InterruptedException {
		loadUrl("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		printTitle();
		printCurrentUrl();
		
		PracticeFormPojo p = new PracticeFormPojo();
		fillValues(p.getFirstName(),FN);
		fillValues(p.getLastName(),LN);
		
		fillValues(p.getEmailID(),email);
		fillValues(p.getPhoneNo(), phone);
		fillValues(p.getAddress(), address);
		sleepWait();
				
		btnClick(p.getFemale());
		sleepWait();
		selectValueByVisibleText(p.getState(), "Rajasthan");
		sleepWait();
		
		btnClick(p.getSubmitBtn());
		
	}
	
}
