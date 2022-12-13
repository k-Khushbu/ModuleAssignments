/*
 * Reference site : https://www.guru99.com/handling-iframes-selenium.html
Assignment -2.2(Windows):
- url : http://demo.guru99.com/popup.php
- Click on Click here
- It will go to next window. Then enter Email Id
- Click on Submit
 */
package module2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/popup.php");
		String parentWindownId = driver.getWindowHandle();
		
		driver.findElement(By.xpath(".//a[contains(text(),'Click Here')]")).click();
		
		Set<String> allIds = driver.getWindowHandles();
		String childWindowId = null;
		for (String id : allIds) {
			if(id.equals(parentWindownId)) {
				
			} else {
				childWindowId = id;
			}
		}
		
		driver.switchTo().window(childWindowId);
		
		driver.findElement(By.name("emailid")).sendKeys("email@xyz.com");
		driver.findElement(By.name("btnLogin")).click();
		driver.quit();

	}

}
