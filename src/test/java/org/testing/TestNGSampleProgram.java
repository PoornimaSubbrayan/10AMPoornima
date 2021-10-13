package org.testing;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.BaseClass;
import org.utilities.LoginPojo;

public class TestNGSampleProgram extends BaseClass{

	@BeforeClass(alwaysRun=true)
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

	
	@Test(enabled=false)
	public void testCase02() throws IOException {
		driver.navigate().refresh();
		loadUrl("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		printTitle();
		printCurrentUrl();
		
		LoginPojo l = new LoginPojo();
		//btnClick(l.getAcceptBtn());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fillValues(l.getTxtUser(), getData(2, 0));
		fillValues(l.getTxtPass(), getData(2, 1));
		btnClick(l.getBtnLogin());
		System.out.println("Test case 2 executed");
	}

	@Test(priority=-17)
	public void testACase04() throws IOException {
		driver.navigate().refresh();
		loadUrl("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		printTitle();
		printCurrentUrl();
		
		LoginPojo l = new LoginPojo();
		btnClick(l.getAcceptBtn());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fillValues(l.getTxtUser(), getData(4, 0));
		fillValues(l.getTxtPass(), getData(4, 1));
		btnClick(l.getBtnLogin());
		System.out.println("Test case 4 executed");
	}
	
	@Test(priority=-11,enabled=false)
	public void testCase03() throws IOException {
		driver.navigate().refresh();
		loadUrl("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		printTitle();
		printCurrentUrl();
		
		LoginPojo l = new LoginPojo();
		//btnClick(l.getAcceptBtn());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fillValues(l.getTxtUser(), getData(3, 0));
		fillValues(l.getTxtPass(), getData(3, 1));
		btnClick(l.getBtnLogin());
		System.out.println("Test case 3 executed");
	}
	
	@Test(groups="smoke")
	public void testCase01() throws IOException {
		loadUrl("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		printTitle();
		printCurrentUrl();
		
		LoginPojo l = new LoginPojo();
		btnClick(l.getAcceptBtn());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fillValues(l.getTxtUser(), getData(1, 0));
		fillValues(l.getTxtPass(), getData(1, 1));
		btnClick(l.getBtnLogin());
		System.out.println("Test case 1 executed");
	}
	
}
