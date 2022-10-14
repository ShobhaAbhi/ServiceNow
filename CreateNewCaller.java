package serviceNow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewCaller {

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
				shadow.findElementByXPath("//input[@id='filter']").sendKeys("Callers");
				shadow.findElementByXPath("//mark[text()='Callers']").click();
				shadow.setImplicitWait(10);
				//4.Click- new  and  fill mandatory fields and click 'Submit' Button. 
				WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
				/* switch to the frame */
				driver.switchTo().frame(eleFrame);
				driver.findElement(By.xpath("//button[text()='New']")).click();
				//First name
				driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("shobha");
				//Last name
				driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("Patil");
				//Title
				driver.findElement(By.xpath("//span[@class='icon icon-lightbulb']")).click();
				Set<String> windowHandles1 = driver.getWindowHandles();
				List<String>lstWindow1=new ArrayList<String>(windowHandles1);
				driver.switchTo().window(lstWindow1.get(1));
				//Print window title
				System.out.println(driver.getTitle());
				//Select Title
				driver.findElement(By.xpath("//tr[@sys_id='848f0e20f90211108c8bd16244dfe728']//a[1]")).click();
				Thread.sleep(2000);
			
				driver.switchTo().window(lstWindow1.get(0));
				System.out.println(driver.getTitle());
			
				/*//Email
				//driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("shobhashivakumarkittada@gmail.com");
				//Business ph
				driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys("1234567890");
				//Mobile Ph
				driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys("9164260329");
				*/
				driver.findElement(By.xpath("//button[text()='Submit']")).click();
				
			
				String Verify = driver.findElement(By.xpath("\"//div[@class='outputmsg_text']\"")).getText();
				
				if (Verify.contains("Shobha")) {
					System.out.println(Verify);
					
				}
				else
				{
					System.out.println("New Caller not created");
				}
	  
	}
 
}
