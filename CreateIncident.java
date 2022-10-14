package serviceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateIncident {
	//Assignment 1:Ordering mobile
	public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			//1 Launch ServiceNow application
			driver.get("https://dev139926.service-now.com/navpage.do");
			driver.manage().window().maximize();
			//2. Login with valid credentials username and password
			driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("ar+I@UkIqFT00omY");
			driver.findElement(By.xpath("//button[@id=\"sysverb_login\"]")).click();
			//3. Click-AllEnter Service catalog in filter navigator and press enter 
			Shadow shadow = new Shadow(driver);
			shadow.setImplicitWait(30);
			shadow.findElementByXPath("//div[text()='All']").click();
			shadow.setImplicitWait(20);
			shadow.findElementByXPath("//input[@id='filter']").click();
			shadow.setImplicitWait(10);
			shadow.findElementByXPath("//span[text()='Service Catalog']").click();
			//driver.findElement(By.xpath("//span[text()='Service Catalog']")).click();
			//	4. Click on  mobiles
			shadow.setImplicitWait(30);
			/* To Locate frame inside Shadow DOM by XPath and save as WebElement*/
			WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
			/* switch to the frame */
			driver.switchTo().frame(eleFrame);
			/* Element for Mobiles catalog is visible in DOM
			* Not necessary to use shadow object to locate the same
			*/
			driver.findElement(By.linkText("Mobiles")).click();
			//5.Select Apple iphone6s
			shadow.setImplicitWait(30);
			driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
			driver.findElement(By.xpath("//label[text()='No']")).click();
			WebElement allowance  = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
			Select dropdown = new Select(allowance);
			dropdown.selectByVisibleText("500MB");
			//6.Update color field to rose gold and storage field to 128GB
			driver.findElement(By.xpath("//label[text()='Blue']")).click();
			driver.findElement(By.xpath("//label[text()='128 GB']")).click();
			//7.Select  Order now option
			driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
			//order confimation message
			WebElement order = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']"));
			System.out.println("order confimation message" +order);
			//8.Verify order is placed and copy the request number
			String requestNumber = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
			System.out.println("The Request number of mobile order is " +requestNumber);
			
			
			

	}

}
