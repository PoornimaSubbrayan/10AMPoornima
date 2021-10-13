package org.testing;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.utilities.BaseClass;
import org.utilities.LoginPojo;
import org.utilities.RedBusPojo;

public class Junit2ndProgram extends BaseClass {
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
		System.out.println("\nStart time of test case execution: " + d);
	}

	@After
	public void endTime() {
		d = new Date();
		System.out.println("End Time of test execution: " + d);
	}

	@Test
	public void testCase01() throws IOException, InterruptedException {
		loadUrl("https://www.redbus.in/");
		driver.manage().window().maximize();
		printTitle();
		printCurrentUrl();

		RedBusPojo r = new RedBusPojo();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fillValues(r.getSourceLoc(), r.getData(8, 0));
		fillValues(r.getDestLoc(), r.getData(8, 1));
		fillValues(r.getDateOfJourney(), r.getData(8, 2));
		Thread.sleep(2000);
		System.out.println("Test case 1 executed");
	}

	@Test
	public void testCase03() throws IOException, InterruptedException {
		loadUrl("https://www.redbus.in/");
		driver.manage().window().maximize();
		printTitle();
		printCurrentUrl();
		
		RedBusPojo r= new RedBusPojo();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fillValues(r.getSourceLoc(), r.getData(9, 0));
		fillValues(r.getDestLoc(), r.getData(9, 1));
		fillValues(r.getDateOfJourney(),r.getData(9, 2));
		Thread.sleep(2000);
		System.out.println("Test case 3 executed");
	}
	
	@Test
	public void testCase02() throws IOException, InterruptedException {
		loadUrl("https://www.redbus.in/");
		driver.manage().window().maximize();
		printTitle();
		printCurrentUrl();
		
		RedBusPojo r= new RedBusPojo();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fillValues(r.getSourceLoc(), r.getData(10, 0));
		fillValues(r.getDestLoc(), r.getData(10, 1));
		fillValues(r.getDateOfJourney(),r.getData(10, 2));
		Thread.sleep(2000);
		System.out.println("Test case 2 executed");

	}
}
