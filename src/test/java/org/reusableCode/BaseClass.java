package org.reusableCode;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	// launch the browser
	public void browserLaunch(String browser) {

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "egde":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser name");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	// launch the url
	public void UrlLaunch(String url) {
		driver.get(url);

	}

	// to get the current url
	public void currentUrl() {
		String Curl = driver.getCurrentUrl();
		System.out.println("the current url of the page is :" + Curl);

	}

	// to print the title of the page
	public void title() {
		String title = driver.getTitle();
		System.out.println("the title of the page is : " + title);
	}

	// to close the current window
	public void closeWindow() {
		driver.close();

	}

	// to quit the driver that is to close all the opened windows
	public void quitDriver() {
		driver.quit();
	}

	// methods for locator strategies
	public WebElement idLocator(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;
	}

	public WebElement nameLocator(String name1) {
		return driver.findElement(By.name(name1));

	}

	public WebElement xpathLocator(String Expression) {
		return driver.findElement(By.xpath(Expression));

	}

	public WebElement classNameLocator(String className) {
		return driver.findElement(By.className(className));

	}

	public WebElement tagNameLocator(String tagName) {
		return driver.findElement(By.tagName(tagName));
	}

	// to pass values to the webelement
	public void textPass(WebElement element, String data) {
		element.sendKeys(data);

	}

	// to click the webelement
	public void buttonClick(WebElement element) {
		element.click();

	}

	// to clear the text passed
	public void clearText(WebElement element) {
		element.clear();

	}

	// to print the visible inner text value of the webelement
	public String printText(WebElement element) {
		String text = element.getText();
		return text;

	};

	// to return the value of the web elements attribute as a string
	public String attributeVal(WebElement element, String attriName) {
		String attribute = element.getAttribute(attriName);
		return attribute;

	}

	// navigate to particular url
	public void navigateTo(String url) {
		driver.navigate().to(url);

	}

	// page refresh operation
	public void pageRefresh() {
		driver.navigate().refresh();

	}

	// to move to previous page
	public void navigateBack() {
		driver.navigate().back();

	}

	// same operation as clicking on the forward button of any browser
	public void navigateForward() {
		driver.navigate().forward();

	}

	// to perform mouse hover actions
	public void mousehover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

	}

	// to perform drag and drop action
	public void dragDrop(WebElement source, WebElement destination) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, destination).perform();
	}

	// to perform double click
	public void doubleClicking(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();

	}

	// to perform right click
	public void rightClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();

	}

	// to press key using Robot class
	public void pressKey(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyPress(keycode);

	}

	// to release the pressed key using Robot class
	public void releaseKey(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyRelease(keycode);

	}

	// to perform page scroll down and scroll up using Actions class
	public void scrollDownAndUp(CharSequence keys) throws InterruptedException {
		Actions act = new Actions(driver);
		for (int i = 0; i < 5; i++) {
			act.sendKeys(keys).perform();
			Thread.sleep(2000);
		}
	}

	// pass text using the Actions class
	public void sendText(WebElement target, CharSequence text) {
		Actions act = new Actions(driver);
		act.sendKeys(target, text).perform();
	}

	// to press key using actions class
	public void pressKeyAction(WebElement element, CharSequence key) {
		Actions act = new Actions(driver);
		act.keyDown(element, key).perform();

	}

	// to release key using the actions class
	public void releaseKeyAction(WebElement element, CharSequence key) {
		Actions act = new Actions(driver);
		act.keyUp(element, key).perform();

	}

	// to select drop down values
	public void selectDropDownValue(WebElement element, String type, String value) {
		Select s = new Select(element);
		switch (type) {
		case "index":
			s.selectByIndex(Integer.parseInt(value));
			break;

		case "value":
			s.selectByValue(value);
			break;

		case "visibletext":
			s.selectByVisibleText(value);
			break;

		default:
			System.out.println("invalid selection criteria");
			break;
		}
	}

	// to get all the options present in the dropdown
	public String printAllOptions(WebElement element) {
		Select s = new Select(element);
		System.out.print("the dropdown values are :");
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();
			return text;
		}

		return null;

	}

	// to deselect drop down values
	public void deselectDropDownValue(WebElement element, String type, String value) {
		Select s = new Select(element);
		switch (type) {
		case "index":
			s.deselectByIndex(Integer.parseInt(value));
			break;

		case "value":
			s.deselectByValue(value);
			break;

		case "visibletext":
			s.deselectByVisibleText(value);
			break;

		default:
			System.out.println("invalid deselection criteria");
			break;
		}
	}

	// to deselect all multiselected values
	public void deselectAllVal(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();

	}

	// whether we can perform multiselect or not
	public boolean checkMultiSelect(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		return multiple;
	}

	// to print all the selected values
	public String printSelected(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		System.out.println("The selected options are:");
		for (WebElement allselected : allSelectedOptions) {
			String text = allselected.getText();
			return text;

		}

		return null;
	}

	// to print the first selected value
	public String printFirstSelected(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption.getText();

	}

	// to take screenshot
	public void captureImage(String imagename) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\ACER\\screenshots\\" + imagename + ".png");
		FileUtils.copyFile(source, des);
	}

	// to handle simple alert
	public void simpleAlert() {
		driver.switchTo().alert().accept();
	}

	// to handle confirm alert
	public void confirmAlert(String choice) {
		if (choice.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		} else {
			driver.switchTo().alert().dismiss();
		}
	}

