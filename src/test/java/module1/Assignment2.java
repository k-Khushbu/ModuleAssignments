/*
 * Assignment -2(Locators working with WebElements)
- URL (https://demo.guru99.com/test/radio.html
- Find Option 1 and select
- Find Checkbox2 and Checkbox3 and select
- Suggested site(https://demo.guru99.com/test/newtours/register.php)
- Find Country Dropdown
- Select “KUWAIT”
 */

package module1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/radio.html");
		driver.findElement(By.id("vfb-7-1")).click();
		driver.findElement(By.id("vfb-6-1")).click();
		driver.findElement(By.id("vfb-6-2")).click();
		
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement dropdown = driver.findElement(By.name("country"));
		Select sc = new Select(dropdown);
		sc.selectByValue("KUWAIT");
		//driver.quit();
	}

}
