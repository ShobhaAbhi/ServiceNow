package serviceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewProposal {

	public static void main(String[] args) {
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
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("My Proposals");
		shadow.findElementByXPath("//mark[text()='My Proposals']").click();
		//4.Click- new  and  fill mandatory fields and click 'Submit' Button. 
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
		/* switch to the frame */
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys("Template Description");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//	5. Verify the successful creation of new Proposal"*/
		String verify = shadow.findElementByXPath("//td[text()='Template Description']").getText();

		if(verify.equals("Template Description")) {
			System.out.println("successful creation of new Proposal");
		}
		
		else {
			System.out.println("not successfully created of new Proposal");
		}


	}

}
