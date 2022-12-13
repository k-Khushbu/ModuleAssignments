/*
 * Assignment -1(WebTable):
- url : https://demo.guru99.com/test/web-table-element.php
- Retrieve the all company names from the table
- And display in console
- url : https://demo.guru99.com/test/login.html
- Enter email
- Enter password
- Click on Login button
 */
package module2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		List<WebElement> list = driver.findElements(By.xpath("//*[@class=\"dataTable\"]/tbody/tr/td[1]"));
		System.out.println("List of Company Names: ");
		for(int i=0;i<list.size();i++) {
			WebElement wb = list.get(i);
			String companyName = wb.getText();
			System.out.println(companyName);
		}
		
		driver.get("https://demo.guru99.com/test/login.html");
		driver.findElement(By.id("email")).sendKeys("email@xyz.com");
		driver.findElement(By.id("passwd")).sendKeys("email123");
		driver.findElement(By.id("SubmitLogin")).click();
		
		driver.quit();
	}

}
