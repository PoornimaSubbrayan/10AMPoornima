package org.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.utilities.BaseClass;

public class MavenActionMethods extends BaseClass{

public static void main(String[] args) {
		
		launchChrome();
		loadUrl("https://en-gb.facebook.com/");
		winMax();
		printTitle();
		printCurrentUrl();
		
		driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
		WebElement newAccount = driver.findElement(By.xpath("//a[contains(text(),'New')]"));
		newAccount.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		

		WebElement day = driver.findElement(By.id("day"));
		selectValueByIndex(day, 23);
		
		WebElement month = driver.findElement(By.id("month"));
		selectValueByValue(month, "7");
		
		WebElement year = driver.findElement(By.xpath("//select[@title='Year']"));
		selectValueByValue(year, "1983");
		
}		
}
