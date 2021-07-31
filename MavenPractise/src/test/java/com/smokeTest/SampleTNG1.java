package com.smokeTest;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SampleTNG1
{
	@Test (priority=3)
	public void SampleTest1() throws InterruptedException
	{
System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://WWW.byjus.com");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
        WebElement statedrop =driver.findElement(By.name("state"));
        
        Select state = new Select(statedrop);
        
        List<WebElement> li = state.getOptions();
        
        System.out.println(li.size());
        
        for (int i=0; i<li.size(); i++)
        {
        	li.get(i).click();
        	System.out.println(li.get(i).getText());
        }
    driver.close();
	}

@Test (priority=1)
public void SampleTest2() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver(); //run Time Polymorphsim
	
	driver.get("https://www.amazon.co.uk");
	
	driver.manage().window().maximize();
	driver.findElement(By.id("sp-cc-accept")).click();
	Thread.sleep(1000);
	WebElement Alldropdown=	driver.findElement(By.id("searchDropdownBox"));
	
	Select choose = new Select(Alldropdown);
	choose.selectByVisibleText("Clothing");
	Thread.sleep(2000);
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Winter Jackets");
	Thread.sleep(1000);
	System.out.println("Complete the priority 1 -SampleTest2");
	driver.close();
}
@Test (priority=2)
public void SampleTest3() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	
	driver.get("http://demo.guru99.com/test/delete_customer.php");
	
	driver.manage().window().maximize();
	driver.findElement(By.name("cusid")).sendKeys("12345");
	Thread.sleep(3000);
	driver.findElement(By.name("submit")).click();
	Thread.sleep(2000);
	
	Alert alrt = driver.switchTo().alert();
	Thread.sleep(2000);
	String alrtmsg1 = alrt.getText();
	System.out.println(alrtmsg1);
	alrt.accept();
	String altrtmsg2=alrt.getText();
	System.out.println(altrtmsg2);
	Thread.sleep(1000);
	alrt.accept();
	driver.findElement(By.name("cusid")).sendKeys("67891");
	Thread.sleep(3000);
	driver.findElement(By.name("submit")).click();
	Thread.sleep(2000);
	String alrtmsg3 = alrt.getText();
	System.out.println(alrtmsg3);
	alrt.dismiss();
	Thread.sleep(5000);
	driver.findElement(By.name("res")).click();
	driver.close();
}
}
