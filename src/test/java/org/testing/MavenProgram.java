package org.testing;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.utilities.BaseClass;
import org.utilities.LoginPojo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenProgram extends BaseClass {
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		
		launchChrome();
		loadUrl("https://en-gb.facebook.com/");
		winMax();
		printTitle();
		printCurrentUrl();
		
		LoginPojo l = new LoginPojo();
		//acceptBtn.click();
		btnClick(l.getAcceptBtn());
		
		//WebElement txtUser = driver.findElement(By.id("email"));
		fillValues(l.getTxtUser(), getData(5,0));
		dClick(l.getTxtUser());
		rightClick(l.getTxtUser());
		sleepWait();
		
		//capsLock();
		downArrowClick();
		//releaseDownArrowClick();
		
		clickEnter();
		clickTab();
		pasteTheCopiedValue();

		//WebElement pwd = driver.findElement(By.id("pass"));
//		fillValues(l.getTxtPass(), getData(7, 1));
//		
//		driver.navigate().refresh();
//		
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		
//		LoginPojo l1 = new LoginPojo();
//		
//		fillValues(l1.getTxtUser(), getData(4,0));
//		fillValues(l1.getTxtPass(), getData(6, 4));
//		//WebElement btnLogin = driver.findElement(By.xpath("//button[@name='login']"));
//		btnClick(l1.getBtnLogin());
//		
	
		
		
	}

}
