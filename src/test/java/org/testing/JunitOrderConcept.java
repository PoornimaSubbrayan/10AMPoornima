package org.testing;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.utilities.BaseClass;
import org.utilities.LoginPojo;

public class JunitOrderConcept extends BaseClass {
	public static Date d;
	@BeforeClass
	public static void launchingBrowser() {
		launchChrome();
	}
	
	@AfterClass
	public static void closingBrowser() {
		driver.close();
	}
	
	@Before
	public void startTime() {
		d = new Date();
		System.out.println("\nStart time of test case execution: "+d);
	}
	
	@After
	public void endTime() {
		d = new Date();
		System.out.println("End Time of test execution: "+d);
	}
	
	@Ignore
	@Test
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
	@Test
	public void testCase04() throws IOException {
		driver.navigate().refresh();
		loadUrl("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		printTitle();
		printCurrentUrl();
		
		LoginPojo l = new LoginPojo();
		//btnClick(l.getAcceptBtn());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fillValues(l.getTxtUser(), getData(4, 0));
		fillValues(l.getTxtPass(), getData(4, 1));
		btnClick(l.getBtnLogin());
		System.out.println("Test case 4 executed");
	}
	
	@Ignore
	@Test
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
	
	@Test
	public void testCase01() throws IOException {
		loadUrl("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
//		printTitle();
//		printCurrentUrl();
		
		String title = driver.getTitle();
		Assert.assertTrue("Verify the Title", title.contains("Facebook"));
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("Current URL to be verified", "HTTP", currentUrl);
		
		LoginPojo l = new LoginPojo();
		btnClick(l.getAcceptBtn());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fillValues(l.getTxtUser(), getData(1, 0));
		fillValues(l.getTxtPass(), getData(1, 1));
		btnClick(l.getBtnLogin());
		System.out.println("Test case 1 executed");
	}
	
}
