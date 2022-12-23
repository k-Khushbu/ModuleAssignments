/*
 * Assignment -2.1(Frames):
- https://demo.guru99.com/test/delete_customer.php
- Click on the frame shown in the image
 */
package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.switchTo().frame("");
		//driver.findElement(By.id("")).click();
		driver.findElement(By.name("cusid")).sendKeys("1176");
		driver.findElement(By.name("submit")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
	}

}
