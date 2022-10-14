package serviceNow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Knowledge {

	public static void main(String[] args) throws InterruptedException {
		//1. Launch ServiceNow application
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//1 Launch ServiceNow application
		driver.get("https://dev139926.service-now.com/navpage.do");
		driver.manage().window().maximize();
		//2. Login with valid credentials username and password
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("ar+I@UkIqFT00omY");
		driver.findElement(By.xpath("//button[@id=\"sysverb_login\"]")).click();
		//3. Click All and Enter Proposal in filter navigator and press enter 
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();
	
		//3. Enter Knowledge  in filter navigator and press enter
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge");
		shadow.findElementByXPath("//span[text()='Knowledge']").click();
		//4. Create new Article 
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
		/* switch to the frame */
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//span[text()='Create an Article']")).click();
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
		//5.Select knowledge base as IT and category as IT- java and Click Ok
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String>lstWindow1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(lstWindow1.get(1));
		driver.findElement(By.xpath("//a[text()='IT']")).click();
		driver.switchTo().window(lstWindow1.get(0));
		System.out.println(driver.getTitle());
	
		driver.switchTo().defaultContent();
		//6.Update the other mandatory fields
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("Short Description");	
		//7.Select the submit option
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
	
		
	
		
		

		
		
	}
	
	

}
