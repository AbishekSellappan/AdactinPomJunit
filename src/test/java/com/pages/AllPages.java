package com.pages;

import java.io.IOException;

import com.base.BaseClass;

public class AllPages extends BaseClass {
	
	

	public static void main(String[] args) throws IOException, InterruptedException {
		getDriver();
		
		enterUrl("https://adactinhotelapp.com/");
		
		maximize();
		
		String path="C:\\Users\\Raj\\Downloads\\workspace\\MavenDemo\\Excel Sheets\\WorksheetAdactin.xlsx";
		String sheetName="Adactin";
		
		//		System.out.println(readValueExcel(path,sheetName, 1,0));
		
		//1.Login
		LoginPage login =new LoginPage();
		login.login(readValueExcel(path,sheetName, 1,0),readValueExcel(path,sheetName, 1,1));
		
		//2.Search Hotel
		SearchHotelPage searchHotelPage = new SearchHotelPage();
		searchHotelPage.searchHotels(readValueExcel(path,sheetName, 1,2), readValueExcel(path,sheetName, 1,3), 
				readValueExcel(path,sheetName, 1,4), readValueExcel(path,sheetName, 1,5), readValueExcel(path,sheetName, 1,6),
				readValueExcel(path,sheetName, 1,7), readValueExcel(path,sheetName, 1,8), readValueExcel(path,sheetName, 1,9));
		
		//3.Select Hotel
		SelectHotelPage selectHotelPage = new SelectHotelPage();
		selectHotelPage.selectHotel();
		
		//4.Book Hotel
		BookHotelPage bookHotelPage = new BookHotelPage();
		bookHotelPage.bookHotel(readValueExcel(path,sheetName, 1,10),readValueExcel(path,sheetName, 1,11),
				readValueExcel(path,sheetName, 1,12), readValueExcel(path,sheetName, 1,13), readValueExcel(path,sheetName, 1,14),
				readValueExcel(path,sheetName, 1,15), readValueExcel(path,sheetName, 1,16), readValueExcel(path,sheetName, 1,17));
		
		Thread.sleep(5000);

		//5.Confirm Booking
		BookingConfirmPage bookingConfirmPage = new BookingConfirmPage();
		
		//Get Booking Id from ConfirmBooking
		String bookingId = bookingConfirmPage.getBookingId();
		
		Thread.sleep(3000);

		//6.Cancel Booking
		
		
		CancelBookingPage cancelBookingPage = new CancelBookingPage();
	
		//call CancelBooking method with parameter of OrderId
		cancelBookingPage.cancelBooking(bookingId);
	}

}
