package com.package_junit;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class AdactinBookingDDUnit extends BaseClass {
	static WebDriver driver;
	static String path = "C:\\Users\\Raj\\Downloads\\workspace\\MavenDemo\\Excel Sheets\\WorksheetAdactin.xlsx";
	static String sheetname = "Adactin";
	
	@BeforeClass
	public static void beforeClass() {

		getDriver();
		enterUrl("https://adactinhotelapp.com/");
		maximize();
	}
	@AfterClass
	public static void afterClass() {
		closeAllWindow();
	}
	
	@Test
	public void bookHotel() throws InterruptedException, IOException {
		
		WebElement txtUserName = findElementById("username");
		elementSendKeys(txtUserName,readValueExcel(path,sheetname,1,0));
		
		WebElement txtPassword = findElementById("password");
		elementSendKeys(txtPassword,readValueExcel(path,sheetname,1,1));
		
		WebElement btnLogin = findElementById("login");
		elementClick(btnLogin);
	
		Thread.sleep(3000);
		
		//Verify User welcome Msg
		WebElement lblUserWelcome = findElementById("username_show");
		String  userWelcomeMsg = elementGetAttribute(lblUserWelcome);
		
		Assert.assertEquals("Verify User welcome Msg", "Hello Greens8767!",userWelcomeMsg );
		
		WebElement dDnLocation = findElementById("location");
		selectOptionByText(dDnLocation,readValueExcel(path,sheetname,1,2));
		
		
		WebElement dDnHotels = findElementById("hotels");
		selectOptionByText(dDnHotels,readValueExcel(path,sheetname,1,3));
	
		WebElement dDnRoom = findElementById("room_type");
		selectOptionByText(dDnRoom,readValueExcel(path,sheetname,1,4));
		
		WebElement dDnNoOfRooms = findElementById("room_nos");
		selectOptionByText(dDnNoOfRooms,readValueExcel(path,sheetname,1,5));
		
		String inDate= readValueExcel(path,sheetname,1,7);
		
		System.out.println("inDate"+inDate);
		
		WebElement txtInDatePick =findElementById("datepick_in");
		txtInDatePick.clear();
		elementSendKeys(txtInDatePick,inDate);
		
		String outDate= readValueExcel(path,sheetname,1,8);

		System.out.println("outDate"+outDate);
		
		WebElement txtOutDatePick = findElementById("datepick_out");
		txtOutDatePick.clear();
		elementSendKeys(txtOutDatePick,outDate);
		
		WebElement dDnAdult = findElementById("adult_room");
		selectOptionByText(dDnAdult,readValueExcel(path,sheetname,1,9));

		WebElement dDnChild = findElementById("child_room");
		selectOptionByText(dDnChild,readValueExcel(path,sheetname,1,10));
		
		WebElement btnSearch = findElementById("Submit");
		elementClick(btnSearch);
		
		
		Thread.sleep(3000);

		//Verify Select Hotel label
		WebElement lblSelectHotel = findElementByXpath("//td[text()='Select Hotel ']");
		String  lblSelectHotelText = getText(lblSelectHotel);
		
		Assert.assertEquals("Verify Select Hotel label", "Select Hotel",lblSelectHotelText );
		
//		Thread.sleep(1000);

		WebElement btnRadio = findElementById("radiobutton_0");
		elementClick(btnRadio);
		
		WebElement btnContinue = findElementById("continue");
		elementClick(btnContinue);
		

//		Thread.sleep(1000);
		
		//Verify Book a Hotel Label
		WebElement lblBookHotel = findElementByXpath("//td[text()='Book A Hotel ']");
		String  lblBookHotelText = getText(lblBookHotel);
		
		Assert.assertEquals("Verify Book a Hotel Label", "Book A Hotel",lblBookHotelText );

		
		WebElement txtFirstName = findElementById("first_name");
		elementSendKeys(txtFirstName,readValueExcel(path,sheetname,1,11));
		

		WebElement txtLastName = findElementById("last_name");
		elementSendKeys(txtLastName,readValueExcel(path,sheetname,1,12));
		
		WebElement txtAddress = findElementById("address");
		elementSendKeys(txtAddress,readValueExcel(path,sheetname,1,13));
		
		WebElement txtCreditCardNo = findElementById("cc_num");
		elementSendKeys(txtCreditCardNo,readValueExcel(path,sheetname,1,14));
		
		WebElement dDnCcType = findElementById("cc_type");
		selectOptionByText(dDnCcType,readValueExcel(path,sheetname,1,15));

		WebElement dDnExpMonth = findElementById("cc_exp_month");
		selectOptionByText(dDnExpMonth,readValueExcel(path,sheetname,1,16));

		WebElement dDnExpYear = findElementById("cc_exp_year");
		selectOptionByText(dDnExpYear,String.valueOf(readValueExcel(path,sheetname,1,17)));
		
		WebElement txtCvv = findElementById("cc_cvv");
		elementSendKeys(txtCvv,readValueExcel(path,sheetname,1,18));
		
		WebElement btnBook = findElementById("book_now");
		elementClick(btnBook);
		
		Thread.sleep(5000);

		WebElement lblBookingConfirm = findElementByXpath("//td[text()='Booking Confirmation ']");
		String  lblBookingConfirmText = getText(lblBookingConfirm);
		
		Assert.assertEquals("Verify BookingConfirm", "Booking Confirmation",lblBookingConfirmText );
		Thread.sleep(1000);

		WebElement txtOrderNo = findElementById("order_no");
		String OrderNum = txtOrderNo.getAttribute("value");
		System.out.println("Hotel Booked, Order Number:"+OrderNum);
		
		writeData(path,sheetname,1, 19 ,OrderNum);
		
		}
	
	}
	
