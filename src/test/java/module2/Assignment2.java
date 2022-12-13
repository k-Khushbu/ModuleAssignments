/*
 * Assignment -2(Handling Alerts, Frames, Windows):
- https://demo.guru99.com/test/delete_customer.php
- Enter customer Id
- Click on Submit
- One prompt will open click on ok
- Again open one prompt click on ok
Reference site : https://www.guru99.com/alert-popup-handling-selenium.html
 */
package module2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.name("cusid")).sendKeys("custxyz123");
		driver.findElement(By.name("submit")).click();
		Alert al = driver.switchTo().alert();
		al.accept();
		Alert all = driver.switchTo().alert();
		all.accept();
		
		driver.quit();
	}

}
