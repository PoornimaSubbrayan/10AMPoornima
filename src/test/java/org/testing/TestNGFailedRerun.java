package org.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGFailedRerun {
	
	@Test(retryAnalyzer=Failed.class)
	public void TC01() {
		Assert.assertTrue(false);
		System.out.println("Test case 1");
	}
	
	@Test
	public void TC02() {
		System.out.println("Test case 2");
	}
	
	@Test
	public void TC03() {
		System.out.println("Test case 3");
	}
	
	@Test(retryAnalyzer=Failed.class)
	public void TC04(){
		Assert.assertTrue(false);
		System.out.println("Test case 3");
	}

}
