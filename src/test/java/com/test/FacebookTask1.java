package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookTask1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		WebElement emailTxt = driver.findElement(By.id("email"));
		emailTxt.sendKeys("Kamal@gmail.com");
		
		WebElement passTxt = driver.findElement(By.id("pass"));
		passTxt.sendKeys("Pass@123");
		
		WebElement btnLogin = driver.findElement(By.name("login"));
		btnLogin.click();

	}

}
