package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotelPage extends BaseClass {

	public SearchHotelPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement dDnLocation;
	
	@FindBy(id="hotels")
	private WebElement dDnHotels;
	
	@FindBy(id="room_type")
	private WebElement dDnRoom;
	
	@FindBy(id="room_nos")
	private WebElement dDnNoOfRooms;
	
	@FindBy(id="datepick_in")
	private WebElement txtInDatePick;
	
	@FindBy(id="datepick_out")
	private WebElement txtOutDatePick;
	
	@FindBy(id="adult_room")
	private WebElement dDnAdultPerRoom;

	@FindBy(id="child_room")
	private WebElement dDnChildPerRoom;
	
	@FindBy(id="Submit")
	private WebElement btnSubmit;

	
	
	
	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotels() {
		return dDnHotels;
	}

	public WebElement getdDnRoom() {
		return dDnRoom;
	}

	public WebElement getdDnNoOfRooms() {
		return dDnNoOfRooms;
	}

	public WebElement getTxtInDatePick() {
		return txtInDatePick;
	}

	public WebElement getTxtOutDatePick() {
		return txtOutDatePick;
	}

	public WebElement getdDnAdultPerRoom() {
		return dDnAdultPerRoom;
	}

	public WebElement getdDnChildPerRoom() {
		return dDnChildPerRoom;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	
	
	public void searchHotels(String location, String hotel, String roomType, String roomNo,
			String dateIn, String dateOut, String adultPerRoom, String childPerRoom ){
		
		selectOptionByText(getdDnLocation(),location);
		selectOptionByText(getdDnHotels(),hotel);
		selectOptionByText(getdDnRoom(),roomType);
		selectOptionByText(getdDnNoOfRooms(),roomNo);
		
		elementClear(getTxtInDatePick());
		elementSendKeys(getTxtInDatePick(), dateIn);
		
		elementClear(getTxtOutDatePick());
		elementSendKeys(getTxtOutDatePick(), dateOut);

		selectOptionByText(getdDnAdultPerRoom(),adultPerRoom);
		selectOptionByText(getdDnChildPerRoom(),childPerRoom);

		elementClick(getBtnSubmit());

	}

	
}

	

	
