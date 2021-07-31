package practise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OnlineShopping {

	WebDriver driver;
	
	Actions mouse ;

	@BeforeClass
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void Order() throws InterruptedException

	{

		WebElement key = driver.findElement(By.xpath("//a[text()='Women']"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(key).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Casual Dresses']")).click();
		Thread.sleep(2000);
		WebElement img = driver.findElement(By.xpath("//div[@class='product-image-container']"));
		mouse.moveToElement(img).perform();
		driver.findElement(By.className("quick-view")).click();
		Thread.sleep(10000);
		// driver.switchTo().frame("fancybox-frame1625598892200");
		driver.switchTo().frame(0);
		System.out.println("successful switched to iframe");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
		System.out.println("Add quantity as 2");
		driver.findElement(By.xpath("(//span[text()='Add to cart'])[1]")).click();
		System.out.println("Add to Cart");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']")).click();
		System.out.println("proceed to check out");
		Thread.sleep(5000);
		String Total = driver.findElement(By.id("total_price")).getText();
		System.out.println(Total);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']")).click();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=2)
	public void LoginPage() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("chakri.vusa@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("vusa1234");
		driver.findElement(By.id("SubmitLogin")).click();
		System.out.println("successfully logged in");
		Thread.sleep(2000);
		
		
		WebElement cart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		mouse.moveToElement(cart).perform();
		System.out.println("View the cart");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Check')]")).click();
		driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
		System.out.println("Successfully signed and view cart and continued");
		driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Adress Selected");
		Thread.sleep(2000);
		System.out.println("Address selected successfully");
		driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("cgv")).click();
		Thread.sleep(1000);
		String shipping = driver.findElement(By.xpath("//div[@class='delivery_option_price']")).getText();
		System.out.println(shipping);
	}

	

	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
}
