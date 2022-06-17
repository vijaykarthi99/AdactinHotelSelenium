package com.hotel;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinHotel {
	static WebDriver driver;
	Robot robot;

	@BeforeClass
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//	@Test
//	public void browserLaunch() throws IOException {
		// TakesScreenshot src = (TakesScreenshot) driver;
		// File s = src.getScreenshotAs(OutputType.FILE);
		// File d =new File
		// ("D:\\JavaClassProjectsEclipse\\AdactinHotelSelenium\\pic\\1.png");
		// FileUtils.copyFile(s, d);
//		Date t = new Date();
//		System.out.println("Before :" + t);
		// WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver();
		// driver.get("http://adactinhotelapp.com/");
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	}
	@After
	public void screenshot() throws IOException {
		 TakesScreenshot screen = (TakesScreenshot) driver;
				 File s = screen.getScreenshotAs(OutputType.FILE);
				 File d = new
				 File("D:\\JavaClassProjectsEclipse\\AdactinHotelSelenium\\pic\\hotel1.png");
				 FileUtils.copyFileToDirectory(s, d);

	}

	@Before
	public void date(){

		Date t = new Date();
		System.out.println("Before " + t);
		
		

	}

	@Test
	public void tc01() {
		driver.findElement(By.id("username")).sendKeys("vijaymaniG");
		driver.findElement(By.id("password")).sendKeys("Y5QELK");
		driver.findElement(By.id("login")).click();

	}

	@Test
	public void tc02() {

		WebElement location = driver.findElement(By.id("location"));
		Select select = new Select(location);
		select.selectByVisibleText("London");
		WebElement hotel = driver.findElement(By.id("hotels"));
		Select s2 = new Select(hotel);
		s2.selectByVisibleText("Hotel Sunshine");
		WebElement roomtype = driver.findElement(By.id("room_type"));
		Select s3 = new Select(roomtype);
		s3.selectByVisibleText("Standard");
		WebElement roomnos = driver.findElement(By.id("room_nos"));
		Select s4 = new Select(roomnos);
		s4.selectByValue("4");
		driver.findElement(By.id("datepick_in")).sendKeys("05/05/2022");
		driver.findElement(By.id("datepick_out")).sendKeys("06/05/2022");
		WebElement adultroom = driver.findElement(By.id("adult_room"));
		Select s5 = new Select(adultroom);
		s5.selectByValue("2");
		WebElement childroom = driver.findElement(By.id("child_room"));
		Select s6 = new Select(childroom);
		s6.selectByValue("2");
		driver.findElement(By.id("Submit")).click();
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
	}

	@Test
	public void tc03() {

		driver.findElement(By.id("first_name")).sendKeys("vj");
		driver.findElement(By.id("last_name")).sendKeys("mani");
		driver.findElement(By.id("address")).sendKeys("xxx,yyyy");
		driver.findElement(By.id("cc_num")).sendKeys("5478983456780001");
		WebElement cctype = driver.findElement(By.id("cc_type"));
		Select s7 = new Select(cctype);
		s7.selectByValue("MAST");
		WebElement ccexpmonth = driver.findElement(By.id("cc_exp_month"));
		Select s8 = new Select(ccexpmonth);
		s8.selectByValue("5");
		WebElement ccexpyear = driver.findElement(By.id("cc_exp_year"));
		Select s9 = new Select(ccexpyear);
		s9.selectByValue("2015");
		driver.findElement(By.id("cc_cvv")).sendKeys("678");
		driver.findElement(By.id("book_now")).click();

	}

	@Test
	public void tc04() throws AWTException {
		driver.findElement(By.id("my_itinerary")).click();
//		WebElement t = driver.findElement(By.xpath("//td[@bgcolor='#FFFFFF']//following::input[@class='select_text']"));
		WebElement t1 =driver.findElement(By.xpath("//td[@bgcolor='#CCCCCC']//following::strong[text()='Order Id ']"));
//		driver.findElement(By.id("order_id_text")).sendKeys("orderid");
//		robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	@Test
	public void tc05() {
		driver.findElement(By.id("btn_id_605965")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
