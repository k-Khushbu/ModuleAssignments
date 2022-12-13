/*
 * Assignment -1(TestNG):
- url : https://demo.guru99.com/test/login.html
- Using TestNG Annotaions to complete this assignment
- In Before test annotation must have the initialize the drivers
- In Test annotation we have to enter the username and password
- In After annotation must have the close() to close the application
 */
package module3;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	WebDriver driver;
	@BeforeMethod
	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/login.html");
	}
	
	@Test
	public void login() {
		driver.findElement(By.id("email")).sendKeys("email@xyz.com");
		driver.findElement(By.id("passwd")).sendKeys("emailxyz123");
		driver.findElement(By.id("SubmitLogin")).click();
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
}