//to handle the prompt alert
	public void promptAlert(String val, String choice) throws InterruptedException {
		Alert prompt = driver.switchTo().alert();
		if (choice == "accept") {
			prompt.sendKeys(val);
			prompt.accept();
		} else {
			prompt.sendKeys(val);
			prompt.dismiss();
		}
	}

//to switch control to the frame using index
	public void frameControlByIndex(int index) {
		driver.switchTo().frame(index);

	}

//to switch control to the frame using name
	public void frameControlByName(String name) {
		driver.switchTo().frame(name);

	}

// to switch control to the frame using the webelement reference
	public void frameControlByRefName(WebElement frameElement) {
		driver.switchTo().frame(frameElement);

	}

//Java script insert values in a text box
	public void jsInsertValue(String text, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);

	}

//java script get the attribute value
	public Object jsGetAttribute(WebElement element, String attributeName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object attriVal = js.executeScript("return arguments[0].getAttribute('" + attributeName + "')", element);
		return attriVal;
	}

//javascript click the button
	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

//to perform Scroll down using java script
	public void jsScrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

//to perform scrollup using java script
	public void jsScrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

//Window handling
	public void windowHandle() {
		String parId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
		for (String id : allIds) {
			if (!parId.equals(id)) {
				driver.switchTo().window(id);
			}
		}
	}

//parentwindow
	public void parWindow() {
		String parId = driver.getWindowHandle();
		driver.switchTo().window(parId);

	}

//handling multiple windows
	public void multipleWinHandle(int index) {
		String parId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
		List<String> li = new ArrayList<>();
		li.addAll(allIds);
		driver.switchTo().window(li.get(index));
	}

//read a particular value from the exccel
	public String excelReadData(String sheetName, int rowNo, int colNo, String fileName) throws IOException {
		File file = new File("E:\\" + fileName + "");
		FileInputStream f = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(f);
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(colNo);
		String res = null;
		CellType cellTypeEnum = cell.getCellTypeEnum();
		switch (cellTypeEnum) {
		case STRING:
			// to get the value from the cell as a string
			res = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dcv = cell.getDateCellValue();
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyy");
				res = simple.format(dcv);

			} else {
				// to get the value from the cell as numeric
				double d = cell.getNumericCellValue();
				BigDecimal b = BigDecimal.valueOf(d);
				// covert the value to string
				res = b.toString();

			}

			break;
		default:
			break;

		}
		return res;
	}

	// update a data in excel
	public void excelUpdateData(String sheetName, int rowNo, int colNo, String fileName, String oldData, String newData)
			throws IOException {

		File file = new File("E:\\" + fileName + "");
		FileInputStream f = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(f);
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(colNo);
		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream o = new FileOutputStream(file);
		w.write(o);
	}
// write a data in excel consider cell empty
	public void excelWriteData(String sheetName, int rowNo, int colNo, String fileName, String newData)
			throws IOException {

		File file = new File("E:\\" + fileName + "");
		FileInputStream f = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(f);
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.createCell(colNo);
		cell.setCellValue(newData);
		FileOutputStream o = new FileOutputStream(file);
		w.write(o);
	}
}
