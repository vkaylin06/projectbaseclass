package org.reusableCode;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class MainClass extends BaseClass {
	public static void main(String[] args) throws InterruptedException, AWTException, IOException  {
		MainClass m = new MainClass();
		m.browserLaunch("chrome");
		/*m.UrlLaunch("https://www.facebook.com/");
		m.title();
		m.currentUrl();
		WebElement email = m.idLocator("email");
		m.textPass(email,"abcd@gmail.com");
		WebElement password = m.nameLocator("pass");
		m.textPass(password,"4666@#$44");
		WebElement login = m.xpathLocator("//button[text()='Log In']");
		m.buttonClick(login);
		Thread.sleep(2000);
		try {
			m.clearText(email);
			m.printText(login);
			m.attributeVal(password, "placeholder");
		} catch (StaleElementReferenceException e) {
		    email = m.idLocator("email");
			m.clearText(email);
			login = m.xpathLocator("//button[text()='Log In']");
			String text = m.printText(login);
			System.out.println("the text value of the webelement login is : " + text);
			password = m.nameLocator("pass");
			String Values = m.attributeVal(password, "placeholder");
			System.out.println("the value of attribute 'placeholder' is : " + Values);
		}
		m.navigateTo("https://www.amazon.in/");
		m.pageRefresh();
		m.navigateBack();
		m.pageRefresh();
		m.navigateForward();
		m.navigateTo("http://greenstech.in/selenium-course-content.html");
		WebElement hover = m.xpathLocator("//div[@title='Courses']");
		m.mousehover(hover);
		m.navigateTo("https://demo.guru99.com/test/drag_drop.html");
		WebElement src = m.idLocator("credit2");
		WebElement des = m.idLocator("bank");
		m.dragDrop(src, des);
		Thread.sleep(2000);
		try {
			m.navigateTo("https://www.amazon.in/");	
		} catch (WebDriverException e) {
			m.navigateTo("https://www.amazon.in/");	
		}
		
		WebElement searchbox = m.idLocator("twotabsearchtextbox");
		m.textPass(searchbox, "iphone13");
        m.doubleClicking(searchbox);
        m.rightClick(searchbox);
        for (int i = 0; i <=1; i++) {
        	 m.pressKey(KeyEvent.VK_DOWN);
             m.releaseKey(KeyEvent.VK_DOWN);
		    }
        Thread.sleep(2000);
         m.pressKey(KeyEvent.VK_ENTER);
         m.releaseKey(KeyEvent.VK_ENTER);
         m.navigateBack();
         try {
        	 m.navigateBack();
			
		} catch (WebDriverException e) {
			 m.navigateBack();
		}
         m.scrollDownAndUp(Keys.PAGE_DOWN);
         m.scrollDownAndUp(Keys.PAGE_UP);
         m.navigateTo("https://www.facebook.com/");
         try {
        	 m.pressKeyAction(email,Keys.SHIFT);
             m.sendText(email, "tony");
             m.releaseKeyAction(email,Keys.SHIFT);
		} catch (StaleElementReferenceException e) {
			 email = m.idLocator("email");
			 m.pressKeyAction(email,Keys.SHIFT);
	         m.sendText(email, "tony");
	         m.releaseKeyAction(email,Keys.SHIFT);
		}
        WebElement newacc = m.xpathLocator("//a[text()='Create New Account']")  ;
        m.buttonClick(newacc);
        WebElement day = m.idLocator("day");
        m.selectDropDownValue(day,"index", "5");
        WebElement month = m.idLocator("month");
        m.selectDropDownValue(month, "visibletext", "Oct");
        WebElement year = m.idLocator("year");
        m.selectDropDownValue(year, "value", "1995");
        Thread.sleep(2000);
        m.printAllOptions(day);
        m.printAllOptions(month);
        m.navigateTo("https://output.jsbin.com/osebed/2");
        WebElement fruits = m.idLocator("fruits");
        m.selectDropDownValue(fruits,"index", "0");
        m.selectDropDownValue(fruits, "visibletext","Apple");
        m.selectDropDownValue(fruits, "visibletext","Orange");
        m.deselectDropDownValue(fruits, "visibletext","Banana");
        m.deselectAllVal(fruits);
        Thread.sleep(2000);
        m.selectDropDownValue(fruits,"index", "0");
        m.selectDropDownValue(fruits, "visibletext","Apple");
        m.selectDropDownValue(fruits, "visibletext","Orange");
        boolean checkMultiSelect = m.checkMultiSelect(fruits);
        System.out.println("can multiSelect be performed on webelement fruits : " + checkMultiSelect);
        m.printSelected(fruits);
        String firstSelected = m.printFirstSelected(fruits);
        System.out.println("the first selected value is :" + firstSelected );
       // m.captureImage("multiple fruits");
        m.navigateTo("https://nxtgenaiacademy.com/alertandpopup/");
        m.nameLocator("alertbox").click();
        m.simpleAlert();
        m.nameLocator("confirmalertbox").click();
        m.confirmAlert("reject");
        m.nameLocator("promptalertbox1234").click();
        Thread.sleep(2000);
        m.promptAlert("Yes", "accept");
        m.navigateTo("https://netbanking.hdfcbank.com/netbanking/");
       // m.frameControlByName("login_page");
        WebElement framelocate= m.xpathLocator("//frame[@name='login_page']");
        m.frameControlByRefName(framelocate);
        m.nameLocator("fldLoginUserId").sendKeys("abcd");
        m.navigateTo("https://www.facebook.com/");
        try {
        	 m.jsExecuteScript("arguments[0].setAttribute('value','abcd')", email);
        	 m.jsExecuteScript("return arguments[0].getAttribute('placeholder')",email);
        	 
		} catch (StaleElementReferenceException e) {
			 email = m.idLocator("email");
			 m.jsExecuteScript("arguments[0].setAttribute('value','abcd')", email);
			 Object getattri = m.jsExecuteScript("return arguments[0].getAttribute('placeholder')",email);
			 System.out.println("the value of the attribute placeholder is : " + getattri);
			 
		}*/
       
      m.navigateTo("http://demo.automationtesting.in/Windows.html");
      WebElement button = m.xpathLocator("//button[@class='btn btn-info']");
       m.buttonClick(button);
       Thread.sleep(2000);
       m.parWindow();
       WebElement multiple = m.xpathLocator("//a[text()='Open Seperate Multiple Windows']");
       m.buttonClick(multiple);
       
}}
