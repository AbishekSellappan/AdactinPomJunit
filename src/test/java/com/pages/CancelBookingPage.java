package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CancelBookingPage extends BaseClass{
	
	
	private static String BookingId = null;


	public CancelBookingPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement bookedHotelsList;
	
	@FindBy(id="order_id_text")
	private WebElement txtsearchBox;
	
	@FindBy(id="search_hotel_id")
	private WebElement btnSearch;
	
	
	//input[@value='Cancel MH8GNG2YI1']
////
//	String xpath="'Cancel'+BookingId+'";
//	
//	
//	@FindBy(xpath="(//input[@value,'"+BookingId+"'])")
//	private WebElement checkBoxHotel;
//	
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement checkBoxHotel;
	
	
	public WebElement getTxtsearchBox() {
		return txtsearchBox;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}
	
	public WebElement getCheckBoxHotel() {
		return checkBoxHotel;
	}

	public WebElement getBookedHotels() {
		return bookedHotelsList;
	}

	
	
	public void cancelBooking(String BookingId) {
		
		elementClick(getBookedHotels());
		
		elementSendKeys(getTxtsearchBox(), BookingId);
		
		elementClick(getBtnSearch());
		
		elementClick(getCheckBoxHotel());
		
		alertOK();
		
	}


}
