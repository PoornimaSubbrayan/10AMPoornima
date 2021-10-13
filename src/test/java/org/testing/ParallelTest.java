package org.testing;

import org.testng.annotations.Test;

public class ParallelTest {
	
	@Test
	public void TC01() {
		System.out.println("Test case 1");
		System.out.println("TC1 thread id: " +Thread.currentThread().getId());
	}
	
	@Test
	public void TC02() {
		System.out.println("Test case 2");
		System.out.println("TC2 thread id: " +Thread.currentThread().getId());
	}
	
	@Test
	public void TC03() {
		System.out.println("Test case 3");
		System.out.println("TC3 thread id: " +Thread.currentThread().getId());
	}

}
