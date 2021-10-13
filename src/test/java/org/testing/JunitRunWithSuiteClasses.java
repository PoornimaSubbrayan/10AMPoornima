package org.testing;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


//@RunWith(Suite.class)
//@SuiteClasses({ JunitOrderConcept.class,Junit2ndProgram.class })

public class JunitRunWithSuiteClasses {
	
	@Test
	public void testcase1() {
		Result rs = JUnitCore.runClasses(JunitOrderConcept.class, Junit2ndProgram.class);
		System.out.println("\nTotal test cases count: "+rs.getRunCount());
		System.out.println("\nTotal failure count: "+rs.getFailureCount());
		System.out.println("\nTotal ignore count: "+rs.getIgnoreCount());

		List<Failure> fail = rs.getFailures();
		for (Failure failure : fail) {
			System.out.println("\n"+failure);
			
		}
	}

}
