package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Actions a;
	public static Select s;
	public static Date d;
	public static Robot r;
	public static JavascriptExecutor jk;
	public static TakesScreenshot tk;
	public static Alert al;

	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static void winMax() {
		driver.manage().window().maximize();
	}

	public static void printTitle() {
		System.out.println(driver.getTitle());
	}

	public static void printCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
	}

	
	public static void fillValues(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	public static void btnClick(WebElement ele) {
		ele.click();
	}

	public static void dragDrop(WebElement src, WebElement dest) {
		a = new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}
	
	public static void movingToAnElement(WebElement ele) {
		a = new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	public static void dClick(WebElement ele) {
		a = new Actions(driver);
		a.doubleClick(ele).perform();
	}

	public static void rightClick(WebElement ele) {
		a = new Actions(driver);
		a.contextClick(ele).perform();
	}
	
	public static void capsLock() throws AWTException {
		r= new Robot();
		r.keyPress(KeyEvent.VK_CAPS_LOCK);
		r.keyRelease(KeyEvent.VK_CAPS_LOCK);
	}
	
	public static void downArrowClick() throws AWTException {
		r= new Robot();
		for (int i = 0; i < 3; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
	}
	
	public static void releaseDownArrowClick() throws AWTException {
		r= new Robot();
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	
	public static void clickTab() throws AWTException {
		r= new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	
	public static void pasteTheCopiedValue() throws AWTException {
		r= new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	
	public static void clickEnter() throws AWTException {
		r= new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void scrollUpAndView(WebElement ele) {
		jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].scrollIntoView(true)", ele);
	}
	
	public static void scrollDownAndView(WebElement ele) {
		jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].scrollIntoView(true)", ele);
	}
	
	public static void scrollAndGetAttributeValue(WebElement ele) {
		jk = (JavascriptExecutor) driver;
		Object obj = jk.executeScript("return arguments[0].getAttribute('value')", ele);
		String text = (String)obj;
		System.out.println(text);
	}
	
	public static void highLightAnElement(WebElement ele) {
		jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].setAttribute('style','background: pink; border:7px solid brown;')", ele);
	}
	
	public static void alertAccept(WebElement ele) {
		ele.click();
		al = driver.switchTo().alert();
		String text = al.getText();
		System.out.println(text);
		al.accept();
	}
	
	public static void alertDecline(WebElement ele) {
		ele.click();
		al = driver.switchTo().alert();
		String text = al.getText();
		System.out.println(text);
		al.dismiss();
	}
	
	public static void findParentWindowID() {
		String windowHandle = driver.getWindowHandle();
		System.out.println("Parent Window ID is :"+windowHandle);
	}
	
	public static void findAllWindowsID() {
		Set<String> allWinIDs = driver.getWindowHandles();
		System.out.println("Parent and Child windows ID: "+allWinIDs);
	}
	
	public static void printingWebTable(WebElement ele) {
		// WebElement table = driver.findElement(By.id("customers"));

		System.out.println("\nUsing for loop Iteration method");
		List<WebElement> tableRows = ele.findElements(By.tagName("tr"));

		for (int i = 0; i < tableRows.size(); i++) {

			WebElement heading = tableRows.get(i);
			List<WebElement> headingRow = heading.findElements(By.tagName("th"));

			for (int j = 0; j < headingRow.size(); j++) {
				WebElement headingText = headingRow.get(j);
				String text = headingText.getText();
				System.out.println(text);
			}

			List<WebElement> dataRow = heading.findElements(By.tagName("td"));
			for (int k = 0; k < dataRow.size(); k++) {
				System.out.println(dataRow.get(k).getText());
			}
			i = i + 1;
			System.out.println("i value is: " + i);

		}
	}
	
	public static void sleepWait() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void screenshot(String name) throws IOException {
		tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Thirumurugan S\\eclipse-workspace\\SeleniumProjects\\Screenshots\\"+name+".jpg");
		FileUtils.copyFile(src,des);
	}
	
	public static void selectValueByIndex(WebElement ele, int date) {
		s = new Select(ele);
		s.selectByIndex(date);
		// System.out.println(ele.getText());
		//System.out.println("\n" + ele.getAttribute("value"));
	}

	public static void selectValueByValue(WebElement ele, String val) {
		s = new Select(ele);
		s.selectByValue(val);
		//System.out.println(ele.getAttribute("value"));
	}
	
	public static void selectValueByVisibleText(WebElement ele, String val) {
		s = new Select(ele);
		s.selectByVisibleText(val);
		//System.out.println(ele.getAttribute("value"));
	}
	
	public static void allSelectedOptions(WebElement ele) {
		s = new Select(ele);
		List<WebElement> listSel = s.getAllSelectedOptions();
		for (WebElement ele1 : listSel) {
			System.out.println("List of fruits selected: " + ele1.getText());
		}
	}
	
	public static void firstSelectedOption(WebElement ele) {
		s = new Select(ele);
		WebElement firstOne = s.getFirstSelectedOption();
		System.out.println("\nFirst fruit is:"+ firstOne.getText()+"\n");
	}
	
	public static void deselectTheOptionByIndex(WebElement ele, int i) {
		s = new Select(ele);
		s.deselectByIndex(i);
	}
	
	public static void deselectTheOptionByValue(WebElement ele, String val) {
		s = new Select(ele);
		s.deselectByValue(val);
	}
	
	public static void deselectTheOptionByVisibleText(WebElement ele, String val) {
		s = new Select(ele);
		s.deselectByValue(val);
	}

	public static String getData(int rowNumber, int cellNumber) throws IOException {
		File f = new File(
				"C:\\Users\\Thirumurugan S\\eclipse-workspace\\SampleMavenProgram\\target\\ExcelData\\TestData.xlsx");
		FileInputStream fInp = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fInp);
		Sheet s = w.getSheet("FBNewAccount");
		Row row = s.getRow(rowNumber);
		Cell cell = row.getCell(cellNumber);
		int cellType = cell.getCellType();
		String value = "";

		if (cellType == 1) {
			value = cell.getStringCellValue();
		} 
		else if (cellType == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
				value = sim.format(dateCellValue);
			} 
			else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				value = String.valueOf(l);
			}
		}
		return value;
	}
	
	public static void printStartTime() {
		d = new Date();
		System.out.println("Start Time :" +d);
	}
	
	public static void printEndTime() {
		d = new Date();
		System.out.println("End Time :" +d);
	}
	
	
}
