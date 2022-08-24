package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoDD {
	
	static List<WebElement> options;
	
	static List<WebElement> getDropDownValues(){
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		//Find and Verify Element
		WebElement dDnSkills = driver.findElement(By.id("Skills"));
		
		Select select = new Select(dDnSkills);
		
		//List<WebElement> options = select.getOptions();
		options = select.getOptions();

		System.out.println(options.size());
		
		return options;	
		
	}
	
	
	public static void main(String[] args) {
		List<WebElement> dropDownValues = getDropDownValues();
		
		for (WebElement dD : dropDownValues) {
			String attribute = dD.getAttribute("value");
			System.out.println(attribute);
		}
	}
}


