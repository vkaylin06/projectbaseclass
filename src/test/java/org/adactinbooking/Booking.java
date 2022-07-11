package org.adactinbooking;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.reusableCode.BaseClass;

public class Booking {
	public static void main(String[] args) throws IOException {
		BaseClass b = new BaseClass();
		b.browserLaunch("chrome");
		b.UrlLaunch("https://adactinhotelapp.com/");
		WebElement user = b.idLocator("username");
		String userData = b.excelReadData("Sheet1", 1, 0, "adactin inputs.xlsx");
		b.textPass(user, userData);
		WebElement pass = b.idLocator("password");
		String passData = b.excelReadData("Sheet1", 1, 1, "adactin inputs.xlsx");
		b.textPass(pass, passData);
		WebElement login = b.idLocator("login");
		b.buttonClick(login);
		WebElement loc = b.idLocator("location");
		b.buttonClick(loc);
		b.selectDropDownValue(loc, "index", "1");
		WebElement hotel = b.idLocator("hotels");
		b.buttonClick(hotel);
		b.selectDropDownValue(hotel, "value", "Hotel Sunshine");
		WebElement room = b.idLocator("room_type");
		b.buttonClick(room);
		b.selectDropDownValue(room, "visibletext", "Super Deluxe");
		WebElement num = b.idLocator("room_nos");
		b.buttonClick(num);
		b.selectDropDownValue(num, "value", "2");
		WebElement dateIn = b.nameLocator("datepick_in");
		b.clearText(dateIn);
		String readDateIn = b.excelReadData("Sheet1", 1, 2, "adactin inputs.xlsx");
		b.textPass(dateIn, readDateIn);

		WebElement dateOut = b.nameLocator("datepick_out");
		b.clearText(dateOut);
		String readDateOut = b.excelReadData("Sheet1", 1, 3, "adactin inputs.xlsx");
		b.textPass(dateOut, readDateOut);

		WebElement adult = b.idLocator("adult_room");
		b.buttonClick(adult);
		b.selectDropDownValue(adult, "index", "2");
		WebElement submit = b.idLocator("Submit");
		b.buttonClick(submit);
		WebElement radiobutton = b.idLocator("radiobutton_0");
		b.buttonClick(radiobutton);
		WebElement cont = b.idLocator("continue");
		b.buttonClick(cont);

		WebElement firstName = b.nameLocator("first_name");
		String first = b.excelReadData("Sheet1", 1, 4, "adactin inputs.xlsx");
		b.textPass(firstName, first);

		WebElement lastName = b.nameLocator("last_name");
		String last = b.excelReadData("Sheet1", 1, 5, "adactin inputs.xlsx");
		b.textPass(lastName, last);

		WebElement add = b.nameLocator("address");
		String address = b.excelReadData("Sheet1", 1, 6, "adactin inputs.xlsx");
		b.textPass(add, address);

		WebElement card = b.nameLocator("cc_num");
		String cardNum = b.excelReadData("Sheet1", 1, 7, "adactin inputs.xlsx");
		b.textPass(card, cardNum);

		WebElement cardType = b.idLocator("cc_type");
		b.buttonClick(cardType);
		b.selectDropDownValue(cardType, "index", "2");

		WebElement month = b.idLocator("cc_exp_month");
		b.buttonClick(month);
		b.selectDropDownValue(month, "value", "8");

		WebElement year = b.idLocator("cc_exp_year");
		b.buttonClick(year);
		b.selectDropDownValue(year, "value", "2022");

		WebElement cvv = b.nameLocator("cc_cvv");
		b.textPass(cvv, "123");

		WebElement book = b.nameLocator("book_now");
		b.buttonClick(book);

		WebElement order = b.nameLocator("order_no");
		String orderId = b.attributeVal(order, "value");

		b.excelWriteData("Sheet1", 1, 8, "adactin inputs.xlsx", orderId);
		System.out.println("*********adactin********");
		System.out.println("*********adactinlogin********");
		b.quitDriver();
	}

}
