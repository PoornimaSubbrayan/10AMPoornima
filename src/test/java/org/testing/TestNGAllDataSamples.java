package org.testing;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.utilities.BaseClass;
import org.utilities.CreateNewAccountFB;

public class TestNGAllDataSamples extends BaseClass {
	
	@BeforeClass(alwaysRun=true)
	private void launchingBrowser() {
		launchChrome();
		//System.out.println("Browser launch");
		System.out.println("BEfore class");
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

	//Data Driven - passing data via excel
	@Test(enabled =false, groups="sanity")
	public void FBCreateNewAccountTC01() throws IOException, InterruptedException {
		driver.navigate().refresh();
		loadUrl("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println(title);
		//Hard assert
		//Assert.assertTrue(title.contains("Facebook"), "Verify the title - Hard assert");
		
		//Soft Assert
		SoftAssert s = new SoftAssert();
		//s.assertTrue(title.contains("facebook"), "Verify the title - Soft assert");
		
		s.assertEquals(title, "facebook – log in or sign up", "Soft Assert Equals");
		printTitle();
		printCurrentUrl();
		//s.assertAll();
		
		CreateNewAccountFB fb = new CreateNewAccountFB();
		btnClick(fb.getAcceptBtn());
		sleepWait();
		btnClick(fb.getNewAccount());
		sleepWait();
		fillValues(fb.getFirstName(), getData(2, 0));
		fillValues(fb.getLastName(), getData(2, 1));
		fillValues(fb.getEmailID(), getData(2, 2));
		fillValues(fb.getReEnterEmailID(), getData(2, 2));
		fillValues(fb.getPassword(), getData(2, 3));
		selectValueByValue(fb.getDayDOB(), getData(2, 4));
		selectValueByValue(fb.getMonthDOB(), getData(2, 5));
		selectValueByVisibleText(fb.getYearDOB(), getData(2, 6));
		btnClick(fb.getFemale());
		btnClick(fb.getBtnSubmit());
	}

	//DataProvider - passing the data 
	@Test(enabled = true,priority=-17, groups ="smoke", dataProvider = "FBNewAccountForm", dataProviderClass = SampleDataProviderTestNG.class)
	public void FBCreateNewAccountTC02(String FN, String LN, String email, String reEmail, String password, int date,
			String month, String year, WebElement gender) throws InterruptedException {
		
		launchChrome();
		System.out.println("Browser launch");
		
		driver.navigate().refresh();
		loadUrl("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		printTitle();
		printCurrentUrl();

		CreateNewAccountFB fb = new CreateNewAccountFB();
		btnClick(fb.getAcceptBtn());
		sleepWait();
		btnClick(fb.getNewAccount());
		sleepWait();
		fillValues(fb.getFirstName(), FN);
		fillValues(fb.getLastName(), LN);
		fillValues(fb.getEmailID(), email);
		fillValues(fb.getReEnterEmailID(), reEmail);
		fillValues(fb.getPassword(), password);
		selectValueByIndex(fb.getDayDOB(), date);
		//selectValueByValue(fb.getDayDOB(), date);
		selectValueByVisibleText(fb.getMonthDOB(), month);
		selectValueByValue(fb.getYearDOB(), year);
		btnClick(gender);
		sleepWait();
		btnClick(fb.getBtnSubmit());
		driver.quit();
		
	}

	@Parameters({"firstName", "lastName", "emailId", "reEmailId", "password", "day", "month", "year"})
	@Test(enabled=false, groups="smoke", priority=-18)
	public void FBCreateNewAccountTC03(String s1, String s2,String s3, String s4, String s5, int d, String s6, String s7) throws InterruptedException {
		driver.navigate().refresh();
		loadUrl("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		printTitle();
		printCurrentUrl();

		CreateNewAccountFB fb = new CreateNewAccountFB();
		btnClick(fb.getAcceptBtn());
		sleepWait();
		btnClick(fb.getNewAccount());
		sleepWait();
		fillValues(fb.getFirstName(), s1);
		fillValues(fb.getLastName(), s2);
		fillValues(fb.getEmailID(), s3);
		fillValues(fb.getReEnterEmailID(), s4);
		fillValues(fb.getPassword(), s5);
		selectValueByIndex(fb.getDayDOB(), d);
		selectValueByVisibleText(fb.getMonthDOB(), s6);
		selectValueByValue(fb.getYearDOB(), s7);
		btnClick(fb.getFemale());
		sleepWait();
		btnClick(fb.getBtnSubmit());

	}

}

