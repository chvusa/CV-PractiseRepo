package practise1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OnlineShopConctact {

	@Test
	public void contact() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("contact-link")).click();
		WebElement SubjectHeading = driver.findElement(By.id("id_contact"));
		Select reasons = new Select(SubjectHeading);
		reasons.selectByVisibleText("Customer service");
	
		List<WebElement> sbh = reasons.getOptions();
		System.out.println(sbh.size());
		for (int cnt = 0; cnt <sbh.size(); cnt++)
		{
			System.out.println(sbh.get(cnt).getText());
		}
		
		System.out.println("Print option successfully");
		driver.findElement(By.id("email")).sendKeys("chakri.vusa@gmail.com");
		driver.findElement(By.id("id_order")).sendKeys("chakri1234");
		driver.findElement(By.id("message")).sendKeys("Would like to contact on my order reference");
		driver.findElement(By.xpath("//span[text()='Send']")).click();
		System.out.println("successfully sent message to customer care");
		driver.close();
	}

}
