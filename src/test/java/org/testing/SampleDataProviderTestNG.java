package org.testing;

import org.testng.annotations.DataProvider;
import org.utilities.CreateNewAccountFB;

public class SampleDataProviderTestNG extends CreateNewAccountFB{

	@DataProvider(name="FormFillDetails")
	public Object Data() {
		
		
		return new Object[][] {
			{"Poornima", "Subbarayan", "poornima.subbarayan@gmail.com", "7424756132","5, Bacara court, 4 Charlton drive, Sale, M332BJ","Female"}
		};
		
	}

	@DataProvider(name="FBNewAccountForm")
	public Object FBNewData() {
		
		CreateNewAccountFB fb = new CreateNewAccountFB();
		return new Object[][] {
			{"Mouraa", "Jyoshna", "test1253453@gmail.com", "test1253453@gmail.com", "happy@123",22, "Apr", "2013", fb.getFemale()},
			{"Jyoshna", "Poornima", "test123983@gmail.com", "test123983@gmail.com", "happy@123",12, "Jun", "2001", fb.getGenderCustom()},
			{"Thiru", "Mouraa", "test38743@gmail.com", "test38743@gmail.com", "happy@123",15, "Nov", "1982", fb.getMale()},
			{"Poornima", "Thiru", "test567853@gmail.com", "test567853@gmail.com", "happy@123",7, "Nov", "2016", fb.getFemale()}
		};
		 
	}
	
}
