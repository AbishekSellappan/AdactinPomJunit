package com.pages;

import org.openqa.selenium.WebElement ;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookHotelPage extends BaseClass {
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	private WebElement txtFirstName;
	
	@FindBy(id="last_name")
	private WebElement txtLastName;
	
	@FindBy(id="address")
	private WebElement txtAddress;
	
	@FindBy(id="cc_num")
	private WebElement txtCreditCardNo;
	
	@FindBy(id="cc_type")
	private WebElement dDnCcType;

	@FindBy(id="cc_exp_month")
	private WebElement dDnExpMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement dDnExpYear;
	
	@FindBy(id="cc_cvv")
	private WebElement txtCvv;
	
	@FindBy(id="book_now")
	private WebElement btnBook;
	
	
	
	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCreditCardNo() {
		return txtCreditCardNo;
	}

	public WebElement getdDnCcType() {
		return dDnCcType;
	}
	
	public WebElement getdDnExpMonth() {
		return dDnExpMonth;
	}

	public WebElement getdDnExpYear() {
		return dDnExpYear;
	}
	
	public WebElement getTxtCvv() {
		return txtCvv;
	}
	
	public WebElement getBtnBook() {
		return btnBook;
	}


	
	
	public void bookHotel(String firstName, String lastName, String address, 
			String ccNum, String ccType, String ccExpMonth, String ccExpYear, String ccv) {
		
	elementSendKeys(getTxtFirstName(),firstName);
	elementSendKeys(getTxtLastName(),lastName);
	elementSendKeys(getTxtAddress(),address);
	
	elementSendKeys(getTxtCreditCardNo(),ccNum);
	selectOptionByText(getdDnCcType(),ccType);
	selectOptionByText(getdDnExpMonth(),ccExpMonth);
	selectOptionByText(getdDnExpYear(),ccExpYear);
	elementSendKeys(getTxtCvv(),ccv);
	
	elementClick(getBtnBook());
	}
	
}
