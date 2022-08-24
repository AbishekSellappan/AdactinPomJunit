package com.package_junit;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinUnitTest {
	
	static WebDriver driver;
	long startTime;
	long endTime;
	
	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}
	@AfterClass
	public static void afterClass() {
		driver.quit();
	}
	@Before
	public void before() throws InterruptedException, IOException {
		getScreenShot("C:\\Users\\Raj\\Documents\\BeforeLogin.png");
		startTime = System.currentTimeMillis()/1000;
		System.out.println(startTime);
		Thread.sleep(1000);
	}
	
	private File getScreenShot(String path) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination= new File(path);
		FileUtils.copyFile(source, destination);
		return source;
	}
	
	@After
	public void after() throws IOException {
		getScreenShot("C:\\Users\\Raj\\Documents\\AfterLogin.png");
		endTime = System.currentTimeMillis()/1000;
		System.out.println(endTime);
		long timeTaken=endTime-startTime;
		System.out.println("Time take to Login :"+timeTaken+"");
		
	}
	@Test
	public void login() throws InterruptedException {
		
		System.out.println("strat ...");
		String userName = "Greens8767";
	
		WebElement id = driver.findElement(By.id("username"));
		id.sendKeys(userName);
		String attribute = id.getAttribute("value");
		
		Assert.assertEquals("verify userName", "Greens8767", attribute);;
		
		Assert.assertTrue("verify userName ", true);
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("QN8V3A");
		
		Assert.assertTrue("verify password ", true);

		WebElement btnLogin =driver.findElement(By.id("login"));
		btnLogin.click();
	
		Assert.assertTrue("verify btnLogin ", true);
		System.out.println("end ...");
		Thread.sleep(3000);
		
	}

}
