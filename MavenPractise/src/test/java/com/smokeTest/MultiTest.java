package com.smokeTest;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiTest {

	WebDriver driver;

	@BeforeMethod
	public void Initalization() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver(); // run Time Polymorphsim

		driver.get("https://www.amazon.co.uk");

		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void SelectDropDown() throws InterruptedException {

		WebElement seldropdown = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(seldropdown);

		sel.selectByIndex(4); // Least Option

		Thread.sleep(2000);

		sel.selectByValue("search-alias=beauty"); // medium priority

		Thread.sleep(2000);

		sel.selectByVisibleText("Clothing"); // high priority

	}

	@Test(priority = 2)
	public void AdvanceDropDown() {

		WebElement seldropdown = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(seldropdown);

		List<WebElement> li = sel.getOptions();

		System.out.println(li.size());

		for (int i = 0; i < li.size(); i++) // 0
		{

			li.get(i).click();
			System.out.println(li.get(i).getText());//
		}

	}

	@AfterMethod
	public void cleanUp() {
		driver.close();
	}

}
